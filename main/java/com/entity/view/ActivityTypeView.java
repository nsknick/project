package com.entity.view;

import com.entity.ActivityTypeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@TableName("activityType")
public class ActivityTypeView extends ActivityTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ActivityTypeView(){
	}
 
 	public ActivityTypeView(ActivityTypeEntity activityTypeEntity){
 	try {
			BeanUtils.copyProperties(this, activityTypeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
