<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <title>会员管理</title>
</head>
<body>
<form action="packageMoneySum.action" method="post">

	<h1>套餐收入统计</h1>
	
	<table>

		<tr>
			<td>开始时间:</td>
			<td>
				<input type="text" name="startDate" id="startDate" value="${page.startDate }"/>
			</td>
		</tr>
		<tr>
		<tr>
			<td>套餐:</td>
			<td>
				<select id="pack" name="paId">
 		    		<option value="0">请选择</option>
		   	 		<c:forEach items="${packageList}" var="pack" >
		   	 			<option value="${pack.paId}">套餐-${pack.paId}</option>
		   	 		</c:forEach>
		   	 		</select> 
			</td>
		</tr>
		<tr>
			<td>
				<button type="button" onclick="query();">查询</button>
				
			</td>
		</tr>
	</table>
	
	<table border="1">
		<tr>
			<td>序号</td>
			<td>产品包</td>
			<td>产品时效</td>
			<td>收入量</td>
		</tr>
		<c:forEach items="${page.pageList }" var="vip" varStatus="s">
			<tr>
				<td>${page.curPageIndex + s.count}</td>
				<td>套餐-${vip.paId }</td>
				<td>${vip.paTime }</td>
				<td>${vip.money }</td>
			</tr>
		</c:forEach>
		
		
	</table>
		当前页<span>${page.curPage}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		总页数<span>${page.totalPage}</span>&nbsp;&nbsp;&nbsp;&nbsp;
		总条数<span>${page.totalRecord}</span>
   	<ul>
   		<c:if test="${page.curPage == 1 }">
   			<button type="button" disabled="disabled">上一页</button>
   		</c:if>
   		<c:if test="${page.curPage > 1 }">
   			<button onclick="lastpage();">上一页</button>
   		</c:if>
   		
		<c:if test="${page.curPage == page.totalPage }">
   			<button type="button" disabled="disabled">下一页</button>
   		</c:if>
   		<c:if test="${page.curPage <  page.totalPage }">
   			<button onclick="nextpage();">下一页</button>
   		</c:if>
    </ul>
  	<input type="hidden" name ="curPage" value="${page.curPage}" id="curPage"/>
   

</form>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript">

	var message = "${message == null ? "" : message}";
	if(message != "")
	{
		alert(message);
	}
	
	function nextpage(){
		document.getElementById("curPage").value = ${page.curPage +1};
		
		$("form").submit();
	}
	function lastpage(){
		document.getElementById("curPage").value = ${page.curPage -1};
		
		$("form").submit();
	}
	function query(){
		document.getElementById("curPage").value = 1;
		/* document.getElementById("carNum").value = ${page.carNum};
		document.getElementById("startDate").value = ${page.startDate}; */
		$("form").submit();
	}
	
	 function getPackage(){
		   $.ajax({
			   type:"post",
			   data:{
				   "message":"111"
				   },
			   dataType:"text",
			   url:"getPackage.action",
			   success:function(data){
				   var arr = eval(data);
				   $("#pack").html("<option value='0'>请选择</option>");
				   for(var i=0;i<arr.length;i++){
					   var doc = arr[i];
					   $("#package").append("<option value="+doc.paId+">"+'套餐'+doc.paId+"</option>");
				   };
			   }
		   })
	   };
</script>
</html>