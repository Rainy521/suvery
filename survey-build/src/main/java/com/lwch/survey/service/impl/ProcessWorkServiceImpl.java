package com.lwch.survey.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.FileManageMapper;
import com.lwch.survey.dao.mapper.FileManageMemberMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.FileManage;
import com.lwch.survey.model.FileManageExample;
import com.lwch.survey.model.FileManageMember;
import com.lwch.survey.model.FileManageMemberExample;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import com.lwch.survey.pojo.CommentPojo;
import com.lwch.survey.pojo.FinishTaskEntity;
import com.lwch.survey.pojo.ProcessDefEntity;
import com.lwch.survey.pojo.TaskInfoEntity;
import com.lwch.survey.service.ProcessWorkService;

@Service
public class ProcessWorkServiceImpl implements ProcessWorkService {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    HistoryService historyService;

    @Autowired
    IdentityService identityService;

    @Autowired
    FormService formService;

    @Autowired
    ProcessEngineConfiguration processEngineConfiguration;
    
    @Autowired
    ProcessStatusMapper processStatusMapper;
    
    @Autowired
    ToolUsersMemberMapper toolusersMapper;
    
    @Autowired
    FileManageMemberMapper fileManageMemberMapper;
    
    @Autowired
    FileManageMapper fileManageMapper;
    
    @Override
    public List<ProcessDefEntity> findProcessDefinition() {
        
        List<ProcessDefinition> definitionsList = repositoryService.createProcessDefinitionQuery().list();
        List<ProcessDefEntity> list = new ArrayList<>();
        
        if(definitionsList.isEmpty()){
            return Collections.emptyList();
        }
        
        for (ProcessDefinition temp : definitionsList) {
            ProcessDefEntity entity = new ProcessDefEntity();
            entity.setCategory(temp.getCategory());
            entity.setDeploymentId(temp.getDeploymentId());
            entity.setDescription(temp.getDescription());
            entity.setDiagramResourceName(temp.getDiagramResourceName());
            entity.setId(temp.getId());
            entity.setKey(temp.getKey());
            entity.setName(temp.getName());
            entity.setVersion(temp.getVersion());
            entity.setResourceName(temp.getResourceName());
            entity.setTenantId(temp.getTenantId());
            list.add(entity);
        }
        
        return list;
    }
    
    @Override
    public Deployment deployClasspath(String deployName) {
        return repositoryService.createDeployment().name(deployName)
                .addClasspathResource("processes/" + deployName + ".bpmn")
                .addClasspathResource("processes/" + deployName + ".png").deploy();
    }
    
    @Override
    public void deleteProcessDefinitionByKey(String key) {
        repositoryService.deleteDeployment(key, true);
    }
    
    @Override
    public ProcessInstance startProcessByKey(String key, Map<String, Object> variables) {
        if (!variables.containsKey("applyBid")) {
            return null;
        }
        if (null == processStatusMapper.selectByPrimaryKey((String)variables.get("applyBid"))) {
            return null;
        }
        
        String businessKey = key + "." + variables.get("applyBid");
        identityService.setAuthenticatedUserId((String) variables.get("userId"));
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, businessKey, variables);
        
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        task.setAssignee((String) variables.get("userId"));
        taskService.complete(task.getId());
        
        ProcessStatus status = processStatusMapper.selectByPrimaryKey((String)variables.get("applyBid"));
        
        status.setStatus(getHisTaskName(processInstance.getId()));
        status.setProcinstid(processInstance.getId());
        
        processStatusMapper.updateByPrimaryKey(status);
        
