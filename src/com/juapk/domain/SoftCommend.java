package com.juapk.domain;

import java.sql.Date;

/**
 * 项目名称：juapk
 * 类名称：SoftCommend
 * 类描述：推荐软件表
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftCommend {
	private String soft_commend_id;
	private String soft_id;
	private String user_id;
	private int level;
	private int state;
	private Date commend_date;
	
	public String getSoft_commend_id() {
		return soft_commend_id;
	}
	public void setSoft_commend_id(String softCommendId) {
		soft_commend_id = softCommendId;
	}
	public String getSoft_id() {
		return soft_id;
	}
	public void setSoft_id(String softId) {
		soft_id = softId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCommend_date() {
		return commend_date;
	}
	public void setCommend_date(Date commendDate) {
		commend_date = commendDate;
	}
}