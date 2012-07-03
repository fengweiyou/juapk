package com.juapk.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juapk.domain.Topic;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.cos.RenamePolicyCos;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.SoftService;
import com.juapk.service.TopicService;
import com.oreilly.servlet.MultipartRequest;

/**
 * 项目名称：juapk
 * 类名称：TopicController
 * 类描述：专题业务处理类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class TopicController extends BaseController{
	@Autowired
	private SoftService softInfoService;
	@Autowired
	private TopicService topicService;
	
	/**
	 * 专题
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/topic.do")
	public ModelAndView GoTopic(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_TOPIC);
		Topic softTopic = null;	// 专题推荐
		try {
			softTopic = topicService.getTopicByWhere("limit 0,1");
			result.put("topic",softTopic);
		} catch (BaseException e) {
			LOGGER.error("GoTopic 查找topic失败" + e.getMessage());
		}
		try {
			result.put("topicList", topicService.getAllTopicList());
		} catch (BaseException e) {
			LOGGER.error("GoTopic 查找topicList失败" + e.getMessage());
		}
		try {
			result.put("softList", softInfoService.getSoftTopicListByWhere("where b.topic_id = " + softTopic.getTopic_id() + " limit 0,10"));
			result.put("softListA", softInfoService.getSoftTopicListByWhere("where b.topic_id = 1 limit 0,10"));
			result.put("softListB", softInfoService.getSoftTopicListByWhere("where b.topic_id = 2 limit 0,10"));
			result.put("softListC", softInfoService.getSoftTopicListByWhere("where b.topic_id = 3 limit 0,10"));
		} catch (BaseException e) {
			LOGGER.error("GoTopic 查询所专题软件信息失败" + e.getMessage());
		}
		return new ModelAndView("topic", result);
	}
	
	/**
	 * 专题列表
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/topicList.do")
	private ModelAndView getTopicList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_TOPIC);
		// 专题推荐软件
		result.put(GlobalConstants.TOPIC_TYPE_FLAG, GlobalConstants.TOPIC_TYPE_SOFT);
		// 专题 id
		String topicId = request.getParameter("topicId");
		PageModel softPageModel = new PageModel();
		try {
			result.put("topic", topicService.getTopicListByTopicId(topicId));
		} catch (BaseException e) {
			LOGGER.error("getTopicList 查找topic失败" + e.getMessage());
		}
		try {
			result.put("topicList", topicService.getAllTopicList());
		} catch (BaseException e) {
			LOGGER.error("getTopicList 查找topicList失败" + e.getMessage());
		}
		try {
			result.put("softList", softInfoService.getSoftTopicListByTopicId(topicId));
		} catch (BaseException e) {
			LOGGER.error("getTopicList 查询所专题软件信息失败" + e.getMessage());
		}
		return new ModelAndView("topic", result);
	}
 
	/**
	 * 添加专题
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/addTopic.do")
	public ModelAndView adminTopicAdd(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		return new ModelAndView("admin/admin_topic_add", result);
	}
	
	/**
	 * 添加软件类型
	 * @param request
	 * @param response
	 */
	@RequestMapping("/s/topicList.do")
	public ModelAndView adminTopicList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
//		Date date = new Date();//获取当前时间
//		SimpleDateFormat sdfFolder = new SimpleDateFormat("yyMM");
//		File fileDir = new File(request.getSession().getServletContext().getRealPath("/res/uploads/"+sdfFolder.format(date)));
//		if (!fileDir.exists()) {
//			fileDir.mkdirs();
//		}
//		// 设置上传文件的大小，超过这个大小 将抛出IOException异常，默认大小是1M。
//		int inmaxPostSize = 100 * 1024 * 1024;
//		MultipartRequest multirequest = null;
//		// 上传文件重命名策略
//		RenamePolicyCos myRenamePolicyCos = new RenamePolicyCos();
//		try {
//			multirequest = new MultipartRequest(request, fileDir
//					.getAbsolutePath(), inmaxPostSize, "UTF-8", myRenamePolicyCos); // UTF-8  编码模式上传文件
//			String subject = multirequest.getParameter("subject");// 获取普通信息
//			System.out.println(subject);
//			Enumeration<String> filedFileNames = multirequest.getFileNames();
//			String filedName = null;
//			if (null != filedFileNames) {
//				while (filedFileNames.hasMoreElements()) {
//					filedName = filedFileNames.nextElement();// 文件文本框的名称
//					// 获取该文件框中上传的文件，即对应到上传到服务器中的文件
//					File uploadFile = multirequest.getFile(filedName);
//					if (null != uploadFile && uploadFile.length() > 0) {
//						System.out.println(uploadFile.getName());
//						System.out.println(uploadFile.getPath());
//						System.out.println(uploadFile.length());
//					}
//					// 获取未重命名的文件名称
//					String Originalname = multirequest.getOriginalFileName(filedName);
//					System.out.println(Originalname);
//				}
//			}
//			
//			response.getWriter().write("1");
//		} catch (Exception e) {
//			LOGGER.error("文件上传异常！");
//		}
		
		return new ModelAndView("admin/admin_topic_list", result);
	}
	
}