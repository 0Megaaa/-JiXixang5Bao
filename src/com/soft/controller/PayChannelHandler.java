package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.bean.TbCar;
import com.soft.bean.TbParkPlace;
import com.soft.bean.ViewCarPark;
import com.soft.biz.CarParkCheckBiz;
import com.soft.biz.PayChannelBiz;

@Controller
@RequestMapping("/payChannel")
public class PayChannelHandler {
	@Resource
	private PayChannelBiz payChannelBizImpl;

	// 拉取停车场的车位及车记录。

	@RequestMapping("/showPay.action")
	public String carpark(HttpServletRequest request) {
		String AotuChannel = String.valueOf(payChannelBizImpl.findAotuChannel());
		String PhoneChannel = String.valueOf(payChannelBizImpl.findPhoneChannel());
		request.setAttribute("AotuChannel", AotuChannel);
		request.setAttribute("PhoneChannel", PhoneChannel);
		return "user/payChannel";

	}

}
