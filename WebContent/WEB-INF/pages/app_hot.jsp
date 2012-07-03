<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div <c:choose><c:when test="${wz == null}">class="hotline mb10"</c:when><c:otherwise>class="hotline r"</c:otherwise></c:choose> id="c1">
	<div class="titlebar">
		<ul>
			<li class="selected" id="yy">热门应用</li>
			<li>热门游戏</li>
		</ul>
	</div>
	<ul class="yylist bgbtm" style="display:block;" id="d2"></ul>
	<ul class="yylist bgbtm" id="d3"></ul>
</div>
<!--热门应用 end-->