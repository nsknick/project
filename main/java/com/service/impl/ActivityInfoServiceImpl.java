package com.service.impl;

import com.dao.ActivityInfoDao;
import com.entity.ActivityInfoEntity;
import com.entity.view.ActivityInfoView;
import com.entity.vo.ActivityInfoVO;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.service.ActivityInfoService;

@Service("activityinfoService")
public class ActivityInfoServiceImpl extends ServiceImpl<ActivityInfoDao, ActivityInfoEntity> implements ActivityInfoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityInfoEntity> page = this.selectPage(
                new Query<ActivityInfoEntity>(params).getPage(),
                new EntityWrapper<ActivityInfoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ActivityInfoEntity> wrapper) {
		  Page<ActivityInfoView> page =new Query<ActivityInfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ActivityInfoVO> selectListVO(Wrapper<ActivityInfoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ActivityInfoVO selectVO(Wrapper<ActivityInfoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ActivityInfoView> selectListView(Wrapper<ActivityInfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ActivityInfoView selectView(Wrapper<ActivityInfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
