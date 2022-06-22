package com.lwch.survey.service;
import java.io.File;
import java.util.List;
import java.util.Map;

import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.ApplyProjectExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.pojo.StatisticsInfo;
import com.lwch.survey.pojo.StatisticsParam;

public interface CommodityHouseService {
    
    /**
     * 查询项目信息展示
     * @param companyExample
     * @param query
     * @param pageParm
     * @return  List<ApplyAptitude>
     */
    List<ApplyProject> selectByExample(ApplyProjectExample applyProjectExample,String query,String username ,PageParm pageParm);
    
    /**
     * 项目信息数量
     * @param query 页面传递查询参数
     * @return long
     */
    long getCount(String query,String username);
    
    /**
     * 新增公司信息
     * @param company
     * @param username
     * @return  long
     */
    ResponseObject insertApplyProject(ApplyProject applyProject , String username);
    
    /**
     * 修改公司信息
     * @param company 设备对象
     * @return 
     */
    ResponseObject updateApplyProject(ApplyProject applyProject,String username);
    
    /**
     * 删除设备信息
     * @param id ID
     */
    void deleteApplyProject(String id);
    
    /**
     * 根据申请主键得到信息
     * @param id
     * @return  Company
     */
    ApplyProject selectPrimaryKey(String id);
    
    /**
     * 根据申请主键得到房屋总信息
     * @param id
     * @return  Company
     */
    ApplyProject selectByExcelInfo(String id);
    
    /**
     * 报表查看
     * @param params
     * @return  List<ApplyProject>
     */
    List<ApplyProject> selectByExampleFrom(Map<String, String> params);
    
    /**
     * 查看结果报表
     * @param applyProjectExample
     * @param query
     * @param currentUsername
     * @param type 
     * @param pageParm
     * @return
     */
    List<ApplyProject> selectPoolByExample(ApplyProjectExample applyProjectExample, String query,
    		String type,String currentUsername,  PageParm pageParm);
    
    /**
     * 得到汇总数量
     * @param query
     * @param type
     * @return
     */
    long getPoolCount(String query, String type);
    
    /**
     * 解压缩
     * @param f
     */
    Map<String, String> unZipSave(File f, String currentUsername) ;
    
    /**
     * 得到统计图标数据
     * @param param
     * @param pageParm
     * @return
     */
    List<StatisticsInfo> getStatisticaltables(StatisticsParam param, PageParm pageParm);
    
    /**
     * 得到数据数量
     * @param type
     * @return
     */
    long getTablesCount(StatisticsParam param);
    
    /**
     * 饼图统计
     * @return
     */
    Map<String, ResponseObject> statisticalPie(String chlx);

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
    static final String COMMDODITY_FORMKEY = "commercial/applyinfo.html";
    
    /**
     * 系统临时路径
     */
    static final String SYS_PATH = System.getProperty("java.io.tmpdir");
    
    /**
     * 压缩文件
     */
    static final String IMPORT_EXECL = "import.execl.commercial";
    
    /**
     * 压缩文件,xlsx文件标识
     */
    static final String IMPORT_XLSX_NAME = IMPORT_EXECL + ".xlsxName";
    
    /** 其他文件:施工图 */
    static final String IMPORT_SGT = "import.execl.sgt";
    /** 其他文件:房产测绘合同 */
    static final String IMPORT_FCCHHT = "import.execl.fcchht";
    /** 其他文件:建设工程规划许可证 */
    static final String IMPORT_JSGCGHXKZ = "import.execl.jsgcghxkz";
    /** 其他文件:不动产权证 */
    static final String IMPORT_BDCQZ = "import.execl.bdcqz";
    /** 其他文件:房产测绘成果报告 */
    static final String IMPORT_SIFF = "import.execl.siff";
    /**
     * 文件返回状态 0:成功
     */
    static final Integer UNLOAD_FILE_SUCCESS = 0;
    /**
     * 文件返回状态 3失败
     */
    static final Integer UNLOAD_FILE_FAIL = 3;
    /** 108-房产测绘成果报告 */
    static final String SIFF_CODE = "108-房产测绘成果报告";
    /** siff */
    static final String SIFF_BOOLEAN = "siff";
    
    /** 1月 */
    static final String MONTH_1 = "01";
    /** 2月 */
    static final String MONTH_2 = "02";
    /** 3月 */
    static final String MONTH_3 = "03";
    /** 4月 */
    static final String MONTH_4 = "04";
    /** 5月 */
    static final String MONTH_5 = "05";
    /** 6月 */
    static final String MONTH_6 = "06";
    /** 7月 */
    static final String MONTH_7 = "07";
    /** 8月 */
    static final String MONTH_8 = "08";
    /** 9月 */
    static final String MONTH_9 = "09";
    
    /** 月度 */
    static final String STATISTICAL_TYPE_MONTH = "月度";
    /** 年度 */
    static final String STATISTICAL_TYPE_YEAR = "年度";
    /** 季度 */
    static final String STATISTICAL_TYPE_QUARTER = "季度";
    /** 建设单位 */
    static final String STATISTICAL_TYPE_JSDW = "建设单位";
    /** 受理单位 */
    static final String STATISTICAL_TYPE_SLDW = "受理单位";

}
