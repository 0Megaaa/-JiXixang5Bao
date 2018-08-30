package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.soft.bean.TbStaff;
import com.soft.bean.ViewTbStaffRole;
import com.soft.biz.StaffRoleBiz;

@Controller
@RequestMapping("/role")
public class UserRoleHandler {
	@Resource
	private StaffRoleBiz staffRoleBizImpl;
	List<ViewTbStaffRole>staffRoles=null;
	@RequestMapping("/userRoleManage.action")
	public ModelAndView findall(HttpServletRequest request){
		staffRoles=staffRoleBizImpl.findallview();
		if (staffRoles!=null) {
			request.setAttribute("staffRoles", staffRoles);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("role/userRoleManage");
			return modelAndView;
		}
		return null;
		
	}
	
	@RequestMapping("/userRoleChange.action")
	public ModelAndView userRoleManage(HttpServletRequest request){
		staffRoles=staffRoleBizImpl.findallview();
		if (staffRoles!=null) {
			request.setAttribute("staffRoles", staffRoles);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("role/userRoleChange");
			return modelAndView;
		}
		return null;
	}
	
	@RequestMapping("/roledelete.action")
	public String roledelete(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffRole(1);
		staffRoleBizImpl.roleupdate(tbStaff);
		if (staffRoles!=null) {
			staffRoles=staffRoleBizImpl.findallview();
			request.setAttribute("staffRoles", staffRoles);
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("role/userRoleChange");
//			return modelAndView;
			return "forward:/role/userRoleChange.action";
		}
		return null;
	}
	
	
	@RequestMapping("/roledivision1.action")
	public String roledivision1(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffRole(2);
		staffRoleBizImpl.roleupdate(tbStaff);
		if (staffRoles!=null) {
			staffRoles=staffRoleBizImpl.findallview();
			request.setAttribute("staffRoles", staffRoles);
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("role/userRoleChange");
//			return modelAndView;
			return "forward:/role/userRoleChange.action";
		}
		return null;
	}
	
	@RequestMapping("/roledivision2.action")
	public String roledivision2(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffRole(3);
		staffRoleBizImpl.roleupdate(tbStaff);
		if (staffRoles!=null) {
			staffRoles=staffRoleBizImpl.findallview();
			request.setAttribute("staffRoles", staffRoles);
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("role/userRoleChange");
//			return modelAndView;
			return "forward:/role/userRoleChange.action";
		}
		return null;
	}

}
