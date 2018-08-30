<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>

<body>

	<!--      <h5>文件操作</h5>
     <form action="fileact.action" method="post" enctype="multipart/form-data" style="margin-left:400px;margin-top:300px">
     	请选择文件:<input type="file" name="fileact">
     	<input type="submit" value="提交">
     </form> -->





	<!-- <div class="Infor_file">
	<input type="file" name="outImgSrc" id="file" value=""   onchange="getPhoto(this)"/>
		<input type="submit" value="上传照片">
</div> -->


<!-- 	<div class="ge_pic_icon_Infor">
		<img src="images/moren.jpg"/>

		<img id="pitctue" src="#" />
	</div> -->


	<form action="fileact.action" method="post"
		enctype="multipart/form-data">
		请选择文件:<input type="file" name="fileact"> <input type="submit"
			value="提交">
	</form>

<!-- 	<div>
		<input type="text" name="carNum" id="carNum" />
		<button id="getPitctue" onclick="getPicture()">提交</button>
	</div> -->



	<%-- 
     <h1>${car.carNum}</h1>
     <h1>${car.startTime}</h1>
     <h1>${car.userTypeName}</h1> --%>
</body>



<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	var imgurl = "";
	function getPhoto(node) {
		var imgURL = "";
		try {
			var file = null;
			if (node.files && node.files[0]) {
				file = node.files[0];
			} else if (node.files && node.files.item(0)) {
				file = node.files.item(0);
			}
			//Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
			try {
				imgURL = file.getAsDataURL();
			} catch (e) {
				imgRUL = window.URL.createObjectURL(file);
			}
		} catch (e) {
			if (node.files && node.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					imgURL = e.target.result;
				};
				reader.readAsDataURL(node.files[0]);
			}
		}
		creatImg(imgRUL);
		return imgURL;
	}

	function creatImg(imgRUL) {
		var textHtml = "<img src='"+imgRUL+"'width='400px' height='300px'/>";
		$(".ge_pic_icon_Infor").html(textHtml);
	}
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script type="text/javascript">
	//$(function(){ 
	function getPicture() {
		var carNum = $("#carNum").val(); // 获取id为username的<input>框数据
		// 判断
		/*   if (carNum.length == 0) {
		      $("#username").tips({msg: "请输入车牌号"});
		      return;
		  } */

		// Ajax提交数据
		$.ajax({

			url : "getPicture.action", // 提交到controller的url路径
			type : "post", // 提交方式
			data : {
				"carNum" : carNum
			}, // data为String类型，必须为 Key/Value 格式。
			dataType : "json", // 服务器端返回的数据类型
			success : function(date) { // 请求成功后的回调函数，其中的参数data为controller返回的map,也就是说,@ResponseBody将返回的map转化为JSON格式的数据，然后通过data这个参数取JSON数据中的值

				if (date.message == "success") {
					$("#pitctue").html(
							"<img  src="+date.TbCar.parkImgSrc + "/>");
				}
			}
		});
	}
	//});
</script>



</html>
