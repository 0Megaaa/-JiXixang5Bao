<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加套餐</title>
</head>
<body>
	<form action="addPost.action" method="post">
		<table border="1">
			<tr>
				<td>套餐时长:</td>
				<td>
					<input type="text" name="paTime">
				</td>
			</tr>
			<tr>
				<td>套餐价格:</td>
				<td>
					<input type="text" name="paPrice">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="新增">
				</td>
				<td>
					<input type="reset">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>