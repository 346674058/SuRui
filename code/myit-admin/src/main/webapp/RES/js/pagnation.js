var showPagenation = function(cur_index, total_page, con) {
	var container = $(con);
	var template_pre = '<li><a href="#" page_index={page_index}>Prev</span></li>';
	var template_next = '<li><a href="#" page_index={page_index}>Next</span></li>';
	var template_item = '<li><a href="#" page_index={page_index}>{page_index}</a></li>';
	var template_current_item = '<li class="active" ><span page_index={page_index}>{page_index}</span></li>';
	var template_disabled_item = '<li class="disabled"><span>{page_index}</span></li>';
	var template_more = '<li class="disabled"><span>...</span></li>';
	
	var html = "";
	var page_show = 0;
	
	if (total_page > 7 && cur_index + 7 <= total_page) {
		page_show = 7;
	}
	if (cur_index + 7 > total_page) {
		page_show = total_page - cur_index;
		if (cur_index - 2 > 0) {
			page_show++;
		}
		if (cur_index - 1 > 0) {
			page_show++;
		}
	}

	if (cur_index==1) {
		html += template(template_disabled_item, {
			"page_index" : 'Prev'
		});
	}else{
		html += template(template_pre, {});
	}
	
	if (page_show == 7) {
		html += template(template_item, {
			"page_index" : 1
		});

		html += template(template_more, {});

		var remain_page_button = 5;
		if (cur_index - 2 > 0) {
			html += template(template_item, {
				"page_index" : cur_index - 2
			});
			remain_page_button--;
		}
		if (cur_index - 1 > 0) {
			html += template(template_item, {
				"page_index" : cur_index - 1
			});
			remain_page_button--;
		}
		for ( var i = 0; i < remain_page_button; i++) {
			if (i == 0) {
				html += template(template_current_item, {
					"page_index" : cur_index + i
				});
			} else {
				html += template(template_item, {
					"page_index" : cur_index + i
				});
			}
		}

		html += template(template_more, {});
	} else {
		
		if (cur_index - 2 > 0) {
			html += template(template_item, {
				"page_index" : cur_index - 2
			});
			page_show--;
		}
		if (cur_index - 1 > 0) {
			html += template(template_item, {
				"page_index" : cur_index - 1
			});
			page_show--;
		}
		for ( var i = 0; i <= page_show; i++) {
			if (i == 0) {
				html += template(template_current_item, {
					"page_index" : cur_index + i
				});
			} else {
				html += template(template_item, {
					"page_index" : cur_index + i
				});
			}
		}
	}
	
	if (cur_index==total_page) {
		html += template(template_disabled_item, {
			"page_index" : total_page
		});
		html += template(template_disabled_item, {
			"page_index" : "Next"
		});
	}else{
		html += template(template_item, {
			"page_index" : total_page
		});
		html += template(template_next, {});
	}

	container.html("<ul>" + html + "</ul>");
	container.addClass("pagination");
};