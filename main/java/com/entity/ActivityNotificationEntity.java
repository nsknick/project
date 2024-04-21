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
 * 活动通知
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("activitynotification")
public class ActivityNotificationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ActivityNotificationEntity() {
		
	}
	
	public ActivityNotificationEntity(T t) {
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
	 * 标题
	 */
					
	private String title;
	
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
	 * 通知内容
	 */
					
	private String notificationContent;
	
	/**
	 * 通知时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date notificationTime;
	
	
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
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
	 * 设置：通知内容
	 */
	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}
	/**
	 * 获取：通知内容
	 */
	public String getNotificationContent() {
		return notificationContent;
	}
	/**
	 * 设置：通知时间
	 */
	public void setNotificationTime(Date notificationTime) {
		this.notificationTime = notificationTime;
	}
	/**
	 * 获取：通知时间
	 */
	public Date getNotificationTime() {
		return notificationTime;
	}

}
