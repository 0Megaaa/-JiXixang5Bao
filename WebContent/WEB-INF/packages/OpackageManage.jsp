<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐管理</title>
</head>
<body>
	
	<a href="add.action">新增套餐</a>
<form action="packageManage.action" method="post">
	<table border="1">
		<tr>
			<td>序号</td>
			<td>套餐时长(月)</td>
			<td>套餐价格(元)</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.pageList }" var="pack" varStatus="s">
			<tr>
				<td>${page.curPageIndex + s.index}</td> 
				<td>${pack.paTime }</td>
				<td>${pack.paPrice }</td>
				<td>
					<a href="modify.action?paId=${pack.paId }&curPage=${page.curPage}">修改</a>
					<a href="delete.action?paId=${pack.paId }&curPage=${page.curPage}">删除</a>
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
	
	var msg = "${msg == null ? "" : msg}";
	if(msg != ""){
		alert(msg);
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
		$("form").submit();
	}
	/* function keepPage(){
		var newUrl = 'delete.action?paId='+${pack.paId };    //设置新提交地址
        $("form").attr('action',newUrl);    //通过jquery为action属性赋值
        $("form").submit();    //提交ID为myform的表单
	} */
</script>
</html>