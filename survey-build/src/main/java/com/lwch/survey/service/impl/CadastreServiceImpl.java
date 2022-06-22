package com.lwch.survey.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Comment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwch.survey.dao.mapper.ApplyCadastreMapper;
import com.lwch.survey.dao.mapper.DjchGdbMapper;
import com.lwch.survey.dao.mapper.FileTypeApplyMemberMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.ApplyCadastre;
import com.lwch.survey.model.ApplyCadastreExample;
import com.lwch.survey.model.ApplyCadastreExample.Criteria;
import com.lwch.survey.model.DjchGdb;
import com.lwch.survey.model.DjchGdbExample;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.FileTypeApplyMemberExample;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import com.lwch.survey.pojo.CommentPojo;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.CadastreService;
import com.lwch.survey.utils.JsonUtil;
import com.lwch.survey.utils.ServiceUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CadastreServiceImpl implements CadastreService{
	
	@Autowired
	private ApplyCadastreMapper applyCadastreMapper;
	
	@Autowired
    private ProcessStatusMapper processStatusMapper;
	
	@Autowired
    private ToolUsersMemberMapper toolUsersMemberMapper;
	
	@Autowired
	private FileTypeApplyMemberMapper fileTypeApplyMemberMapper;
	
	@Autowired
	private DjchGdbMapper djchGdbMapper;
	
	@Autowired
    TaskService taskService;
    
    @Autowired
    HistoryService historyService;

	@Override
	public List<ApplyCadastre> query(String query, String currentUsername, PageParm pageParm) {
		ApplyCadastreExample example = getQueryExample(query, currentUsername);
        
        ServiceUtils.startPage(pageParm);
        
        return applyCadastreMapper.selectByExample(example);
	}

	@Override
	public long getCount(String query, String currentUsername) {
		ApplyCadastreExample example = getQueryExample(query, currentUsername);
		return applyCadastreMapper.countByExample(example);
	}
	
	@Override
	public ApplyCadastre getOne(String id) {
		
		return applyCadastreMapper.selectByPrimaryKey(id);
	}

	@Override
	public ResponseObject updateCadastre(ApplyCadastre applyCadastre) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		try {
			FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
			applyMemberExample.createCriteria().andApplyidEqualTo(applyCadastre.getId());
			fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
			
			List<FileTypeApplyMember> listFiles = applyCadastre.getListFiles();
			for(FileTypeApplyMember fileMember : listFiles){
			    fileMember.setApplyid(applyCadastre.getId());
			    if(null != fileMember.getFileId()){
			    	 String[] arr = fileMember.getFileId().split(",");
			         if(arr.length > 1){
			        	 for(String temp : arr) {
			        		 FileTypeApplyMember member = new FileTypeApplyMember();
			        		 member.setApplyid(fileMember.getApplyid());
			        		 member.setFileId(temp);
			        		 member.setFileManageId(fileMember.getFileManageId());
			        		 fileTypeApplyMemberMapper.insertSelective(member);
			        	 } 
			         }else {
			        	 fileTypeApplyMemberMapper.insertSelective(fileMember);
			         }
			    }
			}
			
			applyCadastreMapper.updateByPrimaryKeySelective(applyCadastre);
			obj.setHttp(HttpStatus.OK.value());
			obj.setData(applyCadastre.getId());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return obj;
	}

	@Override
	public ResponseObject insertCadastre(ApplyCadastre applyCadastre, String currentUsername) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		try {
			List<FileTypeApplyMember> listFiles = applyCadastre.getListFiles();
			for(FileTypeApplyMember fileMember : listFiles){
			    fileMember.setApplyid(applyCadastre.getId());
			    if(null != fileMember.getFileId()){
			    	 String[] arr = fileMember.getFileId().split(",");
			         if(arr.length > 1){
			        	 for(String temp : arr) {
			        		 FileTypeApplyMember member = new FileTypeApplyMember();
			        		 member.setApplyid(fileMember.getApplyid());
			        		 member.setFileId(temp);
			        		 member.setFileManageId(fileMember.getFileManageId());
			        		 fileTypeApplyMemberMapper.insertSelective(member);
			        	 } 
			         }else {
			        	 fileTypeApplyMemberMapper.insertSelective(fileMember);
			         }
			    }
			}
			
			ToolUsersMember usersMember = new ToolUsersMember();
			usersMember.setUsername(currentUsername);
			usersMember.setId(applyCadastre.getId());
			toolUsersMemberMapper.insert(usersMember);
			
			ProcessStatus processStatus = new ProcessStatus();
			processStatus.setId(applyCadastre.getId());
			processStatus.setStatus(PROCESS_INIT_STATUS);
			processStatus.setName(applyCadastre.getProName());
			
			processStatus.setFormkey(COMMDODITY_FORMKEY);
			processStatusMapper.insertSelective(processStatus);
			
			applyCadastre.setCreateTime(new Date());
			applyCadastreMapper.insertSelective(applyCadastre);
			
			obj.setHttp(HttpStatus.OK.value());
			obj.setData(applyCadastre.getId());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
        return obj;
	}

	@Override
	public long deleteCadastreById(String id) {
        
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(id);
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
        
        toolUsersMemberMapper.deleteByPrimaryKey(id);
        processStatusMapper.deleteByPrimaryKey(id);
        
		return applyCadastreMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<DjchGdb> queryGd(DossierParam dossierParam) {
		DjchGdbExample example = getDjchGdbExample(dossierParam);
		
		Integer startPage = null == dossierParam.getPageNum()?1:dossierParam.getPageNum();
    	Integer pageNum = null == dossierParam.getPageSize()?10:dossierParam.getPageSize();
    	PageParm pageParm = new PageParm(startPage,pageNum," update_time desc");
    	
    	ServiceUtils.startPage(pageParm);
		return djchGdbMapper.selectByExample(example);
	}
	
	@Override
	public long queryGdCount(DossierParam dossierParam) {
		DjchGdbExample example = getDjchGdbExample(dossierParam);
		
		return djchGdbMapper.countByExample(example);
	}

	@Override
	@Transactional
	public long saveCadastreDossierByApplyId(String applyId) {
		ApplyCadastre applyCadastre = applyCadastreMapper.selectByPrimaryKey(applyId);
		ProcessStatus proStatus = processStatusMapper.selectByPrimaryKey(applyId);
		
		if(null == applyCadastre || null == proStatus) {
			return 0;
		}
		
		DjchGdbExample example = new DjchGdbExample();
		example.createCriteria().andApplyIdEqualTo(applyId).andYxxEqualTo(GD_YXX_YES);
		DjchGdb djchGdb = new DjchGdb();
		djchGdb.setYxx(GD_YXX_NO);
		djchGdbMapper.updateByExampleSelective(djchGdb, example);
		
		String processInstanceId = proStatus.getProcinstid();
		
		DjchGdb saveEntity = conventCadastre(applyCadastre);
		
		Integer backNum = conventBcakNum(processInstanceId);
		List<CommentPojo> listComments = conventCommont(processInstanceId);
		
		saveEntity.setLcslid(processInstanceId);
		
		saveEntity.setPzxx(JsonUtil.getBeanToJson(listComments));
		saveEntity.setBacknum(backNum);
		
		saveEntity.setGdno(null);
		return djchGdbMapper.insert(saveEntity);
	}
	
	@Override
	public DjchGdb getGdbOne(Integer id) {
		DjchGdb entity = djchGdbMapper.selectByPrimaryKey(id);
		entity.setComments(JsonUtil.getJsonToList(entity.getPzxx(), CommentPojo.class));
		entity.setApplyCadastre(JsonUtil.getJsonToBean(entity.getApplyField(), ApplyCadastre.class));
		return entity;
	}

	@Override
	public long updateCadastreDossier(DjchGdb djchGdb) {
		return djchGdbMapper.updateByPrimaryKeySelective(djchGdb);
	}

	@Override
	public long removeDossierById(Integer id) {
		return djchGdbMapper.deleteByPrimaryKey(id);
	}

	private List<CommentPojo> conventCommont(String processInstanceId){
		List<CommentPojo> list = new ArrayList<>();
		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()//历史任务表查询
				.processInstanceId(processInstanceId)//使用流程实例ID查询
				.list();
		List<Comment> commentlist = new ArrayList<>();
		//遍历集合，获取每个任务ID
		if(!htiList.isEmpty()){
			for(HistoricTaskInstance hti : htiList){
				//任务ID
				String htaskId = hti.getId();
				//获取批注信息
				List<Comment> taskList = taskService.getTaskComments(htaskId);//对用历史完成后的任务ID
				commentlist.addAll(taskList);
			}
		}
		for(Comment temp : commentlist) {
            CommentPojo commentPojo = new CommentPojo();
            commentPojo.setId(temp.getId());
            commentPojo.setFullMessage(temp.getFullMessage());
            commentPojo.setProcessInstanceId(temp.getProcessInstanceId());
            commentPojo.setUserId(temp.getUserId());
            commentPojo.setTime(temp.getTime());
            commentPojo.setTaskId(temp.getTaskId());
            String taskName = historyService.createHistoricTaskInstanceQuery().taskId(temp.getTaskId()).singleResult().getName();
            commentPojo.setTaskName(taskName);
            commentPojo.setType(temp.getType());
            list.add(commentPojo);
        }
		
        return list;
	}
	
	private int conventBcakNum(String processInstanceId){
		int num = 0;
		List<CommentPojo> list = new ArrayList<>();
		List<HistoricTaskInstance> htiList = historyService.createHistoricTaskInstanceQuery()//历史任务表查询
				.processInstanceId(processInstanceId)//使用流程实例ID查询
				.list();
		List<Comment> commentlist = new ArrayList<>();
		//遍历集合，获取每个任务ID
		if(!htiList.isEmpty()){
			for(HistoricTaskInstance hti : htiList){
				//任务ID
				String htaskId = hti.getId();
				//获取批注信息
				List<Comment> taskList = taskService.getTaskComments(htaskId);//对用历史完成后的任务ID
				commentlist.addAll(taskList);
			}
		}
		for(Comment temp : commentlist) {
            CommentPojo commentPojo = new CommentPojo();
            commentPojo.setId(temp.getId());
            commentPojo.setFullMessage(temp.getFullMessage());
            commentPojo.setProcessInstanceId(temp.getProcessInstanceId());
            commentPojo.setUserId(temp.getUserId());
            commentPojo.setTime(temp.getTime());
            commentPojo.setTaskId(temp.getTaskId());
            String taskName = historyService.createHistoricTaskInstanceQuery().taskId(temp.getTaskId()).singleResult().getName();
            commentPojo.setTaskName(taskName);
            commentPojo.setType(temp.getType());
            list.add(commentPojo);
            if("申请".equals(taskName)) {
            	num++;
            }
        }
		
        return num;
	}
	
	private DjchGdb conventCadastre(ApplyCadastre applyCadastre) {
		DjchGdb entity = new DjchGdb();
		
		entity.setApplyId(applyCadastre.getId());
		entity.setJsdw(applyCadastre.getJsdw());
		entity.setUpdateTime(new Date());
		entity.setYxx(GD_YXX_YES);
		entity.setProName(applyCadastre.getProName());
		entity.setProXmlz(applyCadastre.getProXmzl());
		
		entity.setApplyField(JsonUtil.getBeanToJson(applyCadastre));
		
		return entity;
	}

	private DjchGdbExample getDjchGdbExample(DossierParam dossierParam) {
		DjchGdbExample example = new DjchGdbExample();
    	if(null == dossierParam) {
    		return example;
    	}
    	com.lwch.survey.model.DjchGdbExample.Criteria criteria = example.createCriteria();
    	if(null != dossierParam.getApplyId() && !StringUtils.isBlank(dossierParam.getApplyId())) {
    		criteria.andApplyIdLike("%" + dossierParam.getApplyId() + "%");
    	}
    	
    	if(null != dossierParam.getProName() && !StringUtils.isBlank(dossierParam.getProName())) {
    		criteria.andProNameLike("%" + dossierParam.getProName() + "%");
    	}
    	
    	if(null != dossierParam.getGhno() && !StringUtils.isBlank(dossierParam.getGhno())) {
    		criteria.andGdnoLike("%" + dossierParam.getGhno() + "%");
    	}
    	
    	if(null != dossierParam.getJsdw() && !StringUtils.isBlank(dossierParam.getJsdw())) {
    		criteria.andJsdwLike("%" + dossierParam.getJsdw() + "%");
    	}
    	
    	if(null != dossierParam.getXmzl() && !StringUtils.isBlank(dossierParam.getXmzl())) {
    		criteria.andProXmlzLike("%" + dossierParam.getXmzl() + "%");
    	}
    	
    	if(null != dossierParam.getBeginGdrq() && !StringUtils.isBlank(dossierParam.getBeginGdrq())) {
    		try {
				criteria.andUpdateTimeBetween(
						new SimpleDateFormat("yyyy-MM-dd").parse(dossierParam.getBeginGdrq()), 
						new SimpleDateFormat("yyyy-MM-dd").parse(dossierParam.getEndGdrq())
				);
			} catch (ParseException e) {
				log.error(e.getLocalizedMessage());
			}
    	}
    	
    	return example;
    }

	private ApplyCadastreExample getQueryExample(String query, String currentUsername) {
		ApplyCadastreExample example = new ApplyCadastreExample();
		Criteria criteria = example.createCriteria();
        
        if (StringUtils.isNotBlank(query)) {
        	criteria.andProNameLike("%" + query + "%");
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return null;
        }
        
        List<String> ids = new ArrayList<>();
        for(ProcessStatus member : status){
            ids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(ids).andUsernameEqualTo(currentUsername);
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return null;
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        criteria.andIdIn(toolids);
        return example;
	}

}
