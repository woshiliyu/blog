package com.ly.provider.sys.controller;

import java.util.List;

import com.ly.provider.sys.Service.UserService;
import com.ly.provider.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * 用户 信息操作处理
 *
 * @author ruoyi
 * @date 2018-11-30
 *
 *
 */
@RestController
public class UserController
{
    private String prefix = "module/user";
	
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/selectUserById", method = RequestMethod.GET)
	public User selectUserById(@RequestParam(value = "userid", required = true) int userid){
		return  userService.selectUserById(userid);
	}


	@RequestMapping(value = "/selectUserByUserName", method = RequestMethod.GET)
	public User selectUserByUserName(@RequestParam(value = "username", required = true) String username){
		return  userService.selectUserByUserName(username);
	}
	
}
