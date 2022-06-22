package com.lwch.survey.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lwch.survey.dao.mapper.GroupMemberMapper;
import com.lwch.survey.dao.mapper.MenuMapper;
import com.lwch.survey.dao.mapper.MenuUsergroupMemberMapper;
import com.lwch.survey.model.GroupMember;
import com.lwch.survey.model.GroupMemberExample;
import com.lwch.survey.model.Menu;
import com.lwch.survey.model.MenuExample;
import com.lwch.survey.model.MenuUsergroupMember;
import com.lwch.survey.model.MenuUsergroupMemberExample;
import com.lwch.survey.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
    
    @Autowired
    private MenuMapper menuMapper;
    
    @Autowired
    private MenuUsergroupMemberMapper menuUserMapper;
    
    @Autowired
    private GroupMemberMapper groupMemberMapper;
    
    @Override
    public List<Menu> selectMenuList() {
        MenuExample menuExample = new MenuExample();
        
        menuExample.setOrderByClause("sort");
        
        List<Menu> menusInDB = menuMapper.selectByExample(menuExample);
        
        return convert(menusInDB);
    }
    
    @Override
    public int saveMenu(Menu menu) {
        return menuMapper.insert(menu);
    }
    
    @Override
    public int insertMenus(Long id, List<Long> menuIds) {
        if (menuIds == null || menuIds.isEmpty()) {
            return 0;
        }
        
        MenuUsergroupMemberExample resourceGroupExample = new MenuUsergroupMemberExample();
        resourceGroupExample.createCriteria().andGroupIdEqualTo(id).andMenuIdIn(menuIds);
        
        List<MenuUsergroupMember> existUserGroupMenus = menuUserMapper.selectByExample(resourceGroupExample);
        
        Set<Long> needInsertmenuIds = new HashSet<>(menuIds);
        for (MenuUsergroupMember userGroupMenu : existUserGroupMenus) {
            needInsertmenuIds.remove(userGroupMenu.getMenuId());
        }
        
        for (Long menuId : needInsertmenuIds) {
            MenuUsergroupMember userGroup = new MenuUsergroupMember();
            userGroup.setGroupId(id);
            userGroup.setMenuId(menuId);
            
            menuUserMapper.insert(userGroup);
        }
        
        return needInsertmenuIds.size();
    }

    @Override
    public List<Menu> selectMenuByRole(String username) {
        GroupMemberExample groupMemberExample = new GroupMemberExample();
        groupMemberExample.createCriteria().andUsernameEqualTo(username);
        
        List<GroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);
        
        if (groupMembers.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Long> groupIds = new ArrayList<>(groupMembers.size());
        for (GroupMember groupMember : groupMembers) {
            groupIds.add(groupMember.getGroupId());
        }
        
        MenuUsergroupMemberExample resourceGroupExample = new MenuUsergroupMemberExample();
        resourceGroupExample.createCriteria().andGroupIdIn(groupIds);
        
        List<MenuUsergroupMember> menuUsergroupMembers = menuUserMapper.selectByExample(resourceGroupExample);
        
        if (menuUsergroupMembers.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Long> menuIds = new ArrayList<>(menuUsergroupMembers.size());
        for (MenuUsergroupMember resourceUserGroupMember : menuUsergroupMembers) {
            menuIds.add(resourceUserGroupMember.getMenuId());
        }
        
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andIdIn(menuIds);
        menuExample.setOrderByClause("id asc ,sort asc");
        
        List<Menu> menusInDB = menuMapper.selectByExample(menuExample);
        
        return convert(menusInDB);
    }

    @Override
	public List<Menu> selectMenuByRoleByName(String username) {
    	GroupMemberExample groupMemberExample = new GroupMemberExample();
        groupMemberExample.createCriteria().andUsernameEqualTo(username);
        
        List<GroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);
        
        if (groupMembers.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Long> groupIds = new ArrayList<>(groupMembers.size());
        for (GroupMember groupMember : groupMembers) {
            groupIds.add(groupMember.getGroupId());
        }
        
        MenuUsergroupMemberExample resourceGroupExample = new MenuUsergroupMemberExample();
        resourceGroupExample.createCriteria().andGroupIdIn(groupIds);
        
        List<MenuUsergroupMember> menuUsergroupMembers = menuUserMapper.selectByExample(resourceGroupExample);
        
        if (menuUsergroupMembers.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Long> menuIds = new ArrayList<>(menuUsergroupMembers.size());
        for (MenuUsergroupMember resourceUserGroupMember : menuUsergroupMembers) {
            menuIds.add(resourceUserGroupMember.getMenuId());
        }
        
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andIdIn(menuIds);
        menuExample.setOrderByClause("id asc ,sort asc");
        
        List<Menu> menusInDB = menuMapper.selectByExample(menuExample);
        
        List<Menu> newMuens = convert(menusInDB);
        
        for(Menu menusPid : newMuens) {
        	if(menusPid.getChildren().isEmpty()) {
        		menusInDB.remove(menusPid);
        	}
        }
        
        return menusInDB;
	}

	@Override
    public List<Menu> selectUnDistributed(Long groupId) {
        MenuUsergroupMemberExample resourceGroupExample = new MenuUsergroupMemberExample();
        resourceGroupExample.createCriteria().andGroupIdEqualTo(groupId);
        
        List<MenuUsergroupMember> menuUsergroupMembers = menuUserMapper.selectByExample(resourceGroupExample);
        
        List<Long> menuIds = new ArrayList<>();
        for (MenuUsergroupMember resourceUserGroupMember : menuUsergroupMembers) {
            menuIds.add(resourceUserGroupMember.getMenuId());
        }
        
        MenuExample allMenuExample = new MenuExample();
        allMenuExample.setOrderByClause("sort");
        List<Menu> allMenusInDB = menuMapper.selectByExample(allMenuExample);
        
        List<Menu> unDistributedInDB = new ArrayList<Menu>();
        Map<Long,Menu> menuMap = new TreeMap<Long,Menu>();
        
        for(Menu menu : allMenusInDB){
            if(!menuIds.contains(menu.getId())){
                menuParent(allMenusInDB ,menuMap, menu);
                if(menu.getPid() == null && CollectionUtils.isEmpty(menu.getChildren())){
                    menuMap.put(menu.getId(), menu);
                }
            }
        }
        
        Iterator<Long> it = menuMap.keySet().iterator();  
        while (it.hasNext()) {  
            Long key = it.next();  
            unDistributedInDB.add(menuMap.get(key));  
        }  
        
        return unDistributedInDB;
    }
    
    @Override
    public int deleteMenus(List<Long> menuIds) {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andIdIn(menuIds);
        int i = menuMapper.deleteByExample(menuExample);
        
        MenuUsergroupMemberExample memberExample = new MenuUsergroupMemberExample();
        memberExample.createCriteria().andMenuIdIn(menuIds);
        menuUserMapper.deleteByExample(memberExample);
        
        return i;
    }
    
    private List<Menu> convert(List<Menu> menusInDB) {
        List<Menu> menuList = new ArrayList<>();
        
        for (Menu menu : menusInDB) {
            if(menu.getPid() == null){
                menuList.add(menuChild(menusInDB, menu));
            }
        }
        
        return menuList;
    }
    
    private Menu menuChild(List<Menu> menusInDB, Menu node){
        List<Menu> children = new ArrayList<Menu>();
        for (Menu child : menusInDB) {
            if (node.getId().equals(child.getPid())) {
                children.add(child);
            }
        }
        
        for(Menu child : children){
            Menu n = menuChild(menusInDB, child);
            node.getChildren().add(n);
        }
        
        return node;
    }
    
    private Menu menuParent(List<Menu> menusInDB,Map<Long,Menu> menuMap, Menu node){
        for (Menu parent : menusInDB) {
            if (node.getPid() != null && node.getPid().equals(parent.getId())) {
                Menu n = menuParent(menusInDB,menuMap,parent);
                Menu menu = menuMap.get(n.getId());
                n.getChildren().add(node);
                if(menu == null){
                    menuMap.put(n.getId(), n);
                }
            }
        }
        
        return node;
    }

    @Override
    public List<Menu> selectByExample(String menuname) {
    	MenuExample example =new MenuExample();
    	if(!menuname.isEmpty()){
    		example.createCriteria().andNameEqualTo(menuname);
    	}
        return menuMapper.selectByExample(example);
    }
    
    
}
