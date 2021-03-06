<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>经纪人信息</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.min.css">
    <script type="text/javascript" src="/assets/js/common/weui.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="/assets/js/admin/brokerAdd.js?v=1.0.3"></script>
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content">
            <div class="account-content">
                <div class="_title">
                    <div class="fl">经纪人新增</div>
                </div>
                <div class="_content">
                    <div class="r-info pd-t-clear clear">
                        <div class="li_text">
                            <div class="fl _t">头像:</div>
                            <div class="fl _info userlogo">
                                <a href="#" onclick="changeImg()">
                                    <div class="imgs">
                                        <img src="" alt="" id="headerImg">

                                        <div class="close"></div>
                                    </div>
                                </a>

                                <div class="weui-cells weui-cells_form hide" id="uploaderHeader">
                                    <div class="weui-cell">
                                        <div class="weui-cells weui-cells_form" id="uploade">
                                            <div class="weui-cell">
                                                <div class="weui-cell__bd">
                                                    <div class="weui-uploader">
                                                        <div class="weui-uploader__bd">
                                                            <div class="weui-uploader__input-box">
                                                                <input
                                                                        id="uploaderCustomInputHeader"
                                                                        class="weui-uploader__input"
                                                                        type="file" accept="image/*" multiple="">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <form id="form">
                        <input type="hidden" name="imgPath" id="path" value="">

                        <div class="clear r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">姓名:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" name="name" id="name"
                                           value="">
                                </div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">身份证号:</div>
                                <div class="fl _info w200"><input type="text" name="idcard" class="edit-input w200"
                                                                  id="idcard" onchange="setInfo()" value="">
                                </div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">性别:</div>
                                <div class="fl _info w200">
                                    <select name="sex" id="sex" class="edit-input w200">
                                        <option value="1">男
                                        </option>
                                        <option value="0">女
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">年龄:</div>
                                <div class="fl _info w200"><input type="text" name="age" class="edit-input w200"
                                                                  id="age"
                                                                  readonly value="">
                                </div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">学历:</div>
                                <div class="fl _info w200">
                                    <select name="xl" id="" class="edit-input w200">
                                        <option value="1">小学
                                        </option>
                                        <option value="2">初中
                                        </option>
                                        <option value="3">高中
                                        </option>
                                        <option value="4">大专
                                        </option>
                                        <option value="5">本科
                                        </option>
                                        <option value="6">硕士
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">经验:</div>
                                <div class="fl _info w200"><input name="jy" type="text" class="edit-input w200"
                                                                  value=""></div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">民族:</div>
                                <div class="fl _info w200"><input name="mz" type="text" class="edit-input w200"
                                                                  value=""></div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">手机号:</div>
                                <div class="fl _info w200"><input name="phoneNumber" id="phoneNumber" type="text"
                                                                  class="edit-input w200"
                                                                  value=""></div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">银行卡号:</div>
                                <div class="fl _info w200"><input name="bankCode" id="bankCode" type="text"
                                                                  class="edit-input w200"
                                                                  value=""></div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">所在公司:</div>
                                <div class="fl _info w200"><input name="companyName" id="comName" type="text"
                                                                  class="edit-input w200"
                                                                  value=""></div>
                            </div>
                            <div class="li_text">
                                <div class="fl _t">公司地址:</div>
                                <div class="fl _info w200"><input name="address" type="text" class="edit-input w200"
                                                                  value=""></div>
                            </div>

                            <div class="btn-box edit-btn">
                                <button class="fl save" onclick="saveInfo();return false;">保存</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>