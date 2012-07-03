package com.juapk.frame.security;

/**
 * 项目名称：juapk
 * 类名称：MD5
 * 类描述：MD5 密码加密
 * 创建人：hubin
 * 创建时间：2011-12-25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class MD5 {

	/**
	 * 获得加密字符串
	 * @param String 加密字符串
	 * @return String 加密后的字符串
	 */
	public static String getMD5Str(String string) {
		String s = null;
		char hexDigits[] = { '0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(string.getBytes());
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return s;
	}

	// MD5 加密测试
	public static void main(String[] args) {
		System.out.println(getMD5Str("www.juapk.com"));
	}
	
}
