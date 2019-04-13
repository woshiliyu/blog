package com.ly.provider.sys.dao;


import com.ly.provider.sys.entity.TtUser;
import com.ly.provider.sys.entity.User;

import java.util.List;

/**
 * 用户 数据层
 * 
 * @author ruoyi
 * @date 2018-11-30
 */
public interface UserDao
{
	/**
     * 查询用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
	public User selectUserById(Integer userId);


	/**
	 * 查询用户信息
	 *
	 * @param userName 用户ID
	 * @return 用户信息
	 */
	public User selectUserByUserName(String  userName);
	
	/**
     * 查询用户列表
     * 
     * @param user 用户信息
     * @return 用户集合
     */
	public List<User> selectUserList(User user);
	
	/**
     * 新增用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	public int insertUser(User user);
	
	/**
     * 修改用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	public int updateUser(User user);
	
	/**
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
	public int deleteUserById(Integer userId);
	
	/**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteUserByIds(String[] userIds);
	
}