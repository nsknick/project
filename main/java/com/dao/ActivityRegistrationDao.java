package com.dao;

import com.entity.ActivityRegistrationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.ActivityRegistrationView;
import com.entity.vo.ActivityRegistrationVO;
import org.apache.ibatis.annotations.Param;


/**
 * 活动报名
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityRegistrationDao extends BaseMapper<ActivityRegistrationEntity> {
	
	List<ActivityRegistrationVO> selectListVO(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	
	ActivityRegistrationVO selectVO(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	
	List<ActivityRegistrationView> selectListView(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);

	List<ActivityRegistrationView> selectListView(Pagination page, @Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	
	ActivityRegistrationView selectView(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
	

}
