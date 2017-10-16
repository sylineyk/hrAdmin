package com.hong.admin.util;

public interface Constant {

    interface PageKey {
        int LIMIT = 10;// 登录用户信息
    }


    interface HttpKey {
        String COOKIE_ACCESS_TOKEN = "accessToken";// 保存在COOKIE中的TOKEN
        String LOGIN_ERROR_MSG = "loginErrorMsg";
        String VALIDATE_PHONE = "validatePhone";
        String VALIDATE_PHONE_CODE = "vPCode";
        String SEND_CODE_TIME = "sendTime";
        String CLICK_TIME = "clickTime";
    }

    interface NurseKey {
        String TYPE_NORMAL = "1";//状态正常待岗
        String TYPE_HOLIDAY = "2";//休假
        String TYPE_SICK = "3";//生病
        String TYPE_WORKING = "4";//服务中
    }

    interface AddressKey {
        int OFTEN = 1;//默认地址
        int NORMAL = 2;//一般地址
        int FACE = 3;//面试地址
    }

    interface SecurityKey {
        String ROLE_CUSTOMER = "1";//用户默认权限
        String ROLE_BROKER = "2";//经纪人默认权限
        String ROLE_NURSE = "3";//阿姨默认权限
    }

    interface OrderKey {
        String TYPE_DC = "1";//单次
        String TYPE_BY = "2";//包月
        String TYPE_FZD = "3";//非钟点

        
        String TYPE_BM = "1";//保姆预约
        String TYPE_YYS = "2";//育婴师预约
        String TYPE_MY = "3";//母婴护理员预约
        String TYPE_JJ = "4";//居家陪护预约
        String TYPE_ZDG = "5";//钟点工
        String TYPE_BYZDG = "6";//包月钟点工


        String STATUS_YYD_DCL = "1";//待处理/已预约
        String STATUS_YYD_DMS = "2";//待面试
        String STATUS_YYD_YMS = "3";//已面试
        String STATUS_YYD_FP_DJD = "4";//已分配阿姨待接单
        String STATUS_YYD_YJD = "5";//钟点工已接单可支付
        String STATUS_YYD_ZF = "66";//预约单已支付
        String STATUS_YYD_YTJ = "11";//预约单已提交不能再提交订单
        String STATUS_YYD_YJD_DCL = "12";//包月钟点工已接单等待经纪人操作


        String STATUS_DD_DZF = "6";//待支付
        String STATUS_DD_DFF = "7";//待服务
        String STATUS_DD_FFZ = "8";//上门服务
        String STATUS_DD_WC = "9";//完成


        String STATUS_CLOSED = "0";//结束


