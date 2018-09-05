<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%String path=request.getContextPath(); String basePath=request.getScheme()+"://"+
    request.getServerName()+":"+request.getServerPort()+path+"/";%>
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
    <link rel="icon" type="image/png" href="<%=path %>/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="<%=path %>/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/app.css">
    <script src="<%=path %>/assets/js/jquery.min.js"></script>
  <%--   <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"/>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/aseets/css/bootstrap.min.css"/> --%> 

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
                                <div class="widget-title am-fl">出场收费端</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">
                            <div style="background-image: url(${pageContext.request.contextPath}/assets/img/bk.jpg);">
    
    
     <form  onsubmit = "return isfileact()" action="fileact.action" method="post" enctype="multipart/form-data" style="text-align:center;height:10%;width:80%;margin-left:10%;margin-top:20px">
     	 <div class="form-group" style="background-color: rgba(0,0,0,0.1);border:1px solid black">
     	  <h1><a>欢迎停车！</a></h1>
     	  <input type="hidden" name="flag" id="flag" value="${flag}"/>
     	 </div>
    <div class="form-group" style="background-color: rgba(0,0,0,0.1);height:500px;width:100%;margin-top:2%;border:1px solid black;">
     	 <div class="form-group" style="text-align:center;height:400px;width:48%;margin-left:49%;margin-top:50px;">
     	  
     		<h3><a>请选择车牌:</a></h3><input type="file" class="btn btn-primary" name="fileact" id="fileact" onblur="isfileact()">
     		<small id="fileactname"></small>
     		<p></p>
     	  <button type="submit"  class = "am-btn am-btn-primary tpl-btn-bg-color-success "  >提交</button>
     	  
     	  
     	  
     	  <c:if test="${flag == 1}">
     	  <h3>车牌号：${tbCar.carNum}</h3>
     	  <h3>出场时间：${tbCar.endTime}</h3>
     	  <h3>需交费：${tbCar.money}</h3>
     	  <h3>用户类型：${tbCar.userType}</h3>
    	  </c:if>
     	</div>
     </div>  
     </form>
     
        <div class="form-group" style="text-align:center;height:400px;width:38%;margin-left:10%;margin-top:-370px;">
     <c:if test="${flag != 1}">
     	<img id="up" src="${pageContext.request.contextPath}/assets/img/down.jpg" style="width:80%; height:70%;" />
     </c:if>
     <c:if test="${flag == 1}">
     	<img  id="up" src="${pageContext.request.contextPath}/assets/img/up.jpg" style="width:80%; height:70%;"/>
     </c:if>
   	    </div>
   
   
  </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <script src="<%=path %>/assets/js/amazeui.min.js"></script>
    <script src="<%=path %>/assets/js/amazeui.datatables.min.js"></script>
    <script src="<%=path %>/assets/js/dataTables.responsive.min.js"></script>
    <script src="<%=path %>/assets/js/app.js"></script>
    
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
var message = "${message == null ? "" : message}";
if(message != "")
{
	alert(message);
	var i = setTimeout('check()',5000);

	function check() {
		
		 if( $('#up')[0].src == 'http://localhost:8080/park/assets/img/up.jpg') {
			 $('#up').attr('src','${pageContext.request.contextPath}/assets/img/down.jpg');
			 alert("车闸关闭了!");
		}
	 }
}

 
</script>
<script language="javascript"> 
function isfileact(){ 
var fileact=window.document.getElementById("fileact").value;
var fileactname=window.document.getElementById("fileactname");
 
if(fileact.length==0){ 
	fileactname.innerHTML = "不能为空！"
return false; 
}
else{
	fileactname.innerHTML = "";
}
return true;
}


</script>  
</body>

</html>