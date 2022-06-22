package com.lwch.survey.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.FileMapper;
import com.lwch.survey.dao.mapper.FileTypeApplyMemberMapper;
import com.lwch.survey.dao.mapper.HouseMapper;
import com.lwch.survey.dao.mapper.OwnershipMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.SubjectMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.File;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.FileTypeApplyMemberExample;
import com.lwch.survey.model.House;
import com.lwch.survey.model.HouseExample;
import com.lwch.survey.model.Ownership;
import com.lwch.survey.model.OwnershipExample;
import com.lwch.survey.model.OwnershipExample.Criteria;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.model.Subject;
import com.lwch.survey.model.SubjectExample;
import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.HouseService;
import com.lwch.survey.utils.ServiceUtils;

@Service
public class HouseServiceImpl implements HouseService{
    
    @Autowired
    private OwnershipMapper ownershipMapper;
    
    @Autowired
    private HouseMapper houseMapper;
    
    @Autowired
    private SubjectMapper subjectMapper;
    
    @Autowired
    private ToolUsersMemberMapper toolUsersMemberMapper;
    
    @Autowired
    private ProcessStatusMapper processStatusMapper;
    
    @Autowired
    private FileTypeApplyMemberMapper fileTypeApplyMemberMapper;
    
    @Autowired
    private FileMapper fileMapper;
    
    
    @Override
    public List<Ownership> selectByExample(OwnershipExample ownershipExample, Map<String, String> map, PageParm pageParm) {
        
        Criteria criteria = ownershipExample.createCriteria();
        
        if (StringUtils.isNotBlank(map.get("id"))||StringUtils.isNotBlank(map.get("name"))
                ||StringUtils.isNotBlank(map.get("certificate"))||StringUtils.isNotBlank(map.get("location"))) {
            
            
            if (StringUtils.isNotBlank(map.get("id"))) {
                criteria.andIdLike("%" + map.get("id") + "%");
            }
            if (StringUtils.isNotBlank(map.get("name"))) {
                SubjectExample subjectExample = new SubjectExample();
                subjectExample.createCriteria().andNameLike("%" + map.get("name") + "%");
                List<Subject> subjects = subjectMapper.selectByExample(subjectExample);
                
                List<String> ids = new ArrayList<>();
                if(!subjects.isEmpty()){
                    
                    for(Subject member : subjects){
                        ids.add(member.getId());
                    }
                    
                    criteria.andIdIn(ids);
                }
            }
            if (StringUtils.isNotBlank(map.get("certificate"))) {
                criteria.andCertificateLike("%" + map.get("certificate") + "%");
            }
            if (StringUtils.isNotBlank(map.get("location"))) {
                criteria.andLocationLike("%" + map.get("location") + "%");
            }
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> pids = new ArrayList<>();
        for(ProcessStatus member : status){
            pids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(pids).andUsernameEqualTo(map.get("currentUsername"));
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        criteria.andIdIn(toolids);
        
        ServiceUtils.startPage(pageParm);
        
        return ownershipMapper.selectByExample(ownershipExample);
    }

    @Override
    public long getCount(Map<String, String> map) {
        OwnershipExample example = new OwnershipExample();
        Criteria criteria = example.createCriteria();
        
        if (StringUtils.isNotBlank(map.get("id"))||StringUtils.isNotBlank(map.get("name"))
                ||StringUtils.isNotBlank(map.get("certificate"))||StringUtils.isNotBlank(map.get("location"))) {
            
            if (StringUtils.isNotBlank(map.get("id"))) {
                criteria.andIdLike("%" + map.get("id") + "%");
            }
            if (StringUtils.isNotBlank(map.get("name"))) {
                SubjectExample subjectExample = new SubjectExample();
                subjectExample.createCriteria().andNameLike("%" + map.get("name") + "%");
                List<Subject> subjects = subjectMapper.selectByExample(subjectExample);
                
                List<String> ids = new ArrayList<>();
                if(!subjects.isEmpty()){
                    
                    for(Subject member : subjects){
                        ids.add(member.getId());
                    }
                    
                    criteria.andIdIn(ids);
                }
            }
            if (StringUtils.isNotBlank(map.get("certificate"))) {
                criteria.andCertificateLike("%" + map.get("certificate") + "%");
            }
            if (StringUtils.isNotBlank(map.get("location"))) {
                criteria.andLocationLike("%" + map.get("location") + "%");
            }
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return 0;
        }
        
        List<String> pids = new ArrayList<>();
        for(ProcessStatus member : status){
            pids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(pids).andUsernameEqualTo(map.get("currentUsername"));
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return 0;
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        criteria.andIdIn(toolids);
        
        return ownershipMapper.countByExample(example);
    }

    @Override
    public List<Ownership> selectByExampleFrom(Long startTime, Long endTime, String...condition) {
        OwnershipExample ownershipExample = new OwnershipExample();
        Criteria criteria = ownershipExample.createCriteria();
            
        if(StringUtils.isNotBlank(condition[0])) {
            criteria.andIdLike("%" + condition[0] + "%");
        }
        if(StringUtils.isNotBlank(condition[1])) {
            criteria.andLocationLike("%" + condition[1] + "%");
        }
        if(StringUtils.isNotBlank(condition[2])) {
            criteria.andApplicantLike("%" + condition[2] + "%");
        }
        if(startTime != null && endTime != null){
            criteria.andUpdateTimeBetween(new Date(startTime), new Date(endTime));
        }
        
        ownershipExample.setOrderByClause("update_time desc");
        List<Ownership> listOwners = ownershipMapper.selectByExample(ownershipExample);
        
        if(listOwners.isEmpty()){
            return Collections.emptyList();
        }
        
        List<Ownership> lists = new ArrayList<>();
        for(Ownership member : listOwners){
            HouseExample houseExample = new HouseExample();
            houseExample.createCriteria().andIdEqualTo(member.getId());
            List<House> houses = houseMapper.selectByExample(houseExample);
            double temp = 0;
            for(House house : houses){
                temp += house.getBuildArea();
            }
            
            BigDecimal b = new BigDecimal(temp);
            member.setAreas(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            
            lists.add(member);
        }
        
        return lists;
    }

    @Override
    public Ownership selectPrimaryKey(String id) {
        if(null == ownershipMapper.selectByPrimaryKey(id)){
            return null;
        }
        
        Ownership ownership = ownershipMapper.selectByPrimaryKey(id);
        
        HouseExample houseExample = new HouseExample();
        houseExample.createCriteria().andIdEqualTo(id);
        List<House> houses = houseMapper.selectByExample(houseExample);
        ownership.setListHouse(houses);
        
        SubjectExample subjectExample = new SubjectExample();
        subjectExample.createCriteria().andIdEqualTo(id);
        List<Subject> subjects = subjectMapper.selectByExample(subjectExample);
        ownership.setListSubject(subjects);
        
        return ownership;
    }

    @Override
    public List<Ownership> selectAllHouse() {
        
        return ownershipMapper.selectByExample(new OwnershipExample());
    }

    @Override
    public void updateHouses(Ownership ownership) {
        
        ownership.setUpdateTime(new Date());
        ownershipMapper.updateByPrimaryKeySelective(ownership);
        
        SubjectExample subjectExample = new SubjectExample();
        subjectExample.createCriteria().andIdEqualTo(ownership.getId());
        subjectMapper.deleteByExample(subjectExample);
        
        HouseExample houseExample = new HouseExample();
        houseExample.createCriteria().andIdEqualTo(ownership.getId());
        houseMapper.deleteByExample(houseExample);
        
        FileTypeApplyMemberExample fileTypeApplyMemberExample = new FileTypeApplyMemberExample();
        fileTypeApplyMemberExample.createCriteria().andApplyidEqualTo(ownership.getId());
        fileTypeApplyMemberMapper.deleteByExample(fileTypeApplyMemberExample);
        
        List<Subject> listSubject = ownership.getListSubject();
        for(Subject subjectMember : listSubject){
            subjectMember.setId(ownership.getId());
            subjectMapper.insertSelective(subjectMember);
        }
        
        List<House> listHouse = ownership.getListHouse();
        for(House houseMember : listHouse){
            houseMember.setId(ownership.getId());
            houseMapper.insertSelective(houseMember);
        }
        
        List<FileTypeApplyMember> listfiles = ownership.getListFileType();
        for(FileTypeApplyMember fileMember : listfiles){
            fileMember.setApplyid(ownership.getId());
            fileTypeApplyMemberMapper.insertSelective(fileMember);
        }
    }

    @Override
    public void insertHouses(Ownership ownership ,String username) {
        
        ownershipMapper.insertSelective(ownership);
        
        List<Subject> listSubject = ownership.getListSubject();
        for(Subject subjectMember : listSubject){
            subjectMember.setId(ownership.getId());
            subjectMapper.insertSelective(subjectMember);
        }
        
        List<House> listHouse = ownership.getListHouse();
        for(House houseMember : listHouse){
            houseMember.setId(ownership.getId());
            houseMapper.insertSelective(houseMember);
        }
        
        List<FileTypeApplyMember> listFileType = ownership.getListFileType();
        for(FileTypeApplyMember fileMember : listFileType){
            if(null == fileMember.getFiles()){
                continue;
            }
            File file = new File();
            String uuid = UUID.randomUUID().toString();
            file.setId(uuid);
            file.setContent(fileMember.getFiles());
            file.setName("siff");
            fileMapper.insert(file);
            
            fileMember.setFileId(uuid);
            fileMember.setApplyid(ownership.getId());
            fileMember.setFileManageId(108);
            fileTypeApplyMemberMapper.insertSelective(fileMember);
        }
        
		/*
		 * Map<String, byte[]> map = FtpUtils.getFileBytes(ownership.getSerialNo());
		 * Map<String, byte[]> map2 = FtpUtils.getFileBytes("HouseImage/" +
		 * ownership.getSerialNo()); map2.putAll(map);
		 * 
		 * for(String key : map2.keySet()){ FileTypeApplyMember member = new
		 * FileTypeApplyMember(); member.setApplyid(ownership.getId());
		 * 
		 * File file = new File();
		 * 
		 * String uuid = UUID.randomUUID().toString(); file.setId(uuid);
		 * file.setContent(map2.get(key)); file.setName(key); fileMapper.insert(file);
		 * 
		 * member.setFileId(uuid); if(key.contains("_")){
		 * member.setFileManageId(StringUtils.substring(key, 11, 14).replaceFirst("^0*",
		 * "")); }else{ member.setFileManageId("108"); }
		 * fileTypeApplyMemberMapper.insertSelective(member); }
		 */
        
        ToolUsersMember usersMember = new ToolUsersMember();
        usersMember.setUsername(username);
        usersMember.setId(ownership.getId());
        toolUsersMemberMapper.insert(usersMember);
        
        ProcessStatus processStatus = new ProcessStatus();
        processStatus.setId(ownership.getId());
        processStatus.setStatus(PROCESS_INIT_STATUS);
        processStatus.setName(ownership.getSerialNo() == null? ownership.getLocation():ownership.getSerialNo());
        processStatus.setFormkey(HOUSES_FORMKEY);
        processStatusMapper.insertSelective(processStatus);
        
    }

    @Override
    public void deleteHouses(String id) {
        toolUsersMemberMapper.deleteByPrimaryKey(id);
        
        processStatusMapper.deleteByPrimaryKey(id);
        
        HouseExample houseExample = new HouseExample();
        houseExample.createCriteria().andIdEqualTo(id);
        houseMapper.deleteByExample(houseExample);
        
        SubjectExample subjectExample = new SubjectExample();
        subjectExample.createCriteria().andIdEqualTo(id);
        subjectMapper.deleteByExample(subjectExample);
        
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(id);
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
        
        ownershipMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertFileMenber(FileTypeApplyMember fileTypeApplyMember) {
        
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(fileTypeApplyMember.getApplyid())
            .andFileManageIdEqualTo(fileTypeApplyMember.getFileManageId());
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
        
        fileTypeApplyMemberMapper.insert(fileTypeApplyMember);
    }

    @Override
    public TreeMap<Integer, List<FileTypeApplyMember>> getFileIds(String applyid) {
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(applyid);
        List<FileTypeApplyMember> members = fileTypeApplyMemberMapper.selectByExample(applyMemberExample);
        
        return  members.stream()
        .collect(Collectors.groupingBy(FileTypeApplyMember::getFileManageId,TreeMap::new,Collectors.toList()));
    }

}
