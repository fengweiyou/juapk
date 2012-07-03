<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--左边-->
<div class="m_l l">
	<!--热门专题-->
	<div class="outbox bgbtm mb10">
		<div class="titlebox">
			<em class="jt l"></em>
       	    <h1 class="l"><a href="index.do">巨卓市场</a></h1><h1 class="l"> &gt;${topic.title}</h1>
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
		
		<!--列表-->
		<div class="outboxs">
			<ul style="display:block">
				<c:forEach items="${softList}" var="item" varStatus="vs">
				<li <c:if test="${vs.count/2==0}">class="double"</c:if>>
					<div class="img l">
						<a href="soft_${item.soft_id}.html">
							<img src="res/images/grey.gif" data-original="${item.icon}" alt="" title="">
						</a>
					</div>
					<div class="info l">
						<div class="top">
							<span class="name l"><a href="soft_${item.soft_id}.html">${item.cn_name}</a>版本：${item.soft_version}</span>
							<span class="dnum l">下载：${item.down_amount}次</span>
							<div class="star l"><span>评分：</span><img src="res/images/grey.gif" data-original="res/images/star${item.grade}.png"></div>
						</div>
						<div class="bot">${item.details}</div>
					</div>
					<div class="appdown l">
						<a href="${item.down_url}" title="点击下载">下载</a>
					</div>	
				</li>
				</c:forEach>
	       </ul>
		</div>
		<!--列表end-->
	</div>
</div>
<!--左边end-->