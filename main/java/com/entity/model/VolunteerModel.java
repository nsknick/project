package com.entity.model;

import java.io.Serializable;
 

/**
 * 志愿者
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public class VolunteerModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String password;
		
	/**
	 * 姓名
	 */
	
	private String name;
		
	/**
	 * 性别
	 */
	
	private String gender;
		
	/**
	 * 头像
	 */
	
	private String profilepicture;
		
	/**
	 * 年龄
	 */
	
	private String age;
		
	/**
	 * 班级
	 */
	
	private String classes;
		
	/**
	 * 邮箱
	 */
	
	private String email;
		
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
	 * 设置：密码
	 */
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
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
	 * 设置：性别
	 */
	 
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}
	
	/**
	 * 获取：头像
	 */
	public String getProfilepicture() {
		return profilepicture;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setAge(String age) {
		this.age = age;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getAge() {
		return age;
	}
				
	
	/**
	 * 设置：班级
	 */
	 
	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	/**
	 * 获取：班级
	 */
	public String getClasses() {
		return classes;
	}
				
	
	/**
	 * 设置：邮箱
	 */
	 
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
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
