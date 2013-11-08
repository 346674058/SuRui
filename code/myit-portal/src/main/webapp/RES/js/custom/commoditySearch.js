//ajax查询商品列表，分页展示
function search(){
	//加载效果
	$("#commodityListCon").html('<div class="loadingCon"><div class="loading left"></div>数据加载中...</div>');
	
	//ajax查询
	$.ajax({
		url: _BASE + "/commodity/list.htm", 
		type: 'POST', 
		data:$("#search_form").serialize(),
		//dataType:'json',
		success: function(resp){
			$("#commodityListCon").html(resp);
	    },
	    error:function(){
	    	$("#commodityListCon").html('<div class="loadingCon">系统忙，请稍后再试</div>');
	    }
	});
}

$(document).ready(function() {

	// location选择
	locality("#more", ".localityBox", function(o) {
		// TODO
	});
	
	//注册分类选择事件
	$("#categorys a").click(function(e){
		$(this).addClass("cur").sublings().removeClass("cur");
		
		//选择'全部'分类
		if(this.id=='all_cate'){
			$("#search_form category").val("");
		}else{
			$("#search_form category").val(this.id);
		}
		
		//查询
		search();
	});
	
	//注册价格范围选择事件
	$("#priceRange a").click(function(e){
		$(this).addClass("cur").sublings().removeClass("cur");
		
		//选择'全部'分类
		if(this.id=='all_price'){
			$("#search_form priceRange").val("");
		}else{
			$("#search_form priceRange").val(this.id);
		}
		
		//查询
		search();
	});
	
	//注册配送区域选择事件
	$("#dispatchArea a").click(function(e){
		$(this).addClass("cur").sublings().removeClass("cur");
		
		//选择'全部'分类
		if(this.id=='all_cate'){
			$("#search_form dispatchArea").val("");
		}else{
			$("#search_form dispatchArea").val(this.id);
		}
		
		//查询
		search();
	});
});