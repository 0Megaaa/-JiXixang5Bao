<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">

</head>
<body>
	<form id="form" name="form" action="addRule.action" method="post">
		<!--导航-->

		<div class="container">
			<div class="col-md-10">
				<h2>添加规则</h2>





 
							

				<table class="table">
					<thead>
						<tr>
							<th>规则名称</th>
							<td><input type="text" name="ruleName"></td>
						</tr>
						<tr>
							<th>不足3小时收费</th>
							<td><input type="text" name="passfh"></td>
						</tr>
						<tr>
							<th>超过3小时时每小时收费</th>
							<td><input type="text" name="pass3h"></td>
						</tr>
						<tr>
							<th>超过5小时每小时收费</th>
							<td><input type="text" name="pass5h"></td>
						</tr>
						<tr>
							<th>超过8小时按全天收费</th>
							<td><input type="text" name="pass8h"></td>
						</tr>
						 
						 
					</thead>
					<tbody>
					
					<td><button type="button" onclick="addRule();">添加规则</button></td>
					</tbody>
				</table>
			</div>
		</div>



	</form>

</body>

<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	function addRule(){
		$("form").submit();
	}

 
</script>
</html>