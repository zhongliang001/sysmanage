package com.zl.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author zhongliang
 */
public class DateUtil {

    /**
     * 默认时间格式
     */
    public static final String DEFALT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 计算两个时间差
     *
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(Date startTime, Date endTime) {
        long start = startTime.getTime();
        long end = endTime.getTime();
        return end - start;
    }

    /**
     * 从date 到当前时间的时间差
     *
     * @param date 起始日期
     * @return 时间相差毫秒数
     */
    public static long getTimeDifToNow(Date date) {
        return getTimeDif(date, new Date());
    }

    /**
     * 从date 到当前时间的时间差
     *
     * @param dateString 时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDifToNow(String dateString) throws ParseException {
        return getTimeDifToNow(dateString, DEFALT_FORMAT);
    }

    /**
     * 从date 到当前时间的时间差
     *
     * @param dateString 时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDifToNow(String dateString, String format) throws ParseException {
        return getTimeDifToNow(parse(dateString, format));
    }

    /**
     * 从date 从当前时间的到date的时间差
     *
     * @param date 结束日期
     * @return 时间相差毫秒数
     */
    public static long getTimeDifFromNow(Date date) {
        return getTimeDif(new Date(), date);
    }

    /**
     * 从date 从当前时间的到date的时间差
     *
     * @param dateString 时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDifFromNow(String dateString) throws ParseException {
        return getTimeDifFromNow(dateString, DEFALT_FORMAT);
    }

    /**
     * 从date 从当前时间的到date的时间差
     *
     * @param dateString 时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDifFromNow(String dateString, String format) throws ParseException {
        return getTimeDifFromNow(parse(dateString, format));
    }

    /**
     * 计算两个时间差
     *
     * @param start 起始时间字符串
     * @param end   结束时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(String start, String end) throws ParseException {
        return getTimeDif(start, end, DEFALT_FORMAT);
    }

    /**
     * 计算两个时间差
     *
     * @param start   起始时间字符串
     * @param format1 时间格式
     * @param end     结束时间字符串
     * @param format2 时间格式
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(String start, String format1, String end, String format2) throws ParseException {
        return getTimeDif(parse(start, format1), parse(end, format2));
    }

    /**
     * 计算两个时间差
     *
     * @param start  起始时间字符串
     * @param end    结束时间字符串
     * @param format 时间格式
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(String start, String end, String format) throws ParseException {
        return getTimeDif(start, format, end, format);
    }

    /**
     * 计算两个时间差
     *
     * @param start  起始时间字符串
     * @param end    结束时间字符串
     * @param format 时间格式
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(Date start, String end, String format) throws ParseException {
        return getTimeDif(start, parse(end, format));
    }

    /**
     * 计算两个时间差
     *
     * @param start 起始时间字符串
     * @param end   结束时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(Date start, String end) throws ParseException {
        return getTimeDif(start, end, DEFALT_FORMAT);
    }

    /**
     * 计算两个时间差
     *
     * @param start  起始时间字符串
     * @param end    结束时间字符串
     * @param format 时间格式
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(String start, String format, Date end) throws ParseException {
        return getTimeDif(parse(start, format), end);
    }

    /**
     * 计算两个时间差
     *
     * @param start 起始时间字符串
     * @param end   结束时间字符串
     * @return 时间相差毫秒数
     */
    public static long getTimeDif(String start, Date end) throws ParseException {
        return getTimeDif(start, DEFALT_FORMAT, end);
    }

    /**
     * 比较两个时间
     *
     * @param date1 起始时间
     * @param date2 结束时间
     * @return -1: date1 < date2 0: date1=date2 1: date1 > date2
     */
    public static int compareDate(Date date1, Date date2) {
        return date1.compareTo(date2);
    }

    /**
     * 比较两个时间
     *
     * @param dateStr1 起始时间
     * @param format1  时间格式
     * @param dateStr2 结束时间
     * @param format2  时间格式
     * @return -1: date1 < date2 0: date1=date2 1: date1 > date2
     */
    public static int comparerDate(String dateStr1, String format1, String dateStr2, String format2) throws ParseException {
        Date date1 = parse(dateStr1, format1);
        Date date2 = parse(dateStr2, format2);
        return date1.compareTo(date2);
    }

    /**
     * 比较两个时间
     *
     * @param dateStr1 起始时间
     * @param dateStr2 结束时间
     * @param format   时间格式
     * @return -1: date1 < date2 0: date1=date2 1: date1 > date2
     */
    public static int comparerDate(String dateStr1, String dateStr2, String format) throws ParseException {
        Date date1 = parse(dateStr1, format);
        Date date2 = parse(dateStr2, format);
        return comparerDate(dateStr1, format, dateStr2, format);
    }

    /**
     * 比较两个时间
     *
     * @param dateStr1 起始时间
     * @param dateStr2 结束时间
     * @return -1: date1 < date2 0: date1=date2 1: date1 > date2
     */
    public static int comparerDate(String dateStr1, String dateStr2) throws ParseException {
        return comparerDate(dateStr1, DEFALT_FORMAT, dateStr2, DEFALT_FORMAT);
    }

    /**
     * 将字符串解析为时间
     *
     * @param dateString 时间字符串
     * @param format     时间格式
     * @return 时间
     * @throws ParseException 格式化异常
     */
    public static Date parse(String dateString, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }

    /**
     * date 加上num天
     *
     * @param date 指定日期
     * @param num  指定天数
     * @return 加上num天后的日期
     */
    public static Date addDay(Date date, int num) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, num);
        return calendar.getTime();
    }

    /**
     * date 加上num天
     *
     * @param date   指定日期
     * @param format 日期格式
     * @param num    指定天数
     * @return 加上num天后的日期
     */
    public static Date addDay(String date, String format, int num) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(parse(date, format));
        calendar.add(Calendar.DATE, num);
        return calendar.getTime();
    }

    /**
     * date 加上num天
     *
     * @param date 指定日期
     * @param num  指定天数
     * @return 加上num天后的日期
     */
    public static Date addDay(String date, int num) throws ParseException {
        return addDay(date, DEFALT_FORMAT, num);
    }

    /**
     * 将字符串解析为时间
     *
     * @param dateString 时间字符串
     * @return 时间
     * @throws ParseException 格式化异常
     */
    public static Date parse(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFALT_FORMAT);
        return sdf.parse(dateString);
    }

    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFALT_FORMAT);
        return sdf.format(date);
    }

    public static String format(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
