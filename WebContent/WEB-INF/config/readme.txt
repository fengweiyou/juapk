 流程：
	1）容器启动(MySecurityMetadataSource：loadResourceDefine加载系统资源与权限列表)
	2）用户发出请求
	3）过滤器拦截(MySecurityFilter:doFilter)
	4）取得请求资源所需权限(MySecurityMetadataSource:getAttributes)
	5）匹配用户拥有权限和请求权限(MyAccessDecisionManager:decide)
	6）登录
	7）验证并授权(MyUserDetailServiceImpl:loadUserByUsername)
	8）重复4,5
	
	
<!-- =========================================================
     SHIRO 安全过滤：
    	1）拦截URL地址  /s/* 导航到登入页面 /s/adminLogin.do
    	2）登入成功 /s/adminIndex.do
    	3）未授权  /s/unauthorized.do
    	
              异常解决：
        1）org.apache.shiro.authc.UnknownAccountException
        	未知帐号错误
        2）org.apache.shiro.authc.IncorrectCredentialsException
        	密码错误（密码与数据库匹配保持一致）
        3）org.apache.shiro.authc.AuthenticationException
        	认证失败
     	4）java.lang.IllegalArgumentException: SessionContext must be an HTTP compatible implementation.
    		将<filter><filter-name>shiroFilter</filter-name><filter>在web.xml的位置
			移动到所有涉及的URL过滤的filter前面
			
	 ---------------------------------------------------------
	  Spring国际化 Test.jsp页面: 
	 ---------------------------------------------------------
	 <%@ page language="java"  pageEncoding="UTF-8"%>
	 <%@ taglib prefix="spring" uri="WEB-INF/lib/spring.tld"%>
	 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	 <html>
	  <head>
	    <title>Spring国际化</title>
	  </head>
	  <body>
	    <spring:message code="main.title" /><br>
	    <input type="button" value="<spring:message code="main.title" />"/><br>
	  </body>
	 </html>
	 ---------------------------------------------------------
	 Spring国际化 ,自动默认当前用户的语言，比如客户端是中文系统，
	   应用程序自动寻找messages_zh.properties资源文件，是英语系统，则自动寻找messages_en.properties资源文件。
	   
	 ========================================================= -->

