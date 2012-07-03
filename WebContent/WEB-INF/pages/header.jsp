<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--注册登录 -->
<div id="user_div">
	<div class="loginbox">
    	<div class="lb_inner w_945">
	        <a href="login.do">登录</a>|<a href="register.do">注册</a>
       	</div>
    </div>
</div>
<!--头部导航和搜索 -->
<div class="topbox w_945">
	<div class="lsbox">
		<h1 class="logoNew"><a href="index.html" title="巨卓市场"></a></h1>
		 <div class="schbox r">
			<em class="border l" id="left"></em>	
			<form action="MoreSoftList.do" class="l schform">
			<input name="softType" type="hidden" value="3">
			<input name="searchKey" value="搜索应用/游戏" class="sc l">
               <script>
               function chectit(){
                  var search_key = $("input[name='s']");
                  var val = jQuery.trim(search_key.val());
                  if(val == "搜索应用/游戏" || val ==""){
                       alert("请输入搜索信息");
                       return false;
                  }else if(val.length < 2){
                       alert("您输入的信息不够详细");
                       return false;
                  }
                  return true;
               }
               </script>
			<em class="l" id="icon"><input type="image" style="margin-top: 4px;" onclick="return chectit()" src="res/images/sc.png"></em>
			<em class="border l" id="right"></em></form>	
		</div>
	</div>
	<!--导航-->
	<div class="nav c">
		<div class="n_l l"></div>
		<div class="n_c l">
			<ul>
				<li><a href="index.html" <c:if test="${wz == 0}">class="selected"</c:if> id="index"><span>首 页</span></a></li>
				<li><a href="sort_0_1.html" <c:if test="${wz == 1}">class="selected"</c:if>><span>应 用</span></a></li>
				<li><a href="sort_1_1.html" <c:if test="${wz == 2}">class="selected"</c:if>><span>游 戏</span></a></li>
				<li><a href="essential.do" <c:if test="${wz == 4}">class="selected"</c:if> id="dev"><span>必备</span></a></li>
				<li><a href="topic.html" <c:if test="${wz == 3}">class="selected"</c:if>><span>专 题</span></a></li>
				<li><a href="index.html" target="_blank" id="bbs"><span>巨卓论坛</span></a></li>
			</ul>
			<em class="hot"><img src="res/images/hot.png" width="17" height="24"></em>		
		</div>
		<div class="n_r l"></div>
	</div>
	<!--导航end-->
</div>
<!--头部导航和搜索end -->