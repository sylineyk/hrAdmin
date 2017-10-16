<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#macro memu>
    <@security.authorize access="hasRole('ROLE_ADMIN')">
    <ul>
        <a class="h1 <#if flag='index'>active</#if>" href="#" onclick="toBrokerList()">经纪人列表</a>
        <a class="h1 <#if flag='nurseList'>active</#if>" href="#" onclick="toNurseList()">阿姨列表</a>
        <a class="h1 <#if flag='cusList'>active</#if>" href="#" onclick="toCustomerList()">客户列表</a>
        <a class="h1 <#if flag='zpsh'>active</#if>" href="#" onclick="toPictureShLife()">照片审核</a>
        <a class="h1 <#if flag='jszx'>active</#if>" href="#" onclick="toJsAdmin()">结算中心</a>
        <a class="h1 <#if flag='center'>active</#if>" href="#" onclick="toUserCenter()">个人中心</a>
    </ul>
    </@security.authorize>


    <@security.authorize access="hasRole('ROLE_BROKER')">
    <ul>
        <a class="h1 <#if flag='index'>active</#if>" href="#" onclick="toNurseBroker()">阿姨管理</a>
        <a class="h1 <#if flag='import'>active</#if>" href="#" onclick="toNurseImport()">阿姨批量导入</a>
        <a class="h1 <#if flag='zpsh'>active</#if>" href="#" onclick="toPictureSh()">照片审核</a>
        <a class="h1 <#if flag='js'>active</#if>" href="#" onclick="toJs()">结算中心</a>
        <a class="h1 <#if flag='nurseManage'>active</#if>" href="#" onclick="toBrokerInfo()">个人中心</a>
    </ul>
    </@security.authorize>
</#macro>