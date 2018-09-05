package com.soft.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.bean.TbMenu;
import com.soft.bean.TbStaff;
import com.soft.biz.IndextMenuBiz;
import com.soft.biz.StaffBiz;

@Controller
@RequestMapping("/staff")
public class StaffHandler {
	@Resource
	private StaffBiz staffBizImpl;
	@Resource
	private IndextMenuBiz indextMenuBizImpl;
	 
	private List<TbMenu> menu;
	@Resource
	TbMenu tbmenu;
	
	private List<TbMenu> tbmenus ;
	
	@RequestMapping("/login.action")
	public String login(HttpServletRequest request, TbStaff staff) {
		TbStaff tbStaff = staffBizImpl.login(staff);
		tbmenus = new ArrayList<>();
		if (tbStaff != null) {
			HttpSession session = request.getSession();
			session.setAttribute("tbStaff", tbStaff);
			tbStaff.getStaffRole();
			tbmenu = null;
//			indextMenuBizImpl.findOneMenu(tbStaff.getStaffState());
			menu = indextMenuBizImpl.findOneMenu(tbStaff.getStaffRole());
			for (int i = 0; i < menu.size(); i++) {
				//这边取到一级菜单的ID 接下去去数据库查父ID是这个ID的菜单 此时返回的数据是一个list
				tbmenu = menu.get(i);
				tbmenu.setSecondList(indextMenuBizImpl.findTwoMenu(menu.get(i).getMenuId(),tbStaff.getStaffRole()));
				tbmenus.add(tbmenu);
				
			}
			request.getSession().setAttribute("name", tbStaff.getStaffName());
			request.getSession().setAttribute("tbmenus", tbmenus);
			return "manage/indext";
		} else {
			return "manage/login";
		}
	}
	
	
	
	
	@RequestMapping("/staffLogin.action")
	public String staffLogin(HttpServletRequest request ) {
		 
			return "/login";
	}

}
