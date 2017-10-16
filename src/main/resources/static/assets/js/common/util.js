/**
 * Created by syline on 2017/6/20.
 */
//校验手机号是否合法
function isPhoneNum(str) {
    var phonenum = str;
    //var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
    var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;
    if (!myreg.test(phonenum)) {
        return false;
    } else {
        return true;
    }
}