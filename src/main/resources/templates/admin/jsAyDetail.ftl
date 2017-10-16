<#import "../frame.ftl" as f>

<@f.html title="订单明细"     stylesheet="page" script="common/template,admin/jsAyDetail,common/jquery.twbsPagination.min,My97DatePicker/4.8/WdatePicker">
<div class="list-content">
    <input type="hidden" id="fromDate" value="${fromDate!""}">
    <input type="hidden" id="endDate" value="${endDate!""}">


    <div class="search-edit clear">
        <button class="edit" onclick="backJs()">返回</button>
    </div>

    <div class="table-content">
        <table>
            <thead>
            <tr class="bg-gary">
                <th>阿姨姓名</th>
                <th>联系电话</th>
                <th>银行卡号</th>
                <th>应付金额(元)</th>
            </tr>
            </thead>
            <tbody id="content">
            <script id="test" type="text/html">
                {{if results}}
                {{each results as entity i}}
                <tr class="li">
                    <td>
                        {{entity.name}}
                    </td>
                    <td><a href="#" onclick="toAyDetail('{{entity.phone}}')">{{entity.phone}}</a></td>
                    <td>{{entity.bankCode}}</td>
                    <td>{{entity.yfje}}</td>
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