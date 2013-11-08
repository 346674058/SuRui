$(document).ready(function(){

		//自定义一个验证方法
		$.validator.addMethod(
		"illegalCharacter", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^[\u4e00-\u9fa5a-zA-Z\/\s]*$/;
			return regExp.test(value);
		}, 
		'姓名中含有非法字符，请重新输入'//验证提示信息
		);
		
		//总格式验证
		$.validator.addMethod(
				"Format", //验证方法名称
				function(value, element, param) {//验证规则
					var regExp1 =  /^([\u4E00-\u9FA5\uF900-\uFA2D]){2,10}$/;//全汉字
					var regExp2 = /^([\u4E00-\u9FA5\uF900-\uFA2D])+([a-zA-Z])*$/;//汉字加拼音
					var regExp3 =  /^([a-zA-Z])+([\ ]){1}([a-zA-Z])+$/;//字母加空格加字母
					var regExp4 =  /^([a-zA-Z])+$/;//全字母
					var flag1 = regExp1.test(value);
					var flag2 = regExp2.test(value);
					var flag3 = regExp3.test(value);
					var flag4 = regExp4.test(value);
					return (flag1||flag2||flag3||flag4);
				}, 
				'姓名必须是中文、拼音或英文，请正确填写'//验证提示信息
				);
		
		$.validator.addMethod(
				"ContainBlank", //验证方法名称
				function(value, element, param) {//验证规则
					var regExp = /(\s)/;
					if( regExp.test(value)){
						return false;
					} else{
						return true;
					}
				}, 
				'姓名中含有空白字符，请重新输入'//验证提示信息
		);
		
		$.validator.addMethod(
		"chineseSizeTooShort", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^[\u4e00-\u9fa5]*$/;
			if(regExp.test(value)){
				if (value.length < 2){
					return false;
				} else{
					return true;
				}
			} else{
				return true;
			}
			
		}, 
		'中文姓名不少于2个汉字，请正确输入您的姓名'//验证提示信息
		);
		
		$.validator.addMethod(
		"chineseSizeTooLong", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^[\u4e00-\u9fa5]*$/;
			if(regExp.test(value)){
				if (value.length > 10){
					return false;
				} else{
					return true;
				}
			}else{
				return true;
			}
		}, 
		'中文姓名不多于10个汉字，请正确输入您的姓名'//验证提示信息
		);
		
		$.validator.addMethod(
		"englishAfterChinese", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^(([\u4E00-\u9FA5\uF900-\uFA2D])*([a-zA-Z])+([\u4E00-\u9FA5\uF900-\uFA2D])+)$/;
			return !regExp.test(value);
		}, 
		'您输入的格式不正确，拼音后面不能再输入汉字，请用拼音替代'//验证提示信息
		);
		
		$.validator.addMethod(
		"englishNameTooShort", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^([a-zA-Z])*$/;
			if (regExp.test(value)){
				if(value.length<2){
					return false;
				} else{
					return true;
				}
			}else{
					return true;
			}
		}, 
		'英文名字不少于2个单词，请正确输入您的姓名'//验证提示信息
		);
		
		$.validator.addMethod(
		"englishName", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp1 = /^([a-zA-Z]*\/*)$/;
			if (regExp1.test(value)){
				var regExp2 = /^([a-zA-Z]{1,20}\/{1}[a-zA-Z]{1,20})$/;
				return regExp2.test(value);
			} else {
				return true;
			}
		}, 
		'填写英文姓名请在姓与名之间用"/"分隔，并按照证件上的姓名顺序填写'//验证提示信息
		);
		//验证证件号validateIdentityCard
		$.validator.addMethod(
		"validateIdentityCardLength", //验证方法名称
		function(value, element, param) {//验证规则
			if( $(element).prev().val()=='0'){
				var size = value.length ;
				if(size == 15 || size == 18){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
			
		}, 
		'身份证号码位数不对!'//验证提示信息
		);
		
		//验证证件号validateIdentityCardBirthday
		$.validator.addMethod(
		"validateIdentityCardBirthday", //验证方法名称
		function(value, element, param) {//验证规则
			if( $(element).prev().val()=='0'){
				var size = value.length ;
				var credentialBirthday = 0;
				if(size == 15){
					credentialBirthday = parseInt(value.substr(6, 2)) + 1900;
					if(credentialBirthday % 400 == 0 ||(credentialBirthday % 100 != 0 && credentialBirthday % 4 == 0)){
						ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2] [0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9])) [0-9]{3}$/;// 测试出生日期的合法性
						return ereg.test(value);
					}else{
						ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]| [1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;// 测试出生日期的合法性
						return ereg.test(value);
					}
				}
				if(size == 18){
					credentialBirthday = parseInt(value.substr(6, 4));
					if(credentialBirthday % 400 == 0 || (credentialBirthday % 100 != 0 && credentialBirthday % 4 == 0)){
						ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;// 闰年出生日期的合法性正则表达式
						return ereg.test(value);
					}else{
						ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;// 平年出生日期的合法性正则表达式
						return ereg.test(value);
					}
				}	
				else{
					return false;
				}
			}else{
				return true;
			}
		}, 
		'身份证号码出生日期超出范围或含有非法字符!'//验证提示信息
		);
		
		//验证证件号validateIdentityCardErrorArea
		$.validator.addMethod(
		"validateIdentityCardErrorArea", //验证方法名称
		function(value, element, param) {//验证规则
			if( $(element).prev().val()=='0'){
				var area = {
						11 : "北京", 12 : "天津", 13 : "河北", 14 : "山西", 15 : "内蒙古", 21 : "辽宁", 22 : "吉林", 23 : "黑龙江",
						31 : "上海", 32 : "江苏", 33 : "浙江", 34 : "安徽", 35 : "福建", 36 : "江西", 37 : "山东", 41 : "河南",
						42 : "湖北", 43 : "湖南", 44 : "广东", 45 : "广西", 46 : "海南", 50 : "重庆", 51 : "四川", 52 : "贵州",
						53 : "云南", 54 : "西藏", 61 : "陕西", 62 : "甘肃", 63 : "青海", 64 : "宁夏", 65 : "新疆", 71 : "台湾",
						81 : "香港", 82 : "澳门", 91 : "国外"
						};
				if (area[value.substring(0, 2)] == null){
					return false;
				} else{
					return true;
				}
			}else{
				return true;
			}
		}, 
		'身份证地区非法!'//验证提示信息
		);
		
		//验证证件号validateIdentityCardFormat
		$.validator.addMethod(
		"validateIdentityCardFormat", //验证方法名称
		function(value, element, param) {//验证规则
			if( $(element).prev().val()=='0'){
				var area = {
						11 : "北京", 12 : "天津", 13 : "河北", 14 : "山西", 15 : "内蒙古", 21 : "辽宁", 22 : "吉林", 23 : "黑龙江",
						31 : "上海", 32 : "江苏", 33 : "浙江", 34 : "安徽", 35 : "福建", 36 : "江西", 37 : "山东", 41 : "河南",
						42 : "湖北", 43 : "湖南", 44 : "广东", 45 : "广西", 46 : "海南", 50 : "重庆", 51 : "四川", 52 : "贵州",
						53 : "云南", 54 : "西藏", 61 : "陕西", 62 : "甘肃", 63 : "青海", 64 : "宁夏", 65 : "新疆", 71 : "台湾",
						81 : "香港", 82 : "澳门", 91 : "国外"
						};
				var card_array = value.split("");
				var credentialBirthday,JYM,Str,Y;
				if (area[value.substring(0, 2)] != null){
					var size = value.length ;
					if(size == 18){
						credentialBirthday = parseInt(value.substr(6, 4));
						if(credentialBirthday % 400 == 0 || (credentialBirthday % 100 != 0 && credentialBirthday % 4 == 0)){
							ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;// 闰年出生日期的合法性正则表达式
						}else{
							ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;// 平年出生日期的合法性正则表达式
						}
						if(ereg.test(value)){
								// 计算校验位
								Str = (parseInt(card_array[0]) + parseInt(card_array[10])) * 7
										+ (parseInt(card_array[1]) + parseInt(card_array[11]))
										* 9
										+ (parseInt(card_array[2]) + parseInt(card_array[12]))
										* 10
										+ (parseInt(card_array[3]) + parseInt(card_array[13]))
										* 5
										+ (parseInt(card_array[4]) + parseInt(card_array[14]))
										* 8
										+ (parseInt(card_array[5]) + parseInt(card_array[15]))
										* 4
										+ (parseInt(card_array[6]) + parseInt(card_array[16]))
										* 2 + parseInt(card_array[7]) * 1
										+ parseInt(card_array[8]) * 6 + parseInt(card_array[9])
										* 3;
								Y = Str % 11;
								M = "F";
								JYM = "10X98765432";
								M = JYM.substr(Y, 1);// 判断校验位
								if (M == card_array[17]){
									return true; // 检测ID的校验位
								}
								else{
									return false;
								}
						  } else{ 
							return true;
						  }
					  } else{
						return true;
					  }
				  } else{
					return true;
				  }
			}else{
				return true;
			}
		}, 
		'身份证号码校验错误!'//验证提示信息
		);
		
		//验证儿童的证件号validateIdentityCardForChildren
		$.validator.addMethod(
		"validateIdentityCardForChildren", //验证方法名称
		function(value, element, param) {//验证规则
			if( $(element).prev().val()=='0' && 
					$(element).closest('.part').find('input:radio:eq(1)').attr('checked')){
				var birDay = $(element).closest('.part').find('.childrenClass input:eq(2)').val().substring(0,10).split('-');
				if(value.substring(6, 10) != birDay[0] 
				|| value.substring(10, 12) != birDay[1]  
				|| value.substring(12, 14) != birDay[2] ){
					return false;
				} else{
					return true;
				}
				
			} else{
				return true;
			}
		}, 
		'儿童的出生日期和身份证号码的出生日期不一致！'//验证提示信息
		);
		
		//乘机人信息验证(手机号码验证)
		$.validator.addMethod(
		"mobileFormat", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^(1[3|4|5|8][0-9]\d{8})$/;
			return regExp.test(value) || value == '';
		}, 
		'请正确填写11位手机号码'//验证提示信息
		);
		
		//联系人信息验证(手机号码验证)
		$.validator.addMethod(
		"contactMobileFormat", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^(1[3|4|5|8][0-9]\d{8})$/;
			return regExp.test(value);
		}, 
		'请正确填写11位手机号码'//验证提示信息
		);
		
		//联系人信息验证(邮箱验证)
		$.validator.addMethod(
		"contactEmailFormat", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp1 = /^(\s){0}$/;
			if(regExp1.test(value)){
				return true;
			} else{
				var regExp2 = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
				return regExp2.test(value);
			}
		}, 
		'请输入正确的邮箱！'//验证提示信息
		);
		
		//行程单收件人手机号码验证
		$.validator.addMethod(
		"addressSendMobile", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^(1[3|4|5|8][0-9]\d{8})$/;
			return regExp.test(value);
		}, 
		'收件人手机号码格式不正确！'//验证提示信息
		);
		
		//行程单邮编验证
		$.validator.addMethod(
		"zipCodeValidate", //验证方法名称
		function(value, element, param) {//验证规则
			var regExp = /^(\d{6})$/;
			return regExp.test(value);
		}, 
		'邮箱格式不正确！'//验证提示信息
		);
		
		//不论什么时候，当你的表单中的多个字段含有相同的验证规则及验证消息，重构规则可以减少很多重复
		$.validator.addClassRules(
		"passNameFormat", 
			{
				required: true,
				illegalCharacter: true,
				ContainBlank:true,
				chineseSizeTooShort:true,
				chineseSizeTooLong:true,
				englishAfterChinese:true,
				englishNameTooShort:true,
				englishName:true,
				Format:true,
				remote:{
		               type:"POST",
		               url:$("#h_base").val() + "/orderAddress/checkHardName.htm",  
		               name: 'name'
		        }
			}
		);   
		
		
		$.validator.addClassRules(
		"credential", 
			{
				required: true,
				validateIdentityCardLength:true,
				validateIdentityCardBirthday:true,
				validateIdentityCardErrorArea:true,
				validateIdentityCardFormat:true,
				validateIdentityCardForChildren:true
			}
		);   
		
		$.validator.addClassRules(
		"mobile", 
			{
				mobileFormat:true
			}
		); 
		
		$.validator.addClassRules(
			"nameForamt", 
			{
				Format:true
			}
		); 
	
  });