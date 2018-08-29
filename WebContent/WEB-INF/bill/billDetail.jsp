<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账单详情</title>
</head>
<body>
<!--startprint1-->
<!--打印内容开始-->
	<table border="1">
		<tr>
			<td>序号</td>
			<td>收费时间</td>
			<td>车牌号</td>
			<td>金额(元)</td>
			<td>收费员</td>
		</tr>
		<c:forEach items="${detail }" var="d" varStatus="s">
			<tr>
				<td>${s.count }</td>
				<td>${d.chargeTime }</td>
				<td>${d.carNum }</td>
				<td>${d.money }</td>
				<td>${d.staffName }</td>
			</tr>
		</c:forEach>
	</table>
	<h3>收费总计:${count }</h3>
<!--打印内容结束-->
<!--endprint1-->		
	<input type=button name='button_export' title='打印1' onclick="preview1(1)" value="打印">
</body>
<script type="text/javascript">

	function preview1(oper){
	    if(oper < 10){
		    bdhtml=window.document.body.innerHTML;//获取当前页的html代码
		    sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
		    eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域
		    prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html
		    prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
		    window.document.body.innerHTML=prnhtml;
		    window.print();
		    window.document.body.innerHTML=bdhtml;
	    }else{
	   		window.print();
	    }
	}
</script>
</html>