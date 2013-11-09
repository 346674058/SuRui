<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>美食搜索-${productName}${version}</title>
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

		<#-- 导航栏 --> 
		<div class="nav_html">
		    <a href="${base}/index.htm" target="_self" title="首页" class="left">首页</a><div class="gt left">&gt;</div>
		    <label title="美食搜索" class="left strength">美食搜索</label>
		</div>
	
		<#-- 查询关键字 -->
		<form id="search_form" name="search_form">
			<input type="hidden" id="category" name="category" value="">
			<input type="hidden" id="priceRange" name="priceRange" value="">
			<input type="hidden" id="dispatchArea" name="dispatchArea" value="">
		</form>
		<div class="rec_area banner" style="height: auto;">
		    <div id="categorys" class="field" style="padding-top:15px;">美食分类:
			    <a id="all_cate" href="#" title="全部分类" class="cur">全部</a>
			    <#if categories?exists>
		    	<#list categories as category>
				    <a id="${category.categoryCode}" name="${category.categoryCode}" href="#" title="${category.categoryName}" >${category.categoryName}</a>
		    	</#list>
		    	</#if>
		    </div>
		    
		   	<div id="priceRange" class="field">价格范围:
			    <a id="all_price" href="#" title="全部价格" class="cur" >全部</a>
			    <a id="*-10" title="￥10以下" >￥10以下</a>
			    <a id="10-50" title="￥10-￥50" >￥10-￥50</a>
			    <a id="50-100" title="￥50-￥100" >￥50-￥100</a>
			    <a id="100-*" title="￥100以上" >￥100以上</a>
		    </div>
		    <div id="dispatchArea" class="field">配送区域:
		    	<a id="all_area" href="#" title="全部区域" class="cur">全部</a>
		    	<#if categories?exists>
		    	<#list districts as district>
				    <a id="${district.districtCode}" name="${district.districtCode}" href="#" title="${district.districtName}" >${district.districtName}</a>
		    	</#list>
		    	</#if>			    
			    <a id="more" href="##" title="点击查看更多区域" >更多..</a>
			    
			    <#-- 区域列表 -->
			    <#include "/common/districts.ftl">
		    </div>
		</div>
		
		<#-- 结果列表 -->
		<div class="rec_area mt10 border">
			<div class="rec_banner"></div>
			
			<#-- 排序 -->
		    <div id="filter" class="left"></div>
		    
		    <div class="page_count right">共找到<span id="totalCount" class="page_count_num">0</span>个相关产品</div>
		</div>
		
		<#-- 数据列表 -->
		<div id="commodityListCon" class="mt10">
			<div class="loadingCon"><label class="loading">商品加载中...</label></div>
		</div>

	</div>
	
	<#-- 浮动工具栏 -->
	<div class="sidebar" id="sidebar">
		<a href="${base}/commodity/shoppingCart.htm" target="_self" title="添加到购物车" class="sidebar_icon_word_02"><div class="sidebar_word">购物车</div></a>
		<a href="${base}/navigation/onlineService.htm" target="_blank" title="问题处理、疑问解答..." class="sidebar_icon_word_04"><div class="sidebar_word">在线客服</div></a>
		<a href="#" title="返回顶部"><div class="sidebar_back"></div></a>
	</div>
	
	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>

<#-- 最后引入js，防止阻塞页面加载 -->
<#assign js = ["js/jquery/jquery-1.7.1.min",
	"js/jquery.tab",
	"js/pagnation",
	"js/jquery.tabChg",
	"js/data/citys",
	"js/selector",
	
	"js/common",
	
	"js/custom/commoditySearch"
] >
<@res.js url = js />
</html>