/**
 * Created by syline on 2017/6/21.
 */
$(function () {
});


function updateNurseImport() {

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


    var ssjjr = $("#ssjjr").val();
    if (!isPhoneNum(ssjjr)) {
        $("#ssjjr")[0].focus();
        layer.msg('请输入正确的所属经纪人手机号码!', {icon: 5, time: 1000});
        return;
    }

    var datas = $("#form").serialize();

    $.ajax({
        type: "post",
        url: "/broker/op/nurseImport/update/api/",
        cache: false,
        dataType: "json",
        data: datas,
        success: function (data) {
            if (data.flag == 1) {
                layer.msg('提交成功!', {icon: 1, time: 1000});
            } else {
                layer.msg('提交失败!', {icon: 1, time: 1000});
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("错误:" + textStatus + errorThrown);
        }
    });
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