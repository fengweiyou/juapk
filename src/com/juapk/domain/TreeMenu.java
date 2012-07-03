package com.juapk.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：juapk
 * 类名称：TreeMenu
 * 类描述：DWZ中左边树形结构菜单表
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:58:22
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TreeMenu {
	private Long id; //树形结构菜单 ID
	private Long nav_menu_id; //导航菜单ID
	private String name; //菜单名
	private String target = "navTab"; //navTab或dialog
	private String rel; //navTabId
	private String reloadFlag = "1"; //是否自动刷新
	private String external = "false"; //是否是外部页
	private String href; //跳转路径
	private Long pid; //父ID
	private int rank; //排序
	private int width; //对话框宽度
	private int height; //对话框高度
	private List<TreeMenu> children = new ArrayList<TreeMenu>();//孩子菜单们
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNav_menu_id() {
		return nav_menu_id;
	}
	public void setNav_menu_id(Long nav_menu_id) {
		this.nav_menu_id = nav_menu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getReloadFlag() {
		return reloadFlag;
	}
	public void setReloadFlag(String reloadFlag) {
		this.reloadFlag = reloadFlag;
	}
	public String getExternal() {
		return external;
	}
	public void setExternal(String external) {
		this.external = external;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<TreeMenu> getChildren() {
		return children;
	}
	public void setChildren(List<TreeMenu> children) {
		this.children = children;
	}
}