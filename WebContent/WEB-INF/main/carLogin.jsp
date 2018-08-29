<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    
     <h5>文件操作</h5>
     <form action="fileact.action" method="post" enctype="multipart/form-data" style="margin-left:400px;margin-top:300px">
     	请选择文件:<input type="file" name="fileact">
     	<input type="submit" value="提交">
     <input type="hidden" name="flag" id="flag" value="${flag}"/>
     </form>
     <c:if test="${flag != 1}">
     	<img id="up" src="${pageContext.request.contextPath}/img/blue.jpg" />
     </c:if>
     <c:if test="${flag == 1}">
     	<img  id="up" src="${pageContext.request.contextPath}/img/green.jpg" />
     </c:if>
     <h1>${car.carNum}</h1>
     <h1>${car.startTime}</h1>
     <h1>${car.userTypeName}</h1>
  </body>
 <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
	
	var message = "${message == null ? "" : message}";
	if(message != "")
	{
		alert(message);
		var i = setTimeout('check()',5000);
		
		function check() {
			
			 if( $('#up')[0].src == 'http://localhost:8080/park/img/green.jpg') {
				 $('#up').attr('src','${pageContext.request.contextPath}/img/blue.jpg');
				 alert("车闸关闭了!");
			}
		 }
		/* window.clearTimeout(i); */
	}
	
	
</script>
</html>
