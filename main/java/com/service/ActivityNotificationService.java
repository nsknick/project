package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ActivityNotificationEntity;
import com.entity.vo.ActivityNotificationVO;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ActivityNotificationView;


/**
 * 活动通知
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityNotificationService extends IService<ActivityNotificationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ActivityNotificationVO> selectListVO(Wrapper<ActivityNotificationEntity> wrapper);
   	
   	ActivityNotificationVO selectVO(@Param("ew") Wrapper<ActivityNotificationEntity> wrapper);
   	
   	List<ActivityNotificationView> selectListView(Wrapper<ActivityNotificationEntity> wrapper);
   	
   	ActivityNotificationView selectView(@Param("ew") Wrapper<ActivityNotificationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityNotificationEntity> wrapper);
   	

}

