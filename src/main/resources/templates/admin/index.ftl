<#import "../frame.ftl" as f>

<@f.html title="主页"     stylesheet="page" script="common/template,admin/brokerList,common/jquery.twbsPagination.min">
<div class="list-content">
    <div class="search">
        <div class="input">
            <input type="text" id="searchInfo" placeholder="请输入关键字">
        </div>
        <button class="btn" onclick="queryInfo()">搜索</button>
        <button type="reset" class="btn" onclick="clearTj()">清除所有条件</button>
    </div>
    <div class="tools-bar">
        <button class="del fl" onclick="deleteBatch()">批量删除</button>
        <button class="add fr" onclick="addBroker()">新增经纪人</button>
    </div>
    <div class="table-content">
        <table>
            <thead>
            <tr class="bg-gary">
                <th><input type="checkbox" name="" id="checkAll"></th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>所属公司</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="content">
            <script id="test" type="text/html">
                {{if results}}
                {{each results as entity i}}
                <tr class="li" id="{{entity.id}}">
                    <td>
                        {{if entity.delFlag=='1'}}
                        <input type="checkbox" name="checkBox" id="{{entity.id}}">
                        {{/if}}
                    </td>
                    <td>
                        {{entity.name}}
                    </td>
                    <td>
                        {{if entity.sex=='1'}}
                        男
                        {{/if}}
                        {{if entity.sex=='0'}}
                        女
                        {{/if}}
                    </td>
                    <td>
                        {{entity.phone}}
                    </td>
                    <td class="w300">{{entity.companyname}}</td>
                    <td class="edit">
                        <a href="#" onclick="toDetail({{entity.id}})">详情</a>
                        <a href="#" onclick="toEdit({{entity.id}})">编辑</a>
                        {{if entity.delFlag=='1'}}
                        <a href="#" onclick="toDelete(this,'{{entity.id}}')">删除</a>
                        {{/if}}
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