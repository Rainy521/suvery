package com.lwch.survey.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.FcchGdb;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.service.DossierService;
import com.lwch.survey.utils.DownloadUtils;
import com.sun.jna.Library;
import com.sun.jna.Native;

@RestController
@RequestMapping("/dossier")
public class DossierController {
	
	/**
     * SIFF文件压缩状态
     */
    static final int PROCESS_INIT_STATUS = 0;
	
	@Autowired
	private DossierService dossierService;

	
	@PostMapping
    public List<FcchGdb> query(@RequestBody DossierParam dossierParam) {
        return dossierService.query(dossierParam);
    }
	
	@PostMapping("/count")
    public long count(@RequestBody DossierParam dossierParam) {
        return dossierService.count(dossierParam);
    }
	
	@GetMapping("/getOne")
    public FcchGdb getOne(@RequestParam(required=false) Integer id) {
        return dossierService.getOne(id);
    }
	
	@GetMapping("/applyFinish/query")
    public ResponseObject applyFinishQquery(@RequestParam(required=false) String query,
    		@RequestParam(required=false, defaultValue="1") int pageNum, 
            @RequestParam(required=false, defaultValue="10") int pageSize) {
        return dossierService.applyFinishQquery(query, new PageParm(pageNum, pageSize, "update_time desc"));
    }
	
	@PostMapping("/old/dossier")
	public ResponseObject getOldDossiers(@RequestBody DossierParam dossierParam) {
		return dossierService.getOldQuery(dossierParam);
	}
	
	@GetMapping("/old/getOne")
	public FcchGdb getOldGetOne(@RequestParam(required=false) String hisId) {
		return dossierService.getOldOne(hisId);
	}
	
	
	@GetMapping("/old/getOne/siff")
	public void getOldGetOneSiff(@RequestParam(required=false) String hisId,
			final HttpServletResponse response) throws FileNotFoundException, IOException {
		FcchGdb fcchGdb = dossierService.getOldOneSiff(hisId);
		unzipSiffData(fcchGdb,response);
	}
	
	public interface Dll extends Library{
	    Dll instance = (Dll)Native.loadLibrary("uncompressX64", Dll.class);
	    public int unzip_siffdata(String a, String b, int c, int d);
	}
	
	private void unzipSiffData(FcchGdb fcchGdb,HttpServletResponse response) 
			throws FileNotFoundException, IOException{
        String toPath = System.getProperty("java.io.tmpdir") + File.separator + "SIFF.TEMP";
        String fromPath = System.getProperty("java.io.tmpdir") + File.separator + "TEMP.SIFF";
        
        try(FileOutputStream outStream = new FileOutputStream(new File(toPath));
            BufferedOutputStream buffOutStream = new BufferedOutputStream(outStream);){
            
            buffOutStream.write(fcchGdb.getSiffData());
        }
        
        if(PROCESS_INIT_STATUS == Dll.instance.unzip_siffdata(fromPath, toPath, fcchGdb.getDatalen(), fcchGdb.getOriginlen())){
            File siffFile = new File(fromPath);
            DownloadUtils.download(siffFile, response);
        }
    }
}