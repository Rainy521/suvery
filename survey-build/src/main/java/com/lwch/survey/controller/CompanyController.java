package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.Company;
import com.lwch.survey.model.CompanyExample;
import com.lwch.survey.model.Config;
import com.lwch.survey.model.Employee;
import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.model.InstrumenttationExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.CompanyService;
import com.lwch.survey.service.ConfigService;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private ConfigService configService;
    
    @GetMapping
    public List<Company> getUsers(@RequestParam(required=false) String query,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="10") int pageSize) {
        return companyService.selectByExample(new CompanyExample(), query, new PageParm(pageNum, pageSize, " update_time desc "));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ) {
        return companyService.getCount(query);
    }
    
    @GetMapping("/instruments")
    public List<Instrumenttation> getInstrumenttations(@RequestParam(required=false) String bsname,
                               @RequestParam(required=false, defaultValue="1") int pageNum, 
                               @RequestParam(required=false, defaultValue="5") int pageSize) {
        return companyService.selectInstrumentByExample(new InstrumenttationExample(), bsname, new PageParm(pageNum, pageSize, " update_time desc "));
    }
    
    @GetMapping("/instruments/count")
    public long getInstrumenttationsCount(@RequestParam(required=false) String bsname) {
        return companyService.getInstrumentCount(bsname);
    }
    
    @GetMapping("/instruments/id")
    public Instrumenttation getInstrumenttation(@RequestParam(required=false) String id) {
        return companyService.getInstrumenttation(id);
    }
    
    @GetMapping("/selectByComanyId")
    public Company selectByComanyId(@RequestParam(required=false) String bsname) {
        return companyService.selectPrimaryKey(bsname);
    }
    
    @GetMapping("/users")
    public List<Employee> getUsers(@RequestParam(required=false) String bsname) {
        return companyService.selectUsers(bsname);
    }
    
    @GetMapping("/users/companys")
    public List<String> getUsersCompanys() {
        return companyService.selectAllUsersCompanys();
    }
    
    @GetMapping("/configs/systype")
    public List<Config> selectConfig(){
        
        String configPrefix ="company.aptitude.type";
        return configService.selectConfigs(configPrefix);
        
    }
}
