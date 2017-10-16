<#import "../frame.ftl" as f>

<@f.html title="结算中心"     stylesheet="page" script="common/template,broker/jsList,common/jquery.twbsPagination.min,My97DatePicker/4.8/WdatePicker">
<div class="list-content">
    <div class="search-edit clear">
        <div class="_t">筛选条件</div>
        <div class="input-list">
            <div class="inputs">
                <div class="_t fl">订单日期:</div>
                <div class="_input fl">
                    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})"
                           id="datemin" class="input-text Wdate" style="width:120px;">
                    -
                    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
                           id="datemax" class="input-text Wdate" style="width:120px;">
                </div>
            </div>

            <div class="inputs clear">
                <div class="_t fl"></div>
                <div class="_input fl">
                    <div class="_input fl">
                        <input type="text" id="paramStr" class="w300" placeholder="请输入姓名进行查询">
                    </div>
                </div>
            </div>
        </div>
        <div class="btns btn-box" style="float:left;padding-left:90px">
            <button class="edit" onclick="queryInfo()">搜索</button>
        </div>
    </div>
    <div class="statistics">
        <div class="li">
            <div class="l">客户订单总额</div>
            <div class="m gray-color"></div>
            <div class="r gray-color" id="ze"></div>
        </div>
        <div class="li">
            <div class="l">平台收入</div>
            <div class="m gray-color">(中介费+定金) * 10%</div>
            <div class="r gray-color" id="ptsr"></div>
        </div>
        <div class="li">
            <div class="l">阿姨工资</div>
            <div class="m gray-color">工资合计</div>
            <div class="r gray-color" id="gz"></div>
        </div>
        <div class="li">
            <div class="l">我的收入</div>
            <div class="m gray-color">(中介费+定金) * 90%</div>
            <div class="r gray-color" id="ysje"></div>
        </div>
    </div>
    <div class="table-content">
        <table>
            <thead>
            <tr class="bg-gary">
                <th>订单编号</th>
                <th>订单类型</th>
                <th>服务阿姨</th>
                <th>阿姨电话</th>
                <th>服务费</th>
                <th>定金</th>
                <th>客户支付</th>
                <th>工资</th>
            </tr>
            </thead>
            <tbody id="content">
            <script id="test" type="text/html">
                {{if results}}
                {{each results as entity i}}
                <tr class="li">
                    <td>
                        {{entity.code}}
                    </td>
                    <td>
                        {{entity.type}}
                    </td>
                    <td>
                        {{entity.nurseName}}
                    </td>
                    <td>{{entity.phone}}</td>
                    <td>{{entity.fwf}}</td>
                    <td>{{entity.dj}}</td>
                    <td>{{entity.khzf}}</td>
                    <td>{{entity.gz}}</td>
                </tr>
                {{/each}}
                {{/if}}
            </script>
            </tbody>
        </table>
        <div id="page">
            <ul id="pagination" class="pagination-sm"></ul>
        </div>
    </div>
    <input type="hidden" id="totalPage">
</div>
</@f.html>