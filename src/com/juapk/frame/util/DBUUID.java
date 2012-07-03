package com.juapk.frame.util;


/**
 * 项目名称：juapk
 * 类名称：DBUUID
 * 类描述：获取 ID 工具类 
 * 创建人：hubin
 * 创建时间：2011-11-29
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class DBUUID {
  
  /**
   * 获取全局唯一 ID
   * @return String
   */
  public static String getID() {
    UUIDHexGenerator uuidHex = new UUIDHexGenerator();
    return uuidHex.generate().toString();
  }
  
  /**
   * 程序入口：用于测试
   * @param args
   */
  public static void main(String[] args) {
	  System.out.println(" 系统全局唯一 ID ：" + getID());
  }
  
}
