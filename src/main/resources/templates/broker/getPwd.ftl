<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>忘记密码</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/jquery.md5.js"></script>
    <script type="text/javascript" src="/assets/js/common/findPwd.js?v=1.0.2"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="login-box">
            <h1>找回密码</h1>

            <div class="form-box">
                <div class="li">
                    <div class="_t">手机号码</div>
                    <div class="_input"><input type="text" id="phone" placeholder="请输入您的手机号码"></div>
                </div>
                <div class="li getcode_li">
                    <div class="_t">短信验证码</div>
                    <div class="_input"><input type="text" placeholder="请输入短信验证码" id="code"></div>
                    <div class="getcode dis" onclick="getVerifyCode()" id="codeButton">获取验证码</div>
                </div>
                <div class="li">
                    <div class="_t">新密码</div>
                    <div class="_input"><input type="password" placeholder="请输入新密码" id="pwd"></div>
                </div>
                <div class="li">
                    <div class="_t">确认新密码</div>
                    <div class="_input"><input type="password" placeholder="请再次输入新密码" id="pwd2"></div>
                </div>
                <div class="form-btn">
                    <a href="#" onclick="findPwd()">提交</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>