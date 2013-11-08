<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单详情-美食之家</title>
<meta name="description" content="">
	<#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['css/common',
		'css/jquery-ui-1.9.2.custom',
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
	
		<#-- 导航栏 --> 
		<div class="nav_html">
		    <a href="${base}/index.htm" target="_self" title="首页" class="left">首页</a><div class="gt left">&gt;</div>
		    <a href="${base}/order/orderCenter.htm" target="_self" title="订单中心" class="left">订单中心</a><div class="gt left">&gt;</div>
		    <label title="订单详情" class="left strength">${order.orderNo}</label>
		</div>
		
		<div class="book-navigation mt10">选择商品 > 提交订单 > 在线支付 > <label class="cur">收货</label> > 评价拿积分</div>
		
		<#-- 商品信息 -->
		<div class="caption">商品信息<div class="right" style="font-size: 12px; margin-top: 5px; font-weight: normal;">您还有<label id="timer" class="active">01小时</label>可以支付</div></div>
		<table class="shoppin-cart banner">
			<thead>
			<tr class="title">
				<th colspan="2">商品信息</th>
				<th colspan="2">单价</th>
				<th>数量</th>
				<th>小计</th>
			</tr>
			</thead>
			
			<#list order.orderItems as orderItem>
			<#if orderItem_index == order.orderItems?size-1>
			<tr class="item last">
			<#else>
			<tr class="item">
			</#if>
				<td class="image"><img src="${resRoot}/${orderItem.commodity.img}"></td>				
				<td style="text-align:left;">${orderItem.commodity.name}</td>
				
				<td style="text-align:right;">￥${orderItem.commodity.price}</td>
				<td></td>
				<td class="count">${orderItem.count}</td>
				
				<td class="price active" style="width:120px;text-align:left;">￥${orderItem.subTotal}<br><label class="freight">（另加运费：￥2.00）</label></td>
			</tr>
			</#list>
		</table>
		
		<#-- 配送信息 -->
		<div class="caption">配送信息</div>
		<div style="height: auto;" class="rec_area">
			<div class="rec_banner"></div>
			<div style="padding-top:15px;" class="field">联系人：<label class="active">${order.contact}</label></div>	    
		   	<div class="field">联系电话：<label class="active">${order.mobile}</label></div>
	    
		   	<div class="field">送达时间：<label class="active" style="margin-right:10px;">${order.transportTime}</label>&nbsp;最晚送达时间：<label class="active">${order.latestTransportTime}</label></div>		    
		    <div class="field">配送地址：<label class="active">${order.address}</label></div>
		</div>
			
		<#-- 工具栏 -->
		<div class="toolbarCon mt10">
			<div class="left" style="padding:8px 10px;">
				总计&nbsp;<label class="active">12</label>&nbsp;件商品，总额&nbsp;<label class="active" style="margin-right:100px;font-size:16px;">￥127.50</label>
			</div>
	    	<div class="toolbar right">    		
	    		<a page_index="1" id="submit-btn" class="btn highlight" target="_self" href="#">在线支付</a>
	    	</div>
		</div>
	</div>
</div>

<#-- 浮动工具栏 -->
<div class="sidebar" id="sidebar">
	<a href="#" target="_self" title="问题处理、疑问解答..." class="sidebar_icon_word_04"><div class="sidebar_word">在线客服</div></a>
	<a href="#" title="返回顶部"><div class="sidebar_back"></div></a>
</div>

<div id="dialog-loading"><div class="loading left"></div><div style="width:125px;">跳转到银联支付...</div></div>
<div id="dialog">订单取消失败，原因码：900001</div>

<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>
	
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["js/jquery/jquery.min",
		"js/jquery/jquery-ui-1.9.2.custom.min",
		"js/jquery.tab",
		"js/jquery.tabChg",
		"js/common"
	] >
	<@res.js url = js />
</html>
