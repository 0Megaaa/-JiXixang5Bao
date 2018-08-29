<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员办理</title>
</head>
<body>
	<h1>会员套餐办理</h1>
	<form action="addPost.action" method="post">
		<table border="1">
			<tr>
				<td>请输入车牌号:</td>
				<td>
					<input type="text" name="carNum" id="carNum"/>
				</td>
				<td id="carNumCheck"></td>
			</tr>
			<tr>
				<td>请选择套餐:</td>
				<td>
					<select name="paId" id="pack">
						<option value="0">请按照选择套餐</option>
						<c:forEach items="${packagesSelect }" var="pack">
							<option value="${pack.paId }">${pack.paTime }</option>
						</c:forEach>
					</select>
				</td>
				<td id="packageMsg">套餐信息</td>
			</tr>
			<tr>
				<td><input type="reset"/></td>
				<td><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
</body>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	 $(document).ready(function(){
		
		$("#pack").change(function(){
			var pack = $("#pack").val();
			$.ajax({
				type:"POST",
				url: "getPackMsg.action",
				/* contentType:"text/html",  */				/* 后台接收类型 */
				dataType:"json",			/* 返回值类型 */
				data:{"paId":pack},
  				success : function(pack){
  					/* console.log(pack.paPrice); */
  					$("#packageMsg").html(pack.paPrice); 
  				}
			});
		});
		
		 $("#carNum").on('input propertychange',function(){
			var carNum = $("#carNum").val();
			$.ajax({
				type:"POST",
				url: "carNumCheck.action",
				dataType:"json",			/* 返回值类型 */
				data:{"carNum":carNum},
  				success : function(msg){
  					var info = msg;
					if(info.flag){
	  					$("#carNumCheck").html(info.message); 
	  					$("#carNumCheck").css({"color":"green"});
					}else{
						$("#carNumCheck").html(info.message); 
						$("#carNumCheck").css({"color":"red"});
					}
  					
  					
  				}
			});
		});
		
		
	}); 
</script>
</html>