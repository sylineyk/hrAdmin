<#import "../frame.ftl" as f>

<@f.html title="结算中心"     stylesheet="page" script="common/template,admin/jsCenter,common/jquery.twbsPagination.min,My97DatePicker/4.8/WdatePicker">
<div class="list-content">
    <div class="search-edit clear">
        <div class="_t">筛选条件</div>
        <div class="input-list">
            <div class="inputs">
                <div class="_t fl">订单日期:</div>
                <div class="_input fl">
                    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
                           id="datemin" class="input-text Wdate" style="width:120px;" value="${fromDate!""}">
                    -
                    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
                           id="datemax" class="input-text Wdate" style="width:120px;" value="${endDate!""}">
                </div>
            </div>
        </div>
        <div class="btns btn-box" style="float:left;padding-left:90px">
            <button class="edit" onclick="queryInfo()">搜索</button>
        </div>
    </div>
    <div class="statistics">
        <div class="li">
            <div class="l">平台收入</div>
            <div class="l gray-color">(中介费+定金) * 10%</div>
            <div class="m gray-color" id="ptsr"></div>
            <button class="r edit" onclick="toDetail('pt')" style="margin-top: 10px; ">查看明细</button>
        </div>
        <div class="li">
            <div class="l">应付经纪人金额</div>
            <div class="l gray-color">(中介费+定金) * 90%</div>
            <div class="m gray-color" id="ysje"></div>
            <button class="r edit" onclick="toDetail('jjr')" style="margin-top: 10px; ">查看明细</button>
        </div>
        <div class="li">
            <div class="l">应付阿姨金额</div>
            <div class="l gray-color">单次钟点工工资合计</div>
            <div class="m gray-color" id="gz"></div>
            <button class="r edit" onclick="toDetail('ay')" style="margin-top: 10px; ">查看明细</button>
        </div>
    </div>
</div>
</@f.html>