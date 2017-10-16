/**
 * Created by syline on 2017/6/21.
 */
$(function () {
});

function passPic() {

    //var ids = "";
    //$("[name='chk
    // All']:checked").each(function () {
    //    if (ids == "") {
    //        ids = $(this).attr("id");
    //    } else {
    //        ids += "," + $(this).attr("id");
    //    }
    //});
    //if (ids == "") {
    //    layer.msg('请选择至少一个要删除的阿姨!', {icon: 5, time: 1000});
    //    return;
    //}
    var ids = $("#nurseId").val();
    var datas = {"ids": ids};
    $.ajax({
        type: 'POST',
        url: '/broker/op/shPic/pass/api',
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            layer.msg('已通过!', {icon: 1, time: 1000});
            setTimeout("parent.reload()", 1000);
        },
        error: function (data) {
            console.log(data.msg);
        },
    });
}

function rejectPic() {
    //var ids = "";
    //$("[name='chkAll']:checked").each(function () {
    //    if (ids == "") {
    //        ids = $(this).attr("id");
    //    } else {
    //        ids += "," + $(this).attr("id");
    //    }
    //});
    //if (ids == "") {
    //    layer.msg('请选择至少一个要删除的阿姨!', {icon: 5, time: 1000});
    //    return;
    //}
    var ids = $("#nurseId").val();
    var datas = {"ids": ids};
    layer.confirm('确认要驳回吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/broker/op/shPic/reject/api',
            cache: false,
            dataType: "json",
            data: datas,
            success: function (data) {
                layer.msg('已驳回!', {icon: 1, time: 1000});
                setTimeout("parent.location.reload()", 1000);
            },
            error: function (data) {
                console.log(data.msg);
            },
        });
    });
}


