<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="hotline r mb10">
	<div class="titlebox btop">
		<em class="jt l"></em>
		<h1 class="l">猜你喜欢</h1>
	</div>
	<ul class="yylist bgbtm" style="display:block;" id="d1">
	<c:forEach items="${likeSoftList}" var="item">
     <li>
		<div class="img l"><img src="${item.icon}"></div>
		<div class="yyname l"><a href="#"><h2>${item.cn_name}</h2></a></div>
		<div class="downnum l">${softInfo.down_amount}次下载</div>
		<div class="down" id="s_down"><a href="${item.down_url}">下 载</a></div>
	 </li>
	</c:forEach>
    </ul>
</div>
<!--猜你喜欢 end-->