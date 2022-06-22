package com.lwch.survey.listener.common;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.model.ApplyEmployee;
import com.lwch.survey.model.Company;
import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.service.ApplyAptitudeService;
import com.lwch.survey.service.CompanyService;

@Component
public class CancelAptitudeEventListener{

    private static final Logger LOGGER = LoggerFactory.getLogger("Aptitude");
    
    @Autowired
    private ApplyAptitudeService applyAptitudeService;
    
    @Autowired
    private CompanyService companyService;

    public void expression(DelegateExecution execution) throws Exception {
        
        ApplyAptitude applyAptitude = applyAptitudeService.selectPrimaryKey(StringUtils.substringAfter(execution.getProcessBusinessKey(), "."));
        
        if(null != applyAptitude){
            Company companyEntity = companyService.selectByCname(applyAptitude.getCname());
            
            List<ApplyEmployee> applyEmployees = applyAptitude.getListEmployee();
            if(!applyEmployees.isEmpty()){
                for(ApplyEmployee member :applyEmployees){
                    companyService.deleteUsers(member.getIdCard());
                }
            }
            
            List<Instrumenttation> instrumenttations = companyEntity.getInstrumenttations();
            if(!instrumenttations.isEmpty()){
                for(Instrumenttation member : instrumenttations){
                    companyService.deleteInstruments(companyEntity.getName(), member.getId());
                }
            }
            
            companyService.deleteCompany(applyAptitude.getCname());
        }
        
        LOGGER.info("流程事件信息【流程定义：{}，流程实例：{}，执行id：{}，操作：{}】",
                execution.getProcessDefinitionId(),
                execution.getProcessInstanceId());
    }
}
