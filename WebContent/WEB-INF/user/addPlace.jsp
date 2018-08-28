<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车入库</title>
</head>
<body>
	<form action="carparkCheck.action" onsubmit="return check();"
	method="post" enctype="multipart/form-data">
		<input type="hidden" name="parkId" value="${viewCarPark.getParkId()}" />
		<div>您选的车位号为：${viewCarPark.getPrefix()} ${viewCarPark.parkNum}</div>
		<div>
			请输入车牌号<input type="text" id="num" name="carNum">
		</div>
		<div>	请选择文件:<input type="file" name="fileact"></div>
		<!--  onblur="clickBtn();" -->
		<input type="submit" value="车入库" />
	</form>
	<!--  <button onclick="clickBtn()">车入库</button> -->
</body>
<!--  <script type="text/javascript">
  		
  		/*	alert("sss");
  					alert(num.value); */
  	var clickBtn  = function(){
  	var num= document.getElementById("num").value;
  	alert("sssfccz");
  	alert(num);
  	
  			$.ajax({
  				url: "carparkNum.action",
  				type: "POST",
  				data:{"carNum":num},
  				success : function(res){
  					alert(res);
  				/* 	console.log(res); */
  				}
  			});
  		};
/* 	}; */
	  </script> -->



<script type="text/javascript">

function check() {
	var num= document.getElementById("num").value;
	 var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
 	if(num==""){
		
		alert("车牌号不能为空！")
		return false;
	} else if (num.length!= 7){
	        
	    	   alert("车牌号应为7位");
	    	   return false;
	      
	      }else if ( !express.test(num)) {
	    	   alert("车牌号不正确");
	    	   return false;
		}
	
	 
	} 
	
	


</script>

<script type="text/javascript">
var msg='${msg==null?  "" : msg}';
if(msg!=""){
	alert(msg);
	
}
</script>

</html>