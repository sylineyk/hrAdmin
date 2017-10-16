<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>经纪人信息</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content">
            <div class="account-content">
                <div class="_title">
                    <div class="fl">经纪人详细信息</div>
                </div>
                <div class="_content">
                    <div class="r-info pd-t-clear clear">
                        <div class="li_text">
                            <div class="fl _t">头像:</div>
                            <div class="fl _info userlogo">
                                <div class="imgs">
                                    <img src="${info.path!''}" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clear r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">姓名:</div>
                            <div class="fl _info w200">${info.name!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">性别:</div>
                            <div class="fl _info w200">${info.sex!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">年龄:</div>
                            <div class="fl _info w200">${info.age!''}岁</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">学历:</div>
                            <div class="fl _info w200">${info.xl!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">经验:</div>
                            <div class="fl _info w200">${info.jy!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">民族:</div>
                            <div class="fl _info w200">${info.mz!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">手机号:</div>
                            <div class="fl _info w200">${info.phone!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">身份证号:</div>
                            <div class="fl _info w200">${info.idcard!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">银行卡号:</div>
                            <div class="fl _info w200">${info.bankCode!''}</div>
                        </div>
                        <div class="li_text">
                            <div class="fl _t">所在公司:</div>
                            <div class="fl _info w200">${info.companyname!''}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>