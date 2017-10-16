package com.hong.admin.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by syline on 2017/6/1.
 */
public class GeneralUtil {


    private static Map<String, String> statusMap = new HashMap<>();
    private static Map<String, String> weekMap = new HashMap<>();
    private static Map<String, String> orderTypeMap = new HashMap<>();
    private static Map<String, String> cityMap = new HashMap<>();

    private static Map<String, String> orderIdTypeMap = new HashMap<>();
    private static Map<String, String> cityIdMap = new HashMap<>();

    static {
        statusMap.put(Constant.OrderKey.STATUS_YYD_DCL, "已预约");
        statusMap.put(Constant.OrderKey.STATUS_YYD_DMS, "待面试");
        statusMap.put(Constant.OrderKey.STATUS_YYD_YMS, "已面试");
        statusMap.put(Constant.OrderKey.STATUS_YYD_FP_DJD, "待接单");
        statusMap.put(Constant.OrderKey.STATUS_YYD_YJD, "已接单");
        statusMap.put(Constant.OrderKey.STATUS_DD_DZF, "待支付");
        statusMap.put(Constant.OrderKey.STATUS_DD_DFF, "待服务");
        statusMap.put(Constant.OrderKey.STATUS_DD_FFZ, "服务中");
        statusMap.put(Constant.OrderKey.STATUS_DD_WC, "服务完成");
        statusMap.put(Constant.OrderKey.STATUS_CLOSED, "订单结束");
        statusMap.put(Constant.OrderKey.STATUS_YYD_ZF, "预约单已支付");
        statusMap.put(Constant.OrderKey.STATUS_YYD_YJD_DCL, "已接单待处理");


        orderTypeMap.put(Constant.OrderKey.TYPE_BM, "保姆");
        orderTypeMap.put(Constant.OrderKey.TYPE_YYS, " 育婴师");
        orderTypeMap.put(Constant.OrderKey.TYPE_MY, "母婴护理");
        orderTypeMap.put(Constant.OrderKey.TYPE_JJ, "居家陪护");
        orderTypeMap.put(Constant.OrderKey.TYPE_ZDG, "钟点工");
        orderTypeMap.put(Constant.OrderKey.TYPE_BYZDG, "包月钟点工");


        orderIdTypeMap.put("保姆", Constant.OrderKey.TYPE_BM);
        orderIdTypeMap.put("育婴师", Constant.OrderKey.TYPE_YYS);
        orderIdTypeMap.put("母婴护理", Constant.OrderKey.TYPE_MY);
        orderIdTypeMap.put("居家陪护", Constant.OrderKey.TYPE_JJ);
        orderIdTypeMap.put("钟点工", Constant.OrderKey.TYPE_ZDG);
        orderIdTypeMap.put("包月钟点工", Constant.OrderKey.TYPE_BYZDG);

        cityMap.put("1", "罗湖区");
        cityMap.put("2", "福田区");
        cityMap.put("3", "南山区");
        cityMap.put("4", "宝安区");
        cityMap.put("5", "光明新区");
        cityMap.put("6", "龙岗区");
        cityMap.put("7", "坪山新区");
        cityMap.put("8", "盐田区");
        cityMap.put("9", "龙华新区");
        cityMap.put("10", "大鹏新区");

        cityIdMap.put("罗湖区", "1");
        cityIdMap.put("福田区", "2");
        cityIdMap.put("南山区", "3");
        cityIdMap.put("宝安区", "4");
        cityIdMap.put("光明新区", "5");
        cityIdMap.put("龙岗区", "6");
        cityIdMap.put("坪山新区", "7");
        cityIdMap.put("盐田区", "8");
        cityIdMap.put("龙华新区", "9");
        cityIdMap.put("大鹏新区", "10");

        weekMap.put("1", "周一");
        weekMap.put("2", "周二");
        weekMap.put("3", "周三");
        weekMap.put("4", "周四");
        weekMap.put("5", "周五");
        weekMap.put("6", "周六");
        weekMap.put("7", "周日");

    }


