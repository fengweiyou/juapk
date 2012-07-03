package com.juapk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juapk.frame.GlobalConstants;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.SoftCommendService;
import com.juapk.service.SoftService;
import com.juapk.service.SoftSortService;
import com.juapk.service.TopicService;
import com.juapk.service.TopicSoftService;

/**
 * 项目名称：juapk
 * 类名称：MobController
 * 类描述：移动版本业务处理类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class MobController extends BaseController{
	@Autowired
	private SoftService softInfoService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private TopicSoftService topicSoftService;
	@Autowired
	private SoftSortService softSortService;
	@Autowired
	private SoftCommendService softCommendService;
	
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mobIndex.do")
	public ModelAndView GoMobIndex(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_INDEX);
		String offsetStr = request.getParameter("offset");
		int offset = 0; // 翻页
		int pageSize = 10; // 每页数量
		if (offsetStr != null && !"".equals(offsetStr))
			offset = Integer.parseInt(offsetStr);
		StringBuffer sqlWhere = new StringBuffer();
		StringBuffer linkUrl = new StringBuffer("mobIndex.do?1=1");
		PageModel softCommendListPageModel = new PageModel();
		QueryItem queryItem = new QueryItem();
		// 推荐软件
		queryItem.setOffset(offset);
		queryItem.setPageSize(pageSize); // 每页显示数量
		queryItem.setSql(sqlWhere.toString());
		try {
			softCommendListPageModel.setData(softInfoService.getSoftCommendListByQueryItem(queryItem));
		} catch (BaseException e) {
			LOGGER.error("GoMobTopicList 查询推荐软件列表失败" + e.getMessage());
		}
		try {
			softCommendListPageModel.setCount(softCommendService.getSoftCommendCountByWhere(sqlWhere.toString()));
		} catch (BaseException e) {
			LOGGER.error("GoMobTopicList 查询推荐软件数量失败" + e.getMessage());
		}
		softCommendListPageModel.setOffset(offset);
		softCommendListPageModel.setPageSize(pageSize);
		softCommendListPageModel.setLinkUrl(linkUrl.toString());
		result.put("softCommendListPageModel", softCommendListPageModel);
		return new ModelAndView("mob/mob_index", result);
	}

	/**
	 * 应用
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mobApp.do")
	public ModelAndView GoMobApp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_APP);
		String softType = request.getParameter("softType"); // 软件类型（0应用1游戏）
		if(softType == null)return null;
		// 应用标题
		String mobTitle = request.getParameter("mobTitle");
		if("0".equals(mobTitle)){
		//----  MOB 应用推荐  ------------------------------------------------------------------------
			result.put(GlobalConstants.MOB_TITLE, GlobalConstants.MOB_TITLE_COMMEND);
		}else if("1".equals(mobTitle)||mobTitle==null){
		//----  MOB 最新应用  ------------------------------------------------------------------------
			result.put(GlobalConstants.MOB_TITLE, GlobalConstants.MOB_TITLE_NEW);
			String offsetStr = request.getParameter("offset");
			int offset = 0; // 翻页
			int pageSize = 12; // 每页数量
			if (offsetStr != null && !"".equals(offsetStr))
				offset = Integer.parseInt(offsetStr);
			StringBuffer sqlWhere = new StringBuffer(" WHERE soft_type = ");
			StringBuffer linkUrl = new StringBuffer("mobApp.do?");
			if("0".equals(softType)){
				// 应用
				sqlWhere.append(GlobalConstants.SOFT_TYPE_APP);
				linkUrl.append("softType=0");
				result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_APP);
				try {
					result.put("sortList", softSortService.getSoftSortListByWhere("WHERE soft_type = " + GlobalConstants.SOFT_TYPE_APP));
				} catch (BaseException e) {
					LOGGER.error("GoMobApp 查找软件类型列表失败" + e.getMessage());
				}
			}else if("1".equals(softType)){
				// 游戏
				sqlWhere.append(GlobalConstants.SOFT_TYPE_GAME);
				linkUrl.append("softType=1");
				result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_GAME);
				try {
					result.put("sortList", softSortService.getSoftSortListByWhere("WHERE soft_type = " + GlobalConstants.SOFT_TYPE_GAME));
				} catch (BaseException e) {
					LOGGER.error("GoMobApp 查找软件类型列表失败" + e.getMessage());
				}
			}
			PageModel softPageModel = new PageModel();
			QueryItem queryItem = new QueryItem();

			// linkUrl地址
			result.put("linkUrl", linkUrl.toString());
			
			queryItem.setOffset(offset);
			queryItem.setPageSize(pageSize); // 每页显示数量
			queryItem.setSql(sqlWhere.toString());
			try {
				softPageModel.setData(softInfoService.getSoftListByQueryItem(queryItem));
				softPageModel.setCount(softInfoService.getSoftCountByWhere(sqlWhere.toString()));
			} catch (BaseException e) {
				LOGGER.error(" 查询应用软件列表失败" + e.getMessage());
			}
			softPageModel.setOffset(offset);
			softPageModel.setPageSize(pageSize);
			softPageModel.setLinkUrl(linkUrl.toString());
			result.put("softPageModel", softPageModel);
		}else if("2".equals(mobTitle)){
		//----  MOB 应用分类  ------------------------------------------------------------------------
			result.put(GlobalConstants.MOB_TITLE, GlobalConstants.MOB_TITLE_SORT);
			if("0".equals(softType)){
				// 应用
				result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_APP);
				try {
					result.put("sortList", softSortService.getSoftSortListByWhere("WHERE soft_type = " + GlobalConstants.SOFT_TYPE_APP));
				} catch (BaseException e) {
					LOGGER.error("GoMobApp 查找应用软件类型列表失败" + e.getMessage());
				}
			}else if("1".equals(softType)){
				// 游戏
				result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_GAME);
				try {
					result.put("sortList", softSortService.getSoftSortListByWhere("WHERE soft_type = " + GlobalConstants.SOFT_TYPE_GAME));
				} catch (BaseException e) {
					LOGGER.error("GoMobApp 查找游戏软件类型列表失败" + e.getMessage());
				}
			}
		}
		return new ModelAndView("mob/mob_app", result);
	}
	
	/**
	 * 专题
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mobTopic.do")
	public ModelAndView GoMobTopic(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_TOPIC);
		String offsetStr = request.getParameter("offset");
		int offset = 0; // 翻页
		int pageSize = 10; // 每页数量
		if (offsetStr != null && !"".equals(offsetStr))
			offset = Integer.parseInt(offsetStr);
		StringBuffer sqlWhere = new StringBuffer(" WHERE flag = 1");
		StringBuffer linkUrl = new StringBuffer("mobTopic.do?1=1");
		PageModel topicPageModel = new PageModel();
		QueryItem queryItem = new QueryItem();
		// 专题 topicList
		queryItem.setOffset(offset);
		queryItem.setPageSize(pageSize); // 每页显示数量
		queryItem.setSql(sqlWhere.toString());
		try {
			topicPageModel.setData(topicService.getTopicListByQueryItem(queryItem));
			topicPageModel.setCount(topicService.getTopicCountByWhere(sqlWhere.toString()));//sqlWhere.toString()
		} catch (BaseException e) {
			LOGGER.error("GoMobTopicList 查询专题列表失败" + e.getMessage());
		}
		topicPageModel.setOffset(offset);
		topicPageModel.setPageSize(pageSize);
		topicPageModel.setLinkUrl(linkUrl.toString());
		result.put("topicPageModel", topicPageModel);
		return new ModelAndView("mob/mob_topic", result);
	}
	
	/**
	 * 专题列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mobTopicList.do")
	public ModelAndView GoMobTopicList(HttpServletRequest request,HttpServletResponse response) {
		// 专题 id
		String topicId = request.getParameter("topicId");
		if (topicId == null || "".equals(topicId))
			return null;
		Map<String, Object> result = new HashMap<String, Object>();
		String offsetStr = request.getParameter("offset");
		int offset = 0; // 翻页
		int pageSize = 10; // 每页数量
		if (offsetStr != null && !"".equals(offsetStr))
			offset = Integer.parseInt(offsetStr);
		StringBuffer sqlWhere = new StringBuffer(" WHERE topic_id="+topicId);
		StringBuffer linkUrl = new StringBuffer("mobTopicList.do?topicId="+topicId);
		PageModel topicListPageModel = new PageModel();
		QueryItem queryItem = new QueryItem();
		// 专题 topicList
		queryItem.setOffset(offset);
		queryItem.setPageSize(pageSize); // 每页显示数量
		queryItem.setSql(sqlWhere.toString());
		try {
			topicListPageModel.setData(softInfoService.getSoftTopicListByQueryItem(queryItem));
		} catch (BaseException e) {
			LOGGER.error("GoMobTopicList 查询专题软件列表失败" + e.getMessage());
		}
		try {
			topicListPageModel.setCount(topicSoftService.getTopicSoftCountByWhere(sqlWhere.toString()));
		} catch (BaseException e) {
			LOGGER.error("GoMobTopicList 查询专题软件数量失败" + e.getMessage());
		}
		topicListPageModel.setOffset(offset);
		topicListPageModel.setPageSize(pageSize);
		topicListPageModel.setLinkUrl(linkUrl.toString());
		result.put("topicListPageModel", topicListPageModel);
		return new ModelAndView("mob/mob_topic_list", result);
	}
	
	/**
	 * 软件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mobSoft.do")
	public ModelAndView GoMobSoft(HttpServletRequest request,HttpServletResponse response) {
		// 软件ID
		String softId = request.getParameter("softId");
		if(softId == null)return null;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("softInfo",softInfoService.getSoftById(Integer.parseInt(softId)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BaseException e) {
			LOGGER.error("GoSoft 查询软件信息失败" + e.getMessage());
		}
		return new ModelAndView("mob/mob_soft", result);
	}
	
	/**
	 * 查询
	 * @param Request
	 * @param Response
	 * @return
	 */
	@RequestMapping("/mobSearch.do")
	public ModelAndView GoMobSearch(HttpServletRequest Request,HttpServletResponse Response) {
		Map<String, Object> result = new HashMap<String, Object>();
		return new ModelAndView("mob/mob_search", result);
	}
	
	/**
	 * 反馈
	 * @param Request
	 * @param Response
	 * @return
	 */
	@RequestMapping("/mobFeedBack.do")
	public ModelAndView GoMobFeedBack(HttpServletRequest Request,HttpServletResponse Response) {
		Map<String, Object> result = new HashMap<String, Object>();
		return new ModelAndView("mob/mob_feed_back", result);
	}
	
}