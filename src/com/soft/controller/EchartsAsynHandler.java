package com.soft.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.bean.EchartsBean;
import com.soft.bean.TbCar;
import com.soft.bean.TbParkPlace;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewMonthService;
import com.soft.bean.ViewTollChannel;
import com.soft.bean.ViewAutoService;
import com.soft.bean.ViewBar;
import com.soft.biz.CarParkCheckBiz;
import com.soft.biz.PayChannelBiz;
import com.soft.biz.PayCheckParkBiz;

@Controller
@RequestMapping("/echartsAsynController")
public class EchartsAsynHandler {
	
	@Resource
	private PayChannelBiz payChannelBizImpl;
	
 
	/**
	 * @Description: TODO(跳转页面)
	 * @return
	 * @author 爱琴孩
	 * @version V1.0
	 */

	/**
	 * 
	 * @Description: TODO(模拟从数据库获取数据)
	 * @return
	 * @author 爱琴孩
	 * @version V1.0
	 */
	
	@RequestMapping(value = "/inIt.action")
	public String inIt(HttpServletRequest request) {
		return "manage/payChannel";
	}
	
	@ResponseBody
	@RequestMapping("/getDatas.action")
	public EchartsBean getDatas(HttpServletRequest request) {
		String year = request.getParameter("year");
		ViewBar viewBar = new ViewBar(); 
		viewBar.setYear(year);
		viewBar.setAutoChannel("自助");
		viewBar.setMonthServic("月缴");
		viewBar.setTollChannel("临时");
		ViewAutoService viewSelfService = payChannelBizImpl.findAutoChannel(viewBar);
		ViewMonthService viewMonthService = payChannelBizImpl.findMonthServic(viewBar);
		ViewTollChannel viewTollChannel = payChannelBizImpl.findTollChannel(viewBar);
		
		
		EchartsBean echartsBean = new EchartsBean();
//		List<String> xAxisCategory = Arrays.asList("高新区", "蜀山区", "瑶海区", "包河区", "经开区", "政务区", "滨湖新区", "新站区");
		
		
		List<Double> datas1 = Arrays.asList(viewSelfService.getM1(), viewSelfService.getM2(), viewSelfService.getM3(), 
				viewSelfService.getM4(), viewSelfService.getM5(), viewSelfService.getM6(), viewSelfService.getM7(), 
				viewSelfService.getM8(), viewSelfService.getM9(), viewSelfService.getM10(), viewSelfService.getM11(),
				viewSelfService.getM12());
		
		List<Double> datas2 = Arrays.asList(viewMonthService.getM1(), viewMonthService.getM2(), viewMonthService.getM3(), 
				viewMonthService.getM4(), viewMonthService.getM5(), viewMonthService.getM6(), viewMonthService.getM7(), 
				viewMonthService.getM8(), viewMonthService.getM9(), viewMonthService.getM10(), viewMonthService.getM11(),
				viewMonthService.getM12());
		
		List<Double> datas3 = Arrays.asList(viewTollChannel.getM1(), viewTollChannel.getM2(), viewTollChannel.getM3(), 
				viewTollChannel.getM4(), viewTollChannel.getM5(), viewTollChannel.getM6(), viewTollChannel.getM7(), 
				viewTollChannel.getM8(), viewTollChannel.getM9(), viewTollChannel.getM10(), viewTollChannel.getM11(),
				viewTollChannel.getM12());
		echartsBean.setDatas1(datas1); 
		echartsBean.setDatas2(datas2); 
		echartsBean.setDatas3(datas3); 
		// echartsBean.setxAxisCategory(xAxisCategory);
		return echartsBean;
	}
}