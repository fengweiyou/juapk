package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.TreeMenuDAO;
import com.juapk.domain.TreeMenu;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：TreeMenuDAOImpl
 * 类描述：DWZ中左边树形结构菜单数据访问对象 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:36:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TreeMenuDAOImpl extends IBatisEntityDao<TreeMenu> implements TreeMenuDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(TreeMenuDAOImpl.class);
	private static final String GET_TREEMENU_BY_WHERE = "getTreeMenuByWhere";
	
	/**
	 * 查询满足 where 条件的左边树形结构菜单记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<TreeMenu>
	 * 			导航菜单记录
	 */
	@Override
	public List<TreeMenu> getTreeMenuByWhere(String where) throws BaseException {
		List<TreeMenu> treeMenuList = null;
		try {
			treeMenuList = findByWhere(GET_TREEMENU_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的左边树形结构菜单记录失败."+e.getMessage());
		}
		return treeMenuList;
	}

}
