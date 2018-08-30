<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">

</head>
<body>
	<form id="form" name="form" action="findAll.action" method="post">
		<!--导航-->

		<div class="container">
			<div class="col-md-10">
				<h2>规则查询</h2>





				<table class="table table-bordered">
					<tbody>
						<tr>
							<td>规则名称：</td>
							<td><input type="text" name="cardnum"></td>
							<td><button type="button" onclick="query();">查询</button></td>
							<td><a href="add.action">添加收费规则</a></td>
						</tr>
					</tbody>
				</table>

				<table class="table">
					<thead>
						<tr>
							<th>序号</th>
							<th>规则名称</th>
							<th>不足3小时收费</th>
							<th>超过3小时时收费(/h)</th>
							<th>超过5小时收费(/h)</th>
							<th>超过8小时收费</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${page.pageList != null}">
							<c:forEach items="${page.pageList}" var="list" varStatus="s">
								<tr>
									<th scope="row">${ s.index + 1}</th>
									<td>${list.ruleName}</td>
									<td>${list.passfh}</td>
									<td>${list.pass3h}</td>
									<td>${list.pass5h}</td>
									<td>${list.pass8h}</td>
									<c:if test="${list.ruleState == 1}"><td>已启动</td></c:if>
									<c:if test="${list.ruleState == 2}"><td>已禁用</td></c:if>
									
									

									 <td><a href="delete.action?ruleId=${list.ruleId}">删除</a></td>
									 <td><a href="open.action?ruleId=${list.ruleId}">启动</a></td> 
									 <td><a href="modify.action?ruleId=${list.ruleId}">修改</a></td> 
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>

		<!-- 分页 -->
		当前页<span>${page.curPage}</span>&nbsp;&nbsp;&nbsp;&nbsp; 总页数<span>${page.totalPage}</span>&nbsp;&nbsp;&nbsp;&nbsp;
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
		<input type="hidden" name="curPage" value="${page.curPage}"
			id="curPage" />
<%-- <a href="findAll.action?curPage=${page.curPage+1}">2</a> --%>

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