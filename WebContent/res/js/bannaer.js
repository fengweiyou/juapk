// bannaerlist 信息
function bannaerList(){
    jQuery.ajax({ 
      type : 'GET',
      contentType : 'application/json',
      url : '/juapk/bannaerList.do',
      dataType : 'json',
	  success : function(data) {
        if (data && data.success == "true") {
              bannaerHref = "index.do";
          	  bannaerClass = "class=\"banner1 l\"";
          $.each(data.data, function(i, item) {
        	if(i==4){bannaerClass = "class=\"banner2 r\"";}else{bannaerHref="topicList.do?topicId="+item.ad_id;}
        	$('#bannaer').append("<div "+bannaerClass+"><a href=\""+bannaerHref+"\"><img alt=\"" + item.title + "\" src=\"" + item.image + "\" title=\"" + item.title + "\"></a></div>");
          });
        }
      },
      error : function(data) {
    	  $('#bannaer').html("bannaer数据加载失败..");
      }
    });
}