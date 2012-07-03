<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<jsp:include flush="false" page="admin_css.jsp"></jsp:include>
<jsp:include flush="false" page="admin_javascript.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	DWZ.init("<c:url value="/res/dwz/dwz.frag.xml"/>", {
		// loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
		// loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"<c:url value="/res/dwz/themes"/>"});
		}
	});
});
</script>
</head>
<body scroll="no">
  <div id="layout">
  	<!-- 头部导航设置 begin -->
	<jsp:include flush="true" page="admin_header.jsp"></jsp:include>
	<!-- 左侧菜单 begin -->
	<c:if test="${navMenuId==0}">
	<div id="leftside">
		<div id="sidebar_s">
			<div class="collapse">
				<div class="toggleCollapse"><div></div></div>
			</div>
		</div>
		<div id="sidebar">
			<div class="toggleCollapse"><h2>控制板</h2><div>收缩</div></div>
			<jsp:include flush="true" page="admin_left_menu.jsp"></jsp:include>
		</div>
	</div>
	<!-- 左侧菜单 end -->
	</c:if>
	<!-- 桌面内容 begin -->
	<div id="container">
		<div id="navTab" class="tabsPage">
			<div class="tabsPageHeader">
				<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
					<ul class="navTab-tab">
						<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
					</ul>
				</div>
				<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
				<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
				<div class="tabsMore">more</div>
			</div>
			<ul class="tabsMoreList">
				<li><a href="javascript:;">桌面</a></li>
			</ul>
			<div class="navTab-panel tabsPageContent layoutBox">
				<div class="page unitBox" >
					<div class="pageFormContent" layoutH="80" width="100%">
						<p>巨卓市场</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 桌面内容 end -->
  </div>
  <!-- 底部 begin -->
  <jsp:include flush="false" page="admin_footer.jsp"></jsp:include>
</body>
</html>