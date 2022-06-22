/**
 * 
 */
package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.ApplyAptitude;
import com.lwch.survey.model.ApplyAptitudeExample;
import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.model.Config;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.ApplyAptitudeService;
import com.lwch.survey.service.ConfigService;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/applyAptitude")
public class ApplyAptitudeController {
    
    @Autowired
    private ApplyAptitudeService applyAptitudeService;
    
    @Autowired
    private ConfigService configService;
    
    @GetMapping
    public List<ApplyAptitude> getApplyAptitudes(@RequestParam(required=false) String query,
                               @RequestParam(required=false, defaultValue="0") int applyStatus,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="10") int pageSize) {
        return applyAptitudeService.selectByExample(new ApplyAptitudeExample(), query,applyStatus,Utils.getCurrentUsername(), new PageParm(pageNum, pageSize, " update_time desc "));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ,
            @RequestParam(required=false, defaultValue="0") int applyStatus) {
        return applyAptitudeService.getCount(Utils.getCurrentUsername(), query ,applyStatus);
    }
    
    @GetMapping("/selectByApplyId")
    public ApplyAptitude selectByComanyId(@RequestParam(required=false) String id) {
        return applyAptitudeService.selectPrimaryKey(id);
    }
    
    @GetMapping("/users")
    public List<AptitudeUsersMember> getUsers(@RequestParam(required=false) String bsname) {
        return applyAptitudeService.selectUsers(bsname);
    }
    
    @GetMapping("/users/companys")
    public List<String> getUsersCompanys() {
        return applyAptitudeService.selectAllUsersCompanys();
    }
    
    @GetMapping("/configs/systype")
    public List<Config> selectConfig(){
        
        String configPrefix ="company.aptitude.type";
        return configService.selectConfigs(configPrefix);
        
    }
}
