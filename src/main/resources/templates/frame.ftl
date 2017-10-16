<#ftl strip_whitespace=true>

<#import "menu.ftl" as m>
<#import "header.ftl" as h>

<#macro html title  stylesheet="" script="" >
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.min.css">

    <title>${title?html}</title>
    <#if stylesheet?html!="">
        <#list stylesheet?html?split(",") as c>
            <link rel="stylesheet" type="text/css" href="/assets/css/${c}.css?v=1.0.3"/>
        </#list>
    </#if>
    <script type="text/javascript" src="/assets/js/common/weui.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="/assets/js/common/jquery.js"></script>
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/jquery.md5.js"></script>
    <script type="text/javascript" src="/assets/js/common/tools.js?v=1.0.1"></script>
    <script type="text/javascript" src="/assets/js/common/util.js?v=1.0.0"></script>
    <script type="text/javascript" src="/assets/js/common/menu.js?v=0.0.1"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>

    <#if script?html!="">
        <#list script?html?split(",") as s>
            <script type="text/javascript" src="/assets/js/${s}.js?v=1.0.7"></script>
        </#list>
    </#if>

    <script type='text/javascript'>
        var _vds = _vds || [];
        window._vds = _vds;
        (function(){
            _vds.push(['setAccountId', 'ae54934bbbdee3bf']);
            (function() {
                var vds = document.createElement('script');
                vds.type='text/javascript';
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
        <@h.header/>


    </header>


    <div class="content-main">
        <div class="left-bar">
            <@m.memu/>
        </div>
        <div class="right-content">
            <#nested/>
        </div>
    </div>
<#--<aside class="Hui-aside">-->
<#--<@m.memu/>-->
<#--</aside>-->
<#--<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>-->
<#--</div>-->


<#--<section class="Hui-article-box">-->
<#--<#nested/>-->
<#--</section>-->
    <!-- body 最后 -->
</div>
</body>

</html>
</#macro>

<#macro baseContextPath><#if _rc.getContextPath()=="/"><#else>${_rc.getContextPath()}</#if></#macro>
<#global base><@baseContextPath/></#global>