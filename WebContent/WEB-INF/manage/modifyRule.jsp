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
                                <div class="widget-title am-fl">修改规则规则</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form onsubmit = "return isChinese()&&ispassfh()&&ispass3h()&&ispass5h()&&ispass8h()"  class="am-form tpl-form-line-form" action="modifyDo.action"  id="form" name="form" method="post">
                                
                                
                                 <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">规则名称 <span class="tpl-form-line-small-title"></span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="ruleName" class="tpl-form-input" id="ruleName"  onblur="isChinese()" value="${rule.ruleName}" placeholder="请输入不超过15个字中文！">
                                        <small id="checkname"></small>
                                        </div>
                                    </div>
                                
                                <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">不足3小时收费 <span class="tpl-form-line-small-title"></span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="passfh" class="tpl-form-input"  value="${rule.passfh}" id="passfh" placeholder="请输入收取费用" onblur="ispassfh()">
                                            <small id="passfhname"></small>
                                        </div>
                                    </div>
                                
                                     <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">超过3小时时每小时收费 <span class="tpl-form-line-small-title"></span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="pass3h" class="tpl-form-input" onblur="ispass3h()" value="${rule.pass3h}" id="pass3h" placeholder="请输入收取费用">
                                            <small id="pass3hname"></small>
                                        </div>
                                    </div>
                                    
                                     <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">超过5小时时每小时收费 <span class="tpl-form-line-small-title"></span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="pass5h" class="tpl-form-input"  onblur="ispass5h()" value="${rule.pass5h}" id="pass5h" placeholder="请输入收取费用">
                                             <small id="pass5hname"></small>
                                        </div>
                                    </div>
                                    
                                      <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">超过8小时时每小时收费 <span class="tpl-form-line-small-title"></span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" name="pass8h" class="tpl-form-input"  onblur="ispass8h()" value="${rule.pass8h}" id="pass8h" placeholder="请输入收取费用">
                                           <small id="pass8hname"></small>
                                        </div>
                                    </div>
 










                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="button"  class = "am-btn am-btn-primary tpl-btn-bg-color-success " onclick="modifyDo();">提交</button>
                                             <button  type="button"  class = "am-btn am-btn-primary tpl-btn-bg-color-success " onclick = "javascript:history.back(-1);">返回</button>
                                        </div>
                                        <input type="hidden" name="ruleId" value="${rule.ruleId}"
			id="ruleId" />
			<input type="hidden" name="ruleState" value="${rule.ruleState}"
			id="ruleId" />
                                    </div>
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                </form>
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
	function modifyDo(){
		$("form").submit();
	}

 
</script>

<!-- 表单验证 -->
<script language="javascript"> 
function ispassfh(){ 
var passfh=window.document .getElementById ("passfh").value;
var passfhname=window.document .getElementById ("passfhname");
var reg = /^[0-9]+$/; 
if(passfh.length==0){ 
	passfhname.innerHTML = "不能为空！"
return false; 
}
if(!reg.test(passfh)){ 
	passfhname.innerHTML = "输入有误！"
	return false; 
}
if(passfh.length>4){ 
	passfhname.innerHTML = "数字过大请谨慎设置规则！"
	return false; 
	} 	
else{
	passfhname.innerHTML = "通过！";
}
return true;
}

function ispass8h(){ 
	var pass8h=window.document .getElementById ("pass8h").value;
	var pass8hname=window.document .getElementById ("pass8hname");
	var reg = /^[0-9]+$/; 
	if(pass8h.length==0){ 
		pass8hname.innerHTML = "不能为空！"
	return false; 
	}
	if(!reg.test(pass8h)){ 
		pass8hname.innerHTML = "输入有误！"
		return false; 
	}
	if(pass8h.length>4){ 
		pass8hname.innerHTML = "数字过大请谨慎设置规则！"
		return false; 
		} 	
	else{
		pass8hname.innerHTML = "通过！";
	}
	return true;
	}
	
function ispass5h(){ 
	var pass5h=window.document .getElementById ("pass5h").value;
	var pass5hname=window.document .getElementById ("pass5hname");
	var reg = /^[0-9]+$/; 
	if(pass5h.length==0){ 
		pass5hname.innerHTML = "不能为空！"
	return false; 
	}
	if(!reg.test(pass5h)){ 
		pass5hname.innerHTML = "输入有误！"
		return false; 
	}
	if(pass5h.length>4){ 
		pass5hname.innerHTML = "数字过大请谨慎设置规则！"
		return false; 
		} 	
	else{
		pass5hname.innerHTML = "通过！";
	}
	return true;
	}
	
function ispass3h(){ 
	var pass3h=window.document .getElementById ("pass3h").value;
	var pass3hname=window.document .getElementById ("pass3hname");
	var reg = /^[0-9]+$/; 
	if(pass3h.length==0){ 
		pass3hname.innerHTML = "不能为空！"
	return false; 
	}
	if(!reg.test(pass3h)){ 
		pass3hname.innerHTML = "输入有误！"
		return false; 
	}
	if(pass3h.length>4){ 
		pass3hname.innerHTML = "数字过大请谨慎设置规则！"
		return false; 
		} 	
	else{
		pass3hname.innerHTML = "通过！";
	}
	return true;
	}

function isChinese(){  
	var ruleName=window.document .getElementById ("ruleName").value;
	var checkname=window.document .getElementById ("checkname");
	var reg=/^[\u0391-\uFFE5]+$/; 
	if(ruleName.length==0){ 
	checkname.innerHTML = "不能为空！"
	return false; 
	}; 
	if(!reg.test(ruleName)){ 
		checkname.innerHTML = "输入有误！"
		return false; 
		}; 
	if(ruleName.length>15){ 
		checkname.innerHTML = "不超过15个字！"
		return false; 
		} 	
	else{
		checkname.innerHTML = "通过！";
	}
	return true;
	}

</script>
</body>

</html>