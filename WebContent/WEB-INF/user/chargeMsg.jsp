<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>缴费界面</title>
</head>
<body>



	<table>
		<tr>
			<td>车牌号</td>
			<td>进场时间</td>
			<td>出场时间</td>
			<td>收费金额</td>
			<td>停车时长</td>
		</tr>
		<tr>
			<td>${tbCar.carNum}</td>
			<td>${tbCar.startTime}</td>
			<td>${tbCar.endTime}</td>
			<td>${tbCar.money}</td>
			<td>${tbCar.totalTime}</td>
		</tr>

	</table>

	<!-- 显示图片有问题 -->
	<form action="chargeMoney.action" method="post">
<input type="hidden" name="money"  value="${tbCar.money}"/>
<input type="hidden" name="endTime"  value="${tbCar.endTime}"/>
		<input type="hidden" name="carId" value="${tbCar.carId}" /> 
		<input type="submit"
			value="扫描支付" />
	</form>

	<img
		src="<%=path%>/carImg/money1.jpg"
		alt="微信支付" height="250" width="200" />
		&nbsp;	&nbsp;	&nbsp;	&nbsp;
	<img
		src="<%=path%>/carImg/money2.jpg"
		alt="支付宝支付" height="250" width="200"  />

</body>
</html>