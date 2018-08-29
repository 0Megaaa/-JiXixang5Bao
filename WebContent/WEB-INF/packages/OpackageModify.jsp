<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>套餐修改</title>
</head>
<body>
	<form action="modifyPost.action" method="post">
	<input type="hidden" name ="curPage" value="${page.curPage}" id="curPage"/>
		<input type="hidden" name="paId" value="${pack.paId }">
		<table border="1">
			<tr>
				<td>套餐时长:</td>
				<td>
					<input type="text" name="paTime" value="${pack.paTime }">
				</td>
			</tr>
			<tr>
				<td>套餐价格:</td>
				<td>
					<input type="text" name="paPrice" value="${pack.paPrice }">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="修改">
				</td>
				<td>
					<input type="reset">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>