package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.view.ActivityInfoView;
import com.entity.vo.ActivityInfoVO;
import com.utils.PageUtils;
import com.entity.ActivityInfoEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 活动信息
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface ActivityInfoService extends IService<ActivityInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ActivityInfoVO> selectListVO(Wrapper<ActivityInfoEntity> wrapper);
   	
   	ActivityInfoVO selectVO(@Param("ew") Wrapper<ActivityInfoEntity> wrapper);
   	
   	List<ActivityInfoView> selectListView(Wrapper<ActivityInfoEntity> wrapper);
   	
   	ActivityInfoView selectView(@Param("ew") Wrapper<ActivityInfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ActivityInfoEntity> wrapper);
   	

}

