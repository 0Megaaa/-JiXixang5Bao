//表单验证
function checkAdd() {
	var carNum = $("#carNum").val();
	var pack = $("#pack").val();
	var msg = $("#carNumCheck").text();//车牌号未被注册
	console.log(msg);
	var reg = /^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$/;
	if (carNum == "" || pack == 0 || carNum=="" || msg != "车牌号未被注册") {
		alert("请检查输入！");
		return false;
	}else if(!reg.test(carNum)){
		alert("请检查车牌号格式！");
		return false;
	}
	alert("新增成功");
	return true;
}

//退费确认
function refund(){
	if(confirm("确认退费？")){
		return true;
	}
	return false;
}

//删除确认
function deleteConfirm(){
	if(confirm("确认删除？")){
		return true;
	}
	return false;
}


//表单验证
function packageCheck() {
	
	var time = $("#time").val();
	var money = $("#money").val();
	var msg = $("#timeCheck").text();//套餐时长可用 :-)

	var regNum = /^[0-9]{1,2}$/;
	var reg = /^[1-9]\d*$/;		//正整数
	
	if(!regNum.test(time) || !reg.test(time) || time == ""){
		alert("套餐时长输入有误！");
		return false;
	}else if(!reg.test(money) || money == "" || parseInt(money) > 99999){
		alert("请检查价格输入！");
		return false;
	}else if(msg != "套餐时长可用 :-)"){
		alert("请按照提示检查！");
		return false;
	}
	
	
	alert("新增成功");
	return true;
}

function packageCheck2() {
	
	var money = $("#money").val();
	var reg = /^[1-9]\d*$/;		//正整数
	
	if(!reg.test(money) || money == "" || parseInt(money) > 99999){
		alert("请检查价格输入！");
		return false;
	}
	alert("修改成功");
	return true;
}





