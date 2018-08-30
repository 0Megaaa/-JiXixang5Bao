<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>会员管理</title>
</head>
<body>
<form action="whiteList.action" method="post">

	<a href="toAddWhiteList.action">新增白名单</a>
	
	<table>
		<tr>
			<td>车牌号:</td>
			<td>
				<input type="text" name="carNum" id="carNum" value="${page.carNum }"/>
			</td>
		</tr>
		<tr>
			<td>登记日期:</td>
			<td>
				<input type="text" name="startDate" id="startDate" value="${page.startDate }"/>
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
			<td>车牌号码</td>
			<td>生效日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.pageList }" var="white" varStatus="s">
			<tr>
				<td>${page.curPageIndex + s.count}</td>
				<td>${white.carNum }</td>
				<td>${white.startDate }</td>
				<td><a href="deleteWhite.action?whiteId=${white.whiteId }">删除</a></td>
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
</script>
</html>