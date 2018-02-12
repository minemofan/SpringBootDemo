package com.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created on 2015-04-01
 * <p>Title:       String工具类（扩展Apache StringUtils）</p>
 * <p>Description: </p>
 * <p>Copyright:   Copyright (c) 2015</p>
 * <p>Company:     东软软件股份有限公司</p>
 * <p>Department:  软件开发事业部</p>
 * @author         mosh
 * @version        1.0
 */
public class StringUtil extends StringUtils {
	
	
	/**
	 * Description 判断字符串是否为null，如果null返回空串
	 * @param str
	 * @return 
	 */
	public static String isEmptyToBlank(String str){
		if(StringUtils.isEmpty(str)){
			return "";
		}
		return str;
	}
	
	/**
	 * Description 判断字符串起始位置是否存在两个“/”，如果存在则删掉一个
	 * @param str
	 * @return
	 */
	public static String removeSprit(String str){
		if(str.indexOf("/")==0 && str.lastIndexOf("/")==1){
			return str.substring(1, str.length());
		}
		return str;
	}
	

}
