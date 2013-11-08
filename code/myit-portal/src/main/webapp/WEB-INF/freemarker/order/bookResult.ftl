<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>预订结果-美食之家</title>
<meta name="description" content="">

	<#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['css/common',
		'css/selector',
		'css/tab'
				]>
	<@res.css url =css />
</head>

<body>

	<#-- 页头 -->
	<#include "/common/header.ftl">

	<#-- 页面主体 -->
	<div class="main center">

		<!-- 导航栏 --> 
		<div class="nav_html">
		    <a href="${base}/index.htm" target="_self" title="首页" class="left">首页</a><div class="gt left">&gt;</div>
		    <label title="预定结果" class="left strength">预定结果</label>
		</div>

		<#-- 结果提示-->
		<div class="rec_area mt10 banner" style="line-height: 25px; height:auto;">
			<div class="center" style="width:600px; margin-top:30px;margin-bottom:30px;">
				<div class="info" style="font-size:20px; text-align:center;"><img src="${resRoot}/img/success.png" />您的订单已经提交成功</div>
				
				<div class="hrl mt10"></div>
				订单号：<label class="active">${order.orderNo}</label><br>
				配送地址：<label class="active">${order.address}</label><br>
				预计最晚送达时间：<label class="active">${order.lastestTime}</label><br>
				您还可以：继续<a class="active" href="${base}/commodity/search.htm">购物</a>，或者查看<a class="active" href="${base}/order/orderDetail/${order.orderNo}.htm">订单详情</a>查看你的订单详情。
			</div>
		</div>
		
	</div>

	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>
	
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["js/jquery/jquery.min",
		"js/jquery.tab",
		"js/jquery.tabChg",
		"js/common"
	] >
	<@res.js url = js />
</html>