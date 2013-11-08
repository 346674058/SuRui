<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员登录-${productName}${version}</title>
<meta name="description" content="">

	<#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['css/common',
		"css/jquery-ui-1.9.2.custom"
				]>
	<@res.css url =css />
</head>

<body>

	<div class="headerCon" style="border-bottom:1px solid #ccc;">
	  <div class="header center">
	  	<div class="left">
	    	<a href="${base}" target="_self"><img class="logo left" /></a>
	  	</div>
	  </div>
	</div>

	<#-- 页面主体 -->
	<div class="main center">
		
		<#-- 导航栏 --> 
		<div class="nav_html">
		    <a href="${base}/index.htm" target="_self" title="首页" class="left">首页</a><div class="gt left">&gt;</div>
		    <label title="会员登录" class="left strength">会员登录</label>
		</div>
		
		<div class="left advertise">
			<a href="${base}/${advImg.href}" target="_blank"><img src="${resRoot}/${advImg.src}" /></a>
		</div>
		
		<div class="right">
			<form id="login-form">
			<input type="hidden" id="_CALLBACK" name="_CALLBACK" value="${_CALLBACK}" >
			<table class="shoppin-cart banner loginCon">
				<tr class="item">
					<td style="width:80px;" class="text-right">账户</td>
					<td class="text-left">
						<input type="text" id="account" name="account" class="input-text"><label class="must">*</label>
						<div class="clearfix"></div>
					</td>
				</tr>
				<tr class="item">
					<td class="text-right">密码</td>
					<td class="text-left">
						<input type="password" id="password" name="password" class="input-text"><label class="must">*</label>
						<div class="clearfix"></div>
					</td>
				</tr>
				<tr class="item">
					<td class="text-right">验证码</td>
					<td class="text-left">
						<div class="left"><input id="randCode" name="randCode" type="text" class="input-text" style="width:50px;"><label class="must">*</label></div>
						<div><img id="randCodeImg" name="randCodeImg" src="${base}/member/randomCode.htm?v=${.now}" class="rand-code" title="点击刷新" /></div>
						<div class="clearfix"></div>
					</td>
				</tr>
				<tr class="item">
					<td colspan="2">
						<div class="mt10 hrl"></div>
						
						<div class="left" style="text-align: right; width: 45%;">
							<a id="submit-btn" class="btn highlight" href="javascript:;">登录</a>
						</div>
						<div class="right" style="text-align: left; width: 55%; margin-top: 10px;">
							还没有账户？立即[<a href="${base}/member/regist.htm" class="active">注册</a>]
						</div>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>

	<div id="dialog-loading"><div class="loading left"></div><div id="msg">登录中...</div></div>
	
	<div id="dialog">登录失败，原因码：900001</div>

	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>
	
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["js/jquery/jquery.min",
		"js/jquery/jquery-ui-1.9.2.custom.min",
		"js/jquery/jquery.validate",
		"js/common",
		
		"js/custom/login"
	] >
	<@res.js url = js />
</html>
