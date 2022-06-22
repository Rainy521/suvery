package com.lwch.survey.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.Config;
import com.lwch.survey.model.FileManage;
import com.lwch.survey.pojo.CommentPojo;
import com.lwch.survey.pojo.FinishTaskEntity;
import com.lwch.survey.pojo.ProcessDefEntity;
import com.lwch.survey.pojo.TaskInfoEntity;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.ProcessWorkService;
import com.lwch.survey.utils.DownloadUtils;

/**
 * 
 * controller: 工作流相关
 * 
 * @author zhangdq
 * 
 * @since 2017-11-13
 * 
 * @version 1.0
 * 
 */
@RestController
@RequestMapping("/workFlow")
public class WorkFlowController {

    @Autowired
    private ProcessWorkService processWorkService;

    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private ConfigService configService;
    
    /**
     * 查询所有流程定义信息
     * @throws UnsupportedEncodingException
     */
    @GetMapping
    public List<ProcessDefEntity> getAllFlowDep() {
        
        return processWorkService.findProcessDefinition();
    }

    /**
     * 部署流程
     * 
     * @param deployName
     * @param classPathBpmn
     * @param classPathPng
     * @return
     */
    @GetMapping("/deployQuery")
    public Deployment getDeployQuery(@RequestParam(required = false) String deployName) {
        
        return processWorkService.deployClasspath(deployName);
    }
    
    /**
     * 根据部署id删除部署信息
     * 
     * @param deploymentId
     */
    @GetMapping("/deleteDeloy")
    public void getDeleteDeploy(@RequestParam(required = false) String deploymentId) {
        
        processWorkService.deleteProcessDefinitionByKey(deploymentId);
    }
    
    /**
     * 部署所有流程
     * @param arr  void
     * @throws Exception 
     */
    @GetMapping("/deployAllFlows")
    public void deployAllFlows() throws Exception {
        
        String configPrefix ="workflow.process.name";
        List<Config> configs = configService.selectConfigs(configPrefix);
        if(configs.isEmpty()){
            throw new Exception("请完善通用配置-流程名称填写");
        }
        
        String[] strs = configs.get(0).getValue().split(",");
        for(String member : strs){
            processWorkService.deployClasspath(member);
        }
    }
    
