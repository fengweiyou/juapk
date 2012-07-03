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
<link rel="stylesheet" href="res/css/app.css">
<script type="text/javascript" src="res/js/scroller.min.js"></script>
<script type="text/javascript" src="res/js/dd_belatedpng_0.0.8a-min.js"></script>
<script type="text/javascript" src="res/js/change.min.js"></script>
<script type="text/javascript" src="res/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="res/js/sort.js"></script>
<script type="text/javascript" src="res/js/jquery.lazyload.min.js"></script>
<script defer="defer" language="javascript">
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){
	style();
	getSortList('0','应用类软件数据加载失败..');
	getSortList('1','游戏类软件数据加载失败..');
	$("img").lazyload();
});
function style(){getfocus(".sc","搜索应用/游戏");}
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
	<!--主体内容 -->	
	<div class="w_945 mb10">
		<!-- 左边 软件列表 -->
		<jsp:include page="soft_list.jsp"></jsp:include>
		<!-- 右边 应用分类 -->
		<jsp:include page="soft_sort.jsp"></jsp:include>
	</div>
	<!--主体内容end -->
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>