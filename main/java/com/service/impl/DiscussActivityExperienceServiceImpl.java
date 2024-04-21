package com.service.impl;

import com.entity.DiscussActivityExperienceEntity;
import com.entity.view.DiscussActivityExperienceView;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussActivityExperienceDao;
import com.service.DiscussActivityExperienceService;
import com.entity.vo.DiscussActivityExperienceVO;

@Service("discussactivityexperienceService")
public class DiscussActivityExperienceServiceImpl extends ServiceImpl<DiscussActivityExperienceDao, DiscussActivityExperienceEntity> implements DiscussActivityExperienceService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussActivityExperienceEntity> page = this.selectPage(
                new Query<DiscussActivityExperienceEntity>(params).getPage(),
                new EntityWrapper<DiscussActivityExperienceEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussActivityExperienceEntity> wrapper) {
		  Page<DiscussActivityExperienceView> page =new Query<DiscussActivityExperienceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussActivityExperienceVO> selectListVO(Wrapper<DiscussActivityExperienceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussActivityExperienceVO selectVO(Wrapper<DiscussActivityExperienceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussActivityExperienceView> selectListView(Wrapper<DiscussActivityExperienceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussActivityExperienceView selectView(Wrapper<DiscussActivityExperienceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
