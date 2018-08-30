/*
var msg = '${result == null ? "" : result}';
if(msg != ""){
    alert(msg);
}
*/

function checkAccount(){
    var account = $("input[name='m.mname']");
    if(account.val().trim() == ""){
        $(account[0].parentNode).removeClass("has-success");
        $(account[0].parentNode).addClass("has-error");
        $(account[0].parentNode).find("div").last().html("用户名不能为空");
        return false;
    }else{
        $(account[0].parentNode).removeClass("has-error");
        $(account[0].parentNode).addClass("has-success");
        $(account[0].parentNode).find("div").last().html("用户名可用");
        return true;
    }
}

function checkPassword(){
    var password = $("input[name='m.mpwd']");
    if(password.val().trim() == "") {
        $(password[0].parentNode).removeClass("has-success");
        $(password[0].parentNode).addClass("has-error");
        $(password[0].parentNode).find("div").last().html("密码不能为空");
        return false;
    }else if(password.val().trim().length < 6){
        $(password[0].parentNode).removeClass("has-success");
        $(password[0].parentNode).addClass("has-error");
        $(password[0].parentNode).find("div").last().html("密码不能少于6位");
        return false;
    }else if(password.val().trim().length > 16){
        $(password[0].parentNode).removeClass("has-success");
        $(password[0].parentNode).addClass("has-error");
        $(password[0].parentNode).find("div").last().html("密码不能超过16位");
        return false;
    }else{
        $(password[0].parentNode).removeClass("has-error");
        $(password[0].parentNode).addClass("has-success");
        $(password[0].parentNode).find("div").last().html("密码输入正确");
        return true;
    }
}

function checkPassword2(){
    var password = $("input[name='m.mpwd']");
    var password2 = $("input[name='m.mpwd2']");
    if(password2.val().trim() == "") {
        $(password2[0].parentNode).removeClass("has-success");
        $(password2[0].parentNode).addClass("has-error");
        $(password2[0].parentNode).find("div").last().html("请确认密码");
        return false;
    }else if(password.val()!=password2.val()){
        $(password2[0].parentNode).removeClass("has-success");
        $(password2[0].parentNode).addClass("has-error");
        $(password2[0].parentNode).find("div").last().html("两次输入密码不一致");
        return false;
    }else{
        $(password2[0].parentNode).removeClass("has-error");
        $(password2[0].parentNode).addClass("has-success");
        $(password2[0].parentNode).find("div").last().html("密码确认成功");
        return true;
    }
}


function checkPhone(){
    var phone = $("input[name='m.mphone']");
    if(phone.val().trim() == "") {
        $(phone[0].parentNode).removeClass("has-success");
        $(phone[0].parentNode).addClass("has-error");
        $(phone[0].parentNode).find("div").last().html("手机号不能为空");
        return false;
    }else if(!/^[1][3,4,5,7,8][0-9]{9}$/.test(phone.val().trim())){
        $(phone[0].parentNode).removeClass("has-success");
        $(phone[0].parentNode).addClass("has-error");
        $(phone[0].parentNode).find("div").last().html("手机号格式错误");
        return false;
    }else{
        $(phone[0].parentNode).removeClass("has-error");
        $(phone[0].parentNode).addClass("has-success");
        $(phone[0].parentNode).find("div").last().html("输入正确");
        return true;
    }
}

function checkEmail(){
    var email = $("input[name='m.memail']");
    if(email.val().trim() == "") {
        $(email[0].parentNode).removeClass("has-success");
        $(email[0].parentNode).addClass("has-error");
        $(email[0].parentNode).find("div").last().html("邮箱不能为空");
        return false;
    }else if(!/^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/.test(email.val().trim())){
        $(email[0].parentNode).removeClass("has-success");
        $(email[0].parentNode).addClass("has-error");
        $(email[0].parentNode).find("div").last().html("邮箱格式错误");
        return false;
    }else{
        $(email[0].parentNode).removeClass("has-error");
        $(email[0].parentNode).addClass("has-success");
        $(email[0].parentNode).find("div").last().html("输入正确");
        return true;
    }
}

function check(){
	if(checkAccount() && checkPassword() && checkPassword2() && checkPhone() && checkEmail()){
		return true;
	}
	return false;
}

$(document).ready(function(){
    $("input[name='m.mname']").blur(checkAccount);
    $("input[name='m.mpwd']").blur(checkPassword);
    $("input[name='m.mpwd2']").blur(checkPassword2);
    $("input[name='m.mphone']").blur(checkPhone);
    $("input[name='m.memail']").blur(checkEmail);
});

