/**
 * Created by syline on 2017/6/21.
 */
var uploadCustomFileList = [];
var imgIdList = [];

var uploadCustomCardFileList = [];
var imgCardIdList = [];

var uploadCustomLiveFileList = [];
var imgLiveIdList = [];


var headerId;

var json;
var fileName;
var path;
$(function () {
    document.querySelector('#uploaderCustomFiles').addEventListener('click', function (e) {
        var target = e.target;

        while (!target.classList.contains('weui-uploader__file') && target) {
            target = target.parentNode;
        }
        if (!target) return;

        var url = target.getAttribute('style') || '';
        var id = target.getAttribute('data-id');

        if (url) {
            url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
        }
        var gallery = weui.gallery(url, {
            onDelete: function onDelete() {
                weui.confirm('确定删除该图片', function () {
                    var index;
                    for (var i = 0, len = uploadCustomFileList.length; i < len; ++i) {
                        var file = uploadCustomFileList[i];
                        if (file.id == id) {
                            index = i;
                            break;
                        }
                    }
                    if (index) uploadCustomFileList.splice(index, 1);

                    target.remove();
                    gallery.hide();
                });
            }
        });
    });

    document.querySelector('#uploaderCustomFilesCard').addEventListener('click', function (e) {
        var target = e.target;

        while (!target.classList.contains('weui-uploader__file') && target) {
            target = target.parentNode;
        }
        if (!target) return;

        var url = target.getAttribute('style') || '';
        var id = target.getAttribute('data-id');

        if (url) {
            url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
        }
        var gallery = weui.gallery(url, {
            onDelete: function onDelete() {
                weui.confirm('确定删除该图片', function () {
                    var index;
                    for (var i = 0, len = uploadCustomCardFileList.length; i < len; ++i) {
                        var file = uploadCustomCardFileList[i];
                        if (file.id == id) {
                            index = i;
                            break;
                        }
                    }
                    if (index) uploadCustomCardFileList.splice(index, 1);

                    target.remove();
                    gallery.hide();
                });
            }
        });
    });

    document.querySelector('#uploaderCustomFilesLive').addEventListener('click', function (e) {
        var target = e.target;

        while (!target.classList.contains('weui-uploader__file') && target) {
            target = target.parentNode;
        }
        if (!target) return;

        var url = target.getAttribute('style') || '';
        var id = target.getAttribute('data-id');

        if (url) {
            url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
        }
        var gallery = weui.gallery(url, {
            onDelete: function onDelete() {
                weui.confirm('确定删除该图片', function () {
                    var index;
                    for (var i = 0, len = uploadCustomLiveFileList.length; i < len; ++i) {
                        var file = uploadCustomLiveFileList[i];
                        if (file.id == id) {
                            index = i;
                            break;
                        }
                    }
                    if (index) uploadCustomLiveFileList.splice(index, 1);

                    target.remove();
                    gallery.hide();
                });
            }
        });
    });


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
            $("#pathHeader").val(path);
            //var nurseId = $("#id").val();
            //
            //var datas = {"imgPath": path, "nurseId": nurseId};
            //
            //$.ajax({
            //    type: "POST",
            //    url: "/broker/op/updaetHeaderImg/api",
            //    cache: false,
            //    dataType: "json",
            //    data: datas,
            //    success: function (data) {
            //        if (data.flag == "1") {
            //            layer.msg('更换成功!', {icon: 1, time: 1000});
            //            //window.parent.location.reload();
            //        } else {
            //            layer.msg('更换失败!', {icon: 5, time: 1000});
            //        }
            //    },
            //    error: function (jqXHR, textStatus, errorThrown) {
            //        alert("错误:" + textStatus + errorThrown);
            //    }
            //});
        },
        onError: function (err) {
            // return true; // 阻止默认行为，不使用默认的失败态
        }
    });


    var uploadCount = 0;
    weui.uploader('#uploader', {
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
            if (files.length > 5) { // 防止一下子选择过多文件
                weui.alert('最多只能上传5张图片，请重新选择');
                return false;
            }
            if (uploadCount + 1 > 5) {
                weui.alert('最多只能上传5张图片');
                return false;
            }

            ++uploadCount;

            // return true; // 阻止默认行为，不插入预览图的框架
        },
        onQueued: function () {

            // console.log(this.status); // 文件的状态：'ready', 'progress', 'success', 'fail'
            // console.log(this.base64); // 如果是base64上传，file.base64可以获得文件的base64

            // this.upload(); // 如果是手动上传，这里可以通过调用upload来实现；也可以用它来实现重传。
            // this.stop(); // 中断上传

            // return true; // 阻止默认行为，不显示预览图的图像
            //uploadCustomFileList.push(this);
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
            // $.extend(data, { test: 1 }); // 可以扩展此对象来控制上传参数
            // $.extend(headers, { Origin: 'http://127.0.0.1' }); // 可以扩展此对象来控制上传头部

            // return false; // 阻止文件上传
            $.extend(data, {
                OSSAccessKeyId: json.accessid,
                policy: json.policy,
                Signature: json.signature,
                key: calculate_object_name(json.dir),
                success_action_status: 201
            }); // 可以扩展此对象来控制上传参数
        },
        onProgress: function (procent) {
            return true; // 阻止默认行为，不使用默认的进度显示
        },
        onSuccess: function (ret) {
            // 返回的上传信息
            if ($(ret).find('PostResponse')) {
                layer.msg('照片上传成功!', {icon: 1, time: 1000});
                var res = $(ret).find('Location');
                path = res.text();
                imgIdList.push(path);
            }
            // return true; // 阻止默认行为，不使用默认的成功态
        },
        onError: function (err) {
            // return true; // 阻止默认行为，不使用默认的失败态
        }
    });


    var uploadCountCard = 0;
    weui.uploader('#uploaderCard', {
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
            if (files.length > 5) { // 防止一下子选择过多文件
                weui.alert('最多只能上传5张图片，请重新选择');
                return false;
            }
            if (uploadCountCard + 1 > 5) {
                weui.alert('最多只能上传5张图片');
                return false;
            }

            ++uploadCountCard;

            // return true; // 阻止默认行为，不插入预览图的框架
        },
        onQueued: function () {

            // console.log(this.status); // 文件的状态：'ready', 'progress', 'success', 'fail'
            // console.log(this.base64); // 如果是base64上传，file.base64可以获得文件的base64

            // this.upload(); // 如果是手动上传，这里可以通过调用upload来实现；也可以用它来实现重传。
            // this.stop(); // 中断上传

            // return true; // 阻止默认行为，不显示预览图的图像
            //uploadCustomCardFileList.push(this);
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
            // $.extend(data, { test: 1 }); // 可以扩展此对象来控制上传参数
            // $.extend(headers, { Origin: 'http://127.0.0.1' }); // 可以扩展此对象来控制上传头部

            // return false; // 阻止文件上传

            $.extend(data, {
                OSSAccessKeyId: json.accessid,
                policy: json.policy,
                Signature: json.signature,
                key: calculate_object_name(json.dir),
                success_action_status: 201
            }); // 可以扩展此对象来控制上传参数
        },
        onProgress: function (procent) {
            return true; // 阻止默认行为，不使用默认的进度显示
        },
        onSuccess: function (ret) {
            // 返回的上传信息
            if ($(ret).find('PostResponse')) {
                layer.msg('照片上传成功!', {icon: 1, time: 1000});
                var res = $(ret).find('Location');
                path = res.text();
                imgCardIdList.push(path);
            }

            // return true; // 阻止默认行为，不使用默认的成功态
        },
        onError: function (err) {
            // return true; // 阻止默认行为，不使用默认的失败态
        }
    });


    var uploadCountLive = 0;
    weui.uploader('#uploaderLive', {
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
            if (files.length > 5) { // 防止一下子选择过多文件
                weui.alert('最多只能上传5张图片，请重新选择');
                return false;
            }
            if (uploadCountLive + 1 > 5) {
                weui.alert('最多只能上传5张图片');
                return false;
            }

            ++uploadCountLive;

            // return true; // 阻止默认行为，不插入预览图的框架
        },
        onQueued: function () {

            // console.log(this.status); // 文件的状态：'ready', 'progress', 'success', 'fail'
            // console.log(this.base64); // 如果是base64上传，file.base64可以获得文件的base64

            // this.upload(); // 如果是手动上传，这里可以通过调用upload来实现；也可以用它来实现重传。
            // this.stop(); // 中断上传

            // return true; // 阻止默认行为，不显示预览图的图像
            //uploadCustomLiveFileList.push(this);

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
            // $.extend(data, { test: 1 }); // 可以扩展此对象来控制上传参数
            // $.extend(headers, { Origin: 'http://127.0.0.1' }); // 可以扩展此对象来控制上传头部

            // return false; // 阻止文件上传
            $.extend(data, {
                OSSAccessKeyId: json.accessid,
                policy: json.policy,
                Signature: json.signature,
                key: calculate_object_name(json.dir),
                success_action_status: 201
            }); // 可以扩展此对象来控制上传参数
        },
        onProgress: function (procent) {
            return true; // 阻止默认行为，不使用默认的进度显示
        },
        onSuccess: function (ret) {
            // 返回的上传信息
            if ($(ret).find('PostResponse')) {
                layer.msg('照片上传成功!', {icon: 1, time: 1000});
                var res = $(ret).find('Location');
                path = res.text();
                imgLiveIdList.push(path);
            }

            // return true; // 阻止默认行为，不使用默认的成功态
        },
        onError: function (err) {
            // return true; // 阻止默认行为，不使用默认的失败态
        }
    });
});

