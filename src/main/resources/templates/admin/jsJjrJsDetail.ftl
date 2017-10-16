<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>详情</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <link href="/assets/page.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/template.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/admin/jsJjrJsDetail.js?v=1.0.2"></script>
</head>
<body>
<div class="body-content">
    <input type="hidden" id="fromDate" value="${fromDate!""}">
    <input type="hidden" id="endDate" value="${endDate!""}">
    <input type="hidden" id="phone" value="${phone!""}">

    <div class="content-main">
        <div class="right-content sh list-content">
            <div class="table-content">
                <table>
                    <thead>
                    <tr class="bg-gary">
                        <th>订单编号</th>
                        <th>订单类型</th>
                        <th>服务阿姨</th>
                        <th>阿姨电话</th>
                        <th>经纪人</th>
                        <th>中介费</th>
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
    </div>
</div>
</body>
</html>