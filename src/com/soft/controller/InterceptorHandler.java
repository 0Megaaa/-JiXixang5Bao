package com.soft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
 
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
 

/** *
@author： 
@date:2018年8月23日 下午5:23:56 
*/

/*拦截器类*/

public class InterceptorHandler implements HandlerInterceptor
{

	@Override  
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		
	}
	 /*预处理回调方法*/
	/*前端页面拦截，未登录返回登录页，已登录请求继续*/
	@Override  
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception
	{
		HttpSession session = request.getSession();
		Object user =  session.getAttribute("tbStaff");
		System.out.println("11111111");
		if(null!=user){
			return true;
		}else{
			System.out.println("11111111");
		String message = "您还未登录，请先登入";
//		session.setAttribute("message2", message);
		response.sendRedirect("http://localhost:8080/park/login.jsp");
		 
		return false;
		}
	}


	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	public String intercept(ActionInvocation arg0) throws Exception
//	{
//		
//		Tbluser user = (Tbluser) ServletActionContext.getRequest().getSession().getAttribute("user");
//		System.out.println(user);
//		System.out.println("111111111111111111");
//		if(null!=user){
//			System.out.println("............");
//			return arg0.invoke() ;
//		} 
//		AdminHandler adminHandler = new AdminHandler();
//		adminHandler.toLogin();
//		return "toLogin";
//	}

}

