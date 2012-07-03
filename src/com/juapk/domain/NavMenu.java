package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：NavMenu
 * 类描述：导航菜单表
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class NavMenu {
	private int id;
	private String name;
	private String href;
	private int rank;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}