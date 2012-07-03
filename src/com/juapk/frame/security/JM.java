package com.juapk.frame.security;

/**
 * 项目名称：juapk
 * 类名称：JM
 * 类描述：JM 数字加密（该算法只加密数字）
 * 创建人：hubin
 * 创建时间：2011-12-25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class JM {
	private int needjam; // 用户输入的需要被加密的数字
	private String overjam = ""; // 加密过的数字
	private String needjem = ""; // 需要被解密的数字
	private int overjem; // 解密后的数字
	private int key[] = { 3, 9, 13, 7 }; // 密钥
	private int paramValue = 666888; // 辅助参数
	
	public JM() {
	}
	
	public JM(int needjam){
		this.needjam = needjam;
	}
	
	/**
	 * 加密设置
	 * @param int 需要被加密的数字
	 */
	public void setNeedjam(int needjam) {
		this.needjam = needjam;
		jam_num();
	}
	
	/**
	 * 获取加密数字
	 * @return int 需要被加密的数字
	 */
	public int getNeedjam() {
		return this.needjam;
	}

	/**
	 * 获取密文
	 * @return String 加密后的字符串
	 */
	public String getOverjam() {
		return this.overjam;
	}

	/**
	 * 解密设置
	 * @param String 加密后的字符串
	 */
	public void setNeedjem(String needjem) {
		this.needjem = needjem;
		jem_num();
	}

	/**
	 * 获取明文
	 * @param int 加密的数字
	 */
	public int getOverjem() {
		return this.overjem;
	}

	/**
	 * 以下代码为加密代码，先来了解一下加密的算法。
	 * 首先定义一个密钥：{0~15，0~15，0~15，0~15}。该密钥为一个整型数组，其中的每个元素为0~15之间的整数。
  	 * 然后通过下面的算法得到一个值y：2*x+666888=y。其中的x为用户输入的转换成整型后的密码。
	 * 接下来对数值y进行加密操作。
	 * 其中用到了toBinaryString()方法，其语法格式如下：Integer.toBinaryString(int i)
	 * 功能：将整型转换成二进制，返回值为字符型。
	 * 参数说明：变量为i为要被转换的整数。
	 */
	private void jam_num() {
		int y = 2 * needjam + paramValue;
		String b_needjam = Integer.toBinaryString(y);
		int ys = b_needjam.length() % 4;
		int i = 0;
		if (ys != 0) { // 进行填“0”补充
			while (i < 4 - ys) {
				b_needjam = "0" + b_needjam;
				i++;
			}
		}// if(ys!=0)
		i = 0;
		int k = 0;
		String sub_b_needjam = "";
		String sub_overjam_str = "";
		while (i < b_needjam.length()) { // 从左向右每次取出4位
			sub_b_needjam = b_needjam.substring(i, i + 4); // 取出4位
			int sub_overjam_num = strbintoint(sub_b_needjam); // 将取出的二进制转换成对应的整型
			sub_overjam_str += (sub_overjam_num ^ key[k]); // 与密钥进行异或运算
			sub_overjam_str += "%";
			if (k < 3) { // 获取下一个密钥值
				k++;
			} else {
				k = 0;
			}
			i = i + 4;
		}// while
		this.overjam = sub_overjam_str.substring(0,
				sub_overjam_str.length() - 1);
	}

	/**
	 * 将二进制转换成对应整型的方法
	 * @param substr 需要转换的字符串
	 * @return
	 */
	private int strbintoint(String substr) {
		int pos = 0; // 在二进制中“1”出现的位置
		int temp = 0; // 二进制转换成的整数
		int sublength = substr.length();
		while ((pos = substr.indexOf("1", pos)) >= 0) {
			if (pos == sublength - 1) { // 如：0001转换成十进制为1
				temp += 1;
			} else {
				temp += Math.pow(2, sublength - 1 - pos); // 如：1110转换成十进制为：(2的三次方)+(2的平方)+(2的一次方)
			}
			pos++;
		}
		return temp;
	}

	/**
	 * 以下代码为解密代码，先来了解一下解密的算法。
	 * ①获取需要解密的字符串：needjem。
	 * ②以“%”为分隔符将needjem转换为字符串数组：needjem_array。
	 * ③以i（初始值为0）为数组元素标记取出一个数组元素转换成整数后与密钥进行异或运算得到一个整数值：sub_int。
	 * ④将sub_int转换成二进制：sub_binary。
	 * ⑤如果sub_binary的长度小于4，在sub_binary的左边补充（4-sub_binary.length()）个“0”。
	 * ⑥将一个已定义的字符串型变量over_jem_b_str在原来的基础上加上sub_binary。
	 * ⑦获取下一个密钥值；并将i加1，如果i小于数组needjem_array的长度，那么重新回到步骤③，否则跳到步骤⑧。
	 * ⑧将字符串变量over_jem_b_str转换成对应的十进制数值：y。
	 * ⑨在y=2*x+1234567算法中，通过y求出x的值，x即为被加密前的数值。
	 */
	private void jem_num() {
		String over_jem_b_str = "";
		String needjem_array[] = this.needjem.split("%");
		int i = 0;
		int k = 0;
		int length = needjem_array.length;
		int sub_needjem = 0;
		while (i < length) {
			sub_needjem = Integer.parseInt(needjem_array[i]);
			String temp = Integer.toBinaryString(sub_needjem ^ key[k]);
			int templength = temp.length();
			if (templength < 4) {
				int j = 0;
				while (j < 4 - templength) {
					temp = "0" + temp;
					j++;
				}
			}
			over_jem_b_str += temp;
			if (k < 3) {
				k++;
			} else {
				k = 0;
			}
			i++;
		}// while
		int yy = strbintoint(over_jem_b_str);
		this.overjem = (yy - paramValue) / 2;
	}
	
	// JM 加密运算
	public static void main(String[] args) {
		JM jm = new JM();
		int j = 100001002;
		// ---------------------------加密---------------------------------
		jm.setNeedjam(j);
		String jam=jm.getOverjam();
		System.out.println("JM加密数字"+j+"后为：tp="+jam);
		// ---------------------------解密---------------------------------
		jm.setNeedjem(jam);
		System.out.println("JM解密字符串"+jam+"后为："+jm.getOverjem());
	}
	
}
