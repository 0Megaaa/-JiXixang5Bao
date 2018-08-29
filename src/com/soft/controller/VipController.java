package com.soft.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.soft.bean.Page;
import com.soft.bean.TbPackages;
import com.soft.bean.ViewVip;
import com.soft.biz.VipBiz;

@Controller
@RequestMapping("/vip")
public class VipController {
	//localhost:8080/park/vip/vipManage.action
	@Resource
	private VipBiz vipBizImpl;
	
	@RequestMapping("/vipManage.action")
	public String packageManage(HttpServletRequest request,Page<ViewVip> page){
		
		page = vipBizImpl.getVipPageInfo(page);
		request.setAttribute("page", page);
		return "vip/vipManage";
	}
	
	@RequestMapping("/add.action")
	public String toAdd(HttpServletRequest request){
		request.setAttribute("packagesSelect", vipBizImpl.getPackagesSelect());
		return "vip/vipAdd";
	}
	
	@RequestMapping(value="/getPackMsg.action", method=RequestMethod.POST, 
			produces="application/json;charset=utf-8")
	public @ResponseBody TbPackages getPackMsg(String paId){
		return vipBizImpl.getPackageById(paId);
	}
	
	@RequestMapping(value="/carNumCheck.action", method=RequestMethod.POST, 
			produces="application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> carNumCheck(String carNum){
		
		return vipBizImpl.carNumCheck(carNum);
	}
	
	
	@RequestMapping("/addPost.action")
	public ModelAndView add(ViewVip viewVip){
		vipBizImpl.addVip(viewVip);
		return new ModelAndView("redirect:/vip/vipManage.action");
	}
	
	@RequestMapping("/refund.action")
	public String toRefund(HttpServletRequest request, String vipId){
		request.setAttribute("vip", vipBizImpl.getVipById(vipId));
		request.setAttribute("rest", vipBizImpl.countRefund(vipId));
		return "vip/vipRefund";
	}
	
	@RequestMapping("/refundPost.action")
	public String refund(String vipId){
		vipBizImpl.deleteVip(vipId);
		return "redirect:/vip/vipManage.action";
	}
	
	
}
