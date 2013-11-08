<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提交订单-美食之家</title>
<meta name="description" content="">

	<#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['css/common',
		"css/jquery-ui-1.9.2.custom",
		"css/selector",
		"css/tab"
				]>
	<@res.css url =css />

</head>

<body>
	<#-- 页头 -->
	<div class="headerCon" style="border-bottom:1px solid #ccc;">
	  <div class="header center">
	  	<div class="left">
	    	<a href="${base}" target="_self"><img class="logo left" /></a>
	  	</div>
	  </div>
	</div>

	<#-- 页面主体 -->
	<div class="main center">
		
		<#-- 预订导航 -->
		<div class="book-navigation mt10">选择商品 > <label class="cur">提交订单</label> > 在线支付 > 收货 > 评价拿积分</div>
		
		<#-- 配送信息 -->
		<form id="submit-form">
		<div class="caption">配送信息</div>
		<div style="height: auto;" class="rec_area">
			<div class="rec_banner"></div>
		    <div style="padding-top:15px;" class="field">联&nbsp;系&nbsp;&nbsp;人:
			    <input id="contact" name="contact" type="text" class="input-text" style="margin-left: 5px;" value="${order.contact}"><label class="must">*</label>
		    </div>
		    
		   	<div class="field">联系电话:
			    <input id="mobile" name="mobile" type="text" class="input-text" style="margin-left: 5px;" value="${order.mobile}"><label class="must">*</label><label class="info">请务必填写准确，便于商品能够准确送达。</label>
		    </div>
		    
		   	<div class="field">送达时间:
			    <input id="latestTime" name="latestTime" type="text" class="input-text" style="margin-left: 5px; width:100px;" value="2013-09-18">
			    <input id="endTime" name="endTime" type="text" class="input-text" style="margin-left: 5px; width:50px;" value="13:00">
			    	<div class="tagCon">
							<a href="javascript:void(0);" name="00:00">00:00</a>
							<a href="javascript:void(0);" name="00:30">00:30</a>
							<a href="javascript:void(0);" name="01:00">01:00</a>
							<a href="javascript:void(0);" name="01:30">01:30</a>
							
							<a href="javascript:void(0);" name="02:00">02:00</a>
							<a href="javascript:void(0);" name="02:30">02:30</a>
							<a href="javascript:void(0);" name="03:00">03:00</a>
							<a href="javascript:void(0);" name="03:30">03:30</a>
							
							<a href="javascript:void(0);" name="04:00">04:00</a>
							<a href="javascript:void(0);" name="04:30">04:30</a>
							<a href="javascript:void(0);" name="05:00">05:00</a>
							<a href="javascript:void(0);" name="05:30">05:30</a>
						</div>
			    </select>
			    <label class="must">*</label><label class="info">可以接受的最晚送达时间。</label>
		    </div>
		    
		    <div class="field">配送地址:
			    <input id="cityId" name="cityId" type="hidden" value="0102">
			    <input id="city" name="city" type="hidden" value="南京市">
			    <label style="margin-left: 5px;font-size:16px;">南京市</label>
			    <input id="districtId" name="districtId" type="hidden" value="0102001">
			    <input id="district" name="district" type="text" class="input-text" value="玄武区">
			    	
		    	<#-- 区域列表 -->
			    <#include "/common/districts.ftl">
			    
			    <label style="margin-left: 5px;">小区/街道</label>
			    <input id="street" type="text" class="input-text" value="徐庄软件园">
			    <div class="tagCon">
					<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
					<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
					<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
					<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
				</div>
			    
			    <input id="address" type="text" class="input-text" value="${order.address}" style="width:250px;">
			    <input id="saveAddress" type="checkbox" value="1" style="margin-left: 5px;">&nbsp;保存到常用地址
		    </div>
	    </div>
		
		<#-- 商品信息 -->
		<div class="caption">商品信息<a href="shoppingCart.html" class="right">返回购物车</a></div>
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
			
		<!-- 工具栏 -->
		<div class="toolbarCon mt10">
			<div class="left" style="margin-left:20px;margin-top:10px;">预计最晚送达时间：<label class="active">2013-09-19 12:30</label></div>
	    	<div class="toolbar right">
	    		总计&nbsp;<label class="active">12</label>&nbsp;件商品，总额&nbsp;<label class="active" style="margin-right:100px;font-size:16px;">￥${order.totalPrice}</label>
	    		<a id="submit-btn" class="btn highlight" target="_self" href="#">提交订单</a>
	    	</div>
		</div>
	</div>

	<div id="dialog-loading"><div class="loading left"></div><div>订单提交中...</div></div>
	<div id="dialog">订单提交失败，原因码：900001</div>
	
	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>

<#-- 最后引入js，防止阻塞页面加载 -->
<#assign js = ["js/jquery/jquery.min",
	"js/jquery/jquery-ui-1.9.2.custom.min",
	"js/jquery.tab",
	"js/jquery.tabChg",
	
	"js/common",
	
	"js/custom/bookOrder"
] >
<@res.js url = js />
</html>