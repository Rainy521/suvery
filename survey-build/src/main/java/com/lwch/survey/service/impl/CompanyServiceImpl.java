/**
 * 
 */
package com.lwch.survey.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.AptitudeUsersMemberMapper;
import com.lwch.survey.dao.mapper.CompanyHistoryMapper;
import com.lwch.survey.dao.mapper.CompanyInstrumentMemberMapper;
import com.lwch.survey.dao.mapper.CompanyMapper;
import com.lwch.survey.dao.mapper.CompanyUsersMemberMapper;
import com.lwch.survey.dao.mapper.EmployeeMapper;
import com.lwch.survey.dao.mapper.InstrumenttationMapper;
import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.model.Company;
import com.lwch.survey.model.CompanyExample;
import com.lwch.survey.model.CompanyHistory;
import com.lwch.survey.model.CompanyInstrumentMember;
import com.lwch.survey.model.CompanyInstrumentMemberExample;
import com.lwch.survey.model.CompanyUsersMember;
import com.lwch.survey.model.CompanyUsersMemberExample;
import com.lwch.survey.model.Employee;
import com.lwch.survey.model.EmployeeExample;
import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.model.InstrumenttationExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.CompanyService;
import com.lwch.survey.utils.ServiceUtils;

/**
 * @author Rain
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService{
    
    @Autowired
    private CompanyMapper companyMapper;
    
    @Autowired
    private CompanyUsersMemberMapper companyUsersMemberMapper;
    
    @Autowired
    private AptitudeUsersMemberMapper aptitudeUsersMemberMapper;
    
/*    @Autowired
    private GroupMemberMapper groupMemberMapper;*/
    
    @Autowired
    private InstrumenttationMapper instrumenttationMapper;
    
    @Autowired
    private CompanyInstrumentMemberMapper companyInstrumentMemberMapper;
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Autowired
    private CompanyHistoryMapper companyHistoryMapper;

    @Override
    public List<Company> selectByExample(CompanyExample companyExample, String query, PageParm pageParm) {
        
        if (StringUtils.isNotBlank(query)) {
            companyExample.createCriteria().andNameLike("%" + query + "%");
        }
        
        ServiceUtils.startPage(pageParm);
        
        return companyMapper.selectByExample(companyExample);
    }

    
    @Override
    public List<Company> selectByExample(CompanyExample companyExample) {
        return companyMapper.selectByExample(companyExample);
    }

    @Override
    public long getCount(String query) {
        CompanyExample companyExample = new CompanyExample();
        
        if (StringUtils.isNotBlank(query)) {
            companyExample.createCriteria().andNameLike("%" + query + "%");
        }
        
        return companyMapper.countByExample(companyExample);
    }

    @Override
    public long insertCompany(Company company, String username) {
        if(null != companyMapper.selectByPrimaryKey(company.getName())){
            return companyMapper.updateByPrimaryKeySelective(company);
        }
        return companyMapper.insertSelective(company);
    }

    @Override
    public void updateCompany(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
    }

    @Override
    public void deleteCompany(String name) {
        
        CompanyUsersMemberExample companyUsersMemberExample = new CompanyUsersMemberExample();
        companyUsersMemberExample.createCriteria().andBsnameEqualTo(name);
        companyUsersMemberMapper.deleteByExample(companyUsersMemberExample);
        
        List<CompanyUsersMember> usersMembers = companyUsersMemberMapper.selectByExample(companyUsersMemberExample);
        if(!usersMembers.isEmpty()){
            for(CompanyUsersMember member : usersMembers){
                aptitudeUsersMemberMapper.deleteByPrimaryKey(member.getUsername());
            }
        }
        
        companyMapper.deleteByPrimaryKey(name);
    }

    @Override
    public Company selectPrimaryKey(String id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Employee> selectUsers(String bsname) {
        /*CompanyUsersMemberExample cumExample = new CompanyUsersMemberExample();
        
        if(StringUtils.isBlank(bsname)){
            return Collections.emptyList();
        }
        cumExample.createCriteria().andBsnameEqualTo(bsname);
        List<CompanyUsersMember> companyUsersMembers = companyUsersMemberMapper.selectByExample(cumExample);
        
        if(companyUsersMembers.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> userIds = new ArrayList<>(); 
        for(CompanyUsersMember member : companyUsersMembers){
            userIds.add(member.getUsername());
        }
        AptitudeUsersMemberExample example = new AptitudeUsersMemberExample();
        example.createCriteria().andUsernameIn(userIds);*/
        
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andCnameEqualTo(bsname);
        return employeeMapper.selectByExample(example);
    }


    @Override
    public void insertUsers(Employee employee) {
        if(null == employee){
            return;
        }
        
        employeeMapper.insertSelective(employee);
        
/*        for(String member : usernames){
            CompanyUsersMemberExample example = new CompanyUsersMemberExample();
            example.createCriteria().andBsnameEqualTo(bsname).andUsernameEqualTo(member);
            List<CompanyUsersMember> companyUserMembers = companyUsersMemberMapper.selectByExample(example);
            
            if(companyUserMembers.isEmpty()){
                CompanyUsersMember companyMember = new CompanyUsersMember();
                companyMember.setBsname(bsname);
                companyMember.setUsername(member);
                companyUsersMemberMapper.insertSelective(companyMember);
                
                GroupMember groupMember = new GroupMember();
                groupMember.setGroupId(MAPPING_COMPANY_GROUP);
                groupMember.setUsername(member);
                groupMemberMapper.insertSelective(groupMember);
            }
            
            if(null == aptitudeUsersMemberMapper.selectByPrimaryKey(member)){
                AptitudeUsersMember aptitudeUsersMember = new AptitudeUsersMember();
                aptitudeUsersMember.setUsername(member);
                aptitudeUsersMemberMapper.insertSelective(aptitudeUsersMember);
            }
        }*/
    }

    @Override
    public void deleteUsers(String idCard) {
        employeeMapper.deleteByPrimaryKey(idCard);
    }

    @Override
    public void insertEmployee(Employee employee) {
        if(null != employeeMapper.selectByPrimaryKey(employee.getIdCard())){
            employeeMapper.updateByPrimaryKeySelective(employee);
            return;
        }
        employeeMapper.insertSelective(employee);
    }


    @Override
    public List<String> selectAllUsersCompanys() {
        List<CompanyUsersMember> companyUsersMembers = companyUsersMemberMapper.selectByExample(new CompanyUsersMemberExample());
        List<String> list = new ArrayList<>();
        for(CompanyUsersMember member :companyUsersMembers){
            list.add(member.getUsername());
        }
        return list;
    }


    @Override
    public void insertAptitudeUsersMember(AptitudeUsersMember aptitudeUsersMember) {
        
        aptitudeUsersMemberMapper.insertSelective(aptitudeUsersMember);
    }

    @Override
    public void updateAptitudeUsersMember(AptitudeUsersMember aptitudeUsersMember) {
        
        aptitudeUsersMemberMapper.updateByPrimaryKeySelective(aptitudeUsersMember);
    }

    @Override
    public List<Instrumenttation> selectInstrumentByExample(InstrumenttationExample instrumenttationExample,
            String bsname, PageParm pageParm) {
        CompanyInstrumentMemberExample memberExample = new CompanyInstrumentMemberExample();
        memberExample.createCriteria().andCompanyNameEqualTo(bsname);
        List<CompanyInstrumentMember> instrumentMembers = companyInstrumentMemberMapper.selectByExample(memberExample);
        
        if(instrumentMembers.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> ids = new ArrayList<>();
        for(CompanyInstrumentMember member : instrumentMembers){
            ids.add(member.getInstrumentId());
        }
        
        instrumenttationExample.createCriteria().andIdIn(ids);
        
        ServiceUtils.startPage(pageParm);
        return instrumenttationMapper.selectByExample(instrumenttationExample);
    }
    
    @Override
    public List<Instrumenttation> selectInstruments(InstrumenttationExample instrumenttationExample,
            String bsname) {
        CompanyInstrumentMemberExample memberExample = new CompanyInstrumentMemberExample();
        memberExample.createCriteria().andCompanyNameEqualTo(bsname);
        List<CompanyInstrumentMember> instrumentMembers = companyInstrumentMemberMapper.selectByExample(memberExample);
        
        if(instrumentMembers.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> ids = new ArrayList<>();
        for(CompanyInstrumentMember member : instrumentMembers){
            ids.add(member.getInstrumentId());
        }
        
        instrumenttationExample.createCriteria().andIdIn(ids);
        
        return instrumenttationMapper.selectByExample(instrumenttationExample);
    }


    @Override
    public Long getInstrumentCount(String bsname) {
        CompanyInstrumentMemberExample memberExample = new CompanyInstrumentMemberExample();
        memberExample.createCriteria().andCompanyNameEqualTo(bsname);
        List<CompanyInstrumentMember> instrumentMembers = companyInstrumentMemberMapper.selectByExample(memberExample);
        
        if(instrumentMembers.isEmpty()){
            return (long) 0;
        }
        
        List<String> ids = new ArrayList<>();
        for(CompanyInstrumentMember member : instrumentMembers){
            ids.add(member.getInstrumentId());
        }
        
        InstrumenttationExample example = new InstrumenttationExample();
        example.createCriteria().andIdIn(ids);
        return instrumenttationMapper.countByExample(example);
    }

    @Override
    public Instrumenttation getInstrumenttation(String id) {
        return instrumenttationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateInstrumenttation(Instrumenttation instrumenttation) {
        instrumenttationMapper.updateByPrimaryKeySelective(instrumenttation);
    }


    @Override
    public void insertInstrumenttation(Instrumenttation instrumenttation, String cname) {
        
        instrumenttationMapper.insertSelective(instrumenttation);
        
        CompanyInstrumentMember instrumentMember = new CompanyInstrumentMember();
        instrumentMember.setInstrumentId(instrumenttation.getId());
        instrumentMember.setCompanyName(cname);
        companyInstrumentMemberMapper.insertSelective(instrumentMember);
    }


    @Override
    public void deleteInstruments(String bsname , String id) {
        CompanyInstrumentMemberExample companyInstrumentMemberExample = new CompanyInstrumentMemberExample();
        companyInstrumentMemberExample.createCriteria().andCompanyNameEqualTo(bsname).andInstrumentIdEqualTo(id);
        companyInstrumentMemberMapper.deleteByExample(companyInstrumentMemberExample);
        
        instrumenttationMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void insertCompanyById(Company company, String username) {
        
        CompanyUsersMember companyMember = new CompanyUsersMember();
        companyMember.setBsname(company.getName());
        companyMember.setUsername(username);
        companyUsersMemberMapper.insertSelective(companyMember);
    }


    @Override
    public Company selectByCname(String cname) {
        Company company = companyMapper.selectByPrimaryKey(cname);
        
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andCnameEqualTo(cname);
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if(!employees.isEmpty()){
            company.setEmployees(employees);
        }
        
        CompanyInstrumentMemberExample instrumentMemberExample = new CompanyInstrumentMemberExample();
        instrumentMemberExample.createCriteria().andCompanyNameEqualTo(cname);
        List<CompanyInstrumentMember> instrumentMembers = companyInstrumentMemberMapper.selectByExample(instrumentMemberExample);
        if(!instrumentMembers.isEmpty()){
            
            List<String> ids = new ArrayList<>();
            for(CompanyInstrumentMember member : instrumentMembers){
                ids.add(member.getInstrumentId());
            }
            
            InstrumenttationExample example = new InstrumenttationExample();
            example.createCriteria().andIdIn(ids);
            List<Instrumenttation> instrumenttations = instrumenttationMapper.selectByExample(example);
            
            company.setInstrumenttations(instrumenttations);
        }
        
        return company;
    }


    @Override
    public void insertCompanyHistory(CompanyHistory companyHistory) {
        if(null != companyHistoryMapper.selectByPrimaryKey(companyHistory.getId())){
            companyHistoryMapper.updateByPrimaryKeySelective(companyHistory);
        }
        
        companyHistoryMapper.insertSelective(companyHistory);
    }
    
}
