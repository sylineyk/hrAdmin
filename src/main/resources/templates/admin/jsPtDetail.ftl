<#import "../frame.ftl" as f>

<@f.html title="订单明细"     stylesheet="page" script="common/template,admin/jsPtDetail,common/jquery.twbsPagination.min,My97DatePicker/4.8/WdatePicker">
<div class="list-content">
    <div class="search-edit clear">
        <button class="edit" onclick="backJs()">返回</button>
    </div>
    <div class="search-edit clear">
        <div class="_t">筛选条件</div>
        <input type="hidden" id="fromDate" value="${fromDate!""}">
        <input type="hidden" id="endDate" value="${endDate!""}">

        <div class="input-list">
            <div class="inputs clear">
                <div class="_t fl"></div>
                <div class="_input fl">
                    <div class="_input fl">
                        <select id="busType">
                            <option value="1">阿姨</option>
                            <option value="2">经纪人</option>
                        </select>
                    </div>
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
            <div class="l">应收金额</div>
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
                <th>经纪人</th>
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
                    <td>{{entity.brokerName}}</td>
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