        return processInstance;
    }
    
    @Override
    public List<TaskInfoEntity> queryReceiveTasks(String userId,int pageNum,int pageSize) {
        List<Task> taskList = taskService.createTaskQuery().taskCandidateUser(userId)
                .orderByTaskCreateTime().desc().listPage(pageNum, pageSize);
        
        List<TaskInfoEntity> list = new ArrayList<>();
        for (Task temp : taskList) {
            TaskInfoEntity entity = new TaskInfoEntity();
            entity.setCreateTime(temp.getCreateTime());
            entity.setProcessDefinitionId(temp.getProcessDefinitionId());
            entity.setProcessDefinitionName(
                    repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
            entity.setProcessInstanceId(temp.getProcessInstanceId());
            entity.setTaskDefinitionKey(temp.getTaskDefinitionKey());
            entity.setTaskId(temp.getId());
            entity.setTaskName(temp.getName());
            entity.setProcessVariables(temp.getProcessVariables());
            entity.setButtons(getButtons(temp));
            entity.setApplyId(getApplyId(temp));
            
            ProcessStatus processStatus = processStatusMapper.selectByPrimaryKey(getApplyId(temp));
            
            entity.setApplyName(processStatus != null?processStatus.getName() : "");
            entity.setApplyNo(processStatus != null?processStatus.getNumber() : "");
            entity.setApplyUser(toolusersMapper.selectByPrimaryKey(getApplyId(temp)) != null?
                    toolusersMapper.selectByPrimaryKey(getApplyId(temp)).getUsername():null);
            list.add(entity);
        }
        
        return list;
    }
    
    @Override
    public long getReceiveTasksCount(String currentUsername) {
        return taskService.createTaskQuery().taskCandidateUser(currentUsername)
                .orderByTaskCreateTime().desc().list().size();
    }

    @Override
    public List<TaskInfoEntity> queryMyRunTask(String key,String userId, int pageNum, int pageSize) {
        
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(userId)
                .processDefinitionKey(key + "%")
                .orderByTaskCreateTime().desc().listPage(pageNum, pageSize);
        
        if(RUNTASK_MY_TASK.equals(key)){
            taskList = taskService.createTaskQuery().taskAssignee(userId)
                    .orderByTaskCreateTime().desc().listPage(pageNum, pageSize);
        }
        
        List<TaskInfoEntity> list = new ArrayList<>();
        for (Task temp : taskList) {
            TaskInfoEntity entity = new TaskInfoEntity();
            entity.setAssignee(temp.getAssignee());
            entity.setCreateTime(temp.getCreateTime());
            entity.setProcessDefinitionId(temp.getProcessDefinitionId());
            entity.setProcessDefinitionName(
                    repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
            entity.setFormKey(formService.getTaskFormData(temp.getId()).getFormKey());
            entity.setProcessInstanceId(temp.getProcessInstanceId());
            entity.setTaskDefinitionKey(temp.getTaskDefinitionKey());
            entity.setTaskId(temp.getId());
            entity.setTaskName(temp.getName());
            entity.setProcessVariables(temp.getProcessVariables());
            entity.setButtons(getButtons(temp));
            entity.setApplyId(getApplyId(temp));
            
            ProcessStatus processStatus = processStatusMapper.selectByPrimaryKey(getApplyId(temp));
            if (null == processStatus) {
                continue;
            }
            
            entity.setApplyName(processStatus.getName());
            entity.setApplyNo(processStatus.getNumber());
            entity.setApplyUser(toolusersMapper.selectByPrimaryKey(getApplyId(temp)) != null?toolusersMapper.selectByPrimaryKey(getApplyId(temp)).getUsername():null);
            list.add(entity);
        }
        
        return list;
    }

    @Override
    public long getMyRunTaskCount(String key ,String currentUsername) {
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(currentUsername)
                .processDefinitionKey(key + "%").list();
        
        if(RUNTASK_MY_TASK.equals(key)){
            taskList = taskService.createTaskQuery().taskAssignee(currentUsername).list();
        }
        
        List<TaskInfoEntity> list = new ArrayList<>();
        for (Task temp : taskList) {
            TaskInfoEntity entity = new TaskInfoEntity();
            entity.setAssignee(temp.getAssignee());
            entity.setCreateTime(temp.getCreateTime());
            entity.setProcessDefinitionId(temp.getProcessDefinitionId());
            entity.setProcessDefinitionName(
                    repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
            entity.setFormKey(formService.getTaskFormData(temp.getId()).getFormKey());
            entity.setProcessInstanceId(temp.getProcessInstanceId());
            entity.setTaskDefinitionKey(temp.getTaskDefinitionKey());
            entity.setTaskId(temp.getId());
            entity.setTaskName(temp.getName());
            entity.setProcessVariables(temp.getProcessVariables());
            entity.setButtons(getButtons(temp));
            entity.setApplyId(getApplyId(temp));
            if (null == processStatusMapper.selectByPrimaryKey(getApplyId(temp))) {
                continue;
            }
            entity.setApplyName(processStatusMapper.selectByPrimaryKey(getApplyId(temp))!=null?processStatusMapper.selectByPrimaryKey(getApplyId(temp)).getName():"");
            entity.setApplyUser(toolusersMapper.selectByPrimaryKey(getApplyId(temp)) != null?toolusersMapper.selectByPrimaryKey(getApplyId(temp)).getUsername():null);
            list.add(entity);
        }
        
        return list.size();
    }

    private List<String> getButtons(Task temp){
        List<String> buttonList =new ArrayList<>();
        ProcessDefinitionEntity pd = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(temp.getProcessDefinitionId());
        
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(temp.getProcessInstanceId()).singleResult();
        
        ActivityImpl activity = null;
        String activitiId = pi.getActivityId();
        activity = pd.findActivity(activitiId);
        
        List<ActivityImpl> listActivitys = pd.getActivities();
        for(ActivityImpl member : listActivitys){
            if(member.getId().equals(temp.getName())){
                activity = member;
                break;
            }
        }
        
        List<PvmTransition> transitions = activity.getOutgoingTransitions();
        for (PvmTransition trans : transitions) {
            String transName = (String) trans.getProperty("name");
            if (StringUtils.isNotBlank(transName)) {
                buttonList.add(transName);
            }
        }
        
        if (CollectionUtils.isEmpty(buttonList)) {
            buttonList.add("提交");// 默认
        }
        
        Collections.sort(buttonList);  
        
        return buttonList;
    }
    
    @Override
    public List<String> retrievalState() {
        List<ToolUsersMember> toolUsersMembers = toolusersMapper.selectByExample(new ToolUsersMemberExample());
        List<String> ids = new ArrayList<>();
        
        if(toolUsersMembers.isEmpty()){
            Collections.emptyList();
        }
        
        for(ToolUsersMember member : toolUsersMembers){
            ids.add(member.getId());
        }
        return ids;
    }
    
    @Override
    public void claim(String taskId, String userId) {
        try {
            taskService.claim(taskId, userId);
        } catch (Exception e) {
           throw new RuntimeException("任务已被认领!");
        }
    }
    
    @Override
    public void cancelTask(String taskId, String userId) throws Exception {
        
        taskService.claim(taskId, null);
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String applyId = getApplyId(task);
        ActivityImpl activity = findActivitiImpl(taskId, null); 
        
        if(activity.getId().equals(LinkName.APPLY_ONLINE.getTypeName())){
            if (null == processStatusMapper.selectByPrimaryKey(applyId)) {
                return ;
            }
            ProcessStatus status = processStatusMapper.selectByPrimaryKey(applyId);
            status.setStatus(PROCESS_STATUS_INIT);
            processStatusMapper.updateByPrimaryKey(status);
            runtimeService.deleteProcessInstance(task.getProcessInstanceId(),"用户撤回申请信息!");//删除流程
            throw new RuntimeException("用户撤回申请信息!");
            
        }else{
            taskService.claim(taskId, null);
        }
        /*
         else if(activity.getId().equals(LinkName.ONLINE_TRAINING.getTypeName())||activity.getId().equals(LinkName.REPORT_CHECK.getTypeName())||activity.getId().equals(LinkName.USER_TRAINING.getTypeName())){
            throw new RuntimeException("当前环节不能取消任务!");
         }
         * */
    }
    
    @Override
    public Integer completeTask(String taskId, Map<String, Object> variables) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        Authentication.setAuthenticatedUserId((String)variables.get("uid"));//设置办理人
        int num = taskService.getTaskComments(taskId).size();//得到当前任务批注的数量
        
        if(num < 1){
            taskService.addComment(taskId, task.getProcessInstanceId(), "没有审批信息");
        }
        
        if (!CollectionUtils.isEmpty(variables)) {
            taskService.complete(taskId, variables);
        } else {
            taskService.complete(taskId);
        }
        
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId()).singleResult();
        
        if (null == processStatusMapper.selectByPrimaryKey((String)variables.get("applyId"))) {
            return -1;
        }
        ProcessStatus status = processStatusMapper.selectByPrimaryKey((String)variables.get("applyId"));
        
        // 流程结束
        if (processInstance == null) {
            status.setStatus(PROCESS_STATUS_END);
            processStatusMapper.updateByPrimaryKey(status);
            return 1;
        } 
        
        status.setStatus(getHisTaskName(processInstance.getId()));
        processStatusMapper.updateByPrimaryKey(status);
        
        return 0;
    }

    @Override
    public byte[] viewPic(String processInstanceId) throws IOException {
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
        
        if (CollectionUtils.isEmpty(tasks)){
            throw new IllegalArgumentException("任务不存在！");
        }
        
        BpmnModel bpmnModel = repositoryService.getBpmnModel(tasks.get(0).getProcessDefinitionId());
        List<String> activeActivityIds = new ArrayList<>();
        List<String> finishedActiveActivityIds = new ArrayList<>();
        List<HistoricActivityInstance> finishedInstances = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId).finished().list();
        
        for (HistoricActivityInstance hai : finishedInstances) {
            finishedActiveActivityIds.add(hai.getActivityId());
        }
        
        activeActivityIds.addAll(finishedActiveActivityIds);
        activeActivityIds.addAll(runtimeService.getActiveActivityIds(processInstanceId));
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
                .getProcessDefinition(tasks.get(0).getProcessDefinitionId());
        
        List<String> highLightedFlows = new ArrayList<>();
        getHighLightedFlows(processDefinitionEntity.getActivities(), highLightedFlows, activeActivityIds);
        ProcessDiagramGenerator pdg = processEngineConfiguration.getProcessDiagramGenerator();
        InputStream inputStream = pdg.generateDiagram(bpmnModel, "PNG", finishedActiveActivityIds, highLightedFlows,
                processEngineConfiguration.getProcessEngineConfiguration().getActivityFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getLabelFontName(), tasks.get(0).getId(),
                processEngineConfiguration.getProcessEngineConfiguration().getProcessEngineConfiguration().getClassLoader(),1.0);
        
        return IOUtils.toByteArray(inputStream);
    }
    
    @Override
    public byte[] historyViewPic(String processInstanceId) throws IOException {
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
        
        if (CollectionUtils.isEmpty(tasks)){
            String processDefinitionId = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();
            
            BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
            List<String> activeActivityIds = new ArrayList<>();
            List<String> finishedActiveActivityIds = new ArrayList<>();
            List<HistoricActivityInstance> finishedInstances = historyService.createHistoricActivityInstanceQuery()
                    .processInstanceId(processInstanceId).finished().list();
            for (HistoricActivityInstance hai : finishedInstances) {
                finishedActiveActivityIds.add(hai.getActivityId());
            }
            activeActivityIds.addAll(finishedActiveActivityIds);
            activeActivityIds.addAll(finishedActiveActivityIds);
            ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
                    .getProcessDefinition(processDefinitionId);
            
            List<String> highLightedFlows = new ArrayList<>();
            getHighLightedFlows(processDefinitionEntity.getActivities(), highLightedFlows, activeActivityIds);
            ProcessDiagramGenerator pdg = processEngineConfiguration.getProcessDiagramGenerator();
            InputStream inputStream = pdg.generateDiagram(bpmnModel, "PNG", finishedActiveActivityIds, highLightedFlows,
                    processEngineConfiguration.getProcessEngineConfiguration().getActivityFontName(),
                    processEngineConfiguration.getProcessEngineConfiguration().getLabelFontName(), processDefinitionId,
                    processEngineConfiguration.getProcessEngineConfiguration().getProcessEngineConfiguration().getClassLoader(),1.0);
            
            return IOUtils.toByteArray(inputStream);
        }
            
        BpmnModel bpmnModel = repositoryService.getBpmnModel(tasks.get(0).getProcessDefinitionId());
        List<String> activeActivityIds = new ArrayList<>();
        List<String> finishedActiveActivityIds = new ArrayList<>();
        List<HistoricActivityInstance> finishedInstances = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId).finished().list();
        for (HistoricActivityInstance hai : finishedInstances) {
            finishedActiveActivityIds.add(hai.getActivityId());
        }
        activeActivityIds.addAll(finishedActiveActivityIds);
        activeActivityIds.addAll(runtimeService.getActiveActivityIds(processInstanceId));
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(tasks.get(0).getProcessDefinitionId());
        
        List<String> highLightedFlows = new ArrayList<>();
        getHighLightedFlows(processDefinitionEntity.getActivities(), highLightedFlows, activeActivityIds);
        ProcessDiagramGenerator pdg = processEngineConfiguration.getProcessDiagramGenerator();
        InputStream inputStream = pdg.generateDiagram(bpmnModel, "PNG", finishedActiveActivityIds, highLightedFlows,
                processEngineConfiguration.getProcessEngineConfiguration().getActivityFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getLabelFontName(), tasks.get(0).getId(),
                processEngineConfiguration.getProcessEngineConfiguration().getProcessEngineConfiguration().getClassLoader(),1.0);
        
        return IOUtils.toByteArray(inputStream);
    }

    @Override
    public List<FinishTaskEntity> findHandledtasksInfo(String bustype, String currentUsername, int pageNum, int pageSize) {
        List<FinishTaskEntity> list = new ArrayList<>();
        List<HistoricTaskInstance> hpiList = historyService.createHistoricTaskInstanceQuery()
                .processInstanceBusinessKeyLike("%" + bustype + "%")
                .taskAssignee(currentUsername).finished().orderByHistoricTaskInstanceEndTime().desc()
                .listPage((pageNum-1)*pageSize, pageSize);
        
        if (!CollectionUtils.isEmpty(hpiList)) {
            for (HistoricTaskInstance temp : hpiList) {
                FinishTaskEntity entity = new FinishTaskEntity();
                entity.setId(temp.getProcessInstanceId());
                entity.setApplyName(repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
                entity.setName(temp.getName());
                entity.setProcessDefinitionId(temp.getProcessDefinitionId());
                entity.setStartTime(temp.getStartTime());
                entity.setEndTime(temp.getEndTime());
                
                HistoricProcessInstance hisMember = historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(temp.getProcessInstanceId()).singleResult();
                
                if(null == hisMember){
                    continue;
                }
                
                entity.setUsername(hisMember.getStartUserId());
                String key = hisMember.getBusinessKey();
                String bid = "";
                
                if (StringUtils.isNotBlank(key)) {
                    bid = key.split("\\.")[1];
                }
                
                if (null == processStatusMapper.selectByPrimaryKey(bid)) {
                    continue;
                }
                
                entity.setApplyId(bid);
                entity.setBsname(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getName():"");
                entity.setFormKey(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getFormkey():"");
                list.add(entity);
            }
        }
        
        return list;
    }

    @Override
    public long getHandledtasksInfoCount(String bustype, String currentUsername) {
        List<FinishTaskEntity> list = new ArrayList<>();
        List<HistoricTaskInstance> hpiList = historyService.createHistoricTaskInstanceQuery()
                .processInstanceBusinessKeyLike("%" + bustype + "%")
                .taskAssignee(currentUsername).finished().list();
        
        if (!CollectionUtils.isEmpty(hpiList)) {
            for (HistoricTaskInstance temp : hpiList) {
                FinishTaskEntity entity = new FinishTaskEntity();
                entity.setId(temp.getProcessInstanceId());
                entity.setApplyName(repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
                entity.setName(temp.getName());
                entity.setProcessDefinitionId(temp.getProcessDefinitionId());
                entity.setStartTime(temp.getStartTime());
                entity.setEndTime(temp.getEndTime());
                
                HistoricProcessInstance hisMember = historyService.createHistoricProcessInstanceQuery()
                        .processInstanceId(temp.getProcessInstanceId()).singleResult();
                
                if(null == hisMember){
                    continue;
                }
                
                entity.setUsername(hisMember.getStartUserId());
                String key = hisMember.getBusinessKey();
                String bid = "";
                
                if (StringUtils.isNotBlank(key)) {
                    bid = key.split("\\.")[1];
                }
                
                if (null == processStatusMapper.selectByPrimaryKey(bid)) {
                    continue;
                }
                
                entity.setApplyId(bid);
                entity.setBsname(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getName():"");
                entity.setFormKey(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getFormkey():"");
                list.add(entity);
            }
        }
        
        return list.size();
    }
    

    @Override
    public List<FinishTaskEntity> findMyHitoryInfo(String currentUsername, int pageNum, int pageSize) {
        List<FinishTaskEntity> list = new ArrayList<>();
        List<HistoricProcessInstance> hpiList = historyService.createHistoricProcessInstanceQuery().finished().orderByProcessInstanceEndTime().desc()
                .startedBy(currentUsername).listPage((pageNum-1)*pageSize, pageSize);
        
        if (!CollectionUtils.isEmpty(hpiList)) {
            for (HistoricProcessInstance temp : hpiList) {
                FinishTaskEntity entity = new FinishTaskEntity();
                entity.setId(temp.getId());
                entity.setApplyName(repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
                entity.setName(temp.getEndTime()!=null?"任务结束":getHisTaskName(temp.getId()));
                entity.setDeploymentId(temp.getDeploymentId());
                entity.setProcessDefinitionId(temp.getProcessDefinitionId());
                entity.setProcessDefinitionKey(temp.getProcessDefinitionKey());
                entity.setStartTime(temp.getStartTime());
                entity.setEndTime(temp.getEndTime());
                entity.setUsername(temp.getStartUserId());
                String key = temp.getBusinessKey();
                String bid = "";
                
                if (StringUtils.isNotBlank(key)) {
                    bid = key.split("\\.")[1];
                }
                
                entity.setApplyId(bid);
                
                if (null == processStatusMapper.selectByPrimaryKey(bid)) {
                    continue;
                }
                
                entity.setFormKey(processStatusMapper.selectByPrimaryKey(bid).getFormkey());
                entity.setBsname(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getName():"");
                list.add(entity);
            }
        }
        
        return list;
    }

    @Override
    public long getMyHitoryInfoCount(String currentUsername) {
        List<FinishTaskEntity> list = new ArrayList<>();
        List<HistoricProcessInstance> hpiList = historyService.createHistoricProcessInstanceQuery().finished().orderByProcessInstanceEndTime().desc()
                .startedBy(currentUsername).list();
        
        if (!CollectionUtils.isEmpty(hpiList)) {
            for (HistoricProcessInstance temp : hpiList) {
                FinishTaskEntity entity = new FinishTaskEntity();
                entity.setId(temp.getId());
                entity.setApplyName(repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
                entity.setName(temp.getEndTime()!=null?"任务结束":getHisTaskName(temp.getId()));
                entity.setDeploymentId(temp.getDeploymentId());
                entity.setProcessDefinitionId(temp.getProcessDefinitionId());
                entity.setProcessDefinitionKey(temp.getProcessDefinitionKey());
                entity.setStartTime(temp.getStartTime());
                entity.setEndTime(temp.getEndTime());
                entity.setUsername(temp.getStartUserId());
                String key = temp.getBusinessKey();
                String bid = "";
                
                if (StringUtils.isNotBlank(key)) {
                    bid = key.split("\\.")[1];
                }
                
                entity.setApplyId(bid);
                
                if (null == processStatusMapper.selectByPrimaryKey(bid)) {
                    continue;
                }
                
                entity.setFormKey(processStatusMapper.selectByPrimaryKey(bid).getFormkey());
                entity.setBsname(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getName():"");
                list.add(entity);
            }
        }
        
        return list.size();
    }

    @Override
	public List<CommentPojo> findCommentByTaskId(String taskId) {
    	List<CommentPojo> list = new ArrayList<>();
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        
        List<Comment> comlist = taskService.getProcessInstanceComments(task.getProcessInstanceId());
        for (Comment temp : comlist) {
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
	public void commentTask(String taskId, Map<String, Object> map) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        Authentication.setAuthenticatedUserId((String)map.get("uid"));//设置办理人
        int num = taskService.getTaskComments(taskId).size();//得到当前任务批注的数量
        
        List<Comment> commentList = taskService.getTaskComments(taskId);
        if(num < 1){
            taskService.addComment(taskId, task.getProcessInstanceId(), (String) map.get("msg"));
        }else{
            taskService.deleteComment(commentList.get(0).getId());
            taskService.addComment(taskId, task.getProcessInstanceId(), (String) map.get("msg"));
        }
	}

	@Override
    public List<FileManage> filesByKey(String key) {
        FileManageMemberExample fileManageMemberExample = new FileManageMemberExample();
        fileManageMemberExample.createCriteria().andBusinessIdEqualTo(key);
        List<FileManageMember> fileManageMembers = fileManageMemberMapper.selectByExample(fileManageMemberExample);
        
        if(fileManageMembers.isEmpty()){
            return Collections.emptyList();
        }
        
        List<Integer> ids = new ArrayList<>();
        
        for(FileManageMember member : fileManageMembers){
            ids.add(member.getFileManageId());
        }
        
        FileManageExample fileManageExample = new FileManageExample();
        fileManageExample.createCriteria().andIdIn(ids);
        fileManageExample.setOrderByClause("id asc");
        return fileManageMapper.selectByExample(fileManageExample);
    }
    
    

    @Override
    public List<FinishTaskEntity> findUnFinishTaskInfo(String currentUsername, int pageNum, int pageSize) {
        List<FinishTaskEntity> list = new ArrayList<>();
        List<HistoricProcessInstance> hpiList = historyService.createHistoricProcessInstanceQuery().unfinished().orderByProcessInstanceStartTime().desc()
                .startedBy(currentUsername).listPage((pageNum-1)*pageSize, pageSize);
        
        if (!CollectionUtils.isEmpty(hpiList)) {
            for (HistoricProcessInstance temp : hpiList) {
                FinishTaskEntity entity = new FinishTaskEntity();
                entity.setId(temp.getId());
                entity.setApplyName(repositoryService.getProcessDefinition(temp.getProcessDefinitionId()).getName());
                entity.setName(temp.getEndTime()!=null?"任务结束":getHisTaskName(temp.getId()));
                entity.setDeploymentId(temp.getDeploymentId());
                entity.setProcessDefinitionId(temp.getProcessDefinitionId());
                entity.setProcessDefinitionKey(temp.getProcessDefinitionKey());
                entity.setStartTime(temp.getStartTime());
                entity.setEndTime(temp.getEndTime());
                entity.setUsername(temp.getStartUserId());
                String key = temp.getBusinessKey();
                String bid = "";
                
                if (StringUtils.isNotBlank(key)) {
                    bid = key.split("\\.")[1];
                }
                
                entity.setApplyId(bid);
                
                if (null == processStatusMapper.selectByPrimaryKey(bid)) {
                    continue;
                }
                
                entity.setFormKey(processStatusMapper.selectByPrimaryKey(bid).getFormkey());
                entity.setBsname(processStatusMapper.selectByPrimaryKey(bid)!=null?processStatusMapper.selectByPrimaryKey(bid).getName():"");
                list.add(entity);
            }
        }
        return list;
    }

    @Override
    public long getUnFinishTaskInfoCount(String currentUsername) {
        
        return historyService.createHistoricProcessInstanceQuery().unfinished().startedBy(currentUsername).count();
    }

    private String getApplyId(Task task){
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId())
                .singleResult();
        String key = pi.getBusinessKey();
        String id = "";
        if (StringUtils.isNotBlank(key)) {
            id = key.split("\\.")[1];
        }
        return id;
    }
    private void getHighLightedFlows(List<ActivityImpl> activityList,
            List<String> highLightedFlows,
            List<String> historicActivityInstanceList) {

        for (ActivityImpl activity : activityList) {
            if (activity.getProperty("type").equals("subProcess")) {
                getHighLightedFlows(activity.getActivities(), highLightedFlows, historicActivityInstanceList);
            }

            if (historicActivityInstanceList.contains(activity.getId())) {
                List<PvmTransition> pvmTransitionList = activity.getOutgoingTransitions();
                for (PvmTransition pvmTransition : pvmTransitionList) {
                    String destinationFlowId = pvmTransition.getDestination().getId();
                    if (historicActivityInstanceList.contains(destinationFlowId)) {
                        highLightedFlows.add(pvmTransition.getId());
                    }
                }
            }
        }
    }
    private String getHisTaskName(String id){
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(id).list();
        
        String getHisTaskName = "";
        for(int i = 0 ; i < tasks.size(); i++){
        	
            if(i!=tasks.size()-1){
                getHisTaskName += tasks.get(i).getName()+',';
            }else{
                getHisTaskName += tasks.get(i).getName();
            }
        }
        
        return getHisTaskName;
    }
    
    private ActivityImpl findActivitiImpl(String taskId, String activityId) throws Exception {  
        TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {  
            throw new Exception("任务实例未找到!");  
        }
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity)((RepositoryServiceImpl) repositoryService)  
                .getDeployedProcessDefinition(task.getProcessDefinitionId());  
        if (processDefinition == null) {  
            throw new Exception("流程定义未找到!");  
        }  
        // 获取当前活动节点ID  
        if (activityId == null) {  
            activityId = task.getTaskDefinitionKey();  
        }  
        // 根据流程定义，获取该流程实例的结束节点  
        if (activityId.toUpperCase().equals(PROCESS_END_NAME)) {  
            for (ActivityImpl activityImpl : processDefinition.getActivities()) {  
                List<PvmTransition> pvmTransitionList = activityImpl  
                        .getOutgoingTransitions();  
                if (pvmTransitionList.isEmpty()) {  
                    return activityImpl;  
                }  
            }  
        }  
        // 根据节点ID，获取对应的活动节点  
        ActivityImpl activityImpl =  processDefinition.findActivity(activityId);  
  
        return activityImpl;  
    }  
}
