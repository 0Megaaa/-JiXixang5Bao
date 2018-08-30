package com.soft.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.crenjoy.easypr.core.Plate;
import com.crenjoy.easypr.core.PlateRecognition;
import com.crenjoy.easypr.core.PlateRecognitionImpl;
import com.soft.bean.Page;
import com.soft.bean.TbCar;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewCharge;
import com.soft.bean.ViewVip;
import com.soft.bean.ViewWhiteList;
import com.soft.biz.CarLoginBiz;
import com.soft.biz.ChargeListBiz;
import com.soft.biz.WhiteListBiz;


@Controller 
@RequestMapping("/chargeList")
public class ChargeListHandler {
	
	@Resource
	private ChargeListBiz chargeListBiz;
	
	private String message;
	//localhost:8080/park/whiteList/whiteList.action
	
	@RequestMapping("/chargeList.action")
	public String findList(HttpServletRequest request,Page<ViewCharge> page){
		page = chargeListBiz.getWhitePageInfo(page);
		long sumMoney = chargeListBiz.findSumMoney().get(0).getSumMoney();
		long parkTime = chargeListBiz.findSumPark().get(0).getParkTime();
		
		request.setAttribute("page", page);
		request.setAttribute("sumMoney", sumMoney);
		request.setAttribute("parkTime", parkTime);
		
		request.setAttribute("message", request.getAttribute("message"));
		return "main/chargeList";
	}
	@RequestMapping("/packageMoneySum.action")
	public String packageMoneySum(HttpServletRequest request,Page<ViewVip> page){
		
		List<TbPackages> packageList = chargeListBiz.findPackageList();
		
		page = chargeListBiz.getPackageMoney(page);
		request.setAttribute("packageList", packageList);
		request.setAttribute("page", page);
		return "main/packageMoneyList";
	}
	@RequestMapping(value="/getPackage.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody List<ViewVip> getPackage(String message){
		System.out.println(message);
		System.out.println("userinfo3");
		return null;
	}
}
