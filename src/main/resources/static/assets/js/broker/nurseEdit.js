/**
 * Created by syline on 2017/6/21.
 */
var uploadCustomFileList = [];
var imgIdList = [];
var json;
var fileName;
var path;


$(function () {
    var uploadCount = 0;
    weui.uploader('#uploaderHeader', {
        url: 'http://chouguanjia.oss-cn-shanghai.aliyuncs.com',
        auto: false,
        type: 'file',
        fileVal: 'file',
        compress: {
            width: 1600,
            height: 1600,
            quality: .8
        },
        onBeforeQueued: function (files) {
            // `this` 是轮询到的文件, `files` 是所有文件

            if (["image/jpg", "image/jpeg", "image/png", "image/gif"].indexOf(this.type) < 0) {
                weui.alert('请上传图片');
                return false; // 阻止文件添加
            }
            if (this.size > 10 * 1024 * 1024) {
                weui.alert('请上传不超过10M的图片');
                return false;
            }
            if (files.length > 2) { // 防止一下子选择过多文件
                weui.alert('最多只能上传1张图片，请重新选择');
                return false;
            }
            if (uploadCount + 1 > 2) {
                weui.alert('最多只能上传1张图片');
                return false;
            }

            ++uploadCount;

            // return true; // 阻止默认行为，不插入预览图的框架
        },
        onQueued: function () {
            var file = this;

            // console.log(this.status); // 文件的状态：'ready', 'progress', 'success', 'fail'
            // console.log(this.base64); // 如果是base64上传，file.base64可以获得文件的base64

            //this.upload(); // 如果是手动上传，这里可以通过调用upload来实现；也可以用它来实现重传。
            // this.stop(); // 中断上传


            // return true; // 阻止默认行为，不显示预览图的图像
            $.ajax({
                type: "get",
                url: "/broker/3/getSignStr",
                cache: false,
                success: function (data) {
                    json = data;
                    fileName = file.name;
                    file.upload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("错误:" + textStatus + errorThrown);
                }
            });


        },
        onBeforeSend: function (data, headers) {
            // $.extend(headers, { Origin: 'http://127.0.0.1' }); // 可以扩展此对象来控制上传头部
            $.extend(data, {
                OSSAccessKeyId: json.accessid,
                policy: json.policy,
                Signature: json.signature,
                key: calculate_object_name(json.dir),
                success_action_status: 201
            }); // 可以扩展此对象来控制上传参数
            // return false; // 阻止文件上传
        },
        onProgress: function (procent) {
            return true; // 阻止默认行为，不使用默认的进度显示
        },
        onSuccess: function (ret) {
            // 返回的上传信息
            if ($(ret).find('PostResponse')) {
                var res = $(ret).find('Location');
                path = res.text();
            }


            $("#headerImg").attr("src", this.url);


            var nurseId = $("#id").val();

            var datas = {"imgPath": path, "nurseId": nurseId};

            $.ajax({
                type: "POST",
                url: "/broker/op/updaetHeaderImg/api",
                cache: false,
                dataType: "json",
                data: datas,
                success: function (data) {
                    if (data.flag == "1") {
                        layer.msg('更换成功!', {icon: 1, time: 1000});
                        //window.parent.location.reload();
                    } else {
                        layer.msg('更换失败!', {icon: 5, time: 1000});
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("错误:" + textStatus + errorThrown);
                }
            });
        },
        onError: function (err) {
            // return true; // 阻止默认行为，不使用默认的失败态
        }
    });
});


function changeImg() {
    $("#uploaderCustomInputHeader").click();
}


//随机字符串
function random_string(len) {
    len = len || 32;
    var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
    var maxPos = chars.length;
    var str = '';
    for (i = 0; i < len; i++) {
        str += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return str;
}
//获取文件名后缀
function get_suffix(filename) {
    var pos = filename.lastIndexOf('.')
    var suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}
//根据文件名类型 临时文件还是原始文件名，返回文件名
function calculate_object_name(oss_key) {
    var suffix = get_suffix(fileName)
    var g_object_name = oss_key + random_string(10) + suffix
    return g_object_name;
}


function selectType() {
    $("#typeDiv").removeClass("hide");


    var ids = $("#serviceTypeIds").val();
    var idArray = ids.split(",");
    for (var i = 0; i < idArray.length; i++) {
        $("#" + idArray[i]).prop('checked', true);
    }
}


function selectCity() {
    $("#cityDiv").removeClass("hide");


    var ids = $("#cityIds").val();
    var idArray = ids.split(",");
    for (var i = 0; i < idArray.length; i++) {
        if (idArray[i] != "") {
            $("#" + (10 + parseInt(idArray[i]))).prop('checked', true);
        }
    }
}


function selectTitle(type) {
    if (type == 'fzd') {
        $("#fzdt").removeClass("active");
        $("#zdt").addClass("active");

        $("#fzd").removeClass("hide");
        $("#zd").addClass("hide");


        var boxs = $("#zd :checkbox");
        for (var i = 0; i < boxs.length; i++) {
            $(boxs[i]).prop('checked', false);
        }

    } else if (type == 'zd') {
        $("#fzdt").addClass("active");
        $("#zdt").removeClass("active");

        $("#fzd").addClass("hide");
        $("#zd").removeClass("hide");

        var boxs = $("#fzd :checkbox");
        for (var i = 0; i < boxs.length; i++) {
            $(boxs[i]).prop('checked', false);
        }
    }
}

function closeDiv() {
    $("#typeDiv").addClass("hide");
}


function closeCityDiv() {
    $("#cityDiv").addClass("hide");
}

function setSelectInfo() {
    $("#typeDiv").addClass("hide");
    var value = "";
    var ids = "";
    if ($("#1").prop('checked')) {
        ids = "1";
        value = "保姆";
    }
    if ($("#2").prop('checked')) {
        ids = ids + "," + 2;
        value = value + " " + "育婴师";
    }
    if ($("#3").prop('checked')) {
        ids = ids + "," + 3;
        value = value + " " + "母婴护理员";
    }
    if ($("#4").prop('checked')) {
        ids = ids + "," + 4;
        value = value + " " + "居家陪护";
    }
    if ($("#5").prop('checked')) {
        ids = ids + "," + 5;
        value = value + " " + "钟点工";
    }
    if ($("#6").prop('checked')) {
        ids = ids + "," + 6;
        value = value + " " + "包月钟点工";
    }
    if (ids.charAt(0) == ',') {
        ids = ids.substring(1, ids.length);
    }

    $("#serviceTypeIds").val(ids);
    $("#serviceTypeValues").val(value);

}

function setCityInfo() {
    var value = "";
    var ids = "";
    if ($("#11").prop('checked')) {
        ids = "1";
        value = "罗湖区";
    }
    if ($("#12").prop('checked')) {
        ids = ids + "," + 2;
        value = value + " " + "福田区";
    }
    if ($("#13").prop('checked')) {
        ids = ids + "," + 3;
        value = value + " " + "南山区";
    }
    if ($("#14").prop('checked')) {
        ids = ids + "," + 4;
        value = value + " " + "宝安区";
    }
    if ($("#15").prop('checked')) {
        ids = ids + "," + 5;
        value = value + " " + "光明新区";
    }
    if ($("#16").prop('checked')) {
        ids = ids + "," + 6;
        value = value + " " + "龙岗区";
    }
    if ($("#17").prop('checked')) {
        ids = ids + "," + 7;
        value = value + " " + "坪山新区";
    }
    if ($("#18").prop('checked')) {
        ids = ids + "," + 8;
        value = value + " " + "盐田区";
    }
    if ($("#19").prop('checked')) {
        ids = ids + "," + 9;
        value = value + " " + "龙华新区";
    }
    if ($("#20").prop('checked')) {
        ids = ids + "," + 10;
        value = value + " " + "大鹏新区";
    }

    if (ids.charAt(0) == ',') {
        ids = ids.substring(1, ids.length);
    }

    $("#cityIds").val(ids);
    $("#cityValues").val(value);

    $("#cityDiv").addClass("hide");
}