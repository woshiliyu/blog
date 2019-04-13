package com.ly.provider.sys.entity;



import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-25 16:14:01
 */

public class House implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private Integer houseId;
	/**
	 * 
	 */
	private String houseName;
	/**
	 * 
	 */
	private String roomNum;
	/**
	 * 
	 */
	private String bedNum;
	/**
	 * 
	 */
	private String pwd;
	/**
	 * 
	 */
	private Date addTime;
	/**
	 * 
	 */
	private Date modTime;
	/**
	 * 
	 */
	private Integer isenable;

	/**
	 * 设置：
	 */
	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}
	/**
	 * 获取：
	 */
	public Integer getHouseId() {
		return houseId;
	}
	/**
	 * 设置：
	 */
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	/**
	 * 获取：
	 */
	public String getHouseName() {
		return houseName;
	}
	/**
	 * 设置：
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	/**
	 * 获取：
	 */
	public String getRoomNum() {
		return roomNum;
	}
	/**
	 * 设置：
	 */
	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}
	/**
	 * 获取：
	 */
	public String getBedNum() {
		return bedNum;
	}
	/**
	 * 设置：
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * 获取：
	 */
	public String getPwd() {
		return pwd;
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
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	/**
	 * 获取：
	 */
	public Integer getIsenable() {
		return isenable;
	}
}
