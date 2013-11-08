(function($) {// 选项卡控件
	$.fn.tabChg = function(options) {
		var opts = $.extend({}, $.fn.tab.defaults, options);
		
		return this.each(function() {
			var _this = $(this);
			var _list = null;
			var _con = null;
			
			opts.tablist == null ? _list = _this.find(opts.list) : _list = $(opts.tablist).find(opts.list);
			opts.tabcon == null ? _con = _this.find(opts.conClass) : _con = $(opts.tabcon + ">div");
			
			_list.each(function(a) {
				$(this)[opts.usevent](function(e) {
					e.stopPropagation();
					_con.hide();
					_list.removeClass(opts.addClass)
					_list.eq(a).addClass(opts.addClass)
					_con.eq(a).show();
			
					//自定义方法
					if(opts.callback){
						opts.callback(_list.eq(a), a);
					}
				});
			});
		});
	};
	
	$.fn.tab.defaults = {
		tablist : null,
		tabcon : null,
		list : "li",
		conClass : ".conlist",
		addClass : "on",
		usevent : "mouseover"
	}
})(jQuery); 