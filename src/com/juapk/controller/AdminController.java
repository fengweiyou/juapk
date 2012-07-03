package com.juapk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juapk.domain.NavMenu;
import com.juapk.domain.TreeMenu;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.NavMenuService;
import com.juapk.service.SoftSortService;
import com.juapk.service.TreeMenuService;

/**
 * 项目名称：juapk
 * 类名称：AdminController
 * 类描述：后台业务处理类 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:10:00
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class AdminController extends BaseController{
	@Autowired
	private SoftSortService softSortService;
	@Autowired
	private NavMenuService navMenuService;
	@Autowired
	private TreeMenuService treeMenuService;
	 
	/**
	 * 后台首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/adminIndex.do")
	public ModelAndView GoAdminIndex(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		String navid = request.getParameter("navid");
		/**
		 * 首次进入主界面  NAVID 为空 ，
		 * NavMenu点击后、展示左侧 TreeMenu 
		 */
		String pageUrl = "admin/admin_main";
		long navMenuId = GlobalConstants.ADMIN_NAV_MENU_INIT;
		if(navid!=null){
			pageUrl = "admin/admin_left_menu";
			navMenuId = Long.valueOf(navid);
		}
		List<NavMenu> navMenuList = null;
		List<TreeMenu> treeMenuList = null;
		try {
			navMenuList = navMenuService.getAllNavMenu();
			treeMenuList = treeMenuService.getTreeMenu(navMenuId, GlobalConstants.ADMIN_TREE_MENU_TAB);
		} catch (BaseException e) {
			LOGGER.error("获取菜单记录失败."+e.getMessage());
		}
		result.put("navMenuId", navMenuId); //NAV菜单ID
		result.put("navMenuList", navMenuList);//NAV导航菜单
		result.put("treeMenuList", getTreeMenu(treeMenuList));//TreeMenu子菜单列表
		return new ModelAndView(pageUrl, result);
	}
	
	/**
	 * getTreeMenu(获得所有树形菜单对象列表)
	 * @param  treeMenuList
	 * 					树形菜单对象列表
	 * @return List<TreeMenu>
	 * @since  V1.0
	 */
	public List<TreeMenu> getTreeMenu(List<TreeMenu> treeMenuList){
		if(treeMenuList==null)return null;
		List<TreeMenu> tempTreeMenuList = new ArrayList<TreeMenu>();
		List<TreeMenu> childrenTreeMenuList = null;
		TreeMenu treeMenu = null;
		for (int i = 0; i < treeMenuList.size(); i++) {
			treeMenu = treeMenuList.get(i);
			try {
				childrenTreeMenuList = treeMenuService.getTreeMenu(treeMenu.getNav_menu_id(), treeMenu.getId());
			} catch (BaseException e) {
				LOGGER.error("获得所有树形菜单对象列表失败: "+e.getMessage());
			}
			if(childrenTreeMenuList!=null){
				treeMenu.setChildren(childrenTreeMenuList);
			}
			tempTreeMenuList.add(treeMenu);
		}
		return tempTreeMenuList;
	}
	
}