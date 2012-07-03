<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=2.0" name="viewport">
<title>百度地图</title>
<link rel="stylesheet" href="<c:url value="res/css/mob_common.css"/>">
</head>
<body>
<a name='top'></a>
<div class="top">
	<span>安智市场</span>
	<span id="return"><a href="index.php">&lt;&lt;返回首页</a></span>
</div>
<!--顶部-->
<div class="m head">
	<div  class="headimg"><img  width="70" height="70" src="${softInfo.icon}"/></div>
	<h1 class="title">${softInfo.cn_name}</h1>
	<span class="address">${softInfo.cn_name}</span>
	<div class="star"><img  width="70" height="12" src="res/images/mob_star${softInfo.grade}.png"/></div>
	<span class="number">517次评论</span>
	<a href="download.php?softid=76433" class="free">免费下载</a>
</div>

<!--软件信息-->
<div class="softinfo">
     
	日期：${softInfo.upload_date} &nbsp;&nbsp; 版本：${softInfo.soft_version}&nbsp;&nbsp; 大小:${softInfo.package_size}
</div>

<!--描述-->
<div class="des m">
	在最新版本中，百度修复遗留定位bug,减少定位引起的流量，提升定位精度； 增大POI收藏的最大收藏条数；还新增精品软件推荐功能。同时百度地图为驾车用户推出摄像头提醒功能，针对已规划路线相关摄像头、道路出口和途径地标进行语音提醒，帮助用户安心驾驶！提供语音搜索功能，以及实景地图AR功能下兴趣点详情查询功能，随时随地，解放您的手指，搜你想搜分城市离线地图包，节省90%以上的流量的同时快速提升搜索和浏览体验；通过百度地图，您可以快速进行定位；任意查找地点、商家、公交站点，以及周边生活信息；强大的路线规划能力，提供公交、驾车、步行三种出行方式；提供分城市离线地图包，节省与手机联系人实现实时的位置共享；还有实时路况、离线收藏、截图、测距、流量监控等各种实用工具。<br />
<br />
更新日志：修复Android1.5.1遗留的收藏记录的bug，使用更加流畅！
  <div class="imgbox">
                    <img  src="res/mob/com.baidu.BaiduMap_45038300_0_0.png"/>
                    <div style='display:none' id='hide_box'>        <img  src="res/mob/com.baidu.BaiduMap_51097600_1_0.png"/>
                            <img  src="res/mob/com.baidu.BaiduMap_52602600_2_0.png"/>
        </div>    	<span class="btn"><a href="javascript:void(0);" onclick=' if (document.getElementById("hide_box").style.display == "none") {document.getElementById("hide_box").style.display="block";} else { document.getElementById("hide_box").style.display="none";}'>&lt;点击查看更多截图&gt;</a></span>  
  </div>
</div>
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
