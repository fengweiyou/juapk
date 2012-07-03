// 获取类别列表（应用.游戏）
function getSortList(id,errorMsg){
    jQuery.ajax({
      type : 'GET',
      contentType : 'application/json',
      url : '/juapk/getSortList.do?sortId='+id,
      dataType : 'json',
	  success : function(data) {
        if (data && data.success == "true") {
          $.each(data.data, function(i, item) {
        	  $('#sort'+id).append("<li><span id=\"name\"><a href=\"softList.do?softType="+id+"&sortId="+item.id+"\">"+item.name+"</a></span><span id=\"count\">"+item.amount+"</span></li>");
          });
        }
      },
      error : function(data) {
    	  $('#sort'+id).append(errorMsg);
      }
    });
}