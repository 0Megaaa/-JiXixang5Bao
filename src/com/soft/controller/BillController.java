package com.soft.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.biz.BillBiz;
import com.soft.biz.BillBizImpl;

@Controller
@RequestMapping("/bill")
public class BillController {
	
	@Resource
	private BillBiz billBizImpl;
	
	//localhost:8080/park/bill/billPrint.action
	@RequestMapping("/billPrint.action")
	public String toBillPrint(){
		return "bill/billPrint";
	}
	
	@RequestMapping("/billDetail.action")
	public String billDetail(HttpServletRequest request,String time){
		switch (time) {
		case "1":
			request.setAttribute("detail", billBizImpl.getMorningList());
			request.setAttribute("count", billBizImpl.getMorningCount());
			break;
		case "2":
			request.setAttribute("detail", billBizImpl.getNoonList());
			request.setAttribute("count", billBizImpl.getNoonCount());
			break;
		case "3":
			request.setAttribute("detail", billBizImpl.getEveningList());
			request.setAttribute("count", billBizImpl.getEveningCount());
			break;
		default:
			break;
		}
		return "bill/billDetail";
	}
}
