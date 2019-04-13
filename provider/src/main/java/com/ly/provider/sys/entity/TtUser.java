package com.ly.provider.sys.entity;



import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-23 15:22:38
 */

public class TtUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private Long userId;
	/**
	 * 
	 */
	private String avatar;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Date birthday;
	/**
	 * 
	 */
	private Integer sex;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String deptid;
	/**
	 * 
	 */
	private Integer isenale;
	/**
	 * 
	 */
	private Date addTime;
	/**
	 * 
	 */
	private Long addUser;
	/**
	 * 
	 */
	private Date modTime;
	/**
	 * 
	 */
	private Long modUser;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	/**
	 * 获取：
	 */
	public String getDeptid() {
		return deptid;
	}
	/**
	 * 设置：
	 */
	public void setIsenale(Integer isenale) {
		this.isenale = isenale;
	}
	/**
	 * 获取：
	 */
	public Integer getIsenale() {
		return isenale;
	}
	/**
	 * 设置：
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：
	 */
	public void setAddUser(Long addUser) {
		this.addUser = addUser;
	}
	/**
	 * 获取：
	 */
	public Long getAddUser() {
		return addUser;
	}
	/**
	 * 设置：
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
	/**
	 * 获取：
	 */
	public Date getModTime() {
		return modTime;
	}
	/**
	 * 设置：
	 */
	public void setModUser(Long modUser) {
		this.modUser = modUser;
	}
	/**
	 * 获取：
	 */
	public Long getModUser() {
		return modUser;
	}
}
