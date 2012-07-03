package com.juapk.frame.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 验证工具类
 * @ClassName: RegularUtils
 * @Description: 
 * @author HUBIN
 * @date 2012-4-26下午06:21:54
 */
public class RegularUtils {
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		String email = "hubin@hc360.com";
		System.out.println(isEmail(email));
		String mobile = "18611561157";
		System.out.println(isTelePhoneNumber(mobile));
	}
	
	/**
	 * 验证是否是正确的邮箱格式
	 * @param email
	 * 				电子邮箱
	 * @return	boolean
	 * 
	 * 	true表示是正确的邮箱格式,false表示不是正确邮箱格式
	 */
	public static boolean isEmail(String email){
		// 1、\\w+表示@之前至少要输入一个匹配字母或数字或下划线
		// 2、(\\w+\\.)表示域名. 为了适应新浪邮箱域名 sina.com.cn
		//	      所以后面{1,3}表示可以出现一次或两次或者三次.
		String regular = "\\w+@(\\w+\\.){1,3}\\w+";
		Pattern pattern = Pattern.compile(regular);
		boolean flag = false;
		if( email != null ){
			Matcher matcher = pattern.matcher(email);
			flag = matcher.matches();
		}
		return flag;
	}
	
	/**
	 * 验证是否是正确的手机号格式
	 * @param telePhoneNumber
	 * 				电话号码
	 * @return	boolean
	 * 
	 * 	true表示是正确的手机号格式,false表示不是正确的手机号格式
	 */
	public static boolean isTelePhoneNumber(String telePhoneNumber){
		//当前运营商号段分配
		//中国移动号段 1340-1348 135 136 137 138 139 150 151 152 157 158 159 187 188 147
		//中国联通号段 130 131 132 155 156 185 186 145
		//中国电信号段 133 1349 153 180 189
		String regular = "1[3,4,5,8]{1}\\d{9}";
		Pattern pattern = Pattern.compile(regular);
		boolean flag = false;
		if( telePhoneNumber != null ){
			Matcher matcher = pattern.matcher(telePhoneNumber);
			flag = matcher.matches();
		}
		return flag;
	}

}
