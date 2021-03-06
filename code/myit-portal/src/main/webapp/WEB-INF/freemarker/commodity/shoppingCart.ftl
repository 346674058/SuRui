﻿<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车-美食之家</title>
<meta name="description" content="">

	<#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['css/common',
		"css/selector",
		'css/sonline/skin/default_blue',
		"css/tab"
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
		    <label title="购物车" class="left strength">购物车</label>
		</div>
		
		<#-- 商品列表--> 
		<#if commodities?exists && (commodities?size &gt; 0)>
		<table class="shoppin-cart banner">
			<thead>
			<tr class="title">
				<th><input type="checkbox" value="all">&nbsp;全选</th>
				<th colspan="2">商品信息</th>
				<th colspan="2">单价</th>
				<th>数量</th>
				<th>小计</th>
				<th></th>
			</tr>
			</thead>
			
			<#assign count=0 >
			<#list commodities as commodity>
			<#-- 累加商品数量 -->
			<#assign count=count+1>
			<tr class="item">
				<td class="chk"><input type="checkbox" value="1" checked="checked"></td>
				<td class="image"><a href="${base}/commodity/info.htm?comCode=${commodity.comCode}" >
					<#if commodity.img?exists>
					<img src="${commodity.img}" width="70px" height="70px;"></a></td>
					<#else>
					<img src="${resRoot}/img/default.jpg" width="70px" height="70px;"></a></td>
					</#if>
				
				<td style="text-align:left;">
					<a href="${base}/commodity/info.htm?comCode=${commodity.comCode}">${commodity.comName}</a>
				</td>
				
				<td style="text-align:right;">￥${commodity.price?string("0.##")}</td>
				<td></td>
				
				<td class="count">
					<a title="-1">-</a>
					<input type="text" id="count" name="count" value="${commodity.bookCount}">
					<a title="+1">+</a>
				</td>
				
				<td class="price active">￥${commodity.subTotalPrice?string("0.##")}</td>
				
				<td class="button"> <a id="delBtn" href="javascript:void(0);">删除</a> </td>
			</tr>
			</#list>
			
		</table>
		
		<#-- 工具栏 -->
		<div class="toolbarCon mt10">
			<div class="left" style="margin-left: 30px; margin-top: 10px;"><input type="checkbox" value="all">&nbsp;全选</div>
	    	<div class="toolbar right">
	    		总计&nbsp;<label class="active">${count}</label>&nbsp;件商品，总额&nbsp;<label class="active" style="margin-right:100px;font-size:16px;">￥${totalPrice?string("0.##")}</label>
	    		<a href="${base}/commodity/search.htm" target="_self" >继续购物</a>
	    		<a page_index="1" class="btn highlight" target="_self" href="${base}/order/bookOrder.htm">去结算</a>
	    	</div>
		</div>
		
		<#else>
		<#-- 购物车为空-->
		<div class="mt10">
			<div class="exception" id="dv_empty_ad">
			  <div style="height:25px;line-height:25px;font-size:16px;font-weight:bold;color:#666666;">您还没有挑选商品！</div>
			  <div style="height:80px;line-height:80px;margin-top:30px;">
			      <div style="color:#696969;height:30px;line-height:30px;text-align:left;">
					<a class="active" href="${base}/commodity/search.htm">继续购物</a>
		  		  </div>
		  	</div>
		</div>
		</#if>
	</div>

	<#-- 浮动工具栏 -->
	<div class="sidebar" id="sidebar">
		<a href="#" title="返回顶部"><div class="sidebar_back"></div></a>
	</div>
	
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["js/jquery/jquery-1.7.2.min",
		"js/jquery.tab",
		"js/jquery.tabChg",
		"js/data/citys",
		"js/selector",
		"js/jquery.sonline",
		
		"js/common",
		
		"js/custom/shoppingCart"
	] >
	<@res.js url = js />
	
	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>

</html>