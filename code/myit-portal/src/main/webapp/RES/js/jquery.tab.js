(function($){
	$.fn.tab = function(options){
		var defaults = {
				event:"click", //触发事件，mouseover | click
				nav:".tab-nav",  //tab的ID
				cls:"current", //选中时的css
				con:".tab-list-wrap", //内容id的包围
				css:{ width: '933px'}
		}
		
		var options = $.extend(defaults, options);
		
		this.each(function(){
				var tab = $(this);
				
				//设置样式
				//tab.css(options.css);
				
				//绑定事件
				tab.find(options.nav).children().eq(0).addClass(options.cls); //触发第一项
				tab.find(options.con).children().eq(0).show();  //显示第一个内容
				
				tab.find(options.nav).children().each(function(a) {
					$(this)[options.event](function(e) {
						e.stopPropagation(); 
						
						$(this).addClass(options.cls).siblings().removeClass(options.cls);
						tab.find(options.con).children().eq(a).siblings().hide();
						tab.find(options.con).children().eq(a).fadeIn();
					});
				});
				
				/*
				tab.find(options.nav).children().bind(options.event, function(i){
					var index = $(this).index();
				
					$(this).addClass(options.cls).siblings().removeClass(options.cls);
					tab.find(options.con).children().eq(i).show().siblings().hide();
				});
				*/
		});
	};
})(jQuery);