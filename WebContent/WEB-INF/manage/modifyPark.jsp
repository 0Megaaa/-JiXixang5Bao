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
    <script src="<%=path %>/js/echarts.min.js"></script>
     <script src="<%=path %>/js/boostrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="<%=path %>/assets/css/app.css">
    <script src="<%=path %>/assets/js/jquery.min.js"></script>
   
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/spop.min.css">
 	<style type="text/css">
    	.myselect{
    		width: 150px;
    		height: 40px;
    		border-radius: 10px;
    		background-color: red;
    		font: 30px;
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
                               <div class="widget-title am-fl">总车位：</div> <div id="parkAllNum" class="widget-title am-fl">${parkNum}</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">


                              <form onsubmit = "return isprifix1Num()&&isprifix2Num()&&isprifix3Num()&&isprifix4Num()&&isunPrifixNum()" class="am-form tpl-form-line-form" action="modify.action"  id="form" name="form" method="post">
                                    
                            <div class="am-form-group">
                             <label for="user-phone" class="am-u-sm-3 am-form-label">车编号<span class="tpl-form-line-small-title"></span></label>
                             <div class="am-u-sm-9">
                             
                           
                             <div class="form-group">
                             	<select class="myselect">
                             		<option>1</option>
                             	</select>
                             </div>
                             
                             
                             <select  name="machine" id="prifix1"   class = "form-group">
				            
				             	<option value="A">A</option>
				              
				              </select>
                             
                             </div>
                                        
                             <div class="am-u-sm-9">
                             <input type="text" name="prifix1Num" id = "prifix1Num"class="tpl-form-input"    onblur="isprifix1Num()" >
                             <small id="prifix1Numname"></small>
                             </div>
                             </div>
                             
                             
                             <div class="am-form-group">
                             <label for="user-phone" class="am-u-sm-3 am-form-label">车编号<span class="tpl-form-line-small-title"></span></label>
                             <div class="am-u-sm-9">
                             <select   style="width:10px;"  name="prifix2">
                             <option value="B">B</option>
                             </select>
                             </div>
                                        
                             <div class="am-u-sm-9">
                             <input type="text"  class="tpl-form-input" id="prifix2Num"   name="prifix2Num" onblur="isprifix2Num()">
                            <small id="prifix2Numname"></small>
                             </div>
                             </div>
                             
                             
                             <div class="am-form-group">
                             <label for="user-phone" class="am-u-sm-3 am-form-label">车编号<span class="tpl-form-line-small-title"></span></label>
                             <div class="am-u-sm-9">
                             <select data-am-selected="{searchBox: 1}" style="display: none;" name="prifix3">
                             <option value="C">C</option>
                             </select>
                             </div>
                                        
                             <div class="am-u-sm-9">
                             <input type="text"  class="tpl-form-input" id="prifix3Num"   name="prifix3Num" onblur="isprifix3Num()">
                             <small id="prifix3Numname"></small>
                             </div>
                             </div>
                             
                             <div class="am-form-group">
                             <label for="user-phone" class="am-u-sm-3 am-form-label">车编号<span class="tpl-form-line-small-title"></span></label>
                             <div class="am-u-sm-9">
                             <select data-am-selected="{searchBox: 1}" style="display: none;" name="prifix4" >
                             <option value="D">D</option>
                             </select>
                             </div>
                                        
                             <div class="am-u-sm-9">
                             <input type="text"  class="tpl-form-input" id="prifix4Num"   name="prifix4Num" onblur="isprifix4Num()" >
                             <small id="prifix4Numname"></small>
                             </div>
                             </div>
                             
                             <div class="am-form-group">
                             <label for="user-phone" class="am-u-sm-3 am-form-label">无编号车位数量<span class="tpl-form-line-small-title"></span></label>
                              
                                        
                             <div class="am-u-sm-9">
                             <input type="text"  class="tpl-form-input" id="unPrifixNum"   name="unPrifixNum" onblur="isunPrifixNum()" >
                             <small id="unPrifixNumname"></small>
                             </div>
                             </div>
                             
                              
                             
                             
                             
                             
                             
                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="button"  class = "am-btn am-btn-primary tpl-btn-bg-color-success " onclick="modifyDo();">提交</button>
                                       <small id="buttonname"></small>
                                        </div>
                              
                              
                              
                                    </div>
                                </form>
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
	<script src="${pageContext.request.contextPath }/js/spop.min.js"></script>
<script type="text/javascript">
	function modifyDo(){
		
		var prifix1Num=window.document.getElementById("prifix1Num").value;
		var prifix2Num=window.document.getElementById("prifix2Num").value;
		var prifix3Num=window.document.getElementById("prifix3Num").value;
		var prifix4Num=window.document.getElementById("prifix4Num").value;
		var unPrifixNum=window.document.getElementById("unPrifixNum").value;
		var parkAllNum=${parkNum};
		var buttonname=window.document.getElementById("buttonname");
		
		if(parseInt(prifix1Num)+parseInt(prifix2Num)+parseInt(prifix3Num)+parseInt(prifix4Num)+parseInt(unPrifixNum)>parseInt(parkAllNum)){ 
			buttonname.innerHTML="超过总车位数量！"
			return false; 
		}else{
			$("form").submit();
		}
		
	}

 
</script>
<script type="text/javascript">
$(function() {
	if ("${parkmsg}") {
		spop({
			template : "${parkmsg}",
			autoclose : 1500
		});
		
	}
	 
	
	
});
 
</script>


<!-- 表单验证 -->
<script language="javascript"> 
function isprifix1Num(){ 
	
var prifix1Num=window.document.getElementById("prifix1Num").value;

var parkAllNum=${parkNum};
var prifix1Numname=window.document.getElementById("prifix1Numname");
var reg = /^[0-9]+$/; 
if(prifix1Num.length==0){ 
	prifix1Numname.innerHTML="不能为空！"
return false; 
}
if(!reg.test(prifix1Num)){ 
	prifix1Numname.innerHTML = "输入有误！"
	return false; 
}
if(prifix1Num.length>4){ 
	prifix1Numname.innerHTML = "数字过大！"
	return false; 
	} 	
if(prifix1Num>parkAllNum){ 
	prifix1Numname.innerHTML = "超过总车位数量！"
	return false; 
	} 
if(prifix1Num==0){ 
	prifix1Numname.innerHTML = "输入有误！"
	return false; 
}
else{
	prifix1Numname.innerHTML = "通过！";
}
return true;
}

function isprifix2Num(){ 
	
	var prifix2Num=window.document.getElementById("prifix2Num").value;
	 
	var prifix2Numname=window.document.getElementById("prifix2Numname");
	var reg = /^[0-9]+$/; 
	if(prifix2Num.length==0){ 
		prifix2Numname.innerHTML="不能为空！"
	return false; 
	}
	if(!reg.test(prifix2Num)){ 
		prifix2Numname.innerHTML = "输入有误！"
		return false; 
	}
	if(prifix2Num.length>4){ 
		prifix2Numname.innerHTML = "数字过大！"
		return false; 
		}
	if(prifix2Num==0){ 
		prifix2Numname.innerHTML = "输入有误！"
		return false; 
	}
	else{
		prifix2Numname.innerHTML = "通过！";
	}
	return true;
	}
	
	
function isprifix3Num(){ 
	
	var prifix3Num=window.document.getElementById("prifix3Num").value;
	 
	var prifix3Numname=window.document.getElementById("prifix3Numname");
	var reg = /^[0-9]+$/; 
	if(prifix3Num.length==0){ 
		prifix3Numname.innerHTML="不能为空！"
	return false; 
	}
	if(!reg.test(prifix3Num)){ 
		prifix3Numname.innerHTML = "输入有误！"
		return false; 
	}
	if(prifix3Num.length>4){ 
		prifix3Numname.innerHTML = "数字过大！"
		return false; 
		} 
	if(prifix3Num==0){ 
		prifix3Numname.innerHTML = "输入有误！"
		return false; 
	}
	else{
		prifix3Numname.innerHTML = "通过！";
	}
	return true;
	}

function isprifix4Num(){ 
	
	var prifix4Num=window.document.getElementById("prifix4Num").value;
	 
	var prifix4Numname=window.document.getElementById("prifix4Numname");
	var reg = /^[0-9]+$/; 
	if(prifix4Num.length==0){ 
		prifix4Numname.innerHTML="不能为空！"
	return false; 
	}
	if(!reg.test(prifix4Num)){ 
		prifix4Numname.innerHTML = "输入有误！"
		return false; 
	}
	if(prifix4Num.length>4){ 
		prifix4Numname.innerHTML = "数字过大！"
		return false; 
		} 
	if(prifix4Num==0){ 
		prifix4Numname.innerHTML = "输入有误！"
		return false; 
	}
	else{
		prifix4Numname.innerHTML = "通过！";
	}
	return true;
	}
	
function isunPrifixNum(){ 
	
	var unPrifixNum=window.document.getElementById("unPrifixNum").value;
	 
	var unPrifixNumname=window.document.getElementById("unPrifixNumname");
	var reg = /^[0-9]+$/; 
	if(unPrifixNum.length==0){ 
		unPrifixNumname.innerHTML="不能为空！"
	return false; 
	}
	if(!reg.test(unPrifixNum)){ 
		unPrifixNumname.innerHTML = "输入有误！"
		return false; 
	}
	if(unPrifixNum.length>4){ 
		unPrifixNumname.innerHTML = "数字过大！"
		return false; 
		} 	
	if(unPrifixNum==0){ 
		unPrifixNumname.innerHTML = "输入有误！"
		return false; 
	}
	else{
		unPrifixNumname.innerHTML = "通过！";
	}
	return true;
	}
 

</script>

</body>

</html>