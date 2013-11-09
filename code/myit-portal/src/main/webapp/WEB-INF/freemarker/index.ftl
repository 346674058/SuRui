<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>首页-${productName}${version}</title>
	<meta name="description" content="" >
	
	<#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['css/common',
		'css/selector',
		'css/tab',
		'css/sonline/skin/default_blue'
				]>
	<@res.css url =css />
	
	</head>
	
	<body>
		<#-- 页头 -->
		<#include "/common/header.ftl">
	
		<#-- 页面主体 -->
		<div class="main center">
	
			<#-- 搜索 -->
			<div class="asp_top left">
				<div class="title"></div>
				
				<form id="query_form" action="commodity/search.htm" method="post">
				<div class="asp_item" style="margin-top:20px;">
					<div class="asp_title left">美食分类</div>
					<div class="asp_desc"><input id="catagory" type="text" name="catagory" class="input-text">				
						<div class="tagCon">
							<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
							<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
							<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
							<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a>
						</div>
								
					</div>
				</div>
				<div class="asp_item" style="height:60px;">
					<div class="asp_title left">价格范围</div>
					<div class="asp_desc">
						<input id="price0" type="radio" name="price" value="" checked="checked"><label for="price0">不限</label>
						<input id="price1" type="radio" name="price" value="*-10" ><label for="price1">￥10以下</label>
						<input id="price2" type="radio" name="price" value="10-50" ><label for="price2">￥10-￥50</label><br>
						<input id="price3" type="radio" name="price" value="50-100" ><label for="price3">￥50-￥100</label>
						<input id="price4" type="radio" name="price" value="100-*" ><label for="price4">￥100以上</label>
					</div>
				</div>
				<div class="asp_item">
					<div class="asp_title left">配送区域</div>
					<div class="asp_desc"><input id="location" name="location" class="input-text">
					
						<div id="localityBox" class="localityBox">
								<br>
								<ol id="localityBoxList">
									<li class="on">商业区</li>
									<li>行政区</li>
								</ol>
								<div id="ciDetail1" class="ciDetail">
									<ul id="ciDetailList1">
								      	<li class="on">ABCDEF</li>
								         	<li>GHJKLM</li>
								        	<li>NPQRS</li>
								        	<li>TWXYZ</li>
								   	</ul>
								   	<div class="locality"  style="display: block;" id="cArea_0">
								   		<a href="javascript:void(0);" title="东直门/簋街" name="010104">东直门/簋街</a><a href="javascript:void(0);" title="北大/清华/学院路" name="010185">北大/清华/学院路</a><a href="javascript:void(0);" title="安贞" name="010186">安贞</a></div>
								   	<div class="locality" id="cArea_1">
								   		<a href="javascript:void(0);" title="国贸CBD" name="010101">国贸CBD</a><a href="javascript:void(0);" title="丽泽商务区" name="010179">丽泽商务区</a><a href="javascript:void(0);"title="金源燕莎MALL" name="010180">金源燕莎MALL</a><a href="javascript:void(0);" title="航天桥/首都师范大学" name="010182">航天桥/首都师范大学</a></div>
							    	<div class="locality" id="cArea_2">
							    		<a href="javascript:void(0);" title="首都国际机场1/2号航站楼" name="010107">首都国际机场1/2号航站楼</a><a href="javascript:void(0);" title="上地工业园区" name="010184">上地工业园区</a></div>
							    	<div class="locality" id="cArea_3">
							    		<a href="javascript:void(0);" title="燕莎/农展馆" name="010102">燕莎/农展馆</a><a href="javascript:void(0);" title="新国展" name="010160">新国展</a><a href="javascript:void(0);" title="天桥" name="010166">天桥</a><a href="javascript:void(0);" title="五棵松体育馆" name="010181">五棵松体育馆</a><a href="javascript:void(0);" title="总部基地" name="010187">总部基地</a></div>
								</div>
								<div id="ciDetail2" class="ciDetail hidden">
									<div class="locality on" id="dArea">
										<a href="javascript:void(0);" title="西城区" name="0001">西城区</a><a href="javascript:void(0);" title="平谷区" name="0030">平谷区</a><a href="javascript:void(0);" title="门头沟区" name="0031">门头沟区</a><a href="javascript:void(0);" title="房山区" name="0032">房山区</a><a href="javascript:void(0);" title="大兴区" name="0033">大兴区</a></div>
								</div>
							</div>
					
					</div>
				</div>
				</form>
				
				<div class="footer">
					<input type="button" value="搜　索" class="searchbar_button" id="btn_search">
				</div>
			</div>
		
			<#-- 广告 -->
			<div id="adv_flash" class="adv_flash right slide">
				<#-- 图片列表 -->
			</div>
	
		  	<div class="clearfix"></div>
		  	
			<#-- 分类推荐 -->
			<div id="categoryRecom" class="ad_container tab">
				<#-- 分类列表 -->
			</div>
		</div>
		
		<#-- 浮动工具栏 -->
		<div class="sidebar" id="sidebar">
			<a href="${base}/commodity/shoppingCart.htm" target="_self" title="添加到购物车" class="sidebar_icon_word_02"><div class="sidebar_word">购物车</div></a>
			<a href="#" title="返回顶部"><div class="sidebar_back"></div></a>
		</div>
		
		<#-- 最后引入js，防止阻塞页面加载 -->
		<#assign js = ["js/jquery/jquery-1.7.2.min",
			"js/jquery.tab",
			"js/jquery.tabChg",
			"js/jquery.slide",
			"js/jquery.sonline",
			"js/data/citys",
			"js/selector",
			"js/common",
			
			"js/custom/index"
		] >
		<@res.js url = js />
		
		<#-- 页脚 -->
		<#include "/common/footer.ftl">
	</body>

</html>