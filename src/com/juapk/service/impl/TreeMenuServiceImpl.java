package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.TreeMenuDAO;
import com.juapk.domain.TreeMenu;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.TreeMenuService;

/**
 * 项目名称：juapk
 * 类名称：TreeMenuServiceImpl
 * 类描述：DWZ中左边树形结构菜单数据访问服务实现类
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:02:39
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TreeMenuServiceImpl implements TreeMenuService {
	private TreeMenuDAO treeMenuDAO;
	
	public void setTreeMenuDAO(TreeMenuDAO treeMenuDAO) {
		this.treeMenuDAO = treeMenuDAO;
	}

	/**
	 * 根据 navMenuId 查询树形结构菜单记录
	 * @param navMenuId
	 * 			 	导航菜单 ID
	 * @return List<TreeMenu>
	 * 				树形结构菜单记录
	 */
	public List<TreeMenu> getTreeMenuByNavMenuID(String navMenuId) throws BaseException {
		return treeMenuDAO.getTreeMenuByWhere(" where nav_menu_id = " + navMenuId);
	}

	/**
	 * 根据 navMenuId,treeMenuId 查询树形结构菜单记录
	 * @param navMenuId
	 * 			 	导航菜单 ID
 	 * @param treeMenuId
	 * 			 	树形结构菜单 ID
	 * @return List<TreeMenu>
	 * 				树形结构菜单记录
	 */
	@Override
	public List<TreeMenu> getTreeMenu(Long navMenuId, Long treeMenuId)
			throws BaseException {
		StringBuffer sql = new StringBuffer(" where pid = ");
					 sql.append(treeMenuId).append(" and nav_menu_id=").append(navMenuId);
		return treeMenuDAO.getTreeMenuByWhere(sql.toString());
	}

}