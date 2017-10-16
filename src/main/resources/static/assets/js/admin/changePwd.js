function submitEdit() {

    var oldPwd = $("#oldPwd").val();
    var newPwd = $("#newPwd").val();
    var newPwd2 = $("#newPwd2").val();


    var datas = {"pwd": $.md5(oldPwd), "newPwd": $.md5(newPwd)};

    if (oldPwd == "") {
        layer.msg('原始密码不能为空!', {icon: 5, time: 1000});
        $("#oldPwd")[0].focus();
        return;
    }
    if (newPwd == "") {
        layer.msg('新密码不能为空!', {icon: 5, time: 1000});
        $("#newPwd")[0].focus();
        return;
    }

    if (newPwd2 == "") {
        layer.msg('再次输入新密码不能为空!', {icon: 5, time: 1000});
        $("#newPwd2")[0].focus();
        return;
    }

    if (newPwd2 != newPwd) {
        layer.msg('两次输入密码不一致!', {icon: 5, time: 1000});
        $("#newPwd2")[0].focus();
        return;
    }


    $.ajax({
        type: "POST",
        url: "/admin/op/resetPwd/api/",
        dataType: "json",
        data: datas,
        cache: false,
        success: function (data) {
            if (data.flag == "1") {
                layer.msg('密码修改成功!', {icon: 1, time: 1000});
            } else if (data.flag == "0") {
                layer.msg('密码修改错误，请重新尝试!', {icon: 5, time: 1000});
            } else {
                layer.msg('原始密码错误，请重新输入!', {icon: 5, time: 1000});
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });

}