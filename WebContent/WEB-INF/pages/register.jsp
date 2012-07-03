<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style media="screen"></style>
<title>安智市场|Android手机软件游戏下载平台</title>
<meta name="keywords" content="android,juapk,安智网,安卓软件,安卓游戏,安卓,android,安卓,sdk,android(安卓),刷机,market">
<meta name="description" content="机友市场是一款android资源下载平台，提供海量中文软件/游戏免费下载，是国内最好的android手机软件市场之一">
<meta name="author" content="机友市场">
<meta name="copyright" content="机友市场">
<meta content="ie=7" http-equiv="x-ua-compatible">
<!--<link type="image/x-icon" href="#.ico" rel="shortcut icon">-->
<link rel="stylesheet" href="<c:url value="res/css/common.css"/>">
<link rel="stylesheet" href="<c:url value="res/css/login.css"/>">
<script type="text/javascript" src="<c:url value="res/js/scroller.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/dd_belatedpng_0.0.8a-min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/change.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/jquery-1.7.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="res/js/verifyCode.js"/>"></script>
<script defer="defer" language="javascript">
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){style()});
function style()
{
    getfocus(".sc","搜索应用/游戏");
}
</script>
<title>安智市场|国内最具人气的android手机软件市场</title>
</head>
<body>
	<!-- 头部导航和搜索 -->
	<jsp:include page="header.jsp"></jsp:include>

	<!--主体-->
	<div class="mainbox bgbtm">
			   <div class="titlebox">
					<em class="jt l"></em>
					<h1 class="l">安智市场用户注册</h1>
				</div>
				
				<div class="out">
					<div class="m_l l">
					<form action="http://www.anzhi.com/register.php?act=submit" method="post" id="register_form">
						<div class="input">
							<div class="tab l"><span id="xx">*</span>用户名</div>
							<div class="txt l"><input name="user_name" class="ltxt" value="" id="com1"></div>
						</div>
						<div class="jg" id="user_name_error" style="display:none;">3到15个字符，不区分大小写</div>
						<div class="input">
							<div class="tab l"><span id="xx">*</span>密码</div>
							<div class="txt l"><input type="password" name="user_password" class="ltxt" id="com2"></div>
							
						</div>
						<div class="jg" id="user_password_error" style="display:none;">6到16个字符，区分大小写</div>
						<div class="input">
							<div class="tab l"><span id="xx">*</span>确认密码</div>
							<div class="txt l"><input type="password" name="re_user_password" class="ltxt" value="" id="com3"></div>
	                    </div>
						<div class="jg" id="re_user_password_error" style="display:none;">请再次输入密码</div>
						<div class="input">
							<div class="tab l"><span id="xx">*</span>E-mail</div>
							<div class="txt l"><input type="text" name="email" class="ltxt" value="" id="com4"></div>
						</div>
						<div class="jg" id="email_error" style="display:none;">请输入常用邮箱，如name@example.com</div>
						<div class="input">
							<div class="tab l"><span id="xx">*</span>验证码</div>
							<div class="txt l"><input type="text" class="ltxt" value="" name="checkcode" id="com5"></div>
						</div>
						<div class="jg" id="checkcode_error" style="display:none;">请输入下面的字符，不区分大小写</div>
						
						<div class="codebox l">
							<img src="<c:url value="/avoid/getValidateCode.do"/>" width="150" height="50" id="imgObj" hspace="5">
					 	</div>
						<div class="change l"><a href="#" onclick="changeImg()">换一张</a></div>
					    <input type="hidden" name="referer" value="http://www.anzhi.com/">
	                    <div class="tk c"><input type="checkbox" id="agreement"><span>已经阅读并同意&lt;&lt;<a href="#" target="_blank">巨卓市场服务条款</a>&gt;&gt;</span></div>
						<div class="logbtn"><a href="register.do" onclick="if (check_submit()) {$(&#39;#register_form&#39;).submit();}">注 册</a></div>
					</form>
					</div>
					<div class="m_r r">
						<div class="txt1">已有安智市场账号</div>
						<div class="btn"><a href="login.do">登 录</a></div>
						<!--<div class="txt1">成为安智市场开发者</div>
						<div class="btn"><a href="register.do">注 册</a></div>-->
					
					</div>
				</div>
	</div>
	<!--主体end-->
	<script>
	var  error_msg = '';
	if (error_msg) {
	    alert(error_msg);
	}
	
	var check_field = new Array();
	check_field['user_name'] = new Function("v",  "return (jQuery.trim(v.val()).length >= 3 && jQuery.trim(v.val()).length <= 16) ");
	check_field['user_password'] = new Function("v", "return ( jQuery.trim(v.val()).length >= 6 && jQuery.trim(v.val()).length <= 16 )");
	check_field['re_user_password'] = new Function("v", "return ( jQuery.trim(v.val()) == jQuery.trim( $('input[name=\"user_password\"]').val() ) ) ");
	check_field['email'] = new Function("v", "var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;  return reg.test(v.val());");
	check_field['checkcode'] = new Function("v", "return jQuery.trim(v.val()) != ''");
	
	function check_submit()
	{
	    for (i in check_field) {
	        obj = $("input[name='"+ i  +"']");
	        $("#"+ i +"_error").hide();
	        obj[0].className = 'ltxt';
	        if ( !check_field[i](obj) ) {
	            obj[0].className = 'onfocurs';
	            $("#"+ i +"_error").show();
	            obj[0].focus();
	            return false;
	        }     
	    }
	    
	    if ( !$("#agreement")[0].checked ) {
	        alert('请先阅读协议');
	        return false;
	    }
	    return true;
	}
	$(document).ready(function() {  
	    for (i in check_field) {
	        obj = $("input[name='"+ i  +"']");
	        obj.keydown(function(event) {  
	            if (event.keyCode == 13) {  
	                if (check_submit()) {
	                    $('#register_form').submit();
	                }
	            }  
	        })
	    }
	}); 
	</script>
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>