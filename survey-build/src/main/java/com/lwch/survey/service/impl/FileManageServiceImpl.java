/**
 * 
 */
package com.lwch.survey.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.FileManageMapper;
import com.lwch.survey.dao.mapper.FileManageMemberMapper;
import com.lwch.survey.model.FileManage;
import com.lwch.survey.model.FileManageExample;
import com.lwch.survey.model.FileManageMember;
import com.lwch.survey.model.FileManageMemberExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ProcessDefEntity;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.FileManageService;
import com.lwch.survey.service.ProcessWorkService;
import com.lwch.survey.utils.ServiceUtils;

/**
 * @author Rain
 *
 */
@Service
public class FileManageServiceImpl implements FileManageService{
    
    @Autowired
    private FileManageMapper fileManageMapper;
    
    @Autowired
    private ProcessWorkService processWorkService;
    
    @Autowired
    private FileManageMemberMapper fileManageMemberMapper;

    @Override
    public List<FileManage> selectByExample(FileManageExample fileManageExample, String query, PageParm pageParm) {
        
        if (StringUtils.isNotBlank(query)) {
            fileManageExample.createCriteria().andFileNameLike("%" + query + "%");
        }
        
        ServiceUtils.startPage(pageParm);
        
        return fileManageMapper.selectByExample(fileManageExample);
    }

    @Override
    public long getCount(String query) {
        FileManageExample example = new FileManageExample();
        
        if (StringUtils.isNotBlank(query)) {
            example.createCriteria().andFileNameLike("%" + query + "%");
        }
        
        return fileManageMapper.countByExample(example);
    }

    @Override
    public long insertFileManage(FileManage fileManage) {
        return fileManageMapper.insertSelective(fileManage);
    }

    @Override
    public void updateFileManage(FileManage fileManage) {
        fileManageMapper.updateByPrimaryKeySelective(fileManage);
    }

    @Override
    public void deleteFileManage(Integer id) {
        fileManageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public FileManage selectPrimaryKey(Integer id) {
        return fileManageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FileManageMember> selectByfileId(Integer id) {
        FileManageMemberExample example = new FileManageMemberExample();
        example.createCriteria().andFileManageIdEqualTo(id);
        return fileManageMemberMapper.selectByExample(example);
    }

    @Override
    public void insertBusiness(Integer id, List<String> bus) {
        
        if(CollectionUtils.isEmpty(bus)){
            return;
        }
        
        for(String member : bus){
            FileManageMemberExample manageMemberExample = new FileManageMemberExample();
            manageMemberExample.createCriteria().andFileManageIdEqualTo(id).andBusinessIdEqualTo(member);
            List<FileManageMember> fileManageMembers = fileManageMemberMapper.selectByExample(manageMemberExample);
            
            if(fileManageMembers.isEmpty()){
                FileManageMember manageMember = new FileManageMember();
                manageMember.setBusinessId(member);
                manageMember.setFileManageId(id);
                fileManageMemberMapper.insert(manageMember);
            }
        }
    }

    @Override
	public void inserFileManages(String businessId, List<Integer> ids) {
    	if(CollectionUtils.isEmpty(ids)){
            return;
        }
        
        for(Integer member : ids){
            FileManageMemberExample manageMemberExample = new FileManageMemberExample();
            manageMemberExample.createCriteria().andFileManageIdEqualTo(member).andBusinessIdEqualTo(businessId);
            List<FileManageMember> fileManageMembers = fileManageMemberMapper.selectByExample(manageMemberExample);
            
            if(fileManageMembers.isEmpty()){
                FileManageMember manageMember = new FileManageMember();
                manageMember.setBusinessId(businessId);
                manageMember.setFileManageId(member);
                fileManageMemberMapper.insert(manageMember);
            }
        }
	}

	@Override
    public Map<String, String> getbusIds() {
        return processWorkService.findProcessDefinition().stream().collect(Collectors.toMap(ProcessDefEntity::getKey, ProcessDefEntity::getName));
    }

    @Override
    public void deleteBusiness(Integer id, String name) {
        FileManageMemberExample manageMemberExample = new FileManageMemberExample();
        manageMemberExample.createCriteria().andFileManageIdEqualTo(id).andBusinessIdEqualTo(name);
        fileManageMemberMapper.deleteByExample(manageMemberExample);
    }

	@Override
	public ResponseObject queryByBusinessId(String businessId,PageParm pageParm) {
		ResponseObject obj = new ResponseObject();
		
		List<FileManageMember> fileMembers;
		try {
			
			ServiceUtils.startPage(pageParm);
			FileManageMemberExample manageMemberExample = new FileManageMemberExample();
			manageMemberExample.createCriteria().andBusinessIdEqualTo(businessId);
			fileMembers = fileManageMemberMapper.selectByExample(manageMemberExample);
			if(fileMembers.isEmpty()) {
				return obj;
			}
			
			for(FileManageMember member : fileMembers) {
				member.setFileManage(fileManageMapper.selectByPrimaryKey(member.getFileManageId()));
			}
			
			obj.setData(fileMembers);
			obj.setCount(queryByBusinessIdCount(businessId));
		} catch (Exception e) {
			
		}
		
		return obj;
	}
    
	private long queryByBusinessIdCount(String businessId) {
		FileManageMemberExample manageMemberExample = new FileManageMemberExample();
		manageMemberExample.createCriteria().andBusinessIdEqualTo(businessId);
		return  fileManageMemberMapper.countByExample(manageMemberExample);
	}
    
    
}
