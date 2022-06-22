/**
 * 
 */
package com.lwch.survey.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.ApplyAptitudeMapper;
import com.lwch.survey.dao.mapper.ApplyAptitudeUsersMemberMapper;
import com.lwch.survey.dao.mapper.ApplyEmployeeMapper;
import com.lwch.survey.dao.mapper.ApplyInstrumentMapper;
import com.lwch.survey.dao.mapper.AptitudeUsersMemberMapper;
import com.lwch.survey.dao.mapper.CompanyUsersMemberMapper;
import com.lwch.survey.dao.mapper.EmployeeMapper;
import com.lwch.survey.dao.mapper.FileTypeApplyMemberMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.model.ApplyAptitudeExample;
import com.lwch.survey.model.ApplyAptitudeExample.Criteria;
import com.lwch.survey.model.ApplyAptitudeUsersMember;
import com.lwch.survey.model.ApplyAptitudeUsersMemberExample;
import com.lwch.survey.model.ApplyEmployee;
import com.lwch.survey.model.ApplyEmployeeExample;
import com.lwch.survey.model.ApplyInstrument;
import com.lwch.survey.model.ApplyInstrumentExample;
import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.model.AptitudeUsersMemberExample;
import com.lwch.survey.model.CompanyUsersMember;
import com.lwch.survey.model.CompanyUsersMemberExample;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.FileTypeApplyMemberExample;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.ApplyAptitudeService;
import com.lwch.survey.utils.ServiceUtils;

/**
 * @author Rain
 *
 */
@Service
public class ApplyAptitudeServiceImpl implements ApplyAptitudeService{
    
    @Autowired
    private ApplyAptitudeMapper applyAptitudeMapper;
    
    @Autowired
    private ApplyAptitudeUsersMemberMapper applyUsersMemberMapper;
    
    @Autowired
    private CompanyUsersMemberMapper companyUsersMemberMapper;
    
    @Autowired
    private AptitudeUsersMemberMapper aptitudeUsersMemberMapper;
    
    @Autowired
    private ApplyInstrumentMapper applyInstrumentMapper;
    
    @Autowired
    private ApplyEmployeeMapper applyEmployeeMapper;

    @Autowired
    private ToolUsersMemberMapper toolUsersMemberMapper;
    
    @Autowired
    private EmployeeMapper employeeMapper;
    
    @Autowired
    private ProcessStatusMapper processStatusMapper;
    
    @Autowired
    private FileTypeApplyMemberMapper fileTypeApplyMemberMapper;
    
