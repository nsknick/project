package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscussActivityExperienceEntity;
import com.entity.vo.DiscussActivityExperienceVO;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussActivityExperienceView;


/**
 * 活动心得评论表
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface DiscussActivityExperienceService extends IService<DiscussActivityExperienceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussActivityExperienceVO> selectListVO(Wrapper<DiscussActivityExperienceEntity> wrapper);
   	
   	DiscussActivityExperienceVO selectVO(@Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);
   	
   	List<DiscussActivityExperienceView> selectListView(Wrapper<DiscussActivityExperienceEntity> wrapper);
   	
   	DiscussActivityExperienceView selectView(@Param("ew") Wrapper<DiscussActivityExperienceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussActivityExperienceEntity> wrapper);
   	

}

