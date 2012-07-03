package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：SoftSort
 * 类描述：软件类型表
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftSort {
	private String soft_sort_id;
	private int soft_type;
	private String name;
	private int location;
	private int state;
	private int amount;
	
	public String getSoft_sort_id() {
		return soft_sort_id;
	}
	public void setSoft_sort_id(String softSortId) {
		soft_sort_id = softSortId;
	}
	public int getSoft_type() {
		return soft_type;
	}
	public void setSoft_type(int softType) {
		soft_type = softType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}