package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ActivityReflectionEntity;
import com.entity.view.ActivityReflectionView;
import com.entity.vo.ActivityReflectionVO;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 活动心得
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityReflectionService extends IService<ActivityReflectionEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ActivityReflectionVO> selectListVO(Wrapper<ActivityReflectionEntity> wrapper);
   	
   	ActivityReflectionVO selectVO(@Param("ew") Wrapper<ActivityReflectionEntity> wrapper);
   	
   	List<ActivityReflectionView> selectListView(Wrapper<ActivityReflectionEntity> wrapper);
   	
   	ActivityReflectionView selectView(@Param("ew") Wrapper<ActivityReflectionEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityReflectionEntity> wrapper);
   	

}

