package com.juapk.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;

/**
 * 项目名称：juapk
 * 类名称：BaseController
 * 类描述：Controller 基础类
 * 创建人：hubin
 * 创建时间：2012-6-11 下午10:21:12
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version V1.0
 */
public abstract class BaseController {
	/** 错误日志 */
	static transient final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	
	BaseController(){
	}

	public void requestDataBinder(HttpServletRequest request,Object target){
		ServletRequestDataBinder bind = new ServletRequestDataBinder(target);
		bind.bind(request);
	}
}