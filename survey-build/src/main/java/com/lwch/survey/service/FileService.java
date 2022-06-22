package com.lwch.survey.service;

import com.lwch.survey.model.File;

public interface FileService {
    /**
     * 新增文件
     * @param file 文件对象
     * @return int
     */
    int insertFile(File file);
    
    /**
     * 根据主键id查找文件
     * @param id 文件编号
     * @return File 文件对象
     */
    File selectByPrimaryKey(String id);
    
    /**
     * 根据文件名获取文件
     * 
     * @param name 文件名
     * @return
     */
    File selectByFileName(String name);
    
    /** 截取字符串开始 */
    static final String SUBFILENAME_START = "_";
    /** 截取字符串结束 */
    static final String SUBFILENAME_END = ".";
}
