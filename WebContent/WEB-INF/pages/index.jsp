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
<link rel="stylesheet" href="<c:url value="res/css/common.css"/>">
<link rel="stylesheet" href="<c:url value="res/css/index.css"/>">
<script type="text/javascript" src="<c:url value="res/js/scroller.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/dd_belatedpng_0.0.8a-min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/change.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/jquery.json-2.2.min.j"/>s"></script>
<script type="text/javascript" src="<c:url value="res/js/soft.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/bannaer.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/index.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/jquery.lazyload.min.js"/>"></script>
<title>安智市场|国内最具人气的android手机软件市场</title>
</head>
<body>
	<!-- 头部导航和搜索 -->
	<jsp:include page="header.jsp"></jsp:include>

	<!--焦点图横栏-->
	<div class="w_945 line1 mb10">
		<!--焦点图-->
		<jsp:include page="picbox.jsp"></jsp:include>
		<!--焦点图右侧-->
		<jsp:include page="picmarket.jsp"></jsp:include>
	</div>
	<!--焦点图横栏end-->

	<!--精品推荐和热门-->
	<div class="w_945 mb10">
		<!--精品-->
		<div class="jptj l bgbtm">
			<div class="titlebox">
				<em class="jt l"></em>
				<h1 class="l">精品推荐</h1>
				<em class="jtr r"></em>
				<a class="more r" href="MoreSoftList.do?softType=0">更多</a>		
			</div>
			<ul class="tjlist" id="d1">
			 	<c:forEach items="${softCommendList}" var="item">
			    <li>
					<div class="icon"><a href="soft_${item.soft_id}.html"><img src="res/images/grey.gif" data-original="${item.icon}"></a></div>
					<div class="name"><a href="soft_${item.soft_id}.html"><h2>${item.cn_name}</h2></a></div>
					<div class="star"><img src="res/images/star${item.grade}.png"></div>
					<div class="down"><a href="${item.down_url}">下 载</a></div>
				</li>
			 	</c:forEach>
	        </ul>
		</div>
		<!--精品end-->
	
		<!--热门应用-->
		<jsp:include page="app_hot.jsp"></jsp:include>
	</div>

	<!--bannaer 信息-->
	<div class="w_945 mb10" id="bannaer"></div>

	<!--最新应用，游戏，排行榜-->
	<div class="w_945 mb10">
		<!-- 最新应用 begin-->
		<div class="zs l">
			<div class="titlebox">
				<em class="jt l"></em>
				<h1 class="l">最新应用</h1>
				<em class="jtr r"></em>
				<a class="more r" href="MoreSoftList.do?softType=1">更多</a>
			</div>
			<ul class="zslist bgbtm" id="d4"></ul>
		</div>
		<!-- 最新应用end-->
		
		<!-- 最新游戏 begin-->
		<div class="zs l">
			<div class="titlebox">
				<em class="jt l"></em>
				<h1 class="l">最新游戏</h1>
				<em class="jtr r"></em>
				<a class="more r" href="MoreSoftList.do?softType=2">更多</a>
			</div>
			<ul class="zslist bgbtm" id="d5">
				<c:forEach items="${newSoftList_Game}" var="item">
				<li>
					<div class="img l"><img src="res/images/grey.gif" data-original="${item.icon}"></div>
					<div class="yyname l"><a href="soft.do"><h2>${item.cn_name}</h2></a></div>
					<div class="downnum l">${item.upload_date}</div>
					<div class="star r" id="zsstar"><img src="res/images/star${item.grade}.png"></div>
					<div id="zs_down" class="down"><a href="${item.down_url}">wdw</a></div>
				</li>
				</c:forEach>
			</ul>
		</div>
		<!-- 最新游戏 end-->
		
		<!-- 应用排行榜 -->
		<jsp:include page="app_top.jsp"></jsp:include>
	</div>
	<!--最新应用，游戏，排行榜end-->
	<!-- ads -->
	<div class="w_945 mb10"><a href="#" title="巨卓市场"><img src="res/upload/ad/bannaer/btad.png"/></a></div>
	<!-- 友情链接 begin -->
	<div id="flinks" class="w_945 mb10">
	<h3 class="titlebox"><span class="linkt">友情链接</span><span class="yewu">本站链接文字：<b><a href="#">巨卓市场</a></b> 欢迎各大媒体、网站、厂商洽谈合作, <a href="#">详情请与我们联系。</a></span></h3> 
	<ul> 
	 <li><a href="#">中国移动</a></li><li><a href="#" >手机搜狐网</a></li><li><a href="#">巨卓论坛</a></li><li><a href="#">手机论坛</a> <a href="#">手机联盟网</a></li> 
	</ul> 
	</div> 
	<!-- 友情链接 end -->
	
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>