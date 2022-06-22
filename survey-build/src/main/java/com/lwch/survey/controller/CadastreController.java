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
import com.lwch.survey.model.ApplyCadastre;
import com.lwch.survey.model.DjchGdb;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.service.CadastreService;

@RestController
@RequestMapping("/cadastre")
public class CadastreController {
	
	@Autowired
	private CadastreService cadastreService;

	@GetMapping
    public List<ApplyCadastre> getApplyProjects(
    		@RequestParam(required=false) String query,
            @RequestParam(required=false, defaultValue="1") int pageNum, 
            @RequestParam(required=false, defaultValue="10") int pageSize) {
		
        return cadastreService.query(query, Utils.getCurrentUsername() ,new PageParm(pageNum, pageSize, " create_time desc "));
    }
    
    @GetMapping("/count")
    public long getCount(@RequestParam(required=false) String query ) {
        return cadastreService.getCount(query ,Utils.getCurrentUsername());
    }
    
    @GetMapping("/getOne")
    public ApplyCadastre getOne(@RequestParam(required=false) String id ) {
        return cadastreService.getOne(id);
    }
    
    @PostMapping("/gdb/query")
    public List<DjchGdb> queryGd(@RequestBody DossierParam dossierParam) {
        return cadastreService.queryGd(dossierParam);
    }
    
    @PostMapping("/gdb/count")
    public long queryGdCount(@RequestBody DossierParam dossierParam) {
        return cadastreService.queryGdCount(dossierParam);
    }
    
    @GetMapping("/gdb/getOne")
    public DjchGdb getGdbOne(@RequestParam(required=false) Integer id ) {
        return cadastreService.getGdbOne(id);
    }
}
