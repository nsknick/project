package com.entity.vo;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 活动心得
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public class ActivityReflectionVO implements Serializable {
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
