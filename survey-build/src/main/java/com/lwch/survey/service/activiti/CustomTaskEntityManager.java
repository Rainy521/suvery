package com.lwch.survey.service.activiti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.TaskQueryImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManager;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.lwch.survey.dao.mapper.GroupMemberMapper;
import com.lwch.survey.dao.mapper.activiti.ActRuIdentitylinkMapper;
import com.lwch.survey.dao.mapper.activiti.ActRuTaskMapper;
import com.lwch.survey.model.GroupMember;
import com.lwch.survey.model.GroupMemberExample;
import com.lwch.survey.model.activiti.ActRuIdentitylinkExample;
import com.lwch.survey.model.activiti.ActRuTask;
import com.lwch.survey.model.activiti.ActRuTaskExample;
import com.lwch.survey.utils.ActivitiUtils;

@Service
public class CustomTaskEntityManager extends TaskEntityManager{
    
    @Autowired
    private ActRuTaskMapper actRuTaskMapper;
    
    @Autowired
    private ActRuIdentitylinkMapper actRuIdentitylinkMapper;
    
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    
    @Override
    public void deleteTasksByProcessInstanceId(String processInstanceId, String deleteReason, boolean cascade) {
        super.deleteTasksByProcessInstanceId(processInstanceId, deleteReason, cascade);
    }

    @Override
    public void deleteTask(TaskEntity task, String deleteReason, boolean cascade) {
        super.deleteTask(task, deleteReason, cascade);
    }

    @Override
    public TaskEntity findTaskById(String id) {
        return super.findTaskById(id);
    }

    @Override
    public List<TaskEntity> findTasksByExecutionId(String executionId) {
        return super.findTasksByExecutionId(executionId);
    }

    @Override
    public List<TaskEntity> findTasksByProcessInstanceId(String processInstanceId) {
        return super.findTasksByProcessInstanceId(processInstanceId);
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<Task> findTasksByQueryCriteria(TaskQueryImpl taskQuery, Page page) {
        return super.findTasksByQueryCriteria(taskQuery, page);
    }

    @Override
    public List<Task> findTasksByQueryCriteria(TaskQueryImpl taskQuery) {
        ActRuTaskExample taskExample = new ActRuTaskExample();
        
        if(taskQuery.getCandidateUser() != null){
            taskExample = assembleTaskCandidateUser(taskQuery);
        }
        if(taskQuery.getAssignee() != null){
            taskExample = assembleTaskAssignee(taskQuery);
        }
        if(taskQuery.getCandidateGroup() != null){
            taskExample = assembleTaskCandidateGroupIn(taskQuery);
        }
        if(taskQuery.getOwner() != null){
            taskExample = assembleTaskOwner(taskQuery);
        }
        if(taskQuery.getProcessDefinitionKey() != null){
            taskExample = assembleProcessDefinitionKeyTask(taskQuery);
        }
        if(taskQuery.getFirstResult() > 0) {
            PageHelper.startPage(taskQuery.getFirstResult(), taskQuery.getMaxResults());
        }
        /*if(taskQuery.getUserIdForCandidateAndAssignee() != null){
            taskExample = assembleTaskCandidateOrAssigned(taskQuery);
        }*/
        if(StringUtils.isNotBlank(taskQuery.getTaskId())){
            taskExample = assembleTaskId(taskQuery);
        }
        if(StringUtils.isNoneBlank(taskQuery.getProcessInstanceId())){
            taskExample = assembleProcessInstanceId(taskQuery);
        }
        
        if(taskExample == null){
            return Collections.emptyList();
        }
        
        if(StringUtils.isNotBlank(taskQuery.getOrderBy())){
            taskExample.setOrderByClause(StringUtils.substring(taskQuery.getOrderBy(), 4));
        }
                
        List<ActRuTask> actRuTasks = actRuTaskMapper.selectByExample(taskExample);
        List<Task> tasks = new ArrayList<>();
        if(!CollectionUtils.isEmpty(actRuTasks)){
            for(ActRuTask task : actRuTasks){
                tasks.add(ActivitiUtils.toActivitiTask(task));
            }
        }
        
        return tasks;
    }

    @Override
    public List<Task> findTasksAndVariablesByQueryCriteria(TaskQueryImpl taskQuery) {
        return super.findTasksAndVariablesByQueryCriteria(taskQuery);
    }

    @Override
    public long findTaskCountByQueryCriteria(TaskQueryImpl taskQuery) {
        return super.findTaskCountByQueryCriteria(taskQuery);
    }

    @Override
    public List<Task> findTasksByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        return super.findTasksByNativeQuery(parameterMap, firstResult, maxResults);
    }

    @Override
    public long findTaskCountByNativeQuery(Map<String, Object> parameterMap) {
        return super.findTaskCountByNativeQuery(parameterMap);
    }

    @Override
    public List<Task> findTasksByParentTaskId(String parentTaskId) {
        return super.findTasksByParentTaskId(parentTaskId);
    }

