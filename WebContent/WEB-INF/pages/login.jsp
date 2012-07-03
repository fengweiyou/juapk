<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style media="screen"></style>
<title>安智市场|Android手机软件游戏下载平台</title>
<meta name="keywords" content="android,juapk,安智网,安卓软件,安卓游戏,安卓,android,安卓,sdk,android(安卓),刷机,market">
<meta name="description" content="机友市场是一款android资源下载平台，提供海量中文软件/游戏免费下载，是国内最好的android手机软件市场之一">
<meta name="author" content="机友市场">
<meta name="copyright" content="机友市场">
<meta content="ie=7" http-equiv="x-ua-compatible">
<!--<link type="image/x-icon" href="#.ico" rel="shortcut icon">-->
<link rel="stylesheet" href="<c:url value="res/css/common.css"/>">
<link rel="stylesheet" href="<c:url value="res/css/login.css"/>">
<script type="text/javascript" src="<c:url value="res/js/scroller.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/dd_belatedpng_0.0.8a-min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/change.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/jquery-1.7.1.min.js"/>"></script>
<script defer="defer" language="javascript">
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){style();});
function style()
{
    getfocus(".sc","搜索应用/游戏");
} 
</script>
<title>安智市场|国内最具人气的android手机软件市场</title>
</head>
<body>
	<!-- 头部导航和搜索 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!--主体-->
	<div class="mainbox bgbtm">
	   <div class="titlebox">
			<em class="jt l"></em>
			<h1 class="l">安智市场用户登录</h1>
		</div>
		<div class="out">
			<div class="m_l l">
			<form action="http://www.anzhi.com/login.php?act=submit" method="post" id="login_form">
				<div class="input">
					<div class="tab l"><span id="xx"></span>用户名</div>
					<div class="txt l"><input name="user_name" class="ltxt" id="com1"></div>
				    <input type="hidden" name="referer" value="http://www.anzhi.com/sort_2_1.do">
                   </div>
				<div class="input">
					<div class="tab l"><span id="xx"></span>密码</div>
					<div class="txt l"><input type="password" name="user_password" class="ltxt" id="com2"></div>
					<!-- <div class="getpwd l"><a href="#">忘记密码?</a></div> -->
				</div>
				<div class="jg"></div>
				<div class="input">
					<div class="tab l"></div>
					<div class="l"><input type="checkbox"><span>记住用户名</span>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"><span>自动登录</span></div>
			   </div>
				<div class="logbtn"><a href="http://www.anzhi.com/login.php#" onclick="">登 录</a></div>
			</form>
				<div class="jg">还没成为安智市场用户? &nbsp;<a href="register.do">立即注册</a></div>
				<div class="jg"></div>
				<div class="jg"></div>
			</div>
			<div class="m_r r">
				<ul>
					<li>
						<div class="l limg"><img src="res/images/img1.png"></div>
						<div class="info l">
							<h1>海量精品软件免费下载！</h1>
							<p>搜罗最新最流行的精品应用游戏，<br>轻松一键免费下载！</p>
						</div>
					</li>
					<li>
						<div class="l limg"><img src="res/images/img2.png"></div>
						<div class="info l">
							<h1>满足不同用户的个性化需求！</h1>
							<p>精心打造多种特色功能，<br>满足不同用户的个性化需求！</p>
						</div>
					</li>
					<li>
						<div class="l limg"><img src="res/images/img3.png"></div>
						<div class="info l">
							<h1>多种客户端，全方位的下载渠道！</h1>
							<p>多种客户端组成的全方位的下载渠道，<br>力求给用户带来全方位的下载体验！</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!--主体end-->
	<script>
	key_arr = ['user_name', 'user_password'];
	for (i in key_arr) {
	    obj = $("input[name='"+ key_arr[i] +"']");
	    obj.keydown(function(event) {  
	        if (event.keyCode == 13) {  
	            $('#login_form').submit();
	        }  
	    });
	}
	</script>
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>