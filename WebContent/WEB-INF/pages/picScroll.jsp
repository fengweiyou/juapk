<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	var sw = 0;
	$(".picsroll .num a").mouseover(function(){
		sw = $(".num a").index(this);
		myShow(sw);
	});
	function myShow(i){
		$(".picsroll .num a").eq(i).addClass("cur").siblings("a").removeClass("cur");
		$(".picsroll ul li").eq(i).stop(true,true).fadeIn(600).siblings("li").fadeOut(600);
	}
	//滑入停止动画，滑出开始动画
	$(".picsroll").hover(function(){
		if(myTime){
		   clearInterval(myTime);
		}
	},function(){
		myTime = setInterval(function(){
		  myShow(sw)
		  sw++;
		  if(sw==3){sw=0;}
		} , 3000);
	});
	//自动开始
	var myTime = setInterval(function(){
	   myShow(sw);
	   sw++;
	   if(sw==3){sw=0;}
	} , 3000);
});
</script>
<style type="text/css">
/*焦点图*/
.picsroll{ width:943px; height:80px; position:relative; overflow:hidden; border:#ddd 1px solid;padding:1px;}
.num{ position:absolute;right:10px; bottom:10px; z-index:10;}
.num a{ width:16px; height:16px; display:inline-block; text-align:center; margin:0 3px; cursor:pointer;}
.num a.cur{ background:#690;color:#fff;}
.picsroll ul{ position:relative; z-index:5;}
.picsroll ul li{ position:absolute; display:none;}
</style>
<!--焦点图-->
<div class="picsroll">
	<ul>
        <li style="display:block;"><a href="#" target="_blank"><img src="res/upload/ad/bannaer/ad001.jpg" /></a></li>
        <li><a href="#" target="_blank"><img src="res/upload/ad/bannaer/ad002.jpg" /></a></li>
        <li><a href="#" target="_blank"><img src="res/upload/ad/bannaer/ad003.jpg" /></a></li>
    </ul>
    <div class="num"><a class="cur">1</a><a>2</a><a>3</a></div>
</div>