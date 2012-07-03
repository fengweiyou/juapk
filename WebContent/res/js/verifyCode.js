function changeImg(){
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src",chgUrl(src));
}
//时间戳 
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳 
function chgUrl(url){
    var timestamp = (new Date()).valueOf();
    url = url.substring(0,33);
    if((url.indexOf("&")>=0)){
        url = url + "×tamp=" + timestamp;
    }else{
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}

function getVerifyCode(url){
	var code = "";
    $.ajax({
        type:"POST",
        url:url,
        data:code,
        success:callback
    });
	return code;
}

function isRightCode(){
    var code = $("#veryCode").attr("value").trim();
    if(code!=""){
    	alert("--code--"+code);
    	jQuery.ajax({
    		type:"POST",
    		contentType : 'application/json',
    		url:"/juapk/avoid/getVCode.do?c=" + code,
    		dataType : 'json',
    		success:callback(data)
    	});
    }else{
    	alert("请输入验证码！");
    }
}

function callback(data){
	var dataHtml="";
	alert("--data--"+data);
	if(data==0){
		dataHtml='请输入验证码';
	}else if(data==1){
		$("#frm").submit();
	}else if(data==2){
		dataHtml='验证码错误';
	}
    $("#verify_info").html(dataHtml);
}
function login(){$("#frm").submit();}
function clearInput(){$("input").val("");}
// 不允许输入数字
$.fn.numeral = function() {
    $(this).css("ime-mode", "disabled");
    this.bind("keypress",function(e) {
    var code = (e.keyCode ? e.keyCode : e.which);  //兼容火狐 IE
        if(!$.browser.msie&&(e.keyCode==0x8))  //火狐下 不能使用退格键 
        {return ;}
         return code >= 48 && code<= 57;
    });
    this.bind("blur", function() {
        if (this.value.lastIndexOf(".") == (this.value.length - 1)) {
            this.value = this.value.substr(0, this.value.length - 1);
        } else if (isNaN(this.value)) {
            this.value = "";
        }
    });
    this.bind("paste", function() {
        var s = clipboardData.getData("text");
       // if (!//D/.test(s));
        value = s.replace(/^0*/, "");
        return false;
    });
    this.bind("dragenter", function() {
        return false;
    });
    this.bind("keyup", function() {
    if (/(^0+)/.test(this.value)) {
        this.value = this.value.replace(/^0*/, "");
        }  
    });
};