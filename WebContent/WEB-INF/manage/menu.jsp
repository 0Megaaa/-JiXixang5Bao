<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=path%>/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path%>/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="<%=path%>/assets/js/echarts.min.js"></script>
<link rel="stylesheet" href="<%=path%>/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="<%=path%>/assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/app.css">
<script src="<%=path%>/assets/js/jquery.min.js"></script>
<style type="text/css">
#canvas {
	border: 1px solid #ADACB0;
	display: block;
	margin: 20px auto;
}
</style>
<script src="<%=path%>/assets/js/amazeui.min.js"></script>
	<script src="<%=path%>/assets/js/amazeui.datatables.min.js"></script>
	<script src="<%=path%>/assets/js/dataTables.responsive.min.js"></script>
	<script src="<%=path%>/assets/js/app.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
</head>
<script src="<%=path %>/assets/js/theme.js"></script>
<body data-type="widgets">
    
     <script src="<%=path%>/assets/js/theme.js"></script>
	<!-- <div class="am-g tpl-g"> -->
		<!-- 头部 -->
		<header>
			<!-- logo -->
			<div class="am-fl tpl-header-logo">
				<a href="javascript:;"><img src="<%=path%>/assets/img/logo.png"
					alt=""></a>
			</div>
			<!-- 右侧内容 -->
			<div class="tpl-header-fluid">
				<!-- 侧边切换 -->
				 
				<!-- 搜索 -->

				<!-- 其它功能-->
				<!-- <div class="am-fr tpl-header-navbar">
					<ul>
						欢迎语
						新邮件
						新提示
						退出
						<li class="am-text-sm"><a href="javascript:;"> <span
								class="am-icon-sign-out"></span> 退出
						</a></li>
					</ul>
				</div> -->
			</div>

		</header>
		<!-- 风格切换 -->
		<div class="tpl-skiner">
			<div class="tpl-skiner-toggle am-icon-cog"></div>
			<div class="tpl-skiner-content">
				<div class="tpl-skiner-content-title">选择主题</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
		<!-- 侧边导航栏 -->
		<div class="left-sidebar">
        <!-- 头部 -->
        
        <!-- 风格切换 -->
        
        <!-- 侧边导航栏 -->
         
            <!-- 用户信息 -->


            <!-- 菜单 -->
            <ul class = "sidebar-nav">
             <li class="sidebar-nav-heading">工作人员：${name}<span class="sidebar-nav-heading-info"> </span></li>
               <c:forEach items="${tbmenus}"  var="type">
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
                               ${second.menuName}
                            </a>
                        </li>
                    </ul>
                    </c:forEach>
                </li>
               <!--  <li class="sidebar-nav-heading"><span class="sidebar-nav-heading-info"> </span></li> -->
               </c:forEach>
                
		</ul>
	 </div>
	

</body>

</html>