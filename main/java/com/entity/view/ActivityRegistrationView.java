package com.entity.view;

import com.entity.ActivityRegistrationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动报名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("activityRegistration")
public class ActivityRegistrationView extends ActivityRegistrationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ActivityRegistrationView(){
	}
 
 	public ActivityRegistrationView(ActivityRegistrationEntity activityRegistrationEntity){
 	try {
			BeanUtils.copyProperties(this, activityRegistrationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
