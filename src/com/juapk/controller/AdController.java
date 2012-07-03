package com.juapk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.juapk.frame.GlobalConstants;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.util.JsonUtils;
import com.juapk.service.AdService;

/**
 * 项目名称：juapk
 * 类名称：AdController
 * 类描述：广告业务处理类 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:09:25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class AdController extends BaseController{
	@Autowired
	private AdService adService;
	
	/**
	 * BannaerList广告信息列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 */
	@RequestMapping(value = "/bannaerList.do", method = RequestMethod.GET)
	@ResponseBody
	public void getBannaerList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("data", adService.getAllAdList(GlobalConstants.Bannaer));
			result.put("success", "true");
		} catch (BaseException e) {
			result.put("success", "false");
			LOGGER.error("getBannaerList 查询bannaerList失败" + e.getMessage());
		}
		JsonUtils.responseAjaxRequest(response, JsonUtils.convertToJson(result));
	}
	
}