    /**
     * 删除所有部署信息
     * 
     * @param deploymentId
     */
    @GetMapping("/delAllDeloy")
    public void getDeleteDeploys() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        if(list.isEmpty()){
            throw new RuntimeException("当前没有部署的流程！");
        }
        for(ProcessDefinition member : list){
            processWorkService.deleteProcessDefinitionByKey(member.getDeploymentId());
        }
    }
    
    /**
     * 启动流程
     * 
     * @param businessId
     * @param key
     * @return
     */
    @GetMapping("/startProcessFlow")
    public String startProcessFlow(@RequestParam(required = false) String applyBid,
            @RequestParam(required = false) String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        
        Map<String, Object> variable = new HashMap<>();
        variable.put("userId", Utils.getCurrentUsername());// 设置流程变量，可以指定办理人
        variable.put("applyBid", applyBid);
        ProcessInstance pi = processWorkService.startProcessByKey(key, variable);
        
        return pi.getId();
    }
    
    /**
     * 查询待接收的任务
     * 
     * @param businessId
     * @param key
     * @return
     */
    @GetMapping("/queryReceiveTasks")
    public List<TaskInfoEntity> queryRunTask(@RequestParam(required=false, defaultValue="1") int pageNum
            ,@RequestParam(required=false, defaultValue="10") int pageSize) {
        return processWorkService.queryReceiveTasks(Utils.getCurrentUsername(),pageNum,pageSize);
    }
    
    /**
     * 查询待接收的任务数量
     * @return
     */
    @GetMapping("/queryReceiveTasks/count")
    public long getRunTaskCount() {
        return processWorkService.getReceiveTasksCount(Utils.getCurrentUsername());
    }
    
    /**
     * 查询个人任务
     * 
     * @param businessId
     * @param key
     * @return
     */
    @GetMapping("/queryMyRunTask")
    public List<TaskInfoEntity> queryMyRunTask(@RequestParam(required=false) String key
            ,@RequestParam(required=false, defaultValue="1") int pageNum
            ,@RequestParam(required=false, defaultValue="10") int pageSize) {
        return processWorkService.queryMyRunTask(key,Utils.getCurrentUsername(),pageNum,pageSize);
    }
    
    /**
     * 查询个人任务数量
     * 
     * @param businessId
     * @param key
     * @return
     */
    @GetMapping("/queryMyRunTask/count")
    public long getMyRunTaskCount(@RequestParam(required=false) String key) {
        return processWorkService.getMyRunTaskCount(key,Utils.getCurrentUsername());
    }
    
    /**
     * 查询已经办理任务
     * @param pageNum
     * @param pageSize
     * @return  List<FinishTaskEntity>
     */
    @GetMapping("/findHandledtasksInfo")
    public List<FinishTaskEntity> findHandledtasksInfo(@RequestParam(required=false) String bustype
            ,@RequestParam(required=false, defaultValue="1") int pageNum
            ,@RequestParam(required=false, defaultValue="10") int pageSize) {
        return processWorkService.findHandledtasksInfo(bustype, Utils.getCurrentUsername(),pageNum,pageSize);
    }
    
    /**
     * 获得已经办理的任务数量
     * @return  long
     */
    @GetMapping("/findHandledtasksInfo/count")
    public long getHandledtasksInfoCount(@RequestParam(required=false) String bustype) {
        return processWorkService.getHandledtasksInfoCount(bustype, Utils.getCurrentUsername());
    }
    
    /**
     * 获得自己已经完成的任务相关信息
     * 
     * @return
     */
    @GetMapping("/findMyHitoryInfo")
    public List<FinishTaskEntity> findMyHitoryInfo(@RequestParam(required=false, defaultValue="1") int pageNum
            ,@RequestParam(required=false, defaultValue="10") int pageSize) {
        return processWorkService.findMyHitoryInfo(Utils.getCurrentUsername(),pageNum,pageSize);
    }
    
    /**
     * 获得自己已经完成的任务数量
     * 
     * @return
     */
    @GetMapping("/findMyHitoryInfo/count")
    public long getMyHitoryInfoCount() {
        return processWorkService.getMyHitoryInfoCount(Utils.getCurrentUsername());
    }
    
    /**
     * 认领任务
     * 
     * @param taskId
     * @param assignee
     */
    @GetMapping("/claimTask")
    public void claimMyTask(@RequestParam(required = false) String taskId) {
        processWorkService.claim(taskId, Utils.getCurrentUsername());
    }
    
    /**
     * 取消任务
     * @param taskId
     * @throws Exception 
     */
    @GetMapping("/deleteCompleTask")
    public void deleteCompleTask(@RequestParam(required = false) String taskId) throws Exception {
        processWorkService.cancelTask(taskId, null);
    }
    
    /**
     * 完成任务
     * 
     * @param taskId
     * @param variable
     */
    @GetMapping("/compleTask")
    public Integer completeTask(@RequestParam(required=false) String taskId
                                            ,@RequestParam(required=false) String variable
                                            ,@RequestParam(required=false) String applyId){
        Map<String, Object> map = new HashMap<>();
        map.put("opinion", variable);
        map.put("applyId", applyId);
        map.put("uid", Utils.getCurrentUsername());

        return processWorkService.completeTask(taskId, map);
    }
    
    @GetMapping("/filesByKey")
    public List<FileManage> filesByKey(@RequestParam(required=false) String key){

        return processWorkService.filesByKey(key);
    }
    
    /**
     * 查询发起人未完成的任务
     * @param pageNum
     * @param pageSize
     * @return  List<FinishTaskEntity>
     */
    @GetMapping("/findUnFinishTaskInfo")
    public List<FinishTaskEntity> findUnFinishTaskInfo(@RequestParam(required=false, defaultValue="1") int pageNum
            ,@RequestParam(required=false, defaultValue="10") int pageSize) {
        return processWorkService.findUnFinishTaskInfo(Utils.getCurrentUsername(),pageNum,pageSize);

    }
    
    /**
     * 获得发起人未完成的任务数量
     * @return  long
     */
    @GetMapping("/findUnFinishTaskInfo/count")
    public long getUnFinishTaskInfoCount() {
        return processWorkService.getUnFinishTaskInfoCount(Utils.getCurrentUsername());

    }
    
    /**
     * 获取批注信息，使用的当前任务id
     */
    @GetMapping("/findCommentByTaskId")
    public List<CommentPojo> findCommentByTaskId(@RequestParam(required = false) String taskId) {
        return processWorkService.findCommentByTaskId(taskId);
    }
    
    /**
     * 添加批注相关信息
     * 
     * @param taskId
     * @param variable
     */
    @GetMapping("/saveCommentTask")
    public void commentTask(@RequestParam(required=false) String taskId
                                            ,@RequestParam(required=false) String msg){
        
        Map<String, Object> map = new HashMap<>();
        map.put("uid", Utils.getCurrentUsername());
        map.put("msg", msg);

        processWorkService.commentTask(taskId, map);
    }

    
    /**
     * 查看流程图
     * @param processInstanceId
     * @param response
     * @throws IOException
     */
    @GetMapping("/{processInstanceId}/viewPic")
    public void viewPic(@PathVariable String processInstanceId, HttpServletResponse response) throws IOException {
        DownloadUtils.download("测试", processWorkService.viewPic(processInstanceId), response);
    }
    
    @GetMapping("/{processInstanceId}/historyViewPic")
    public void historyViewPic(@PathVariable String processInstanceId, HttpServletResponse response) throws IOException {
        DownloadUtils.download("测试", processWorkService.historyViewPic(processInstanceId), response);
    }
    
}
