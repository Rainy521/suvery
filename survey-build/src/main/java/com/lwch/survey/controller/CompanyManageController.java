/**
 * 
 */
package com.lwch.survey.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.AptitudeUsersMember;
import com.lwch.survey.model.Company;
import com.lwch.survey.model.Employee;
import com.lwch.survey.model.Instrumenttation;
import com.lwch.survey.model.InstrumenttationExample;
import com.lwch.survey.service.CompanyService;
import com.lwch.survey.utils.ExcelUtils;

/**
 * @author Rain
 *
 */
@RestController
@RequestMapping("/manage/company")
public class CompanyManageController {
    
    @Autowired
    private CompanyService companyService;
    
    @PostMapping
    public void saveCompany(@RequestBody Company company) {
        if (companyService.selectPrimaryKey(company.getName()) != null) {
            companyService.updateCompany(company);
            
            return;
        }
        
        companyService.insertCompany(company, "");
    }
    
    @DeleteMapping("/remove/{name}")
    public void deleteCase(@PathVariable String name) {
        
        companyService.deleteCompany(name);
    }
    
    @PostMapping("/users/add")
    public void addUsers(@RequestBody Employee employee) {
        
        companyService.insertUsers(employee);
    }
    
    @GetMapping("/{bsname}/{idCard}/users/remove")
    public void deleteUsers(@PathVariable String bsname,@PathVariable String idCard) {
        
        companyService.deleteUsers(idCard);
    }
    
    @PostMapping("/users/aptitudes")
    public void addAptitudesUsers(@RequestBody AptitudeUsersMember aptitudeUsersMember) {
        
        companyService.updateAptitudeUsersMember(aptitudeUsersMember);
    }
    
    /**
     * ????????????Excel??????
     * 
     * @param 
     * 
     * @return 
     * @throws ParseException 
     * 
     * @throws Exception
     * */
    @GetMapping("/excelport/excel")
    public void excelPortInstruments(@RequestParam(required=false) String cname, final HttpServletResponse response) throws Exception {
        
        List<Instrumenttation> list = companyService.selectInstruments(new InstrumenttationExample(), cname);
        
        if(list.isEmpty()){
            throw new RuntimeException("???????????????????????????");
        }
        
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("name", "??????????????????");
        fields.put("model", "????????????");
        fields.put("factoryNo", "????????????");
        fields.put("number", "??????");
        fields.put("verificationDate", "????????????");
        fields.put("mechanism", "????????????");
        fields.put("certificateNo", "???????????????");
        fields.put("invoiceNo", "????????????");
        fields.put("cognizance", "????????????");
        
        ExcelUtils.listToExcel(fields, list, response);
    }
    
    
    @PostMapping("/{bsname}/instruments/add")
    public void addInstruments(@PathVariable String bsname,@RequestBody Instrumenttation instrumenttation) {
        
        if (companyService.getInstrumenttation(instrumenttation.getId()) != null) {
            companyService.updateInstrumenttation(instrumenttation);
            
            return;
        }
        
        instrumenttation.setId(UUID.randomUUID().toString());
        companyService.insertInstrumenttation(instrumenttation, bsname);
    }
    
    @GetMapping("/{bsname}/{id}/instruments/remove")
    public void deleteInstruments(@PathVariable String id ,@PathVariable String bsname) {
        companyService.deleteInstruments(bsname,id);
    }
}
