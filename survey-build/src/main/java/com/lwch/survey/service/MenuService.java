package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.Menu;

public interface MenuService {

    /**
     * 查询菜单信息
     * @return List 菜单集合
     */
    List<Menu> selectMenuList();
    
    /**
     * 根据组id查询菜单信息
     * @param groupId 组ID
     * @return List 菜单集合
     */
    List<Menu> selectUnDistributed(Long groupId);
    
    /**
     * 根据用户名查询菜单信息
     * @param username 用户名
     * @return List 菜单集合
     */
    List<Menu> selectMenuByRole(String username);
    
    /**
     * 根据用户名查询菜单信息
     * @param username 用户名
     * @return List 菜单集合
     */
    List<Menu> selectMenuByRoleByName(String username);
    
    /**
     * 根据菜单名查询菜单信息
     * @param menuname 菜单名
     * @return List 菜单集合
     */
    List<Menu> selectByExample(String menuname);
    
    /**
     * 新增菜单及用户组信息
     * @param id 组ID
     * @param menuIds 菜单ID
     * @return int
     */
    int insertMenus(Long id, List<Long> menuIds);
    
    /**
     * 新增菜单
     * @param menu 菜单对象
     * @return int
     */
    int saveMenu(Menu menu);
    
    /**
     * 删除菜单
     * @param menuIds 菜单ID
     * @return int
     */
    int deleteMenus(List<Long> menuIds);
}
