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
//刷新
	@RequestMapping("/findAll.action")
	public String findAll(HttpServletRequest request, Page<TbRule> page) {
		 
		list = ruleBizImpl.findAll(page);
		request.setAttribute("list", list);
		 
		
		return "manage/adminRule";
	}

	// 删除
	@RequestMapping("/delete.action")
	public String delete(HttpServletRequest request, Page<TbRule> page,long ruleState) {
		String deletemsg = "删除失败";
		if(ruleState==2){
			int a = ruleBizImpl.delete(page.getRuleId());
			
			if(a==0){
				  deletemsg = "删除成功";
			} 
				
		}else{
			  deletemsg = "已启动规则不可删除";
		}
		request.setAttribute("deletemsg", deletemsg);
		return "forward:/rule/findAll.action";
	}

	// 启动
	@RequestMapping("/open.action")
	public String open(HttpServletRequest request, Page<TbRule> page) {

		int b =ruleBizImpl.open(page.getRuleId());
		 String openmsg = "启动失败";
		if(b==0){
			  openmsg = "启动成功";
		} 
		request.setAttribute("openmsg", openmsg);
		return "forward:/rule/findAll.action";
	}

	// 切换添加规则界面
	@RequestMapping("/add.action")
	public String add(HttpServletRequest request, Page<TbRule> page) {
		return "manage/addRule";
	}

	// 添加规则
	@RequestMapping("/addRule.action")
	public String addRule(HttpServletRequest request, TbRule rule) {
		rule.setRuleState(2 + "");
		 ruleBizImpl.addRule(rule);
		 
		return "redirect:/rule/findAll.action";
	}

	// 跳转准备修改规则
	@RequestMapping("/modify.action")
	public String modify(HttpServletRequest request, TbRule rule0) {
		TbRule rule = ruleBizImpl.findById(rule0);
		request.setAttribute("rule", rule);
		return "manage/modifyRule";
	}

	// 跳转修改之后规则
	@RequestMapping("/modifyDo.action")
	public String modifyDo(HttpServletRequest request, TbRule rule0) {
		ruleBizImpl.modifyDo(rule0);
		return "redirect:/rule/findAll.action";
	}

}
