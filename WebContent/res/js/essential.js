(function($){
//滚动效果
$.fn.slide = function(options){
	var opt = $.extend({width:0},options),$self = $(this),fn,index = 1,timer2,len=$self.children('li').length;
	var scrollLoop = {
		init:function(){
			if(options.effect == 'left'){
				var ul = $self.children('ul');
				ul.children('li').each(function(){
					opt.width += $(this).outerWidth(true);
				});
				ul.append(ul.html());
			}else if(options.effect == 'focus'){
				var ul=$('<ul class="list_banner_num"></ul>');
				for(var i = 0;i<len;i++){
					ul.append('<li>'+(i+1)+'</li>');
				}
				ul.children('li:eq(0)').addClass('act');
				$self.parent().append(ul);
			}			
			return this;
		},
		begin:function(){
			if(options.effect == 'left'){
				fn = setInterval(function(){
					if(opt.width < $self[0].scrollLeft){
						$self[0].scrollLeft = 0;
					}else{
						$self[0].scrollLeft++;
					}
				},opt.sqeed);
			}else if(options.effect == 'bottom'){
				var fn1 = function(){
					$self.animate({paddingTop:opt.height+'px'},1000,function(){
							$self.css({paddingTop:0});
							$self.prepend($self.children(":last"));
						});
				};
				fn1();
				fn = setInterval(function(){							
					fn1();
				},opt.sqeed);
			}else if(options.effect == 'focus'){
				var fn1 = function(){
					$self.stop();
					$self.children('.act').removeClass('act');
					$self.children('li').hide();
					$self.children('li:eq('+index+')').addClass('act').fadeIn(500);
					$('.list_banner_num li.act').removeClass('act');
					$('.list_banner_num li:eq('+index+')').addClass('act');	
					index++;
					if(index >= len){index = 0;}
				};
				var out = function(){
					fn = window.setInterval(fn1,opt.sqeed);
				};
				$(".list_banner_num li").unbind().bind('mouseover',function(){
					if(fn){
						clearInterval(fn); 
					  }	
					 index = $(this).index();						 
					 timer2 = window.setTimeout(function(){
						fn1();
					 },200);
				}).bind('mouseout',function(){	
					 if(timer2){
						clearTimeout(timer2); 
					  }
					  scrollLoop.begin();
				});
				out();
			}
		}
	};
	scrollLoop.init().begin();
	$self.bind('mouseover',function(){
		clearInterval(fn);
		if(options.effect == 'bottom'){
			$self.stop();
		}
	}).bind('mouseout',function(){
		scrollLoop.begin();
	});
};
$.fn.hover=function(options){
	var opt = $.extend({type:1},options);
	return this.each(function(){								  
		var $self = $(this);
		if(opt.type == 3){
			$self.children('li').bind('mouseenter',function(){
				$(".mo_list_hov").remove();
				var $self = $(this);img = $(this).html(),position = $(this).position(),div = $("<div class='mo_list_hov'><div class='fl'>"+img+"</div><p>"+$(this).attr('tit')+"</p><p>人气值："+$(this).attr('viewnum')+"</p><p>总下载值："+$(this).attr('downnum')+"</p></div>");
				var vip = $(this).attr('vip');
				if(vip == 1){
				  $('p:eq(0)',div).append($('<a target="_blank" class="viptb_1" href="/user/auth/main"></a>'));
					}
				if(position.left > 600){
					var css = {position:'absolute',right:(922-position.left-52)+'px',top:(position.top-1)+'px'};
					div.children('div').attr('class','fr');
					div.addClass("mo_hov1");
				}else{
					var css = {position:'absolute',left:(position.left-1)+'px',top:(position.top-1)+'px'};
				}
				$self.parent('ul').append(div);
				div.css(css).animate({width:'200px'},300);
			});
			var fn = function(){$(".mo_list_hov").remove();};
			$(".mo_list_hov").live('mouseleave',fn);
			$self.parent().bind('mouseleave',fn);
		}
	});
};
})(jQuery);