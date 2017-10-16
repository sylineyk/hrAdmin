<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>审核详情</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.min.css">
    <script type="text/javascript" src="/assets/js/common/weui.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="/assets/js/broker/picShDetail.js?v=1.0.2"></script>
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content sh list-content">
            <div class="account-content pd-clear">
                <div class="uploadinfo">
                    <div class="li clear">
                        <div class="li_text">
                            <div class="fl _t">上传人:</div>
                            <div class="fl _info w200">
                                <input type="hidden" name="nurseId" id="nurseId" value="${nurseId}">
                            ${picName}
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="account-content pd-clear">
            <#if cardInfos??>
                <div class="_title">
                    <div class="fl">身份证明</div>
                </div>
                <div class="_content br-none">
                    <#list cardInfos as info>
                        <div class="imgupload-box"><img src="${info}" alt=""></div>
                    </#list>
                </div>
            </#if>
            <#if pictureInfos??>
                <div class="_title">
                    <div class="fl">资质证书</div>
                </div>
                <div class="_content br-none">
                    <#list pictureInfos as info>
                        <div class="imgupload-box"><img src="${info}" alt=""></div>
                    </#list>
                </div>
            </#if>
            <#if status=='0'>
                <div class="btn-box edit-btn">
                    <button class="fl save" onclick="passPic()">通过</button>
                    <button class="fl cancel" onclick="rejectPic()">驳回</button>
                </div>
            </#if>
            </div>

        </div>

    </div>
</div>
</body>
</html>