function toEditBroker() {
    location.href = "/broker/view/toBrokerEdit";
}


function cancel() {
    location.href = "/broker/view/toBrokerInfo";
}

function saveInfo() {
    var datas = $("#form").serialize();
    $.ajax({
        type: "post",
        url: "/broker/op/updateBrokerInfo/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            if (data.flag == "1") {
                layer.msg('修改成功!', {icon: 1, time: 1000});
                setTimeout("cancel()", 1000);
            } else {
                layer.msg('修改失败!', {icon: 5, time: 1000});
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
}


function toChangePwd() {
    var index = layer.open({
        type: 2,
        title: '密码修改',
        content: '/broker/view/changePwd'
    });
    layer.full(index);
}