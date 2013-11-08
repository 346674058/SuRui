$(document).ready(function(){
		
	//日历控件
	$( "#birthday" ).attr("readonly","readonly").datepicker({
        defaultDate: "+1w",
        minDate: '2013-09-18',
        maxDate: '2013-09-20',
        dateFormat: 'yy-mm-dd',
        onClose: function( selectedDate ) {
            $(this).val(selectedDate );
        }
    });
		
	//城市插件
	new Vcity.CitySelector({
		input : 'city',
		data: _CITYS,
		blankTxt: '请选择城市',
		firstTbName: '热门城市',
		firstTbSize:12,
		winSize: 15,
		callback: function(v) {
			$("#cityId").val(v.split("|")[1]);
			
		}
	});
		
	// location选择
	$("#district").attr("readonly","readonly");
	locality("#district", ".localityBox", function(o){
		// TODO 
	}); 
	
    $("#regist-form").validate({
		ignore: ":hidden",
		rules: {
			memberNo:{
				required: true,
				rangelength: [4,20]
			},
			password:{
				required: true,
				rangelength: [6,20]
			},
			nick:{
				rangelength: [4,20]
			},
			email:{
				email: true
			},
			birthday:{
				date: true
			}
		},
		
		messages: {
			memberNo:{
				required: '账户不能为空！',
				rangelength: '账户长度为{0} - {1}'
			},
			password:{
				required: '密码不能为空！',
				rangelength: '密码长度为{0} - {1}'
			},
			nick:{
				rangelength: '昵称长度为{0} - {1}'
			},
			mobile:{
				mobile: '手机格式错误！'
			},
			birthday:{
				mobile: '日期格式错误！'
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

	// 提交注册信息
	$('#submit-btn').click(function() {
		if(!$("#regist-form").valid()){
			return ;
		}
		
		loading("信息提交中，请稍后...");
		
		// ajax登录
		$.ajax({
			url: _BASE + "/member/saveRegist.htm", 
			type: 'POST', 
			data:$("#regist-form").serialize(),
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
				
				// 注册成功，免登录，直接跳转到查询页面
				location.href=_BASE + "/recommodity/list.htm";
		    },
		    error:function(){
		    	closeLoading();
		    	dialog("提示","系统忙，请稍后再试。");
		    }
		});

		return false;
	});

});