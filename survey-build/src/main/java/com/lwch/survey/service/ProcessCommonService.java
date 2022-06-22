package com.lwch.survey.service;
import java.util.List;
import java.util.Map;

import com.lwch.survey.model.ProcessStatus;



/**
 * 
 * Client：运营管理企业信息service层服务接口
 * 
 * @author zhangcl
 * 
 * @since 2017-11-13
 * 
 * @version 1.0
 * 
 * 
 * */
public interface ProcessCommonService {
    
    /**
     * 根据业务id，得到流程状态信息
     * @param id 业务ID
     * @return ProcessStatus 业务状态对象
     */
    ProcessStatus statusByid(String id);
    
    /**
     * 查询满足的业务状态的id
     * @param statusIds 业务状态的id集合
     * @return Map 业务状态信息集合
     */
    Map<String, String> statusByids(List<String> statusIds);
    
    /**
     * 业务流水号
     * 
     * @return
     */
    String  generate(String busName);
    
    static final String SERIAL_NUMBER = "itsm:serial:";
}
