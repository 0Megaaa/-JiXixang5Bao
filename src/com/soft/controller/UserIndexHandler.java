package com.soft.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soft.bean.TbAppointment;
import com.soft.bean.TbParkPlace;
import com.soft.bean.TbRulePlace;
import com.soft.biz.CarParkBiz;
import com.soft.biz.CarParkBizImpl;
import com.soft.biz.RuleMiniBiz;

@Controller
@RequestMapping("/user")
public class UserIndexHandler {
	@Resource
	private CarParkBiz CarParkBizImpl;
@Resource
private TbAppointment tbAppointment;
	@Resource
	private RuleMiniBiz RuleMiniBizImpl;

	/*
	 * @Resource ModelAndView modelAndView;
	 */
	@RequestMapping("/index.action")
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/userIndex");
		return modelAndView;
	}

	@RequestMapping(value = "/MiniProgram.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody TbRulePlace userinfo3(String x, String y) {
		// 查找剩余车位数，如果剩余车位数大于0，则提示可以预约，

		// 查剩余车位。
		List<TbParkPlace> listLeft = CarParkBizImpl.queryParkPlace("10");

		// 查询总车位
		List<TbParkPlace> listAll = CarParkBizImpl.queryParkPlaceAll();
//获取当前时间。	
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// Date dateStart = df.parse(timeStart);
		Date date = new Date();
		String endTime = df2.format(date);
		
		//查询预约的车位。
		tbAppointment.setEndTime(endTime);
		List<TbAppointment> listApp= CarParkBizImpl. queryAppoint( tbAppointment);
		
		
		
		// 查询规则表
		TbRulePlace rp = RuleMiniBizImpl.findRule();

		rp.setPlaceAll(listAll.size() + "");
rp.setAppointSize(listApp.size()+"");
		rp.setPlaceRemain(listLeft.size() + "");
		return rp;
	}

}
