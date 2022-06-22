package com.lwch.survey.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

import com.lwch.survey.model.FileManage;
import com.lwch.survey.pojo.CommentPojo;
import com.lwch.survey.pojo.FinishTaskEntity;
import com.lwch.survey.pojo.ProcessDefEntity;
import com.lwch.survey.pojo.TaskInfoEntity;

public interface ProcessWorkService {
    
    static final String PROCESS_STATUS_END = "3";
    static final String PROCESS_STATUS_INIT = "0";
    static final String PROCESS_END_NAME = "END";
    static final String RUNTASK_MY_TASK = "alltask";
    
    enum LinkName {
        APPLY_ONLINE("申请");
        /*APPLY_ONLINE("在线申请"),
        REPORT_CHECK("报告查看"),
        USER_TRAINING("用户查看"),
        ONLINE_TRAINING("在线培训");*/
 
        private String typeName;
 
        LinkName(String typeName) {
            this.typeName = typeName;
        }
 
        public String getTypeName() {
            return this.typeName;
        }
        
    }
    
    /**
     * 查询流程定义
     * @return ProcessDefinitionResult 流程定义分结果
     */
    List<ProcessDefEntity> findProcessDefinition();

    /**
     * 部署流程任务，发布流程定义
     * @param map /
     * @return Deployment
     */
    Deployment deployClasspath(String deployNamep);
    
    /**
     * 删除流程定义（删除key相同的所有不同版本的流程定义）
     * @param key 流程定义key
     */
     void deleteProcessDefinitionByKey(String key);
     
     /**
      * 启动流程实例 根据流程定义key启动  ,设置启动时是否设置流程变量
      * @param key 流程启动key
      * @param variables 流程变量
      * @return ProcessInstance 流程实例对象
      */
     ProcessInstance startProcessByKey(String key, Map<String,Object> variables);
     
     /**
      * 查询待接收的任务
      * @param userId 用户ID
      * @param pageNum 页码
      * @param pageSize 每页显示数量
      * @return List 任务对象结合
      */
     List<TaskInfoEntity> queryReceiveTasks(String userId,int pageNum,int pageSize);
     
    /**
     * 查询待接收的任务的数量
     * @param currentUsername
     * @return  long
     */
    long getReceiveTasksCount(String currentUsername);
    
    /**
     * 查询个人任务
     * @param userId 用户ID
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return List 任务对象集合
     */
    List<TaskInfoEntity> queryMyRunTask(String key ,String userId,int pageNum,int pageSize);
    
    /**
     * 查询正在执行任务数量
     * @param currentUsername 用户名
     * @return long
     */
    long getMyRunTaskCount(String key , String currentUsername);
    
    /**
     * 查询已办理业务
     * @param currentUsername
     * @param pageNum
     * @param pageSize
     * @return  List<FinishTaskEntity>
     */
    List<FinishTaskEntity> findHandledtasksInfo(String bustype, String currentUsername, int pageNum, int pageSize);
    
    /**
     * 查询已办理数量
     * @param currentUsername
     * @return  long
     */
    long getHandledtasksInfoCount(String bustype, String currentUsername);
    
    /**
     * 检索交易中心发起流程
     * @param ids
     * @return  List<String>
     */
    List<String> retrievalState();
    
    /**
     * 拾取任务，将组任务分给个人任务，指定任务的办理人字段
     * @param taskId 任务ID
     * @param userId 用户ID
     */
     void claim(String taskId,String userId);
     
     /**
      * 取消任务
      * @param taskId 任务ID
      * @param userId 用户ID
      * @throws Exception 抛异常
      */
     void cancelTask(String taskId, String userId) throws Exception;
     
     /**
      * 完成任务
      * @param taskId
      * @param map
      * @return  Integer
      */
     Integer completeTask(String taskId, Map<String, Object> map);
     
     /**
      * 查看流程图
      * @param processInstanceId 流程ID
      * @return byte[]
      * @throws IOException 抛异常
      */
     byte[] viewPic(String processInstanceId) throws IOException;
     
     /**
      * 历史流程图
      * @param processInstanceId 实例ID
      * @return byte[]
      * @throws IOException 抛异常
      */
     byte[] historyViewPic(String processInstanceId) throws IOException;
     
     /**
      * 根据申请id查找附件目录
      * @param applyId
      * @return  FileManage
      */
     List<FileManage> filesByKey(String applyId);
     
     /**
      * 查询发起人未完成的任务
      * @param currentUsername
      * @param pageNum
      * @param pageSize
      * @return  List<FinishTaskEntity>
      */
     List<FinishTaskEntity> findUnFinishTaskInfo(String currentUsername, int pageNum, int pageSize);
     
     /**
      * 获得发起人未完成的任务数量
      * @param currentUsername
      * @return  long
      */
     long getUnFinishTaskInfoCount(String currentUsername);

    /**
     * 查询发起人已完成任务
     * @param currentUsername
     * @param pageNum
     * @param pageSize
     * @return  List<FinishTaskEntity>
     */
    List<FinishTaskEntity> findMyHitoryInfo(String currentUsername, int pageNum, int pageSize);

    /**
     * 查询发起人已完成任务数量
     * @param currentUsername
     * @return  long
     */
    long getMyHitoryInfoCount(String currentUsername);

    /**
     * 获取批注信息，使用的当前任务id
     * @param taskId
     * @return
     */
	List<CommentPojo> findCommentByTaskId(String taskId);

	/**
	 * 添加批注相关信息
	 * @param taskId
	 * @param map
	 */
	void commentTask(String taskId, Map<String, Object> map);
   
    


}
