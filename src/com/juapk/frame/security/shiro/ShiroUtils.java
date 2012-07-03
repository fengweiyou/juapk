package com.juapk.frame.security.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * 项目名称：juapk
 * 类名称：ShiroUtils
 * 类描述：SHIRO 工具类 
 * 创建人：hubin
 * 创建时间：2012-02-16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class ShiroUtils {
	
	/**
	 * 获取用户名密码组合加密码 
	 * @param userName
	 * 				用户名
	 * @param passWord
	 * 				密码
	 * @return
	 */
	public static String getPassWord(String userName, String passWord) {
		return new Sha256Hash(userName, passWord).toBase64();
	}
	
	/**
	 * 获得 Sha256Hash 加密的随机密码
	 * @param password
	 * @return
	 */
	public static String getRandomPassword(String password){
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		Object salt = rng.nextBytes();
		return new Sha256Hash(password, salt, 1024).toBase64();
	}

	/**
	 * 程序入口：用于测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----- 加密码 -----" + getRandomPassword("666888"));
		System.out.println(" 组合加密码 ：" + getPassWord("juapk", "666888"));
	}
	
}