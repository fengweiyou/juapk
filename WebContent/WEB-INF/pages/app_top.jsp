<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div <c:choose><c:when test="${wz == null}">class="hotline"</c:when><c:otherwise>class="hotline r"</c:otherwise></c:choose> id="c2">
	<div class="titlebar">
		<ul>
			<li class="selected" id="date">日排行</li>
			<li id="week">周排行</li>
			<li id="all">月排行</li>
		</ul>
	</div>
	<ul class="yylist pt bgbtm" style="display:block;" id="d6"></ul>
	<ul class="yylist pt bgbtm" id="d7"></ul>
	<ul class="yylist pt bgbtm" id="d8"></ul>
</div>
<!-- 应用排行榜 end -->