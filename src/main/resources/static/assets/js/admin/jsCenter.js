/**
 * Created by syline on 2017/6/21.
 */
$(function () {
});


function queryInfo() {
    var fromDate = $("#datemin").val();
    var endDate = $("#datemax").val();

    if (fromDate == "" || endDate == "") {
        layer.msg('订单日期不能为空!', {icon: 5, time: 1000});
        return;
    }


    var jsonObectArr = [];

    if (fromDate != "" && endDate != "") {
        createJsonStr(jsonObectArr, "fromDate", fromDate);
        createJsonStr(jsonObectArr, "endDate", endDate);
    } else {
        layer.msg('开始结束日期都不能为空!', {icon: 5, time: 1000});
        return;
    }


    var str = "{" + jsonObectArr.join(',') + "}";


    var datas = $.parseJSON(str);


    $.ajax({
        type: "GET",
        url: "/admin/view/jsCenter/param/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            var ptsr = data.pdsr;
            var gz = data.aygz;
            var ysje = data.ysje;

            $("#ptsr").text(ptsr);
            $("#gz").text(gz);
            $("#ysje").text(ysje);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
}


createJsonStr = function (jsonObectArr, name, value) {
    jsonObectArr.push("\"" + name + "\":" + "\"" + value + "\"");
}


function toDetail(type) {
    var fromDate = $("#datemin").val();
    var endDate = $("#datemax").val();

    if (fromDate == "" || endDate == "") {
        layer.msg('订单日期不能为空!', {icon: 5, time: 1000});
        return;
    }


    var jsonObectArr = [];

    if (fromDate != "" && endDate != "") {
        createJsonStr(jsonObectArr, "fromDate", fromDate);
        createJsonStr(jsonObectArr, "endDate", endDate);
    } else {
        layer.msg('开始结束日期都不能为空!', {icon: 5, time: 1000});
        return;
    }

    if (type == "pt") {
        location.href = "/admin/view/toJsPtDetail?fromDate=" + fromDate + "&endDate=" + endDate;
    } else if (type == "jjr") {
        location.href = "/admin/view/toJsJjrDetail?fromDate=" + fromDate + "&endDate=" + endDate;
    } else if (type == "ay") {
        location.href = "/admin/view/toJsAyDetail?fromDate=" + fromDate + "&endDate=" + endDate;
    }
}
