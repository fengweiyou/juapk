<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="message"><a href="#" style="display: none; ">TOP</a></div>
<style type="text/css">
#message a
{display: block;display: none;z-index: 999; opacity: .8;position: fixed;top: 100%;
margin-top: -60px;left: 50%;margin-left: 360px;-moz-border-radius: 24px;
-webkit-border-radius: 24px;width: 60px;line-height: 18px;height: 18px;padding: 8px;
background-color: #98CC00;font-size: 20px;text-align: center;color: #fff;font-weight: bold;
}
</style>
<script type="text/javascript">
$(function () {
	var scroll_timer;
	var displayed = false;
	var $message = $('#message a');
	var $window = $(window);
	var top = $(document.body).children(0).position().top;
	$window.scroll(function () {
		window.clearTimeout(scroll_timer);
		scroll_timer = window.setTimeout(function () {
			if($window.scrollTop() <= top)
			{
				displayed = false;
				$message.fadeOut(500);
			}
			else if(displayed == false)
			{
				displayed = true;
				$message.stop(true, true).show().click(function () { $message.fadeOut(500); });
			}
		}, 100);
	});
});
</script>
<!--底部-->
<div class="w_945 bottom">
    <p>京ICP备10010号&nbsp;&nbsp;|<a href="#">关于我们</a>|<a href="#">联系我们</a>|<a href="#" class="jbbl">举报不良</a><br>巨卓市场QQ群:187027820&nbsp;&nbsp;|<a href="#">新浪微博</a>|<a href="#">腾讯微博</a>|<a href="#" target="_blank" title="站长统计">站长统计</a></p>
</div>
<!--底部end-->
<script type="text/javascript">
	$(function(){
		var obj = $(".jbbl");
		var tagobj = $(".all_jb");
		var closeboj = $(".all_close");
		var tagobj1 = $(".jb_suc");
		var closeboj1 = $(".suc_close");
		obj.click(function(){
			tagobj.show();
		
		});
		closeboj.click(function(){
			tagobj.hide();
		});
	});
</script>
<!--举报软件-->
	<div class="all_jb">
	<div id="t_l"></div>
	<div id="m_l"></div>
	<div id="m_m">
        <form action="#" method="POST" id="feedback_form">
        <div class="tt">
			<h1>巨卓市场不良信息举报</h1>
			<a href="http://www.anzhi.com/#" class="all_close"></a>
		</div>
		<div class="jbtype">
			<h2>请描述您在巨卓市场发现的不良信息</h2>
            <input type="hidden" name="feedbacktype" value="5">
            <input type="hidden" name="referrer_url" value="http%3A%2F%2Fm5.baidu.com%2Fs%3Ffrom%3D124n%26word%3D%25E5%25AE%2589%25E6%2599%25BA%25E5%25B8%2582%25E5%259C%25BA%26ua%3Dbd_320_480_S5830_1.0">
            <textarea class="txt3" name="feedback_content" onclick="chechit()">可输入200字</textarea>
		</div>
        <script>
        function check_feedback_form()
        {
            var feedback_content = $("textarea[name='feedback_content']");
            var feedback_content_val = jQuery.trim(feedback_content.val());
            if (feedback_content_val == '可输入200字' || feedback_content_val == '') {
                alert('请输入举报内容');
                feedback_content[0].focus();
                return false;
            }
            return true;
        }
        </script>
        <div class="bt"><a href="javascript:void(0);" onclick="if (check_feedback_form()) { $(&quot;#feedback_form&quot;).submit(); }" class="r tjbt">提 交</a></div>
		</form>
	</div>
	<div id="m_r"></div>
	<div id="b_l"></div>
</div>

<!--举报完了显示下面那个举报成功的DIV-->
<!--举报成功-->
	<div class="jb_suc">
	<div id="t_l"></div>
	<div id="m_l"></div>
	<div id="m_m">
		<div class="tt">
			<h1>谢谢您对巨卓市场的支持！</h1>
			<a href="http://www.anzhi.com/#" class="suc_close"></a>
		</div>
		<div class="cc">
			页面将转入之前的页面。
		</div>
		<div class="bt"><a href="http://www.anzhi.com/#" class="r tjbt">确 定</a></div>
	</div>
	<div id="m_r"></div>
	<div id="b_l"></div>
</div>