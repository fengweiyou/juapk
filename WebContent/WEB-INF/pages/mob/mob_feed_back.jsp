<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0" name="viewport">
<title>反馈意见</title>
<link rel="stylesheet" href="<c:url value="res/css/mob_common.css"/>">
</head>
<body>
<a name='top'></a>
<div class="top"><span><a href='mobIndex.do'>安智市场</a></span></div>
<!--返回首页-->
<div class="goindex">
	<a href="#">&gt;&gt;意见反馈</a>
</div>
<!--描述-->
<div class="des m">
	<p class="alert">请将您对安智市场的意见和建议告诉我们，我们为您会不断改进</p>
	<form action='suggestion.php?type=submit' method='POST' onsubmit='return check_submit();'>
		<p class="ts">请输入您的建议：</p>
		<textarea class="js" id='message' name="message"></textarea>
		<p class="ts">请输入您的手机型号：</p>
		<input type="text"  name="phone_model" id='phone_model'  class="inp"  value=''/>
		<p class="ts">请输入您联系方式（QQ、手机号）：</p>
		<input type="text" name="contact" id='contact' class="inp" />
		<input  type="submit" value="提 交" class="sb"/>
        <input type='hidden' name='referer_url' value='http://m.anzhi.com/app.php?type=info&softid=76433'>
    </form>
</div>
<script language="javascript"> 
    function check_submit()
    {
        var message =  document.getElementById('message');
        var phone_model = document.getElementById('phone_model');
        var contact = document.getElementById('contact');
        if (message.value.replace(/(^\s*)(\s*$)/g, '') == '') {
            alert('请填写留言');
            return false;
        }
        if (phone_model.value.replace(/(^\s*)(\s*$)/g, '') == '') {
            alert('请填写机型');
            return false;
        }
        if (contact.value.replace(/(^\s*)(\s*$)/g, '') == '') {
            alert('请填写联系方式');
            return false;
        }    
        return true;
    }
</script>
<!--翻页-->
<footer class="footer m notop">
	<div class="btnline">
		<a href="suggestion.php" class="suggest">反馈意见</a>
		<a href="#top" class="returntop">返回顶部</a>
	</div>
	<div class="footerinfo">本站地址:http://m.anzhi.com | <script src="http://s16.cnzz.com/stat.php?id=3217453&web_id=3217453&show=pic1" language="JavaScript"></script><script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F230c63426e4fce3a604a2a9069e4d782' type='text/javascript'%3E%3C/script%3E"));
</script></div>
</footer>
</body>
</html>

