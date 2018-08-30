<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车库鸟瞰图</title>
<style type="text/css">
#canvas {
	border: 1px solid #ADACB0;
	display: block;
	margin: 20px auto;
}
</style>
</head>
<body>

	<form action="carparkxy.action" id="form" method="post">

		<input type="hidden" name="x" id="x" /> <input type="hidden" name="y"
			id="y" />
	</form>

	<form action="selfCharge.action" id="selfCharge" method="post">
		<input type="hidden" name="carNum1" id="carNum1" />

	</form>

	<div>

		<c:if test="${list!=null}">
温馨提示：请点击要停放的车库。
<canvas id="canvas" width="3000" height="750"> 你的浏览器还不支持canvas
			</canvas>
		</c:if>

	</div>



</body>
<script type="text/javascript">
 
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");


<c:forEach items="${list}" var="type">
/* console.log("${type.getPrefix()}"); */

    context.rect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);

context.stroke();

/*判断是否有车停  */
<c:if test="${type.getCarId()!=''}">
console.log("${type.getPrefix()}");
context.fillStyle="#F5270B";
context.fillRect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);
context.fillStyle="#0F0F0F";
context.fillText("${type.getCarNum()}", 100*"${type.getParkX()}"+20,50*"${type.getParkY()}"+10);
 

</c:if>


<c:if test="${type.getCarId()==''}">
/* console.log("${type.getPrefix()}"); */
context.fillStyle="#00CD00";
context.fillRect(100*"${type.getParkX()}",50*"${type.getParkY()}",100,50);


</c:if>

/* context.rect(150,50,100,50); 
 */

</c:forEach>

 
 /* 获取该点的位置，触发事件 */
 canvas.onclick=function(e){//给canvas添加点击事件
    e=e||event;//获取事件对象
    //获取事件在canvas中发生的位置
    
   /*  var x=e.clientX-canvas.offsetLeft;
    var y=e.clientY-canvas.offsetTop; */
    //1
    var rect = canvas.getBoundingClientRect();
    //2
    var x = e.clientX - rect.left * (canvas.width / rect.width);
    var y = e.clientY - rect.top * (canvas.height / rect.height);
    
    console.log(x);
    console.log(y);
    //如果事件位置在矩形区域中
   /*  if(x/100>=1&&x/2<=2+100&&y/50>=1&&y/50<=2)
    {
        window.open("www.baidu.com");//打开指定链接
    }  */
    
  /*  (x/100) */
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