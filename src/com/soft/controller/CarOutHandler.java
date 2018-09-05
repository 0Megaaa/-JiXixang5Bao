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
import com.soft.biz.SelfChargeBiz;
import com.soft.biz.StaffBiz;
import com.soft.tools.OcrUtil;

@Controller
@RequestMapping("/carOut")
public class CarOutHandler {
	@Resource
	private CarOutBiz carOutBizImpl;
	@Resource
	private SelfChargeBiz SelfChargeBizImpl;
	@Resource
	private OcrUtil ocr;

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

			String carNum = ocr.getCarNum(path, filename).substring(ocr.getCarNum(path, filename).length()-12, ocr.getCarNum(path, filename).length()-5);
			String path2 = savedFile + "\\" + filename;
			TbCar Car = new TbCar();
			Car.setCarNum(carNum);
			Car.setOutImgSrc(path2);
			request.setAttribute("Car", Car);
			carOutBizImpl.addCarOut(Car);
			
//			String a = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//			String s = a.substring(1) + "resources";
//			PlateRecognition pr = new PlateRecognitionImpl(s);
//
//			String path2 = savedFile + "\\" + filename;
//			File file = new File(path2);
//			Map<String, Plate> ps = pr.plateRecognize(file.getAbsolutePath());
//			for (Plate p : ps.values()) {
//				TbCar Car = new TbCar();
//				Car.setCarNum(p.toString().substring(12).split(",")[0]);
//				Car.setOutImgSrc(path2);
//				request.setAttribute("Car", Car);
//				carOutBizImpl.addCarOut(Car);
//			}
			
		}
		return "forward:/carOut/findCarOut.action";
	}

	@RequestMapping(value = "/inIt.action")
	public String inIt(HttpServletRequest request) {
		request.setAttribute("flag", 2);
		return "manage/carOut";
	}

	@RequestMapping(value = "/findCarOut.action")
	public String findCarOut(HttpServletRequest request) {
		 TbCar Car = (TbCar) request.getAttribute("Car");
		 
//		TbCar CarFull = carOutBizImpl.findCarOut(Car);
//		request.setAttribute("CarFull", CarFull);
		
		int i = SelfChargeBizImpl.findList(Car.getCarNum());
		if (i == 1) {
			// i=1说明有值，说明是会员。或白名单。
			String msg = "您是免缴会员，可直接出场！";
			request.setAttribute("msg", msg);
			// 更新车状态。为已缴费。
			// 先通过车号查车id，再根据车id取更新数据。
			request.setAttribute("flag", 1);
			TbCar tbCar = SelfChargeBizImpl.findByCarNum(Car);
			
			SelfChargeBizImpl.updateWhiteCarOutMsg(tbCar);
			
			request.setAttribute("tbCar", tbCar);
			return "manage/carOut";
		} else {
			// 调出缴费记录，计算缴费信息下发，并点击缴费 就缴费。
			/* paystate=7 */
			/*
			 * 有数据下发数据。没数据下发输入车牌号有误，请重新输入。
			 */
			TbCar tbCar = SelfChargeBizImpl.queryCarOutMsg(Car.getCarNum());
			if (tbCar == null) {
				String msg = "对不起，车号有误！";
				request.setAttribute("msg", msg);
				return "manage/carOut";
			} else {
				// j就是卡id。 通过卡id去查记录，并计算金额。下发到客户端。
				request.setAttribute("tbCar", tbCar);
				SelfChargeBizImpl.updateCarOutMsg(tbCar);
				
				request.setAttribute("flag", 1);
			}
		}

		return "manage/carOut";

	}
 
}
