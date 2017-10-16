/**
 * Created by killerr1 on 2017/6/20.
 */

var tools = {
    /**
     * URL重定向
     */
    redirect: function (url, time) {
        if (typeof(url) !== 'string' || url == '') url = location.href;
        if (typeof(time) === 'undefined') time = 0;

        setTimeout(function () {
            if (top) {
                top.window.location.href = url;
                return;
            }
            window.location.href = url;
        }, time);
    },
    url_reset: {
        _replace: function (head, url) {
            if (window.history.replaceState) {
                window.history.replaceState(head, '', url);
            }
        },
        _push: function (head, url) {
            if (window.history.pushState) {
                window.history.pushState(head, '', url);
            }
        }
    },
    //返回
    goback: function () {
        history.go(-1)
    },
    /**
     * 判断是否存在array
     */
    inArray: function (needle, array, bool) {
        if (typeof needle == "string" || typeof needle == "number") {
            for (var i in array) {
                if (needle === array[i]) {
                    if (bool) {
                        return i;
                    }
                    return true;
                }
            }
            return false;
        }
    },
    /*
     * 时间戳转格式化日
     * 2014-07-10
     * formatDate('YYYY-mm-dd H:i:s)
     */
    formatDate: function (format, timestamp) {
        if (typeof(timestamp) == 'undefined') {
            var day = new Date();

        } else {
            var day = new Date(parseInt(timestamp));
        }

        var o = {
            "M+": day.getMonth() + 1, //month
            "d+": day.getDate(), //day
            "h+": day.getHours(), //hour
            "m+": day.getMinutes(), //minute
            "s+": day.getSeconds(), //second
            "q+": Math.floor((day.getMonth() + 3) / 3), //quarter
            "S": day.getMilliseconds() //millisecond
        };

        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (day.getFullYear() + "").substr(4 - RegExp.$1.length));
        }

        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    },
    /**
     * 判断josn格式
     */
    isJson: function (json) {
        if (typeof(json) == 'string' && json.match("^{(.+:.+,*){1,}}$")) {
            return true;
        } else {
            return false;
        }
    },
    /**
     * 获取URL参数
     */
    getUrlParam: function (name, url) {
        var h = (url == undefined || url == '') ? decodeURI(window.location.search) : '?' + url.toString().split('?')[1];
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = h.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2])
        }
        return null;
    },
    isEmail: function (email) {
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        return myreg.test(email);
    },
    isMobile: function (str) {
        return (/^(?:13\d|147|15[0-9]|18\d|17\d)-?\d{5}(\d{3}|\*{3})$/.test($.trim(str)));
    },
    isTel: function (str) {
        return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test($.trim(str)));
    },
    htmlspecialchars: function (str) {
        var s = "";
        if (str.length == 0) return "";
        for (var i = 0; i < str.length; i++) {
            switch (str.substr(i, 1)) {
                case "<":
                    s += "&lt;";
                    break;
                case ">":
                    s += "&gt;";
                    break;
                case "&":
                    s += "&amp;";
                    break;
                case " ":
                    if (str.substr(i + 1, 1) == " ") {
                        s += " &nbsp;";
                        i++;
                    } else s += " ";
                    break;
                case "\"":
                    s += "&quot;";
                    break;
                case "\n":
                    s += "<br>";
                    break;
                default:
                    s += str.substr(i, 1);
                    break;
            }
        }
        return s;
    },
    chartohtml: function (str) {
        str = str.replace(/<br\/>/gi, "\n");
        str = str.replace(/<br>/gi, "\n");
        str = str.replace(/&gt;/gi, ">");
        str = str.replace(/&lt;/gi, "<");
        str = str.replace(/&nbsp;/gi, " ");
        str = str.replace(/&quot;/gi, "\"");
        str = str.replace(/''/gi, "'");
        str = str.replace(/&amp/gi, "&");
        return str;
    },
    /**
     * 字符串长??
     * @param str
     * @returns {number}
     */
    strlen: function (str) {
        str = "string" !== typeof str ? "" : str;
        var chinese = str.match(/[^\x00-\x7F]/g),
            l = (chinese && chinese.length) || 0;
        return str.length - l + l * 2;
    },
    base64_encode: function (str) {
        var base64encodechars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        var out, i, len;
        var c1, c2, c3;
        len = str.length;
        i = 0;
        out = "";
        while (i < len) {
            c1 = str.charCodeAt(i++) & 0xff;
            if (i == len) {
                out += base64encodechars.charAt(c1 >> 2);
                out += base64encodechars.charAt((c1 & 0x3) << 4);
                out += "==";
                break;
            }
            c2 = str.charCodeAt(i++);
            if (i == len) {
                out += base64encodechars.charAt(c1 >> 2);
                out += base64encodechars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xf0) >> 4));
                out += base64encodechars.charAt((c2 & 0xf) << 2);
                out += "=";
                break;
            }
            c3 = str.charCodeAt(i++);
            out += base64encodechars.charAt(c1 >> 2);
            out += base64encodechars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xf0) >> 4));
            out += base64encodechars.charAt(((c2 & 0xf) << 2) | ((c3 & 0xc0) >> 6));
            out += base64encodechars.charAt(c3 & 0x3f);
        }
        return out;
    },
    base64_decode: function (str) {
        var c1, c2, c3, c4;
        var base64DecodeChars = new Array(
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57,
            58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6,
            7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
            25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
            37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,
            -1, -1
        );
        var i = 0, len = str.length, string = '';
        while (i < len) {
            do {
                c1 = base64DecodeChars[str.charCodeAt(i++) & 0xff]
            }
            while (i < len && c1 == -1);
            if (c1 == -1) {
                break;
            }

            do {
                c2 = base64DecodeChars[str.charCodeAt(i++) & 0xff];
            } while (i < len && c2 == -1);
            if (c2 == -1) {
                break;
            }
            string += String.fromCharCode((c1 << 2) | ((c2 & 0x30) >> 4));
            do {
                c3 = str.charCodeAt(i++) & 0xff;
                if (c3 == 61) {
                    return string;
                }
                c3 = base64DecodeChars[c3];
            } while (i < len && c3 == -1);

            if (c3 == -1) {
                break;
            }
            string += String.fromCharCode(((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));
            do {
                c4 = str.charCodeAt(i++) & 0xff;
                if (c4 == 61) {
                    return string;
                }
                ;
                c4 = base64DecodeChars[c4];
            } while (i < len && c4 == -1);
            if (c4 == -1) {
                break;
            }
            string += String.fromCharCode(((c3 & 0x03) << 6) | c4);
        }
        return string;
    },
    fmoney: function (s, n) {
        s = s.toString().replace(/,/g, '');
        if (n != null && n != undefined) { //保留几位小数
            s = parseFloat(s);
            s = s.toFixed(n);
            if (s.split('.')[1] == '00') {
                s = s.split('.')[0];
            }
        }
        return s;
    },
    /**
     * 设置cookie
     * @param name
     * @param value
     */
    setCookie: function (name, value) {
        var Days = 1;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
    },
    setAddressCookie: function (name, value) {
        var Days = 1;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + "; path=/1/view";
    },
    getCookie: function (name) {
        var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
        if (arr != null) return unescape(arr[2]);
        return null;
    },
    delCookie: function (name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = this.getCookie(name);
        if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    },
    showMask: function (obj) {
        if ($('#showMask').size() == 0) {
            var _HTML = obj == undefined ? '' : (typeof(obj) == 'string' ? obj : obj[0].outerHTML),
                HTML = '';

            if (_HTML != '') {
                HTML = '<div data-controller="mask" id="showMask" style="width:100%;height:' + ($(document.body)[0].scrollHeight < $(window)[0].innerHeight ? $(window)[0].innerHeight : $(document.body)[0].scrollHeight) + 'px">' + _HTML + '</div>'
            }
            else {
                HTML = '<div data-controller="mask" id="showMask" style="width:100%;height:' + ($(document.body)[0].scrollHeight < $(window)[0].innerHeight ? $(window)[0].innerHeight : $(document.body)[0].scrollHeight) + 'px"></div>'
            }
            $(document.body).append(HTML);
        }
        else {
            if ($('#showMask').hasClass('hide')) {
                $('#showMask').addClass('show');
                $('#showMask').removeClass('hide');
            }
            else {
                $('#showMask').addClass('hide');
                $('#showMask').removeClass('show');
            }
        }
        $('#showMask').bind('touchstart', function (e) {
            e.cancelable = false;
            if (e.preventDefault) {
                e.preventDefault();
            }
            else {
                e.cancelBubble = true;
            }
        })
    },
    /*
     * 当前的提示文字类
     * str      : 文字内容
     * timeline : 显示时间，没有则为1秒
     * */
    showMsg: function (str, timeline) {
        if (timeline == undefined) {
            timeline = 1000;
        }
        if ($('#msg').size() == 0) {
            var HTML = '<div data-controller="showmsg" id="msg" class="flexbox flexbox-align" style="position: fixed; width: 100%; z-index: 9999; transition: opacity .2s,bottom .2s; -webkit-transition: opacity .2s,bottom .2s; opacity: 0; bottom: 0;">'
                + '<div style="background:rgba(0,0,0,.8);border-radius:.1rem">'
                + '<div style="text-align:center;color: #fff; padding: 0 .3rem; min-height: 1.2533333333rem;" id="msghtml" class="msg-info flexbox flexbox-align">' + str + '</div>'
                + '</div>'
                + '</div>';
            $('body').append(HTML);
        }
        else {
            $('#msghtml').html(str);
        }
        setTimeout(function () {
            $('#msg').css({'bottom': '1rem', 'opacity': '1'});
            /*remove*/
            setTimeout(function () {
                $('#msg').css({'bottom': '-1rem', 'opacity': '0'});
                setTimeout(function () {
                    $('#msg').remove();
                }, 200)
            }, timeline)
        }, 300);
    },
    /*
     * 确认框的内容
     * */
    confirm: function (title, text, options, data, callback) {
        $(document.body)[0].scrollTop = 0;
        this.btnhtml = function (options) {
            var rethtml = '';
            for (var i = 0, x = options.length; i < x; i++) {
                if (options[i].flag != null && options[i].flag != undefined) {
                    this.bindfun(options[i].type, data, callback, options[i].flag);
                    rethtml += '<a class="box box-align box-flex1" href="javascript:' + options[i].type + options[i].flag + '()">' + options[i].text + '</a>'
                }
                else {
                    this.bindfun(options[i].type, data, callback);
                    rethtml += '<a class="box box-align box-flex1" href="javascript:' + options[i].type + '()">' + options[i].text + '</a>'
                }
            }
            return rethtml;
        }
        this.bindfun = function (t, data, fun, flag) {
            switch (t) {
                case 'callback':
                    if (flag != null && flag != undefined) {
                        (function (d, f) {
                            window['callback' + flag] = function () {
                                fun(data, flag);
                            }
                        })(data, flag)
                    }
                    else {
                        window['callback'] = function () {
                            fun(data);
                        }
                    }
                    break;
                case 'close':
                    window['close'] = function () {
                        $('#_confirm').remove();
                    }
                    break;
                default:
                    window[t] = function () {
                        $('#_confirm').remove(); //其他全部为关闭
                    }
                    break;
            }
        }
        var HTML = '<div class="confirm" id="_confirm" style="width:100%;height:' + ($(document.body)[0].offsetHeight < $(window)[0].innerHeight ? $(window)[0].innerHeight : $(document.body)[0].offsetHeight) + 'px">' +
            '<div class="box box-align" style="height:' + $(window)[0].innerHeight + 'px">' +
            '<div class="confirm-box">' +
            '<div class="textinfo"><h1>' + title + '</h1>' +
            (text != '' ? ('<p>' + text + '</p>') : '') +
            '</div>' +
            '<div class="box box-align confirm-btn">' +
            this.btnhtml(options) +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>'
        $('body').append(HTML);

        $('#_confirm').bind('click', function (e) {
            e = e.srcElement || e.target;
            if ($(e).hasClass('box box-align')) {
                $(this).remove();
            }
        })
    },
    is_weixn: function () {
        var ua = navigator.userAgent.toLowerCase();
        if (ua.match(/MicroMessenger/i) == "micromessenger") {
            return true;
        }
        else {
            return false;
        }
    },
    empty: function (obj) {
        if (obj == null || obj == '' || obj == undefined || obj.length == 0) {
            return true
        }
        else {
            return false;
        }
    }
}


