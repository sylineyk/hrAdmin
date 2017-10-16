/**
 * Created by syline on 2017/6/21.
 */
$(function () {
    queryInfoInit();
});


function queryInfo() {
    var status = $("#status").val();

    var jsonObectArr = [];

    if (status != "") {
        createJsonStr(jsonObectArr, "status", status);
    }

    createJsonStr(jsonObectArr, "currentPage", 1);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    var defaultOpts = {
        totalPages: 20
    };

    $.ajax({
        type: "GET",
        url: "/broker/view/shList/param/api",
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

function queryInfoInit() {
    var datas = {"currentPage": 1, "status": "0"};
    $.ajax({
        type: "GET",
        url: "/broker/view/shList/param/api",
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

function queryInfoByPage(currPage) {
    var status = $("#status").val();

    var jsonObectArr = [];


    if (status != "") {
        createJsonStr(jsonObectArr, "status", status);
    }
    createJsonStr(jsonObectArr, "currentPage", currPage);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    $.ajax({
        type: "GET",
        url: "/broker/view/shList/param/api",
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


function toShDetail(nurseId) {
    var status = $("#status").val();
    var index = layer.open({
        type: 2,
        title: '审核详情',
        content: '/broker/view/shDetail/' + nurseId + "/" + status
    });
    layer.full(index);
}


function reload() {
    location.reload();
}
