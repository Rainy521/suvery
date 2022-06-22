package com.lwch.survey.listener.common;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.model.ApplyEmployee;
import com.lwch.survey.model.ApplyInstrument;
import com.lwch.survey.model.Company;
import com.lwch.survey.model.CompanyHistory;
import com.lwch.survey.model.Employee;
import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.service.ApplyAptitudeService;
import com.lwch.survey.service.CompanyService;
import com.lwch.survey.service.ProcessCommonService;

@Component
public class UpdateAptitudeEventListener{

    private static final Logger LOGGER = LoggerFactory.getLogger("Aptitude");
    
    @Autowired
    private ApplyAptitudeService applyAptitudeService;
    
    @Autowired
    private ProcessCommonService processCommonService;
    
    @Autowired
    private CompanyService companyService;

    public void expression(DelegateExecution execution) throws Exception {
        
        ApplyAptitude applyAptitude = applyAptitudeService.selectPrimaryKey(StringUtils.substringAfter(execution.getProcessBusinessKey(), "."));
        
        if(null != applyAptitude){
            ObjectMapper om = new ObjectMapper();
            String companyOld = "";
            String companyNew = "";
            try {
                companyNew = om.writeValueAsString(applyAptitude);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            
            CompanyHistory companyHistory = new CompanyHistory();
            companyHistory.setId(applyAptitude.getId());
            companyHistory.setCompanyNew(companyNew);
            companyHistory.setCompanyOld(companyOld);
            companyService.insertCompanyHistory(companyHistory);
            
            Company company = new Company();
            company.setAptitude(applyAptitude.getAptitude());
            company.setContacts(applyAptitude.getContacts());
            company.setExpiryTime(applyAptitude.getExpiryTime());
            company.setName(applyAptitude.getCname());
            company.setPhone(applyAptitude.getPhone());
            company.setStatus(applyAptitude.getStatus());
            company.setQyyyzhNo(applyAptitude.getQyyyzhNo());
            company.setQyzycs(applyAptitude.getQyzycs());
            company.setQyzzNo(applyAptitude.getQyzzNo());
            company.setFiles(applyAptitude.getFiles());
            
            companyService.insertCompany(company, "");
            
            List<ApplyEmployee> applyEmployees = applyAptitude.getListEmployee();
            if(!applyEmployees.isEmpty()){
                for(ApplyEmployee member :applyEmployees){
                    Employee employee = new Employee();
                    employee.setCname(member.getCname());
                    employee.setEmail(member.getEmail());
                    employee.setExpiryTime(member.getExpiryTime());
                    employee.setIdCard(member.getIdCard());
                    employee.setName(member.getName());
                    employee.setPhone(member.getPhone());
                    employee.setSex(member.getSex());
                    employee.setStatus(member.getStatus());
                    employee.setYgzzNo(member.getYgzzNo());
                    employee.setZzzslx(member.getZzzslx());
                    employee.setFiles(member.getFiles());
                    
                    companyService.insertEmployee(employee);
                }
            }
            
            List<ApplyInstrument> instruments = applyAptitude.getInstruments();
            if(!instruments.isEmpty()){
                for(ApplyInstrument member : instruments){
                    Instrumenttation instrumenttation = new Instrumenttation();
                    instrumenttation.setCertificateNo(member.getCertificateNo());
                    instrumenttation.setCognizance(member.getCognizance());
                    instrumenttation.setFactoryNo(member.getFactoryNo());
                    instrumenttation.setId(processCommonService.generate("APM"));
                    instrumenttation.setInvoiceNo(member.getInvoiceNo());
                    instrumenttation.setMechanism(member.getMechanism());
                    instrumenttation.setModel(member.getModel());
                    instrumenttation.setName(member.getName());
                    instrumenttation.setNumber(member.getNumber());
                    instrumenttation.setVerificationDate(member.getVerificationDate());
                    instrumenttation.setFiles(member.getFiles());
                    
                    companyService.insertInstrumenttation(instrumenttation, applyAptitude.getCname());
                }
            }
            
        }
        
        LOGGER.info("流程事件信息【流程定义：{}，流程实例：{}，执行id：{}，操作：{}】",
                execution.getProcessDefinitionId(),
                execution.getProcessInstanceId());
    }
}
