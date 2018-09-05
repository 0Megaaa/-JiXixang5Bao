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
<link rel="apple-touch-icon-precomposed"
	href="<%=path %>/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="<%=path %>/assets/js/echarts.min.js"></script>
<link rel="stylesheet" href="<%=path %>/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/app.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/spop.min.css">
<script src="<%=path %>/assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
	<!-- 菜单 -->
			<c:import url="menu.jsp"></c:import>


		<!-- 内容区域 -->
		
		<form id="form" name="form" action="findAll.action" method="post">
		<div class="tpl-content-wrapper">
			<div class="row-content am-cf">
				<div class="row">
					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title  am-cf">规则列表</div>


							</div>
							
							<div class="widget-body  am-fr">
								<div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
									<div class="am-form-group">
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs">
											<a href="add.action">
												<button type="button"
													class="am-btn am-btn-default am-btn-success">
													<span class="am-icon-plus"></span> 新增
												</button>
												</a>
											</div>
										</div>
									</div>
								</div>

								<div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
									<div
										class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
										<input type="text" class="am-form-field " name="ruleName"> <span
											class="am-input-group-btn">
											<button
												class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search"
												type="button" onclick="query();"></button>
										</span>
									</div>
								</div>

								<div class="am-u-sm-12">
									<table width="100%"
										class="am-table am-table-compact am-table-striped tpl-table-black "
										id="example-r">
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
						
											<tr class="gradeX">
												<th scope="row">${ s.index + 1}</th>
									<td>${list.ruleName}</td>
									<td>${list.passfh}</td>
									<td>${list.pass3h}</td>
									<td>${list.pass5h}</td>
									<td>${list.pass8h}</td>
									
									
									<c:if test="${list.ruleState == 1}"><td>已启动</td></c:if>
									<c:if test="${list.ruleState == 2}"><td>已禁用</td></c:if>
												
												
												<td>
													<div class="tpl-table-black-operation">
														<a href="modify.action?ruleId=${list.ruleId}"> 
														<i class="am-icon-pencil"></i>
															编辑
														</a> 
														<a href="delete.action?ruleId=${list.ruleId}&&ruleState=${list.ruleState}"
															class="tpl-table-black-operation-del"> <i
															class="am-icon-trash"></i> 删除
														</a>
														<a href="open.action?ruleId=${list.ruleId}"
															class="am-btn am-btn-default am-btn-warning"> <i
															class="am-icon-pencil"></i> 启动
														</a>
													</div>
												</td>
											</tr>
											 	</c:forEach>
						</c:if>
											<!-- more data -->
										</tbody>
									</table>
								</div>
								<div class="am-u-lg-12 am-cf">

									<div class="am-fr">
									
									
										<!-- <ul class="am-pagination tpl-pagination">
											<li class="am-disabled"><a href="#">«</a></li>
											<li class="am-active"><a href="#">1</a></li>
											<li><a href="#">2</a></li>
											<li><a href="#">3</a></li>
											<li><a href="#">4</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">»</a></li>
										</ul> -->
										
										
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
		<input type="hidden" name="curPage" value="${page.curPage}"
			id="curPage" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
	
	
	</div>
	
	
	
	<script src="<%=path %>/assets/js/amazeui.min.js"></script>
	<script src="<%=path %>/assets/js/amazeui.datatables.min.js"></script>
	<script src="<%=path %>/assets/js/dataTables.responsive.min.js"></script>
	<script src="<%=path %>/assets/js/app.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/spop.min.js"></script>
	
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
	<script type="text/javascript">
$(function() {
	if ("${deletemsg}") {
		spop({
			template : "${deletemsg}",
			autoclose : 1500
		});
		
	}
	if ("${openmsg}") {
		spop({
			template : "${openmsg}",
			autoclose : 1500
		});
		
	}
	
	if ("${addmsg}") {
		spop({
			template : "${addmsg}",
			autoclose : 1500
		});
		
	}
	
	
});
 
</script>
</body>

</html>