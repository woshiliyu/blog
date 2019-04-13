package com.ly.provider.sys.entity;



import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-15 22:35:27
 */

public class TtMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private Integer id;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private String path;
	/**
	 * 
	 */
	private String component;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String iconcls;
	/**
	 * 
	 */
	private Integer keepalive;
	/**
	 * 
	 */
	private Integer requireauth;
	/**
	 * 
	 */
	private Integer parentid;
	/**
	 * 是否启用 0 不启用 1 启用
	 */
	private Integer isenale;
	/**
	 * 添加时间
	 */
	private Date addTime;
	/**
	 * 添加人
	 */
	private Long addUser;
	/**
	 * 修改时间
	 */
	private Date modTime;
	/**
	 * 修改人
	 */
	private Long modUser;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 获取：
	 */
	public String getPath() {
		return path;
	}
	/**
	 * 设置：
	 */
	public void setComponent(String component) {
		this.component = component;
	}
	/**
	 * 获取：
	 */
	public String getComponent() {
		return component;
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
	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}
	/**
	 * 获取：
	 */
	public String getIconcls() {
		return iconcls;
	}
	/**
	 * 设置：
	 */
	public void setKeepalive(Integer keepalive) {
		this.keepalive = keepalive;
	}
	/**
	 * 获取：
	 */
	public Integer getKeepalive() {
		return keepalive;
	}
	/**
	 * 设置：
	 */
	public void setRequireauth(Integer requireauth) {
		this.requireauth = requireauth;
	}
	/**
	 * 获取：
	 */
	public Integer getRequireauth() {
		return requireauth;
	}
	/**
	 * 设置：
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：
	 */
	public Integer getParentid() {
		return parentid;
	}
	/**
	 * 设置：是否启用 0 不启用 1 启用
	 */
	public void setIsenale(Integer isenale) {
		this.isenale = isenale;
	}
	/**
	 * 获取：是否启用 0 不启用 1 启用
	 */
	public Integer getIsenale() {
		return isenale;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：添加人
	 */
	public void setAddUser(Long addUser) {
		this.addUser = addUser;
	}
	/**
	 * 获取：添加人
	 */
	public Long getAddUser() {
		return addUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModTime() {
		return modTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModUser(Long modUser) {
		this.modUser = modUser;
	}
	/**
	 * 获取：修改人
	 */
	public Long getModUser() {
		return modUser;
	}
}
