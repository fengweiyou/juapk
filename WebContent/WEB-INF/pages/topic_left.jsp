<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="res/js/bannaer.js"></script>
<!-- 专题列表 -->
<!--左边-->
<div class="m_l l">
	<!--热门专题-->
	<div class="outbox bgbtm mb10">
		<div class="titlebox">
			<em class="jt l"></em>
			<h1 class="l">热门专题</h1>
		</div>
	<!--最佳游戏-->
	<div class="bestgame">
		<div class="gimg l"><img src="res/images/grey.gif" data-original="${topic.image}"></div>
		<div class="ginfo l">
			<h1>热门专题：${topic.title}</h1>
			<h2>${topic.sub_title}</h2>
			<p>${topic.details}</p>
		</div>
	</div>
	<!--最佳游戏end-->
	<!--最佳游戏列表-->
	<ul class="tjlist" id="d1">
	   <c:forEach items="${softList}" var="item"> 	
		<li>
			<div class="icon"><a href="soft_${item.soft_id}.html"><img src="res/images/grey.gif" data-original="${item.icon}"></a></div>
			<div class="name"><a href="soft_${item.soft_id}.html"><h2>${item.cn_name}</h2></a></div>
			<div class="star"><img src="res/images/star${item.grade}.png"></div>
			<div class="down"><a href="${item.down_url}">下 载</a></div>
		</li>
        </c:forEach>
    </ul>
	<div class="morezt c"><a href="topicList.do?topicId=${topic.topic_id}">查看更多专题应用</a></div>
	<!--最佳游戏列表end-->
	</div>
	<!--热门专题end-->
	<!--bannaer 信息-->
	<div class="w_945 mb10" id="bannaer"></div>
	<!--最佳应用列表-->
	<div class="zjyylist bgbtm">
		<div class="title">
			<ul>
		      <li id="zj" class="selected" onmouseover="$(&quot;#c2&quot;).show();$(&quot;#c3&quot;).hide();$(&quot;#c4&quot;).hide();$(&quot;#des2&quot;).show();$(&quot;#des3&quot;).hide();$(&quot;#des4&quot;).hide();">影音播放</li>
		      <li id="zj2" onmouseover="$(&quot;#c3&quot;).show();$(&quot;#c2&quot;).hide();$(&quot;#c4&quot;).hide();$(&quot;#des3&quot;).show();$(&quot;#des2&quot;).hide();$(&quot;#des4&quot;).hide();">装机必备</li>
			  <li onmouseover="$(&quot;#c4&quot;).show();$(&quot;#c2&quot;).hide();$(&quot;#c3&quot;).hide();$(&quot;#des4&quot;).show();$(&quot;#des2&quot;).hide();$(&quot;#des3&quot;).hide();">生活服务</li>
			</ul>
		</div>
		<ul class="imglist">
			<li class="selected" id="yy1"></li>
			<li class="" id="yy2"></li>
			<li class="" id="yy3"></li>
		</ul>
	    <div class="des" id="des2">听音乐，看视频，一个都不能少。</div>
		<!--最佳游戏列表-->
		<ul class="tjlist" id="d2" style="display:block;">
			<c:forEach items="${softListA}" var="item">
			<li>
				<div class="icon"><a href="soft_${item.soft_id}.html"><img src="res/images/grey.gif" data-original="${item.icon}"></a></div>
				<div class="name"><a href="soft_${item.soft_id}.html"><h2>${item.cn_name}</h2></a></div>
				<div class="star"><img src="res/images/star${item.grade}.png"></div>
				<div class="down"><a href="${item.down_url}">下 载</a></div>
			</li>
			</c:forEach>
		</ul>
	    <div class="morezt c" id="c2"><a href="topicList.do?topicId=0">查看更多专题应用</a></div>
		<div class="des" id="des3">安乐生活，智慧下载­——安智，带您进入绿色资源的海洋</div>
		<!--最佳游戏列表-->
		<ul class="tjlist" id="d3">
			<c:forEach items="${softListB}" var="item">
			<li>
				<div class="icon"><a href="soft_${item.soft_id}.html"><img src="res/images/grey.gif" data-original="${item.icon}"></a></div>
				<div class="name"><a href="soft_${item.soft_id}.html"><h2>${item.cn_name}</h2></a></div>
				<div class="star"><img src="res/images/star${item.grade}.png"></div>
				<div class="down"><a href="${item.down_url}">下 载</a></div>
			</li>
			</c:forEach>
		</ul>
	    <div class="morezt c" id="c3"><a href="topicList.do?topicId=1">查看更多专题应用</a></div>
		<div class="des" id="des4">安生活，享娱乐，智理财。安智市场——你Hold住吗？</div>
		<!--最佳游戏列表-->
		<ul class="tjlist" id="d4">
			<c:forEach items="${softListC}" var="item">
			<li>
				<div class="icon"><a href="soft_${item.soft_id}.html"><img src="res/images/grey.gif" data-original="${item.icon}"></a></div>
				<div class="name"><a href="soft_${item.soft_id}.html"><h2>${item.cn_name}</h2></a></div>
				<div class="star"><img src="res/images/star${item.grade}.png"></div>
				<div class="down"><a href="${item.down_url}">下 载</a></div>
			</li>
			</c:forEach>
		</ul>
	    <div class="morezt c" id="c4"><a href="topicList.do?topicId=2">查看更多专题应用</a></div>
		<!--最佳游戏列表end-->
	</div>
	<!--最佳应用列表end-->
</div>
<!--左边end-->