// 主页 js 逻辑
DD_belatedPNG.fix('#logo,#hot');
$(document).ready(function(){
	style();
	bannaerList();
    getSoftList('d2','热门应用数据加载失败..');
    getSoftList('d3','热门游戏数据加载失败..');
	getSoftList('d4','最新应用数据加载失败..');
	getSoftList('d5','最新游戏数据加载失败..');
	getSoftList('d6','日排行数据加载失败..');
	getSoftList('d7','周排行数据加载失败..');
	getSoftList('d8','月排行数据加载失败..');
	$("img").lazyload();
});
function style(){
    getfocus(".sc","搜索应用/游戏");
    scroller(); //滚动
    changetab("c1");
    changetab("c2");
    showdown("d1");
    showdown("d9");
}