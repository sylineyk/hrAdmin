<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>新增编辑</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content">
            <div class="account-content">
                <div class="_title">
                    <div class="fl">阿姨详细信息</div>
                </div>
                <div class="_content">
                    <div class="r-info pd-t-clear clear">
                        <div class="li_text">
                            <div class="fl _t">头像:</div>
                            <div class="fl _info userlogo">
                                <div class="imgs">
                                    <img src="${result["nurse"].imgPath}" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">姓名:</div>
                            <div class="fl _info w200">${result["nurse"].name}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">年龄:</div>
                            <div class="fl _info w200">${result["nurse"].age}岁</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">工作经验:</div>
                            <div class="fl _info w200">${result["nurse"].experience}年</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">属相:</div>
                            <div class="fl _info w200">${result["nurse"].zodiac}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">手机号:</div>
                            <div class="fl _info w200">${result["nurse"].phoneNumber}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">所在地区:</div>
                            <div class="fl _info w200">${result["nurse"].locationArea!""}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">服务地区:</div>
                            <div class="fl _info w200">${result["nurse"].serviceAreaNames}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">工号:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].card!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">服务类型:</div>
                            <div class="fl _info w200">${result["nurse"].typeNames!""}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">身份证号:</div>
                            <div class="fl _info w200">${result["nurse"].idcard}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">家乡:</div>
                            <div class="fl _info w200">${result["nurse"].birth!""}</div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">参考工资:</div>
                            <div class="fl _info w200">${result["nurse"].salary}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="account-content">
                <div class="_title">
                    <div class="fl">身份证明</div>
                </div>
                <div class="_content">
                <#list result["card"] as card>
                    <div class="imgupload-box imgs" id="${card["id"]}">
                        <img
                                src="${card["path"]}"
                                alt="">
                    </div>
                </#list>
                </div>
            </div>
            <div class="account-content">
                <div class="_title">
                    <div class="fl">资质证书</div>
                </div>
                <div class="_content">
                <#list result["ryzs"] as ryzs>
                    <div class="imgupload-box">
                        <img
                                src="${ryzs["path"]}"
                                alt="">
                    </div>
                </#list>
                </div>
            </div>
            <div class="account-content">
                <div class="_title">
                    <div class="fl">生活照片</div>
                </div>
                <div class="_content">
                <#list result["live"] as live>
                    <div class="imgupload-box">
                        <img
                                src="${live["path"]}"
                                alt="">
                    </div>
                </#list>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>