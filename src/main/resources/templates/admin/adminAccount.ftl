<#import "../frame.ftl" as f>

<@f.html title="个人信息"     stylesheet="page" script="common/template,admin/adminInfo,common/jquery.twbsPagination.min">
<div class="account-content">
    <div class="_title">
        <div class="fl">个人信息</div>
        <div class="fr">
            <a href="#" onclick="toChangePwd()">修改登录密码</a>
        </div>
    </div>
    <div class="_content">
        <div class="fl r-info">
            <div class="li_text">
                <div class="fl _t">姓名:</div>
                <div class="fl _info">${info.name!''}</div>
            </div>
            <div class="li_text">
                <div class="fl _t">电话:</div>
                <div class="fl _info">${info.phoneNumber!''}</div>
            </div>
        </div>
    </div>
    <div class="btn-box edit-btn">
        <button class="fl save" onclick="toEditAdmin()">编辑</button>
    </div>
</div>
<#--<div class="account-content">-->
<#--<div class="_title">-->
<#--<div class="fl">公司信息</div>-->
<#--</div>-->
<#--<div class="_content">-->
<#--<div class="fl r-info pd-t-clear">-->
<#--<div class="li_text">-->
<#--<div class="fl _t">公司名称:</div>-->
<#--<div class="fl _info">${info.companyname!''}</div>-->
<#--</div>-->
<#--<div class="li_text">-->
<#--<div class="fl _t">公司地址:</div>-->
<#--<div class="fl _info">${info.address!''}</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->

<#--<div class="btn-box edit-btn">-->
<#--<button class="fl save" onclick="toEditBroker()">编辑</button>-->
<#--</div>-->
<#--</div>-->
</@f.html>