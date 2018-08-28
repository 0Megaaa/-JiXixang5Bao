package com.soft.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.bean.TbAppointment;
import com.soft.biz.AppointBiz;
import com.soft.biz.AppointBizImpl;

@Controller
@RequestMapping("/app")
public class AppointHandler {
	@Resource
	AppointBiz AppointBizImpl;
	@Resource
	TbAppointment tbAppointment;

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
			 appointment=	AppointBizImpl.insetApp(tbAppointment);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 插入到停车表。
		return appointment;

	}

}
