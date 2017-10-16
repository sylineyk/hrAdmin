/**
 * Created by syline on 2017/6/20.
 */
function getVerifyCode() {

    $('#codeButton').attr('disabled', "true");
    $("#codeButton").addClass("dis");

    var phone = $("#phone").val();
    if (isPhoneNum(phone)) {
        $.ajax({
            type: "GET",
            url: "/broker/sendSms?phone=" + phone,
            cache: false,
            success: function (data) {
                if (data.errorCode == 0) {
                    layer.msg('成功获取验证码，30分钟内有效!', {icon: 1, time: 1000});
                    settime();
                } else if (data.errorCode == 1) {
                    layer.msg('不能在2分钟内多次申请验证码，请在超过2分钟后刷新页面重新申请!', {icon: 5, time: 1000});
                } else {
                    layer.msg('获取验证码错误,请重新点击获取!', {icon: 5, time: 1000});
                    $('#codeButton').attr('disabled', false);
                    $("#codeButton").removeClass("dis");
                    $("#codeButton").text("获取验证码");
                    countdown = 60;
                    return false;
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("错误:" + textStatus + errorThrown);
            }
        });
    } else {
        layer.msg('请输入有效的手机号码!', {icon: 5, time: 1000});
        $('#codeButton').removeAttr("disabled");
        $("#codeButton").removeClass("dis");
    }
}

//倒计时
var countdown = 60;
function settime() {
    if (countdown == 0) {
        $('#codeButton').attr('disabled', false);
        $("#codeButton").removeClass("dis");
        $("#codeButton").text("获取验证码");
        countdown = 60;
        return false;
    } else {
        $("#codeButton").attr("disabled", true);
        $("#codeButton").addClass("dis");
        $("#codeButton").text("重新发送(" + countdown + ")");
        countdown--;
    }
    setTimeout(function () {
        settime();
    }, 1000);
}


function findPwd() {
    var phone = $("#phone").val();
    var code = $("#code").val();
    if (!isPhoneNum(phone)) {
        layer.msg('请输入正确的手机号码!', {icon: 5, time: 1000});
        return;
    }
    if (code == "") {
        layer.msg('请输入验证码!', {icon: 5, time: 1000});
        return;
    }
    var pwd = $("#pwd").val();
    var pwd2 = $("#pwd2").val();
    if (pwd == "") {
        layer.msg('新密码不能为空!', {icon: 5, time: 1000});
        $("#pwd")[0].focus();
        return;
    }


    if (pwd2 == "") {
        layer.msg('再次输入新密码不能为空!', {icon: 5, time: 1000});
        $("#pwd2")[0].focus();
        return;
    }

    if (pwd != pwd2) {
        layer.msg('两次输入密码不一致!', {icon: 5, time: 1000});
        $("#pwd")[0].focus();
        return;
    }


    var pwdMd5 = $.md5(pwd);

    var datas = {"phone": phone, "pwd": pwdMd5, "code": code};
    $.ajax({
        type: "POST",
        url: "/broker/findPwd",
        dataType: "json",
        data: datas,
        cache: false,
        success: function (data) {
            if (data.flag == "success") {
                layer.msg('修改成功!', {icon: 1, time: 1000});
                setTimeout("parent.location.reload();", 1000);
            } else if (data.flag == "errorCode") {
                layer.msg('验证码失效，请重新尝试!', {icon: 5, time: 1000});
            } else if (data.flag == "other") {
                layer.msg('手机号或者验证码不对，请核对后再输入!', {icon: 5, time: 1000});
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
}