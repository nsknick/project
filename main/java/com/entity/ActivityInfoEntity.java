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
 * 活动信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("activityinfo")
public class
ActivityInfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ActivityInfoEntity() {
		
	}
	
	public ActivityInfoEntity(T t) {
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
	 * 活动时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date time;
	
	/**
	 * 人数
	 */
					
	private Integer people;
	
	/**
	 * 活动场地
	 */
					
	private String location;
	
	/**
	 * 活动介绍
	 */
					
	private String introduction;
	
	/**
	 * 是否审核
	 */
					
	private String isReviewed;
	
	/**
	 * 审核回复
	 */
					
	private String reviewResponse;
	
	
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
	 * 设置：活动时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：活动时间
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * 设置：人数
	 */
	public void setPeople(Integer people) {
		this.people = people;
	}
	/**
	 * 获取：人数
	 */
	public Integer getPeople() {
		return people;
	}
	/**
	 * 设置：活动场地
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 获取：活动场地
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 设置：活动介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：活动介绍
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：是否审核
	 */
	public void setIsReviewed(String isReviewed) {
		this.isReviewed = isReviewed;
	}
	/**
	 * 获取：是否审核
	 */
	public String getIsReviewed() {
		return isReviewed;
	}
	/**
	 * 设置：审核回复
	 */
	public void setReviewResponse(String reviewResponse) {
		this.reviewResponse = reviewResponse;
	}
	/**
	 * 获取：审核回复
	 */
	public String getReviewResponse() {
		return reviewResponse;
	}

}
