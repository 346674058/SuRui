<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>订单中心-美食之家</title>
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
		    <label title="订单中心" class="strength left">订单中心</label>
		</div>
		
		<#-- 查询条件 -->
		<div class="rec_area" style="height: auto;">
			<div class="rec_banner"></div>
		    <div class="field" style="padding-top:15px;">下单时间：
		    	<select id="timeRange" class="select" onchange="search();">
		    		<option value="0">全部</option>
		    		<option value="1" selected="selected">一个月内</option>
		    		<option value="2">两个月内</option>
		    		<option value="6">半年内</option>
		    		<option value="-1">自定义</option>
		    		
		    		<input id="timeBegin" type="text" class="input-text" style="margin:0px 5px; width:100px;">到<input id="timeEnd" type="text" class="input-text" style="margin-left: 5px; width:100px;">
		    		<a class="btn small highlight" href="javascript:search();">查询</a>
		    	</select>
		    </div>
		    
		   	<div class="field">订单状态：
			    <a href="javascript:search();" title="全部订单" class="cur" >全部</a>
			    <a href="javascript:search();" title="待支付的订单">待支付</a>
			    <a href="javascript:search();" title="待收货的订单" >待收货</a>
			    <a href="javascript:search();" title="待点评的订单" >待点评</a>
			    <a href="javascript:search();" title="已关闭的订单" >已关闭</a>
			</div>
		</div>
		
		<#-- 订单列表 -->
		<div id="orderListCon" class="mt10">
			<div class="loadingCon"><label class="loading">订单加载中...</label></div>
		</div>
	</div>
	
	<#-- 浮动工具栏 -->
	<div class="sidebar" id="sidebar">
		<a href="#" target="_self" title="问题处理、疑问解答..." class="sidebar_icon_word_04"><div class="sidebar_word">在线客服</div></a>
		<a href="#" title="返回顶部"><div class="sidebar_back"></div></a>
	</div>

	<div id="dialog-loading"><div class="loading left"></div><div>订单提交中...</div></div>
	<div id="dialog">订单提交失败，原因码：900001</div>

	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>
	
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["js/jquery/jquery.min",
		"js/jquery/jquery-ui-1.9.2.custom.min",
		"js/pagnation",
		"js/jquery.tab",
		"js/jquery.tabChg",
		"js/common",
		
		"js/custom/orderCenter"
	] >
	<@res.js url = js />
</html>