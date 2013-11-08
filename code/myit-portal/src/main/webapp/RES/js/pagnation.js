var showPagenation = function(cur_index,total_page, con){
    var container = $(con);
    var template_pre = '<a href="#" target="_self" class="left" page_index={page_index}>&lt;</a>';
    var template_next = '<a href="#" target="_self" class="left" page_index={page_index}>&gt;</a>';
    var template_item = '<a href="#" target="_self" class="left" page_index={page_index}>{page_index}</a>';
    var template_current_item = '<a href="#" target="_self" class="left" style="background:#676767;color:white;" page_index={page_index}>{page_index}</a>';
    var template_more = '<div class="ad_pagenation_more left">...</div>';
    var html = "";
    var page_show = 0;
    if(total_page > 7 && cur_index + 7 <= total_page){
        page_show = 7;
    }
    if(cur_index + 7 > total_page){
        page_show = total_page - cur_index;
        if(cur_index - 2 > 0){
            page_show++;
        }
        if(cur_index - 1 > 0){
            page_show++;
        }
    }
    
    html += template(template_pre,{"page_index" : 1});
    if(page_show == 7){
        var remain_page_button = 5;
        if(cur_index - 2 > 0){
            html += template(template_item,{"page_index" : cur_index - 2});
            remain_page_button--;
        }
        if(cur_index - 1 > 0){
            html += template(template_item,{"page_index" : cur_index - 1});
            remain_page_button--;
        }
        for(var i=0;i<remain_page_button;i++){
            if(i==0){
                html += template(template_current_item,{"page_index" : cur_index + i});
            }
            else{
                html += template(template_item,{"page_index" : cur_index + i});
            }
        }
        html += template(template_more,{});
        for(var i=0;i<2;i++){
            html += template(template_item,{"page_index" : total_page - 1 + i});
        }
    }
    else{
        if(cur_index - 2 > 0){
            html += template(template_item,{"page_index" : cur_index - 2});
            page_show--;
        }
        if(cur_index - 1 > 0){
            html += template(template_item,{"page_index" : cur_index - 1});
            page_show--;
        }
        for(var i=0;i<=page_show;i++){
            if(i==0){
                html += template(template_current_item,{"page_index" : cur_index + i});
            }
            else{
                html += template(template_item,{"page_index" : cur_index + i});
            }
        }
    }
    html += template(template_next,{"page_index" : total_page});
    
    container.html(html);
};