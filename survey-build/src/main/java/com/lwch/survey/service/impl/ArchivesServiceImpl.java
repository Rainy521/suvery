/**
 * 
 */
package com.lwch.survey.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwch.survey.dao.mapper.ArchiveMapper;
import com.lwch.survey.model.Archive;
import com.lwch.survey.model.ArchiveExample;
import com.lwch.survey.service.ArchivesService;

/**
 * @author Rain
 *
 */
@Service
public class ArchivesServiceImpl implements ArchivesService{
    
    @Autowired
    private ArchiveMapper archiveMapper;

    @Override
    public List<Archive> getAllArchives(ArchiveExample archiveExample) {
        List<Archive> archiveList = new ArrayList<Archive>();
        List<Archive> archives = archiveMapper.selectByExample(archiveExample);
        
        for (Archive member : archives) {
            if(member.getPid() == null){
                archiveList.add(child(archives, member));
            }
        }
        return archiveList;
    }

    @Override
    public List<Archive> getArchives(ArchiveExample archiveExample, String query) {
        
        if(!StringUtils.isNotBlank(query)){
            return convert(archiveMapper.selectByExample(archiveExample));
        }
        
        archiveExample.createCriteria().andCasenumberLike("%" + query + "%");
        List<Archive> listArchives = archiveMapper.selectByExample(archiveExample);
        if(listArchives.isEmpty()){
            return Collections.emptyList();
        }
        
        Archive entity = new Archive();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(query);
        entity.setPid(listArchives.get(0).getPid());
        entity.setNext("1");
        entity.setChildren(null);
        
        List<Archive> list = new ArrayList<>();
        list.add(entity);
        listArchives.get(0).setChildren(list);
        
        entity = listArchives.get(0);
        String pid = listArchives.get(0).getPid();
        
        while(pid != null){
            Archive temp = archiveMapper.selectByPrimaryKey(pid);
            if(temp != null){
                List<Archive> newlist = new ArrayList<>();
                newlist.add(entity);
                temp.setChildren(newlist);
                entity = temp;
                pid = temp.getPid();
            }else{
                pid = null;
            }
        }
        
        List<Archive> archives = new ArrayList<>();
        archives.add(entity);
        
        return archives;
    }

    @Override
    public void insertManage(Archive archive) {
        archive.setId(UUID.randomUUID().toString());
        archive.setNext("0");
        archive.setIsempty(0);
        archiveMapper.insertSelective(archive);
    }

    @Override
    public void updateManage(Archive archive) {
        archiveMapper.updateByPrimaryKeySelective(archive);
    }

    @Override
    public boolean selectId(String id) {
        ArchiveExample archiveExample = new ArchiveExample();
        archiveExample.createCriteria().andCasenumberLike("%" + id + "%");
        List<Archive> archives = archiveMapper.selectByExample(archiveExample);
        
        if(archives.isEmpty()){
            return false;
        }else{
            return true;
        }
        
    }

    private List<Archive> convert(List<Archive> archiveInDB) {
        List<Archive> archiveList = new ArrayList<Archive>();
        
        for (Archive member : archiveInDB) {
            if(member.getPid() == null){
                archiveList.add(archiveChild(archiveInDB, member));
            }
        }
        
        return archiveList;
    }
    
    private Archive archiveChild(List<Archive> archiveInDB, Archive node){
        List<Archive> children = new ArrayList<Archive>();
        for (Archive child : archiveInDB) {
            if (node.getId().equals(child.getPid())) {
                List<Archive> eren = new ArrayList<Archive>();
                if(null != child.getCasenumber()){
                    String[] members = child.getCasenumber().split(",");
                    for(String temp : members){
                        Archive entity = new Archive();
                        entity.setId(UUID.randomUUID().toString());
                        entity.setName(temp);
                        entity.setPid(child.getId());
                        entity.setNext("1");
                        entity.setChildren(null);
                        eren.add(entity);
                    }
                }
                child.setChildren(eren);
                children.add(child);
            }
        }
        
        for(Archive child : children){
            Archive n = archiveChild(archiveInDB, child);
            node.getChildren().add(n);
        }
        
        return node;
    }
    
    private Archive child(List<Archive> archiveInDB, Archive node){
        List<Archive> children = new ArrayList<Archive>();
        for (Archive child : archiveInDB) {
            if (node.getId().equals(child.getPid())) {
                children.add(child);
            }
        }
        
        for(Archive child : children){
            Archive n = child(archiveInDB, child);
            node.getChildren().add(n);
        }
        
        return node;
    }
}
