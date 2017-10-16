<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>后台登录</title>
    <link href="/assets/css/admin.css?v=1.0.1" rel="stylesheet" type="text/css">
    <link href="/assets/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/h-ui.admin/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/js/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css"/>

    <script type='text/javascript'>
        var _vds = _vds || [];
        window._vds = _vds;
        (function () {
            _vds.push(['setAccountId', 'ae54934bbbdee3bf']);
            (function () {
                var vds = document.createElement('script');
                vds.type = 'text/javascript';
                vds.async = true;
                vds.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'dn-growing.qbox.me/vds.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(vds, s);
            })();
        })();
    </script>
</head>
<body>


<div class="body-content">
    <header class="header-main">
        <div class="left">
            管理后台
        </div>
    </header>
    <div class="content-main">
        <div class="login-box">
            <h1>后台登录</h1>

            <div class="form-box">
                <form name="form" action="/login" method="POST" id="form">
                    <div class="li">
                        <div class="_t">用户名</div>
                        <div class="_input"><input type="text" name="username" id="name" type="text" placeholder="手机号码">
                        </div>
                    </div>
                    <div class="li">
                        <div class="_t">密码</div>
                        <div class="_input"><input type="password" name="password" id="password" type="password"
                                                   placeholder="密码"></div>
                    </div>
                    <div class="li resetpwd">
                        <a href="#" onclick="toGetPwd();return false;">
                            忘记密码
                        </a>
                    </div>
                    <div class="form-btn"
                         style="margin-top: 60px;margin-right: auto;margin-bottom: 0px;margin-left: 180px;">
                        <input name="" type="button" class="btn btn-success radius size-L" onclick="login()"
                               value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                        <input name="" type="reset" class="btn btn-default radius size-L"
                               value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="footer">Copyright 你的公司名称 by H-ui.admin.page.v3.0</div>
<script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/common/jquery.md5.js"></script>
<script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>

<script type="text/javascript">
    $(function () {
    <#if (SPRING_SECURITY_LAST_EXCEPTION.message)??>
        var errMsg = '${SPRING_SECURITY_LAST_EXCEPTION.message}';
        if (errMsg != null && errMsg != "") {
            layer.msg('你的用户名或者密码错误!', {icon: 5, time: 1000});
        }
    </#if>
    });


    function login() {
        var name = $("#name").val();
        if (name == "") {
            layer.msg('用户名不能为空!', {icon: 5, time: 1000});
            $("#name")[0].focus();
        }
        var password = $("#password").val();
        if (password == "") {
            layer.msg('密码不能为空!', {icon: 5, time: 1000});
            $("#password")[0].focus();
        }
        $("#password").val($.md5(password));
        $("#form").submit();
    }

    function toGetPwd() {
        var index = layer.open({
            type: 2,
            title: '忘记密码',
            content: '/broker/view/toGetPwd'
        });
        layer.full(index);
    }
</script>
</body>
</html>