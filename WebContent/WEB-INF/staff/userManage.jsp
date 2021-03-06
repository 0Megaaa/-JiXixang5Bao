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
    <title>用户管理</title>
    <meta name="description" content="这是一个 用户管理页面">
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
               <c:forEach items="${tbMenus}"  var="type">
               <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> ${type.menuName}
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>
                    <c:forEach items="${type.secondList}"  var="second">
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <li class="sidebar-nav-link">
                            <a href="${second.menuLink}">
                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 
                               ${second.menuName }
                            </a>
                        </li>
                    </ul>
                    </c:forEach>
                </li>
               <!--  <li class="sidebar-nav-heading"><span class="sidebar-nav-heading-info"> </span></li> -->
               </c:forEach>
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
                                <div class="widget-title am-fl">用户表单</div>
                            </div>
                           <!--  用户表格 -->
                           
                           <div class="container">
                           
                             <table class="table table-hover table-bordered">
        <thead>
        <tr class="success">
            <th>账号</th>
            <th>姓名</th>
            <th>状态</th>
            <th>操作</th>
            <th>删除</th>
            <th>离职</th>
            <th>修改信息</th>
            <th>重置密码</th>
        </tr>
        </thead>
        <tbody>
        
      <c:forEach items="${tbStafflist}" var="staff"> 
	        <tr>
	            <!--  用户账号 -->
	            <td> ${staff.getStaffAccount()}</td>
	            
	           <!--  用户姓名 -->
	            <td>${staff.staffName } </td>
	              
	           <!-- 用户状态  -->
	             <td> 
	             <c:if test="${staff.staffState == 12 }">  
	            	 启动 
	             </c:if>
	             <c:if test="${staff.staffState ==13 }"> 
	            	 禁用 
	          	</c:if>
	          	<c:if test="${staff.staffState ==14 }"> 
	            	 离职 
	          	</c:if>
	             </td>
	             
	             <!-- 用户状态修改 -->
	             <td>
	            	<c:if test="${staff.staffState ==13 }"> 
	            	<a class="btn btn-success btn-xs" href="staffEnable.action?staffId=${staff.staffId }">启用</a>
	             	</c:if>
	             	<c:if test="${staff.staffState ==12 }"> 
	            	<a class="btn btn-danger btn-xs" href="staffDisable.action?staffId=${staff.staffId }">禁用</a>
	             	</c:if>
				 </td> 
				 
				  <td><a class="btn btn-success btn-xs" href="staffdelete.action?staffId=${staff.staffId }">删除</a></td>
				   <td><a class="btn btn-success btn-xs" href="staffQuit.action?staffId=${staff.staffId }">离职</a></td>
				 <td><a class="btn btn-success btn-xs" href="userChangeManage.action?staffId=${staff.staffId }">修改信息</a></td> 
				    <td><a class="btn btn-success btn-xs" href="userpwd.action?staffId=${staff.staffId }">密码重置</a></td>          
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