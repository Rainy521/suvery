package com.lwch.survey.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.service.ProcessCommonService;

/**
 * 
 * controller: 在线申请的流程相关状态操作
 * 
 * @author zhangdq
 * 
 * @since 2017-11-13
 * 
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/processCommon")
public class ProcessCommonController {
    
    @Autowired
    ProcessCommonService processCommonService;
    
    /**
     * 根据id得到状态
     * @param testmanage
     * @return
     * @throws Exception 
     */
    @PostMapping("/statusByids")
    public Map<String, String> statusByid(@RequestBody List<String> statusIds) {
        return processCommonService.statusByids(statusIds);
    }
    

}
