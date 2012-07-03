<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0" name="viewport">
<title>最新</title>
<link rel="stylesheet" href="<c:url value="res/css/mob_common.css"/>">
</head>
<body>
<!-- 头部导航和搜索 -->
<jsp:include page="mob_header.jsp"></jsp:include>
<!--标题栏-->
<div class="m titlebar">
	<div class="left <c:if test="${mt==0}">selected</c:if>"><a href="${linkUrl}&mobTitle=0">推 荐</a></div>
	<div class="left <c:if test="${mt==1}">selected</c:if>"><a href="${linkUrl}&mobTitle=1">最 新</a></div>
	<div class="left w_34 <c:if test="${mt==2}">selected</c:if>"><a href="${linkUrl}&mobTitle=2">分 类</a></div>
	<em class="bright" id="first"></em>
	<em class="bright" id="second"></em>
</div>

<!-- 推荐 -->
<c:if test="${mt==0}">
</c:if>
<!-- 最新 -->
<c:if test="${mt==1}">
  <jsp:include page="mob_app_new.jsp"></jsp:include>
</c:if>
<!-- 分类 -->
<c:if test="${mt==2}">
  <jsp:include page="mob_app_sort.jsp"></jsp:include>
</c:if>

<!--翻页-->
<footer class="footer m">
<div class="pageline">
   <div class="p_center">1/2198
	<a class="next" href="/app.php?&index_start=10">下一页</a>		
   </div>
</div>
<!-- 底部 -->
<jsp:include page="mob_footer.jsp"></jsp:include>
</footer>
</body>
</html>
