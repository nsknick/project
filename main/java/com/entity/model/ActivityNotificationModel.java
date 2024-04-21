package com.entity.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 活动通知
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public class ActivityNotificationModel implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
