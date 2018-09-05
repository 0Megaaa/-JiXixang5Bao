<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>新增白名单</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="${pageContext.request.contextPath }/assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/app.css">
    <script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
    <!-- 菜单 -->
			<c:import url="../manage/menu.jsp"></c:import>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

            <div class="row-content am-cf">


                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">新增白名单</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form class="am-form tpl-form-line-form" action="addWhite.action"  method="post">

                                    <div class="am-form-group">
                                        <label for="time" class="am-u-sm-3 am-form-label">
                                     		      车牌号
                                            <span class="tpl-form-line-small-title">mon</span>
                                        </label>
                                        <div class="am-u-sm-9">
                                            <input name="carNum" type="text" class="tpl-form-input">
                                            
                                        </div>
                                    </div>

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="submit" class="am-btn am-btn-primary tpl-btn-bg-color-success ">确认</button>                 
                                        </div>
                                    </div>
                                </form>
 								<form class="am-form tpl-form-line-form" action="whiteList.action" method="post">

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                           
                                            <button type="submit" class="am-btn am-btn-warning tpl-btn-bg-color-success ">返回</button>
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
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/amazeui.datatables.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
	<!-- JEVONS的JAVASCRIPT -->
	<script src="${pageContext.request.contextPath }/js/js_Jevons.js"></script>
</body>
<script type="text/javascript">
	 $(document).ready(function(){
		
		 $("#time").on('input propertychange',function(){
			var time = $("#time").val();
			$.ajax({
				type:"POST",
				url: "timeCheck.action",
				dataType:"json",			/* 返回值类型 */
				data:{"time":time},
  				success : function(msg){
  					var info = msg;
					if(info.flag){
	  					$("#timeCheck").html(info.message); 
	  					$("#timeCheck").css({"color":"green"});
					}else{
						$("#timeCheck").html(info.message); 
						$("#timeCheck").css({"color":"red"});
					}
  					
  				}
			});
		});
		
		
	}); 
</script>
</html>