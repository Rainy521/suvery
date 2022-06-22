package com.lwch.survey.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import com.google.common.io.Files;

public class DownloadUtils {
    public static void download(String fileName, byte[] data, HttpServletResponse response) throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            fileName = URLDecoder.decode(fileName, "ISO8859_1");
            
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream");
            //response.setContentType("image/jpeg");
            
            outputStream.write(data);
            outputStream.flush();
        }
    }
    
    public static void download(File localFile, HttpServletResponse response) throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            String fileName = URLEncoder.encode(localFile.getName(), "UTF-8");
            fileName = URLDecoder.decode(fileName, "ISO8859_1");
            
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.addHeader("Content-Length", "" + localFile.length());
            response.setContentType("application/octet-stream;charset=UTF-8");
            
            Files.copy(localFile, outputStream);
            
            outputStream.flush();
        }
    }
}