        String STATUS_STOP_SQ = "0";//申请
        String STATUS_STOP_TG = "1";//通过


//        String STATUS_DD_CJ = "";//订单刚创建未支付订金
//        String STATUS_WFF = "10";//未服务
//        String STATUS_FF = "1";//服务
//        String STATUS_FW_WC = "2";//服务完成
//        String STATUS_FW_WWC = "3";//服务未完成
//        String STATUS_SH_HR = "4";//售后换人状态
//        String STATUS_SH_TK = "5";//售后退款状态
//        String STATUS_SH_HR_YES = "6";//售后换人经纪人同意
//        String STATUS_SH_HR_NO = "7";//售后换人经纪人不同意
//        String STATUS_SH_HR_AY_YES = "8";//售后换人阿姨接单(包月)
//        String STATUS_SH_HR_AY_NO = "9";//售后换人阿姨不接单(包月)
//        String STATUS_SH_FB_AY_YES = "10";//售后换人阿姨同意(非标准)
//        String STATUS_SH_FB_AY_NO = "11";//售后换人阿姨不同意(非标准)
//        String STATUS_SH_FB_MS_YES = "12";//售后面试通过(非标准)
//        String STATUS_SH_FB_MS_NO = "13";//售后面试没通过(非标准)
//        String STATUS_CLOSED = "0";//结束
//
//
//        String NONST_ORDER_STATUS_AP = "1";//初始预约状态
//        String NONST_ORDER_STATUS_CL_YES = "2";// 经纪人接受订单
//        String NONST_ORDER_STATUS_CL_NO = "02";// 经纪人不接受
//        String NONST_ORDER_STATUS_AY_YES = "3";//该阿姨接单
//        String NONST_ORDER_STATUS_AY_NO = "03";//该阿姨不接单重新预约
//        String NONST_ORDER_STATUS_FA = "4";//安排面试
//        String NONST_ORDER_STATUS_JS = "5";//接受面试
//        String NONST_ORDER_STATUS_CLOSD = "6";//不接受面试结束
//        String NONST_ORDER_STATUS_FA_SU = "7";//面试成功
//        String NONST_ORDER_STATUS_FA_SB = "8";//面试失败
//        String NONST_ORDER_STATUS_FA_SB_CX = "9";//面试失败继续合作
//        String NONST_ORDER_STATUS_QTFWY_YES = "10";//是否有其他服务员
//        String NONST_ORDER_STATUS_FA_SB_NO = "0";//面试失败取消预约结束
//
//
//        String NONST_QUERY_TYPE_ALL = "0";//查询所有
//        String NONST_QUERY_TYPE_YYY = "1";//查询已预约
//        String NONST_QUERY_TYPE_DMS = "2";//查询待面试
//        String NONST_QUERY_TYPE_YMS = "3";//查询已面试
//
//
//        String ST_ORDER_TYPE_ONCE = "1"; //单次预约
//        String ST_ORDER_TYPE_MULTI = "2";//包月多次
//
//        String ST_ORDER_STATUS_AP = "1";//初始预约状态(未分配)
//        String ST_ORDER_STATUS_FP = "2";//预约状态(已分配)
//        String ST_ORDER_STATUS_JD = "3";//阿姨接单
//        String ST_ORDER_STATUS_CLOSED = "0";//结束
    }

    interface QuartzKey {
        String QUARTZ_GROUP_ASSIGN = "assign_order_group";

        String QUARTZ_GROUP_PAY = "assign_order_pay";

        String QUARTZ_GROUP_MONTH_FP = "assign_month_fp";

        String QUARTZ_GROUP_SENDMSG = "assign_group_sendmsg";


        String QUARTZ_TASK_TYPE_ZF_CANCEL = "orderCancel";//钟点预约未支付取消任务
        String QUARTZ_TASK_TYPE_FP = "yydfp";//预约单分配
        String QUARTZ_TASK_TYPE_SENDMSG = "sendmsg";//给经纪人发通知
        String QUARTZ_TASK_TYPE_MULTI_CANCEL = "multiWclCancel";//包月钟点未处理取消任务

    }


    interface WeiChatKey {

        String SERVICE_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
        int ADDRESS_TYPE = 4;
        int BROKER_TYPE = 2;
        int NURSE_TYPE = 3;
        int CUSTOMER_TYPE = 1;
        int JS_TICKET_TYPE = 5;

        int BROKER_AGENT_ID = 1000002;
        int NURSE_AGENT_ID = 1000003;


        String FACE_TMP_ID = "MVb-LpVigjDQlNGDLVXuSMCn_3LOOxlzMrAzE49XJRI";
        String ACCEPT_TMP_ID = "YYM3syWtW_PSbZIB2u_8x_e5B4spW2XbbIA3a6-vcFY";
        String JD_TMP_ID = "imkfH9ONV8czG6d4h2qKnJ8P4bxaQvjNznIwZuTwQis";

    }

    String ONCE = "单次";
    String MULTI = "包月";
    String NONSTD = "非标准";

    String NAME = "保洁";

    String CUSTOMER = "1";
    String BROKER = "2";
    String NURSE = "3";

    String ACTION_LOGIN = "1";
    String ACTION_REGISTER = "2";
}
