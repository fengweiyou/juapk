<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>.fillet_top {border-radius:5px 5px 0px 0px; -moz-border-radius:5px 5px 0px 0px;}.fillet_top {-webkit-border-top-left-radius:5px 5px; -webkit-border-top-right-radius:5px 5px; -webkit-border-bottom-right-radius:0px 0px; -webkit-border-bottom-left-radius:0px 0px;}.fillet_all {border-radius:5px 5px 5px 5px; -moz-border-radius:5px 5px 5px 5px;}.fillet_all {-webkit-border-top-left-radius:5px 5px; -webkit-border-top-right-radius:5px 5px; -webkit-border-bottom-right-radius:5px 5px; -webkit-border-bottom-left-radius:5px 5px;}.fillet_left {border-radius:5px 0px 0px 5px; -moz-border-radius:5px 0px 0px 5px;}.fillet_left {-webkit-border-top-left-radius:5px 5px; -webkit-border-top-right-radius:0px 0px; -webkit-border-bottom-right-radius:0px 0px; -webkit-border-bottom-left-radius:5px 5px;}.fillet_right {border-radius:0px 5px 5px 0px; -moz-border-radius:0px 5px 5px 0px;}.fillet_right {-webkit-border-top-left-radius:0px 0px; -webkit-border-top-right-radius:5px 5px; -webkit-border-bottom-right-radius:5px 5px; -webkit-border-bottom-left-radius:0px 0px;}</style>
<link rel="stylesheet" href="<c:url value="/res/dwz/_css/common.css"/>">
<link rel="stylesheet" href="<c:url value="/res/dwz/_css/header.css"/>">
<link rel="stylesheet" href="<c:url value="/res/dwz/_css/footer.css"/>">
<link rel="stylesheet" href="<c:url value="/res/dwz/_css/login.css"/>">
<link rel="stylesheet" href="<c:url value="/res/dwz/_css/validationEngine.jquery.css"/>">
<script type="text/javascript" src="<c:url value="/res/js/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/dwz/_js/jquery.validationEngine-cn.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/dwz/_js/jquery.validationEngine.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/dwz/_js/login.js"/>"></script>
</head>
<body>
<!-- 
	code : chenyoca (chenyoca@163.com)
	date : 2011-11-18
	desc : div#main_wrapper 用于刷渐变背景，无实际意义。
 -->
<div id="main_wrapper">
<!-- 
	code : chenyoca (chenyoca@163.com)
	date : 2011-11-18
	desc : div#wrapper 是页面的最大布局框架。它的CSS样式在common.css中，用于
		   设置页面显示区域的大小。当前设置为1000px，左右居中。
 -->
 <div id="wrapper">
	<div id="header_large"></div>
	<div id="login_box" class="fillet_all">
		<div id="login_content_box" class="fillet_all">
			<div id="login_form_box" class="floatLeft">
			<form action="<c:url value="/s/invalidLogin.do"/>" method="post" id="login_form">
				<input type="hidden" name="_method" value="put">
				<label for="user.account">帐号：</label>
				<input type="text" value="" name="user_name" id="username" class="input_style fillet_all validate[required,length[4,20]]">
				<span></span>
				<div class="blank10"></div>
				<label for="user.password">密码：</label>
				<input type="password" value="" name="password" id="password" class="input_style fillet_all validate[required,length[6,20]]">
				<span></span>
				<div class="blank10"></div>
				<label for="user.authcode">验证码：</label>
				<input id="validate_code_input" name="authcode" class="code input_style fillet_all" type="text" maxlength="5" style="float:left; margin-right:5px;">
		     	<img id="validate_code_img"src="<c:url value="/auth/captcha.jpg"/>" onclick="this.src=this.src+'?'+Math.random()" style="float:left;"/>
				<span></span>
				<div class="blank10 clear"></div>
				<div class="blank10 clear"></div>
				<input type="submit" id="login_button" value="登录">
				<span></span>
				<div class="blank10 clear"></div>
			</form>
			</div>
			<div id="login_img_box" class="floatRight"></div>
		</div>
	</div>
	<!-- Footer -->
	<div id="footer_simple">
		Copyright © juapk.com 2012 AllRight Reserved
	</div>
	<!-- Footer End -->
  </div>
</div><!-- End of div#main_wrapper  -->
<script type="text/javascript" src="./login_files/fillet.js"></script>
<script type="text/javascript">
jQuery(function($){
	/*** 渲染圆角 ***/
	DD_roundies.addRule('.fillet_top', '5px 5px 0px 0px', true);
	DD_roundies.addRule('.fillet_all', '5px 5px 5px 5px', true);
	DD_roundies.addRule('.fillet_left', '5px 0px 0px 5px', true);
	DD_roundies.addRule('.fillet_right', '0px 5px 5px 0px', true);
});
</script>
</body>
</html>