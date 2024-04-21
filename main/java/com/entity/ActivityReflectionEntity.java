package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;


/**
 * 活动心得
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("activityReflection")
public class ActivityReflectionEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ActivityReflectionEntity() {
		
	}
	
	public ActivityReflectionEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 活动名称
	 */
					
	private String activityname;
	
	/**
	 * 活动类型
	 */
					
	private String activitytype;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 心得分享
	 */
					
	private String reflection;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date publishtime;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：活动名称
	 */
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	/**
	 * 获取：活动名称
	 */
	public String getActivityname() {
		return activityname;
	}
	/**
	 * 设置：活动类型
	 */
	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}
	/**
	 * 获取：活动类型
	 */
	public String getActivitytype() {
		return activitytype;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：心得分享
	 */
	public void setReflection(String reflection) {
		this.reflection = reflection;
	}
	/**
	 * 获取：心得分享
	 */
	public String getReflection() {
		return reflection;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishtime() {
		return publishtime;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
