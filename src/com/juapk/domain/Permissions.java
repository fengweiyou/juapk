package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：Permissions
 * 类描述：权限管理( 权限表 )
 * 创建人：hubin
 * 创建时间：2011.01.15
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class Permissions {
	private String permissions_id; // 权限 ID
	private String parent_pid; // 父级权限ID
	private String role_name; // 权限名称
	private String details; // 权限描述

	public String getPermissions_id() {
		return permissions_id;
	}

	public void setPermissions_id(String permissionsId) {
		permissions_id = permissionsId;
	}

	public String getParent_pid() {
		return parent_pid;
	}

	public void setParent_pid(String parentPid) {
		parent_pid = parentPid;
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
}
