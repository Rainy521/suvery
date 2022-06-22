package com.lwch.survey.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.Ownership;
import com.lwch.survey.model.OwnershipExample;
import com.lwch.survey.pojo.PageParm;

public interface HouseService {
    
    /**
     * 根据申请主键得到信息
     * @param id
     * @return  Company
     */
    Ownership selectPrimaryKey(String id);
    
    /**
     * 查询全部申请
     * @return  List<Ownership>
     */
    List<Ownership> selectAllHouse();

    /**
     * 查询在线申请
     * @param ownershipExample
     * @param query
     * @param pageParm
     * @return  List<Ownership>
     */
    List<Ownership> selectByExample(OwnershipExample ownershipExample, Map<String, String> map, PageParm pageParm);

    /**
     * 查询申请数量
     * @param query
     * @return  long
     */
    long getCount(Map<String, String> map);

    /**
     * 修改房屋信息
     * @param ownership  void
     */
    void updateHouses(Ownership ownership);

    /**
     * 新增房屋信息
     * @param ownership  void
     */
    void insertHouses(Ownership ownership ,String username);

    /**
     * 删除房屋信息
     * @param id  void
     */
    void deleteHouses(String id);

    /**
     * 
     * 新增file，filetype，applyid关联
     * @param fileTypeApplyMember  void
     */
    void insertFileMenber(FileTypeApplyMember fileTypeApplyMember);

    /**
     * 得到file_id,filemanage集合
     * @param applyid
     * @return  Map<String,String>
     */
    TreeMap<Integer, List<FileTypeApplyMember>> getFileIds(String applyid);
    
    /**
     * 查询报表
     * @param params
     * @return  List<Ownership>
     */
    List<Ownership> selectByExampleFrom(Long startTime, Long endTime, String...condition);
    
    /**
     * 初始流程状态设置
     */
    static final String PROCESS_INIT_STATUS = "0";
    
    /**
     * 结束流程状态默认
     */
    static final String PROCESS_END_STATUS = "3";
    
    /**
     * 已办理业务查看
     */
    static final String HOUSES_FORMKEY = "stockroom/applyinfo.html";


}
