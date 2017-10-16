<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#macro header>
<div class="left">
    管理后台
</div>
<div class="right">
    <@security.authorize access="hasRole('ROLE_ADMIN')">
        <a href="#" class="userinfo" onclick="toUserCenter()">
            <img src="//p1.meituan.net/deal/ba7764120541b925b54a5398d49579e4136141.jpg" alt="">
        ${Session.SPRING_SECURITY_CONTEXT.authentication.principal.name!'xxx'}
        </a>
    </@security.authorize>


    <@security.authorize  access="hasRole('ROLE_BROKER')">
        <a href="#" class="userinfo" onclick="toBrokerInfo()">
            <img src="//p1.meituan.net/deal/ba7764120541b925b54a5398d49579e4136141.jpg" alt="">
        ${Session.SPRING_SECURITY_CONTEXT.authentication.principal.name!'xxx'}
        </a>
    </@security.authorize>



    <a href="/logout" class="out">
        退出
    </a>
</div>
</#macro>