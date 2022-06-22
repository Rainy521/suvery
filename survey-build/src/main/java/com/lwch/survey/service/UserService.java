package com.lwch.survey.service;

import java.util.List;

import com.lwch.survey.model.User;
import com.lwch.survey.model.UserExample;
import com.lwch.survey.model.UserGroup;

public interface UserService {
    
    /**
     * 得到满足条件的用户数量
     * @param query 页面传递查询参数 
     * @return long
     */
    long getCount(String query ,int userType);
    
    /**
     * 查询全部用户并根据条件分页展示
     * @param query 页面传递查询参数
     * @param userType 用户类型
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return List 用户集合
     */
    List<User> selectALLUsers(String query, int userType, int pageNum, int pageSize);
    
    /**
     * 根据查询条件，返回满足条件的用户
     * @param example 查询条件
     * @return List 用户集合
     */
    List<User> selectByExample(UserExample example);
    
    /**
     * 根据名字，查询用户组
     * @param name 用户组名
     * @return List 用户组集合
     */
    List<UserGroup> selectUserGroupByName(String name);
    
    /**
     * 根据用户名查询个人相关信息
     * @param username 用户名
     * @return User 用户对象
     */
    User selectByPrimaryKey(String username);
    
    /**
     * 根据要删除的用户id，以及组id删除相应的关系以及用户
     * @param id 用户id
     * @param groupIds 组id
     * @return int
     */
    int deleteGroups(String id, List<Long> groupIds);
    
    /**
     * 修改用户状态信息，改变登录锁定状态（关）
     * @param name 用户名
     */
    void lockUser(String name);
    
    /**
     * 修改用户状态信息，改变登录锁定状态（开）
     * @param name 用户名
     */
    void unlockUser(String name);
    
    /**
     * 重置密码
     * @param username 用户名
     * @param password 密码
     */
    void resetPassword(String username,  String password);
    
    /**
     * 修改昵称
     * @param username 用户名
     * @param nickname 昵称
     */
    void resetNickname(String username,  String nickname);
    
    /**
     * 修改基本信息
     * @param user
     */
    void updateUser(User user);
    
    /**
     * 新增用户
     * @param record 用户对象
     * @return int
     */
    int insert(User record);
    
    static final int USER_TYPE_PLATFORM = 0;
    static final int USER_TYPE_PERSONAL = 1;
    static final int USER_TYPE_BUSINESS = 2;
}
