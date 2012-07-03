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
<link rel="stylesheet" href="res/css/essential.css">
<script type="text/javascript" src="res/js/scroller.min.js"></script>
<script type="text/javascript" src="res/js/dd_belatedpng_0.0.8a-min.js"></script>
<script type="text/javascript" src="res/js/change.min.js"></script>
<script type="text/javascript" src="res/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="res/js/sort.js"></script>
<script type="text/javascript" src="res/js/jquery.lazyload.min.js"></script>
<script type="text/javascript" src="res/js/essential.js"></script>
<style type="text/css">
.select_hot{width:943px;float:right;border-bottom:1px solid #ccc;}
	.select_hot_in{border:1px solid #fff;height:46px;overflow:hidden}
	.select_sj{height:22px;margin:1px;overflow:hidden}
		.select_sj a{float:left;display:block;line-height:22px;background:#dedede;margin-right:2px;padding:0 5px;}
		.select_sj a:hover,.select_sj a.on{background:#157502;color:#fcffef;text-decoration:none}
		.sj_type{height:22px;overflow:hidden}
		.sj_type a{line-height:22px;padding:0 5px;float:left;display:block}

		.sj_type li{display:none}
</style>
<script defer="defer" language="javascript">
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){
	style();
	getSortList('0','应用类软件数据加载失败..');
	getSortList('1','游戏类软件数据加载失败..');
	$("img").lazyload();
	$("#mo_stat_list").hover({type:3});
	$("a", $("#select_brand_bar")).mouseover(function(){
		$(".on", $("#select_brand_bar")).removeClass("on");
		$(this).addClass("on");
		$("li", $("#brand_bar_con")).hide();
		$("#hot_"+$(this).attr('name')).show();
	});
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
        <div class="m_l l">
	      <div class="outbox bgbtm mb10">
      		<div class="titlebox">
				<em class="jt l"></em>
	       	    <h1 class="l">装机必备</h1>
			</div>
		 <div class="select_hot">
	    	<div class="select_hot_in">
	    	 <div id="select_brand_bar" class="select_sj">
	    	 	<a href="#" name="tab0" class="on">热门</a>
	    	 	<a href="#" name="tab1" title="1" class="">宅男宅女</a>
	    	 	<a href="#" name="tab2" title="1" class="">程序员</a>
	    	 	</div>
	            <ul id="brand_bar_con" class="sj_type">
	            <li style="display: block; " id="hot_tab0"><a href="#" title="11">壁纸</a><a href="#" title="22纸">桌面插件(widget)</a><a href="#" title="33">电话增强</a><a href="#" title="44">流量监控</a></li>
	            <li id="hot_tab1" style="display: none; "><a href="#" title="11">来电防火墙</a><a href="#" title="22纸">即时聊天(IM)</a><a href="#" title="33">社交网络(SNS)</a><a href="#" title="44">流量监控</a></li>
	            <li id="hot_tab2" style="display: none; "><a href="#" title="11">壁纸</a><a href="#" title="22纸">输入法	图书阅读器</a><a href="#" title="33">备份/安全</a><a href="#" title="44">流量监控</a></li>
	            </ul>
	        </div>
	    </div>
		   <div class="tjlist ">
			 <ul class="mo_list" id="mo_stat_list">
			 <c:forEach items="${softEssentialList}" var="item" varStatus="vs">
				<li tit="爱丽丝_馋猫" viewnum="3866125" downnum="1376053" vip="1">
					<a href="#" target="_blank">
					 <img src="res/images/grey.gif" data-original="${item.icon}" width="50" alt="" title="">
					</a>
				</li>
			 </c:forEach>
			 </ul>	
  		    </div>
	  	  <div class="morezt c" id="c4"><a href="#">查看更多</a></div>
  		  </div>
  		</div>
	</div>
	<!--主体内容end -->
	
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>