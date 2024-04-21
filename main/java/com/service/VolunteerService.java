package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.view.VolunteerView;
import com.entity.vo.VolunteerVO;
import com.utils.PageUtils;
import com.entity.VolunteerEntity;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 志愿者
 *
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
public interface VolunteerService extends IService<VolunteerEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<VolunteerVO> selectListVO(Wrapper<VolunteerEntity> wrapper);
   	
   	VolunteerVO selectVO(@Param("ew") Wrapper<VolunteerEntity> wrapper);
   	
   	List<VolunteerView> selectListView(Wrapper<VolunteerEntity> wrapper);
   	
   	VolunteerView selectView(@Param("ew") Wrapper<VolunteerEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<VolunteerEntity> wrapper);
   	

}

