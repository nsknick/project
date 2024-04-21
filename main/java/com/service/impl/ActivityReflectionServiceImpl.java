package com.service.impl;

import com.dao.ActivityReflectionDao;
import com.entity.ActivityReflectionEntity;
import com.entity.view.ActivityReflectionView;
import com.entity.vo.ActivityReflectionVO;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.service.ActivityReflectionService;

@Service("activityreflectionService")
public class ActivityReflectionServiceImpl extends ServiceImpl<ActivityReflectionDao, ActivityReflectionEntity> implements ActivityReflectionService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityReflectionEntity> page = this.selectPage(
                new Query<ActivityReflectionEntity>(params).getPage(),
                new EntityWrapper<ActivityReflectionEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ActivityReflectionEntity> wrapper) {
		  Page<ActivityReflectionView> page =new Query<ActivityReflectionView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ActivityReflectionVO> selectListVO(Wrapper<ActivityReflectionEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ActivityReflectionVO selectVO(Wrapper<ActivityReflectionEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ActivityReflectionView> selectListView(Wrapper<ActivityReflectionEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ActivityReflectionView selectView(Wrapper<ActivityReflectionEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
