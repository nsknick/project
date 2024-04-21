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
 * 志愿者
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("volunteer")
public class VolunteerEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public VolunteerEntity() {
		
	}
	
	public VolunteerEntity(T t) {
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
	 * 学号
	 */
					
	private String studentid;
	
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
