<#import "../frame.ftl" as f>

<@f.html title="资料编辑"     stylesheet="page" script="common/template,broker/brokerInfoEdit,common/jquery.twbsPagination.min">
<div class="account-content">
    <div class="_title">
        <div class="fl">个人信息</div>
    </div>
    <div class="_content">
        <div class="fl userlogo">
            <a href="#" onclick="changeImg()">
                <div class="imgs">
                    <img src="${info.path!''}" alt="" id="headerImg">

                    <div class="close"></div>
                </div>
            </a>

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
        </div>
        <form id="form">
            <input type="hidden" name="imgPath" id="path">

            <div class="fl r-info">
                <div class="li_text">
                    <div class="fl _t">姓名:</div>
                    <div class="fl _info"><input type="text" name="name" class="edit-input w100"
                                                 value="${info.name!''}">
                    </div>
                </div>
                <div class="li_text">
                    <div class="fl _t">电话:</div>
                    <div class="fl _info">${info.phone!''}</div>
                </div>
            </div>
    </div>
</div>
<div class="account-content">
    <div class="_title">
        <div class="fl">公司信息</div>
    </div>
    <div class="_content">
        <div class="fl r-info pd-t-clear">
            <div class="li_text">
                <div class="fl _t">公司名称:</div>
                <div class="fl _info"><input type="text" name="companyName" class="edit-input w300"
                                             value="${info.companyname!''}"></div>
            </div>
            <div class="li_text">
                <div class="fl _t">公司地址:</div>
                <div class="fl _info"><input type="text" name="address" class="edit-input w300"
                                             value="${info.address!''}">
                </div>
            </div>
        </div>
    </div>
    </form>
    <div class="btn-box edit-btn">
        <button class="fl save" onclick="saveInfo()">保存</button>
        <button class="fl cancel" onclick="cancel()">取消</button>
    </div>
</div>
</div>
</@f.html>