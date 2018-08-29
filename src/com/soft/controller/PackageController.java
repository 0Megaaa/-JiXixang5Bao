package com.soft.controller;

import java.util.List;
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
import com.soft.biz.PackageBiz;

@Controller
@RequestMapping("/package")
public class PackageController {

	@Resource
	private PackageBiz packageBizImpl;
//	localhost:8080/park/package/packageManage.action
	@RequestMapping("/packageManage.action")
	public String packageManage(HttpServletRequest request,Page<TbPackages> page){
		page = packageBizImpl.getPackageList(page);
		request.setAttribute("page", page);
//		System.out.println("aaaaaaaaaa");
		return "packages/packageManage";
		//		request.setAttribute("packageList", packageBizImpl.getPackageList());
//		ModelAndView mav = new ModelAndView("packages/packageManage");
//		return mav;
	}
	//修改套餐
	@RequestMapping("/modify.action")
	public ModelAndView toModify(HttpServletRequest request,String paId,
			Page<TbPackages> page){
		int num = packageBizImpl.modifyCheck(paId);
		if(num == -1){
			request.setAttribute("msg", "无法修改，该套餐有用户在使用");
			return new ModelAndView("forward:/package/packageManage.action");
		}
		request.setAttribute("pack", packageBizImpl.getPackageById(paId));
		request.setAttribute("page", page);
		return new ModelAndView("packages/packageModify");
	}
	@RequestMapping("/modifyPost.action")
	public ModelAndView modify(HttpServletRequest request,TbPackages tbPackages){
		int num = packageBizImpl.updatePackage(tbPackages);
		return new ModelAndView("forward:/package/packageManage.action");
	}
	//删除套餐
	@RequestMapping("/delete.action")
	public ModelAndView delete(HttpServletRequest request,String paId){
		int num = packageBizImpl.deletePackage(paId);
		if(num == -1){
			request.setAttribute("msg", "删除失败，该套餐有用户在使用");
		}else{
			request.setAttribute("msg", "删除成功");
		}
		return new ModelAndView("forward:/package/packageManage.action");
	}
	//新增套餐
	@RequestMapping("/add.action")
	public String toAdd(){
		return "packages/packageAdd";
	}
	@RequestMapping("/addPost.action")
	public ModelAndView add(TbPackages tbPackages){
		
		packageBizImpl.addPackage(tbPackages);
		return new ModelAndView("redirect:/package/packageManage.action");
	}
	
	@RequestMapping(value="/timeCheck.action", method=RequestMethod.POST, 
			produces="application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> timeCheck(String time){
		
		return packageBizImpl.timeCheck(time);
	}
	
	
}
