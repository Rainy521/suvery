package com.lwch.survey.service;
import java.util.List;

import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.model.ApplyAptitudeExample;
import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.pojo.PageParm;

public interface ApplyAptitudeService {
    
    /**
     * 查询公司基本信息展示
     * @param companyExample
     * @param query
     * @param pageParm
     * @return  List<ApplyAptitude>
     */
    List<ApplyAptitude> selectByExample(ApplyAptitudeExample applyAptitudeExample, String query,int applyStatus,
            String currentUsername,PageParm pageParm);
    
    /**
     * 公司信息数量
     * @param query 页面传递查询参数
     * @return long
     */
    long getCount(String username , String query ,int applyStatus);
    
    /**
     * 新增公司信息
     * @param company
     * @param username
     * @return  long
     */
    long insertApplyAptitude(ApplyAptitude applyAptitude , String username);
    
    /**
     * 修改公司信息
     * @param company 设备对象
     */
    void updateApplyAptitude(ApplyAptitude applyAptitude);
    
    /**
     * 删除设备信息
     * @param id ID
     */
    void deleteApplyAptitude(String id);
    
    /**
     * 根据申请主键得到信息
     * @param id
     * @return  Company
     */
    ApplyAptitude selectPrimaryKey(String id);
    
    /**
     * 得到公司下的所有用户
     * @param bsname
     * @return  List<String>
     */
    List<AptitudeUsersMember> selectUsers(String bsname);



    /**
     * 查询所有公司员工
     * @return  List<String>
     */
    List<String> selectAllUsersCompanys();


    /**
     * 初始流程状态设置
     */
    static final String PROCESS_INIT_STATUS = "0";
    
    /**
     * 结束流程状态默认
     */
    static final String PROCESS_END_STATUS = "3";
    
    /**
     * 已办理查看的formkey设置
     */
    static final String APTITUDE_FORMKEY = "aptitude/applyinfo.html";

}
