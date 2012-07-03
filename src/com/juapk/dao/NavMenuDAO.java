package com.juapk.dao;

import java.util.List;

import com.juapk.domain.NavMenu;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：NavMenuDAO
 * 类描述：导航菜单数据访问对象
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface NavMenuDAO {
	
	
	/**
	 * 查询满足 where 条件的导航菜单记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<NavMenu>
	 * 			导航菜单记录
	 */
	List<NavMenu> getNavMenuByWhere(String where) throws BaseException;
	
}
