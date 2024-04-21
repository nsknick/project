package com.dao;

import com.entity.DiscussActivityExperienceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.view.DiscussActivityExperienceView;
import com.entity.vo.DiscussActivityExperienceVO;
import org.apache.ibatis.annotations.Param;


/**
 * 活动心得评论表
 * 
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface DiscussActivityExperienceDao extends BaseMapper<DiscussActivityExperienceEntity> {
	
	List<DiscussActivityExperienceVO> selectListVO(@Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);
	
	DiscussActivityExperienceVO selectVO(@Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);
	
	List<DiscussActivityExperienceView> selectListView(@Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);

	List<DiscussActivityExperienceView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);
	
	DiscussActivityExperienceView selectView(@Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);
	

}
