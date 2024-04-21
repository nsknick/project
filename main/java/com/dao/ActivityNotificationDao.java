package com.dao;

import com.entity.ActivityNotificationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.ActivityNotificationView;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.ActivityNotificationVO;


/**
 * 活动通知
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityNotificationDao extends BaseMapper<ActivityNotificationEntity> {
	
	List<ActivityNotificationVO> selectListVO(@Param("ew") Wrapper<ActivityNotificationEntity> wrapper);
	
	ActivityNotificationVO selectVO(@Param("ew") Wrapper<ActivityNotificationEntity> wrapper);
	
	List<ActivityNotificationView> selectListView(@Param("ew") Wrapper<ActivityNotificationEntity> wrapper);

	List<ActivityNotificationView> selectListView(Pagination page, @Param("ew") Wrapper<ActivityNotificationEntity> wrapper);
	
	ActivityNotificationView selectView(@Param("ew") Wrapper<ActivityNotificationEntity> wrapper);
	

}
