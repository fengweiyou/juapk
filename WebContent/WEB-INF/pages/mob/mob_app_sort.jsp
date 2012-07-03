<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="m subject">
  <ul>
	 <c:forEach items="${sortList}" var="item" varStatus="vs">
	 <li <c:if test="${vs.count==1}">class="bordertop"</c:if>>
	    <span><a href="mobTopicList.do?topicId=${item.id}">${item.name}（${item.amount}个）</a></span>
	 	<a href="mobTopicList.do?topicId=${item.id}" class="more" title="展开列表"></a>
	  </li>
      </c:forEach>
   </ul>
</div>
