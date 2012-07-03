package com.juapk.domain;

import java.sql.Date;

/**
 * 项目名称：juapk
 * 类名称：Role
 * 类描述：权限管理( 角色表 )
 * 创建人：hubin
 * 创建时间：2011.01.15
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class Role {
	private String role_id; // 角色 ID
	private String parent_role_id; // 父级角色 ID
	private String role_name; // 角色名称
	private String details; // 角色描述
	private Date create_date; // 创建时间

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String roleId) {
		role_id = roleId;
	}

	public String getParent_role_id() {
		return parent_role_id;
	}

	public void setParent_role_id(String parentRoleId) {
		parent_role_id = parentRoleId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
}
