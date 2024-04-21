package com.service.impl;

import com.dao.ActivityNotificationDao;
import com.entity.ActivityNotificationEntity;
import com.entity.view.ActivityNotificationView;
import com.entity.vo.ActivityNotificationVO;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.service.ActivityNotificationService;

@Service("activitynotificationService")
public class ActivityNotificationServiceImpl extends ServiceImpl<ActivityNotificationDao, ActivityNotificationEntity> implements ActivityNotificationService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ActivityNotificationEntity> page = this.selectPage(
                new Query<ActivityNotificationEntity>(params).getPage(),
                new EntityWrapper<ActivityNotificationEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ActivityNotificationEntity> wrapper) {
		  Page<ActivityNotificationView> page =new Query<ActivityNotificationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ActivityNotificationVO> selectListVO(Wrapper<ActivityNotificationEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ActivityNotificationVO selectVO(Wrapper<ActivityNotificationEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ActivityNotificationView> selectListView(Wrapper<ActivityNotificationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ActivityNotificationView selectView(Wrapper<ActivityNotificationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
