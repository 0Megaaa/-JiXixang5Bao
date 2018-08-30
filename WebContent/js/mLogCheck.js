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
        $(account[0].parentNode).find("div").last().html("^-^");
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
    }else{
        $(password[0].parentNode).removeClass("has-error");
        $(password[0].parentNode).addClass("has-success");
        $(password[0].parentNode).find("div").last().html("^-^");
        return true;
    }
}


function check(){
    return checkAccount() && checkPassword() ;
}

$(document).ready(function(){
    $("input[name='m.mname']").blur(checkAccount);
    $("input[name='m.mpwd']").blur(checkPassword);
});

