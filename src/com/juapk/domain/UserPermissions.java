package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：UserPermissions
 * 类描述：权限管理( 用户权限表 )
 * 创建人：hubin
 * 创建时间：2011.01.15
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class UserPermissions {
	private String id; // 用户权限 ID
	private String user_id; // 用户 ID
	private String permissions_id; // 权限 ID
	private int category; // 权限类型

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

	public String getPermissions_id() {
		return permissions_id;
	}

	public void setPermissions_id(String permissionsId) {
		permissions_id = permissionsId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}
