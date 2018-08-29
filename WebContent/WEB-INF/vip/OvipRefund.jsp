<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员退费</title>
</head>
<body>
	<h1>会员退费</h1>
	
	<table border="1">
		<tr>
			<td>车牌号码</td>
			<td>开始日期</td>
			<td>会员状态</td>
			<td>套餐时长</td>
			<td>套餐价格</td>
			<td>退费金额</td>
			<td>操作</td>
		</tr>
		<tr>
			<td>${vip.carNum }</td>
			<td>${vip.startDate }</td>
			<td>${vip.vipState }</td>
			<td>${vip.paTime }月</td>
			<td>${vip.paPrice }</td>
			<td>${rest }</td>
			<td><a href="refundPost.action?vipId=${vip.vipId }">退费</a></td>
		</tr>
		
		
	</table>
</body>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</html>