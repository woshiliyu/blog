package com.ly.provider.sys.entity;



import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-17 15:56:33
 */

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private Integer aid;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 文章缩略名
	 */
	private String slug;
	/**
	 * 文字内容
	 */
	private String content;
	/**
	 * 作者
	 */
	private Integer authorid;
	/**
	 * 是否置顶，1置顶，0不置顶
	 */
	private Integer setTop;
	/**
	 * 文章点击次数
	 */
	private Integer hits;
	/**
	 * 文章缩略图
	 */
	private String thumbimg;
	/**
	 * 标签列表
	 */
	private String tags;
	/**
	 * 分类列表
	 */
	private Integer categoriesId;
	/**
	 * 类型：原创,转载,(由参数article_type决定)
	 */
	private Integer articleType;
	/**
	 * 是否公开，1公开，0私有
	 */
	private Integer publicType;
	/**
	 * 内容所属评论数
	 */
	private Integer commentsnum;
	/**
	 * 有效性
	 */
	private Integer isenable;
	/**
	 * 
	 */
	private Date addtime;
	/**
	 * 
	 */
	private Date modtime;

	/**
	 * 设置：
	 */
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	/**
	 * 获取：
	 */
	public Integer getAid() {
		return aid;
	}
	/**
	 * 设置：文章标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：文章标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：文章缩略名
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * 获取：文章缩略名
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * 设置：文字内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：文字内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}
	/**
	 * 获取：作者
	 */
	public Integer getAuthorid() {
		return authorid;
	}
	/**
	 * 设置：是否置顶，1置顶，0不置顶
	 */
	public void setSetTop(Integer setTop) {
		this.setTop = setTop;
	}
	/**
	 * 获取：是否置顶，1置顶，0不置顶
	 */
	public Integer getSetTop() {
		return setTop;
	}
	/**
	 * 设置：文章点击次数
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：文章点击次数
	 */
	public Integer getHits() {
		return hits;
	}
	/**
	 * 设置：文章缩略图
	 */
	public void setThumbimg(String thumbimg) {
		this.thumbimg = thumbimg;
	}
	/**
	 * 获取：文章缩略图
	 */
	public String getThumbimg() {
		return thumbimg;
	}
	/**
	 * 设置：标签列表
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * 获取：标签列表
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * 设置：分类列表
	 */
	public void setCategoriesId(Integer categoriesId) {
		this.categoriesId = categoriesId;
	}
	/**
	 * 获取：分类列表
	 */
	public Integer getCategoriesId() {
		return categoriesId;
	}
	/**
	 * 设置：类型：原创,转载,(由参数article_type决定)
	 */
	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}
	/**
	 * 获取：类型：原创,转载,(由参数article_type决定)
	 */
	public Integer getArticleType() {
		return articleType;
	}
	/**
	 * 设置：是否公开，1公开，0私有
	 */
	public void setPublicType(Integer publicType) {
		this.publicType = publicType;
	}
	/**
	 * 获取：是否公开，1公开，0私有
	 */
	public Integer getPublicType() {
		return publicType;
	}
	/**
	 * 设置：内容所属评论数
	 */
	public void setCommentsnum(Integer commentsnum) {
		this.commentsnum = commentsnum;
	}
	/**
	 * 获取：内容所属评论数
	 */
	public Integer getCommentsnum() {
		return commentsnum;
	}
	/**
	 * 设置：有效性
	 */
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	/**
	 * 获取：有效性
	 */
	public Integer getIsenable() {
		return isenable;
	}
	/**
	 * 设置：
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：
	 */
	public void setModtime(Date modtime) {
		this.modtime = modtime;
	}
	/**
	 * 获取：
	 */
	public Date getModtime() {
		return modtime;
	}
}