    @Override
    public void deleteTask(String taskId, String deleteReason, boolean cascade) {
        super.deleteTask(taskId, deleteReason, cascade);
    }

    @Override
    public void updateTaskTenantIdForDeployment(String deploymentId, String newTenantId) {
        super.updateTaskTenantIdForDeployment(deploymentId, newTenantId);
    }
    
    /*private ActRuTaskExample assembleTaskCandidateOrAssigned(TaskQueryImpl taskQuery){
        return null;
    }*/

    /**
     * 待接收任务
     * @return
     */
    private ActRuTaskExample assembleTaskCandidateUser(TaskQueryImpl taskQuery){
        
        ActRuTaskExample taskExample = new ActRuTaskExample();
        GroupMemberExample memberExample = new GroupMemberExample();
        
        memberExample.createCriteria().andUsernameEqualTo(taskQuery.getCandidateUser());
        List<GroupMember> members = groupMemberMapper.selectByExample(memberExample);
        
        ActRuIdentitylinkExample linkExample = new ActRuIdentitylinkExample();
        ActRuIdentitylinkExample.Criteria linkCriteria = linkExample.createCriteria();
        ActRuIdentitylinkExample.Criteria linkOrCriteria = linkExample.createCriteria();
        
        if(!CollectionUtils.isEmpty(members)){
            linkCriteria.andTypeEqualTo("candidate").andGroupIdIn(members.stream().map(member -> String.valueOf(member.getGroupId())).collect(Collectors.toList()));
            linkOrCriteria.andTypeEqualTo("candidate").andUserIdEqualTo(taskQuery.getCandidateUser());
            linkExample.or(linkOrCriteria);
        }else {
            linkCriteria.andUserIdEqualTo(taskQuery.getCandidateUser());
        }
        
        List<String> ids = actRuIdentitylinkMapper.selectByExample(linkExample).stream().map(link -> link.getTaskId()).collect(Collectors.toList());
        
        if(CollectionUtils.isEmpty(ids)){
            return null;
        }
        
        taskExample.createCriteria().andIdIn(ids).andAssigneeIsNull();
        taskExample.setDistinct(true);
        
        return taskExample;
    }
    
    /**
     * 个人任务
     * @return
     */
    private ActRuTaskExample assembleTaskAssignee(TaskQueryImpl taskQuery){
        ActRuTaskExample taskExample = new ActRuTaskExample();
        taskExample.createCriteria().andAssigneeEqualTo(taskQuery.getAssignee());
        taskExample.setDistinct(true);
        return taskExample;
    }
    
    private ActRuTaskExample assembleTaskCandidateGroupIn(TaskQueryImpl taskQuery){
        ActRuTaskExample taskExample = new ActRuTaskExample();
        ActRuIdentitylinkExample linkExample = new ActRuIdentitylinkExample();
        
        if(CollectionUtils.isEmpty(taskQuery.getCandidateGroups())){
            taskQuery.getCandidateGroups().add(taskQuery.getCandidateGroup());
        }
        
        linkExample.createCriteria().andTypeEqualTo("candidate").andGroupIdIn(taskQuery.getCandidateGroups());
        List<String> taskIds = actRuIdentitylinkMapper.selectByExample(linkExample).stream().map(task -> task.getTaskId()).collect(Collectors.toList());
        
        if(CollectionUtils.isEmpty(taskIds)){
            return null;
        }
        
        taskExample.createCriteria().andIdIn(taskIds).andAssigneeIsNull();
        taskExample.setDistinct(true);
        
        return taskExample;
        
    }
    
    private ActRuTaskExample assembleTaskOwner(TaskQueryImpl taskQuery){
        ActRuTaskExample taskExample = new ActRuTaskExample();
        taskExample.createCriteria().andOwnerEqualTo(taskQuery.getOwner());
        return taskExample;
    }
    
    private ActRuTaskExample assembleProcessDefinitionKeyTask(TaskQueryImpl taskQuery){
        ActRuTaskExample taskExample = new ActRuTaskExample();
        taskExample.createCriteria().andProcDefIdLike(taskQuery.getProcessDefinitionKey()).andAssigneeEqualTo(taskQuery.getAssignee());
        taskExample.setDistinct(true);
        return taskExample;
    }
    
    private ActRuTaskExample assembleTaskId(TaskQueryImpl taskQuery){
        ActRuTaskExample taskExample = new ActRuTaskExample();
        taskExample.createCriteria().andIdEqualTo(taskQuery.getTaskId());
        return taskExample;
    }
    
    private ActRuTaskExample assembleProcessInstanceId(TaskQueryImpl taskQuery){
        ActRuTaskExample taskExample = new ActRuTaskExample();
        taskExample.createCriteria().andProcInstIdEqualTo(taskQuery.getProcessInstanceId());
        return taskExample;
    }
}
