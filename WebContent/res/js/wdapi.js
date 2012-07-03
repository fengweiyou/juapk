var wdapi_data = {
    action: null, 
    type: null, 
    name: null, 
    href: null, 
    artist: null, 
    album: null 
};

wdapi_jump = function() {
    var addr;
    var action = wdapi_data.action;
    var name = wdapi_data.name;
    var href = wdapi_data.href;
    var type = wdapi_data.type;
    var artist = wdapi_data.artist;
    var album = wdapi_data.album;
    if(action == 'search') {
        switch (type) {
            case 'ebook':
                
                break;
            case 'music':
                
                break;
            case 'apk':
                //addr = 'wdjapk://'+href;
                //break;
            case 'video':
                addr = 'wandoujia://type=search&cat=video&keyword='+name+'==';
                break;
            default:
               addr = 'wandoujia://type='+type+'&name='+name+'&url='+href+'==';
                break;
        }
    } else {
        switch (type) {
            case 'ebook':
                addr = 'wandoujia://type='+type+'&title='+name+'&url='+href+'==';
                break;
            case 'music':
                addr = 'wandoujia://type='+type+'&title='+name+'&artist='+artist+'&album='+album+'&url='+href+'==';
                break;
            case 'apk':
                //addr = 'wdjapk://'+href;
                //break;
            case 'video':
            default:
               addr = 'wandoujia://type='+type+'&name='+name+'&url='+href+'==';
                break;
        }
    }
    try{
        if (wdapi_detectActiveX()) {
            document.getElementById(baseId+'_down').src = addr;
        }
        else {
            if("\v"=="v") { //if ie
                var ws = new ActiveXObject("WScript.Shell");
                ws.Exec(addr);
            }
        }
    }catch(err){}
};
wdapi_dl = function(iframefile, _target, type, style, src) {
    wdapi_data = {
        action: null,  
        type: null,  
        name: null,  
        href: null,  
        artist: null,  
        album: null
    };
    var args = type.split(':');
    type = args[0];
    wdapi_data.type = type;
    action = null;
    if(args.length > 1){
        action = args[1];
        wdapi_data.action = action;
    }
    var baseId = 'wdapi_'+type+'dl';
    var name = _target.getAttribute('name');
    wdapi_data.name = name;
    if (!name || name.length === 0) {
        switch (type) {
        case 'video': name='视频';
            break;
        case 'music': name='音乐';
            break;
        default: name=type;
            break;
        }
    }
    var artist, album;
    if (type == 'music') {
        artist = _target.getAttribute('artist');
        album = _target.getAttribute('album');
        wdapi_data.artist = artist;
        wdapi_data.album = album;
    }
    var href = _target.href;
    wdapi_data.href = href;
    if (!_target || !href) {
        return true;
    }

    /*if (type == 'apk' && href.indexOf('?') === -1) { //handle client bug
        href = href + '?';
    }*/
    var elm = document.getElementById(baseId);
    var urlprefix='http://wandoujia.com/api/';
    var iframesrc = "";
    if(action == 'search'){
        iframesrc=urlprefix+iframefile+'?src='+escape(src||"")+'&name='+escape(name)+'&keyword='+escape(name);
    } else {
        iframesrc=urlprefix+iframefile+'?src='+escape(src||"")+'&name='+escape(name)+'&href='+escape(href);
    }
    
    if (elm) {
        elm.style.display="block";
        wdapi_resize(baseId)();
        try {
            pageTracker = _gat._getTracker('UA-15790641-1');
            //document.getElementById(baseId+'_inner').contentWindow.document.location.href = pageTracker._getLinkerUrl(iframesrc);
            document.getElementById(baseId+'_inner').src=pageTracker._getLinkerUrl(iframesrc);
        }catch(err) {
            document.getElementById(baseId+'_inner').src=iframesrc;
        }
    }
    else {
        var oDiv=document.createElement('div');
        var html = '<div id="'+baseId+'_bg"></div><div id="'+baseId+'_outter"><div id="'+baseId+'_close"></div><iframe id="'+baseId+'_inner" frameborder="0"></iframe></div><style>'+style+'</style><iframe id="'+baseId+'_down" style="display:none;"></iframe>';
        oDiv.innerHTML = html;
        oDiv.id=baseId;
        document.body.appendChild(oDiv);
        var _resize = wdapi_resize(baseId);
        _resize();
        window.onresize = _resize;
        var iframe = document.getElementById(baseId+'_inner');
        if (iframe.attachEvent){
            iframe.detachEvent('onload', wdapi_jump);
            iframe.attachEvent('onload', wdapi_jump);
        }
        else {
            iframe.onload = wdapi_jump;
        }

        try{
            pageTracker = _gat._getTracker('UA-15790641-1');
            pageTracker._setDomainName('outsite.wandoujia.com');
            pageTracker._addIgnoredOrganic('outsite.wandoujia.com');
            pageTracker._setAllowHash(false);
            pageTracker._setAllowLinker(true);
            pageTracker._trackPageview();
            //document.getElementById(baseId+'_inner').contentWindow.document.location.href = pageTracker._getLinkerUrl(iframesrc);
            document.getElementById(baseId+'_inner').src = pageTracker._getLinkerUrl(iframesrc);
        } catch(err) {
            document.getElementById(baseId+'_inner').src = iframesrc;
        }

        document.getElementById(baseId+'_close').onclick=document.getElementById(baseId+'_bg').onclick=function(){
            document.getElementById(baseId).style.display="none";
            document.getElementById(baseId+'_down').src = "";
            return false;
        };
        

    }

    return false;
};
wdapi_apkdl_render = function(containerId, href, name, src) {
    if (!href || !name) {
        return false;
    }
    var baseId = 'wdapi_apkdl';
    var urlprefix='http://wandoujia.com/api/';
    var iframefile='wdapi_apkdl_v2.html';
    var iframesrc=urlprefix+iframefile+'?src='+escape(src||"")+'&name='+escape(name)+'&href='+escape(href);
    var style='#wdapi_apkdl_inner{border:none;width:100%;height:100%;}';
    wdapi_data = {
        action: null,  
        type: null,  
        name: null,  
        href: null,  
        artist: null,  
        album: null
    };
    wdapi_data.name = name;
    wdapi_data.type = "apk";
    wdapi_data.href = href;

    var elm = document.getElementById(baseId+'_inner');
    if (elm) {
        try {
            pageTracker = _gat._getTracker('UA-15790641-1');
            //document.getElementById(baseId+'_inner').contentWindow.document.location.href = pageTracker._getLinkerUrl(iframesrc);
            document.getElementById(baseId+'_inner').src = pageTracker._getLinkerUrl(iframesrc);
        }catch(err) {
            document.getElementById(baseId+'_inner').src=iframesrc;
        }
    }
    else {
        var html = '<iframe id="'+baseId+'_inner" frameborder="0"></iframe><style>'+style+'</style><iframe id="'+baseId+'_down" style="display:none;"></iframe>';
        var container = document.getElementById(containerId);
        if (!container) return false;
        container.innerHTML = html;
        var iframe = document.getElementById(baseId+'_inner');
        if (iframe.attachEvent){
            iframe.detachEvent('onload', wdapi_jump);
            iframe.attachEvent('onload', wdapi_jump);
        }
        else {
            iframe.onload = wdapi_jump;
        }

        try{
            pageTracker = _gat._getTracker('UA-15790641-1');
            pageTracker._setDomainName('outsite.wandoujia.com');
            pageTracker._addIgnoredOrganic('outsite.wandoujia.com');
            pageTracker._setAllowHash(false);
            pageTracker._setAllowLinker(true);
            pageTracker._trackPageview();
            //document.getElementById(baseId+'_inner').contentWindow.document.location.href = pageTracker._getLinkerUrl(iframesrc);
            document.getElementById(baseId+'_inner').src = pageTracker._getLinkerUrl(iframesrc);
        } catch(err) {
            document.getElementById(baseId+'_inner').src = iframesrc;
        }
    }
    return true;
};
wdapi_apkdl = function(_target, src) {
    var style = '#wdapi_apkdl_bg{position: absolute;top: 0; left: 0;background:black;-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";filter: alpha(opacity=50);opacity:0.5;z-index:99998;} #wdapi_apkdl_outter{width: 480px; height:220px;border: 1px solid gray;position: absolute;top: 0;left: 0;overflow:hidden;background: white;z-index:99999;} #wdapi_apkdl_close{width:9px;height:9px;background:url("http://wandoujia.com/api/cross.png") no-repeat;right:0px;margin:10px;cursor:pointer;position:absolute;} #wdapi_apkdl_inner{border:none;width:100%;height:100%;}';

    return wdapi_dl('wdapi_apkdl.html', _target, 'apk', style, src);
};
wdapi_apkdl_m = function(_target, src) {
    var style = '#wdapi_apkdl_bg{position: absolute;top: 0; left: 0;background:black;-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";filter: alpha(opacity=50);opacity:0.5;z-index:99998;} #wdapi_apkdl_outter{width: 480px; height:220px;border: 1px solid gray;position: absolute;top: 0;left: 0;overflow:hidden;background: white;z-index:99999;} #wdapi_apkdl_close{width:9px;height:9px;background:url("http://wandoujia.com/api/cross.png") no-repeat;right:0px;margin:10px;cursor:pointer;position:absolute;} #wdapi_apkdl_inner{border:none;width:100%;height:100%;} ';

    return wdapi_dl('wdapi_apkdl_v2.html', _target, 'apk', style, src);
};
wdapi_videodl = function(_target, src) {
    var style = '#wdapi_videodl_bg{position: absolute;top: 0; left: 0;background:black;-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";filter: alpha(opacity=50);opacity:0.5;z-index:99998;} #wdapi_videodl_outter{width: 500px; height:280px;border: 1px solid gray;position: absolute;top: 0;left: 0;overflow:hidden;background: white;z-index:99999;} #wdapi_videodl_close{width:9px;height:9px;background:url("http://wandoujia.com/api/cross.png") no-repeat;right:0px;margin:10px;cursor:pointer;position:absolute;} #wdapi_videodl_inner{border:none;width:100%;height:100%;} ';

    return wdapi_dl('wdapi_videodl.html', _target, 'video', style, src);
};
wdapi_musicdl = function(_target, src) {
    var style = '#wdapi_musicdl_bg{position: absolute;top: 0; left: 0;background:black;-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";filter: alpha(opacity=50);opacity:0.5;z-index:99998;} #wdapi_musicdl_outter{width: 500px; height:280px;border: 1px solid gray;position: absolute;top: 0;left: 0;overflow:hidden;background: white;z-index:99999;} #wdapi_musicdl_close{width:9px;height:9px;background:url("http://wandoujia.com/api/cross.png") no-repeat;right:0px;margin:10px;cursor:pointer;position:absolute;} #wdapi_musicdl_inner{border:none;width:100%;height:100%;} ';

    return wdapi_dl('wdapi_musicdl.html', _target, 'music', style, src);
};
wdapi_bookdl = function(_target, src) {
    var style = '#wdapi_bookdl_bg{position: absolute;top: 0; left: 0;background:black;-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";filter: alpha(opacity=50);opacity:0.5;z-index:99998;} #wdapi_bookdl_outter{width: 500px; height:280px;border: 1px solid gray;position: absolute;top: 0;left: 0;overflow:hidden;background: white;z-index:99999;} #wdapi_bookdl_close{width:9px;height:9px;background:url("http://wandoujia.com/api/cross.png") no-repeat;right:0px;margin:10px;cursor:pointer;position:absolute;} #wdapi_bookdl_inner{border:none;width:100%;height:100%;} ';

    return wdapi_dl('wdapi_bookdl.html', _target, 'ebook', style, src);
};
wdapi_resize = (function(id) {
    var baseId = id;
    return function() {
        var d_bg = document.getElementById(baseId+'_bg');
        var d_outter = document.getElementById(baseId+'_outter');
        // Get page size
        var arrPageSizes = wdapi_getPageSize();
        d_bg.style.width = arrPageSizes[2] + 'px';
        d_bg.style.height= arrPageSizes[1] + 'px';
        // Get page scroll
        var arrPageScroll = wdapi_getPageScroll();
        d_outter.style.top = arrPageScroll[1] + (arrPageSizes[3] / 5) + 'px';
        d_outter.style.left = ((arrPageSizes[2] - 480 > 0) ? (arrPageSizes[2]-480)/2 : 0) + 'px';
    };
});
wdapi_videosearch = function(_target, src) {
    var style = '#wdapi_videodl_bg{position: absolute;top: 0; left: 0;background:black;-ms-filter:"progid:DXImageTransform.Microsoft.Alpha(Opacity=50)";filter: alpha(opacity=50);opacity:0.5;z-index:99998;} #wdapi_videodl_outter{width: 500px; height:280px;border: 1px solid gray;position: absolute;top: 0;left: 0;overflow:hidden;background: white;z-index:99999;} #wdapi_videodl_close{width:9px;height:9px;background:url("http://wandoujia.com/api/cross.png") no-repeat;right:0px;margin:10px;cursor:pointer;position:absolute;} #wdapi_videodl_inner{border:none;width:100%;height:100%;} ';

    return wdapi_dl('wdapi_videodl.html', _target, 'video:search', style, src);
};


