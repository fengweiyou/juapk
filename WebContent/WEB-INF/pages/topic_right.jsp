<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--右边-->
<div class="m_r r">
	<div class="titlebox">
		<em class="jt l"></em>
		<h1 class="l">专题列表</h1>
	</div>
	<ul class="ztlist">
	 <c:forEach items="${topicList}" var="item" varStatus="vs">
     <li <c:if test="${vs.count==1}">class="selected"</c:if>><a href="topic_${item.topic_id}.html">${item.title}</a><span>&gt;</span></li>
	 </c:forEach>
	</ul>
</div>
<!--右边end-->