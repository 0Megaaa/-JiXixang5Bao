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
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewWhiteList;
import com.soft.biz.CarLoginBiz;
import com.soft.biz.WhiteListBiz;


@Controller 
@RequestMapping("/whiteList")
public class WhiteListHandler {
	
	@Resource
	private WhiteListBiz whiteListBiz;
	@Resource
	private TbCar car;
	private String message;
	//localhost:8080/park/whiteList/whiteList.action
	
	@RequestMapping("/whiteList.action")
	public String findList(HttpServletRequest request,Page<ViewWhiteList> page){
		page = whiteListBiz.getWhitePageInfo(page);
		request.setAttribute("page", page);
		request.setAttribute("message", request.getAttribute("message"));
		return "main/whiteListManage";
	}
	@RequestMapping("/deleteWhite.action")
	public String deleteWhite(HttpServletRequest request,String whiteId){
		long id = Integer.valueOf(whiteId);
		whiteListBiz.deleteWhite(id);
		message = "删除成功";
		request.setAttribute("message", message);
		return "forward:/whiteList/whiteList.action";
	}
	@RequestMapping("/toAddWhiteList.action")
	public String toAddWhiteList(){
		
		return "main/createWhite";
	}
	@RequestMapping("/addWhite.action")
	public String addWhiteList(HttpServletRequest request,ViewWhiteList view){
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		view.setStartDate(time);
		whiteListBiz.createWhite(view);
		message = "新增成功";
		request.setAttribute("message", message);
		return "forward:/whiteList/whiteList.action";
	}
}
