package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：SoftTop
 * 类描述：排行软件表
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftTop {
	private String soft_top_id;
	private String soft_id;
	private int type;
	
	public String getSoft_top_id() {
		return soft_top_id;
	}
	public void setSoft_top_id(String softTopId) {
		soft_top_id = softTopId;
	}
	public String getSoft_id() {
		return soft_id;
	}
	public void setSoft_id(String softId) {
		soft_id = softId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}