    @Override
    public List<ApplyAptitude> selectByExample(ApplyAptitudeExample applyAptitudeExample, String query,int applyStatus,String username,
            PageParm pageParm) {
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> ids = new ArrayList<>();
        for(ProcessStatus member : status){
            ids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(ids).andUsernameEqualTo(username);
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        Criteria criteria = applyAptitudeExample.createCriteria().andApplyStatusEqualTo(applyStatus).andIdIn(toolids);
        if (StringUtils.isNotBlank(query)) {
            criteria.andCnameLike("%" + query + "%");
        }
        
        ServiceUtils.startPage(pageParm);
        
        return applyAptitudeMapper.selectByExample(applyAptitudeExample);
    }
    
    @Override
    public long getCount(String username, String query ,int applyStatus) {
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return 0;
        }
        
        List<String> ids = new ArrayList<>();
        for(ProcessStatus member : status){
            ids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(ids).andUsernameEqualTo(username);
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return 0;
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        ApplyAptitudeExample applyAptitudeExample = new ApplyAptitudeExample();
        Criteria criteria = applyAptitudeExample.createCriteria().andApplyStatusEqualTo(applyStatus).andIdIn(toolids);
        
        if (StringUtils.isNotBlank(query)) {
            criteria.andCnameLike("%" + query + "%");
        }
        
        return applyAptitudeMapper.countByExample(applyAptitudeExample);
    }


    @Override
    public long insertApplyAptitude(ApplyAptitude applyAptitude, String username) {
        
        List<ApplyEmployee> lists = applyAptitude.getListEmployee();
        for(ApplyEmployee member : lists){
            member.setId(applyAptitude.getId());
            
            if(null != employeeMapper.selectByPrimaryKey(member.getIdCard())){
                if(!applyAptitude.getCname().equals(employeeMapper.selectByPrimaryKey(member.getIdCard()).getCname())){
                    throw new RuntimeException(member.getName() + "的身份证已经注册，请重试！");
                }
            }
            
            if(null != applyEmployeeMapper.selectByPrimaryKey(member.getIdCard())){
                if(null != processStatusMapper.selectByPrimaryKey(applyAptitude.getId())){
                    if(!PROCESS_END_STATUS.equals(processStatusMapper.selectByPrimaryKey(applyAptitude.getId()))){
                        throw new RuntimeException(member.getName() + "已经进行申请！");
                    }
                }
            }
            
            if(null != applyEmployeeMapper.selectByPrimaryKey(member.getIdCard())){
                applyEmployeeMapper.deleteByPrimaryKey(member.getIdCard());
                applyEmployeeMapper.insertSelective(member);
            }else{
                applyEmployeeMapper.insertSelective(member);
            }
        }
        
        List<ApplyInstrument> instruments = applyAptitude.getInstruments();
        for(ApplyInstrument member : instruments){
            member.setId(applyAptitude.getId());
            applyInstrumentMapper.insertSelective(member);
        }
        
        List<FileTypeApplyMember> listFileType = applyAptitude.getListFileType();
        for(FileTypeApplyMember fileMember : listFileType){
            fileMember.setApplyid(applyAptitude.getId());
            fileTypeApplyMemberMapper.insertSelective(fileMember);
        }
        
        ToolUsersMember usersMember = new ToolUsersMember();
        usersMember.setUsername(username);
        usersMember.setId(applyAptitude.getId());
        toolUsersMemberMapper.insertSelective(usersMember);
        
        ProcessStatus processStatus = new ProcessStatus();
        processStatus.setId(applyAptitude.getId());
        processStatus.setStatus(PROCESS_INIT_STATUS);
        processStatus.setName(applyAptitude.getCname());
        processStatus.setFormkey(APTITUDE_FORMKEY);
        processStatusMapper.insertSelective(processStatus);
        
        return applyAptitudeMapper.insertSelective(applyAptitude);
    }


    @Override
    public void updateApplyAptitude(ApplyAptitude applyAptitude) {
        applyAptitudeMapper.updateByPrimaryKeySelective(applyAptitude);
        
        ApplyEmployeeExample employeeExample = new ApplyEmployeeExample();
        employeeExample.createCriteria().andIdEqualTo(applyAptitude.getId());
        applyEmployeeMapper.deleteByExample(employeeExample);
        
        ApplyInstrumentExample applyInstrumentExample = new ApplyInstrumentExample();
        applyInstrumentExample.createCriteria().andIdEqualTo(applyAptitude.getId());
        applyInstrumentMapper.deleteByExample(applyInstrumentExample);
        
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(applyAptitude.getId());
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
        
        List<ApplyEmployee> lists = applyAptitude.getListEmployee();
        for(ApplyEmployee member : lists){
            member.setId(applyAptitude.getId());
            
            if(null != employeeMapper.selectByPrimaryKey(member.getIdCard())){
                if(!applyAptitude.getCname().equals(employeeMapper.selectByPrimaryKey(member.getIdCard()).getCname())){
                    throw new RuntimeException(member.getName() + "的身份证已经注册，请重试！");
                }
            }
            
            if(null != applyEmployeeMapper.selectByPrimaryKey(member.getIdCard())){
                if(null != processStatusMapper.selectByPrimaryKey(applyAptitude.getId())){
                    if(!PROCESS_END_STATUS.equals(processStatusMapper.selectByPrimaryKey(applyAptitude.getId()))){
                        throw new RuntimeException(member.getName() + "已经进行申请！");
                    }
                }
            }
            
            applyEmployeeMapper.insertSelective(member);
        }
        
        List<ApplyInstrument> instruments = applyAptitude.getInstruments();
        for(ApplyInstrument member : instruments){
            member.setId(applyAptitude.getId());
            applyInstrumentMapper.insertSelective(member);
        }
        
        List<FileTypeApplyMember> listFileType = applyAptitude.getListFileType();
        for(FileTypeApplyMember fileMember : listFileType){
            fileMember.setApplyid(applyAptitude.getId());
            fileTypeApplyMemberMapper.insertSelective(fileMember);
        }
    }


    @Override
    public void deleteApplyAptitude(String id) {
        toolUsersMemberMapper.deleteByPrimaryKey(id);
        
        processStatusMapper.deleteByPrimaryKey(id);
        
        applyAptitudeMapper.deleteByPrimaryKey(id);
        
        ApplyEmployeeExample employeeExample = new ApplyEmployeeExample();
        employeeExample.createCriteria().andIdEqualTo(id);
        applyEmployeeMapper.deleteByExample(employeeExample);
        
        ApplyInstrumentExample applyInstrumentExample = new ApplyInstrumentExample();
        applyInstrumentExample.createCriteria().andIdEqualTo(id);
        applyInstrumentMapper.deleteByExample(applyInstrumentExample);
        
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(id);
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
    }

    @Override
    public ApplyAptitude selectPrimaryKey(String id) {
        ApplyAptitude aptitude = applyAptitudeMapper.selectByPrimaryKey(id);
        
        if(aptitude == null){
            return aptitude;
        }
        
        ApplyEmployeeExample employeeExample = new ApplyEmployeeExample();
        employeeExample.createCriteria().andIdEqualTo(id);
        aptitude.setListEmployee(applyEmployeeMapper.selectByExample(employeeExample));
        
        ApplyInstrumentExample applyInstrumentExample = new ApplyInstrumentExample();
        applyInstrumentExample.createCriteria().andIdEqualTo(id);
        aptitude.setInstruments(applyInstrumentMapper.selectByExample(applyInstrumentExample));
        return aptitude;
    }

    @Override
    public List<AptitudeUsersMember> selectUsers(String bsname) {
        CompanyUsersMemberExample cumExample = new CompanyUsersMemberExample();
        
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
        example.createCriteria().andUsernameIn(userIds);
        
        return aptitudeUsersMemberMapper.selectByExample(example);
    }


    @Override
    public List<String> selectAllUsersCompanys() {
        List<CompanyUsersMember> companyUsersMembers = companyUsersMemberMapper.selectByExample(new CompanyUsersMemberExample());
        List<String> list = new ArrayList<>();
        for(CompanyUsersMember member :companyUsersMembers){
            list.add(member.getUsername());
        }
        
        List<ApplyAptitudeUsersMember> usersMembers = applyUsersMemberMapper.selectByExample(new ApplyAptitudeUsersMemberExample());
        if(!usersMembers.isEmpty()){
            for(ApplyAptitudeUsersMember member : usersMembers){
                list.add(member.getUsername());
            }
        }
        return new ArrayList<>(new HashSet<String>(list));
    }

    
}
