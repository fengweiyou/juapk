package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：UserRole
 * 类描述：权限管理( 用户角色表 )
 * 创建人：hubin
 * 创建时间：2011.01.15
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class UserRole {
	private String id; // 用户角色 ID
	private String user_id; // 用户 ID
	private String role_id; // 角色 ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String roleId) {
		role_id = roleId;
	}
}
