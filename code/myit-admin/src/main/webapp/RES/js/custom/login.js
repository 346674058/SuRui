$(function() {
	$("[rel=tooltip]").tooltip();
	
	$('.demo-cancel-click').click(function() {
		return false;
	});
	
	//登录表单验证
	$("#login-form").validate({
		ignore: ":hidden",
		rules: {
			userName:{
				required: true,
				rangelength: [4,20]
			},
			password:{
				required: true,
				rangelength: [6,20]
			}		
		},
		
		messages: {
			userName:{
				required: '用户名不能为空！',
				rangelength: '用户名长度为{0} - {1}'
			},
			password:{
				required: '密码不能为空！',
				rangelength: '密码长度为{0} - {1}'
			}
		},
	
	errorElement: "em",				//用来创建错误提示信息标签
    success: function(element) {			//验证成功后的执行的回调函数
    	element.empty()//清空错误提示消息
		.removeClass("error")//删除原有的样式类
		.addClass("success");//额外添加自定义的success类
	},
	//更换报错信息位置
	errorPlacement: function(error, element) { 
		element.prev().empty();
		error.appendTo(element.prev());
	},
//	
//	//错误和正确时添加的样式
	errorClass: "error",
	successClass: "success"

  });

	// 提交订单
	$('#submit-btn').click(function() {
		if(!$("#login-form").valid()){
			return ;
		}
		
		loading("登录中，请稍后...");
		
		// ajax登录
		$.ajax({
			url: _BASE + "/user/loginValidate.htm", 
			type: 'POST', 
			data:$("#login-form").serialize(),
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
				
				// 登录成功，跳转到首页
				location.href=_BASE + "/index.htm";
				
		    },
		    error:function(){
		    	closeLoading();
		    	dialog("提示","系统忙，请稍后再试。");
		    }
		});

		return false;
	});
	
	
});