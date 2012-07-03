<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/CommonMultiPages.tld" prefix="CommonMultiPages"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0" name="viewport">
<title>安智市场</title>
<link rel="stylesheet" href="<c:url value="res/css/mob_common.css"/>">
</head>
<body>
<!-- 头部导航和搜索 -->
<jsp:include page="mob_header.jsp"></jsp:include>

<!--首页推荐-->
<div class="m tj">
	<div class="t_center">
		<img  width="6" height="6" src="res/images/dot.gif" id="dotimg"/>
		<h2>安智市场特别推荐</h2>		
	</div>
</div>
<!--推荐列表-->
<div class="list m">
   <ul>
	 <c:forEach items="${softCommendListPageModel.data}" var="item" varStatus="vs">
	 <li>
    	<div class="icon"><a href="mobSoft.do?softId=${item.soft_id}"><img src="${item.icon}" width="60" height="60" /></a></div>
		<h3><a href="mobSoft.do?softId=${item.soft_id}">${item.cn_name}</a></h3>
		<div class="info">
			<span id="type">系统工具</span>
			<span id="date">${item.down_amount}次下载</span>
			<div class="mb">${item.package_size}</div>
		</div>
		<div class="downbox"><a href="${item.down_url}" class="down_item">免费下载</a></div>
		<img src="res/images/mob_star${item.grade}.png" class="stars"/>	
	 </li>
	 </c:forEach>
   </ul>
</div>
<!--翻页-->
<footer class="footer m">
<div class="pageline">
  <div class="p_center">
	<CommonMultiPages:pager var="${softCommendListPageModel}">
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