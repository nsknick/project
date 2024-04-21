package com.dao;

import com.entity.ActivityInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.ActivityInfoView;
import com.entity.vo.ActivityInfoVO;
import org.apache.ibatis.annotations.Param;


/**
 * 活动信息
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityInfoDao extends BaseMapper<ActivityInfoEntity> {
	
	List<ActivityInfoVO> selectListVO(@Param("ew") Wrapper<ActivityInfoEntity> wrapper);
	
	ActivityInfoVO selectVO(@Param("ew") Wrapper<ActivityInfoEntity> wrapper);
	
	List<ActivityInfoView> selectListView(@Param("ew") Wrapper<ActivityInfoEntity> wrapper);

	List<ActivityInfoView> selectListView(Pagination page, @Param("ew") Wrapper<ActivityInfoEntity> wrapper);
	
	ActivityInfoView selectView(@Param("ew") Wrapper<ActivityInfoEntity> wrapper);
	

}
