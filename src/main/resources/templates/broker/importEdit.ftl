<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>导入阿姨编辑</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="/assets/js/broker/importEdit.js?v=1.0.2"></script>
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content">
            <div class="account-content">
                <div class="_title">
                    <div class="fl">导入阿姨详细信息</div>
                </div>
                <div class="_content">
                    <form id="form">
                        <input type="hidden" name="id" value="${result["nurse"].id}">

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">姓名:</div>
                                <div class="fl _info w200">${result["nurse"].name}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">性别:</div>
                                <div class="fl _info w200">
                                <#if result["nurse"].sex=="0">
                                    女
                                <#else>
                                    男
                                </#if>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">手机号:</div>
                                <div class="fl _info w200">
                                    <input type="text" id="phoneNumber" name="phone"
                                           value=" ${result["nurse"].phone!""}">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">身份证号:</div>
                                <div class="fl _info w200">
                                    <input type="text" id="idcard" name="idCard" value=" ${result["nurse"].idCard!""}">
                                </div>
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
                                <div class="fl _t">属相:</div>
                                <div class="fl _info w200">${result["nurse"].zodiac}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">学历:</div>
                                <div class="fl _info w200">${result["nurse"].xl}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">民族:</div>
                                <div class="fl _info w200">${result["nurse"].mz}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">身高:</div>
                                <div class="fl _info w200">${result["nurse"].height}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">体重:</div>
                                <div class="fl _info w200">${result["nurse"].weight}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">健康状况:</div>
                                <div class="fl _info w200">${result["nurse"].jkzk}</div>
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
                                <div class="fl _t">家庭住址:</div>
                                <div class="fl _info w200">${result["nurse"].address}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">婚姻状况:</div>
                                <div class="fl _info w200">
                                <#if result["nurse"].marriage=="0">
                                    未婚
                                <#else>
                                    已婚
                                </#if>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">有无小孩:</div>
                                <div class="fl _info w200">
                                ${result["nurse"].ywxh!''}
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">语言能力:</div>
                                <div class="fl _info w200">${result["nurse"].yy}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">烹调能力:</div>
                                <div class="fl _info w200">${result["nurse"].cookie}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">工作能力:</div>
                                <div class="fl _info w200">${result["nurse"].work}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">使用电器:</div>
                                <div class="fl _info w200">${result["nurse"].sydq}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">所属经纪人:</div>
                                <div class="fl _info w200">
                                    <input type="text" id="ssjjr" name="ssjjr" value=" ${result["nurse"].ssjjr!""}">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">所属公司:</div>
                                <div class="fl _info w200">${result["nurse"].ssgs}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">工资:</div>
                                <div class="fl _info w200">${result["nurse"].salary}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">合同开始日期:</div>
                                <div class="fl _info w200">${result["nurse"].startDate}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">合同结束日期:</div>
                                <div class="fl _info w200">${result["nurse"].endDate}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">开户银行:</div>
                                <div class="fl _info w200">${result["nurse"].khyh}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">银行卡号:</div>
                                <div class="fl _info w200">${result["nurse"].bankCode}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">工种:</div>
                                <div class="fl _info w200">${result["nurse"].type}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">级别:</div>
                                <div class="fl _info w200">${result["nurse"].level}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">经纪人评价:</div>
                                <div class="fl _info w200">${result["nurse"].gspj!''}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">所在地区:</div>
                                <div class="fl _info w200">${result["nurse"].szdq!''}</div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">服务地区:</div>
                                <div class="fl _info w200">${result["nurse"].fwdq!''}</div>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="_tab"> 
                    <ul id="typeid"> 
                        <li class="active" onclick="updateNurseImport()" style="margin-left: 100px;">确定</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>