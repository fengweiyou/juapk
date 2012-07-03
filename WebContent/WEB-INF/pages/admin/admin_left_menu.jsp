<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="accordion" fillSpace="sideBar">
	<c:forEach items="${treeMenuList}" var="item" >
	<div class="accordionHeader">
		<h2><span>Folder</span>${item.name}</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree treeFolder">
			<c:forEach items="${item.children}" var="child" >
			<li><a href="<c:url value="${child.href}"/>" width="${child.width}" height="${child.height}"  reloadFlag="${child.reloadFlag}" rel="${child.rel}" target="${child.target}" external="${child.external}" >${child.name}</a></li>
			</c:forEach>
		</ul>
	</div>
	</c:forEach>
</div>