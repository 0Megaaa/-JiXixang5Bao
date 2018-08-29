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
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.biz.CarLoginBiz;


@Controller 
@RequestMapping("/carLogin")
public class CarLoginHandler {
	
	@Resource
	private CarLoginBiz carLoginBiz;
	@Resource
	private TbCar car;
	@Resource
	private ViewCarPark viewCarParkcar;
	private String message;
	//localhost:8080/park/carLogin/hello.action
	@RequestMapping("/carLogin.action")
	public ModelAndView carLogin(HttpServletRequest request){
		String path = (String)request.getAttribute("path");
		String fileName = (String)request.getAttribute("file");
		File file=new File(path+"//"+fileName);
		
		System.out.println(file.getAbsolutePath());
		
		PlateRecognition pr=new PlateRecognitionImpl("E:\\eclipse\\park\\src\\resources");//
		Map<String,Plate> ps= pr.plateRecognize(file.getAbsolutePath());
		String carNum = null;
		for(Plate p:ps.values()){
			carNum = p.toString().substring(12, 18);	
		}
		System.out.println(carNum);
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		car.setCarNum(carNum);
		car.setStartTime(time);
		car.setEnterImgSrc(file.getAbsolutePath());
		car.setPayState(7);
		//需要进行用户类型判断
		car.setUserType(2);
		carLoginBiz.addCar(car);
		viewCarParkcar = carLoginBiz.findCar(car).get(0);
		
		message = "车闸开启了!";
		request.setAttribute("car", viewCarParkcar);
		request.setAttribute("message", message);
		request.setAttribute("flag", 1);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("carLogin");
		return mav;
	}
	@RequestMapping("/beforePark.action")
	public ModelAndView beforePark(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/carLogin");
		return mav;
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
		String path = request.getRealPath("/upload");
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
