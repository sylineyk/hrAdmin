/**
 * Created by syline on 2017/6/21.
 */
$(function () {
    queryInfoInit();


    //$("#checkAll").click(function () {
    //    $("input[name='checkBox']").prop("checked", true);
    //})

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
    var nurseType = $("#nurseType").val();
    var area = $("#area").val();
    var salaryType = $("#salaryType").val();
    //var fromDate = $("#fromDate").val();
    //var endDate = $("#endDate").val();
    var paramStr = $("#paramStr").val();


    var jsonObectArr = [];

    if (paramStr != "") {
        createJsonStr(jsonObectArr, "paramStr", paramStr);
    }
    if (nurseType != "") {
        createJsonStr(jsonObectArr, "nurseType", nurseType);
    }
    if (area != "") {
        createJsonStr(jsonObectArr, "area", area);
    }
    if (salaryType != "") {
        createJsonStr(jsonObectArr, "salaryType", salaryType);
    }
    //if (fromDate != "" && endDate != "") {
    //    createJsonStr(jsonObectArr, "fromDate", fromDate);
    //    createJsonStr(jsonObectArr, "endDate", endDate);
    //}
    createJsonStr(jsonObectArr, "currentPage", 1);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    var defaultOpts = {
        totalPages: 20
    };

    $.ajax({
        type: "GET",
        url: "/broker/view/nurseList/param/api",
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
        url: "/broker/view/nurseList/param/api",
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
    var nurseType = $("#nurseType").val();
    var area = $("#area").val();
    var salaryType = $("#salaryType").val();
    //var fromDate = $("#fromDate").val();
    //var endDate = $("#endDate").val();

    var jsonObectArr = [];


    if (nurseType != "") {
        createJsonStr(jsonObectArr, "nurseType", nurseType);
    }
    if (area != "") {
        createJsonStr(jsonObectArr, "area", area);
    }
    if (salaryType != "") {
        createJsonStr(jsonObectArr, "salaryType", salaryType);
    }
    //if (fromDate != "" && endDate != "") {
    //    createJsonStr(jsonObectArr, "fromDate", fromDate);
    //    createJsonStr(jsonObectArr, "endDate", endDate);
    //}
    createJsonStr(jsonObectArr, "currentPage", currPage);

    var str = "{" + jsonObectArr.join(',') + "}";

    var datas = $.parseJSON(str);

    $.ajax({
        type: "GET",
        url: "/broker/view/nurseList/param/api",
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
    var datas = {"nurseIds": nurseId};
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/broker/op/nurse/param/api',
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
        content: '/broker/view/nurseDetail/' + nurseId
    });
    layer.full(index);
}


function toAddNurse() {
    var index = layer.open({
        type: 2,
        title: '新增阿姨',
        content: '/broker/view/toAddNurse/'
    });
    layer.full(index);
}


function toEdit(nurseId) {
    var index = layer.open({
        type: 2,
        title: '阿姨明细',
        content: '/broker/view/nurseEdit/' + nurseId
    });
    layer.full(index);
}

createJsonStr = function (jsonObectArr, name, value) {
    jsonObectArr.push("\"" + name + "\":" + "\"" + value + "\"");
}


function deleteBatch() {
    var ids = "";
    $("[name='checkBox']:checked").each(function () {
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
    var datas = {"nurseIds": ids};
    layer.confirm('确认要删除吗？', function (index) {
        $.ajax({
            type: 'POST',
            url: '/broker/op/nurse/param/api',
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