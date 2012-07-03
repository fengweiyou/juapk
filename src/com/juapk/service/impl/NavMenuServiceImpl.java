package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.NavMenuDAO;
import com.juapk.domain.NavMenu;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.NavMenuService;

/**
 * 项目名称：juapk
 * 类名称：NavMenuService
 * 类描述：导航菜单数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:51:16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class NavMenuServiceImpl implements NavMenuService {
	private NavMenuDAO navMenuDAO;
	
	public void setNavMenuDAO(NavMenuDAO navMenuDAO) {
		this.navMenuDAO = navMenuDAO;
	}

	/**
	 * 查询导航菜单记录
	 * @return List<NavMenu>
	 * 			导航菜单记录
	 */
	@Override
	public List<NavMenu> getAllNavMenu() throws BaseException {
		return navMenuDAO.getNavMenuByWhere("");
	}

}
