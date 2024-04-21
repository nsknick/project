package com.dao;

import com.entity.ActivityTypeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.ActivityTypeView;
import com.entity.vo.ActivityTypeVO;
import org.apache.ibatis.annotations.Param;


/**
 * 活动类型
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityTypeDao extends BaseMapper<ActivityTypeEntity> {
	
	List<ActivityTypeVO> selectListVO(@Param("ew") Wrapper<ActivityTypeEntity> wrapper);
	
	ActivityTypeVO selectVO(@Param("ew") Wrapper<ActivityTypeEntity> wrapper);
	
	List<ActivityTypeView> selectListView(@Param("ew") Wrapper<ActivityTypeEntity> wrapper);

	List<ActivityTypeView> selectListView(Pagination page, @Param("ew") Wrapper<ActivityTypeEntity> wrapper);
	
	ActivityTypeView selectView(@Param("ew") Wrapper<ActivityTypeEntity> wrapper);
	

}
