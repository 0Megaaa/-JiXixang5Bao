package com.soft.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import com.crenjoy.easypr.core.Plate;
import com.crenjoy.easypr.core.PlateRecognition;
import com.crenjoy.easypr.core.PlateRecognitionImpl;
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.biz.CarOutBiz;
import com.soft.biz.PayCheckParkBiz;
import com.soft.biz.StaffBiz;

@Controller
@RequestMapping("/checkPark")
public class PayCheckParkHandler {
	@Resource
	private PayCheckParkBiz payCheckParkBizImpl;

 
	@RequestMapping(value = "/showMap.action")
	public String inIt(HttpServletRequest request) {
		String allPark = String.valueOf(payCheckParkBizImpl.allPark());
		String bePark = String.valueOf(payCheckParkBizImpl.bePark());
		request.setAttribute("allPark", allPark);
		request.setAttribute("bePark", bePark);
		return "user/payCheckPark";
	}



	 

}
