package com.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 活动信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public class ActivityInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
