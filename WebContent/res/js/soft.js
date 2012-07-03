// 获取软件列表（热门.排行）
function getSoftList(id,errorMsg){
    jQuery.ajax({
      type : 'GET',
      contentType : 'application/json',
      url : '/juapk/getSoftList.do?d='+id,
      dataType : 'json',
	  success : function(data) {
        if (data && data.success == "true") {
          $.each(data.data, function(i, item) {
        	  var softHtml = "<li>" +"<div class=\"img l\"><a href=\"soft_"+item.soft_id+".html\"><img src=\""+item.icon+"\"></a></div>"
				    				+"<div class=\"yyname l\"><a href=\"soft_"+item.soft_id+".html\"><h2>"+item.cn_name+"</h2></a></div>";
        	  if(id == 'd4' || id == 'd5'){
        		  softHtml = softHtml +"<div class=\"downnum l\">"+item.upload_date+"</div>"
									  +"<div class=\"star r\" id=\"zsstar\"><img src=\"res/images/star"+item.grade+".png\"></div>"
									  +"<div id=\"zs_down\" class=\"down\"><a href=\""+item.down_url+"\">下 载</a></div>"
								   +"</li>";
			  }else{
        		  softHtml = softHtml +"<div class=\"downnum l\">"+item.down_amount+"次下载</div>"
					      			  +"<div class=\"down\" id=\"s_down\"><a href=\""+item.down_url+"\">下 载</a></div>"
					      		   +"</li>";
			  }
        	  $('#'+id).append(softHtml);
          });
          if(id == 'd2'){$('#'+id).append("<li class=\"morebtn\"><a href=\"softList.do?softType=0&sort=hot\">查看更多热门应用</a></li>");}
          else if(id == 'd3'){$('#'+id).append("<li class=\"morebtn\"><a href=\"softList.do?softType=1&sort=hot\">查看更多热门游戏</a></li>");}
          $('#'+id).live(showdown(id)); // 重新绑定下载JS
        }
      },
      error : function(data) {
    	  $('#'+id).append(errorMsg);
      }
    });
}