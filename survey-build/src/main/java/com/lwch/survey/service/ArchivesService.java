package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.Archive;
import com.lwch.survey.model.ArchiveExample;

public interface ArchivesService {
    
    public List<Archive> getArchives(ArchiveExample archiveExample, String query);

    /**
     * 新增归档管理任务
     * @param archive  void
     */
    public void insertManage(Archive archive);

    /**
     * 更新归档信息
     * @param archive  void
     */
    public void updateManage(Archive archive);

    /**
     * 查询归档的盒子
     * @param archiveExample
     * @return  List<Archive>
     */
    public List<Archive> getAllArchives(ArchiveExample archiveExample);
    
    /**
     * 根据id查询是否存在
     * @param id
     * @return  boolean
     */
    public boolean selectId (String id);

}
