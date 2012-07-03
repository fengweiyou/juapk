package com.juapk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juapk.domain.Soft;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.SoftService;

/**
 * 项目名称：juapk
 * 类名称：IndexController
 * 类描述：主页业务处理类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private SoftService softInfoService;
	
	/**
	 * 登入
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.do")
	public ModelAndView GoLogin(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		return new ModelAndView("login", result);
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/register.do")
	public ModelAndView GoRegister(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("---------register.do---------");
		return new ModelAndView("register", null);
	}
	
	/**
	 * 主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index.do")
	public ModelAndView GoIndex(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_INDEX);
		// 推荐软件
		try {
			List<Soft> softList = softInfoService.getSoftCommendListByWhere(" limit 0,20");
			result.put("softCommendList", softList);
		} catch (BaseException e) {
			LOGGER.error("GoIndex 查询softCommendList失败" + e.getMessage());
		}
		return new ModelAndView("index", result);
	}
	
	/**
	 * 开发者
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/dev.do")
	public ModelAndView GoDev(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_DEV);
		return new ModelAndView("dev", result);
	}
	
	/**
	 * 装机必备
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/essential.do")
	public ModelAndView GoEssential(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 推荐软件
		try {
			result.put("softEssentialList", softInfoService.getSoftCommendListByWhere(" limit 0,27"));
		} catch (BaseException e) {
			LOGGER.error("GoIndex 查询softCommendList失败" + e.getMessage());
		}
		result.put(GlobalConstants.HEADER_LOCATION, GlobalConstants.HEADER_DEV);
		return new ModelAndView("essential", result);
	}
	
}
