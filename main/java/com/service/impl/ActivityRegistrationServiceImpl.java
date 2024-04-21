package com.service.impl;

import com.entity.ActivityRegistrationEntity;
import com.entity.view.ActivityRegistrationView;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ActivityRegistrationDao;
import com.service.ActivityRegistrationService;
import com.entity.vo.ActivityRegistrationVO;

@Service("activityregistrationService")
public class ActivityRegistrationServiceImpl extends ServiceImpl<ActivityRegistrationDao, ActivityRegistrationEntity> implements ActivityRegistrationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityRegistrationEntity> page = this.selectPage(
                new Query<ActivityRegistrationEntity>(params).getPage(),
                new EntityWrapper<ActivityRegistrationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ActivityRegistrationEntity> wrapper) {
		  Page<ActivityRegistrationView> page =new Query<ActivityRegistrationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ActivityRegistrationVO> selectListVO(Wrapper<ActivityRegistrationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ActivityRegistrationVO selectVO(Wrapper<ActivityRegistrationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ActivityRegistrationView> selectListView(Wrapper<ActivityRegistrationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ActivityRegistrationView selectView(Wrapper<ActivityRegistrationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
