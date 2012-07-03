package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：User
 * 类描述：权限管理( 用户表 )
 * 创建人：hubin
 * 创建时间：2011.01.15
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class User {
	private String user_id; // 用户 ID
	private String user_name; // 姓名
	private String nick_name; // 昵称
	private String password; // 密码
	private int sex; // 性别
	private String city; // 城市
	private String phone; // 电话
	private String mail; // 邮箱
	private String qq; // QQ
	private String msn; // MSN
	private String phone_type; // 手机型号
	private String other; // 其他联系方式
	private int grade; // 积分
	private int gold_coin; // 金币
	private String rank; // 职衔
	private String home; // 主页
	private String create_date; // 创建时间
	private String login_date; // 登入时间
	private String last_login_date; // 上一次登入时间
	private int login_counts; // 登入次数
	private int state; // 状态
	
	private String authcode;// 验证码，非数据表字段

	
	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nickName) {
		nick_name = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getPhone_type() {
		return phone_type;
	}

	public void setPhone_type(String phoneType) {
		phone_type = phoneType;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGold_coin() {
		return gold_coin;
	}

	public void setGold_coin(int goldCoin) {
		gold_coin = goldCoin;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String createDate) {
		create_date = createDate;
	}

	public String getLogin_date() {
		return login_date;
	}

	public void setLogin_date(String loginDate) {
		login_date = loginDate;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String lastLoginDate) {
		last_login_date = lastLoginDate;
	}

	public int getLogin_counts() {
		return login_counts;
	}

	public void setLogin_counts(int loginCounts) {
		login_counts = loginCounts;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
