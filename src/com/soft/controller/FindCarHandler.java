package com.soft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soft.bean.TbCar;
import com.soft.bean.TbParkPlace;
import com.soft.bean.ViewCarPark;
import com.soft.biz.CarParkBiz;
import com.soft.tools.Point;
import com.soft.tools.TestPoint;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Controller
@RequestMapping("/user")
public class FindCarHandler {
	@Resource
	private CarParkBiz CarParkBizImpl;
	List<ViewCarPark> list;
	@Resource
	private ViewCarPark viewCarPark;
	@Resource
	private TbCar tbCar;
	@Resource
	private TbParkPlace tbParkPlace;
	@Resource
	private TestPoint testPoint;

	@RequestMapping("/findCar.action")
	public ModelAndView findCar(HttpServletRequest request) {
		// 寻车，需要输入车牌号
		// 自助设备。
		ModelAndView modelAndView = new ModelAndView();
		list = CarParkBizImpl.fingAllCarPark();
		for(int i=0;i<list.size();i++){
			
			Random a=new Random();

			list.get(i).setImgIndex(	a.nextInt(5)+1);
			
			
		}
		request.setAttribute("list", list);
		
		
		
		
		
		modelAndView.setViewName("user/findCar");
		return modelAndView;

	}

	@RequestMapping("/findCar1.action")
	public ModelAndView findCar1(HttpServletRequest request, int machine, String carNum) {
		// 寻车，需要输入车牌号
		// 自助设备。
		// 获取机器号，和车牌号。
		ArrayList<Point> listPoint = null;
		int[] arr = judge(machine);

		System.out.println(arr[1]);
		System.out.println(arr[0]);
		// 通过车牌号去查，该车是否在停车位上，如果在，返回坐标，如果不在，下发说：输入的车牌号不正确。

		viewCarPark.setCarNum(carNum);
	
		ViewCarPark viewCarPark1 = CarParkBizImpl.findCarParkMsg2(viewCarPark);

		if (viewCarPark1 == null) {
			// 下发说：输入的车牌号不正确。
			request.setAttribute("msg", "输入车牌号不正确！");
		} else {
			// 获取车位置的x，y。将
			System.out.println(viewCarPark1.getParkX());
			int machineX = arr[0];
			int machineY = arr[1];
			int carX = (int) viewCarPark1.getParkX();
			int carY = (int) viewCarPark1.getParkY();
			listPoint = testPoint.test2(machineX, machineY, carX, carY);

		}

		ModelAndView modelAndView = new ModelAndView();

		list = CarParkBizImpl.fingAllCarPark();

		request.setAttribute("list", list);
		request.setAttribute("carNum", carNum);
		request.setAttribute("listPoint", listPoint);
		modelAndView.setViewName("user/findCar");
		return modelAndView;

	}

	public int[] judge(int machine) {
		int x = 0;
		int y = 0;
		switch (machine) {
		case 1:
			x = 0;
			y = 6;
			break;

		case 2:
			x = 6;
			y = 0;
			break;

		case 3:
			x = 13;
			y = 6;
			break;

		case 4:
			x = 6;
			y = 13;
			break;

		default:
			break;
		}
		int[] arrays = new int[] { x, y };

		return arrays;

	}

	
	//小程序寻车
	@RequestMapping(value="/findCarMini.action",    method = RequestMethod.POST, produces = "application/json;charset=utf-8"                               )
	public  @ResponseBody    List<ViewCarPark>   findCarMini(HttpServletRequest request) {
		// 寻车，需要输入车牌号
		// 自助设备。
		
		list = CarParkBizImpl.fingAllCarPark();

		
	
		return list;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
