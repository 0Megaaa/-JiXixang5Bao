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

<body data-type="chart">
    <!-- 菜单 -->
			<c:import url="menu.jsp"></c:import>

        <!-- 内容区域 -->
        <div class="tpl-content-wrapper">

             
                                <form onsubmit = "return isyear()" class="am-form tpl-form-line-form"    id="myForm" name="form" method="post">
                                
                                
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">查询年份<span class="tpl-form-line-small-title"></span></label>
                                         
                                        
                                        <div class="am-u-sm-9">
                                            <input type="text" name="year" id = "year" class="tpl-form-input"   placeholder="请输入年份" onblur="isyear()">
                                            <small id="yearname"></small>
                                        </div>
                                    </div>
                                     
                                    
                                    
                                      

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="button"  class = "am-btn am-btn-primary tpl-btn-bg-color-success " onclick="getdas();">提交</button>
                                        </div>
                                    </div>
                                </form>
           


 
 
   
<div id="container" style="height: 300%"></div>
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
 <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
app.title = '多 Y 轴示例';

var colors = ['#5793f3', '#d14a61', '#675bba'];

option = {
    color: colors,

    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross'
        }
    },
    grid: {
        right: '20%'
    },
    toolbox: {
        feature: {
            dataView: {show: true, readOnly: false},
            restore: {show: true},
            saveAsImage: {show: true}
        }
    },
    
    
    legend: {
        data:['自助缴费','收费端缴费','月缴费']
    },
    xAxis: [
        {
            type: 'category',
            axisTick: {
                alignWithLabel: true
            },
            data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '自助缴费',
            min: 0,
            max: 2500,
            position: 'right',
            axisLine: {
                lineStyle: {
                    color: colors[0]
                }
            },
            axisLabel: {
                formatter: '{value} ￥'
            }
        },
        {
            type: 'value',
            name: '收费端缴费',
            min: 0,
            max: 2500,
            position: 'right',
            offset: 80,
            axisLine: {
                lineStyle: {
                    color: colors[1]
                }
            },
            axisLabel: {
                formatter: '{value} ￥'
            }
        },
        {
            type: 'value',
            name: '月缴费',
            min: 0,
            max: 2500,
            position: 'right',
            offset: 160,
            axisLine: {
                lineStyle: {
                    color: colors[2]
                }
            },
            axisLabel: {
                formatter: '{value} ￥'
            }
        },
        
 
    ],
    series: [
        {
            name:'自助缴费',
            type:'bar',
            yAxisIndex: 1,
            data:[]
        },
        {
            name:'收费端缴费',
            type:'bar',
            yAxisIndex: 1,
            data:[]
        },
        {
            name:'月缴费',
            type:'bar',
            yAxisIndex: 1,
            data:[]
        },
         
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
};


       </script>
       
       
       <script type = "text/javascript">
       function getdas(){
    	   var data = $("#myForm").serialize(); 
    	    $.ajax({  
    	        url:"<%=basePath%>echartsAsynController/getDatas.action", 
    	        
    	        
    	        data:data,
    	        dataType:"json",  
    	        success:function(jsonData){   
    	            myChart.setOption({  
    	                 
    	               series: [  
    	                   // 根据名字对应到相应的系列  
    	                   {name: '自助缴费',  
    	                   data: jsonData.datas1},  
    	                   {name: '月缴费',  
    	                   data: jsonData.datas2 },
    	                   {name: '收费端缴费',  
        	               data: jsonData.datas3 }
    	               ],  
    	                
    	           });  
    	           // 设置加载等待隐藏  
    	           myChart.hideLoading();  
    	        }  
    	    }); 
    	};
</script>
       
       
   <!-- 表单验证 -->
<script language="javascript"> 
function isyear(){ 
var year=window.document.getElementById("year").value;
var yearname=window.document.getElementById("yearname");
var reg = /^[0-9]+$/; 
if(year.length==0){ 
	yearname.innerHTML = "不能为空！"
return false; 
}
if(!reg.test(year)){ 
	yearname.innerHTML = "输入有误！"
	return false; 
}
if(year.length>4){ 
	yearname.innerHTML = "年份不合理！"
	return false; 
	} 	
if(year.length<4){ 
	yearname.innerHTML = "年份不合理！"
	return false; 
	} 
else{
	yearname.innerHTML = "";
}
return true;
}


</script>    
       
       
       
       
       
              
</body>

</html>