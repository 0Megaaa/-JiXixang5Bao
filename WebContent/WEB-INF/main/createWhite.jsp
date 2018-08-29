<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/> 
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
</head>
 <script type = "text/javascript">
    
    		var message = "${message == null ? "" : message}";
    		if(message != "")
    		{
    			alert(message);
    		}
    	
    		function checkAccount(){
        		var account = $("#account").val();
        		$.post("user/checkAccount",{
        			"account" : account
        		},function(data){
        			var info = data;
        			if(info.success){
        				$("#ename_msg").html(info.message);
        			}else{
        				$("#ename_msg").html(info.message);
        			}
        		});
        	}
		</script>
<body  style="width:60%;margin-left:-200px;">

  <form action="addWhite.action" method="post" class="container container-small" style="margin-top:100px;margin-left:480px">
	<h1>新增白名单</h1>
	<div class="form-group">
		<label>车牌号</label>
		<input type="text" name="carNum" class="form-control"/>
	</div>
	<div class="form-group" style="margin-left:20px;margin-top:0px">
		<button type="submit" class="btn btn-primary" value="注册">新增</button>
	</div>
	</form>
	<form action="whiteList.action" method="post" class="container container-small">
	<div class="form-group" style="margin-left:630px;margin-top:-49px">
		<button type="submit" class="btn btn-primary" value="注册">返回</button>
	</div>
	</form>
</body>
</html>