/**
 * 
 */
package com.lwch.survey.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwch.survey.dao.mapper.ApplyBuildMapper;
import com.lwch.survey.dao.mapper.ApplyBuildingMapper;
import com.lwch.survey.dao.mapper.ApplyProjectMapper;
import com.lwch.survey.dao.mapper.BuildingDomainMapper;
import com.lwch.survey.dao.mapper.BuildingLayerMapper;
import com.lwch.survey.dao.mapper.FileManageMapper;
import com.lwch.survey.dao.mapper.FileMapper;
import com.lwch.survey.dao.mapper.FileTypeApplyMemberMapper;
import com.lwch.survey.dao.mapper.HouseMapper;
import com.lwch.survey.dao.mapper.ProcessStatusMapper;
import com.lwch.survey.dao.mapper.StatisticsMapper;
import com.lwch.survey.dao.mapper.ToolUsersMemberMapper;
import com.lwch.survey.model.ApplyBuild;
import com.lwch.survey.model.ApplyBuildExample;
import com.lwch.survey.model.ApplyBuilding;
import com.lwch.survey.model.ApplyBuildingExample;
import com.lwch.survey.model.ApplyProject;
import com.lwch.survey.model.ApplyProjectExample;
import com.lwch.survey.model.ApplyProjectExample.Criteria;
import com.lwch.survey.model.BuildingDomain;
import com.lwch.survey.model.BuildingDomainExample;
import com.lwch.survey.model.BuildingLayer;
import com.lwch.survey.model.BuildingLayerExample;
import com.lwch.survey.model.Config;
import com.lwch.survey.model.FileManage;
import com.lwch.survey.model.FileManageExample;
import com.lwch.survey.model.FileTypeApplyMember;
import com.lwch.survey.model.FileTypeApplyMemberExample;
import com.lwch.survey.model.House;
import com.lwch.survey.model.HouseExample;
import com.lwch.survey.model.ProcessStatus;
import com.lwch.survey.model.ProcessStatusExample;
import com.lwch.survey.model.ToolUsersMember;
import com.lwch.survey.model.ToolUsersMemberExample;
import com.lwch.survey.pojo.PageParm;
import com.lwch.survey.pojo.PieData;
import com.lwch.survey.pojo.ResponseObject;
import com.lwch.survey.pojo.StatisticsInfo;
import com.lwch.survey.pojo.StatisticsParam;
import com.lwch.survey.service.CommodityHouseService;
import com.lwch.survey.service.ConfigService;
import com.lwch.survey.service.ProcessCommonService;
import com.lwch.survey.utils.FdExcelUtils;
import com.lwch.survey.utils.ServiceUtils;
import com.lwch.survey.utils.TimeUtils;
import com.lwch.survey.utils.ZipUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Rain
 *
 */
@Service
@Slf4j
public class CommodityHouseServiceImpl implements CommodityHouseService {

    @Autowired
    private ApplyProjectMapper applyProjectMapper;
    
    @Autowired
    private ApplyBuildingMapper applyBuildingMapper;
    
    @Autowired
    private ApplyBuildMapper applyBuildMapper;
    
    @Autowired
    private ToolUsersMemberMapper toolUsersMemberMapper;
    
    @Autowired
    private ProcessStatusMapper processStatusMapper;
    
    @Autowired
    private FileTypeApplyMemberMapper fileTypeApplyMemberMapper;
    
    @Autowired
    private FileManageMapper fileManageMapper;
    
    @Autowired
    private FileMapper fileMapper;
    
    @Autowired
    private BuildingDomainMapper buildingDomainMapper;
    
    @Autowired
    private BuildingLayerMapper buildingLayerMapper;
    
    @Autowired
    private HouseMapper houseMapper;
    
    @Autowired
    private ConfigService configService;
    
    @Autowired
    private StatisticsMapper statisticsMapper;
    
    @Autowired
    private ProcessCommonService processCommonService;
    
    private static final Logger logger = LoggerFactory.getLogger(OperationLogServiceImpl.class);
    
