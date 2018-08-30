<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户自助端欢迎页</title>
</head>
<body>

	<form action="staff/login.action" method="post">
		<div class="form-group">
			<label>帐号：</label>
			<div>
				<input name="staffAccount" type="text" id="staffAccount">
			</div>
		</div>
		<div class="form-group">
			<label>密码：</label>
			<div>
				<input name="staffPwd" type="text" id="staffpwd">
			</div>
		</div>

		<!-- 		<div>
			<label>验证码：</label>
			<div class="col-sm-10">
				<input type="text" id="code" name="code"> <img alt="点击更换"
					src="createImage.action" onclick="change(this)" />
			</div>
		</div> -->

		<!-- 		<!-- 引入Kaptcha组件配置文件 -->
		<!-- <import resource="spring-Kaptcha.xml"/> -->

		<div class="form-group">
			<button type="submit">登录</button>
		</div>
	</form>

	<!-- <form action="captcha.action"> -->
	<!-- <input type="text" name="kaptcha" value="" /><img src="captcha.action" />  -->
	<!-- </form>  -->



	<div class="form-group">
		<div class="row">
			<div class="col-sm-8">
				<input type="text" id="code" class="form-control" placeholder="验证码">
			</div>
			<div class="col-sm-4">
				<img onclick="changeImg()" alt="验证码看不清，换一张" id="codeImg"
					src="validataImg/captcha.action"
					style="display: block; width: 10%; height: 32px">


			</div>
		</div>
	</div>


	<script type="text/javascript">
		//刷新验证码
		function changeImg() {
			document.getElementById("codeImg").src = "validataImg/captcha.action";
		}
	</script>



</body>
</html>