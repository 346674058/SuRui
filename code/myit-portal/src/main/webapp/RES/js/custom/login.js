$(document).ready(function() {
	
	setTop();
	
	$("#randCodeImg").click(function(){
		var version=new Date();
		$(this).attr("src", _BASE + "/member/randomCode.htm?v="+version);
	});

	$("#login-form").validate({
		ignore: ":hidden",
		rules: {
			account:{
				required: true,
				rangelength: [4,20]
			},
			password:{
				required: true,
				rangelength: [6,20]
			},
			randCode:{
				required: true,
				rangelength: [4,4]
			}			
		},
		
		messages: {
			account:{
				required: '用户名不能为空！',
				rangelength: '用户名长度为{0} - {1}'
			},
			password:{
				required: '密码不能为空！',
				rangelength: '密码长度为{0} - {1}'
			},
			randCode:{
				required: '验证码不能为空！',
				rangelength: '验证码长度为{0} - {1}'
			}
		},
	
		errorElement: "label",				//用来创建错误提示信息标签
//	    success: function(label) {			//验证成功后的执行的回调函数
//		//label指向上面那个错误提示信息标签em
//		label.text(" ")//清空错误提示消息
//		.removeClass("guestError")//删除原有的样式类
//		.addClass("success");//额外添加自定义的success类
//	},
//	//更换报错信息位置
	errorPlacement: function(error, element) { 
		//element.next("em").next("strong").next("a").next("span").next("div").empty();
		//error.appendTo( element.next("em").next("strong").next("a").next("span").next("div") );
		
		//特殊结构
		if(element.attr("id") == "randCode"){
			element.parent().next().next().empty();
			error.appendTo(element.parent().next().next());
		}else{
			element.next().next().empty();
			error.appendTo(element.next().next());
		}
		
	},
//	
//	//错误和正确时添加的样式
	errorClass: "valid-failed",
//	successClass: "success"

  });

	// 提交订单
	$('#submit-btn').click(function() {
		if(!$("#login-form").valid()){
			return ;
		}
		
		loading("登录中，请稍后...");
		
		// ajax登录
		$.ajax({
			url: _BASE + "/member/loginValidate.htm", 
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
				
				// 登录成功，判断是否有回调
				if ($("#_CALLBACK").val() && $("#_CALLBACK").val()!="") {
					location.href=_BASE+$("#_CALLBACK").val();
					return;
				}else{
					location.href=_BASE;
				}
				
		    },
		    error:function(){
		    	closeLoading();
		    	dialog("提示","系统忙，请稍后再试。");
		    }
		});

		return false;
	});

});