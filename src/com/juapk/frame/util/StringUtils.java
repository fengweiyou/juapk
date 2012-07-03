package com.juapk.frame.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author HUBIN
 * @version 1.0
 * @since 2011-11-29
 */
public class StringUtils {
	
	/**
	 * 关键字过滤
	 * @param regx
	 * @param keywords
	 * @param replaceStr
	 * @return
	 */
	public static String replaceKeywords(String[] regx, String keywords,
			String replaceStr) {
		String regxValue = "";
		String value = keywords.toLowerCase();
		for (int i = 0; i < regx.length; i++) {
			regxValue = regx[i];
			Pattern p = Pattern.compile(regxValue);
			Matcher match = p.matcher(value);
			value = match.replaceAll(replaceStr);
		}
		return value;
	}
	
	/**
	 * 数组转换为字符串
	 * @param strArray
	 * 				字符串数组
	 * @param separator
	 * 				元素分割字符串
	 * @return String 
	 */
	public static String arrayToString(String[] strArray, String separator){
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<strArray.length;i++){
			sb.append(strArray[i]).append(separator);
		}
		sb.deleteCharAt(sb.length() - 1);
		
		return sb.toString();
	}
	
	/**
	 * 添加=""号
	 * @param  sourceString
	 * 				转换字符串
	 * @return String 
	 */
	public static String addSingleQuotes(String sourceString) {
		String regx = "\\d";
		Pattern p = Pattern.compile(regx);
		Matcher match = p.matcher(sourceString);
		boolean exist = match.find();

		if (exist) {
			sourceString = "=\"" + sourceString;
			sourceString += "\"";
		}
		return sourceString;
	}

	/**
	 * 删=""号
	 * @param  sourceString
	 * 				转换字符串
	 * @return String 
	 */
	public static String delSingleQuotes(String sourceString) {
		String regx = "=\"";
		Pattern p = Pattern.compile(regx);
		Matcher match = p.matcher(sourceString);
		boolean exist = match.find();

		if (exist) {
			sourceString = match.replaceFirst("");
			sourceString = sourceString.substring(0, sourceString.length() - 1);
		}
		return sourceString;
	}
	
	/**
	 * 去掉逗号
	 * @param  sourceString
	 * 				转换字符串
	 * @return String
	 */
	public static String trimCommaSeparatedValues(String sourceString) {
		String regx = ",";
		Pattern p = Pattern.compile(regx);
		Matcher match = p.matcher(sourceString);
		match.find();
		sourceString = match.replaceAll(" ");
		return sourceString;
	}
	
}