<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/CommonMultiPages.tld" prefix="CommonMultiPages"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0" name="viewport">
<title>专题</title>
<link rel="stylesheet" href="<c:url value="res/css/mob_common.css"/>">
</head>
<body>
<!-- 头部导航和搜索 -->
<jsp:include page="mob_header.jsp"></jsp:include>
<!--专题列表-->
<div class="m subject">
  <ul>
    <c:forEach items="${topicPageModel.data}" var="item" varStatus="vs">
    <li <c:if test="${vs.count==1}">class="bordertop"</c:if>>
      <span><a href="mobTopicList.do?topicId=${item.topic_id}">${item.title}（10个）</a></span>
	  <a href="mobTopicList.do?topicId=${item.topic_id}" class="more" title="展开列表"></a>
    </li>
    </c:forEach>
  </ul>
</div>
<!--翻页-->
<footer class="footer m">
<div class="pageline">
  <div class="p_center">
	<CommonMultiPages:pager var="${topicPageModel}">
	   <CommonMultiPages:prev/>
	   <CommonMultiPages:index/>
	   <CommonMultiPages:next/>
	</CommonMultiPages:pager>
  </div>
</div>
<!-- 底部 -->
<jsp:include page="mob_footer.jsp"></jsp:include>
</footer>
</body>
</html>