    public static String getDateStr(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String getDateTimeStr(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }


    public static String getDateTimeWithNotSeStr(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }


    public static Date getDate(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDateTime(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Date getDateTimeWithNotSe(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取给定日期后面若干个星期固定的天数
     *
     * @param length
     * @param dayOfWeeks
     * @return
     */
    public static List<Date> getDays(Date date, int length, int[] dayOfWeeks) {
        List<Date> result = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null) {
            // 指定一个日期
            cal.setTime(date);
        }

//        // 年份
//        int year = cal.get(Calendar.YEAR);
//        System.out.println("year is = " + String.valueOf(year));
//
//        // 月份 (从0开始, 实际显示要加一)
//        int month = cal.get(Calendar.MONTH);

        //日期
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

//        cal.set(Calendar.YEAR, year);
//        cal.set(Calendar.MONTH, month);
        //从下单的第二天开始算起
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth + 1);

        Calendar c = (Calendar) cal.clone();
        c.add(Calendar.WEEK_OF_YEAR, length * 4);


        List<Integer> list = new ArrayList<>();
        for (int i : dayOfWeeks) {
            list.add(i);
        }
//        list.add(Calendar.MONDAY);
//        list.add(Calendar.WEDNESDAY);
//        list.add(Calendar.FRIDAY);

        while (!c.before(cal)) {
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if (list.contains(day)) {
                try {
                    result.add(dateFormat.parse(dateFormat.format(cal.getTime())));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            cal.add(Calendar.DATE, 1);
        }
        return result;
    }

    public static int getHour(String[] infos) {
        String hourStr = infos[0];
        int hour = Integer.parseInt(hourStr.substring(0, hourStr.indexOf(":")));
        return hour;
    }

    public static int getTime(String[] infos) {
        String timeStr = infos[1];
        int time = Integer.parseInt(timeStr.substring(0, timeStr.indexOf("小时")));
        return time;
    }

    /**
     * 计算两个日期的相隔天数
     *
     * @param date1
     * @param date2
     * @return
     * @author shijing
     * 2015年9月6日下午5:14:54
     */
    public static int daysBetween(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 退款的时候获取已经服务的次数
     *
     * @param dayOfWeeks
     * @return
     */
    public static int getServerDays(int[] dayOfWeeks, Date fromDate, int fromTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        int count = daysBetween(fromDate, cal.getTime());


        Calendar c = (Calendar) cal.clone();
        c.setTime(fromDate);
        c.add(Calendar.DAY_OF_YEAR, count);


        List<Integer> list = new ArrayList<>();
        for (int i : dayOfWeeks) {
            list.add(i + 1);
        }
        List<Date> result = new ArrayList<>();
        while (!c.before(cal)) {
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if (list.contains(day)) {
                result.add(cal.getTime());
                System.out.println(dateFormat.format(cal.getTime()));
            }
            cal.add(Calendar.DATE, 1);
        }

        if (result.contains(cal.getTime())) {
            if (cal.get(Calendar.HOUR_OF_DAY) < fromTime) {
                result.remove(cal.getTime());
            }
        }
        return result.size();
    }


    /**
     * 获取两个日期间既定的周期有多少天
     *
     * @param dayOfWeeks
     * @return
     */
    public static List<Date> getWeekDays(int[] dayOfWeeks, Date fromDate, Date toDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        cal.add(Calendar.DAY_OF_MONTH, 1);


        Calendar c = (Calendar) cal.clone();
        c.setTime(toDate);


        List<Integer> list = new ArrayList<>();
        for (int i : dayOfWeeks) {
            list.add(i + 1);
        }
        List<Date> result = new ArrayList<>();
        while (!c.before(cal)) {
            int day = cal.get(Calendar.DAY_OF_WEEK);
            if (list.contains(day)) {
                result.add(cal.getTime());
            }
            cal.add(Calendar.DATE, 1);
        }

        return result;
    }


    /**
     * 获取两个日期之间的所有日期
     *
     * @param fromDate
     * @param endDate
     * @return
     */
    public static List<Date> getDateListBetweenTwoDate(Date fromDate, Date endDate) {
        List<Date> result = new ArrayList<>();
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(fromDate);

        Calendar endCal = (Calendar) fromCal.clone();
        endCal.setTime(endDate);
        while (!endCal.before(fromCal)) {
            result.add(fromCal.getTime());
            fromCal.add(Calendar.DATE, 1);
        }
        return result;
    }


    /**
     * 获取两个日期之间的所有日期开始日期加一天
     *
     * @param fromDate
     * @param endDate
     * @return
     */
    public static List<Date> getDateListBetweenTwoDateAddOne(Date fromDate, Date endDate) {
        List<Date> result = new ArrayList<>();
        Calendar fromCal = Calendar.getInstance();
        fromCal.setTime(fromDate);
        fromCal.add(Calendar.DAY_OF_MONTH, 1);

        Calendar endCal = (Calendar) fromCal.clone();
        endCal.setTime(endDate);
        while (!endCal.before(fromCal)) {
            result.add(fromCal.getTime());
            fromCal.add(Calendar.DATE, 1);
        }
        return result;
    }


    public static String getSatusName(String status) {
        return statusMap.get(status);
    }


    public static String getOrderTypeName(String type) {
        return orderTypeMap.get(type);
    }


    public static String formatTosepara(int data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }

    /**
     * 获取文件名字的后缀
     *
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 获取文件名字的后缀
     *
     * @return
     */
    public static String getSuffix(File file) {
        return getSuffix(file.getName());
    }


    public static String getCityName(String type) {
        return cityMap.get(type);
    }


    public static String getNamesByTypes(String type, String types) {
        String[] typeArray = types.split(",");
        String typeNames = "";
        if (type.equals("service")) {
            for (String str : typeArray) {
                typeNames += " " + GeneralUtil.getOrderTypeName(str);
            }
        } else if (type.equals("city")) {
            for (String str : typeArray) {
                typeNames += " " + GeneralUtil.getCityName(str);
            }
        }
        return typeNames;
    }

    public static String getVerifyCode() {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        // 生成6位验证码
        for (int i = 0; i < 6; i++) {
            code.append(String.valueOf(random.nextInt(10)));
        }
        return code.toString();
    }


    public static String urlEncode(String source, String encode) {
        String result = source;
        try {
            result = URLEncoder.encode(source, encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static Date getFirstDayOfMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        Date firstDate = c.getTime();
        return getDate(getDateStr(firstDate));
    }


    public static Date getLastDayOfMonth() {
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDate = ca.getTime();
        return getDate(getDateStr(lastDate));
    }


    public static Date getThirtyDateTime() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.SECOND, 1740);
        return ca.getTime();
    }

    public static Date getTwoDayDateTime() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DAY_OF_YEAR, 2);
        return ca.getTime();
    }

    public static Date getTwoHourDateTime() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.HOUR_OF_DAY, 2);
        return ca.getTime();
    }


    public static String getWeekStr(String serviceWeek) {
        String[] strs = serviceWeek.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(weekMap.get(str)).append(" ");
        }
        return sb.toString();
    }


    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public static boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            return false;
        }
        return true;
    }


    public static String getTypeIdByName(String name) {
        String[] arr = name.split(",");
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            if (StringUtils.isEmpty(sb.toString())) {
                sb.append(orderIdTypeMap.get(str));
            } else {
                sb.append(",").append(orderIdTypeMap.get(str));
            }
        }
        return sb.toString();
    }


    public static String getCityIdByName(String name) {
        String[] arr = name.split(",");
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            if (StringUtils.isEmpty(sb.toString())) {
                sb.append(cityIdMap.get(str));
            } else {
                sb.append(",").append(cityIdMap.get(str));
            }
        }
        return sb.toString();
    }

}
