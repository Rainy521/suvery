package com.lwch.survey.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.ApplyProjectExample;
import com.lwch.survey.model.Config;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.pojo.StatisticsInfo;
import com.lwch.survey.pojo.StatisticsParam;
import com.lwch.survey.service.CommodityHouseService;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.ProcessCommonService;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/commodityHouse")
public class CommodityHouseController {
    
    @Autowired
    private CommodityHouseService commodityHouseService;
    
    @Autowired
    private ProcessCommonService processCommonService;
    
    @Autowired
    private ConfigService configService;
    
    @GetMapping
    public List<ApplyProject> getApplyProjects(@RequestParam(required=false) String query,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="10") int pageSize) {
        return commodityHouseService.selectByExample(new ApplyProjectExample(), query, Utils.getCurrentUsername() ,new PageParm(pageNum, pageSize, " update_time desc "));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ) {
        return commodityHouseService.getCount(query ,Utils.getCurrentUsername());
    }
    
    @GetMapping("/getPool")
    public List<ApplyProject> getApplyProjectPools(@RequestParam(required=false) String query,
    						   @RequestParam(required=false) String type,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="10") int pageSize) {
        return commodityHouseService.selectPoolByExample(new ApplyProjectExample(), query,type, Utils.getCurrentUsername() ,new PageParm(pageNum, pageSize, " id desc "));
    }
    
    @GetMapping("/Poolcount")
    public long getPoolCount(@RequestParam(required=false) String query ,@RequestParam(required=false) String type) {
        return commodityHouseService.getPoolCount(query,type);
    }
    
    @GetMapping("/selectByApplyId")
    public ApplyProject selectByComanyId(@RequestParam(required=false) String id) {
        return commodityHouseService.selectPrimaryKey(id);
    }
    
    @GetMapping("/configs/systype")
    public List<Config> selectConfig(){
        String configPrefix ="company.aptitude.type";
        return configService.selectConfigs(configPrefix);
    }
    
    @GetMapping("/randomXmbh")
    public String randomXmbh(){
        return processCommonService.generate("FC");
    }
    
    @GetMapping("/statistical/tables")
    public List<StatisticsInfo> statistical(
    		@RequestParam(required=false) String type,
    		@RequestParam(required=false) String activeTab,
    		@RequestParam(required=false) String searchType,
    		@RequestParam(required=false, defaultValue="1") int pageNum, 
            @RequestParam(required=false, defaultValue="15") int pageSize){
    	StatisticsParam param = new StatisticsParam();
    	param.setActiveTab(activeTab);
    	param.setType(type);
    	param.setSearchType(searchType);
        return commodityHouseService.getStatisticaltables(param,new PageParm(pageNum, pageSize, ""));
    }
    
    @GetMapping("/statistical/tables/count")
    public long statisticalCount(@RequestParam(required=false) String type,
    		@RequestParam(required=false) String activeTab,
    		@RequestParam(required=false) String searchType){
    	StatisticsParam param = new StatisticsParam();
    	param.setActiveTab(activeTab);
    	param.setType(type);
    	param.setSearchType(searchType);
        return commodityHouseService.getTablesCount(param);
    }
    
    @GetMapping("/statisticalPie")
    public Map<String,ResponseObject> statisticalPie(@RequestParam(required=false) String chlx){
    	
        return commodityHouseService.statisticalPie(chlx);
    }
    
}
