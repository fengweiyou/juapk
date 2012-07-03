package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.NavMenuDAO;
import com.juapk.domain.NavMenu;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：NavMenuDAOImpl
 * 类描述：导航菜单数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class NavMenuDAOImpl extends IBatisEntityDao<NavMenu> implements NavMenuDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(NavMenuDAOImpl.class);
	private static final String GET_NAVMENU_BY_WHERE = "getNavMenuByWhere";
	
	/**
	 * 查询满足 where 条件的导航菜单记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<Soft>
	 * 			导航菜单记录
	 */
	@Override
	public List<NavMenu> getNavMenuByWhere(String where) throws BaseException {
		List<NavMenu> navMenuList = null;
		try {
			navMenuList = findByWhere(GET_NAVMENU_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的导航菜单记录失败."+e.getMessage());
		}
		return navMenuList;
	}

}
