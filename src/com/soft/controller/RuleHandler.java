package com.soft.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.bean.Page;
import com.soft.bean.TbRule;
import com.soft.biz.RuleBiz;

@Controller
@RequestMapping("/rule")
public class RuleHandler {
	@Resource
	private RuleBiz ruleBizImpl;

	private Page<TbRule> list;

	@RequestMapping("/findAll.action")
	public String findAll(HttpServletRequest request, Page<TbRule> page) {
		list = ruleBizImpl.findAll(page);
		request.setAttribute("list", list);

		return "user/rule";
	}

	@RequestMapping("/delete.action")
	public String delete(HttpServletRequest request, Page<TbRule> page) {
		ruleBizImpl.delete(page.getRuleId());
		return "forward:/rule/findAll.action";
	}

	@RequestMapping("/open.action")
	public String open(HttpServletRequest request, Page<TbRule> page) {

		ruleBizImpl.open(page.getRuleId());

		return "forward:/rule/findAll.action";
	}
	//切换添加规则界面
	@RequestMapping("/add.action")
	public String add(HttpServletRequest request, Page<TbRule> page) {
		return "user/addRule";
	}
	//添加规则
	@RequestMapping("/addRule.action")
	public String addRule(HttpServletRequest request, TbRule rule) {
		rule.setRuleState(2+"");
		ruleBizImpl.addRule(rule);
		return "redirect:/rule/findAll.action";
	}
	
	//跳转修改规则
	@RequestMapping("/modify.action")
	public String modify(HttpServletRequest request, TbRule rule0) {
		TbRule rule = ruleBizImpl.findById(rule0);
		request.setAttribute("rule", rule);
		return "user/modifyRule";
	}
	
	//跳转修改规则
	@RequestMapping("/modifyDo.action")
	public String modifyDo(HttpServletRequest request, TbRule rule0) {
		ruleBizImpl.modifyDo(rule0);
		return "redirect:/rule/findAll.action";
	}
	
	
	

}
