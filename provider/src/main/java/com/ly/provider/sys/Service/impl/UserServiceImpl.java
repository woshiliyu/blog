package com.ly.provider.sys.Service.impl;

import java.util.List;

import com.ly.provider.sys.Service.UserService;
import com.ly.provider.sys.dao.UserDao;
import com.ly.provider.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-30
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	/**
     * 查询用户信息
     * 
     * @param userId 用户ID
     * @return 用户信息
     */
    @Override
	public User selectUserById(Integer userId)
	{
	    return userDao.selectUserById(userId);
	}

	@Override
	public User selectUserByUserName(String userName) {
		return userDao.selectUserByUserName(userName);
	}

	/**
     * 查询用户列表
     * 
     * @param user 用户信息
     * @return 用户集合
     */
	@Override
	public List<User> selectUserList(User user)
	{
	    return userDao.selectUserList(user);
	}
	
    /**
     * 新增用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	@Override
	public int insertUser(User user)
	{
	    return userDao.insertUser(user);
	}
	
	/**
     * 修改用户
     * 
     * @param user 用户信息
     * @return 结果
     */
	@Override
	public int updateUser(User user)
	{
	    return userDao.updateUser(user);
	}



	
}
