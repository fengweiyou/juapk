package com.juapk.service.impl;

import com.juapk.dao.UserDAO;
import com.juapk.domain.User;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.UserService;

/**
 * 项目名称：juapk
 * 类名称：UserService
 * 类描述：用户数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012.02.26
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * 根据 用户名查询一条记录
	 * 
	 * @param userName
	 *            用户名
	 * @return 返回 User 对象
	 * @throws BaseException
	 */
	@Override
	public User getUserByUserName(String userName) throws BaseException {
		return userDAO.getUserByUserName(userName);
	}

}
