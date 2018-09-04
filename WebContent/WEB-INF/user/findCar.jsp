<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/button.css" />

<title>用户自助端</title>
<style type="text/css">
#canvas {
	border: 1px solid #ADACB0;
	display: block;
	margin: 20px auto;
}
</style>
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



	<!--根据设备找车.  -->
	<div style="position: absolute; left: 520px; top: 260px;">
		<form action="findCar1.action" id="form" method="post"
			onsubmit="return check();">
			
			<div style="margin-top: 5px;margin-left: 50px" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车牌号:<input type="text"
					name="carNum" id="carNum" style="line-height: 22px ;width: 100px"  />
			</div>
			<div style="margin-left:  80px;margin-top: 5px;">
				自助终端编号:
				<select  name="machine" id="machine" style="width:50px;">
				<option value="1">1</option>
					<option value="2">2</option>
					<option value="3"> 3</option>
						<option value="4">4</option>
				</select>
			
			</div>
			<div style="margin-left: 100px; margin-top: 15px">
				<input type="submit" value="寻车"
					class="button button-glow button-border button-rounded button-primary" />
			</div>
		</form>

	</div>

	<form action="selfCharge.action" id="selfCharge" method="post">
		<input type="hidden" name="carNum1" id="carNum1" />

	</form>
	<div style="position: absolute; left: 0px; top: 400px;">
		<canvas id="canvas" width="1500" height="750">
		你的浏览器还不支持canvas </canvas>
	</div>
</body>
<script type="text/javascript">
 
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");

//绘制路线图。
<c:forEach items="${listPoint}" var="type">
context.beginPath();
context.fillStyle="#F5270B";
context.arc("${type.getX()}"*25+12,"${type.getY()}"*25+12,5,0,2*Math.PI);


context.fill();



</c:forEach>

<c:forEach items="${list}" var="type">
/* console.log("${type.getPrefix()}"); */
context.rect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);

context.stroke();

/*判断是否有车停  */
<c:if test="${type.getCarId()!=''}">

context.fillStyle="#F5270B";
context.fillRect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);
context.font="20px Times New Roman";
context.fillStyle="#0F0F0F";

context.fillText("${type.getCarNum()}", 100*"${type.getParkX()}"+8,50*"${type.getParkY()}"+30);
var imgObj = new Image();
console.log(${type.getImgIndex()});
/*${type.getImgIndex()}  */
 imgObj.src = "${pageContext.request.contextPath}/carImg/${type.getImgIndex()}.png";   
 /*context.drawImage(imgObj,100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);    
 context.stroke(); */ 
 imgObj.onload=function(){
	 context.drawImage(imgObj,100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);
	 callback(imgObj);
  /*  var imagedata = context.getImageData(10,10,10,10);
   context.createImageData(imagedata); */
 }

</c:if>
<c:if test="${type.getCarNum()==carNum}">

context.fillStyle="#00FFFF";
context.fillRect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);
context.fillStyle="#0F0F0F";
context.fillText("${type.getCarNum()}", 100*"${type.getParkX()}"+8,50*"${type.getParkY()}"+30);
 
</c:if>

<c:if test="${type.getCarId()==''}">
/* console.log("${type.getPrefix()}"); */
context.fillStyle="#00CD00";
context.fillRect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);
context.fillStyle="#000000";

context.font="20px Times New Roman";
  context.fillText("${type.getPrefix()}${type.getParkNum()}", 100*"${type.getParkX()}"+8,50*"${type.getParkY()}"+30);
   

</c:if>

/* context.rect(150,50,100,50); 
 */

</c:forEach>
//设置四个点
//左1

 context.fillStyle="#436EEE";
context.fillRect(100*0,50*6,75,50);
context.fillStyle="#0F0F0F";
context.fillText("设备1", 100*0+10,50*6+27);
 
 
//上
context.fillStyle="#436EEE";
context.fillRect(100*6,0,75,50);
context.fillStyle="#0F0F0F";
context.fillText("设备2", 100*6+10,50*0+27);
 
//右
 
  context.fillStyle="#436EEE";
context.fillRect(100*12.5,50*6,75,50);
context.fillStyle="#0F0F0F";
context.fillText("设备3", 100*12.5+10,50*6+27);
 
//下
context.fillStyle="#436EEE";
context.fillRect(100*6,50*13,75,50);
context.fillStyle="#0F0F0F";
context.fillText("设备4", 100*6+10,50*13+27);
 
 
 /* 获取该点的位置，触发事件 */
 canvas.onclick=function(e){//给canvas添加点击事件
    e=e||event;//获取事件对象
    //获取事件在canvas中发生的位置
    var x=e.clientX-canvas.offsetLeft;
    var y=e.clientY-canvas.offsetTop;
    console.log(x);
    console.log(y);
    //如果事件位置在矩形区域中
 
 document.getElementById("x").value= (x);
 document.getElementById("y").value= (y);  
 /* console.log( document.getElementById("x").value);  */
  document.getElementById("form").submit(); 
    
} 

</script>
<script type="text/javascript">
var msg='${msg==null?  "" : msg}';
if(msg!=""){
	alert(msg);
	
}

</script>
<script type="text/javascript">

function check() {
	var machine= document.getElementById("machine").value
	var num= document.getElementById("carNum").value
	var num1=/^[1-4]*$/;
	var  length=/^\d{1}$/;
	 var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
	if(machine==""){
		alert("设备号不能为空");
		return false;
	}else if(!num1.test(machine)){
		
		alert("请输入1-4的数字");
		return false;
	}
else if(!length.test(machine.length)){
		
		alert("请输入1-4的数字");
		return false;
	}
else if(num==""){
		
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