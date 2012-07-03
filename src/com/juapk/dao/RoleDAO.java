package com.juapk.dao;

import java.util.List;

import com.juapk.domain.Role;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：RoleDAO
 * 类描述：角色数据访问对象
 * 创建人：hubin
 * 创建时间：2012.02.27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface RoleDAO {

	/**
	 * 根据 用户ID查询角色记录
	 * 
	 * @param userId
	 *            	用户名ID
	 * @return List<Role>
	 * 				角色记录
	 * @throws BaseException
	 */
	List<Role> getRoleByUserId(String userId) throws BaseException;
	
}
