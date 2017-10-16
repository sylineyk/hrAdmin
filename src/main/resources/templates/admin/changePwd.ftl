<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>密码修改</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/jquery.md5.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="/assets/js/admin/changePwd.js?v=1.0.2"></script>
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content">
            <div class="account-content">
                <form id="form">
                    <div class="_title">
                        <div class="fl">密码修改</div>
                    </div>
                    <div class="_content">
                        <div class="login-box">
                            <div class="form-box">
                                <div class="li">
                                    <div class="_t">旧密码</div>
                                    <div class="_input">
                                        <input type="password" id="oldPwd" placeholder="请输入原始密码">
                                    </div>
                                </div>
                                <div class="li">
                                    <div class="_t">新密码</div>
                                    <div class="_input">
                                        <input type="password" id="newPwd" placeholder="请输入新密码" name="pwd">
                                    </div>
                                </div>
                                <div class="li">
                                    <div class="_t">确认新密码</div>
                                    <div class="_input">
                                        <input type="password" id="newPwd2" placeholder="请再次输入新密码">
                                    </div>
                                </div>
                                <div class="form-btn">
                                    <a href="#" onclick="submitEdit()">确定</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>