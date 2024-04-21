package com.entity.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 活动报名
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public class ActivityRegistrationModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 活动类型
	 */
	
	private String activitytype;
		
	/**
	 * 人数
	 */
	
	private Integer people;
		
	/**
	 * 报名说明
	 */
	
	private String description;
		
	/**
	 * 报名时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date registrationtime;
		
	/**
	 * 学号
	 */
	
	private String studentid;
		
	/**
	 * 姓名
	 */
	
	private String name;
		
	/**
	 * 手机
	 */
	
	private String phonenumber;
		
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
	 * 设置：报名说明
	 */
	 
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 获取：报名说明
	 */
	public String getDescription() {
		return description;
	}
				
	
	/**
	 * 设置：报名时间
	 */
	 
	public void setRegistrationtime(Date registrationtime) {
		this.registrationtime = registrationtime;
	}
	
	/**
	 * 获取：报名时间
	 */
	public Date getRegistrationtime() {
		return registrationtime;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
	/**
	 * 获取：学号
	 */
	public String getStudentid() {
		return studentid;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	/**
	 * 获取：手机
	 */
	public String getPhonenumber() {
		return phonenumber;
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