    @Override
    public List<ApplyProject> selectByExample(ApplyProjectExample applyProjectExample, String query,String username ,
            PageParm pageParm) {
        Criteria criteria = applyProjectExample.createCriteria();
        
        if (StringUtils.isNotBlank(query)) {
            criteria.andProjectNameLike("%" + query + "%");
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> ids = new ArrayList<>();
        for(ProcessStatus member : status){
            ids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(ids).andUsernameEqualTo(username);
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        criteria.andIdIn(toolids);
        
        ServiceUtils.startPage(pageParm);
        
        return conventBuild(applyProjectMapper.selectByExample(applyProjectExample));
    }
    
    private List<ApplyProject> conventBuild(List<ApplyProject> list){
    	if(list.isEmpty()) {
    		return Collections.emptyList();
    	}
    	for(ApplyProject member : list) {
    		member.setApplyBuild(applyBuildMapper.selectByPrimaryKey(member.getId()));
    	}
    	return list;
    }

    @Override
    public long getCount(String query ,String username) {
        ApplyProjectExample applyProjectExample = new ApplyProjectExample();
        Criteria criteria = applyProjectExample.createCriteria();
        
        if (StringUtils.isNotBlank(query)) {
            criteria.andProjectNameLike("%" + query + "%");
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return 0;
        }
        
        List<String> ids = new ArrayList<>();
        for(ProcessStatus member : status){
            ids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(ids).andUsernameEqualTo(username);
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return 0;
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        criteria.andIdIn(toolids);
        
        return applyProjectMapper.countByExample(applyProjectExample);
    }
    
    @Override
	public List<ApplyProject> selectPoolByExample(ApplyProjectExample applyProjectExample, 
			String query,String type,String currentUsername, PageParm pageParm) {
    	Criteria criteria = applyProjectExample.createCriteria();
        
        if (StringUtils.isNotBlank(query)) {
            criteria.andProjectNameLike("%" + query + "%");
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> ids = status.stream().map(ProcessStatus::getId).collect(Collectors.toList());
        criteria.andIdIn(ids);
        
        ApplyBuildExample buildExample = new ApplyBuildExample();
        com.lwch.survey.model.ApplyBuildExample.Criteria buildCriteria = buildExample.createCriteria().andSlbhIn(ids);
        if (StringUtils.isNotBlank(type)) {
        	buildCriteria.andChlxLike("%" + type + "%");
        }
        List<ApplyBuild> builds = applyBuildMapper.selectByExample(buildExample);
        if(builds.isEmpty()){
            return Collections.emptyList();
        }
        
        ids.clear();
        Map<String,ApplyBuild> map = new HashMap<>();
        for(ApplyBuild temp : builds) {
        	ids.add(temp.getSlbh());
        	map.put(temp.getSlbh(), temp);
        }
        
        ServiceUtils.startPage(pageParm);
        
        List<ApplyProject> projects = applyProjectMapper.selectByExample(applyProjectExample);
        if (projects.isEmpty()) {
        	return Collections.emptyList();
		}
        projects.forEach(x -> x.setApplyBuild(map.get(x.getId())));
        
        return projects;
	}

    @Override
	public long getPoolCount(String query, String type) {
    	ApplyProjectExample applyProjectExample = new ApplyProjectExample();
        Criteria criteria = applyProjectExample.createCriteria();
        
        if (StringUtils.isNotBlank(query)) {
            criteria.andProjectNameLike("%" + query + "%");
        }
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return 0;
        }
        
        List<String> ids = status.stream().map(ProcessStatus::getId).collect(Collectors.toList());
        
        criteria.andIdIn(ids);
        
        ApplyBuildExample buildExample = new ApplyBuildExample();
        com.lwch.survey.model.ApplyBuildExample.Criteria buildCriteria = buildExample.createCriteria().andSlbhIn(ids);
        if (StringUtils.isNotBlank(type)) {
        	buildCriteria.andChlxLike("%" + type + "%");
        }
        List<ApplyBuild> builds = applyBuildMapper.selectByExample(buildExample);
        if(builds.isEmpty()){
            return 0;
        }
        
        ids.clear();
        for(ApplyBuild temp : builds) {
        	ids.add(temp.getSlbh());
        }
        
        return applyProjectMapper.countByExample(applyProjectExample);
	}

	@Override
    public List<ApplyProject> selectByExampleFrom(Map<String, String> params) {
        ApplyProjectExample applyProjectExample = new ApplyProjectExample();
        Criteria criteria = applyProjectExample.createCriteria();
        
        /*if (StringUtils.isNotBlank(query)) {
            criteria.andProjectNameLike("%" + query + "%");
        }*/
        
        ProcessStatusExample processStatusExample = new ProcessStatusExample();
        processStatusExample.createCriteria().andStatusNotEqualTo(PROCESS_END_STATUS);
        List<ProcessStatus> status = processStatusMapper.selectByExample(processStatusExample);
        if(status.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> ids = new ArrayList<>();
        for(ProcessStatus member : status){
            ids.add(member.getId());
        }
        
        ToolUsersMemberExample toolUsersMemberExample = new ToolUsersMemberExample();
        toolUsersMemberExample.createCriteria().andIdIn(ids).andUsernameLike("%" + params.get("user") + "%");
        List<ToolUsersMember> members = toolUsersMemberMapper.selectByExample(toolUsersMemberExample);
        
        if(members.isEmpty()){
            return Collections.emptyList();
        }
        
        List<String> toolids = new ArrayList<>();
        for(ToolUsersMember member : members){
            toolids.add(member.getId());
        }
        
        criteria.andIdIn(toolids);
        
        return applyProjectMapper.selectByExample(applyProjectExample);
    }

    @Override
    public ResponseObject insertApplyProject(ApplyProject applyProject, String username){
    	
    	ApplyBuild build = applyProject.getApplyBuild();
    	if(null != build) {
    		try{
    			build.setXmbh(applyProject.getId());
    			applyBuildMapper.insert(build);
    		}catch(DuplicateKeyException e){
    			logger.error(e.getMessage());
    			throw new RuntimeException("主键冲突,请检查受理编号!"); 
    		}
    	}
        
        List<FileTypeApplyMember> listFiles = applyProject.getListFiles();
        for(FileTypeApplyMember fileMember : listFiles){
            fileMember.setApplyid(applyProject.getId());
            if(null != fileMember.getFileId()){
            	 String[] arr = fileMember.getFileId().split(",");
                 if(arr.length > 1){
                	 for(String temp : arr) {
                		 FileTypeApplyMember member = new FileTypeApplyMember();
                		 member.setApplyid(fileMember.getApplyid());
                		 member.setFileId(temp);
                		 member.setFileManageId(fileMember.getFileManageId());
                		 fileTypeApplyMemberMapper.insertSelective(member);
                	 } 
                 }else {
                	 fileTypeApplyMemberMapper.insertSelective(fileMember);
                 }
                
            }
        }
        
        ToolUsersMember usersMember = new ToolUsersMember();
        usersMember.setUsername(username);
        usersMember.setId(applyProject.getId());
        toolUsersMemberMapper.insert(usersMember);
        
        ProcessStatus processStatus = new ProcessStatus();
        processStatus.setId(applyProject.getId());
        processStatus.setStatus(PROCESS_INIT_STATUS);
        processStatus.setName(applyProject.getProjectName());
        if(null != build) {
        	processStatus.setNumber(build.getLpzh());
        }
        
        processStatus.setFormkey(COMMDODITY_FORMKEY);
        processStatusMapper.insertSelective(processStatus);
        
        applyProjectMapper.insertSelective(applyProject);
        return ResponseObject.builder().http(HttpStatus.OK.value())
        		.data(applyProject.getId()).build();
    }
    
    private long updateProject (ApplyProject applyProject, String username) {
    	ApplyBuild build = applyProject.getApplyBuild();
    	if(null != build) {
    		try{
    			build.setXmbh(applyProject.getId());
    			applyBuildMapper.insert(build);
    		}catch(DuplicateKeyException e){
    			logger.error(e.getMessage());
    			throw new RuntimeException("主键冲突,请检查受理编号!"); 
    		}
    	}
        
        List<FileTypeApplyMember> listFiles = applyProject.getListFiles();
        for(FileTypeApplyMember fileMember : listFiles){
            fileMember.setApplyid(applyProject.getId());
            if(null != fileMember.getFileId()){
            	 String[] arr = fileMember.getFileId().split(",");
                 if(arr.length > 1){
                	 for(String temp : arr) {
                		 FileTypeApplyMember member = new FileTypeApplyMember();
                		 member.setApplyid(fileMember.getApplyid());
                		 member.setFileId(temp);
                		 member.setFileManageId(fileMember.getFileManageId());
                		 fileTypeApplyMemberMapper.insertSelective(member);
                	 } 
                 }else {
                	 fileTypeApplyMemberMapper.insertSelective(fileMember);
                 }
                
            }
        }
        
        return applyProjectMapper.insertSelective(applyProject);
    }

	/*
	 * private String getKey(Map<String,Object> map, String value){ for(String key:
	 * map.keySet()){ if(map.get(key).equals(value)){ return key; } } return value;
	 * }
	 */
    @Override
    public ResponseObject updateApplyProject(ApplyProject applyProject, String username) {
    	ResponseObject obj = ResponseObject.builder()
    			.http(HttpStatus.INTERNAL_SERVER_ERROR.value())
    			.build();
    	try {
			String id = applyProject.getId();
			ApplyProject project = applyProjectMapper.selectByPrimaryKey(id);
			if(null != project) {
				applyBuildMapper.deleteByPrimaryKey(project.getProjectNo());
			}
			FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
			applyMemberExample.createCriteria().andApplyidEqualTo(id);
			fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
			
			applyProjectMapper.deleteByPrimaryKey(id);
			applyProject.setId(id);
			updateProject(applyProject,username);

            String name = null != applyProject.getProjectName()?applyProject.getProjectName(): StringUtils.EMPTY;
			processStatusMapper.updateByPrimaryKeySelective(ProcessStatus.builder()
					.id(id).number(applyProject.getApplyBuild().getLpzh()).name(name)
                    .build());
			
			obj.setHttp(HttpStatus.OK.value());
			obj.setData(id);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
    	return obj;
		
		/*
		 * ApplyBuildingExample applyBuildingExample = new ApplyBuildingExample();
		 * applyBuildingExample.createCriteria().andApplyIdEqualTo(applyProject.getId())
		 * ; applyBuildingMapper.deleteByExample(applyBuildingExample);
		 * 
		 * Map<String, Object> structure = configService.getMapConfigs("structure.",
		 * true);
		 * 
		 * List<ApplyBuilding> applyBuildings = applyProject.getListBuilding();
		 * if(!applyBuildings.isEmpty()) { applyBuildings.forEach(x -> {
		 * x.setApplyId(applyProject.getId());
		 * x.setJzjg(getKey(structure,x.getJzjg()).toString());
		 * x.setId(UUID.randomUUID().toString()); });
		 * applyBuildingMapper.batchInsert(applyBuildings); }
		 */
		/*
		 * if(!applyProject.getId().equals(applyProject.getApplyBuild().getSlbh())) {
		 * applyBuildMapper.deleteByPrimaryKey(applyProject.getId());
		 * applyBuildMapper.insert(applyProject.getApplyBuild());
		 * deleteApplyProject(applyProject.getId());
		 * insertApplyProject(applyProject,username);
		 * 
		 * } ApplyBuild build =
		 * applyBuildMapper.selectByPrimaryKey(applyProject.getApplyBuild().getSlbh());
		 * if(null == build || !build.getXmbh().equals(applyProject.getId())) { throw
		 * new RuntimeException("主键冲突,请检查受理编号!"); }
		 * applyBuildMapper.updateByPrimaryKeySelective(applyProject.getApplyBuild());
		 * 
		 * FileTypeApplyMemberExample fileTypeApplyMemberExample = new
		 * FileTypeApplyMemberExample();
		 * fileTypeApplyMemberExample.createCriteria().andApplyidEqualTo(applyProject.
		 * getId());
		 * fileTypeApplyMemberMapper.deleteByExample(fileTypeApplyMemberExample);
		 * 
		 * List<FileTypeApplyMember> listfiles = applyProject.getListFiles();
		 * for(FileTypeApplyMember fileMember : listfiles){
		 * fileMember.setApplyid(applyProject.getId());
		 * fileTypeApplyMemberMapper.insertSelective(fileMember); }
		 * 
		 * applyProjectMapper.updateByPrimaryKeySelective(applyProject);
		 */
    }

    @Override
    public void deleteApplyProject(String id) {
		/*
		 * ApplyBuildingExample applyBuildingExample = new ApplyBuildingExample();
		 * applyBuildingExample.createCriteria().andApplyIdEqualTo(id);
		 * applyBuildingMapper.deleteByExample(applyBuildingExample);
		 */
    	ApplyProject project = applyProjectMapper.selectByPrimaryKey(id);
    	if(null != project) {
    		applyBuildMapper.deleteByPrimaryKey(project.getProjectNo());
    	}
		/*
		 * HouseExample houseExample = new HouseExample();
		 * houseExample.createCriteria().andIdEqualTo(id);
		 * houseMapper.deleteByExample(houseExample);
		 */
        
        FileTypeApplyMemberExample applyMemberExample = new FileTypeApplyMemberExample();
        applyMemberExample.createCriteria().andApplyidEqualTo(id);
        fileTypeApplyMemberMapper.deleteByExample(applyMemberExample);
        
        applyProjectMapper.deleteByPrimaryKey(id);
        toolUsersMemberMapper.deleteByPrimaryKey(id);
        processStatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ApplyProject selectPrimaryKey(String id) {
        ApplyProject applyProject = applyProjectMapper.selectByPrimaryKey(id);
        if(applyProject == null){
            return applyProject;
        }
        
        ApplyBuild build = applyBuildMapper.selectByPrimaryKey(applyProject.getProjectNo());
        applyProject.setApplyBuild(build);
        
        ApplyBuildingExample applyBuildingExample = new ApplyBuildingExample();
        applyBuildingExample.createCriteria().andApplyIdEqualTo(id);
        List<ApplyBuilding> buildings = applyBuildingMapper.selectByExample(applyBuildingExample);
        if(buildings.isEmpty()){
            buildings = Collections.emptyList();
        }
        
        Collections.sort(buildings, new Comparator<ApplyBuilding>() {
            @Override
            public int compare(ApplyBuilding o1, ApplyBuilding o2) {
                int a = 0;
                try {
                    a = new Double((String) o1.getLpzh()).compareTo(new Double((String) o2.getLpzh()));
                } catch (NumberFormatException e) {
                    return -1;
                }
                return a;
            }
        });
        applyProject.setListBuilding(buildings);
        
        HouseExample houseExample = new HouseExample();
        houseExample.createCriteria().andIdEqualTo(id);
        List<House> houses = houseMapper.selectByExample(houseExample);
        if(houses.isEmpty()){
            houses = Collections.emptyList();
        }
        applyProject.setListHouse(houses);
        
        return applyProject;
    }
    
    @Override
    public ApplyProject selectByExcelInfo(String id) {
        ApplyProject applyProject = applyProjectMapper.selectByPrimaryKey(id);
        if(applyProject == null){
            return applyProject;
        }
        
        ApplyBuildingExample applyBuildingExample = new ApplyBuildingExample();
        applyBuildingExample.createCriteria().andApplyIdEqualTo(id);
        List<ApplyBuilding> buildings = applyBuildingMapper.selectByExample(applyBuildingExample);
        
        if(buildings.isEmpty()){
            applyProject.setListBuilding(Collections.emptyList());
            return applyProject;
        }
        
        List<String> buildingids = buildings.stream().map(ApplyBuilding::getId).collect(Collectors.toList());
        
        BuildingDomainExample buildingDomainExample = new BuildingDomainExample();
        buildingDomainExample.createCriteria().andBuildIdIn(buildingids);
        List<BuildingDomain> listDomains = buildingDomainMapper.selectByExample(buildingDomainExample);
        
        BuildingLayerExample buildingLayerExample = new BuildingLayerExample();
        buildingLayerExample.createCriteria().andBuildIdIn(buildingids);
        List<BuildingLayer> listlayers = buildingLayerMapper.selectByExample(buildingLayerExample);
        
        HouseExample houseExample = new HouseExample();
        houseExample.createCriteria().andBuildNoIn(buildingids);
        houseExample.setOrderByClause("layers_location ASC ,house_no ASC");
        List<House> listhouses = houseMapper.selectByExample(houseExample);
        
        houseExample.clear();
        houseExample.createCriteria().andBuildNoIn(buildingids).andOwnerRoomIsNotNull();
        houseExample.setOrderByClause("layers_location ASC ,house_no ASC");
        List<House> listOwnerRooms = houseMapper.selectByExample(houseExample);
        
        List<ApplyBuilding> listBuildings = new ArrayList<>();
        if(buildings.isEmpty()){
            buildings = Collections.emptyList();
            applyProject.setListBuilding(buildings);
        }else{
            for(ApplyBuilding member : buildings){
                ApplyBuilding applyBuilding = new ApplyBuilding();
                applyBuilding = member;
                
                List<BuildingDomain> domains = new ArrayList<>();
                for(BuildingDomain domainMember : listDomains){
                    if(domainMember.getBuildId().equals(member.getId())){
                        domains.add(domainMember);
                    }
                }
                applyBuilding.setDomains(domains);
                applyBuilding.setFuncs(getFuncs(domains));
                
                List<BuildingLayer> layers = new ArrayList<>();
                for(BuildingLayer layerMember : listlayers){
                    if(layerMember.getBuildId().equals(member.getId())){
                        layers.add(layerMember);
                    }
                }
                applyBuilding.setLayers(layers);
                
                List<House> housesList = new ArrayList<>();
                for(House houseMember : listhouses){
                    if(houseMember.getBuildNo().equals(member.getId()) && null == houseMember.getOwnerRoom()){
                        housesList.add(houseMember);
                    }
                }
                applyBuilding.setHouses(getHouses(housesList, listOwnerRooms));
                
                Map<String, Object> map = configService.getMapConfigs("structure.", true);
                applyBuilding.setJzjg(String.valueOf(map.get(applyBuilding.getJzjg())));
                listBuildings.add(applyBuilding);
            }
            
            Collections.sort(buildings, new Comparator<ApplyBuilding>() {
                @Override
                public int compare(ApplyBuilding o1, ApplyBuilding o2) {
                    int a = 0;
                    try {
                        a = new Double((String) o1.getLpzh()).compareTo(new Double((String) o2.getLpzh()));
                    } catch (NumberFormatException e) {
                        return -1;
                    }
                    return a;
                }
            });
            applyProject.setListBuilding(buildings);
        }
        
        applyProject.setListHouse(listhouses);
        return applyProject;
    }
    
    private List<House> getHouses(List<House> housesList,List<House> listOwnerRooms){
        List<House> houses = new ArrayList<>();
        for(House temp : housesList){
            List<House> housesTemp = new ArrayList<>();
            
            if(!listOwnerRooms.isEmpty()){
                for(House atemp : listOwnerRooms){
                    if(atemp.getOwnerRoom().equals(temp.getRoomId())){
                        housesTemp.add(atemp);
                    }
                }
            }
            
            if(!housesTemp.isEmpty()){
                //temp.setChildren(housesTemp);
                double sumArea = temp.getBuildArea();
                double sumTnmj = temp.getInnerArea();
                double sumFtmj = temp.getShareArea();
                double sumYtmj = temp.getYtmj();
                
                for(House houTemp : housesTemp){
                    sumArea += houTemp.getBuildArea();
                    sumTnmj += houTemp.getInnerArea();
                    sumFtmj += houTemp.getShareArea();
                    sumYtmj += houTemp.getYtmj();
                }
                temp.setBuildArea(sumArea);
                temp.setInnerArea(sumTnmj);
                temp.setShareArea(sumFtmj);
                temp.setYtmj(sumYtmj);
            }
            
            String[] gnqlb = configService.selectConfig("functype").getValue().split(",");
            List<String> lb = Arrays.asList(gnqlb);
            
            for(String str : lb){
                if(null == temp.getFuncName()){
                    continue;
                }
                if(temp.getFuncName().contains(str)){
                    temp.setFuncName(str);
                }
            }
            houses.add(temp);
        }
        return houses;
    }
    
    private List<BuildingDomain> getFuncs (List<BuildingDomain> domains){
        Map<String, List<BuildingDomain>> collect = domains.stream().collect(Collectors.groupingBy(BuildingDomain::getGnqlb));
        List<BuildingDomain> funces = collect.values().stream().map((List<BuildingDomain> details) -> {
            Double totalArea = 0D;
            Integer totalSet = 0;
            String lb = "";
            for (BuildingDomain detail : details) {
                totalArea += detail.getJzmj();
                totalSet += detail.getTs();
                lb = detail.getGnqlb();
            }
            
            BuildingDomain domain = new BuildingDomain();
            domain.setGnqlb(lb);
            domain.setJzmj(totalArea);
            domain.setTs(totalSet);

            return domain;
        }).collect(Collectors.toList());
        
        if(funces.isEmpty()){
            return Collections.emptyList();
        }
        
        return funces;
    }

	@Override
	@Async
	@Transactional
	public Map<String, String> unZipSave(java.io.File f, String currentUsername)  {
		String path = SYS_PATH + java.io.File.separator + UUID.randomUUID().toString();
		//path = "C:\\Users\\43796\\AppData\\Local\\Temp\\97818acf-eed0-45b7-9fe0-3d0b6a2e7381";
		Map<String, String> mapCode = new HashMap<>();
		try {
			ZipUtil.unzip(f, path);
		} catch (IOException e) {
			throw new RuntimeException("文件解压出错");
		}

		List<Config> configs = configService.selectConfigs(IMPORT_EXECL);
		if(configs.isEmpty()) {
			throw new RuntimeException("配置项出错,检查配置项");
		}
		
		ApplyProject project = new ApplyProject();
		
		for(Config configMember : configs) {
			String excelPath = path + java.io.File.separator + configMember.getValue();
			if(configMember.getName().equals(IMPORT_XLSX_NAME)) {
				File file = new File(excelPath);
				if (!file.exists()) {
					throw new RuntimeException(configMember.getValue() + "文件不存在，请检查文件");
				}
				
				project = FdExcelUtils.readExcel(excelPath);
				if(project == null) {
					mapCode.put("code", UNLOAD_FILE_FAIL.toString());
					mapCode.put("msg", "表格填写错误，请检查文件");
					return mapCode;
				}
				
				String id = processCommonService.generate("FC");
				project.setProjectNo(id);
				project.setId(id);
				project.getApplyBuild().setSlbh(id);
			}
		}
		
		String[] strArr = {IMPORT_SGT,IMPORT_FCCHHT,
				IMPORT_JSGCGHXKZ,IMPORT_BDCQZ,IMPORT_SIFF};
		List<FileTypeApplyMember> listfiles = getListfiles(configs, path, strArr);
		
		project.setListFiles(listfiles);
		insertApplyProject(project, currentUsername);
		mapCode.put("code", UNLOAD_FILE_SUCCESS.toString());
		mapCode.put("msg", "成功");
		return mapCode;
		
	}
	
	private List<FileTypeApplyMember> getListfiles(List<Config> configs,String path, String[] strArr){
		List<FileTypeApplyMember> listfiles = new ArrayList<>();
		for(Config configMember : configs) {
			String excelPath = path + java.io.File.separator + configMember.getValue();
			
			if(configMember.getName().equals(IMPORT_XLSX_NAME)) {
				continue;
			}
			String value = configMember.getValue().trim();
//			if(SIFF_BOOLEAN.equals(configMember.getValue())) {
//				value = SIFF_CODE;
//			}
			FileManageExample example = new FileManageExample();
			example.createCriteria().andFileNameEqualTo(value);
			List<FileManage> fileManage = fileManageMapper.selectByExample(example);
			
			if(fileManage.isEmpty()) {
				continue;
			}
			File file1 = new File(excelPath);
	        if (!file1.exists() && !file1 .isDirectory()) {
	        	continue;
	        }
	        String[] list = new File(excelPath).list();
	        if(list.length > 0) {
	        	for(String temp : list) {
	        		FileTypeApplyMember member = new FileTypeApplyMember();
	        		
	        		StringBuilder timeid = new StringBuilder(TimeUtils.getDatePrimaryKey());
	            	
	                String id = timeid.toString();
	        		com.lwch.survey.model.File modelFile = new com.lwch.survey.model.File();
	        		modelFile.setId(id);
	        		modelFile.setName(temp);
	        		modelFile.setUpdateTime(new Date());
	        		modelFile.setContent(getBytesByFile(excelPath + File.separator + temp));
	        		fileMapper.insert(modelFile);
	        		
	        		member.setFileId(id);
	        		member.setFileManageId(fileManage.get(0).getId());
	        		listfiles.add(member);
	        	}
	        }
		}
		return listfiles;
	}
	
	@Override
	public List<StatisticsInfo> getStatisticaltables(StatisticsParam param, PageParm pageParm) {
		if(null != param.getSearchType() && !StringUtils.isBlank(param.getSearchType())) {
			param = getBeginTimeAndEndTime(param);
		}
		
		ServiceUtils.startPage(pageParm);
		
		List<StatisticsInfo> list = statisticsMapper.queryStatistics(param);
		if(list.isEmpty()) {
			return Collections.emptyList();
		}
		list.forEach(x -> x.setJzmj(null == x.getJzmj()?0:x.getJzmj()));
		
		return list;
	}


	private StatisticsParam getBeginTimeAndEndTime(StatisticsParam param) {
		String beginTime = "";
		String endTime = "";
		switch (param.getActiveTab()) {
		case STATISTICAL_TYPE_MONTH:
			beginTime = param.getSearchType() + "-01";
			endTime = param.getSearchType() + "-31";
			param.setBeginTime(beginTime);
			param.setEndTime(endTime);
			break;
		case STATISTICAL_TYPE_QUARTER:
			int yearIndex = param.getSearchType().indexOf("年");
			int beginMonthIndex = param.getSearchType().indexOf("月");
			int endMonthIndex = param.getSearchType().lastIndexOf("月");
			String year = param.getSearchType().substring(0, yearIndex);
			String beginMonth = param.getSearchType().substring(yearIndex + 1, beginMonthIndex);
			String endMonth = param.getSearchType().substring(beginMonthIndex + 2, endMonthIndex);
			beginTime = year.trim() + "-" + beginMonth.trim() + "-01";
			endTime = year.trim() + "-" + endMonth.trim() + "-31";
			param.setBeginTime(beginTime);
			param.setEndTime(endTime);
			break;
		case STATISTICAL_TYPE_YEAR:
			String year1 = param.getSearchType().substring(0, param.getSearchType().indexOf("年"));
			beginTime = year1 + "-01-01";
			endTime = year1 + "-12-31";
			param.setBeginTime(beginTime);
			param.setEndTime(endTime);
			break;
		default:
			break;
		}
		return param;
	}

	@Override
	public long getTablesCount(StatisticsParam param) {
		if(null != param.getSearchType() && !StringUtils.isBlank(param.getSearchType())) {
			param = getBeginTimeAndEndTime(param);
		}
		
		List<StatisticsInfo> list = statisticsMapper.queryStatistics(param);
		if(list.isEmpty()) {
			return 0;
		}
		return list.size();
	}

	@Override
	public Map<String, ResponseObject> statisticalPie(String chlx) {
		
		Map<String, ResponseObject>  map = new HashMap<>();
		//得到所有数据
		List<StatisticsInfo> list = statisticsMapper.queryStatisticsChlx(chlx);
		if(list.isEmpty()) {
			return Collections.emptyMap();
		}
		list.forEach(x -> {
			String monthDay = getLocalDateStr(x.getUpdateTime(),"yyyy-MM");
			String yearDay = getLocalDateStr(x.getUpdateTime(),"yyyy年");
			x.setMonthDay(monthDay);
			x.setYearDay(yearDay);
			x.setQuarterDay(getQuarterDay(yearDay,monthDay));
			x.setJzmj(null == x.getJzmj()?1:x.getJzmj());
			x.setSldw(null == x.getSldw()?"-":x.getSldw());
		});
		
		String [] types = {"月度","季度","年度","建设单位","受理单位"};
		for(String type : types) {
			map.put(type, getPieData(type, list));
		}
		
		return map;
	}
	
	// 得到统计数据
	private ResponseObject getPieData(String type, List<StatisticsInfo> list){
		ResponseObject pieObject = new ResponseObject();
		
		try {
			List<PieData> listpie = new ArrayList<>();
			Map<String, Double> collect = getStreamList(type, list);
			if(collect.isEmpty()) {
				return null;
			}
			
			//排序map的key
			collect = collect.entrySet().stream()
						.sorted(Map.Entry.comparingByKey())
							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
										(oldValue, newValue) -> oldValue, LinkedHashMap::new));
			
			collect.forEach((k,v) ->{
				PieData pieData = new PieData();
				pieData.setName(k);
				pieData.setValue(v);
				List<StatisticsInfo> listInfos = getStreamNum(type,k,list);
				pieData.setStatisticses(listInfos);
				pieData.setCount(listInfos.size());
				listpie.add(pieData);
			});
			
			List<String> tableNames = listpie.stream().map(PieData::getName).collect(Collectors.toList());
			
			pieObject.setData(listpie);
			pieObject.setDataNames(tableNames);
			pieObject.setHttp(HttpStatus.OK.value());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pieObject;
	}
	
	private List<StatisticsInfo> getStreamNum(String type, String name, List<StatisticsInfo> list){
		
		Map<String, List<StatisticsInfo>> map = new HashMap<>();
		switch (type) {
		case STATISTICAL_TYPE_MONTH:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getMonthDay,Collectors.toList())
			        );
			break;
		case STATISTICAL_TYPE_QUARTER:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getQuarterDay,Collectors.toList())
			        );
			break;
		case STATISTICAL_TYPE_YEAR:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getYearDay,Collectors.toList())
			        );
			break;
		case STATISTICAL_TYPE_JSDW:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getJsdw,Collectors.toList())
			        );
			break;
		case STATISTICAL_TYPE_SLDW:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getSldw,Collectors.toList())
			        );
			break;

		default:
			map = Collections.emptyMap();
			break;
		}
		
		if(map.isEmpty()) {
			return Collections.emptyList();
		}
		
		return map.get(name);
	}
	
	private Map<String, Double> getStreamList(String type, List<StatisticsInfo> list){
		
		Map<String, Double> map = new HashMap<>();
		switch (type) {
		case STATISTICAL_TYPE_MONTH:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getMonthDay,Collectors.summingDouble(StatisticsInfo::getJzmj))
			        );
			break;
		case STATISTICAL_TYPE_QUARTER:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getQuarterDay,Collectors.summingDouble(StatisticsInfo::getJzmj))
			        );
			break;
		case STATISTICAL_TYPE_YEAR:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getYearDay,Collectors.summingDouble(StatisticsInfo::getJzmj))
			        );
			break;
		case STATISTICAL_TYPE_JSDW:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getJsdw,Collectors.summingDouble(StatisticsInfo::getJzmj))
			        );
			break;
		case STATISTICAL_TYPE_SLDW:
			map = list.stream().collect(Collectors.groupingBy(
			        	StatisticsInfo::getSldw,Collectors.summingDouble(StatisticsInfo::getJzmj))
			        );
			break;

		default:
			map = Collections.emptyMap();
			break;
		}
		
		return map;
	}
	
	// 得到季度日期
	private String getQuarterDay(String yaerDay, String monthDay) {
		String resuleMonth = "";
		String month = monthDay.substring(5);
		if(MONTH_1.equals(month)||MONTH_2.equals(month)||MONTH_3.equals(month)) {
			resuleMonth = "1月-3月";
		}else if(MONTH_4.equals(month)||MONTH_5.equals(month)||MONTH_6.equals(month)) {
			resuleMonth = "4月-6月";
		}else if(MONTH_7.equals(month)||MONTH_8.equals(month)||MONTH_9.equals(month)) {
			resuleMonth = "7月-9月";
		}else {
			resuleMonth = "10月-12月";
		}
		StringBuilder temp = new StringBuilder(yaerDay);
		temp.append(" ");
		temp.append(resuleMonth);
		
		return temp.toString() ;
	}
	
	private String getLocalDateStr(Date date,String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);     
	     
        return dateTimeFormatter.format(localDateTime); 
	}

	public byte[] getBytesByFile(String filePath) {
		File file = new File(filePath);
		try (	// 获取输入流
				FileInputStream fis = new FileInputStream(file);
				// 新的 byte 数组输出流，缓冲区容量1024byte
				ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			){
			// 缓存
			byte[] b = new byte[1024];
			int n;	
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			// fis.close();
			// 改变为byte[]
			// byte[] data = bos.toByteArray();
			// bos.close();
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new RuntimeException("文件流出错");
		}
	}

	
	/*
	 * 户室申请 Map<String, Object> use = configService.getMapConfigs("use.", true);
	 * 
	 * List<ApplyBuilding> applyBuildings = applyProject.getListBuilding();
	 * for(ApplyBuilding member : applyBuildings){
	 * member.setApplyId(applyProject.getId()); if(null !=
	 * applyBuildingMapper.selectByPrimaryKey(member.getId())){ throw new
	 * RuntimeException("该项目幢户已经被申请!"); }
	 * member.setGhyt(use.get(member.getGhyt()).toString());
	 * 
	 * File file = new File(); String uuid = UUID.randomUUID().toString();
	 * file.setId(uuid); file.setContent(member.getFiles()); file.setName("siff");
	 * fileMapper.insert(file);
	 * 
	 * member.setSiffFileid(uuid); applyBuildingMapper.insertSelective(member);
	 * 
	 * BuildingLayerExample buildingLayerExample = new BuildingLayerExample();
	 * buildingLayerExample.createCriteria().andBuildIdEqualTo(member.getId());
	 * buildingLayerMapper.deleteByExample(buildingLayerExample);
	 * 
	 * List<BuildingLayer> layers = member.getLayers(); // for(BuildingLayer layer :
	 * member.getLayers()){ // if(null !=
	 * buildingLayerMapper.selectByPrimaryKey(layer.getId())){ //
	 * buildingLayerMapper.updateByPrimaryKeySelective(layer); // }else{ //
	 * layers.add(layer); // //buildingLayerMapper.insertSelective(layer); // } // }
	 * 
	 * if(!layers.isEmpty()){ buildingLayerMapper.batchInsert(layers); }
	 * 
	 * BuildingDomainExample domainExample = new BuildingDomainExample();
	 * domainExample.createCriteria().andBuildIdEqualTo(member.getId());
	 * buildingDomainMapper.deleteByExample(domainExample);
	 * 
	 * List<BuildingDomain> domains = new ArrayList<>(); String[] gnqlb =
	 * configService.selectConfig("functype").getValue().split(",");
	 * 
	 * for(BuildingDomain domain : member.getDomains()){ List<String> lb =
	 * Arrays.asList(gnqlb);
	 * 
	 * for(String str : lb){ if(domain.getGnqmc().contains(str)){
	 * domain.setGnqlb(str); } }
	 * 
	 * domain.setGnqlb(domain.getGnqlb() == null?"无":domain.getGnqlb());
	 * 
	 * domains.add(domain); // if(null !=
	 * buildingDomainMapper.selectByPrimaryKey(domain.getId())){ //
	 * buildingDomainMapper.updateByPrimaryKeySelective(domain); // }else{ // //
	 * //buildingDomainMapper.insertSelective(domain); // } }
	 * 
	 * if(!domains.isEmpty()){ buildingDomainMapper.batchInsert(domains); }
	 * 
	 * }
	 * 
	 * 
	 * Map<String, Object> structure = configService.getMapConfigs("structure.",
	 * true); List<House> listHouse = new ArrayList<>(); for(House houseMember :
	 * applyProject.getListHouse()){ houseMember.setId(applyProject.getId());
	 * houseMember.setBuildStructure((String)
	 * structure.get(houseMember.getBuildStructure()));
	 * houseMember.setPlanUse(use.get(houseMember.getPlanUse()).toString());
	 * listHouse.add(houseMember); //houseMapper.insertSelective(houseMember); }
	 * 
	 * if(!listHouse.isEmpty()){ houseMapper.batchInsert(listHouse); }
	 */
	/*
	 * Map<String, Object> structure = configService.getMapConfigs("structure.", true);
	 * List<ApplyBuilding> applyBuildings = applyProject.getListBuilding();
	 * if(!applyBuildings.isEmpty()) { applyBuildings.forEach(x -> {
	 * x.setApplyId(applyProject.getId()); x.setJzjg(getKey(structure,x.getJzjg()));
	 * x.setId(UUID.randomUUID().toString()); });
	 * applyBuildingMapper.batchInsert(applyBuildings); }
	 */

}
