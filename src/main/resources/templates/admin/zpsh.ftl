<#import "../frame.ftl" as f>

<@f.html title="照片审核"     stylesheet="page" script="common/template,admin/shList,common/jquery.twbsPagination.min">
<div class=" sh list-content">
    <div class="title">阿姨照片审核</div>
    <div class="search-edit clear pd-clear mg-clear br-none">
        <div class="input-list clear">
            <div class="inputs clear">
                <div class="_t fl">审核状态:</div>
                <div class="_input fl">
                    <div class="_input fl">
                        <select id="status">
                            <option value="0">待审核</option>
                            <option value="1">已通过</option>
                            <option value="2">已驳回</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="btns btn-box fl">
                <button class="edit" onclick="queryInfo()">搜索</button>
            </div>
        </div>
    </div>
    <div class="phone-list" id="content">
        <script id="test" type="text/html">
            {{if results}}
            {{each results as entity i}}
            <div class="li">
                <div class="_title">
                    {{entity.name}}
                <#--<span class="gray-color">2016-06-02 11:30</span>-->
                </div>
                <div class="_list">
                    {{each entity.pics as pic i}}
                    <img src="{{pic}}" alt="">
                    {{/each}}
                    <a href="#" class="linksh" onclick="toShDetail({{entity.id}})">详情>></a>
                </div>
            </div>
            {{/each}}
            {{/if}}
        </script>
    </div>
    <div id="page">
        <ul id="pagination" class="pagination-sm"></ul>
    </div>
</div>
</@f.html>