<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style media="screen"></style>
<title>安智市场 最新版2.1.4--安智市场|Android手机软件游戏下载平台</title>
<meta name="keywords" content="android,juapk,安智网,安卓软件,安卓游戏,安卓,android,安卓,sdk,android(安卓),刷机,market">
<meta name="description" content="机友市场是一款android资源下载平台，提供海量中文软件/游戏免费下载，是国内最好的android手机软件市场之一">
<meta name="author" content="机友市场">
<meta name="copyright" content="机友市场">
<meta content="ie=7" http-equiv="x-ua-compatible">
<link rel="stylesheet" href="<c:url value="res/css/common.css"/>">
<link rel="stylesheet" href="<c:url value="res/css/detail.css"/>">
<link type="text/css" href="<c:url value="res/css/jRating.jquery.css"/>" rel="stylesheet">
<script type="text/javascript" src="<c:url value="res/js/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/scroller.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/dd_belatedpng_0.0.8a-min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/change.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/qrcode.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/draw_qrcode.min.js"/>"></script>
<script src="<c:url value="res/js/jquery.raty.min.js"/>" type="text/javascript"></script>
<script defer="defer" language="javascript">
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){style();});
function style()
{
    getfocus(".sc","搜索应用/游戏");
    showdown("d1");
} 
</script>
<title>安智市场|国内最具人气的android手机软件市场</title>
</head>
<body>
	<!-- 头部导航和搜索 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!--主体-->
	<div class="w_945 mb10" style="position:relative;">
	<script type="text/javascript">
		$(function(){
			var obj = $(".jb");
			var tagobj = $(".jbbox");
			var closeboj = $(".close");
			var hideobj = $(".sq,.bl,.hate");
			var showobj = $(".bad,.other");
			var tagobj1 = $(".txt");
			obj.click(function(){
				tagobj.show();
			});
			closeboj.click(function(){
				tagobj.hide();
			});
			showobj.click(function(){tagobj1.show();});
			hideobj.click(function(){tagobj1.hide();});
		});
	</script>
	<!--举报软件-->
	<div class="jbbox">
	<div id="t_l"></div>
	<div id="m_l"></div>
	<div id="m_m">
		<div class="tt">
			<h1>举报该软件</h1>
			<a href="http://www.anzhi.com/soft_50367.do#" class="close"></a></div>
		<div class="jbtype">
			<form action="http://www.anzhi.com/feedback.php?softid=50367&version_code=94" method="POST" id="feedback_form">
                <input type="hidden" name="referrer_url" value="/soft_50367.do">
                <div id="line1"><input type="radio" value="1" name="feedbacktype" class="sq">色情内容</div>
				<div id="line1"><input type="radio" value="2" name="feedbacktype" class="bl">暴力图片</div>
				<div id="line1"><input type="radio" value="3" name="feedbacktype" class="hate">令人讨厌的内容或者攻击性内容</div>
				<div id="line1"><input type="radio" value="4" name="feedbacktype" class="bad">对手机或数据有害</div>
				<div id="line1"><input type="radio" value="5" name="feedbacktype" class="other">其他举报理由</div>
				<div id="line2"><textarea class="txt" name="feedback_content">可输入200字</textarea></div>		
			</form>
		</div>
        <script>
        function check_feedback_form()
        {
            var feedbacktype =  jQuery.trim($("input[name='feedbacktype']:checked").val());
            if (feedbacktype == '') {
                alert('请选择举报类型');
                return false;
            }
            var feedback_content = $("textarea[name='feedback_content']");
            var feedback_content_val = jQuery.trim(feedback_content.val());            
            if (feedback_content_val == '可输入200字') {
                feedback_content.val('');
            }
            return true;
        }
        </script>
		<div class="bt"><a href="javascript:void(0);" onclick="" class="r tjbt">提 交</a></div>
	</div>
	<div id="m_r"></div>
	
	<div id="b_l"></div>
