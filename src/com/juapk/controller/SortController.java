package com.juapk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.juapk.domain.SoftSort;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.util.JsonUtils;
import com.juapk.service.SoftSortService;

/**
 * 项目名称：juapk
 * 类名称：SortController
 * 类描述：软件类别业务处理类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class SortController extends BaseController{
	@Autowired
	private SoftSortService softSortService;
	
	/**
	 * 获取（软件模块）分类列表信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 */
	@RequestMapping(value = "/getSortList.do", method = RequestMethod.GET)
	@ResponseBody
	public void getSortList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		Map<String, Object> result = new HashMap<String, Object>();
		String sortId = request.getParameter("sortId");
		try {
			
			// 0 应用类、1 游戏类
			if(GlobalConstants.SOFT_TYPE_APP.equals(sortId)
					||GlobalConstants.SOFT_TYPE_GAME.equals(sortId)){
				result.put("data", softSortService.getSoftSortListByWhere(sortId));
			}
			
			result.put("success", "true");
		} catch (BaseException e) {
			result.put("success", "false");
			LOGGER.error("getSortList 查找软件类型列表失败" + e.getMessage());
		}
		// 返回JSON信息
		JsonUtils.responseAjaxRequest(response, JsonUtils.convertToJson(result));
	}
	
	/**
	 * 添加软件类型
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/addSoftSort.do")
	public ModelAndView addSoftSort(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		SoftSort softSort = new SoftSort();
		ServletRequestDataBinder bind = new ServletRequestDataBinder(softSort);
		bind.bind(request);
		try {
			softSortService.insertSoftSort(softSort);
			result.put(GlobalConstants.ALERT_MSG, GlobalConstants.ALERT_SUCCESS);
		} catch (BaseException e) {
			result.put(GlobalConstants.ALERT_MSG, GlobalConstants.ALERT_ERROR);
			e.printStackTrace();
		}
		return new ModelAndView("admin/soft_sort_add", result);
	}
	
	/**
	 * 添加软件类型
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/updateSoftSort.do")
	public ModelAndView updateSoftSort(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		return new ModelAndView("admin/soft_sort_update", result);
	}
	
	/**
	 * 添加软件类型
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/getSoftSort.do")
	public ModelAndView getSoftSort(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		String offsetStr = request.getParameter("offset");
		String stype = request.getParameter("stype");
		// 软件类型 ID 
		String soft_sort_id = request.getParameter("soft_sort_id");
		if(!"".equals(soft_sort_id)&&soft_sort_id!=null){
			try {
				softSortService.deleteSoftSortById(soft_sort_id);
				result.put(GlobalConstants.ALERT_MSG, GlobalConstants.ALERT_SUCCESS);
			} catch (BaseException e) {
				result.put(GlobalConstants.ALERT_MSG, GlobalConstants.ALERT_ERROR);
				LOGGER.error("软件类别删除失败: " + e.getMessage());
			}
		}
		int offset = 0; // 翻页
		int pageSize = 10; // 每页数量
		if (offsetStr != null && !"".equals(offsetStr))
			offset = Integer.parseInt(offsetStr);
		PageModel sortPageModel = new PageModel();
		QueryItem queryItem = new QueryItem();
		StringBuffer sqlWhere = new StringBuffer(" WHERE soft_type = ");
		StringBuffer linkUrl = new StringBuffer("getSoftSort.do?");
		queryItem.setOffset(offset);
		queryItem.setPageSize(pageSize); // 每页显示数量
		// 0 应用类、1 游戏类
		if(GlobalConstants.SOFT_TYPE_APP.equals(stype)
				||GlobalConstants.SOFT_TYPE_GAME.equals(stype)){
			result.put("STYPE", stype);
			sqlWhere.append(stype);
			queryItem.setSql(sqlWhere.toString());
			linkUrl.append("stype=").append(stype);
			try {
				sortPageModel.setData(softSortService.getSoftSortListByQueryItem(queryItem));
				sortPageModel.setCount(softSortService.getSoftSortCountByWhere(sqlWhere.toString()));
				sortPageModel.setOffset(offset);
				sortPageModel.setPageSize(pageSize);
				sortPageModel.setLinkUrl(linkUrl.toString());
				result.put("sortPageModel", sortPageModel);
			} catch (BaseException e) {
				result.put("", "");
				LOGGER.error("查找软件类别翻页信息失败: " + e.getMessage());
			}
		}
		return new ModelAndView("admin/soft_sort_list", result);
	}
	
}