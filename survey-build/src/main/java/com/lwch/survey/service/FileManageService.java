package com.lwch.survey.service;
import java.util.List;
import java.util.Map;

import com.lwch.survey.model.FileManage;
import com.lwch.survey.model.FileManageExample;
import com.lwch.survey.model.FileManageMember;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;

public interface FileManageService {
    
    List<FileManage> selectByExample(FileManageExample fileManageExample,String query,PageParm pageParm);
    
    long getCount(String query);
    
    long insertFileManage(FileManage fileManage );
    
    void updateFileManage(FileManage fileManage);
    
    void deleteFileManage(Integer id);

    FileManage selectPrimaryKey(Integer id);

    List<FileManageMember> selectByfileId(Integer id);

    void insertBusiness(Integer id, List<String> bus);

    Map<String, String> getbusIds();

    void deleteBusiness(Integer id, String name);

    ResponseObject queryByBusinessId(String businessId, PageParm pageParm);

	void inserFileManages(String businessId, List<Integer> ids);
    
}
