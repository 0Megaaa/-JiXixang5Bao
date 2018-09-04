package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.soft.bean.TbMenu;
import com.soft.biz.MenuBiz;
import com.soft.biz.RoleMenuBiz;

import oracle.net.aso.p;

@Controller
@RequestMapping("/Menu")
public class UserMenuHandler {
	
	@Resource
	
	private MenuBiz menuBizImpl;
	@Resource
	private RoleMenuBiz roleMenuBizImpl;
	List<TbMenu>tbMenuslist=null;
	List<TbMenu>tbMenus=null;
	@RequestMapping("/userMenu.action")
	public ModelAndView findAll(HttpServletRequest request){
		//MAP存 数据库查所有的一级菜单 循环存一级菜单名字 作为hashmap的值  
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
		
		tbMenuslist=menuBizImpl.findMenu();
		if (tbMenuslist!=null) {
			request.setAttribute("tbMenuslist", tbMenuslist);
			request.setAttribute("tbMenus", tbMenus);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Menu/userMenu");
			return modelAndView;
		}
		return null;
		
	}
	
	
	@RequestMapping("/userMenuChange.action")
	public ModelAndView userMenuChange(HttpServletRequest request){
		TbMenu tbMenu=new TbMenu();
		tbMenus=roleMenuBizImpl.findmenu(tbMenu);
		for (int i = 0; i < tbMenus.size(); i++) {
			TbMenu tbMenu2=tbMenus.get(i);
			//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
			tbMenu2.setSecondList(roleMenuBizImpl.findseconid(""+tbMenu2.getMenuId()));
		}
		tbMenuslist=menuBizImpl.findMenu();
		if (tbMenuslist!=null) {
			request.setAttribute("tbMenus", tbMenus);
			request.setAttribute("tbMenuslist", tbMenuslist);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Menu/userMenuChange");
			return modelAndView;
		}
		return null;
		
	}
	
	@RequestMapping("/Menudelete.action")
	public String Menudelete(HttpServletRequest request,long menuId){
		TbMenu tbMenu =new TbMenu();
		tbMenu.setMenuId(menuId);
		menuBizImpl.Menudelete(tbMenu);
		if (tbMenu!=null) {
			tbMenuslist=menuBizImpl.findMenu();
			request.setAttribute("tbMenuslist", tbMenuslist);
//			ModelAndView modelAndView=new ModelAndView();
//			modelAndView.setViewName("forward:/Menu/userMenuChange.action");
			return "forward:/Menu/userMenuChange.action";
		}
		return null;
	}
	
	@RequestMapping("/userMenuAddone.action")
	public ModelAndView userMenuAddone(HttpServletRequest request){
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Menu/userMenuAddone");
			return modelAndView;
	}
	
	@RequestMapping("uerMenuInto1.action")
	public String uerMenuInto1(HttpServletRequest request,String menu1){
		TbMenu tbMenu=new TbMenu();
		tbMenu.setMenuName(menu1);
		menuBizImpl.MenuInsert(tbMenu);
        if (tbMenuslist!=null) {
			tbMenuslist=menuBizImpl.findMenu();
			request.setAttribute("tbMenuslist", tbMenuslist);
			return "forward:/Menu/userMenuChange.action";
			
		}		
		return null;
		
	}
	
	
	@RequestMapping("/userMenuAddtow.action")
	public ModelAndView userMenuAddtow(HttpServletRequest request,long menuId){
		TbMenu tbMenu=new TbMenu();
		tbMenu.setMenuId(menuId);
		TbMenu tbMenu2 =menuBizImpl.selectmenu(tbMenu);
		if (tbMenuslist!=null) {
			request.setAttribute("Tbmenu", tbMenu2);
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.setViewName("Menu/userMenuAddtow");
			return modelAndView;
		}
		return null;
	}
	
	
	@RequestMapping("uerMenuInto2.action")
	public String uerMenuInto2(HttpServletRequest request,String menu2,long menuId){
		TbMenu tbMenu=new TbMenu();
		System.out.println(menuId+"haha");
		tbMenu.setMenuPid(menuId);
		tbMenu.setMenuName(menu2);
		menuBizImpl.MenuIsert2(tbMenu);
        if (tbMenuslist!=null) {
			tbMenuslist=menuBizImpl.findMenu();
			request.setAttribute("tbMenuslist", tbMenuslist);
			return "forward:/Menu/userMenuChange.action";
		}		
		return null;
		
	}
	

}
