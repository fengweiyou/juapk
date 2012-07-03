<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/CommonMultiPages.tld" prefix="CommonMultiPages"%>
<!--左边-->
<div class="m_l l">
	<!--标题-->
	<div class="titlebox">
     	<em class="jt l"></em>
     	<h1 class="l"><a href="index.do">巨卓市场</a></h1>
     	<h1 class="l">&gt;
     		<c:choose>
     			<c:when test="${stf == 0}">应用</c:when>
     			<c:when test="${stf == 1}">游戏</c:when>
     			<c:when test="${stf == 2}">精品推荐</c:when>
     			<c:when test="${stf == 3}">最新应用</c:when>
     			<c:when test="${stf == 4}">最新游戏</c:when>
     			<c:when test="${stf == 5}">${searchStr}</c:when>
     			<c:otherwise>其他</c:otherwise>
     		</c:choose>
     	</h1>
     	<c:if test="${stf < 2}">
     	<div class="r pl">
        	<span>排序：</span>
         	<a class="selected" href="<c:if test="${stf == 0}">softList.do?softType=0&sort=hot</c:if>
         		<c:if test="${stf == 1}">softList.do?softType=1&sort=hot</c:if>">最热软件</a>
         	<span>|</span>
         	<a href="<c:if test="${stf == 0}">softList.do?softType=0&sort=new</c:if>
         		<c:if test="${stf == 1}">softList.do?softType=1&sort=new</c:if>">最新软件</a>
     	</div>
     	</c:if>
     </div>
     <!--标题end-->
	 <!--列表-->
	 <div class="outbox">
		<ul style="display:block">
			<c:forEach items="${softPageModel.data}" var="item" varStatus="vs">
				<li <c:if test="${vs.count/2==0}">class="double"</c:if>>
					<div class="img l">
						<a href="soft_${item.soft_id}.html">
							<img src="res/images/grey.gif" data-original="${item.icon}">
						</a>
					</div>
					<div class="info l">
						<div class="top">
							<span class="name l"><a href="soft_${item.soft_id}.html">${item.cn_name}</a>版本：${item.soft_version}</span>
							<span class="dnum l">下载：${item.down_amount}次</span>
							<div class="star l"><span>评分：</span><img src="res/images/star${item.grade}.png"></div>
						</div>
						<div class="bot">${item.details}</div>
					</div>
					<div class="appdown l">
						<a href="${item.down_url}" title="点击下载">下载</a>
					</div>	
				</li>
			</c:forEach>
			<!-- 分页begin -->
			<li class="pages">
				<CommonMultiPages:pager var="${softPageModel}">
				   <CommonMultiPages:prev/>
				   <CommonMultiPages:index/>
				   <CommonMultiPages:next/>
				</CommonMultiPages:pager>
			</li>
			<!-- 分页end -->
		</ul>
	 </div>
	 <!--列表end-->
</div>
<!--左边end-->