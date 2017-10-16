<#import "../frame.ftl" as f>

<@f.html title="主页"     stylesheet="page" script="common/template,broker/nurseImport,common/jquery.twbsPagination.min">
<div class="list-content">
    <div class="search-edit">
        <div class="_t">批量上传</div>
        <div class="input-list">
            <div class="inputs">
                <div class="_t fl">选择文件:</div>
                <div class="_input fl">
                    <form id="form" action="/broker/op/importExcel"
                          enctype="multipart/form-data" method="post">
                        <input class="form-input" type="file" name="filename" id="fileName"></input>
                        <input type="hidden" id="msg" value="${msg}">
                        <button class="edit" type="submit">开始导入</button>
                    </form>
                </div>
                <a href="http://chouguanjia.oss-cn-shanghai.aliyuncs.com/broker/template.xlsx" class="afont" download>下载模板</a>
            </div>
        </div>
        <div class="input-list">
            <div class="inputs">
                <div class="_t fl">状态:</div>
                <div class="_input fl">
                    <div class="_input fl">
                        <select name="flag" id="flag">
                            <option value="0">待提交</option>
                            <option value="1">提交成功</option>
                            <option value="2">提交失败</option>
                        </select>
                    </div>
                </div>

                <button class="edit m-l-10" onclick="queryInfo()">查询</button>

            </div>
        </div>
    </div>
    <div class="table-topbutton">
        <button class="edit" onclick="submitImportInfo()">提交</button>
        <button class="edit" onclick="submitImportInfoAll()">全部提交</button>
    </div>
    <div class="table-content">
        <table>
            <thead>
            <tr class="bg-gary">
                <th><input type="checkbox" name="" id="checkAll"></th>
                <th>是否上传</th>
                <th>上传结果</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>工种</th>
                <th>属相</th>
                <th>学历</th>
                <th>民族</th>
                <th>工资</th>
                <th>级别</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="content">
            <script id="test" type="text/html">
                {{if results}}
                {{each results as entity i}}
                <tr class="li" id="{{entity.id}}">
                    <td>
                        <input type="checkbox" name="checkBox" id="{{entity.id}}">
                    </td>
                    <td>
                        {{if entity.flag=='0'}}
                        未提交
                        {{/if}}
                        {{if entity.flag=='1'}}
                        已提交
                        {{/if}}
                        {{if entity.flag=='2'}}
                        提交失败
                        {{/if}}
                    </td>
                    <td class="w200">
                        {{if entity.flag=='0'}}
                        {{/if}}
                        {{if entity.flag=='1'}}
                        提交成功
                        {{/if}}
                        {{if entity.flag=='2'}}
                        {{entity.result}}
                        {{/if}}
                    </td>
                    <td>
                        {{entity.name}}
                    </td>
                    <td>
                        {{entity.sex}}
                    </td>
                    <td>
                        {{entity.age}}
                    </td>
                    <td class="w200">{{entity.type}}</td>
                    <td>
                        {{entity.zodiac}}
                    </td>
                    <td>{{entity.xl}}</td>
                    <td>{{entity.mz}}</td>
                    <td>{{entity.salary}}</td>
                    <td>{{entity.level}}</td>
                    <td class="edit">
                        <a href="#" onclick="toDetail({{entity.id}})">详情</a>
                        <a href="#" onclick="toEdit({{entity.id}})">编辑</a>
                        <a href="#" onclick="toDelete(this,'{{entity.id}}')">删除</a>
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