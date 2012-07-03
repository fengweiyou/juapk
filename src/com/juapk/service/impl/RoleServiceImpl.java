package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.RoleDAO;
import com.juapk.domain.Role;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.RoleService;

/**
 * 项目名称：juapk
 * 类名称：RoleService
 * 类描述：角色数据访问服务实现类  
 * 创建人：hubin
 * 创建时间：2012.02.27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class RoleServiceImpl implements RoleService {
	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	/**
	 * 根据 用户ID查询角色记录
	 * 
	 * @param userId
	 *            	用户名ID
	 * @return List<Role>
	 * 				角色记录
	 * @throws BaseException
	 */
	@Override
	public List<Role> getRoleByUserId(String userId) throws BaseException {
		return roleDAO.getRoleByUserId(userId);
	}

}
