package com.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created on 2015-04-01
 * <p>Title:       Date工具类</p>
 * <p>Description: </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     东软软件股份有限公司</p>
 * <p>Department:  软件开发事业部</p>
 * @author         mosh
 * @version        1.0
 */
public class DateUtil {
	
	private static Log log = LogFactory.getLog(DateUtil.class);
	
	private static SimpleDateFormat DATE_FORMAT_ALL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private static SimpleDateFormat DATE_FORMAT_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat DATE_FORMAT_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat DATE_FORMAT_TIME = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * Description 获得当前系统Date
	 * @param
	 * @return Date
	 */
	public static Date getCurrentDate(){
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}
	
	/**
	 * Description 获得当前系统Date字符串
	 * @param
	 * @return Date
	 */
	public static String getCurrentDate(SimpleDateFormat format){
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();	
		return format.format(date);
	}
	
	/**
	 * Description 字符串转Date(根据pattern)
	 * @param str
	 * @param pattern
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date str2Date(String str,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			if(StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(pattern)){
				date = sdf.parse(str);
			}		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("[工具类日志]String转Date类型错误!"+ e.getMessage());
		}
		return date;
	}
	
	/**
	 * Description Date转字符串(根据pattern)
	 * @param date
	 * @param pattern
	 * @return Date
	 * @throws ParseException 
	 */
	public static String date2Str(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String str = "";
		if(StringUtils.isNotEmpty(pattern)){
			str = sdf.format(date);
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		System.out.println(DateUtil.str2Date("2014-04-26", "yyyy-MM-dd"));
		System.out.println(DateUtil.date2Str(DateUtil.str2Date("2014-04-26", "yyyy-MM-dd"), "yyyy-MM-dd"));
		
		
		
	}
}
