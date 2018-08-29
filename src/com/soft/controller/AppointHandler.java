package com.soft.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.bean.TbAppointment;
import com.soft.bean.TbCar;
import com.soft.biz.AppointBiz;
import com.soft.biz.AppointBizImpl;
import com.soft.biz.CarParkBiz;
import com.soft.biz.CarParkBizImpl;

@Controller
@RequestMapping("/app")
public class AppointHandler {
	@Resource
	AppointBiz AppointBizImpl;
	@Resource
	private CarParkBiz CarParkBizImpl;
	@Resource
	TbAppointment tbAppointment;
	@Resource
	TbCar tbCar;

	@RequestMapping(value = "/appoint.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody TbAppointment appoint(String carNum, String times, int timeLength) {

		// 获取到车号
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// Date dateStart = df.parse(timeStart);
		Date date = new Date();
		String startDate = df.format(date);
		String startDateall = startDate + " " + times;
		TbAppointment appointment = null;
		Date startDateall2;
		try {
			startDateall2 = df2.parse(startDateall);
			Date endDate = new Date(startDateall2.getTime() + timeLength * 60 * 60 * 1000);
			String endDate2 = df2.format(endDate);
			tbAppointment.setCarNum(carNum);
			tbAppointment.setStartTime(startDateall);
			tbAppointment.setMoney(timeLength);
			tbAppointment.setEndTime(endDate2);
			appointment = AppointBizImpl.insetApp(tbAppointment);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 插入到停车表。
		return appointment;

	}

	// 查询个人的

	// querySelfApp

	@RequestMapping(value = "/selfAppointment.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody List<TbCar> selfAppointment(String carNum) {

		// 查询停车记录。

		tbCar.setCarNum(carNum);

		return CarParkBizImpl.queryCarAll(tbCar);
	}

}
