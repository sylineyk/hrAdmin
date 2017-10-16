function toEditAdmin() {
    location.href = "/admin/view/toAdminInfoEdit";
}


function toChangePwd() {
    var index = layer.open({
        type: 2,
        title: '密码修改',
        content: '/admin/view/changePwd'
    });
    layer.full(index);
}