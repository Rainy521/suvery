package com.lwch.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.controller.utils.Utils;
import com.lwch.survey.model.ApplyEngineering;
import com.lwch.survey.model.GcclGdb;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.EngineeringService;

@RestController
@RequestMapping("/engineering")
public class EngineeringController {

	@Autowired
	private EngineeringService engineeringService;

	@GetMapping
    public List<ApplyEngineering> getApplyProjects(
    		@RequestParam(required=false) String query,
            @RequestParam(required=false, defaultValue="1") int pageNum, 
            @RequestParam(required=false, defaultValue="10") int pageSize) {
		
        return engineeringService.query(query, Utils.getCurrentUsername() ,new PageParm(pageNum, pageSize, " create_time desc "));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ) {
        return engineeringService.getCount(query ,Utils.getCurrentUsername());
    }
    
    @GetMapping("/getOne")
    public ApplyEngineering getOne(@RequestParam(required=false) String id ) {
        return engineeringService.getOne(id);
    }
    
    @PostMapping("/gdb/query")
    public List<GcclGdb> queryGd(@RequestBody DossierParam dossierParam) {
        return engineeringService.queryGd(dossierParam);
    }
    
    @PostMapping("/gdb/count")
    public long queryGdCount(@RequestBody DossierParam dossierParam) {
        return engineeringService.queryGdCount(dossierParam);
    }
    
    @GetMapping("/gdb/getOne")
    public GcclGdb getGdbOne(@RequestParam(required=false) Integer id ) {
        return engineeringService.getGdbOne(id);
    }
}