</div>

	<!--左边-->
	<div class="m_l l bgbtm">
		<!--标题-->
		<div class="titlebox">
			<em class="jt l"></em>
			<h1 class="l"><a href="http://www.anzhi.com/index.do">安智市场</a></h1><h1 class="l"> &gt;安智市场 最新版2.1.4</h1>
		</div>
		<!--标题end-->
		
		
		<!--软件信息-->
		
		<div class="softinfo">
			<div class="d_img l"><img src="<c:url value="${softInfo.icon}"/>"></div>
			<div class="info l">
				<div class="titleline"><h1 class="l">${softInfo.cn_name}</h1>${softInfo.soft_version}<img src="<c:url value="res/images/star${softInfo.grade}.png"/>"></div>
				<div class="titleline"><span>作者：${softInfo.author}</span><span>更新：${softInfo.upload_date}</span></div>
                 
				<div class="titleline"><span>下载：${softInfo.down_amount}次</span><span>大小：${softInfo.author}</span></div>
				<div class="titleline" id="titleline_keyw">关键字：${softInfo.author}</div>				
				<div class="btn">
					<div class="l" id="btn">
                       <a href="http://www.anzhi.com/dl_app.php?s=50367">立即下载</a>
                    </div>
					<div class="l" id="op">
					<div id="op_left">
						<a href="#" class="jb">举报该软件</a>
					</div>
					<div id="fenxiang">
						<!--Passit BUTTON BEGIN-->
						<!--Passit BUTTON END-->
					</div>
					</div>
				</div>
			</div>
			<div class="two_d l" id="qrcode">			
              <script>
				draw_qrcode("${softInfo.down_url}");//二维码信息  
			  </script>
            </div>

			
		</div>
		<!--软件信息end-->
        <!--统计flash-->
        <!--统计flash end-->
        
		<!--详细描述-->
		<div class="des">
		  ${softInfo.details}
		</div>
		<!--详细描述end-->
		
		<!--软件图片-->
		<script language="javascript">
			$(function(){
			var obj = $(".imgoutbox ul li");
			var length =(obj.width()+10)* obj.length;
			$(".imgoutbox ul").width(length);
			})
		</script>
		<div class="imgoutbox">
		   <ul style="width: 840px; ">
        	 <li><img src="<c:url value="${softInfo.image_a}"/>"></li>
             <li><img src="<c:url value="${softInfo.image_b}"/>"></li>
             <li><img src="<c:url value="${softInfo.image_c}"/>"></li>
             <li><img src="<c:url value="${softInfo.image_d}"/>"></li>
 		  </ul>
		</div>
		<!--软件图片end-->

		<!--软件评论-->
		<div id="comment_div">
		   <div class="pl">
			<div class="title">软件评论(587)</div>
			<ul>
			  <li>
				<div class="head l"><img src="res/upload/zhi_files/avatar.php"></div>
				<div class="top l">
					<h2 class="l">安智网友:3550...3722</h2>
					<div class="r"><img src="res/upload/zhi_files/star10.png"></div>
					<span class="r">2011-10-22 14:33:15</span>
				</div>
				<div class="cot l">3.0的更好，大家快去安智官网下载</div>
			  </li>
                <li>
					<div class="head l"><img src="res/upload/zhi_files/avatar.php"></div>
					<div class="top l">
						<h2 class="l">安智网友:a000...0f22</h2>
						<div class="r"><img src="res/upload/zhi_files/star1.png"></div>
						<span class="r">2011-10-21 10:27:22</span>
					</div>
					<div class="cot l">***太垃圾了c880.0装上不能使用骗流量
				</div>
				</li>
               	<li class="pages">
                   <a href="#" class="selected"> 1 </a>
                   <a href="#" > 2 </a>
                   <a href="#" > 3 </a>
                   <a href="#"  class="next">下一页</a>    
                </li>
			</ul>
		
		</div>
        		
        <!--软件评论end-->
		
		<!--发表评论-->
		<div class="pl">
			<div id="before">登录后方可发表软件评论，<a href="login.do">登录</a>或者<a href="register.do">注册</a></div>
		</div>
		<!--发表评论end-->
	  </div>
         <script>
           $('#comment_div').load("/comment.php?softid=50367&package=cn.goapk.market&rand="+Math.random());
         </script>
	</div>
	<!--左边end-->


<!--猜你喜欢-->
<jsp:include page="app_like.jsp"></jsp:include>
<div class="banner r">
	<img src="res/upload/ad/bannaer/5.jpg">
</div>

</div>
<!--底部-->

	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>