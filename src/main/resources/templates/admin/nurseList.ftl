<#import "../frame.ftl" as f>

<@f.html title="主页"     stylesheet="page" script="common/template,admin/nurseList,common/jquery.twbsPagination.min">
<div class="list-content">
    <form>
        <div class="search-edit">
            <div class="_t">筛选条件</div>
            <div class="input-list">
                <div class="inputs">
                    <div class="_t fl">服务类型:</div>
                    <div class="_input fl">
                        <select name="" id="nurseType">
                            <option value="">不限</option>
                            <option value="1">保姆</option>
                            <option value="2">育婴</option>
                            <option value="3">月嫂</option>
                            <option value="4">居家陪护</option>
                        </select>
                    </div>
                </div>
                <div class="inputs">
                    <div class="_t fl">服务地区:</div>
                    <div class="_input fl">
                        <select name="" id="area">
                            <option value="">不限</option>
                            <option value="1">罗湖区</option>
                            <option value="2">福田区</option>
                            <option value="3">南山区</option>
                            <option value="4">宝安区</option>
                            <option value="5">光明新区</option>
                            <option value="6">龙岗区</option>
                            <option value="7">坪山新区</option>
                            <option value="8">盐田区</option>
                            <option value="9">龙华新区</option>
                            <option value="10">大鹏新区</option>
                        </select>
                    </div>
                </div>
                <div class="inputs">
                    <div class="_t fl">工资:</div>
                    <div class="_input fl">
                        <div class="_input fl">
                            <select name="" id="salaryType">
                                <option value="">不限</option>
                                <option value="1">4500元以下</option>
                                <option value="2">4500~6000</option>
                                <option value="3">6000~8000</option>
                                <option value="4">8000以上</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="inputs">
                    <div class="_t fl"></div>
                    <div class="_input fl">
                        <div class="_input fl">
                            <input type="text" id="paramStr" name="paramStr" class="w300" placeholder="请输入关键字">
                        </div>
                    </div>
                </div>
            </div>
            <div class="btns btn-box">
                <button type="reset" class="edit">清除所有条件</button>
                <button class="edit" onclick="queryInfo();return false;">搜索</button>
            </div>
        </div>
    </form>
    <div class="table-content">
        <table>
            <thead>
            <tr class="bg-gary">
                <th>姓名</th>
                <th>年龄</th>
                <th>属相</th>
                <th>服务类型</th>
                <th>服务地区</th>
                <th>工资</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="content">
            <script id="test" type="text/html">
                {{if results}}
                {{each results as entity i}}
                <tr class="li" id="{{entity.id}}">
                    <td>
                        {{entity.name}}
                    </td>
                    <td>
                        {{entity.age}}
                    </td>
                    <td>
                        {{entity.zodiac}}
                    </td>
                    <td class="w200">{{entity.type}}</td>
                    <td class="w200">{{entity.service_area}}</td>
                    <td>{{entity.salary}}</td>
                    <td class="edit">
                        <a href="#" onclick="toDetail({{entity.id}})">详情</a>
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