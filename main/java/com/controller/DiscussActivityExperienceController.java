package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussActivityExperienceEntity;
import com.entity.view.DiscussActivityExperienceView;

import com.service.DiscussActivityExperienceService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 活动心得评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@RestController
@RequestMapping("/discussactivityexperience")
public class DiscussActivityExperienceController {
    @Autowired
    private DiscussActivityExperienceService discussActivityExperienceService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DiscussActivityExperienceEntity discussactivityexperience,
                  HttpServletRequest request){
        EntityWrapper<DiscussActivityExperienceEntity> ew = new EntityWrapper<DiscussActivityExperienceEntity>();
		PageUtils page = discussActivityExperienceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussactivityexperience), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, DiscussActivityExperienceEntity discussactivityexperience,
                  HttpServletRequest request){
        EntityWrapper<DiscussActivityExperienceEntity> ew = new EntityWrapper<DiscussActivityExperienceEntity>();
		PageUtils page = discussActivityExperienceService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussactivityexperience), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussActivityExperienceEntity discussactivityexperience){
       	EntityWrapper<DiscussActivityExperienceEntity> ew = new EntityWrapper<DiscussActivityExperienceEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussactivityexperience, "discussactivityexperience"));
        return R.ok().put("data", discussActivityExperienceService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussActivityExperienceEntity discussactivityexperience){
        EntityWrapper<DiscussActivityExperienceEntity> ew = new EntityWrapper<DiscussActivityExperienceEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussactivityexperience, "discussactivityexperience"));
		DiscussActivityExperienceView discussactivityexperienceView =  discussActivityExperienceService.selectView(ew);
		return R.ok("查询活动心得评论表成功").put("data", discussactivityexperienceView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussActivityExperienceEntity discussactivityexperience = discussActivityExperienceService.selectById(id);
        return R.ok().put("data", discussactivityexperience);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussActivityExperienceEntity discussactivityexperience = discussActivityExperienceService.selectById(id);
        return R.ok().put("data", discussactivityexperience);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussActivityExperienceEntity discussactivityexperience, HttpServletRequest request){
    	discussactivityexperience.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussactivityexperience);
        discussActivityExperienceService.insert(discussactivityexperience);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussActivityExperienceEntity discussactivityexperience, HttpServletRequest request){
    	discussactivityexperience.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussactivityexperience);
        discussActivityExperienceService.insert(discussactivityexperience);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussActivityExperienceEntity discussactivityexperience, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussactivityexperience);
        discussActivityExperienceService.updateById(discussactivityexperience);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussActivityExperienceService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussActivityExperienceEntity> wrapper = new EntityWrapper<DiscussActivityExperienceEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussActivityExperienceService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
