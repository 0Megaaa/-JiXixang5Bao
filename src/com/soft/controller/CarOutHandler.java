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
import com.soft.biz.StaffBiz;

@Controller
@RequestMapping("/carOut")
public class CarOutHandler {
	@Resource
	private CarOutBiz carOutBizImpl;

	// @RequestMapping(value = "/readPicture.action")
	// public String fileact(HttpServletRequest request, String outImgSrc) {
	//
	// PlateRecognition pr = new
	// PlateRecognitionImpl("D:\\eclipse\\park\\src\\resources");
	// File file = new File(outImgSrc);
	// Map<String, Plate> ps = pr.plateRecognize(file.getAbsolutePath());
	// for (Plate p : ps.values()) {
	// System.out.println(p.toString().substring(12).split(",")[0]);
	// TbCar Car = new TbCar();
	// Car.setCarNum(p.toString().substring(12).split(",")[0]);
	// Car.setOutImgSrc(outImgSrc);
	// request.setAttribute("Car", Car);
	// carOutBizImpl.addCarOut(Car);
	// }
	// return "forward:/carOut/findCarOut.action";
	// }

	@RequestMapping(value = "/fileact.action")
	public String fileact(MultipartFile fileact, HttpServletRequest request) {

		String filename = fileact.getOriginalFilename();

		String path = null;
		if (!fileact.isEmpty()) {
			path = request.getSession().getServletContext().getRealPath("/upload/");// 存放位置
			File savedFile = new File(path);
			if (savedFile.exists()) {
				try {
					fileact.transferTo(new File(savedFile, filename));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				savedFile.mkdirs();
				try {
					boolean isCreateSuccess = savedFile.createNewFile();
					fileact.transferTo(new File(savedFile, filename));

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			String a = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
			String s = a.substring(1) + "resources";
			PlateRecognition pr = new PlateRecognitionImpl(s);

			String path2 = savedFile + "\\" + filename;
			File file = new File(path2);
			Map<String, Plate> ps = pr.plateRecognize(file.getAbsolutePath());
			for (Plate p : ps.values()) {
				TbCar Car = new TbCar();
				Car.setCarNum(p.toString().substring(12).split(",")[0]);
				Car.setOutImgSrc(path2);
				request.setAttribute("Car", Car);
				carOutBizImpl.addCarOut(Car);
			}
		}
		return "forward:/carOut/findCarOut.action";
	}
	
	
	

	@RequestMapping(value = "/inIt.action")
	public String inIt(HttpServletRequest request) {
		return "user/carOut";
	}

	@RequestMapping(value = "/findCarOut.action")
	public String findCarOut(HttpServletRequest request) {
		TbCar Car = (TbCar) request.getAttribute("Car");
		TbCar CarFull = carOutBizImpl.findCarOut(Car);
		request.setAttribute("CarFull", CarFull);
		return "user/carOutPay";
	}

	/*
	 * @RequestMapping(value = "/getPicture.action") public @ResponseBody
	 * ViewCarPark getPicture(HttpServletRequest request, TbCar Car) {
	 * ViewCarPark CarFull = carOutBizImpl.findCarOut(Car);
	 * System.out.println("2222"); return CarFull; }
	 */

/*	@RequestMapping(value = "/getPicture.action")
	@ResponseBody
	public Map getPicture(HttpServletRequest request, TbCar Car) {
		Map<String, Object> map = new HashMap<>();
		// 调用service查询数据库验证登录信息
		// 判断用户是否存在
		TbCar TbCar = carOutBizImpl.findCarOut(Car);
		System.out.println(TbCar.getParkImgSrc());
		if (TbCar != null) {
			map.put("message", "success");
			map.put("TbCar", TbCar);
			return map;
		} else {
			map.put("message", "error");
		}
		return map;
	}*/

}
