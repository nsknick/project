package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.ActivityReflectionEntity;
import com.entity.view.ActivityReflectionView;
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

import com.service.ActivityReflectionService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.service.StoreupService;

/**
 * 活动心得
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@RestController
@RequestMapping("/activityreflection")
public class ActivityReflectionController {
    @Autowired
    private ActivityReflectionService activityReflectionService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ActivityReflectionEntity activityreflection,
                  HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		activityreflection.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<ActivityReflectionEntity> ew = new EntityWrapper<ActivityReflectionEntity>();
		PageUtils page = activityReflectionService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityreflection), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ActivityReflectionEntity activityreflection,
                  HttpServletRequest request){
        EntityWrapper<ActivityReflectionEntity> ew = new EntityWrapper<ActivityReflectionEntity>();
		PageUtils page = activityReflectionService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityreflection), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ActivityReflectionEntity activityreflection){
       	EntityWrapper<ActivityReflectionEntity> ew = new EntityWrapper<ActivityReflectionEntity>();
      	ew.allEq(MPUtil.allEQMapPre( activityreflection, "activityreflection"));
        return R.ok().put("data", activityReflectionService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ActivityReflectionEntity activityreflection){
        EntityWrapper<ActivityReflectionEntity> ew = new EntityWrapper<ActivityReflectionEntity>();
 		ew.allEq(MPUtil.allEQMapPre( activityreflection, "activityreflection"));
		ActivityReflectionView activityReflectionView =  activityReflectionService.selectView(ew);
		return R.ok("查询活动心得成功").put("data", activityReflectionView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ActivityReflectionEntity activityreflection = activityReflectionService.selectById(id);
        return R.ok().put("data", activityreflection);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ActivityReflectionEntity activityreflection = activityReflectionService.selectById(id);
        return R.ok().put("data", activityreflection);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ActivityReflectionEntity activityreflection, HttpServletRequest request){
    	activityreflection.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activityreflection);
    	activityreflection.setUserid((Long)request.getSession().getAttribute("userId"));
        activityReflectionService.insert(activityreflection);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ActivityReflectionEntity activityreflection, HttpServletRequest request){
    	activityreflection.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activityreflection);
        activityReflectionService.insert(activityreflection);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ActivityReflectionEntity activityreflection, HttpServletRequest request){
        //ValidatorUtils.validateEntity(activityreflection);
        activityReflectionService.updateById(activityreflection);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        activityReflectionService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ActivityReflectionEntity> wrapper = new EntityWrapper<ActivityReflectionEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = activityReflectionService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
