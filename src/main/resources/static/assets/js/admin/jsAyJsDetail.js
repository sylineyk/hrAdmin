/**
 * Created by syline on 2017/6/21.
 */
$(function () {
    queryInfoByPage(1);
});


function queryInfoByPage(currPage) {

    var phone = $("#phone").val();
    var fromDate = $("#fromDate").val();
    var endDate = $("#endDate").val();

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

    if (phone != "") {
        createJsonStr(jsonObectArr, "phone", phone);
    }
    createJsonStr(jsonObectArr, "currentPage", currPage);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    $.ajax({
        type: "GET",
        url: "/admin/view/jsAyJsDetailPage/param/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            var str = JSON.stringify(data);
            var html = template('test', data);
            document.getElementById('content').innerHTML = html;

            var totalPage = data.total;
            $("#totalPage").val(totalPage);
            if (totalPage != null && totalPage > 0) {
                $("#pagination").twbsPagination({
                    totalPages: totalPage,
                    visiblePages: 5,
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


createJsonStr = function (jsonObectArr, name, value) {
    jsonObectArr.push("\"" + name + "\":" + "\"" + value + "\"");
}
