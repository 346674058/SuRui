<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>找不到页面-美食之家</title>
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
		    <label title="找不到页面" class="left strength">找不到页面</label>
		</div>

		<#-- 异常提示-->
		<div class="exception show" id="dv_empty_ad">
	      <div style="height:25px;line-height:25px;font-size:16px;font-weight:bold;color:#666666;">您访问的页面似乎找不到了!</div>
	      <div style="height:80px;line-height:80px;margin-top:30px;">
	          <div style="color:#c2c2c2;height:20px;line-height:20px;text-align:left;">建议您:</div>
	          <div style="color:#696969;height:30px;line-height:30px;text-align:left;">
	          	1.尝试从 <span style="color:#d32e00;font-weight:bold;">所有产品分类</span> 中点击与您相关的分类,或直接搜索关键词;</div>
	          <div style="color:#696969;height:30px;line-height:30px;text-align:left;">
	          	2.等待 <span style="color:#d32e00;font-weight:bold;" id="remain_time">10秒</span> ，自动为您返回首页......</div>
	      </div>
	  </div>
		
	</div>
	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>

<#-- 最后引入js，防止阻塞页面加载 -->
<#assign js = ["js/jquery/jquery.min",
	"js/jquery.tab",
	"js/data/citys",
	"js/selector",
	"js/common"
] >
<@res.js url = js />
<script type="text/javascript">
	
	$(document).ready(function(){
		
		//10秒倒计时
		timeEnd(9, "#remain_time", function(){
			location.href="${base}/index.htm";
		});
		
	});
	
</script>
</html>
