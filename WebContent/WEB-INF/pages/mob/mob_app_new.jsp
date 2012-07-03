<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="list m">
  <ul>
 	<c:forEach items="${softPageModel.data}" var="item" varStatus="vs">
	 <li>
	   	<div class="icon"><a href="mobSoft.do?softId=${item.soft_id}"><img  src="${item.icon}" width="60" height="60" /></a></div>
		<h3><a href="mobSoft.do?softId=${item.soft_id}">${item.cn_name}</a></h3>
		<div class="info">
			<span id="type">美化壁纸</span>
			<span id="date">${item.down_amount}次下载</span>
			<div class="mb">${item.package_size}</div>
		</div>
		<div class="downbox"><a href="${item.down_url}" class="down_item">免费下载</a></div>
		<img src="res/images/mob_star${item.grade}.png" class="stars"/>	
	 </li>
	 </c:forEach>
   </ul>
</div>
