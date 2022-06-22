package com.lwch.survey.service;
import java.util.List;

import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.model.Company;
import com.lwch.survey.model.CompanyExample;
import com.lwch.survey.model.CompanyHistory;
import com.lwch.survey.model.Employee;
import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.model.InstrumenttationExample;
import com.lwch.survey.pojo.PageParm;

/**
 * 
 * Client：设配测试管理service层服务接口
 * 
 * @author zhangcl
 * 
 * @since 2018-03-21
 * 
 * @version 1.0
 * 
 * 
 * */
public interface CompanyService {
    
    /**
     * 测绘公司组id
     */
    static final Long MAPPING_COMPANY_GROUP = (long) 6;
    
    /**
     * 查询公司基本信息展示
     * @param companyExample
     * @param query
     * @param pageParm
     * @return  List<Company>
     */
    List<Company> selectByExample(CompanyExample companyExample,String query,PageParm pageParm);
    
    List<Company> selectByExample(CompanyExample companyExample);
    
    /**
     * 公司信息数量
     * @param query 页面传递查询参数
     * @return long
     */
    long getCount(String query);
    
    /**
     * 新增公司信息
     * @param company
     * @param username
     * @return  long
     */
    long insertCompany(Company company , String username);
    
    /**
     * 修改公司信息
     * @param company 设备对象
     */
    void updateCompany(Company company);
    
    /**
     * 删除设备信息
     * @param id ID
     */
    void deleteCompany(String name);
    
    /**
     * 根据申请主键得到信息
     * @param id
     * @return  Company
     */
    Company selectPrimaryKey(String id);
    
    /**
     * 得到公司下的所有用户
     * @param bsname
     * @return  List<String>
     */
    List<Employee> selectUsers(String bsname);

    /**
     * 新增公司人员信息
     * @param bsName
     * @param usernames  void
     */
    void insertUsers(Employee employee);

    /**
     * 删除公司人员
     * @param bsname
     * @param username  void
     */
    void deleteUsers(String idCard);

    /**
     * 查询所有公司员工
     * @return  List<String>
     */
    List<String> selectAllUsersCompanys();

    /**
     * 新增用户资质
     * @param aptitudeUsersMember  void
     */
    void insertAptitudeUsersMember(AptitudeUsersMember aptitudeUsersMember);

    /**
     * 查询公司设备信息
     * @param instrumenttationExample
     * @param bsname
     * @param pageParm
     * @return  List<Instrumenttation>
     */
    List<Instrumenttation> selectInstrumentByExample(InstrumenttationExample instrumenttationExample, String bsname,
            PageParm pageParm);
    
    List<Instrumenttation> selectInstruments(InstrumenttationExample instrumenttationExample, String bsname);
    
    /**
     * 得到设备数量
     * @param bsname
     * @return  List<Instrumenttation>
     */
    Long getInstrumentCount(String bsname);
    
    /**
     * 通过id找到对象
     * @param id
     * @return  Instrumenttation
     */
    Instrumenttation getInstrumenttation(String id);
    
    /**
     * 修改设备信息
     * @param instrumenttation  void
     */
    void updateInstrumenttation(Instrumenttation instrumenttation);

    /**
     * 新增设备信息
     * @param instrumenttation
     * @param cname  void
     */
    void insertInstrumenttation(Instrumenttation instrumenttation, String cname);

    /**
     * 删除设备
     * @param id  void
     */
    void deleteInstruments(String bsname, String id);

    /**
     * 根据申请id找到发起用户，进行回写插入数据
     * @param company
     * @param substringAfter  void
     */
    void insertCompanyById(Company company, String substringAfter);

    /**
     * 修改用户绑定
     * @param aptitudeUsersMember  void
     */
    void updateAptitudeUsersMember(AptitudeUsersMember aptitudeUsersMember);

    /**
     * 审核新增员工
     * @param employee  void
     */
    void insertEmployee(Employee employee);

    /**
     * 根据公司名称查询相关记录（包括员工，设备）
     * @param cname
     * @return  Company
     */
    Company selectByCname(String cname);
    
    /**
     * 更新公司信息操作表
     * @param companyHistory  void
     */
    void insertCompanyHistory(CompanyHistory companyHistory);

}