/**
 / THIRD FUNCTION
 * getPageSize() by quirksmode.com
 *
 * @return Array Return an array with page width, height and window width, height
 */
wdapi_getPageSize = function() {
    var xScroll, yScroll;
    if (window.innerHeight && window.scrollMaxY) {
        xScroll = window.innerWidth + window.scrollMaxX;
        yScroll = window.innerHeight + window.scrollMaxY;
    } else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
        xScroll = document.body.scrollWidth;
        yScroll = document.body.scrollHeight;
    } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
        xScroll = document.body.offsetWidth;
        yScroll = document.body.offsetHeight;
    }
    var windowWidth, windowHeight;
    if (self.innerHeight) { // all except Explorer
        if(document.documentElement.clientWidth){
            windowWidth = document.documentElement.clientWidth; 
        } else {
            windowWidth = self.innerWidth;
        }
        windowHeight = self.innerHeight;
    } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
        windowWidth = document.documentElement.clientWidth;
        windowHeight = document.documentElement.clientHeight;
    } else if (document.body) { // other Explorers
        windowWidth = document.body.clientWidth;
        windowHeight = document.body.clientHeight;
    }   
    // for small pages with total height less then height of the viewport
    if(yScroll < windowHeight){
        pageHeight = windowHeight;
    } else { 
        pageHeight = yScroll;
    }
    // for small pages with total width less then width of the viewport
    if(xScroll < windowWidth){  
        pageWidth = xScroll;        
    } else {
        pageWidth = windowWidth;
    }
    arrayPageSize = new Array(pageWidth,pageHeight,windowWidth,windowHeight);
    return arrayPageSize;
};
/**
 / THIRD FUNCTION
 * getPageScroll() by quirksmode.com
 *
 * @return Array Return an array with x,y page scroll values.
 */
wdapi_getPageScroll = function() {
    var xScroll, yScroll;
    if (self.pageYOffset) {
        yScroll = self.pageYOffset;
        xScroll = self.pageXOffset;
    } else if (document.documentElement && document.documentElement.scrollTop) {     // Explorer 6 Strict
        yScroll = document.documentElement.scrollTop;
        xScroll = document.documentElement.scrollLeft;
    } else if (document.body) {// all other Explorers
        yScroll = document.body.scrollTop;
        xScroll = document.body.scrollLeft; 
    }
    arrayPageScroll = new Array(xScroll,yScroll);
    return arrayPageScroll;
};

wdapi_detectActiveX = function() {
  if("\v"=="v") { //if ie
    try {
      var comActiveX = new ActiveXObject("WDJBrowserAddin.BHO");
      return true;
    } catch(e) {
      return false; 
    }
  }
  else {
    return true;
  }
};

