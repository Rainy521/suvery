/**
 * 
 */
package com.lwch.survey.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.Ownership;
import com.lwch.survey.service.CommodityHouseService;
import com.lwch.survey.service.HouseService;

/**
 * 报表查看Controller
 * @author Rain
 *
 */
@RestController
@RequestMapping("/journaling")
public class JournalingController {
    
    @Autowired
    private HouseService houseService;
    
    @Autowired
    private CommodityHouseService commodityHouseService;
    
    @GetMapping("/stockroom")
    public List<Ownership> getStockrooms(@RequestParam(required=false) String id,
                                            @RequestParam(required=false) String applicant, 
                                            @RequestParam(required=false) String location,
                                            @RequestParam(required=false) Long startTime,
                                            @RequestParam(required=false) Long endTime) {
        
        return houseService.selectByExampleFrom(startTime, endTime, id, applicant, location);
    }
    
    @GetMapping("/commercial")
    public List<ApplyProject> getCount(@RequestParam(required=false) String query ) {
        Map<String,String> params =new HashMap<>();
        return commodityHouseService.selectByExampleFrom(params);
    }
    
}
