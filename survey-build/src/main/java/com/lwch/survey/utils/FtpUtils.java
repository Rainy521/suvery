/**
 * 
 */
package com.lwch.survey.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FtpUtils {

    /** 日志对象 **/
    private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtils.class);
 
    /** FTP地址 **/
    private static final String FTP_ADDRESS = "192.168.192.12";
 
    /** FTP端口 **/
    private static final int FTP_PORT = 21;
 
    /** FTP用户名 **/
    private static final String FTP_USERNAME = "admin";
 
    /** FTP密码 **/
    private static final String FTP_PASSWORD = "admin";
 
    /** FTP基础目录 **/
    private static final String BASE_PATH = "SurveyImage/";
    
    /** 本地字符编码  **/
    private static String localCharset = "GBK";
    
    /** FTP协议里面，规定文件名编码为iso-8859-1 **/
    private static String serverCharset = "ISO-8859-1";
    
    /** UTF-8字符编码 **/
    private static final String CHARSET_UTF8 = "UTF-8";
    
    /** OPTS UTF8字符串常量 **/
    private static final String OPTS_UTF8 = "OPTS UTF8";
    
    /** 设置缓冲区大小4M **/
    private static final int BUFFER_SIZE = 1024 * 1024 * 4;
    
    /** FTPClient对象 **/
    private static FTPClient ftpClient = null;
    
    /**
     * 获取该目录下所有文件,以字节数组返回
     * 
     * @param ftpPath FTP服务器上文件所在相对路径，例如：test/123
     * @return Map<String, Object> 其中key为文件名，value为字节数组对象
     */
    public static Map<String, byte[]> getFileBytes(String ftpPath) {
        // 登录
        login(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD);
        Map<String, byte[]> map = new HashMap<>();
        if (ftpClient != null) {
            try {
                String path = changeEncoding(BASE_PATH + ftpPath);
                // 判断是否存在该目录
                if (!ftpClient.changeWorkingDirectory(path)) {
                    LOGGER.error(BASE_PATH + ftpPath + "该目录不存在");
                    return map;
                }
                ftpClient.enterLocalPassiveMode();  // 设置被动模式，开通一个端口来传输数据
                FTPFile[] files = ftpClient.listFiles();
                // 判断该目录下是否有文件
                if (files == null || files.length == 0) {
                    LOGGER.error(BASE_PATH + ftpPath + "该目录下没有文件");
                    return map;
                }
                for (FTPFile file : files) {
                    if (file.isFile()) {
                        try (InputStream is = ftpClient.retrieveFileStream(file.getName())) {
                            String ftpName = new String(file.getName().getBytes(serverCharset), localCharset);
                            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                            byte[] buffer = new byte[BUFFER_SIZE];
                            int readLength = 0;
                            while ((readLength = is.read(buffer, 0, BUFFER_SIZE)) > 0) {
                                byteStream.write(buffer, 0, readLength);
                            }
                            map.put(ftpName, byteStream.toByteArray());
                            ftpClient.completePendingCommand(); // 处理多个文件
                        } catch (Exception e) {
                            LOGGER.error(e.getMessage(), e);
                        }
                    } else if (file.isDirectory()) {
                        // 需要加此判断。否则，ftp默认将‘项目文件所在目录之下的目录（./）’与‘项目文件所在目录向上一级目录下的目录（../）’都纳入递归，这样下去就陷入一个死循环了。需将其过滤掉。
                        if (!".".equals(file.getName()) && !"..".equals(file.getName())) {
                            getFileBytes(ftpPath + file.getName() + "/");
                        }
                    }
                }
            } catch (IOException e) {
                LOGGER.error("获取文件失败", e);
            } finally {
                closeConnect();
            }
        }
        return map;
    }
    
    /**
     * 获取该目录下所有文件,以输入流返回
     * 
     * @param ftpPath FTP服务器上文件相对路径，例如：test/123
     * @return Map<String, InputStream> 其中key为文件名，value为输入流对象
     */
    public static Map<String, InputStream> getFileInputStream(String ftpPath) {
        // 登录
        login(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD);
        Map<String, InputStream> map = new HashMap<>();
        if (ftpClient != null) {
            try {
                String path = changeEncoding(BASE_PATH + ftpPath);
                // 判断是否存在该目录
                if (!ftpClient.changeWorkingDirectory(path)) {
                    LOGGER.error(BASE_PATH + ftpPath + "该目录不存在");
                    return map;
                }
                ftpClient.enterLocalPassiveMode();  // 设置被动模式，开通一个端口来传输数据
                String[] fs = ftpClient.listNames();
                // 判断该目录下是否有文件
                if (fs == null || fs.length == 0) {
                    LOGGER.error(BASE_PATH + ftpPath + "该目录下没有文件");
                    return map;
                }
                for (String ff : fs) {
                    String ftpName = new String(ff.getBytes(serverCharset), localCharset);
                    InputStream is = ftpClient.retrieveFileStream(ff);
                    map.put(ftpName, is);
                    ftpClient.completePendingCommand(); // 处理多个文件
                }
            } catch (IOException e) {
                LOGGER.error("获取文件失败", e);
            } finally {
                closeConnect();
            }
        }
        return map;
    }
    
    /**
     * 连接FTP服务器
     * 
     * @param address  地址，如：127.0.0.1
     * @param port     端口，如：21
     * @param username 用户名，如：root
     * @param password 密码，如：root
     */
    private static void login(String address, int port, String username, String password) {
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(address, port);
            ftpClient.login(username, password);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                closeConnect();
                LOGGER.error("FTP服务器连接失败");
            }
        } catch (Exception e) {
            LOGGER.error("FTP登录失败", e);
        }
    }
    
    /**
     * 关闭FTP连接
     * 
     */
    private static void closeConnect() {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                LOGGER.error("关闭FTP连接失败", e);
            }
        }
    }
    
    /**
     * FTP服务器路径编码转换
     * 
     * @param ftpPath FTP服务器路径  
     * @return String
     */
    private static String changeEncoding(String ftpPath) {
        String directory = null;
        try {
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand(OPTS_UTF8, "ON"))) {
                localCharset = CHARSET_UTF8;
            }
            directory = new String(ftpPath.getBytes(localCharset), serverCharset);
        } catch (Exception e) {
            LOGGER.error("路径编码转换失败", e);
        }
        return directory;
    }
    
}
