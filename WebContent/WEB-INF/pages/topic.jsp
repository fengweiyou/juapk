<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style media="screen"></style>
<title>安智市场|Android手机软件游戏下载平台</title>
<meta name="keywords" content="android,juapk,安智网,安卓软件,安卓游戏,安卓,android,安卓,sdk,android(安卓),刷机,market">
<meta name="description" content="机友市场是一款android资源下载平台，提供海量中文软件/游戏免费下载，是国内最好的android手机软件市场之一">
<meta name="author" content="机友市场">
<meta name="copyright" content="机友市场">
<meta content="ie=7" http-equiv="x-ua-compatible">
<!--<link type="image/x-icon" href="#.ico" rel="shortcut icon">-->
<link rel="stylesheet" href="res/css/common.css">
<link rel="stylesheet" href="res/css/topic.css">
<script type="text/javascript" src="res/js/scroller.min.js"></script>
<script type="text/javascript" src="res/js/dd_belatedpng_0.0.8a-min.js"></script>
<script type="text/javascript" src="res/js/change.min.js"></script>
<script type="text/javascript" src="res/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="res/js/jquery.lazyload.min.js"></script>
<script defer="defer" language="javascript">
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){style();bannaerList();});
function style()
{
    getfocus(".sc","搜索应用/游戏");
    showdown("d1");
    showdown("d2");
    showdown("d3");
    showdown("d4");
    changetabs();
    $("img").lazyload();
} 
</script>
<title>安智市场|国内最具人气的android手机软件市场</title>
</head>
<body>
	<!-- 头部导航和搜索 -->
	<jsp:include page="header.jsp"></jsp:include>
	
	<!--picSroll 焦点图-->
	<div class="w_945 mb10">
	<jsp:include page="picScroll.jsp"></jsp:include>
	</div>
	<!--主体 -->
	<div class="w_945 mb10 main">
		<!--左边 专题列表-->
		<c:choose>
			<c:when test="${ttf == 0}">
				<jsp:include page="topic_list.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="topic_left.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
		<!--右边 专题列表-->
		<jsp:include page="topic_right.jsp"></jsp:include>
	</div>
	<!--主体 end -->
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>