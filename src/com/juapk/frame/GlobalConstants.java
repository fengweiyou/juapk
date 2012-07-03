package com.juapk.frame;

/**
 * 项目名称：juapk
 * 类名称：GlobalConstants
 * 类描述：全局常量类 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:38:40
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class GlobalConstants {
	public static final String CURRENT_USER = "shiroUserName";
	// ALERT MSG 提示信息
	public static final String ALERT_MSG = "alertMsg"; // alert msg
	public static final int ALERT_ERROR = 0; // Error or danger
	public static final int ALERT_SUCCESS = 1; // Success
	public static final int ALERT_INFO = 2; // Information
	
	// PROMPT_MSG 文字提示信息
	public static final String PROMPT_MSG = "promptMsg";
	
	// Header当前位置
	public static final String HEADER_LOCATION = "wz";
	public static final String HEADER_INDEX = "0";
	public static final String HEADER_APP = "1";
	public static final String HEADER_GAME = "2";
	public static final String HEADER_TOPIC = "3";
	public static final String HEADER_DEV = "4";
	
	// MOB标题栏
	public static final String MOB_TITLE = "mt";
	public static final String MOB_TITLE_COMMEND = "0";
	public static final String MOB_TITLE_NEW = "1";
	public static final String MOB_TITLE_SORT = "2";
	
	// 中部位置广告: BANNAER
	public static final int Bannaer = 1;
	
	// 软件类型
	public static final String SOFT_TYPE_FLAG = "stf";
	public static final String SOFT_HOT = "hot"; // 最热软件
	public static final String SOFT_NEW = "new"; // 最新软件
	public static final String SOFT_TYPE_APP = "0";	// 应用型软件
	public static final String SOFT_TYPE_GAME = "1"; // 游戏型软件
	public static final int SOFT_TYPE_COMMEND = 2;	// 推荐
	public static final int SOFT_TYPE_NEW_APP = 3;	// 最新应用
	public static final int SOFT_TYPE_NEW_GAME = 4;	// 最新游戏
	public static final int SOFT_TYPE_SEARCH = 5;	// 查询
	
	// 专题类型
	public static final String TOPIC_TYPE_FLAG = "ttf";
	public static final int TOPIC_TYPE_SOFT = 0; // 专题推荐软件
	
	// Top 软件排行
	public static final int TOP_SOFT_TODAY = 0;	// 日排行（前日）
	public static final int TOP_SOFT_WEEK = 1;	// 周排行
	public static final int TOP_SOFT_MONTH = 2;	// 月排行
	
	// Topic 专题列表
	public static final int TOPIC_STATE_ON = 1; // 启动状态
	public static final int TOPIC_COMMEND_A = 1; // 推荐专题 A
	public static final int TOPIC_COMMEND_B = 2; // 推荐专题 B
	public static final int TOPIC_COMMEND_C = 3; // 推荐专题 C
	
	// ----  验证码  VERIFYCODE ------
	public static final String VERIFYCODE = "verifycode";
	
	//================================ 后台常量  ================================
	public static final long ADMIN_NAV_MENU_INIT = 0; //NAV菜单默认navMenuId=0
	public static final long ADMIN_TREE_MENU_TAB = 0; //一级TAB切换菜单默认值PID=0
	
}