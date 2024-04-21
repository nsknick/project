package com.dao;

import com.entity.VolunteerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.VolunteerView;
import com.entity.vo.VolunteerVO;
import org.apache.ibatis.annotations.Param;


/**
 * 志愿者
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface VolunteerDao extends BaseMapper<VolunteerEntity> {
	
	List<VolunteerVO> selectListVO(@Param("ew") Wrapper<VolunteerEntity> wrapper);
	
	VolunteerVO selectVO(@Param("ew") Wrapper<VolunteerEntity> wrapper);
	
	List<VolunteerView> selectListView(@Param("ew") Wrapper<VolunteerEntity> wrapper);

	List<VolunteerView> selectListView(Pagination page, @Param("ew") Wrapper<VolunteerEntity> wrapper);
	
	VolunteerView selectView(@Param("ew") Wrapper<VolunteerEntity> wrapper);
	

}
