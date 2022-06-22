package com.lwch.survey.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Comment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwch.survey.dao.mapper.ApplyBuildMapper;
import com.lwch.survey.dao.mapper.ApplyProjectMapper;
import com.lwch.survey.dao.mapper.FcchGdbMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.view.DossierOracleMapper;
import com.lwch.survey.model.ApplyBuild;
import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.ApplyProjectExample;
import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.model.FcchGdbExample;
import com.lwch.survey.model.FcchGdbExample.Criteria;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.pojo.CommentPojo;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.DossierService;
import com.lwch.survey.utils.JsonUtil;
import com.lwch.survey.utils.ServiceUtils;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DossierServiceImpl implements DossierService {

	@Autowired
    private ApplyProjectMapper applyProjectMapper;
    
    @Autowired
    private ApplyBuildMapper applyBuildMapper;
    
    @Autowired
    private ProcessStatusMapper processStatusMapper;
    
    @Autowired
    private FcchGdbMapper fcchGdbMapper;
    
    @Autowired
    TaskService taskService;
    
    @Autowired
    HistoryService historyService;
    
    @Autowired
    private DossierOracleMapper dossierOracleDao;
    
    @Autowired
    private ConfigService configService;
    
    @Override
	public List<FcchGdb> query(DossierParam dossierParam) {
    	FcchGdbExample example = getFcchGdbExample(dossierParam);
    	
    	Integer startPage = null == dossierParam.getPageNum()?1:dossierParam.getPageNum();
    	Integer pageNum = null == dossierParam.getPageSize()?10:dossierParam.getPageSize();
    	PageParm pageParm = new PageParm(startPage,pageNum," updateTime desc");
    	
    	ServiceUtils.startPage(pageParm);
		return fcchGdbMapper.selectByExample(example);
	}
    
    @Override
	public long count(DossierParam dossierParam) {
    	FcchGdbExample example = getFcchGdbExample(dossierParam);
    	
		return fcchGdbMapper.countByExample(example);
	}

	@Override
	public FcchGdb getOne(Integer id) {
		FcchGdb entity = fcchGdbMapper.selectByPrimaryKey(id);
		entity.setComments(JsonUtil.getJsonToList(entity.getPzxx(), CommentPojo.class));
		return entity;
	}
	
	@Override
	@Transactional
	public long saveDossierByApplyId(String applyId) {
		ApplyProject applyProject = applyProjectMapper.selectByPrimaryKey(applyId);
		ApplyBuild applyBuild = applyBuildMapper.selectByPrimaryKey(applyId);
		ProcessStatus proStatus = processStatusMapper.selectByPrimaryKey(applyId);
		
		if(null == applyProject || null == applyBuild || null == proStatus) {
			return 0;
		}
		
		FcchGdbExample example = new FcchGdbExample();
		example.createCriteria().andApplyidEqualTo(applyId).andYxxEqualTo(0);
		FcchGdb fcchGdb = new FcchGdb();
		fcchGdb.setYxx(1);
		fcchGdbMapper.updateByExampleSelective(fcchGdb, example);
		
		String processInstanceId = proStatus.getProcinstid();
		
		FcchGdb saveEntity = conventProject(applyProject,applyBuild);
		
		Integer backNum = conventBcakNum(processInstanceId);
		List<CommentPojo> listComments = conventCommont(processInstanceId);
		
		saveEntity.setUpdatetime(new Date());
		saveEntity.setLcslid(processInstanceId);
		
		saveEntity.setPzxx(JsonUtil.getBeanToJson(listComments));
		saveEntity.setLspzxx(null);
		saveEntity.setThcs(null);
		saveEntity.setBacknum(backNum);
		
		saveEntity.setGdno(null);
//		saveEntity.setFiles(null);
		return fcchGdbMapper.insert(saveEntity);
	}

	@Override
	public long updateDossier(FcchGdb fcchGdb) {
		return fcchGdbMapper.updateByPrimaryKeySelective(fcchGdb);
	}

	@Override
	public long removeDossierById(Integer id) {
		return fcchGdbMapper.deleteByPrimaryKey(id);
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
	
	@Override
	public ResponseObject getOldQuery(DossierParam dossierParam) {
		ResponseObject obj = new ResponseObject();
		try {
			Integer pageNum = null == dossierParam.getPageNum()?1:dossierParam.getPageNum();
			Integer pageSize = null == dossierParam.getPageSize()?10:dossierParam.getPageSize();
			
			Map<String, Object> structureMap = configService.getMapConfigs("structure.", true);
			Map<String, Object> useMap = configService.getMapConfigs("use.", true);
			
			ServiceUtils.startPage(new PageParm(pageNum, pageSize, ""));
			long starttime = System.currentTimeMillis();
			List<FcchGdb> listFcch = dossierOracleDao.getDatas(dossierParam);
			long endtime = System.currentTimeMillis();
			System.out.println(endtime - starttime);
			
			for(FcchGdb member : listFcch) {
				String usageCode = member.getUsageCode();
				String structCode = member.getStructCode();
				
				if(null != structCode && null != structureMap.get(structCode)) {
					member.setJzjg(structureMap.get(structCode).toString());
				}
				if(null != usageCode && null != useMap.get(usageCode)) {
					member.setGhyt(useMap.get(usageCode).toString());
				}
			}
			obj.setData(listFcch);
			obj.setCount(dossierOracleDao.getDatasCount(dossierParam));
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		
		return obj;
	}
	
	@Override
	public FcchGdb getOldOne(String hisId) {
		return dossierOracleDao.getDataByOldId(hisId);
	}
	
	@Override
	public FcchGdb getOldOneSiff(String hisId) {
		return dossierOracleDao.getDataBySiff(hisId);
	}

	@Override
	public ResponseObject applyFinishQquery(String query, PageParm pageParm) {
		ResponseObject obj = ResponseObject.builder()
				.http(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
		try {
			
			ProcessStatusExample processExample = new ProcessStatusExample();
			processExample.createCriteria().andStatusEqualTo("3")
				.andFormkeyLike("commercial" + "%");
			List<ProcessStatus> processStatuses = processStatusMapper.selectByExample(processExample);
			if(processStatuses.isEmpty()) {
				obj.setMsg("流程结束案件为空");
				return obj;
			}
			
//			List<FcchGdb> fcchGdbs = fcchGdbMapper.selectByExample(new FcchGdbExample());
					
			ApplyProjectExample projectExample = new ApplyProjectExample();
			com.lwch.survey.model.ApplyProjectExample.Criteria projecCriteria = projectExample.createCriteria();
			projecCriteria.andIdIn(processStatuses.stream()
					.map(ProcessStatus::getId).collect(Collectors.toList()));
//			if(!fcchGdbs.isEmpty()) {
//				projecCriteria.andIdNotIn(fcchGdbs.stream()
//					.map(FcchGdb::getApplyid).collect(Collectors.toList()));
//			}
			
			obj.setTotal(applyProjectMapper.countByExample(projectExample));
			
			ServiceUtils.startPage(pageParm);
			List<ApplyProject> list = applyProjectMapper.selectByExample(projectExample);
			if(!list.isEmpty()) {
				list.forEach(x -> x.setApplyBuild(applyBuildMapper.selectByPrimaryKey(x.getId())));
			}
			obj.setData(list);
			obj.setHttp(HttpStatus.OK.value());
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return obj;
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
	
	private FcchGdb conventProject(ApplyProject applyProject,ApplyBuild applyBuild) {
		FcchGdb saveEntity = new FcchGdb();
		saveEntity.setApplyid(applyProject.getId());
		saveEntity.setApplytime(applyProject.getUpdateTime());
		saveEntity.setBdcqzh(applyBuild.getBdcqzh());
		saveEntity.setChdw(applyProject.getSldw());
		saveEntity.setChdwcode(applyProject.getSlcreditCode());
		saveEntity.setChdwlxdh(applyProject.getSldh());
		saveEntity.setChdwlxr(applyProject.getSllxr());
		saveEntity.setChlx(applyBuild.getChlx());
		saveEntity.setDscs(applyBuild.getDscs());
		saveEntity.setDxcs(applyBuild.getDxcs());
		saveEntity.setGhxkzh(applyBuild.getGhxkzh());
		saveEntity.setGhyt(applyBuild.getGhyt());
		saveEntity.setJsdw(applyProject.getProjectFzr());
		saveEntity.setJsdwcode(applyProject.getCreditCode());
		saveEntity.setJzjg(applyBuild.getJzjg());
		saveEntity.setLpzh(applyBuild.getLpzh());
		saveEntity.setLxdh(applyProject.getLxdh());
		saveEntity.setLxr(applyProject.getLxr());
		saveEntity.setProname(applyProject.getProjectName());
		saveEntity.setRemark(applyProject.getProjectGk());
		saveEntity.setYxx(0);
		saveEntity.setXmzl(applyProject.getProjectXmzl());
		saveEntity.setZcs(applyBuild.getZcs());
		saveEntity.setZmj(applyBuild.getZjzmj());
		
		return saveEntity;
	}
	
	private FcchGdbExample getFcchGdbExample(DossierParam dossierParam) {
    	FcchGdbExample example = new FcchGdbExample();
    	if(null == dossierParam) {
    		return example;
    	}
    	Criteria criteria = example.createCriteria();
    	if(null != dossierParam.getApplyId() && !StringUtils.isBlank(dossierParam.getApplyId())) {
    		criteria.andApplyidLike("%" + dossierParam.getApplyId() + "%");
    	}
    	
    	if(null != dossierParam.getProName() && !StringUtils.isBlank(dossierParam.getProName())) {
    		criteria.andPronameLike("%" + dossierParam.getProName() + "%");
    	}
    	
    	if(null != dossierParam.getGhno() && !StringUtils.isBlank(dossierParam.getGhno())) {
    		criteria.andGdnoLike("%" + dossierParam.getGhno() + "%");
    	}
    	
    	if(null != dossierParam.getJsdw() && !StringUtils.isBlank(dossierParam.getJsdw())) {
    		criteria.andJsdwLike("%" + dossierParam.getJsdw() + "%");
    	}
    	
    	if(null != dossierParam.getXmzl() && !StringUtils.isBlank(dossierParam.getXmzl())) {
    		criteria.andXmzlLike("%" + dossierParam.getXmzl() + "%");
    	}
    	
    	if(null != dossierParam.getLpzh() && !StringUtils.isBlank(dossierParam.getLpzh())) {
    		criteria.andLpzhLike("%" + dossierParam.getLpzh() + "%");
    	}
    	
    	if(null != dossierParam.getChlx() && !StringUtils.isBlank(dossierParam.getChlx())) {
    		criteria.andChlxEqualTo(dossierParam.getChlx());
    	}
    	
    	if(null != dossierParam.getBeginGdrq() && !StringUtils.isBlank(dossierParam.getBeginGdrq())) {
    		try {
				criteria.andApplytimeBetween(
						new SimpleDateFormat("yyyy-MM-dd").parse(dossierParam.getBeginGdrq()), 
						new SimpleDateFormat("yyyy-MM-dd").parse(dossierParam.getEndGdrq())
				);
			} catch (ParseException e) {
				log.error(e.getLocalizedMessage());
			}
    	}
    	
    	return example;
    }

}
