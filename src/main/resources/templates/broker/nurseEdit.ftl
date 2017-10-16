<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>新增编辑</title>
    <link href="/assets/css/admin.css?v=1.0.2" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/assets/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/js/common/util.js"></script>
    <script type="text/javascript" src="/assets/js/layer/2.4/layer.js"></script>
    <link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.0/weui.min.css">
    <script type="text/javascript" src="/assets/js/common/weui.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="/assets/js/broker/nurseEdit.js?v=1.0.2"></script>
    <script type="text/javascript" src="/assets/js/broker/nurseImgEdit.js?v=1.0.2"></script>
    <script type="text/javascript" src="/assets/js/My97DatePicker/4.8/WdatePicker.js?v=1.0.0"></script>
</head>
<body>
<div class="body-content">
    <div class="content-main">
        <div class="right-content">
            <div class="account-content">
                <form id="form">
                    <div class="_title">
                        <div class="fl">阿姨详细信息</div>
                        <input type="hidden" id="id" name="id" value="${result["nurse"].id}">
                        <input type="hidden" id="pathRy" value="" name="pathRy">
                        <input type="hidden" id="pathCard" value="" name="pathCard">
                        <input type="hidden" id="pathLive" value="" name="pathLive">
                        <input type="hidden" id="delRy" value="" name="delRy">
                        <input type="hidden" id="delCard" value="" name="delCard">
                        <input type="hidden" id="delLive" value="" name="delLive">


                        <input type="hidden" id="oldCard" value="${result["nurse"].idcard}">
                        <input type="hidden" id="oldPhone" value="${result["nurse"].phoneNumber}">

                    </div>
                    <div class="_content">
                        <div class="r-info pd-t-clear clear">
                            <div class="li_text">
                                <div class="fl _t">头像:</div>
                                <div class="fl _info userlogo">
                                    <a href="#" onclick="changeImg()">
                                        <div class="imgs">
                                            <img src="${result["nurse"].imgPath}" alt="" id="headerImg">
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="weui-cells weui-cells_form hide" id="uploaderHeader">
                            <div class="weui-cell">
                                <div class="weui-cells weui-cells_form" id="uploade">
                                    <div class="weui-cell">
                                        <div class="weui-cell__bd">
                                            <div class="weui-uploader">
                                                <div class="weui-uploader__bd">
                                                    <div class="weui-uploader__input-box">
                                                        <input
                                                                id="uploaderCustomInputHeader"
                                                                class="weui-uploader__input"
                                                                type="file" accept="image/*" multiple="">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">姓名:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].name!""}"
                                           id="name" name="name">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">性别:</div>
                                <div class="fl _info w200">
                                    <select name="sex" id="sex" class="edit-input w200">
                                        <option value="1" <#if result["nurse"].sex??><#if result["nurse"].sex=='1'>selected</#if></#if>>
                                            男
                                        </option>
                                        <option value="0" <#if result["nurse"].sex??><#if result["nurse"].sex=='0'>selected</#if></#if>>
                                            女
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">手机号:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].phoneNumber!""}"
                                           id="phoneNumber" name="phoneNumber">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">身份证号:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].idcard!""}"
                                           onchange="setInfo()" name="idcard"
                                           id="idcard">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">年龄:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].age!""}"
                                           id="age"
                                           name="age" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">属相:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].zodiac!""}"
                                           readonly
                                           id="zodiac" name="zodiac">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">学历:</div>
                                <div class="fl _info w200">
                                    <select name="xl" id="" class="edit-input w200">
                                        <option value="1" <#if result["nurse"].xl??><#if result["nurse"].xl='1'>selected</#if></#if>>
                                            小学
                                        </option>
                                        <option value="2" <#if result["nurse"].xl??><#if result["nurse"].xl='2'>selected</#if></#if>>
                                            初中
                                        </option>
                                        <option value="3" <#if result["nurse"].xl??><#if result["nurse"].xl='3'>selected</#if></#if>>
                                            高中
                                        </option>
                                        <option value="4" <#if result["nurse"].xl??><#if result["nurse"].xl='4'>selected</#if></#if>>
                                            大专
                                        </option>
                                        <option value="5" <#if result["nurse"].xl??><#if result["nurse"].xl='5'>selected</#if></#if>>
                                            本科
                                        </option>
                                        <option value="6" <#if result["nurse"].xl??><#if result["nurse"].xl='6'>selected</#if></#if>>
                                            硕士
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">民族:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].mz!""}"
                                           id="mz" name="mz">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">身高:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].high!""}"
                                           id="high" name="high">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">体重:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].weight!""}"
                                           id="weight" name="weight">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">健康状况:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].health!""}"
                                           id="health" name="health">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">工作经验:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].experience!""}"
                                           id="experience" name="experience">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">家乡:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].birth!""}"
                                           id="birth" name="birth">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">婚姻状况:</div>
                                <div class="fl _info w200">
                                    <select name="hy" id="hy" class="edit-input w200">
                                        <option value="1" <#if result["nurse"].hy??><#if result["nurse"].hy=='1'>selected</#if></#if>>
                                            已婚
                                        </option>
                                        <option value="0" <#if result["nurse"].hy??><#if result["nurse"].hy=='0'>selected</#if></#if>>
                                            未婚
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">有无小孩:</div>
                                <div class="fl _info w200">
                                    <select name="ywxh" id="ywxh" class="edit-input w200">
                                        <option value="1" <#if result["nurse"].ywxh??><#if result["nurse"].ywxh=='1'>selected</#if></#if>>
                                            有
                                        </option>
                                        <option value="0" <#if result["nurse"].ywxh??><#if result["nurse"].ywxh=='0'>selected</#if></#if>>
                                            无
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">语言能力:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200"
                                           value="${result["nurse"].yy!""}"
                                           id="yy" name="yy">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">烹饪能力:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200"
                                           value="${result["nurse"].pr!""}"
                                           id="pr" name="pr">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">工作能力:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200"
                                           value="${result["nurse"].gz!""}"
                                           id="gz" name="gz">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">使用电器:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200"
                                           value="${result["nurse"].sydq!""}"
                                           id="sydq" name="sydq">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">参考工资:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].salary!""}"
                                           id="salary" name="salary">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">合同开始日期:</div>
                                <div class="fl _info w200">
                                    <input type="text" value="${result["nurse"].htStartDateStr!""}"
                                           onfocus="WdatePicker()"
                                           id="datemin" class="input-text Wdate" style="width:120px;"
                                           name="htStartDate">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">合同结束日期:</div>
                                <div class="fl _info w200">
                                    <input type="text" value="${result["nurse"].htEndDateStr!""}"
                                           onfocus="WdatePicker()"
                                           id="datemax" class="input-text Wdate" style="width:120px;" name="htEndDate">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">开户银行:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].khyh!""}"
                                           id="khyh" name="khyh">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">银行卡账户:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" value="${result["nurse"].bank_code!""}"
                                           id="bankCode" name="bankCode">
                                </div>
                            </div>
                        </div>

                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">所在地区:</div>
                                <div class="fl _info w200">
                                    <select name="locationArea" id="locationArea">
                                        <option value="罗湖区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='1'>selected</#if></#if>>
                                            罗湖区
                                        </option>
                                        <option value="福田区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='2'>selected</#if></#if>>
                                            福田区
                                        </option>
                                        <option value="南山区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='3'>selected</#if></#if>>
                                            南山区
                                        </option>
                                        <option value="宝安区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='4'>selected</#if></#if>>
                                            宝安区
                                        </option>
                                        <option value="光明新区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='5'>selected</#if></#if>>
                                            光明新区
                                        </option>
                                        <option value="龙岗区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='6'>selected</#if></#if>>
                                            龙岗区
                                        </option>
                                        <option value="坪山新区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='7'>selected</#if></#if>>
                                            坪山新区
                                        </option>
                                        <option value="盐田区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='8'>selected</#if></#if>>
                                            盐田区
                                        </option>
                                        <option value="龙华新区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='9'>selected</#if></#if>>
                                            龙华新区
                                        </option>
                                        <option value="大鹏新区" <#if result["nurse"].locationArea??><#if result["nurse"].locationArea=='10'>selected</#if></#if>>
                                            大鹏新区
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear" onclick="selectCity()">
                            <div class="li_text">
                                <div class="fl _t">服务地区:</div>
                                <div class="fl _info w200">
                                    <input type="hidden" name="serviceArea" readonly id="cityIds"
                                           value="${result["nurse"].serviceArea!""}">
                                    <input type="text" class="edit-input w200" id="cityValues" readonly
                                           value="${result["nurse"].serviceAreaNames!""}">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">工号:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200" name="card" id="card"
                                           value="${result["nurse"].card!""}">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear" onclick="selectType()">
                            <div class="li_text">
                                <div class="fl _t">服务类型:</div>
                                <div class="fl _info w200">
                                    <input type="hidden" name="type" readonly id="serviceTypeIds"
                                           value="${result["nurse"].type!""}">
                                    <input type="text" class="edit-input w200" readonly id="serviceTypeValues"
                                           value="${result["nurse"].typeNames!""}">

                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">级别:</div>
                                <div class="fl _info w200">
                                    <input type="text" class="edit-input w200"
                                           value="${result["nurse"].level!""}"
                                           id="level" name="level">
                                </div>
                            </div>
                        </div>
                        <div class="fl r-info pd-t-clear">
                            <div class="li_text">
                                <div class="fl _t">经纪人评价:</div>
                                <div class="fl _info w500">
                                    <textarea class="edit-input" rows="20" cols="30"
                                              style="border:1px solid #e6e6e6;height: 50px;"
                                              id="gspj" name="gspj">
                                    ${result["nurse"].gspj!""}
                                    </textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="account-content">
                <div class="_title">
                    <div class="fl">身份证明</div>
                </div>
                <div class="_content">
                <#list result["card"] as card>
                    <a href="#" onclick="deleteCardImg(${card["id"]})">
                        <div class="imgupload-box imgs" id="${card["id"]}">
                            <img
                                    src="${card["path"]}"
                                    alt="">
                        </div>
                    </a>
                </#list>
                </div>
                <div class="weui-cells weui-cells_form" id="uploaderCard">
                    <div class="weui-cell">
                        <div class="weui-cells weui-cells_form" id="uploade">
                            <div class="weui-cell">
                                <div class="weui-cell__bd">
                                    <div class="weui-uploader">
                                        <div class="weui-uploader__bd">
                                            <ul class="weui-uploader__files" id="uploaderCustomFilesCard"></ul>
                                            <div class="weui-uploader__input-box"><input
                                                    id="uploaderCustomInput" class="weui-uploader__input"
                                                    type="file" accept="image/*" multiple="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="account-content">
                <div class="_title">
                    <div class="fl">资质证书</div>
                </div>
                <div class="_content">
                <#list result["ryzs"] as ryzs>
                    <a href="#" onclick="deleteRyImg(${ryzs["id"]})">
                        <div class="imgupload-box imgs" id="${ryzs["id"]}">
                            <img
                                    src="${ryzs["path"]}"
                                    alt="">
                        </div>
                    </a>
                </#list>
                </div>
                <div class="weui-cells weui-cells_form" id="uploader">
                    <div class="weui-cell">
                        <div class="weui-cells weui-cells_form" id="uploade">
                            <div class="weui-cell">
                                <div class="weui-cell__bd">
                                    <div class="weui-uploader">
                                        <div class="weui-uploader__bd">
                                            <ul class="weui-uploader__files" id="uploaderCustomFiles"></ul>
                                            <div class="weui-uploader__input-box">
                                                <input
                                                        id="uploaderCustomInput"
                                                        class="weui-uploader__input"
                                                        type="file" accept="image/*" multiple="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="account-content">
                <div class="_title">
                    <div class="fl">生活照片</div>
                </div>
                <div class="_content">
                <#list result["live"] as live>
                    <a href="#" onclick="deleteLiveImg(${live["id"]})">
                        <div class="imgupload-box imgs" id="${live["id"]}">
                            <img
                                    src="${live["path"]}"
                                    alt="">
                        </div>
                    </a>
                </#list>
                </div>
                <div class="weui-cells weui-cells_form" id="uploaderLive">
                    <div class="weui-cell">
                        <div class="weui-cells weui-cells_form" id="uploade">
                            <div class="weui-cell">
                                <div class="weui-cell__bd">
                                    <div class="weui-uploader">
                                        <div class="weui-uploader__bd">
                                            <ul class="weui-uploader__files" id="uploaderCustomFilesLive"></ul>
                                            <div class="weui-uploader__input-box"><input
                                                    id="uploaderCustomInput" class="weui-uploader__input"
                                                    type="file" accept="image/*" multiple="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="account-content">
                <div class="btn-box edit-btn pd-t-clear">
                    <button class="fl save" onclick="addNurse()">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal-box hide" id="typeDiv"> 
    <div class="_title"> 
        <h1>服务类型</h1> 
        <div class="close" onclick="closeDiv()">关闭</div>
    </div>
    <div class="_content"> 
        <div class="_tab"> 
            <ul id="typeid"> 
                <li class="active" onclick="selectTitle('fzd')" id="fzdt">非钟点工</li>
                <li onclick="selectTitle('zd')" id="zdt">钟点工</li>
            </ul>
        </div>
         
        <div class="_list" id="fzd"> 
            <div class="li">  <input type="checkbox" name="" id="1">保姆 </div>
            <div class="li">  <input type="checkbox" name="" id="2">育婴师 </div>
            <div class="li">  <input type="checkbox" name="" id="3">母婴护理员 </div>
            <div class="li">  <input type="checkbox" name="" id="4">居家陪护 </div>
        </div>
        <div class="_list hide" id="zd"> 
            <div class="li">  <input type="checkbox" name="" id="5">钟点工 </div>
            <div class="li">  <input type="checkbox" name="" id="6">包月钟点工 </div>
        </div>

        <div class="_tab"> 
            <ul id="typeid"> 
                <li class="active" onclick="setSelectInfo()" style="margin-left: 100px;">确定</li>
            </ul>
        </div>
    </div>
</div>

<div class="modal-box hide" id="cityDiv"> 
    <div class="_title"> 
        <h1>服务类型</h1> 
        <div class="close" onclick="closeCityDiv()">关闭</div>
    </div>
    <div class="_content"> 
        <div class="_list" id="s"> 
            <div class="li">  <input type="checkbox" name="" id="11">罗湖区 </div>
            <div class="li">  <input type="checkbox" name="" id="12">福田区 </div>
            <div class="li">  <input type="checkbox" name="" id="13">南山区 </div>
            <div class="li">  <input type="checkbox" name="" id="14">宝安区 </div>
            <div class="li">  <input type="checkbox" name="" id="15">光明新区</div>
            <div class="li">  <input type="checkbox" name="" id="16">龙岗区 </div>
            <div class="li">  <input type="checkbox" name="" id="17">坪山新区 </div>
            <div class="li">  <input type="checkbox" name="" id="18">盐田区 </div>
            <div class="li">  <input type="checkbox" name="" id="19">龙华新区 </div>
            <div class="li">  <input type="checkbox" name="" id="20">大鹏新区 </div>
        </div>

        <div class="_tab"> 
            <ul id="typeid"> 
                <li class="active" onclick="setCityInfo()" style="margin-left: 100px;">确定</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>