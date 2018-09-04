package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;
import com.soft.biz.RoleMenuBiz;

@Controller
@RequestMapping("/rolemenu")
public class UserRoleMenuHandler {
	@Resource
	private RoleMenuBiz roleMenuBizImpl;
	List<ViewRoleMenu> roleMenus = null;
	List<TbMenu> tbMenus = null;
	List<TbRole>roles=null;

	@RequestMapping("/userRoleMenu.action")
	public ModelAndView findview(HttpServletRequest request) {
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
		    roles=roleMenuBizImpl.findrole();
		    if (roles!=null) {
				
		    	request.setAttribute("roles", roles);
		    	request.setAttribute("tbMenus", tbMenus);
		    	ModelAndView modelAndView = new ModelAndView();
		    	modelAndView.setViewName("rolemenu/userRoleMenu");
		    	return modelAndView;
			}
		    return null;
	}
/*	@RequestMapping("/userRoleMenu.action")
	
	public String findmenu(HttpServletRequest request) {
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
	    	request.setAttribute("tbMenus", tbMenus);
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("rolemenu/userRoleMenu");
	    	return "forward:/rolemenu/userRoleMenu.action";
		
}*/
	
	@RequestMapping("/userRoleMenuChange.action")
	public ModelAndView updaterolemenu(HttpServletRequest request,String roleId){
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
		//tip1
//		String roleId = "2";
		//拉取一级
		List<ViewRoleMenu> lst = roleMenuBizImpl.findFirstMenu(roleId);
		for (int i = 0; i < lst.size(); i++) {
			ViewRoleMenu rm = lst.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			rm.setSecondList2(roleMenuBizImpl.findSecondMenu(roleId, rm.getMenuId()+""));
			
		}
	/*	for (ViewRoleMenu viewRoleMenu : lst) {
			List<ViewRoleMenu> list = viewRoleMenu.getSecondList2();
			for (ViewRoleMenu viewRoleMenu2 : list) {
			
				System.out.println(viewRoleMenu2.getMenuName());
			}
		}*/
		   if (tbMenus!=null) {
			   	request.setAttribute("roleId", roleId);
		    	request.setAttribute("tbMenus", tbMenus);
		    	request.setAttribute("menuLst", lst);
		    	ModelAndView modelAndView = new ModelAndView();
		    	modelAndView.setViewName("rolemenu/userRoleMenuChange");
		    	return modelAndView;
			}
		    return null;
		
	}
	
	@RequestMapping("/userRoleMenuupdate.action")
	public String userRoleMenuupdate(HttpServletRequest request,String roleId,String[] menuArr){
		for (int i = 0; i < menuArr.length; i++) {
			System.out.println(menuArr[i]);
			
		}
		
		System.out.println("-------------");
		System.out.println(roleId+",--");
		ViewRoleMenu viewRoleMenu=new ViewRoleMenu();
		viewRoleMenu.setRoleId(Long.parseLong(roleId));
//		viewRoleMenu.setRoleId(Long.parseLong(roleId));
		roleMenuBizImpl.deleall(viewRoleMenu);
		roleMenuBizImpl.newMenu(roleId,menuArr);
	
		roleMenuBizImpl.addAllFirst(menuArr,roleId);
			
		 if (roleMenus!=null) {
			 roleMenus=roleMenuBizImpl.findallview();
		    	request.setAttribute("roleMenus", roleMenus);
		 }
		 return "forward:/rolemenu/userRoleMenu.action";
	}



}
