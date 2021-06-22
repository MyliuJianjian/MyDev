package com.my.common;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月22日11:02:42$
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Peng Jian
 * @date: 2018/6/19 9:21
 * @description: 日期工具类
 */
public abstract class DateUtil extends DateUtils {

    private static final Log logger = LogFactory.getLog(DateUtil.class);

    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_CH_YYYY_MM_DD = "yyyy年MM月dd日";
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.S";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYY_MM = "yyyy-MM";
    public static final String FORMAT_TIME = "HH:mm:ss";
    public static final String FORMAT_DAYTIME_START = "00:00:00";
    public static final String FORMAT_DAYTIME_END = "23:59:59";


    /**
     * 字符串、日期格式 转换日期
     *
     * @param format 例如: "yyyy-MM-dd HH:mm:ss"
     * @param str    例如: "2012-12-03 23:21:24"
     */
    public static Date convert(String str, String format) {
        if (!StringUtils.isEmpty(str)) {
            try {
                Date date = new SimpleDateFormat(format).parse(str);
                return date;
            } catch (ParseException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn(e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * 将日期转换成format字符串
     *
     * @param date       例如: Sun Jun 10 09:18:00 CST 2018
     * @param dateFormat 例如: "yyyy-MM-dd HH:mm:ss"
     */
    public static String convert(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        if (null == dateFormat) {
            dateFormat = FORMAT_YYYY_MM_DD_HH_MM_SS;
        }
        return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * 根据传入的日期  转换成这样格式的字符串 如：“yyyy-MM-dd HH:mm:ss”
     */
    public static String convert(Date date) {
        return convert(date, FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 根据传入的日期返回年月日的6位字符串，例：20101203
     */
    public static String getDay(Date date) {
        return convert(date, FORMAT_YYYYMMDD);
    }

    /**
     * 根据传入的日期返回中文年月日字符串，例：2010年12月03日
     */
    public static String getChDate(Date date) {
        return convert(date, FORMAT_CH_YYYY_MM_DD);
    }

    /**
     * 返回该天从00:00:00开始的日期
     */
    public static Date getStartDatetime(Date date) {
        String thisDate = convert(date, FORMAT_YYYY_MM_DD);
        return convert(thisDate + " " + FORMAT_DAYTIME_START,FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 返回该天到23:59:59结束的日期
     */
    public static Date getEndDatetime(Date date) {
        String thisDate = convert(date, FORMAT_YYYY_MM_DD);
        return convert(thisDate + " " + FORMAT_DAYTIME_END,FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 返回n天到23:59:59结束的日期
     */
    public static Date getEndDatetime(Date date, Integer diffDays) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
        String thisDate = dateFormat.format(date.getTime() + MILLIS_PER_DAY * diffDays);
        return convert(thisDate + " " + FORMAT_DAYTIME_END,FORMAT_YYYY_MM_DD_HH_MM_SS);
    }


    /**
     * 将传入的时间格式的字符串转成时间对象      例如：传入2012-12-03 23:21:24
     */
    public static Date strToDate(String dateStr) {
        SimpleDateFormat formatDate = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
        Date date = null;
        try {
            date = formatDate.parse(dateStr);
        } catch (Exception e) {

        }
        return date;
    }

    /**
     * 相对当前日期，增加或减少天数
     */
    public static String addDay2Date(Date date, int day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
        return simpleDateFormat.format(new Date(date.getTime() + MILLIS_PER_DAY * day));
    }

    /**
     * 相对当前日期，增加或减少天数
     */
    public static Date addDay2Time(Date date, int day) {
        return new Date(date.getTime() + MILLIS_PER_DAY * day);
    }

    /**
     * 返回两个时间的相差天数
     */
    public static Long getDayDiff(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / MILLIS_PER_DAY;
    }

    /**
     * 返回两个时间的相差分钟数
     */
    public static Long getMinuteDiff(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / MILLIS_PER_MINUTE;
    }

    /**
     * 返回两个时间的相差秒数
     */
    public static Long getSecondDiff(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / MILLIS_PER_SECOND;
    }

    /**
     * 返回两个时间的相差月数
     */
    public static int getMonthDiff(Date startTime, Date endTime) {
        int months = 0;
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);
        endCalendar.setTime(endTime);
        months = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return months;
    }


    /*public static void main(String[] args) throws Exception {
        System.out.println("String:"+convert("2021-06-22 11:28:00", FORMAT_YYYY_MM_DD_HH_MM_SS));

        System.out.println("Date:"+convert(new Date(), FORMAT_YYYY_MM_DD_HH_MM_SS));

        System.out.println("convert:"+convert(new Date()));

        System.out.println("getDay:"+getDay(new Date()));

        System.out.println("getChDate:"+getChDate(new Date()));

        System.out.println("getStartDatetime:"+getStartDatetime(new Date()));

        System.out.println("getEndDatetime:"+getEndDatetime(new Date()));

        System.out.println("getEndDatetime:"+getEndDatetime(new Date(),7));

        System.out.println("strToDate:"+strToDate("2021-06-22 11:38:12"));

        System.out.println("addDay2Date:"+addDay2Date(new Date(),-7));

        System.out.println("addDay2Time:"+addDay2Time(new Date(),-7));

        System.out.println("getDayDiff:"+getDayDiff(addDay2Time(new Date(),-7),new Date()));

        System.out.println("getMinuteDiff:"+getMinuteDiff(addDay2Time(new Date(),-7),new Date()));

        System.out.println("getSecondDiff:"+getSecondDiff(addDay2Time(new Date(),-7),new Date()));

        System.out.println("getMonthDiff:"+getMonthDiff(addDay2Time(new Date(),-7),new Date()));

    }*/
}
