<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/aseets/css/bootstrap.min.css"/> 
  <body style="background-image: url(${pageContext.request.contextPath}/assets/img/bk.jpg);">
    
    
     <form action="fileact.action" method="post" enctype="multipart/form-data" style="text-align:center;height:10%;width:80%;margin-left:10%;margin-top:20px">
     	 <div class="form-group" style="background-color: rgba(0,0,0,0.1);border:1px solid black">
     	  <h1><a>吉祥五宝停车场</a></h1>
     	  <h1><a>欢迎停车！</a></h1>
     	  <input type="hidden" name="flag" id="flag" value="${flag}"/>
     	 </div>
    <div class="form-group" style="background-color: rgba(0,0,0,0.1);height:500px;width:100%;margin-top:2%;border:1px solid black;">
     	 <div class="form-group" style="text-align:center;height:400px;width:48%;margin-left:49%;margin-top:50px;">
     	  <h3><a>车牌图片接入口</a></h3>
     		<h3><a>请选择车牌:</a></h3><input type="file" class="btn btn-primary" name="fileact">
     	  <input type="submit" class="btn btn-primary" value="提交">
     	  <c:if test="${flag == 1}">
     		 <h3>您的车牌号:${car.carNum}</h3>
    		 <h3>入场时间:${car.startTime}</h3>
    		 <h3>停车类型:${car.userTypeName}</h3>
    	  </c:if>
     	</div>
    	  
     </form>
        <div class="form-group" style="text-align:center;height:400px;width:38%;margin-left:10%;margin-top:-370px;">
     <c:if test="${flag != 1}">
     	<img id="up" src="${pageContext.request.contextPath}/assets/img/down.jpg" />
     </c:if>
     <c:if test="${flag == 1}">
     	<img  id="up" src="${pageContext.request.contextPath}/assets/img/up.jpg" />
     </c:if>
   	    </div>
   </div>
  </body>
 <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript">
	
	var message = "${message == null ? "" : message}";
	if(message != "")
	{
		alert(message);
		var i = setTimeout('check()',5000);

		function check() {
			
			 if( $('#up')[0].src == 'http://localhost:8080/park/assets/img/up.jpg') {
				 $('#up').attr('src','${pageContext.request.contextPath}/assets/img/down.jpg');
				 alert("车闸关闭了!");
			}
		 }
		/* window.clearTimeout(i); */
	}
	
	
</script>
</html>
