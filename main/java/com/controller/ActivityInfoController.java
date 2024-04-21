package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.ActivityInfoEntity;
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

import com.entity.view.ActivityInfoView;

import com.service.ActivityInfoService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 活动信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@RestController
@RequestMapping("/activityinfo")
public class ActivityInfoController {
    @Autowired
    private ActivityInfoService activityInfoService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ActivityInfoEntity activityinfo,
                  HttpServletRequest request){
        EntityWrapper<ActivityInfoEntity> ew = new EntityWrapper<ActivityInfoEntity>();
		PageUtils page = activityInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityinfo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ActivityInfoEntity activityinfo,
                  HttpServletRequest request){
        EntityWrapper<ActivityInfoEntity> ew = new EntityWrapper<ActivityInfoEntity>();
		PageUtils page = activityInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityinfo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ActivityInfoEntity activityinfo){
       	EntityWrapper<ActivityInfoEntity> ew = new EntityWrapper<ActivityInfoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( activityinfo, "activityinfo"));
        return R.ok().put("data", activityInfoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ActivityInfoEntity activityinfo){
        EntityWrapper<ActivityInfoEntity> ew = new EntityWrapper<ActivityInfoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( activityinfo, "activityinfo"));
		ActivityInfoView activityInfoView =  activityInfoService.selectView(ew);
		return R.ok("查询活动信息成功").put("data", activityInfoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ActivityInfoEntity activityinfo = activityInfoService.selectById(id);
        return R.ok().put("data", activityinfo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ActivityInfoEntity activityinfo = activityInfoService.selectById(id);
        System.out.println(activityinfo);
        return R.ok().put("data", activityinfo);

    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ActivityInfoEntity activityinfo, HttpServletRequest request){
    	activityinfo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activityinfo);
        activityInfoService.insert(activityinfo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ActivityInfoEntity activityinfo, HttpServletRequest request){
    	activityinfo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activityinfo);
        activityInfoService.insert(activityinfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ActivityInfoEntity activityinfo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(activityinfo);
        activityInfoService.updateById(activityinfo);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        activityInfoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ActivityInfoEntity> wrapper = new EntityWrapper<ActivityInfoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = activityInfoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
