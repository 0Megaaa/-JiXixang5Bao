package com.soft.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soft.bean.TbStaff;
import com.soft.biz.StaffBiz;

@Controller
@RequestMapping("/Manager")
public class UserManageHandler {

	@Resource
	private StaffBiz staffBizImpl;
	List<TbStaff>tbStafflist =null;
	@RequestMapping("/userManage.action")
	public ModelAndView findAll(HttpServletRequest request){
		tbStafflist =staffBizImpl.findAll();
//        System.out.println(tbStafflist.get(0).getStaffState());
        if (tbStafflist!=null) {
        	request.setAttribute("tbStafflist", tbStafflist);
        /*	for (TbStaff tbStaff : tbStafflist) {
        		TbStaff s = tbStafflist.get(0);
        		System.out.println(s.getStaffState());
			}*/
        	ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		} else {
			return null;
		}
		
	}
	
	@RequestMapping("/userChangeManage.action")
	public ModelAndView userChangeManage(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		TbStaff	tbStaff2 =staffBizImpl.selectuser(tbStaff );
        if (tbStafflist!=null) {
        	request.setAttribute("Tbstaff", tbStaff2);
        	ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userChangeManage");
			return modelAndView;
		} else {
			return null;
		}
		
	}
	
	@RequestMapping("/updateuser.action")
	public ModelAndView updateuser(HttpServletRequest request,long staffId,String staffName){
		
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffName(staffName);
		staffBizImpl.updateuser(tbStaff);
        if (tbStafflist!=null) {
        	tbStafflist =staffBizImpl.findAll();
        	request.setAttribute("tbStafflist", tbStafflist);
        	ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		} else {
			return null;
		}
		
	}
	
	
	@RequestMapping("/userpwd.action")
	public ModelAndView userpwd(HttpServletRequest request,long staffId,String staffPwd){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffPwd(staffPwd);
		TbStaff	tbStaff2 =staffBizImpl.selectuser(tbStaff );
        if (tbStafflist!=null) {
        	request.setAttribute("Tbstaff", tbStaff2);
        	ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userChangePwd");
			return modelAndView;
		} else {
			return null;
		}
		
	}
	@RequestMapping("/updatepwd.action")
    public ModelAndView updatepwd(HttpServletRequest request,long staffId,String staffPwd,String oldPwd){
		
		TbStaff tbStaff=new TbStaff();
		
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffPwd(staffPwd);
		staffBizImpl.updatepwd(tbStaff);
		System.out.println("12312312");
		
        if (tbStafflist!=null) {
        	tbStafflist =staffBizImpl.findAll();
        	request.setAttribute("tbStafflist", tbStafflist);
        	ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		} else {
			return null;
		}
		
	}
//	public String updatepwd(HttpServletRequest request,long staffId,String staffPwd){
//		
//		TbStaff tbStaff=new TbStaff();
//		tbStaff.setStaffId(staffId);
//		tbStaff.setStaffPwd(staffPwd);
//		staffBizImpl.updatepwd(tbStaff);
//		return "forword:/Manager/userManage.action";
//
//	}
	
	
	@RequestMapping("/staffEnable.action")
	public ModelAndView staffEnable(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffState(12);
		staffBizImpl.staffupdate(tbStaff);
		if (tbStaff!=null) {
			tbStafflist =staffBizImpl.findAll();
			request.setAttribute("tbStafflist", tbStafflist);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		}
		return null;
		
	}
	@RequestMapping("/staffDisable.action")
	public ModelAndView staffDisable(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffState(13);
		staffBizImpl.staffupdate(tbStaff);
		if (tbStaff!=null) {
			tbStafflist =staffBizImpl.findAll();
			request.setAttribute("tbStafflist", tbStafflist);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		}
		return null;
		
	}
	@RequestMapping("/staffQuit.action")
	public ModelAndView staffQuit(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		tbStaff.setStaffState(14);
		staffBizImpl.staffupdate(tbStaff);
		if (tbStaff!=null) {
			tbStafflist =staffBizImpl.findAll();
			request.setAttribute("tbStafflist", tbStafflist);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		}
		return null;
		
	}
	
	@RequestMapping("/staffdelete.action")
	public ModelAndView staffdelete(HttpServletRequest request,long staffId){
		TbStaff tbStaff=new TbStaff();
		tbStaff.setStaffId(staffId);
		staffBizImpl.staffdelete(tbStaff);
		if (tbStaff!=null) {
			tbStafflist =staffBizImpl.findAll();
			request.setAttribute("tbStafflist", tbStafflist);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("staff/userManage");
			return modelAndView;
		}
		return null;
		
	}
	
	
	
	
}
