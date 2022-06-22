/**
 * 
 */
package com.lwch.survey.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Config;
import com.lwch.survey.model.FileManage;
import com.lwch.survey.model.FileManageExample;
import com.lwch.survey.model.FileManageMember;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.FileManageService;

/**
 * 附件管理Controller
 * @author Rain
 *
 */
@RestController
@RequestMapping("/annex")
public class AnnexController {
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private FileManageService fileManageService;
    
    @GetMapping
    public List<FileManage> getUsers(@RequestParam(required=false) String query,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="10") int pageSize) {
        return fileManageService.selectByExample(new FileManageExample(), query, new PageParm(pageNum, pageSize, "id asc, file_name asc"));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ) {
        return fileManageService.getCount(query);
    }
    
    @GetMapping("/selectByAnnexId")
    public FileManage selectByComanyId(@RequestParam(required=false) Integer id) {
        return fileManageService.selectPrimaryKey(id);
    }
    
    @GetMapping("/configs/fileType")
    public List<Config> selectConfig(){
        String configPrefix ="annexmanage.file.type";
        return configService.selectConfigs(configPrefix);
    }
    
    @GetMapping("/business")
    public List<FileManageMember> selectByfileId(@RequestParam(required=false) Integer id) {
        return fileManageService.selectByfileId(id);
    }
    
    @GetMapping("/query/byBusinessId")
    public ResponseObject queryByBusinessId(@RequestParam(required=false) String businessId,
    		@RequestParam(required=false, defaultValue="1") int pageNum, 
            @RequestParam(required=false, defaultValue="10") int pageSize) {
        return fileManageService.queryByBusinessId(businessId,new PageParm(pageNum, pageSize, ""));
    }
    
    @GetMapping("/filemanageIds")
    public Map<String, String> getbusIds(){
        return fileManageService.getbusIds();
    }
}
