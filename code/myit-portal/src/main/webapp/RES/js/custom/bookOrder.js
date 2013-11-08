$(document).ready(function() {

	// 日历控件
	$("#latestTime").attr("readonly", "readonly");
	$("#latestTime").datepicker({
		defaultDate : "+1w",
		minDate : '2013-09-18',
		maxDate : '2013-09-20',
		dateFormat : 'yy-mm-dd',
		onClose : function(selectedDate) {
			$(this).val(selectedDate);
		}
	});

	// 时间选择器
	tagTrigger({
		id : 'endTime',
		showEvent : 'click',
		css : {
			width : '144px'
		},
		callback : function(o) {
			$("#endTime").val(o.text());
		}
	});

	// location选择
	locality("#district", ".localityBox", function(o) {
		// TODO
	});

	// 小区/街道选择器
	tagTrigger({
		id : 'street',
		showEvent : 'click',
		css : {
			width : '144px'
		},
		callback : function(o) {
			$("#street").val(o.text());
		}
	});

	// loading
	$("#dialog").dialog({
		autoOpen : false,
		modal : true,
		resizable : false,
		title : '提示'
	});

	// 对话框
	$("#dialog-loading").dialog({
		autoOpen : false,
		modal : true,
		resizable : false,
		draggable : false,
		closeOnEscape : false
	});

	// 提交订单
	$('#submit-btn').click(function() {
		loading("订单提交中...");
		
		// ajax提交订单
		$.ajax({
			url: _BASE + "/order/submitOrder.htm", 
			type: 'POST', 
			data:$("#submit-form").serialize(),
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
				
				//TODO  订单提交成功，跳转到在线支付页面
				// 订单提交成功，跳转到预订结果页面
				location.href = _BASE + "/order/bookResult.htm?orderNo="+data.orderNo;
				
				
		    },
		    error:function(){
		    	closeLoading();
		    	dialog("提示","系统忙，请稍后再试。");
		    }
		});
		
		return false;
	});

});