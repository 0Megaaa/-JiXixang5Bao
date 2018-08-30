package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soft.bean.TbRule;
import com.soft.bean.TbStaff;
import com.soft.biz.CarParkCheckBiz;
import com.soft.biz.RuleBiz;
import com.soft.biz.StaffBiz;

@Controller
@RequestMapping("/staff")
public class StaffHandler {
	@Resource
	private StaffBiz staffBizImpl;


	@RequestMapping("/login.action")
	public String login(HttpServletRequest request, String staffAccount, String staffPwd) {
		TbStaff tbStaff0 = new TbStaff();
		tbStaff0.setStaffAccount(staffAccount);
		tbStaff0.setStaffPwd(staffPwd);
		TbStaff tbStaff = staffBizImpl.login(tbStaff0);
		if (tbStaff != null) {
			HttpSession session = request.getSession();
			session.setAttribute("tbStaff", tbStaff);
			return "user/inrule";
		} else {
			return "user/inrule";
		}
	}

}
