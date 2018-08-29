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
<form action="vipManage.action" method="post">

	<a href="add.action">会员办理</a>
	
	<table>
		<tr>
			<td>车牌号:</td>
			<td>
				<input type="text" name="carNum" value="${page.carNum }"/>
			</td>
		</tr>
		<tr>
			<td>开始日期:</td>
			<td>
				<input type="text" name="startDate" value="${page.startDate }"/>
			</td>
		</tr>
		<tr>
			<td>会员状态:</td>
			<td>
				<select name="vipState">
					<option value ="0" >请选择类型</option>
					<c:if test="${1 == page.vipState}">
						<option value="1" selected="selected">正常</option>
					</c:if>
					<c:if test="${1 != page.vipState}">
						<option value="1">正常</option>
					</c:if>
					<c:if test="${2 == page.vipState}">
						<option value="2" selected="selected">逾期</option>
					</c:if>
					<c:if test="${2 != page.vipState}">
						<option value="2">逾期</option>
					</c:if>
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
			<td>车牌号码</td>
			<td>生效日期</td>
			<td>会员状态</td>
			<td>套餐时长</td>
			<td>套餐价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.pageList }" var="vip" varStatus="s">
			<tr>
				<td>${page.curPageIndex + s.index}</td>
				<td>${vip.carNum }</td>
				<td>${vip.startDate }</td>
				<c:if test="${vip.vipState == 1}"><td>活跃</td></c:if>
				<c:if test="${vip.vipState == 2}"><td>逾期</td></c:if>
				<td>${vip.paTime }</td>
				<td>${vip.paPrice }</td>
				<td><a href="refund.action?vipId=${vip.vipId }">会员退费</a></td>
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
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
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
		$("form").submit();
	}
</script>
</html>