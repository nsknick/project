package com.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.entity.ActivityRegistrationEntity;
import com.entity.view.ActivityRegistrationView;
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

import com.service.ActivityRegistrationService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;

/**
 * 活动报名
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-06 08:33:49
 */
@RestController
@RequestMapping("/activityregistration")
public class ActivityRegistrationController {
    @Autowired
    private ActivityRegistrationService activityRegistrationService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ActivityRegistrationEntity activityregistration,
                  HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("volunteer")) {
			activityregistration.setStudentid((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();
		PageUtils page = activityRegistrationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityregistration), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ActivityRegistrationEntity activityregistration,
                  HttpServletRequest request){
        EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();
		PageUtils page = activityRegistrationService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, activityregistration), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ActivityRegistrationEntity activityregistration){
       	EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();
      	ew.allEq(MPUtil.allEQMapPre( activityregistration, "activityregistration"));
        return R.ok().put("data", activityRegistrationService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ActivityRegistrationEntity activityregistration){
        EntityWrapper<ActivityRegistrationEntity> ew = new EntityWrapper<ActivityRegistrationEntity>();
 		ew.allEq(MPUtil.allEQMapPre( activityregistration, "activityregistration"));
		ActivityRegistrationView activityregistrationView =  activityRegistrationService.selectView(ew);
		return R.ok("查询活动报名成功").put("data", activityregistrationView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ActivityRegistrationEntity activityregistration = activityRegistrationService.selectById(id);
        return R.ok().put("data", activityregistration);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ActivityRegistrationEntity activityregistration = activityRegistrationService.selectById(id);
        return R.ok().put("data", activityregistration);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ActivityRegistrationEntity activityregistration, HttpServletRequest request){
    	activityregistration.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activityregistration);
        activityRegistrationService.insert(activityregistration);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ActivityRegistrationEntity activityregistration, HttpServletRequest request){
    	activityregistration.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(activityregistration);
        activityRegistrationService.insert(activityregistration);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ActivityRegistrationEntity activityregistration, HttpServletRequest request){
        //ValidatorUtils.validateEntity(activityregistration);
        activityRegistrationService.updateById(activityregistration);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        activityRegistrationService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ActivityRegistrationEntity> wrapper = new EntityWrapper<ActivityRegistrationEntity>();
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

		int count = activityRegistrationService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
