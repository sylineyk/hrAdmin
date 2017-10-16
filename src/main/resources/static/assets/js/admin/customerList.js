/**
 * Created by syline on 2017/6/21.
 */
$(function () {
    queryInfoInit();

    $("#checkAll").click(function () {
        $("input[name='checkBox']").each(function () {
            if ($(this).prop("checked")) {
                $(this).removeAttr("checked");
            }
            else {
                $(this).prop("checked", "true");
            }
        })
    })
});

function clearTj() {
    $("#paramStr").val("");
}


function queryInfo() {
    var paramStr = $("#paramStr").val();

    var jsonObectArr = [];

    if (paramStr != "") {
        createJsonStr(jsonObectArr, "paramStr", paramStr);
    }
    createJsonStr(jsonObectArr, "currentPage", 1);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);


    $.ajax({
        type: "GET",
        url: "/admin/view/customerList/param/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            var str = JSON.stringify(data);
            var html = template('test', data);
            document.getElementById('content').innerHTML = html;

            document.getElementById('page').innerHTML = '<ul id="pagination" class="pagination-sm"></ul>';
            var totalPage = data.total;
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

function queryInfoInit() {
    var datas = {"currentPage": 1};
    $.ajax({
        type: "GET",
        url: "/admin/view/customerList/param/api",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            var str = JSON.stringify(data);
            var html = template('test', data);
            document.getElementById('content').innerHTML = html;

            var totalPage = data.total;
            $("#totalPage").val(totalPage);
            if (totalPage != null) {
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

    var jsonObectArr = [];

    if (paramStr != "") {
        createJsonStr(jsonObectArr, "paramStr", paramStr);
    }


    createJsonStr(jsonObectArr, "currentPage", currPage);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    $.ajax({
        type: "GET",
        url: "/admin/view/customerList/param/api",
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
