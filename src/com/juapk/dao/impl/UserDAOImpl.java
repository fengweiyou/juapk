package com.juapk.dao.impl;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.UserDAO;
import com.juapk.domain.User;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：UserDAOImpl
 * 类描述：用户数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2012.02.26
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class UserDAOImpl extends IBatisEntityDao<User> implements UserDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	private static final String GET_USER_BY_USERNAME = "getUserByUserName";
	
	/**
	 * 根据 用户名查询 用户信息
	 * 
	 * @param userName
	 *            用户名
	 * @return 返回 User 对象
	 * @throws BaseException
	 */
	@Override
	public User getUserByUserName(String userName) throws BaseException {
		User user = null;
		try {
			user = findUniqueByWhere(GET_USER_BY_USERNAME, userName);
		} catch (SQLException e) {
			LOGGER.error("根据 用户名查询 用户信息失败."+e.getMessage());
		}
		return user;
	}

}
