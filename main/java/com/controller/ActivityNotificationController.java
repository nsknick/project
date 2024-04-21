package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.ActivityNotificationEntity;
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

import com.entity.view.ActivityNotificationView;

import com.service.ActivityNotificationService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 活动通知
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@RestController
@RequestMapping("/activitynotification")
public class ActivityNotificationController {
    @Autowired
    private ActivityNotificationService activityNotificationService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ActivityNotificationEntity activitynotification,
                  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("volunteer")) {
			activitynotification.setStudentid((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ActivityNotificationEntity> ew = new EntityWrapper<ActivityNotificationEntity>();
		PageUtils page = activityNotificationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activitynotification), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ActivityNotificationEntity activitynotification,
                  HttpServletRequest request){
        EntityWrapper<ActivityNotificationEntity> ew = new EntityWrapper<ActivityNotificationEntity>();
		PageUtils page = activityNotificationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activitynotification), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ActivityNotificationEntity activitynotification){
       	EntityWrapper<ActivityNotificationEntity> ew = new EntityWrapper<ActivityNotificationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( activitynotification, "activitynotification"));
        return R.ok().put("data", activityNotificationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ActivityNotificationEntity activitynotification){
        EntityWrapper<ActivityNotificationEntity> ew = new EntityWrapper<ActivityNotificationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( activitynotification, "activitynotification"));
		ActivityNotificationView activityNotificationView =  activityNotificationService.selectView(ew);
		return R.ok("查询活动通知成功").put("data", activityNotificationView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ActivityNotificationEntity activitynotification = activityNotificationService.selectById(id);
        return R.ok().put("data", activitynotification);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ActivityNotificationEntity activitynotification = activityNotificationService.selectById(id);
        return R.ok().put("data", activitynotification);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ActivityNotificationEntity activitynotification, HttpServletRequest request){
    	activitynotification.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activitynotification);
        activityNotificationService.insert(activitynotification);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ActivityNotificationEntity activitynotification, HttpServletRequest request){
    	activitynotification.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activitynotification);
        activityNotificationService.insert(activitynotification);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ActivityNotificationEntity activitynotification, HttpServletRequest request){
        //ValidatorUtils.validateEntity(activitynotification);
        activityNotificationService.updateById(activitynotification);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        activityNotificationService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ActivityNotificationEntity> wrapper = new EntityWrapper<ActivityNotificationEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("volunteer")) {
			wrapper.eq("studentid", (String)request.getSession().getAttribute("username"));
		}

		int count = activityNotificationService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
