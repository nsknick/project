package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.ActivityTypeEntity;
import com.entity.view.ActivityTypeView;
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

import com.service.ActivityTypeService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 活动类型
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@RestController
@RequestMapping("/activitytype")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ActivityTypeEntity activitytype,
                  HttpServletRequest request){
        EntityWrapper<ActivityTypeEntity> ew = new EntityWrapper<ActivityTypeEntity>();
		PageUtils page = activityTypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activitytype), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ActivityTypeEntity activitytype,
                  HttpServletRequest request){
        EntityWrapper<ActivityTypeEntity> ew = new EntityWrapper<ActivityTypeEntity>();
		PageUtils page = activityTypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activitytype), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ActivityTypeEntity activitytype){
       	EntityWrapper<ActivityTypeEntity> ew = new EntityWrapper<ActivityTypeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( activitytype, "activitytype"));
        return R.ok().put("data", activityTypeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ActivityTypeEntity activitytype){
        EntityWrapper<ActivityTypeEntity> ew = new EntityWrapper<ActivityTypeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( activitytype, "activitytype"));
		ActivityTypeView activityTypeView =  activityTypeService.selectView(ew);
		return R.ok("查询活动类型成功").put("data", activityTypeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ActivityTypeEntity activitytype = activityTypeService.selectById(id);
        return R.ok().put("data", activitytype);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ActivityTypeEntity activitytype = activityTypeService.selectById(id);
        return R.ok().put("data", activitytype);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ActivityTypeEntity activitytype, HttpServletRequest request){
    	activitytype.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activitytype);
        activityTypeService.insert(activitytype);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ActivityTypeEntity activitytype, HttpServletRequest request){
    	activitytype.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activitytype);
        activityTypeService.insert(activitytype);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ActivityTypeEntity activitytype, HttpServletRequest request){
        //ValidatorUtils.validateEntity(activitytype);
        activityTypeService.updateById(activitytype);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        activityTypeService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ActivityTypeEntity> wrapper = new EntityWrapper<ActivityTypeEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = activityTypeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
