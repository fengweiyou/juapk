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

import com.juapk.domain.Soft;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.util.JsonUtils;
import com.juapk.service.SoftCommendService;
import com.juapk.service.SoftService;

/**
 * 项目名称：juapk
 * 类名称：SoftController
 * 类描述：软件业务处理类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class SoftController extends BaseController{
	@Autowired
	private SoftService softService;
	@Autowired
	private SoftCommendService softCommendService;
	@Autowired
	private SoftService softInfoService;
	
	/**
	 * 软件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/soft.do")
	public ModelAndView GoSoft(HttpServletRequest request,HttpServletResponse response) {
		// 软件ID
		String softId = request.getParameter("softId");
		if(softId == null)return null;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Soft soft = softService.getSoftById(Integer.parseInt(softId));
			result.put("softInfo",soft);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BaseException e) {
			LOGGER.error("GoSoft 查询软件信息失败" + e.getMessage());
		}
		// 猜你喜欢
		try {
			result.put("likeSoftList", softInfoService.getSoftCommendListByWhere(" limit 0,10"));
		} catch (BaseException e) {
			LOGGER.error("GoSoft 查询likeSoftList失败" + e.getMessage());
		}
		return new ModelAndView("soft", result);
	}
	
	/**
	 * 应用
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/softList.do")
	public ModelAndView GoSoftList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		String softType = request.getParameter("softType"); // 软件类型（1应用2游戏）
		if(softType == null)return null;
		String offsetStr = request.getParameter("offset");
		int offset = 0; // 翻页
		int pageSize = 12; // 每页数量
		if (offsetStr != null && !"".equals(offsetStr))
			offset = Integer.parseInt(offsetStr);
		StringBuffer sqlWhere = new StringBuffer(" WHERE soft_type = ");
		StringBuffer linkUrl = new StringBuffer("softList.do?");
		if(GlobalConstants.SOFT_TYPE_APP.equals(softType)){
			// 应用
			sqlWhere.append(GlobalConstants.SOFT_TYPE_APP);
			linkUrl.append("softType=").append(GlobalConstants.SOFT_TYPE_APP);
			result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_APP);
			result.put(GlobalConstants.SOFT_TYPE_FLAG, GlobalConstants.SOFT_TYPE_APP);
		}else if(GlobalConstants.SOFT_TYPE_GAME.equals(softType)){
			// 游戏
			sqlWhere.append(GlobalConstants.SOFT_TYPE_GAME);
			linkUrl.append("softType=").append(GlobalConstants.SOFT_TYPE_GAME);
			result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_GAME);
			result.put(GlobalConstants.SOFT_TYPE_FLAG, GlobalConstants.SOFT_TYPE_GAME);
		}
		PageModel softPageModel = new PageModel();
		QueryItem queryItem = new QueryItem();
		// 软件类型 ID
		String sortId = request.getParameter("sortId");
		if(sortId !=null){
			sqlWhere.append(" and soft_sort_id = "+sortId);	// 最热软件
			linkUrl.append("&sortId="+sortId);
			result.put("sortId", "&sortId="+sortId);
		}
		// 排序
		String sort = request.getParameter("sort");
		if(GlobalConstants.SOFT_HOT.equals(sort)){
			sqlWhere.append(" order by down_amount desc");	// 最热软件
			linkUrl.append("&sort=hot");
		}else if(GlobalConstants.SOFT_NEW.equals(sort)){
			sqlWhere.append(" order by upload_date desc");	// 最新软件
			linkUrl.append("&sort=new");
		}
		
		queryItem.setOffset(offset);
		queryItem.setPageSize(pageSize); // 每页显示数量
		queryItem.setSql(sqlWhere.toString());
		try {
			softPageModel.setData(softService.getSoftListByQueryItem(queryItem));
			softPageModel.setCount(softService.getSoftCountByWhere(sqlWhere.toString()));
		} catch (BaseException e) {
			LOGGER.error(" 查询所有应用软件信息失败" + e.getMessage());
		}
		softPageModel.setOffset(offset);
		softPageModel.setPageSize(pageSize);
		softPageModel.setLinkUrl(linkUrl.toString());
		result.put("softPageModel", softPageModel);
		return new ModelAndView("app", result);
	}
	
	/**
	 * Index.jsp 焦点图
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/picbox.do")
	public ModelAndView GoGd(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("---------picbox.do---------");
		return new ModelAndView("picbox", null);
	}
	
	/**
	 * 更多
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/MoreSoftList.do")
	public ModelAndView GoMoreSoftList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		String softType = request.getParameter("softType"); // 软件类型（0应用1游戏）
		if(softType == null)return null;
		String offsetStr = request.getParameter("offset");
		int offset = 0; // 翻页
		int pageSize = 12; // 每页数量
		if (offsetStr != null && !"".equals(offsetStr))
			offset = Integer.parseInt(offsetStr);
		StringBuffer sqlWhere = new StringBuffer();
		StringBuffer linkUrl = new StringBuffer("MoreSoftList.do?");
		PageModel softPageModel = new PageModel();
		QueryItem queryItem = new QueryItem();
		queryItem.setOffset(offset);
		queryItem.setPageSize(pageSize); // 每页显示数量
		if("0".equals(softType)){
			// 更多 --> 推荐
			linkUrl.append("softType=0");
			result.put(GlobalConstants.SOFT_TYPE_FLAG, GlobalConstants.SOFT_TYPE_COMMEND);
			try {
				softPageModel.setData(softService.getSoftCommendListByQueryItem(queryItem));
			} catch (BaseException e) {
				LOGGER.error("GoNewSoftList 查询推荐软件列表失败" + e.getMessage());
			}
			try {
				softPageModel.setCount(softCommendService.getSoftCommendCountByWhere(sqlWhere.toString()));
			} catch (BaseException e) {
				LOGGER.error("GoNewSoftList 查询推荐软件数量失败" + e.getMessage());
			}
		}else{
			if("1".equals(softType)){
				// 更多 --> 最新应用
				sqlWhere.append(" WHERE soft_type = "+GlobalConstants.SOFT_TYPE_APP);
				linkUrl.append("softType=1");
				result.put(GlobalConstants.SOFT_TYPE_FLAG, GlobalConstants.SOFT_TYPE_NEW_APP);
			}else if("2".equals(softType)){
				// 更多 --> 游戏
				sqlWhere.append(" WHERE soft_type = "+GlobalConstants.SOFT_TYPE_GAME);
				linkUrl.append("softType=2");
				result.put(GlobalConstants.SOFT_TYPE_FLAG, GlobalConstants.SOFT_TYPE_NEW_GAME);
			}else if("3".equals(softType)){
				// 查询 /newSoftList.do?a=2&s=''
				String searchStr = request.getParameter("s");
				sqlWhere.append(" WHERE cn_name like '%"+searchStr+"%'");
				linkUrl.append("softType=3&searchKey="+searchStr);
				result.put("searchStr", searchStr);
				result.put(GlobalConstants.SOFT_TYPE_FLAG, GlobalConstants.SOFT_TYPE_SEARCH);
			}
			// 查询条件
			queryItem.setSql(sqlWhere.toString());
			try {
				softPageModel.setData(softService.getSoftListByQueryItem(queryItem));
				softPageModel.setCount(softService.getSoftCountByWhere(sqlWhere.toString()));
			} catch (BaseException e) {
				LOGGER.error("GoNewSoftList 查询所有应用软件信息失败" + e.getMessage());
			}
		}
		softPageModel.setOffset(offset);
		softPageModel.setPageSize(pageSize);
		softPageModel.setLinkUrl(linkUrl.toString());
		result.put("softPageModel", softPageModel);
		return new ModelAndView("app_more", result);
	}
	
	/**
	 * 获取（模块）软件列表信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 */
	@RequestMapping(value = "/getSoftList.do", method = RequestMethod.GET)
	@ResponseBody
	public void getSoftList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		Map<String, Object> result = new HashMap<String, Object>();
		String d = request.getParameter("d");
		if("d2".equals(d)){
			// 热门应用
			try {
				result.put("data", softService.getSoftListByWhere(" WHERE soft_type = "
						+ GlobalConstants.SOFT_TYPE_APP
						+ " ORDER BY down_amount DESC LIMIT 0,9"));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询最热应用失败" + e.getMessage());
			}
		}else if("d3".equals(d)){
			// 热门游戏
			try {
				result.put("data", softService.getSoftListByWhere(" WHERE soft_type = "
						+ GlobalConstants.SOFT_TYPE_GAME
						+ " ORDER BY down_amount DESC LIMIT 0,9"));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询最热游戏失败" + e.getMessage());
			}
		}else if("d4".equals(d)){
			// 最新应用
			try {
				result.put("data", softService.getSoftListByWhere(" WHERE soft_type = "
						+ GlobalConstants.SOFT_TYPE_APP
						+ " ORDER BY upload_date DESC LIMIT 0,10"));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询最新应用失败" + e.getMessage());
			}
		}else if("d5".equals(d)){
			// 最新游戏
			try {
				result.put("data", softService.getSoftListByWhere(" WHERE soft_type = "
						+ GlobalConstants.SOFT_TYPE_GAME
						+ " ORDER BY upload_date DESC LIMIT 0,10"));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询最新游戏失败" + e.getMessage());
			}
		}else if("d6".equals(d)){
			// 日排行
			try {
				result.put("data", softService.getSoftTopListByType(GlobalConstants.TOP_SOFT_TODAY));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询日排行失败" + e.getMessage());
			}
		}else if("d7".equals(d)){
			// 周排行
			try {
				result.put("data", softService.getSoftTopListByType(GlobalConstants.TOP_SOFT_WEEK));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询周排行失败" + e.getMessage());
			}
		}else if("d8".equals(d)){
			// 月排行
			try {
				result.put("data", softService.getSoftTopListByType(GlobalConstants.TOP_SOFT_MONTH));
				result.put("success", "true");
			} catch (BaseException e) {
				result.put("success", "false");
				LOGGER.error("getSoftList 查询月排行失败" + e.getMessage());
			}
		}
		// 返回JSON信息
		JsonUtils.responseAjaxRequest(response, JsonUtils.convertToJson(result));
	}
	
	/**
	 * 添加软件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/addSoft.do")
	public ModelAndView addSoft(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		Soft soft = new Soft();
		ServletRequestDataBinder bind = new ServletRequestDataBinder(soft);
		bind.bind(request);
		try {
			softService.insertSoft(soft);
			result.put(GlobalConstants.ALERT_MSG, GlobalConstants.ALERT_SUCCESS);
		} catch (BaseException e) {
			result.put(GlobalConstants.ALERT_MSG, GlobalConstants.ALERT_ERROR);
			e.printStackTrace();
		}
		return new ModelAndView("/admin/soft_sort_add", result);
	}
	
}