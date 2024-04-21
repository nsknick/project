package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ActivityTypeEntity;
import com.entity.vo.ActivityTypeVO;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ActivityTypeView;


/**
 * 活动类型
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityTypeService extends IService<ActivityTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ActivityTypeVO> selectListVO(Wrapper<ActivityTypeEntity> wrapper);
   	
   	ActivityTypeVO selectVO(@Param("ew") Wrapper<ActivityTypeEntity> wrapper);
   	
   	List<ActivityTypeView> selectListView(Wrapper<ActivityTypeEntity> wrapper);
   	
   	ActivityTypeView selectView(@Param("ew") Wrapper<ActivityTypeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityTypeEntity> wrapper);
   	

}

