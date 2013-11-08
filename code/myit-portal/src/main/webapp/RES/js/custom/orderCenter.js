//ajax查询商品列表，分页展示
function search(){
	//加载效果
	$("#orderListCon").html('<div class="loadingCon"><div class="loading left"></div>订单加载中...</div>');
	
	//ajax查询
	
	$.ajax({
		url: _BASE + "/order/list.htm", 
		type: 'POST', 
		data:$("#search-form").serialize(),
		//dataType:'json',
		success: function(resp){
			$("#orderListCon").html(resp);
			
			// 取消订单
			$('.cancel-btn').click(function(){
				cancelOrder(this.id);
			});
	    },
	    error:function(){
	    	$("#orderListCon").html('<div class="loadingCon">系统忙，请稍后再试</div>');
	    }
	});
}

function cancelOrder(id){
	loading("订单取消中...");
	
	// ajax取消订单
	$.ajax({
		url: _BASE + "/order/cancel.htm", 
		type: 'POST', 
		data:{orderNo:id},
		dataType:'json',
		success: function(data){
			closeLoading();
			
			if(!data){
				dialog("提示","系统忙，请稍后再试。");
				return;
			}
			
			if (data.retCode!="0") {
				dialog("提示",data.msg);
				return;
			}
			
			//订单取消成功
			dialog("提示", "订单取消成功，订单号：" + id, function(){
				//页面刷新
				location.href=_BASE+"/order/orderCenter.htm";
			});				
	    },
	    error:function(){
	    	closeLoading();
	    	dialog("提示","系统忙，请稍后再试。");
	    }
	});

	return false;
}

$(document).ready(function() {

	search();
});