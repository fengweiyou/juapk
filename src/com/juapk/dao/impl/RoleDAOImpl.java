package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.RoleDAO;
import com.juapk.domain.Role;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：RoleDAOImpl
 * 类描述：角色数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2012.02.27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class RoleDAOImpl extends IBatisEntityDao<Role> implements RoleDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(RoleDAOImpl.class);
	private static final String GET_ROLE_BY_USERID = "getRoleByUserId";
	
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
		List<Role> roleList = null;
		try {
			roleList = findByWhere(GET_ROLE_BY_USERID, userId);
		} catch (SQLException e) {
			LOGGER.error("根据 用户ID查询角色记录失败."+e.getMessage());
		}
		return roleList;
	}

}
