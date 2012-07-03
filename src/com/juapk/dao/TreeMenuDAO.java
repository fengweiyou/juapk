package com.juapk.dao;

import java.util.List;

import com.juapk.domain.TreeMenu;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：TreeMenuDAO
 * 类描述：DWZ中左边树形结构菜单数据访问对象 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:31:17
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface TreeMenuDAO {
	
	
	/**
	 * 查询满足 where 条件的左边树形结构菜单记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<TreeMenu>
	 * 			导航菜单记录
	 */
	List<TreeMenu> getTreeMenuByWhere(String where) throws BaseException;
	
}
