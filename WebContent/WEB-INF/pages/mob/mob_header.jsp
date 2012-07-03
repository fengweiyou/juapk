<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--顶部-->
<a name='top'></a>
<div class="header">
	<div class="logo"><a href="index.php"><img  src="res/images/logo2.png" alt="安智市场" title="安智市场"/></a></div>
	<a href="http://m.anzhi.com/redirect.php?do=dlapk&puid=91" class="downimg"></a>
</div>
<!--搜索-->
<div class="sbox">
<form action='search.php'>
	<div class="sch">
	<input class="search_text" name='keyword' value="" onclick='if (this.value=="搜索应用/游戏") {this.value="";}' />
	</div>
	<input type="submit" class="s_btn" value="搜索"/>
</form>
</div>
<!--搜索end-->
<!--导航-->
<div class="bigbox">
	<nav>
		<a href="mobIndex.do" <c:if test="${wz == 0}">class="selected"</c:if>><span>首页</span><em></em></a><a href="mobApp.do?softType=0" <c:if test="${wz == 1}">class="selected"</c:if>><span>应用</span><em></em></a><a href="mobApp.do?softType=1" <c:if test="${wz == 2}">class="selected"</c:if>><span>游戏</span><em></em></a><a href="mobTopic.do" <c:if test="${wz == 3}">class="selected"</c:if>><span>专题</span><em></em></a><a href="mobIndex.do" ><span>论坛</span></a><img src="res/images/hot.png" class="hot"/>
	</nav>
</div>