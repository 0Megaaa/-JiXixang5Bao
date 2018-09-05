<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=path%>/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path%>/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="<%=path%>/assets/js/echarts.min.js"></script>
<link rel="stylesheet" href="<%=path%>/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="<%=path%>/assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/app.css">
<script src="<%=path%>/assets/js/jquery.min.js"></script>
<style type="text/css">
#canvas {
	border: 1px solid #ADACB0;
	display: block;
	margin: 20px auto;
}
</style>
</head>
<body data-type="widgets">
	 
			 
			<!-- 菜单 -->
			<c:import url="menu.jsp"></c:import>
		 
		 
		 

		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">



			<div class="row-content am-cf">


				<div class="row">

					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title am-fl">总车位:${allPark};已占用车位:${bePark}</div>
								<div class="widget-function am-fr">
									<a href="javascript:;" class="am-icon-cog"></a>
								</div>
							</div>

							<c:if test="${list!=null}">

								<canvas id="canvas" width="800" height="450"> 你的浏览器还不支持canvas</canvas>

							</c:if>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script src="<%=path%>/assets/js/amazeui.min.js"></script>
	<script src="<%=path%>/assets/js/amazeui.datatables.min.js"></script>
	<script src="<%=path%>/assets/js/dataTables.responsive.min.js"></script>
	<script src="<%=path%>/assets/js/app.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript">
		function addRule() {
			$("form").submit();
		}
	</script>
</body>
<script type="text/javascript">
 
var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");


<c:forEach items="${list}" var="type">
/* console.log("${type.getPrefix()}"); */

    context.rect(60*"${type.getParkX()}",30*"${type.getParkY()}",60,30);

context.stroke();
 
/*判断是否有车停  */
<c:if test="${type.getCarId()!=''}">
console.log("${type.getPrefix()}");
context.fillStyle="#F5270B";
context.fillRect(60*"${type.getParkX()}",30*"${type.getParkY()}",60,30);
context.fillStyle="#0F0F0F";
context.fillText("${type.getCarNum()}", 53*"${type.getParkX()}"+20,33*"${type.getParkY()}"+10);
 

</c:if>


<c:if test="${type.getCarId()==''}">
/* console.log("${type.getPrefix()}"); */
context.fillStyle="#00CD00";
context.fillRect(60*"${type.getParkX()}",30*"${type.getParkY()}",60,30);
context.fillStyle="#000000";
context.fillText("${type.getPrefix()}${type.getParkNum()}  ", 60*"${type.getParkX()}"+20,30*"${type.getParkY()}"+10);

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
</html>