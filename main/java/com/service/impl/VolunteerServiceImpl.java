package com.service.impl;

import com.dao.VolunteerDao;
import com.entity.VolunteerEntity;
import com.entity.view.VolunteerView;
import com.entity.vo.VolunteerVO;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.service.VolunteerService;

@Service("volunteerService")
public class VolunteerServiceImpl extends ServiceImpl<VolunteerDao, VolunteerEntity> implements VolunteerService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<VolunteerEntity> page = this.selectPage(
                new Query<VolunteerEntity>(params).getPage(),
                new EntityWrapper<VolunteerEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<VolunteerEntity> wrapper) {
		  Page<VolunteerView> page =new Query<VolunteerView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<VolunteerVO> selectListVO(Wrapper<VolunteerEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public VolunteerVO selectVO(Wrapper<VolunteerEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<VolunteerView> selectListView(Wrapper<VolunteerEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public VolunteerView selectView(Wrapper<VolunteerEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
