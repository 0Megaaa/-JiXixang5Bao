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
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/button.css"/>
<style type="text/css">
table, td, th {
    border: 1px solid black;
}
table {
    border-collapse: collapse;
}

</style>



<title>缴费界面</title>
</head>
<body>




<div style="position: absolute;left: 600px; top: 10px;" >

<input type="image" src="${pageContext.request.contextPath}/assets/img/2.png" width ="200px" height="200px"/>
</div>
<div style="position: absolute;left: 480px; top: 210px;" >
<a  href="carpark.action" class="button button-3d button-primary button-rounded">停车入库</a>
<a href="javascript:input()"  class="button button-3d button-primary button-rounded">自助缴费</a>
<a  href="findCar.action" class="button button-3d button-primary button-rounded">寻爱车</a>
</div>

<div   style="position: absolute;left: 400px; top: 300px;" >
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
		<input type="hidden" name="money" value="${tbCar.money}" /> <input
			type="hidden" name="endTime" value="${tbCar.endTime}" /> <input
			type="hidden" name="carId" value="${tbCar.carId}" /> <input
			type="submit" value="扫描支付" class="button button-raised button-primary button-pill" 
			style="margin-top: 10px; margin-left: 240px" 
			 />
	</form>

	<img src="<%=path%>/carImg/money1.png" alt="微信支付" height="250"
		width="250" style="margin-top: 20px"/> &nbsp; &nbsp; &nbsp; &nbsp;
	<img src="<%=path%>/carImg/money2.png" alt="支付宝支付" height="250"
		width="250" style="margin-left: 80px" />
</div>
</body>

<script type="text/javascript">
function input() {
	 var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
	 
	var t=prompt("请输入车牌号");
	if(t==null || t==''){
		alert("车牌号不能为空");
		
		
	}
	else if (t.length!= 7){
        
 	   alert("车牌号应为7位");
 	 
   
   }else if ( !express.test(t)) {
 	   alert("车牌号不正确");
 	   
	}else  {
		console.log(t);
document.getElementById("carNum1").value=t;
	
		 document.getElementById("selfCharge").submit();
		
	}
}
</script>

</html>