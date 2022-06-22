package com.lwch.survey.utils;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.task.Task;

import com.lwch.survey.model.User;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.model.activiti.ActRuTask;

public class ActivitiUtils {
    public static UserEntity  toActivitiUser(User bUser){  
        UserEntity userEntity = new UserEntity();  
        userEntity.setId(bUser.getUsername());  
        userEntity.setLastName(bUser.getRealname());  
        userEntity.setPassword(bUser.getPassword());  
        userEntity.setRevision(1);  
        return userEntity;  
    }
      
    public static GroupEntity  toActivitiGroup(UserGroup bGroup){  
        GroupEntity groupEntity = new GroupEntity();  
        groupEntity.setRevision(1);  
        groupEntity.setType("assignment");  
  
        groupEntity.setId(String.valueOf(bGroup.getId()));  
        groupEntity.setName(bGroup.getGroupName());  
        return groupEntity;  
    }
    
    public static TaskEntity  toActivitiTask(ActRuTask task){  
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setRevision(task.getRev());
        taskEntity.setExecutionId(task.getExecutionId());
        taskEntity.setProcessInstanceId(task.getProcInstId());
        taskEntity.setProcessDefinitionId(task.getProcDefId());
        taskEntity.setName(task.getName());
        taskEntity.setParentTaskId(task.getParentTaskId());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setTaskDefinitionKey(task.getTaskDefKey());
        taskEntity.setOwner(task.getOwner());
        taskEntity.setAssignee(task.getAssignee());
        taskEntity.setDelegationStateString(task.getDelegation());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setCreateTime(task.getCreateTime());
        taskEntity.setDueDate(task.getDueDate());
        taskEntity.setCategory(task.getCategory());
        taskEntity.setSuspensionState(task.getSuspensionState());
        taskEntity.setTenantId(task.getTenantId());
        taskEntity.setFormKey(task.getFormKey());
        return taskEntity;  
    } 
      
    public static List<org.activiti.engine.identity.Group> toActivitiGroups(List<UserGroup> bGroups){  
          
        List<org.activiti.engine.identity.Group> groupEntitys = new ArrayList<org.activiti.engine.identity.Group>();  
          
        for (UserGroup bGroup : bGroups) {  
            GroupEntity groupEntity = toActivitiGroup(bGroup);  
            groupEntitys.add(groupEntity);  
        }  
        return groupEntitys;  
    }
    
    public static List<Task> toActivitiTask(List<ActRuTask> actRuTasks){
        
        List<Task> taskEntitys = new ArrayList<>();
        for(ActRuTask task : actRuTasks){
            TaskEntity taskEntity = toActivitiTask(task);
            taskEntitys.add(taskEntity);
        }
        return taskEntitys;
    }
}
