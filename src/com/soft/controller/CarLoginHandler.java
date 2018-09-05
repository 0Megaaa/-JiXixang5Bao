package com.soft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.biz.CarLoginBiz;
import com.soft.tools.OcrUtil;
import com.squareup.okhttp.Request;


@Controller 
@RequestMapping("/carLogin")
public class CarLoginHandler {
	
	@Resource
	private CarLoginBiz carLoginBiz;
	@Resource
	private TbCar car;
	@Resource
	private ViewCarPark viewCarParkcar;
	@Resource
	private OcrUtil ocr;
	private String message;
	private Map<String, Object> info=new HashMap<String, Object>();
	//localhost:8080/park/carLogin/hello.action
	@RequestMapping("/carLogin.action")
	public ModelAndView carLogin(HttpServletRequest request){
		String path = (String)request.getAttribute("path");
		String fileName = (String)request.getAttribute("file");
		File file=new File(path+"//"+fileName);
		
		String sum = ocr.getCarNum(path, fileName);
		String carNum = sum.substring(ocr.getCarNum(path, fileName).length()-12, ocr.getCarNum(path, fileName).length()-5);
	
		//需要进行用户类型判断
		if(sum.length()>=160 && sum.length()<=170){
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			car.setCarNum(carNum);
			car.setStartTime(time);
			car.setEnterImgSrc(file.getAbsolutePath());
			if(carLoginBiz.findWhite(car).size()==0 && carLoginBiz.findVip(car).size()==0){
				car.setUserType(2);
				car.setPayState(7);
			}else if(carLoginBiz.findWhite(car).size()!=0){
				car.setUserType(4);
				car.setPayState(7);
			}else if(carLoginBiz.findVip(car).size()!=0){
				car.setUserType(3);
				car.setPayState(7);
			}
			
			carLoginBiz.addCar(car);
			viewCarParkcar = carLoginBiz.findCar(car).get(0);
			
			request.setAttribute("car", viewCarParkcar);
			request.setAttribute("flag", 1);
		}else{
			message = "该图片不是车牌!";
			request.setAttribute("message", message);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/carLogin");
		return mav;
	}
	@RequestMapping("/beforePark.action")
	public ModelAndView beforePark(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/carLogin");
		return mav;
	}
	@RequestMapping("/toLookCar.action")
	public ModelAndView toLookCar(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/lookCar");
		return mav;
	}
	
	@RequestMapping(value="/lookCar.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> userinfo3(HttpServletRequest request,String carNum){
		car.setCarNum(carNum);
		List<ViewCarPark> carList = carLoginBiz.lookCar(car);
		
		if(carList.size()!=0 && carList.get(0).getParkImgSrc()!=null){
			info.put("success", true);
			info.put("carimg", carList.get(0).getParkImgSrc());
		}else{
			info.put("success", false);
			info.put("message", "该车暂未停入车库");
		}
		request.setAttribute("carNum", carNum);
		request.setAttribute("map", info);
		return info;
	}
	
	
	//localhost:8080/webproj12_springmvc/index.jsp
//	@RequestMapping(value="/userinfo.action")
//	public ModelAndView userinfo(HttpServletRequest request, 
//			@RequestParam(value="username", required=true, defaultValue="empty")String name, 
//			String password){
//		System.out.println(name + ":" + password);
//		System.out.println("userinfo������������...");
//		HttpSession session = request.getSession();
//		session.setAttribute("user", new User(name, password));
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("userinfo");
//		return mav;
//	}
//	
//	//localhost:8080/webproj12_springmvc/index.jsp
//	@RequestMapping(value="/userinfo2.action")
//	public String userinfo2(HttpServletRequest request, 
//			User user){
//		System.out.println(user);
//		System.out.println("userinfo2������������...");
//		HttpSession session = request.getSession();
//		session.setAttribute("user", user);
//		return "userinfo"; //��ͨ��String���ͷ�����Ϣ
//	}
	
	//localhost:8080/webproj12_springmvc/index.jsp
//	@RequestMapping(value="/userinfo3.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
//	public @ResponseBody User userinfo3(String username, String password){
//		System.out.println(username + ":" + password);
//		System.out.println("userinfo3������������...");
//		return new User(username, password);
//	}
	
	//localhost:8080/webproj12_springmvc/index.jsp
//	@RequestMapping(value="/userinfo4.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
//	public @ResponseBody User userinfo4(@RequestBody User user){
//		System.out.println(user);
//		System.out.println("userinfo4������������...");
//		return user;
//	}
	
	//localhost:8080/webproj12_springmvc/index.jsp
	@RequestMapping(value="/fileact.action", method=RequestMethod.POST)
	public String fileact(HttpServletRequest request,MultipartFile fileact){
		String filename = fileact.getOriginalFilename();
		String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String path = request.getRealPath("/upload/"+time);
		File destFile = new File(path);
		if(!destFile.exists()){
			destFile.mkdirs();
		}
		try {
			fileact.transferTo(new File(path+"/"+filename));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("path",path);
		request.setAttribute("file",filename);
		return "forward:/carLogin/carLogin.action";
	}
	
	
	
}
