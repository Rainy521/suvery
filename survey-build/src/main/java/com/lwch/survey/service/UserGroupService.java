package com.lwch.survey.service;
import java.util.List;

import com.lwch.survey.model.GroupRole;
import com.lwch.survey.model.Groups;
import com.lwch.survey.model.Menu;
import com.lwch.survey.model.UserGroup;
import com.lwch.survey.model.UserGroupExample;
import com.lwch.survey.pojo.PageParm;

public interface UserGroupService {
    
    /**
     * 通过id查询用户组关系信息
     * @param id 组ID
     * @return UserGroup 用户组对象
     */
    UserGroup selectByPrimaryKey(Long id);
    
    /**
     * 查询满足条件的全部用户组对应信息
     * @param example 查询条件
     * @param pageParm 分页类
     * @return 用户组集合
     */
    List<UserGroup> selectByExample(UserGroupExample example, PageParm pageParm);
    
    /**
     * 查询全部用户组信息
     * @return List 用户组集合
     */
    List<UserGroup> selectByExample();
    
    /**
     * 用户组分配用户根据组id用户名
     * @param id 组id
     * @param userNames 用户名
     * @return int
     */
    int insertUsers(Long id, List<String> userNames);
    
    /**
     * 用户组删除用户操作
     * @param id 组ID
     * @param userNames 用户名
     * @return int
     */
    int deleteUsers(Long id, List<String> userNames);
    
    /**
     * 根据用户组id，查询绑定的菜单
     * @param id 组id
     * @return List 菜单集合
     */
    List<Menu> selectMenus(Long id);
    
    /**
     * 根绝用户组id，删除一个菜单
     * @param id 组id
     * @param menuIds 菜单ID
     * @return int
     */
    int deleteMenus(Long id, List<Long> menuIds);
    
    /**
     * 返回用户组数量
     * @return int
     */
    int getCount();
    
    /**
     * 删除用户组
     * @param name 组名
     * @return int
     */
    int deleteUserGroup(String name);
    
    /**
     * 遍历所有角色
     * @return List 角色集合
     */
    List<GroupRole> selectByGroupRoles();
    
    /**
     * 根据名字得到组相应信息
     * @param name 组名
     * @return List 组信息集合
     */
    List<Groups> selectGroupInfo(String name);  
    
}
