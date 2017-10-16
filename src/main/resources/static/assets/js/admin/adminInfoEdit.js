/**
 * Created by syline on 2017/6/21.
 */
function cancel() {
    location.href = "/admin/view/toAdminInfo";
}

function saveInfo() {
    var datas = $("#form").serialize();
    $.ajax({
        type: "post",
        url: "/admin/op/updateAdminInfo/api",
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