<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">
	<div class="headerNav">
		<a class="logo" href="#">标志</a>
		<ul class="nav">
			<li><a href="/juapk" target="_blank">首页</a></li>
			<li><a href="#" target="_blank">论坛</a></li>
			<li><a href="<c:url value="/s/logout.do"/>">退出</a></li>
		</ul>
		<ul class="themeList" id="themeList">
			<li theme="default"><div class="selected">蓝色</div></li>
			<li theme="green"><div>绿色</div></li>
			<!--<li theme="red"><div>红色</div></li>-->
			<li theme="purple"><div>紫色</div></li>
			<li theme="silver"><div>银色</div></li>
			<li theme="azure"><div>天蓝</div></li>
		</ul>
	</div>
	<div id="navMenu">
		<ul>
	    <c:forEach items="${navMenuList}" var="item" varStatus="vs">
		 	<li <c:if test="${item.id == 0}">class="selected"</c:if>><a href="<c:url value="${item.href}"/>"><span>${item.name}</span></a></li>
		</c:forEach>
		</ul>
	</div>
</div>
<!-- 头部导航设置 end -->