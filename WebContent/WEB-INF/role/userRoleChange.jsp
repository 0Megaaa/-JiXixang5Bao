<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%String path=request.getContextPath(); String basePath=request.getScheme()+"://"+
    request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>角色管理</title>
    <meta name="description" content="这是一个 角色管理页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="<%=path %>/<%=path %>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/<%=path %>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="<%=path %>/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/app.css">
     <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/main.css" rel="stylesheet">
    <script src="<%=path %>/assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
    <script src="<%=path %>/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 头部 -->
        <header>
            <!-- logo -->
            <div class="am-fl tpl-header-logo">
                <a href="javascript:;"><img src="<%=path %>/assets/img/logo.png" alt=""></a>
            </div>
            <!-- 右侧内容 -->
            <div class="tpl-header-fluid">
                <!-- 侧边切换 -->
                <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
                </div>
                <!-- 搜索 -->
                
                <!-- 其它功能-->
                <div class="am-fr tpl-header-navbar">
                    <ul>
                        <!-- 欢迎语 -->
                        <li class="am-text-sm tpl-header-navbar-welcome">
                            <a href="javascript:;">欢迎你, <span>Amaze UI</span> </a>
                        </li>

                        <!-- 新邮件 -->
                        

                        <!-- 新提示 -->
                        

                        <!-- 退出 -->
                        <li class="am-text-sm">
                            <a href="javascript:;">
                                <span class="am-icon-sign-out"></span> 退出
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </header>
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div class="tpl-skiner-content-title">
                    选择主题
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <!-- 侧边导航栏 -->
        <div class="left-sidebar">
            <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="<%=path %>/assets/img/user04.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              禁言小张
          </span>
                </div>
            </div>

            <!-- 菜单 -->
            <ul class="sidebar-nav">
               

                <li class="sidebar-nav-heading">管理菜单<span class="sidebar-nav-heading-info"> </span></li>
                  <li class="sidebar-nav-link">
                    <a href="tables.html">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 首页
                    </a>
                </li>
                
                <li class="sidebar-nav-link">
                    <a href="Manager/userManage.action">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 用户管理
                    </a>
                </li>
                 <!--    权限配置 -->
              <li class="sidebar-nav-link">
                    <a href="calendar.html">
                        <i class="am-icon-calendar sidebar-nav-link-logo"></i> 权限配置
                    </a>
                </li>
                
              <!--   日志查看 -->
              
               <li class="sidebar-nav-link">
                    <a href="calendar.html">
                        <i class="am-icon-calendar sidebar-nav-link-logo"></i> 日志查看
                    </a>
                </li>
                <!-- 参数配置 -->
               <li class="sidebar-nav-link">
                    <a href="tables.html">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 参数配置
                    </a>
                </li>
                
                                   <!-- 菜单管理 -->
                                   
               
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 菜单管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="Menu/userMenu.action">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 查看菜单
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="Menu/userMenuChange.action">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 菜单修改
                            </a>
                        </li>
                    </ul>
                </li>
                
                <!-- 角色管理 -->
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> 角色管理
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="table-list.html">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 角色信息
                            </a>
                        </li>

                        <li class="sidebar-nav-link">
                            <a href="table-list-img.html">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 角色操作
                            </a>
                        </li>
                    </ul>
                </li>
                
            
                
                <li class="sidebar-nav-link">
                    <a href="register.jsp">
                        <i class="am-icon-clone sidebar-nav-link-logo"></i> 注册
<!--                         <span class="am-badge am-badge-secondary sidebar-nav-link-logo-ico am-round am-fr am-margin-right-sm">6</span>
 -->                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="login.jsp">
                        <i class="am-icon-key sidebar-nav-link-logo"></i> 登录
                    </a>
                </li>
                <!-- <li class="sidebar-nav-link">
                    <a href="404.html">
                        <i class="am-icon-tv sidebar-nav-link-logo"></i> 404错误
                    </a>
                </li> -->

            </ul>
        </div>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            <div class="container-fluid am-cf">

            </div>

            <div class="row-content am-cf">


                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">角色管理</div>
                            </div>
                           <!-- 角色表格 -->
                           <div class="container">
                             <table class="table table-hover table-bordered">
        <thead>
        <tr class="success">
            <th>用户账号</th>
            <th>用户姓名</th>
            <th>用户角色</th>
            <th>分配角色</th>
            <th>删除角色</th>
        </tr>
        </thead>
        <tbody>
        
      <c:forEach items="${staffRoles}" var="role"> 
	        <tr>
	            <!--  用户账号 -->
	             <!--  用户账号 -->
	            <td> ${role.getStaffAccount()}</td>
	            
	           <!--  用户姓名 -->
	            <td>${role.getStaffName()} </td>
	              
	             <!-- 用户修改 -->
	            <td>
	             <c:if test="${role.getStaffRole() ==1}">  
	            	 无角色
	             </c:if>
	             <c:if test="${role.getStaffRole() ==2 }"> 
	            	 收费员 
	          	</c:if>
	          	<c:if test="${role.getStaffRole() ==3 }"> 
	            	 管理员 
	          	</c:if>
	            </td>
	             
				 
				 
				  <td>
				
	            	<a class="btn btn-success btn-xs" href="roledivision1.action?staffId=${role.staffId }">收费员</a>
	             	
	             	
	            	<a class="btn btn-success btn-xs" href="roledivision2.action?staffId=${role.staffId }">管理员</a>
	             	
				  </td>
				  
				   <td><a class="btn btn-danger btn-xs" href="roledelete.action?staffId=${role.staffId }">删除当前角色</a></td>
	        </tr>
        </c:forEach> 
        </tbody>
    </table>
  
</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script src="<%=path %>/assets/js/amazeui.min.js"></script>
    <script src="<%=path %>/assets/js/amazeui.datatables.min.js"></script>
    <script src="<%=path %>/assets/js/dataTables.responsive.min.js"></script>
    <script src="<%=path %>/assets/js/app.js"></script>

</body>
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/js/bootstrap.min.js"></script>
</html>