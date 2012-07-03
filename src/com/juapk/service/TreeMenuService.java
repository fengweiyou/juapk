package com.juapk.service;

import java.util.List;

import com.juapk.domain.TreeMenu;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：TreeMenuService
 * 类描述：DWZ中左边树形结构菜单数据访问服务
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:03:18
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface TreeMenuService {

	/**
	 * 根据 navMenuId 查询树形结构菜单记录
	 * @param navMenuId
	 * 			 	导航菜单 ID
	 * @return List<TreeMenu>
	 * 				树形结构菜单记录
	 */
	List<TreeMenu> getTreeMenuByNavMenuID(String navMenuId) throws BaseException;
	
	/**
	 * 根据 navMenuId,treeMenuId 查询树形结构菜单记录
	 * @param navMenuId
	 * 			 	导航菜单 ID
 	 * @param treeMenuId
	 * 			 	树形结构菜单 ID
	 * @return List<TreeMenu>
	 * 				树形结构菜单记录
	 */
	List<TreeMenu> getTreeMenu(Long navMenuId, Long treeMenuId) throws BaseException;
}
