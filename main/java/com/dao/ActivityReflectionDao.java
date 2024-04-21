package com.dao;

import com.entity.ActivityReflectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.ActivityReflectionView;
import com.entity.vo.ActivityReflectionVO;
import org.apache.ibatis.annotations.Param;


/**
 * 活动心得
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityReflectionDao extends BaseMapper<ActivityReflectionEntity> {
	
	List<ActivityReflectionVO> selectListVO(@Param("ew") Wrapper<ActivityReflectionEntity> wrapper);
	
	ActivityReflectionVO selectVO(@Param("ew") Wrapper<ActivityReflectionEntity> wrapper);
	
	List<ActivityReflectionView> selectListView(@Param("ew") Wrapper<ActivityReflectionEntity> wrapper);

	List<ActivityReflectionView> selectListView(Pagination page, @Param("ew") Wrapper<ActivityReflectionEntity> wrapper);
	
	ActivityReflectionView selectView(@Param("ew") Wrapper<ActivityReflectionEntity> wrapper);
	

}
