package com.lwch.survey.controller.file;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.Ownership;
import com.lwch.survey.pojo.DossierParam;
import com.lwch.survey.service.CommodityHouseService;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.FileService;
import com.lwch.survey.service.HouseService;
import com.lwch.survey.utils.DownloadUtils;
import com.lwch.survey.utils.WordUtil;

@RestController
@RequestMapping("/exprot/files")
public class DownExprotController {
    
    @Autowired
    private WordUtil wordUtil;
    
    @Autowired
    private HouseService houseService;
    
    @Autowired
    private FileService fileService;
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private CommodityHouseService commodityHouseService;
    
    @Autowired
    private SqlSessionTemplate localSqlSessionTemplate;
    
    @GetMapping("/dossier/{beginGdrq}/{endGdrq}")
    public void downDossierDoc(
    		@PathVariable String beginGdrq,@PathVariable String endGdrq,
    		HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        DossierParam param = DossierParam.builder().beginGdrq(beginGdrq).endGdrq(endGdrq).build();
        List<Map<String, Object>> mapList = localSqlSessionTemplate.selectList("ArchivesStatisticsMapper.getStatisticsData",param);
        System.out.println(mapList);
        Map<String, Object> map = new HashMap<>(0);
        map.put("list", mapList);
        map.put("beginGdrq", beginGdrq);
        map.put("endGdrq", endGdrq);
        //System.out.println(JsonUtil.writeValueAsString(map));
        
        File file = wordUtil.createExcel("fdtableExcle.ftl", "统计表-" + UUID.randomUUID(), map);
        
        DownloadUtils.download(file, response);
    }
    
    
    @GetMapping("/{id}")
    public void downDoc(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        Ownership ownership = houseService.selectPrimaryKey(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(ownership);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(ownership, name));
            }
        }
        
        File file = wordUtil.createExcel("houseExport.ftl", "房管局申请表-" + UUID.randomUUID(), map);
        
        DownloadUtils.download(file, response);
    }
    
    @GetMapping("/house/{id}")
    public String viewDoc(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        Ownership ownership = houseService.selectPrimaryKey(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(ownership);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(ownership, name));
            }
        }
        
        File file = wordUtil.createExcel("houseExport.ftl", "房管局申请表-" + UUID.randomUUID(), map);
        
        String fid = UUID.randomUUID().toString();

        com.lwch.survey.model.File f = new com.lwch.survey.model.File();
        f.setId(fid);
        f.setName(file.getName());
        f.setContent(FileUtils.readFileToByteArray(file));

        fileService.insertFile(f);
        return f.getId();
        //DownloadUtils.download(file, response);
    }
    
    @GetMapping("/commercial/summary/{id}")
    public void downSummary(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        ApplyProject applyProject = commodityHouseService.selectByExcelInfo(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(applyProject);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(applyProject, name));
            }
        }
        
        File file = wordUtil.createExcel("commercialSummaryExport.ftl", "房屋汇总表-" + UUID.randomUUID(), map);
        
        DownloadUtils.download(file, response);
    }
    
    @GetMapping("/commercial/view/summary/{id}")
    public String viewSummary(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        ApplyProject applyProject = commodityHouseService.selectByExcelInfo(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(applyProject);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(applyProject, name));
            }
        }
        
        File file = wordUtil.createExcel("commercialSummaryExport.ftl", "房屋汇总表-" + UUID.randomUUID(), map);
        
        String fid = UUID.randomUUID().toString();
        com.lwch.survey.model.File f = new com.lwch.survey.model.File();
        f.setId(fid);
        f.setName(file.getName());
        f.setContent(FileUtils.readFileToByteArray(file));

        fileService.insertFile(f);
        return f.getId();
    }
    
    @GetMapping("/commercial/floorSpace/{id}")
    public void downFloorSpace(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        ApplyProject applyProject = commodityHouseService.selectByExcelInfo(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(applyProject);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(applyProject, name));
            }
        }
        
        String[] functypes = configService.selectConfig("functype").getValue().split(",");
        map.put("functypes", Arrays.asList(functypes));
        
        File file = wordUtil.createExcel("commercialFloorSpaceExport.ftl", "房屋面积审核表-" + UUID.randomUUID(), map);
        
        DownloadUtils.download(file, response);
    }
    
    @GetMapping("/commercial/view/floorSpace/{id}")
    public String viewFloorSpace(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        ApplyProject applyProject = commodityHouseService.selectByExcelInfo(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(applyProject);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(applyProject, name));
            }
        }
        
        
        String[] functypes = configService.selectConfig("functype").getValue().split(",");
        map.put("functypes", Arrays.asList(functypes));
        
        File file = wordUtil.createExcel("commercialFloorSpaceExport.ftl", "房屋面积审核表-" + UUID.randomUUID(), map);
        
        String fid = UUID.randomUUID().toString();
        com.lwch.survey.model.File f = new com.lwch.survey.model.File();
        f.setId(fid);
        f.setName(file.getName());
        f.setContent(FileUtils.readFileToByteArray(file));

        fileService.insertFile(f);
        return f.getId();
    }
    
    @GetMapping("/commercial/details/{id}")
    public void downDetailsSpace(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        ApplyProject applyProject = commodityHouseService.selectByExcelInfo(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(applyProject);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(applyProject, name));
            }
        }
        
        String[] functypes = configService.selectConfig("functype").getValue().split(",");
        map.put("functypes", Arrays.asList(functypes));
        
        File file = wordUtil.createExcel("commerciaDetails.ftl", "分户明细表-" + UUID.randomUUID(), map);
        
        DownloadUtils.download(file, response);
    }
    
    @GetMapping("/commercial/view/details/{id}")
    public String viewDetailsSpace(@PathVariable String id,HttpServletRequest request,HttpServletResponse response)
            throws IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        request.setCharacterEncoding("utf-8");
        
        ApplyProject applyProject = commodityHouseService.selectByExcelInfo(id);
        
        Map<String, Object> map = new HashMap<>(0);
        
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(applyProject);
        for (int i = 0; i < descriptors.length; i ++) {
            String name = descriptors[i].getName();
            if (!StringUtils.equals(name, "class")) {
                map.put(name, propertyUtilsBean.getNestedProperty(applyProject, name));
            }
        }
        
        String[] functypes = configService.selectConfig("functype").getValue().split(",");
        map.put("functypes", Arrays.asList(functypes));
        
        File file = wordUtil.createExcel("commerciaDetails.ftl", "分户明细表-" + UUID.randomUUID(), map);
        
        String fid = UUID.randomUUID().toString();
        com.lwch.survey.model.File f = new com.lwch.survey.model.File();
        f.setId(fid);
        f.setName(file.getName());
        f.setContent(FileUtils.readFileToByteArray(file));

        fileService.insertFile(f);
        return f.getId();
    }
}
