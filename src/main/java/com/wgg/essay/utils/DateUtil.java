package com.wgg.essay.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {
	
	/* 
     * 将时间转换为yyyy-MM-dd HH:mm:ss
     */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/* 
     * 将字符串转为date
     */
	public static Date stringToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.parse(str);
	}

	/* 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(Date date){
        long ts = date.getTime();
        return String.valueOf(ts);
    }
    
    /* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
    /* 
     * 改变时间
     */
    public static Date changeDate(Date date,int calenderType,int num) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(calenderType, num);
    	date = calendar.getTime();
    	return date;
    }
}
