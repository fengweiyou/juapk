package com.juapk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.juapk.domain.User;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.security.shiro.ShiroUtils;

/**
 * 项目名称：juapk
 * 类名称：SecurityController
 * 类描述：权限安全业务处理类 
 * 创建人：hubin
 * 创建时间：2012-02-16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class SecurityController extends BaseController{

	/**
	 * 用户登入验证
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/invalidLogin.do")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		User user = new User();
		requestDataBinder(request,user); // Request 信息绑定
		boolean islogin = true;
		if(user.getUser_name() == null || "".equals(user.getUser_name())){
			islogin = false;
			result.put("un", "0");
		}
		if(user.getPassword() == null || "".equals(user.getPassword())){
			islogin = false;
			result.put("pw", "0");
		}
		// KAPTCHA 验证码
		String _sessionAuthcode = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String authcode = user.getAuthcode();
		if(authcode == null || _sessionAuthcode == null
				|| !authcode.equalsIgnoreCase(_sessionAuthcode)){
			islogin = false;
			result.put("ac", "0");
		}
		// 登入信息验证
		if (islogin) {
			setLogin(user.getUser_name(), user.getPassword());
			return new ModelAndView("redirect:/s/adminIndex.do");
		}
		return new ModelAndView("admin/admin_login", result);
	}
	

	/**
	 * 未授权
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/s/unauthorized.do")
	public ModelAndView GoAdminIndex(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		return new ModelAndView("index", result);
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/s/logout.do")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			subject.logout();
		}
		return new ModelAndView("admin/admin_login");
	}
	
	/**
	 * 登入用户信息验证
	 * @param username
	 * 				用户名
	 * @param password
	 * 				密码
	 * @return
	 */
	public static final void setLogin(String username, String password) {
		// 获取当前Subject
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			// 接受提交证书
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					ShiroUtils.getPassWord(username, password));
			token.setRememberMe(true);
			// 登录验证
			currentUser.login(token);
		}
	}
	
	/**
	 * 保存登录用户信息到 Session
	 * @param user
	 * @return
	 */
	public static final void setCurrentUser(User user) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(GlobalConstants.CURRENT_USER, user);
			}
		}
	}
	
	/**
	 * 从 Session 中获取当前登录用户
	 * @return User
	 */
	public static final User getCurrentUser() {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				User user = (User) session.getAttribute(GlobalConstants.CURRENT_USER);
				if (null != user) {
					return user;
				}
			}
		}
		return null;
	}
	
}