function addNewNurse() {
    var name = $("#name").val();
    if (name = "") {
        $("#name")[0].focus();
        layer.msg('姓名不能为空!', {icon: 5, time: 1000});
        return;
    }
    var idCard = $("#idcard").val();
    if (idCard == "" || idCard == null) {
        $("#idcard")[0].focus();
        layer.msg('身份证号码不能为空!', {icon: 5, time: 1000});
        return;
    } else {
        if (!IdentityCodeValid(idCard)) {
            $("#idcard")[0].focus();
            layer.msg('请输入正确的身份证号码!', {icon: 5, time: 1000});
            return;
        }
    }
    var phoneNumber = $("#phoneNumber").val();
    if (!isPhoneNum(phoneNumber)) {
        $("#phoneNumber")[0].focus();
        layer.msg('请输入正确的手机号码!', {icon: 5, time: 1000});
        return;
    }
    var experience = $("#experience").val();
    if (experience == "" || experience == null) {
        $("#experience")[0].focus();
        layer.msg('经验不能为空!', {icon: 5, time: 1000});
        return;
    } else {
        if (!/^[0-9]*$/.test(experience)) {
            $("#experience")[0].focus();
            layer.msg('经验只能为数字!', {icon: 5, time: 1000});
            return;
        }
    }
    var birth = $("#birth").val();
    if (birth == "" || birth == null) {
        $("#birth")[0].focus();
        layer.msg('家乡不能为空!', {icon: 5, time: 1000});
        return;
    }
    var serviceTypeValues = $("#serviceTypeValues").val();
    if (serviceTypeValues == "" || serviceTypeValues == null) {
        layer.msg('服务类型不能为空!', {icon: 5, time: 1000});
        $("#serviceTypeValues")[0].focus();
        return;
    }
    var card = $("#card").val();
    if (card == "" || card == null) {
        layer.msg('工号不能为空!', {icon: 5, time: 1000});
        $("#card")[0].focus();
        return;
    }
    var locationArea = $("#locationArea").val();
    if (locationArea == "" || locationArea == null) {
        layer.msg('所在地区不能为空!', {icon: 5, time: 1000});
        $("#locationArea")[0].focus();
        return;
    }
    var cityValues = $("#cityValues").val();
    if (cityValues == "" || cityValues == null) {
        layer.msg('服务地区不能为空!', {icon: 5, time: 1000});
        $("#cityValues")[0].focus();
        return;
    }
    var salary = $("#salary").val();
    if (salary == "" || salary == null) {
        layer.msg('参考工资不能为空!', {icon: 5, time: 1000});
        $("#salary")[0].focus();
        return;
    } else {
        if (!/^[0-9]*$/.test(salary)) {
            layer.msg('参考工资只能为数字!', {icon: 5, time: 1000});
            $("#salary")[0].focus();
            return;
        }
    }


    var fileRy = "";
    for (var i = 0, len = imgIdList.length; i < len; ++i) {
        fileRy += "," + imgIdList[i];
    }
    var fileCard = "";
    for (var i = 0, len = imgCardIdList.length; i < len; ++i) {
        fileCard += "," + imgCardIdList[i];
    }
    var fileLive = "";
    for (var i = 0, len = imgLiveIdList.length; i < len; ++i) {
        fileLive += "," + imgLiveIdList[i];
    }


    $("#pathRy").val(fileRy);
    $("#pathCard").val(fileCard);
    $("#pathLive").val(fileLive);


    var datas = $("#form").serialize();


    $.ajax({
        type: "GET",
        url: "/broker/op/isNurseExists/api/" + phoneNumber + "/" + idCard,
        cache: false,
        success: function (data) {
            if (data.idFlag == 0) {
                layer.msg('该身份证号已经存在，无法再次新增!', {icon: 5, time: 1000});
                $("#idcard")[0].focus();
            }
            if (data.phoneFlag == 0) {
                layer.msg('该手机号已经存在，无法再次新增!', {icon: 5, time: 1000});
                $("#phoneNumber")[0].focus();
            }
            if (data.idFlag == 1 && data.phoneFlag == 1) {
                $.ajax({
                    type: "post",
                    url: "/broker/op/nurse/addNew/api/",
                    cache: false,
                    dataType: "json",
                    data: datas,
                    success: function (data) {
                        if (data.flag == 1) {
                            layer.msg('提交成功!', {icon: 1, time: 1000});
                            setTimeout("parent.newReload()", 1000);
                        } else {
                            layer.msg('提交失败!', {icon: 2, time: 1000});
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert("错误:" + textStatus + errorThrown);
                    }
                });
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
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


(function (window) {

    /**
     * 生肖构造函数，默认参数是当前日期
     * @param {Number} year 年
     * @param {Number} month 月
     * @param {Number} day 日
     */
    function Zodiac(codeid) {
        var year = codeid.substring(6, 10);
        var month = codeid.substring(10, 12);
        var day = codeid.substring(12, 14);
        var date = new Date();
        this.year = year * 1 || date.getFullYear();
        this.month = month * 1 || date.getMonth();
        this.day = day * 1 || date.getDate();
    }

    Zodiac.constructor = Zodiac;

    /**
     * 获取C值
     * @return {Number} C
     */
    Zodiac.prototype.getC = function () {
        var _year = Math.floor(this.year / 100) + 1;
        var C;

        switch (_year) {
            case 20:
                C = 4.6295;
                break;
            case 21:
                C = 3.87;
                break;
            case 22:
                C = 4.15;
                break;
            default:
                C = 3.87;
        }
        return C;
    }

    /**
     * 获取立春日 一般都在2月
     * @return {Number} springDay
     */
    Zodiac.prototype.getSpringDay = function () {
        var Y = this.year % 100,
            D = 0.2422,
            C = this.getC(),
            L = (Y - 1) / 4,
            springDay = 0;
        springDay = Math.floor(Y * D + C) - Math.floor((Y - 1) / 4);
        return springDay;
    }

    /**
     * 获取生肖
     * @return {String} myZodiac
     */
    Zodiac.prototype.getZodiac = function () {
        var year = this.year,
            month = this.month,
            day = this.day,
            zodiac = ['子鼠', '丑牛', '寅虎', '卯兔', '辰龙', '巳蛇', '午马', '未羊', '申猴', '酉鸡', '戌狗', '亥猪'],
            myPos = (year - 1900) % 12,
            myZodiac = zodiac[myPos],
            springDay = this.getSpringDay();

        switch (month) {
            case 1:
                var _myPos = myPos - 1;
                if (_myPos < 0) {
                    _myPos = 11;
                }
                myZodiac = zodiac[_myPos];
                break;
            case 2:
                if (day < springDay) {
                    var _myPos = myPos - 1;
                    if (_myPos < 0) {
                        _myPos = 11;
                    }
                    myZodiac = zodiac[_myPos];
                }
                break;
        }
        return myZodiac;
    }

    /**
     * 获取年龄
     * @return {String} myYear
     */
    Zodiac.prototype.myY = function () {
        var myYear = '';
        var dateyear = new Date().getFullYear();
        myYear = dateyear - this.year;
        return myYear;
    }

    window.Zodiac = Zodiac;
})(window);


function setInfo() {
    var idCard = $("#idcard").val();
    if (idCard.length == 15) {
        idCard = changeFivteenToEighteen(idCard);
    }
    if (IdentityCodeValid(idCard)) {
        //当前身份证参数
        var zodiac = new Zodiac(idCard);
        $("#zodiac").val(zodiac.getZodiac());
        $("#age").val(zodiac.myY());
    } else {
        layer.msg('请输入正确的身份证号码!', {icon: 5, time: 1000});
    }
}


function IdentityCodeValid(code) {
    var city = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江 ",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北 ",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏 ",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外 "
    };
    var tip = "";
    var pass = true;

    if (!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)) {
        tip = "身份证号格式错误";
        pass = false;
    }

    else if (!city[code.substr(0, 2)]) {
        tip = "地址编码错误";
        pass = false;
    }
    else {
        //18位身份证需要验证最后一位校验位
        if (code.length == 18) {
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
            //校验位
            var parity = [1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++) {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            var last = parity[sum % 11];
            if (parity[sum % 11] != code[17]) {
                tip = "校验位错误";
                pass = false;
            }
        }
    }
    return pass;
}


//15位转18位身份证号
function changeFivteenToEighteen(card) {
    if (card.length == '15') {
        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
        var cardTemp = 0, i;
        card = card.substr(0, 6) + '19' + card.substr(6, card.length - 6);
        for (i = 0; i < 17; i++) {
            cardTemp += card.substr(i, 1) * arrInt[i];
        }
        card += arrCh[cardTemp % 11];
        return card;
    }
    return card;
}


function changeImg() {
    $("#uploaderCustomInputHeader").click();
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