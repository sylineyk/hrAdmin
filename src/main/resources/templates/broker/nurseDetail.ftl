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
                                    <img src="${result["nurse"].imgPath!""}" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">姓名:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].name!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">性别:</div>
                            <div class="fl _info w200">
                            <#if result["nurse"].sex??>
                                <#if result["nurse"].sex=='1'>
                                    男
                                </#if>
                                <#if result["nurse"].sex=='0'>
                                    女
                                </#if>
                            </#if>
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">手机号:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].phoneNumber!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">身份证号:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].idcard!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">年龄:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].age!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">属相:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].zodiac!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">学历:</div>
                            <div class="fl _info w200">
                            <#if result["nurse"].xl??>
                                <#if result["nurse"].xl='1'>
                                    小学
                                </#if>
                                <#if result["nurse"].xl='2'>
                                    初中
                                </#if>
                                <#if result["nurse"].xl='3'>
                                    高中
                                </#if>
                                <#if result["nurse"].xl='4'>
                                    大专
                                </#if>
                                <#if result["nurse"].xl='5'>
                                    本科
                                </#if>
                                <#if result["nurse"].xl='6'>
                                    硕士
                                </#if>
                            </#if>
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">民族:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].mz!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">身高:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].high!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">体重:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].weight!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">健康状况:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].health!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">工作经验:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].experience!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">家乡:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].birth!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">婚姻状况:</div>
                            <div class="fl _info w200">
                            <#if result["nurse"].hy??>
                                <#if result["nurse"].hy=='1'>
                                    已婚
                                </#if>
                                <#if result["nurse"].hy=='0'>
                                    未婚
                                </#if>
                            </#if>
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">有无小孩:</div>
                            <div class="fl _info w200">
                            <#if result["nurse"].ywxh??>
                                <#if result["nurse"].ywxh=='1'>
                                    有
                                </#if>
                                <#if result["nurse"].ywxh=='0'>
                                    无
                                </#if>
                            </#if>
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">语言能力:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].yy!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">烹饪能力:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].pr!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">工作能力:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].gz!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">使用电器:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].sydq!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">参考工资:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].salary!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">合同开始日期:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].htStartDateStr!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">合同结束日期:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].htEndDateStr!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">开户银行:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].khyh!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">银行卡账户:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].bankCode!""}
                            </div>
                        </div>
                    </div>

                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">所在地区:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].locationArea!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">服务地区:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].serviceAreaNames!""}
                            </div>
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
                            <div class="fl _info w200">
                            ${result["nurse"].typeNames!""}

                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">级别:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].level!""}
                            </div>
                        </div>
                    </div>
                    <div class="fl r-info pd-t-clear">
                        <div class="li_text">
                            <div class="fl _t">经纪人评价:</div>
                            <div class="fl _info w200">
                            ${result["nurse"].gspj!""}
                            </div>
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