<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">

</head>
<body>
	<form id="form" name="form" action="modifyDo.action" method="post">
		<!--导航-->

		<div class="container">
			<div class="col-md-10">
				<h2>添加规则</h2>





 
							

				<table class="table">
					<thead>
						<tr>
							<th>规则名称</th>
							<td><input type="text" name="ruleName" value="${rule.ruleName}"></td>
						</tr>
						<tr>
							<th>不足3小时收费</th>
							<td><input type="text" name="passfh" value="${rule.passfh}"></td>
						</tr>
						<tr>
							<th>超过3小时时每小时收费</th>
							<td><input type="text" name="pass3h" value="${rule.pass3h}"></td>
						</tr>
						<tr>
							<th>超过5小时每小时收费</th>
							<td><input type="text" name="pass5h" value="${rule.pass5h}"></td>
						</tr>
						<tr>
							<th>超过8小时按全天收费</th>
							<td><input type="text" name="pass8h" value="${rule.pass8h}"></td>
						</tr>
						 
					</thead>
					<tbody>
					
 
					<td><button type="button" onclick="modifyDo();">添加规则</button></td>
					</tbody>
				</table>
			</div>
		</div>
		<input type="hidden" name="ruleId" value="${rule.ruleId}"
			id="ruleId" />
			<input type="hidden" name="ruleState" value="${rule.ruleState}"
			id="ruleId" />


	</form>

</body>

<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	function modifyDo(){
		$("form").submit();
	}

 
</script>
</html>