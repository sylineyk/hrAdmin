<#import "../frame.ftl" as f>

<@f.html title="主页"     stylesheet="page" script="common/template,admin/customerList,common/jquery.twbsPagination.min">
<div class="list-content">
    <div class="search">
        <div class="input">
            <input type="text" id="paramStr" placeholder="请输入关键字">
        </div>
        <button class="btn" onclick="queryInfo()">搜索</button>
        <button type="reset" class="btn" onclick="clearTj()">清除所有条件</button>
    </div>
    <div class="table-content">
        <table>
            <thead>
            <tr class="bg-gary">
                <th>电话</th>
                <th>注册时间</th>
            </tr>
            </thead>
            <tbody id="content">
            <script id="test" type="text/html">
                {{if results}}
                {{each results as entity i}}
                <tr class="li" id="{{entity.id}}">
                    <td>
                        {{entity.phone}}
                    </td>
                    <td>
                        {{entity.createTime}}
                    </td>
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