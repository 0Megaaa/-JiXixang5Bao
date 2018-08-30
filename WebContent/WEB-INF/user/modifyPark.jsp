<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">

</head>
<body>
	<form id="form"  action="modify.action" method="post">
		<!--导航-->

		<div class="container">
			<div class="col-md-10">
				<h2>车位管理</h2>

 
				<table class="table">
					<thead>
						 
						<tr>
							<th>车位编号</th>
							<td><input type="text" name="prifix1"  ></td>
							<th>车位数量</th>
							<td><input type="text" name="prifix1Num"  ></td>
						</tr>
						<tr>
							<th>车位编号</th>
							<td><input type="text" name="prifix2"  ></td>
							<th>车位数量</th>
							<td><input type="text" name="prifix2Num"  ></td>
						</tr>
						<tr>
							<th>车位编号</th>
							<td><input type="text" name="prifix3"  ></td>
							<th>车位数量</th>
							<td><input type="text" name="prifix3Num"  ></td>
						</tr>
						<tr>
							<th>车位编号</th>
							<td><input type="text" name="prifix4"  ></td>
							<th>车位数量</th>
							<td><input type="text" name="prifix4Num"  ></td>
						</tr>
						<tr>
							<th>无编号车位数量</th>
							<td><input type="text" name="unPrifixNum"  ></td>
						</tr>
 
 
					</thead>
					<tbody>


						<td><button type="button" onclick="modifyDo();">确认修改</button></td>
					</tbody>
				</table>
			</div>
		</div>
	</form>

</body>

<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	function modifyDo() {
		$("form").submit();
	}
</script>
</html>