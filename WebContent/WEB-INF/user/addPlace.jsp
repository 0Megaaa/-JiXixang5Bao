<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/button.css" />

<title>车入库</title>
</head>
<body>
	<div style="position: absolute; left: 600px; top: 10px;">

		<input type="image"
			src="${pageContext.request.contextPath}/assets/img/2.png"
			width="200px" height="200px" />
	</div>
	<div style="position: absolute; left: 480px; top: 210px;">
		<a href="carpark.action"
			class="button button-3d button-primary button-rounded">停车入库</a> <a
			href="javascript:input()"
			class="button button-3d button-primary button-rounded">自助缴费</a> <a
			href="findCar.action"
			class="button button-3d button-primary button-rounded">寻爱车</a>
	</div>
	<div  style="position: absolute; left: 580px; top: 270px;" >
	<form action="carparkCheck.action" onsubmit="return check();"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="parkId" value="${viewCarPark.getParkId()}" />
		<div>您选的车位号为：${viewCarPark.getPrefix()} ${viewCarPark.parkNum}</div>
		<div style="margin-top: 8px">
			请输入车牌号<input type="text" id="num" name="carNum" 	style="line-height: 22px">
		</div>
		<div style="margin-top: 8px">
			请选择文件:<input type="file" name="fileact" 	style="line-height: 22px">
		</div>
<div style="margin-top: 8px;margin-left: 50px">
		<input type="submit" value="车入库" 
		class="button button-glow button-border button-rounded button-primary" 
		/></div>
	</form>
</div>
</body>
<script type="text/javascript">
	function check() {
		var num = document.getElementById("num").value;
		var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
		if (num == "") {

			alert("车牌号不能为空！")
			return false;
		} else if (num.length != 7) {

			alert("车牌号应为7位");
			return false;

		} else if (!express.test(num)) {
			alert("车牌号不正确");
			return false;
		}

	}
</script>

<script type="text/javascript">
	var msg = '${msg==null?  "" : msg}';
	if (msg != "") {
		alert(msg);

	}
</script>

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