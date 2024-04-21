package com.service.impl;

import com.dao.ActivityTypeDao;
import com.entity.ActivityTypeEntity;
import com.entity.view.ActivityTypeView;
import com.entity.vo.ActivityTypeVO;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.service.ActivityTypeService;

@Service("activitytypeService")
public class ActivityTypeServiceImpl extends ServiceImpl<ActivityTypeDao, ActivityTypeEntity> implements ActivityTypeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityTypeEntity> page = this.selectPage(
                new Query<ActivityTypeEntity>(params).getPage(),
                new EntityWrapper<ActivityTypeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ActivityTypeEntity> wrapper) {
		  Page<ActivityTypeView> page =new Query<ActivityTypeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ActivityTypeVO> selectListVO(Wrapper<ActivityTypeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ActivityTypeVO selectVO(Wrapper<ActivityTypeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ActivityTypeView> selectListView(Wrapper<ActivityTypeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ActivityTypeView selectView(Wrapper<ActivityTypeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
