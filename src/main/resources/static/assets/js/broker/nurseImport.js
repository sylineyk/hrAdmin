/**
 * Created by syline on 2017/6/21.
 */
$(function () {
    var msg = $("#msg").val();
    if (msg != "" && msg != null) {
        if (msg.indexOf("出错") > 0) {
            layer.msg(msg, {icon: 5, time: 1000});
        } else {
            layer.msg(msg, {icon: 1, time: 1000});
        }
    }

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


function queryInfo() {
    var flag = $("#flag").val();
    var fromDate = $("#fromDate").val();
    var endDate = $("#endDate").val();

    var jsonObectArr = [];


    if (flag != "") {
        createJsonStr(jsonObectArr, "flag", flag);
    }
    if (fromDate != "" && endDate != "") {
        createJsonStr(jsonObectArr, "fromDate", fromDate);
        createJsonStr(jsonObectArr, "endDate", endDate);
    } else {
        layer.msg('开始结束日期都不能为空!', {icon: 1, time: 1000});
        return;
    }
    createJsonStr(jsonObectArr, "currentPage", 1);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);


    $.ajax({
        type: "GET",
        url: "/broker/view/nurseImportList/param/api",
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
    var datas = {"currentPage": 1, "flag": "0"};
    $.ajax({
        type: "GET",
        url: "/broker/view/nurseImportList/param/api",
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
    var flag = $("#flag").val();
    var fromDate = $("#fromDate").val();
    var endDate = $("#endDate").val();

    var jsonObectArr = [];


    if (flag != "") {
        createJsonStr(jsonObectArr, "flag", flag);
    }
    if (fromDate != "" && endDate != "") {
        createJsonStr(jsonObectArr, "fromDate", fromDate);
        createJsonStr(jsonObectArr, "endDate", endDate);
    }
    createJsonStr(jsonObectArr, "currentPage", 1);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    $.ajax({
        type: "GET",
        url: "/broker/view/nurseImportList/param/api",
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

function toDelete(obj, nurseId) {
    var datas = {"ids": nurseId};
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/broker/op/nurseImport/delete/api',
            cache: false,
            dataType: "json",
            data: datas,
            success: function (data) {
                $(obj).parents("tr").remove();
                layer.msg('已删除!', {icon: 1, time: 1000});
            },
            error: function (data) {
                console.log(data.msg);
            },
        });
    });
}

function toDetail(nurseId) {
    var index = layer.open({
        type: 2,
        title: '阿姨明细',
        content: '/broker/view/importDetail/' + nurseId
    });
    layer.full(index);
}


function toEdit(nurseId) {
    var index = layer.open({
        type: 2,
        title: '阿姨明细',
        content: '/broker/view/importEdit/' + nurseId
    });
    layer.full(index);
}

createJsonStr = function (jsonObectArr, name, value) {
    jsonObectArr.push("\"" + name + "\":" + "\"" + value + "\"");
}


function deleteBatch() {
    var ids = "";
    $("[name='chkAll']:checked").each(function () {
        if (ids == "") {
            ids = $(this).attr("id");
        } else {
            ids += "," + $(this).attr("id");
        }
    });
    if (ids == "") {
        layer.msg('请选择至少一个要删除的阿姨!', {icon: 5, time: 1000});
        return;
    }
    var datas = {"ids": ids};
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/broker/op/nurseImport/param/api',
            cache: false,
            dataType: "json",
            data: datas,
            success: function (data) {
                layer.msg('已删除!', {icon: 1, time: 1000});
                setTimeout("location.reload()", 1000);
            },
            error: function (data) {
                console.log(data.msg);
            },
        });
    });
}

function reload(id, name, age, zodiac, type, serviceArea, salary) {
    location.reload();


    var httml = "<td><input type=\"checkbox\" name=\"chkAll\" id=\"" + id + "\"></td><td>" + name + "</td> <td>" + age + "</td>";
    httml += "<td>" + zodiac + "</td><td>" + type + "</td><td>" + serviceArea + "</td><td>" + salary + "</td>";
    httml += "<td class=\"edit\"><a href=\"#\" onclick=\"toDetail(" + id + ")\">详情</a><a href=\"#\" onclick=\"toEdit(" + id + ")\">编辑</a>";
    httml += "<a href=\"#\" onclick=\"toDelete(this,'" + id + "')\">删除</a></td></tr>";


    document.getElementById(id).innerHTML = httml;

}

function newReload() {
    location.reload();
}


function submitImportInfo() {
    var ids = "";
    $("[name='checkBox']:checked").each(function () {
        if (ids == "") {
            ids = $(this).attr("id");
        } else {
            ids += "," + $(this).attr("id");
        }
    });
    if (ids == "") {
        layer.msg('请选择至少一个要提交的阿姨!', {icon: 5, time: 1000});
        return;
    }

    var datas = {"ids": ids};
    $.ajax({
        type: 'POST',
        url: '/broker/op/nurseImportSubmit/select/api',
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            layer.msg('已提交!', {icon: 1, time: 1000});
            setTimeout("location.reload()", 1000);
        },
        error: function (data) {
            console.log(data.msg);
        },
    });


}


function submitImportInfoAll() {
    $.ajax({
        type: 'POST',
        url: '/broker/op/nurseImportSubmit/all/api',
        cache: false,
        dataType: "json",
        data: "",
        success: function (data) {
            layer.msg('已提交!', {icon: 1, time: 1000});
            setTimeout("location.reload()", 1000);
        },
        error: function (data) {
            console.log(data.msg);
        },
    });
}