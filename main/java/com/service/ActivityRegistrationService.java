package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ActivityRegistrationEntity;
import com.entity.view.ActivityRegistrationView;
import com.entity.vo.ActivityRegistrationVO;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 活动报名
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityRegistrationService extends IService<ActivityRegistrationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ActivityRegistrationVO> selectListVO(Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	ActivityRegistrationVO selectVO(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	List<ActivityRegistrationView> selectListView(Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	ActivityRegistrationView selectView(@Param("ew") Wrapper<ActivityRegistrationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityRegistrationEntity> wrapper);
   	

}

