package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.soft.bean.TbMenu;
import com.soft.bean.TbStaff;
import com.soft.bean.ViewTbStaffRole;
import com.soft.biz.RoleMenuBiz;
import com.soft.biz.StaffRoleBiz;

@Controller
@RequestMapping("/role")
public class UserRoleHandler {
	@Resource
	private StaffRoleBiz staffRoleBizImpl;
	@Resource
	private RoleMenuBiz roleMenuBizImpl;
	List<ViewTbStaffRole>staffRoles=null;
	List<TbMenu>tbMenus=null;
	@RequestMapping("/userRoleManage.action")
	public ModelAndView findall(HttpServletRequest request){
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
		staffRoles=staffRoleBizImpl.findallview();
		if (staffRoles!=null) {
			request.setAttribute("staffRoles", staffRoles);
			request.setAttribute("tbMenus", tbMenus);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("role/userRoleManage");
			return modelAndView;
		}
		return null;
		
	}
	
	@RequestMapping("/userRoleChange.action")
	public ModelAndView userRoleManage(HttpServletRequest request){
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
		staffRoles=staffRoleBizImpl.findallview();
		if (staffRoles!=null) {
			request.setAttribute("tbMenus", tbMenus);
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
