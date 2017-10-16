/**
 * Created by syline on 2017/6/21.
 */
$(function () {
});


function queryInfo() {
    var paramStr = $("#paramStr").val();
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

    if (paramStr != "") {
        createJsonStr(jsonObectArr, "paramStr", paramStr);
    }
    createJsonStr(jsonObectArr, "currentPage", 1);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);


    $.ajax({
        type: "GET",
        url: "/broker/view/jsInfo/param/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            var str = JSON.stringify(data);
            var html = template('test', data);
            document.getElementById('content').innerHTML = html;

            document.getElementById('page').innerHTML = '<ul id="pagination" class="pagination-sm"></ul>';
            var totalPage = data.total;
            var ze = data.zje;
            var ptsr = data.pdsr;
            var gz = data.aygz;
            var ysje = data.ysje;

            $("#ze").text(ze);
            $("#ptsr").text(ptsr);
            $("#gz").text(gz);
            $("#ysje").text(ysje);

            $("#totalPage").val(totalPage);
            if (totalPage != null && parseInt(totalPage) > 0) {
                $("#pagination").twbsPagination({
                    totalPages: totalPage,
                    visiblePages: 10,
                    onPageClick: function (event, page) {
                        queryInfoByPage(page);
                    }
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
}


function queryInfoByPage(currPage) {

    var paramStr = $("#paramStr").val();
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

    if (paramStr != "") {
        createJsonStr(jsonObectArr, "paramStr", paramStr);
    }
    createJsonStr(jsonObectArr, "currentPage", currPage);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    $.ajax({
        type: "GET",
        url: "/broker/view/jsInfoPage/param/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            var str = JSON.stringify(data);
            var html = template('test', data);
            document.getElementById('content').innerHTML = html;
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
}


createJsonStr = function (jsonObectArr, name, value) {
    jsonObectArr.push("\"" + name + "\":" + "\"" + value + "\"");
}
