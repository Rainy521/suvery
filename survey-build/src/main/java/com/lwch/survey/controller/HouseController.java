/**
 * 
 */
package com.lwch.survey.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.Config;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.Ownership;
import com.lwch.survey.model.OwnershipExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {
    
    @Autowired
    private HouseService houseService;
    
    @Autowired
    private ConfigService configService;

    @GetMapping
    public List<Ownership> getUsers(@RequestParam(required=false) String id,
                                    @RequestParam(required=false) String name,
                                    @RequestParam(required=false) String certificate,
                                    @RequestParam(required=false) String location,
                                    @RequestParam(required=false, defaultValue="1") int pageNum, 
                                    @RequestParam(required=false, defaultValue="10") int pageSize) {
        Map<String,String> map = new HashedMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("certificate", certificate);
        map.put("location", location);
        map.put("currentUsername", Utils.getCurrentUsername());
        return houseService.selectByExample(new OwnershipExample(), map, new PageParm(pageNum, pageSize, " update_time desc "));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String id,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String certificate,
            @RequestParam(required=false) String location ) {
        Map<String,String> map = new HashedMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("certificate", certificate);
        map.put("location", location);
        map.put("currentUsername", Utils.getCurrentUsername());
        return houseService.getCount(map);
    }
    
    @GetMapping("/selectByHouseid")
    public Ownership selectByComanyId(@RequestParam(required=false) String id) {
        return houseService.selectPrimaryKey(id);
    }
    
    @GetMapping("/file/id")
    public TreeMap<Integer, List<FileTypeApplyMember>> getbusIds(@RequestParam(required=false) String applyid){
        return houseService.getFileIds(applyid);
    }
    
    @GetMapping("/configs/systype")
    public List<Config> selectConfig(@RequestParam(required=false) String configPrefix){
        return configService.selectConfigs(configPrefix);
        
    }
    
    @GetMapping("/configs/getMapConfigs")
    public Map<String, Object> getMapConfigs(@RequestParam(required=false) String configPrefix){
        return configService.getMapConfigs(configPrefix, true);
        
    }
}
