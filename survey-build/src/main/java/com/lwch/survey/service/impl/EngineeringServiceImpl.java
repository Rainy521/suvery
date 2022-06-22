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

import com.lwch.survey.dao.mapper.ApplyEngineeringMapper;
import com.lwch.survey.dao.mapper.FileTypeApplyMemberMapper;
import com.lwch.survey.dao.mapper.GcclGdbMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.ApplyEngineering;
import com.lwch.survey.model.ApplyEngineeringExample;
import com.lwch.survey.model.ApplyEngineeringExample.Criteria;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.FileTypeApplyMemberExample;
import com.lwch.survey.model.GcclGdb;
import com.lwch.survey.model.GcclGdbExample;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import com.lwch.survey.pojo.CommentPojo;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.EngineeringService;
import com.lwch.survey.utils.JsonUtil;
import com.lwch.survey.utils.ServiceUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EngineeringServiceImpl implements EngineeringService{
	
	@Autowired
	private ApplyEngineeringMapper applyEngineeringMapper;
	
	@Autowired
    private ProcessStatusMapper processStatusMapper;
	
	@Autowired
    private ToolUsersMemberMapper toolUsersMemberMapper;
	
	@Autowired
	private FileTypeApplyMemberMapper fileTypeApplyMemberMapper;
	
	@Autowired
	private GcclGdbMapper gcclGdbMapper;
	
	@Autowired
    TaskService taskService;
    
    @Autowired
    HistoryService historyService;

	@Override
	public List<ApplyEngineering> query(String query, String currentUsername, PageParm pageParm) {
		ApplyEngineeringExample example = getQueryExample(query, currentUsername);
        
        ServiceUtils.startPage(pageParm);
        
        return applyEngineeringMapper.selectByExample(example);
	}

	@Override
	public long getCount(String query, String currentUsername) {
		
		return applyEngineeringMapper.countByExample(getQueryExample(query, currentUsername));
	}

	@Override
	public ApplyEngineering getOne(String id) {
		return applyEngineeringMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public ResponseObject updateEngineering(ApplyEngineering applyEngineering) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		try {
			FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
			applyMemberExample.createCriteria().andApplyidEqualTo(applyEngineering.getId());
			fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
			
			List<FileTypeApplyMember> listFiles = applyEngineering.getListFiles();
			for(FileTypeApplyMember fileMember : listFiles){
			    fileMember.setApplyid(applyEngineering.getId());
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
			applyEngineeringMapper.updateByPrimaryKeySelective(applyEngineering);
			processStatusMapper.updateByPrimaryKeySelective(ProcessStatus.builder()
					.id(applyEngineering.getId())
					.number(applyEngineering.getLpzh()).build());
			
			obj.setHttp(HttpStatus.OK.value());
			obj.setData(applyEngineering.getId());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return obj;
	}

	@Override
	@Transactional
	public ResponseObject insertEngineering(ApplyEngineering applyEngineering, String currentUsername) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		try {
			List<FileTypeApplyMember> listFiles = applyEngineering.getListFiles();
			for(FileTypeApplyMember fileMember : listFiles){
			    fileMember.setApplyid(applyEngineering.getId());
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
			usersMember.setId(applyEngineering.getId());
			toolUsersMemberMapper.insert(usersMember);
			
			ProcessStatus processStatus = new ProcessStatus();
			processStatus.setId(applyEngineering.getId());
			processStatus.setStatus(PROCESS_INIT_STATUS);
			processStatus.setName(applyEngineering.getProName());
			
			processStatus.setFormkey(COMMDODITY_FORMKEY);
			processStatus.setNumber(applyEngineering.getLpzh());
			processStatusMapper.insertSelective(processStatus);
			
			applyEngineering.setCreateTime(new Date());
			applyEngineeringMapper.insertSelective(applyEngineering);
			
			obj.setHttp(HttpStatus.OK.value());
			obj.setData(applyEngineering.getId());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return obj;
	}

	@Override
	public long deleteEngineeringById(String id) {
		FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(id);
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
        
        toolUsersMemberMapper.deleteByPrimaryKey(id);
        processStatusMapper.deleteByPrimaryKey(id);
        
		return applyEngineeringMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<GcclGdb> queryGd(DossierParam dossierParam) {
		GcclGdbExample example = getGcclGdbExample(dossierParam);
		
		Integer startPage = null == dossierParam.getPageNum()?1:dossierParam.getPageNum();
    	Integer pageNum = null == dossierParam.getPageSize()?10:dossierParam.getPageSize();
    	PageParm pageParm = new PageParm(startPage,pageNum," update_time desc");
    	
    	ServiceUtils.startPage(pageParm);
    	
		return gcclGdbMapper.selectByExample(example);
	}

	@Override
	public long queryGdCount(DossierParam dossierParam) {
		
		return gcclGdbMapper.countByExample(getGcclGdbExample(dossierParam));
	}

	@Override
	@Transactional
	public long saveEngineeringDossierByApplyId(String applyId) {
		ApplyEngineering applyEngineering = applyEngineeringMapper.selectByPrimaryKey(applyId);
		ProcessStatus proStatus = processStatusMapper.selectByPrimaryKey(applyId);
		
		if(null == applyEngineering || null == proStatus) {
			return 0;
		}
		
		GcclGdbExample example = new GcclGdbExample();
		example.createCriteria().andApplyIdEqualTo(applyId).andYxxEqualTo(GD_YXX_YES);
		GcclGdb gcclGdb = new GcclGdb();
		gcclGdb.setYxx(GD_YXX_NO);
		gcclGdbMapper.updateByExampleSelective(gcclGdb, example);
		
		String processInstanceId = proStatus.getProcinstid();
		
		GcclGdb saveEntity = conventEngineering(applyEngineering);
		
		Integer backNum = conventBcakNum(processInstanceId);
		List<CommentPojo> listComments = conventCommont(processInstanceId);
		
		saveEntity.setLcslid(processInstanceId);
		
		saveEntity.setPzxx(JsonUtil.getBeanToJson(listComments));
		saveEntity.setBacknum(backNum);
		
		saveEntity.setGdno(null);
		return gcclGdbMapper.insert(saveEntity);
	}

	@Override
	public GcclGdb getGdbOne(Integer id) {
		GcclGdb entity = gcclGdbMapper.selectByPrimaryKey(id);
		entity.setComments(JsonUtil.getJsonToList(entity.getPzxx(), CommentPojo.class));
		entity.setEngineering(JsonUtil.getJsonToBean(entity.getApplyField(), ApplyEngineering.class));
		return entity;
	}

	@Override
	public long updateEngineeringDossier(GcclGdb gcclGdb) {
		return gcclGdbMapper.updateByPrimaryKeySelective(gcclGdb);
	}

	@Override
	public long removeDossierById(Integer id) {
		return gcclGdbMapper.deleteByPrimaryKey(id);
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
	
	private GcclGdb conventEngineering(ApplyEngineering ApplyEngineering) {
		GcclGdb entity = new GcclGdb();
		
		entity.setApplyId(ApplyEngineering.getId());
		entity.setJsdw(ApplyEngineering.getJsdw());
		entity.setUpdateTime(new Date());
		entity.setYxx(GD_YXX_YES);
		entity.setProName(ApplyEngineering.getProName());
		entity.setProXmzl(ApplyEngineering.getProXmzl());
		entity.setLpzh(ApplyEngineering.getLpzh());
		entity.setChlx(ApplyEngineering.getChlx());
		
		entity.setApplyField(JsonUtil.getBeanToJson(ApplyEngineering));
		
		return entity;
	}

	private GcclGdbExample getGcclGdbExample(DossierParam dossierParam) {
		GcclGdbExample example = new GcclGdbExample();
    	if(null == dossierParam) {
    		return example;
    	}
    	com.lwch.survey.model.GcclGdbExample.Criteria criteria = example.createCriteria();
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
    		criteria.andProXmzlLike("%" + dossierParam.getXmzl() + "%");
    	}
    	
    	if(null != dossierParam.getLpzh() && !StringUtils.isBlank(dossierParam.getLpzh())) {
    		criteria.andLpzhLike("%" + dossierParam.getLpzh() + "%");
    	}
    	
    	if(null != dossierParam.getChlx() && !StringUtils.isBlank(dossierParam.getChlx())) {
    		criteria.andChlxEqualTo(dossierParam.getChlx());
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

	private ApplyEngineeringExample getQueryExample(String query, String currentUsername) {
		ApplyEngineeringExample example = new ApplyEngineeringExample();
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
