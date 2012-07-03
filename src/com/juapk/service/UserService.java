package com.juapk.service;

import com.juapk.domain.User;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：UserService
 * 类描述：用户数据访问服务 
 * 创建人：hubin
 * 创建时间：2012.02.26
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface UserService {

	/**
	 * 根据 用户名查询一条记录
	 * 
	 * @param userName
	 *            用户名
	 * @return 返回 User 对象
	 * @throws BaseException
	 */
	User getUserByUserName(String userName) throws BaseException;
	
}
