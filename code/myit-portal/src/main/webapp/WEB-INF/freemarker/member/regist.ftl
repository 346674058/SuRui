<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员注册-${productName}${version}</title>
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
		    <label title="会员注册" class="left strength">会员注册</label>
		</div>
		
		<form id="regist-form">
		<table class="shoppin-cart banner registCon">
			<tr class="item">
				<td style="width:120px;" class="text-right">账户</td>
				<td class="text-left"><input type="text" id="memberNo" name="memberNo" class="input-text"><label class="must">*</label><label></label></td>
			</tr>
			<tr class="item">
				<td class="text-right">密码</td>
				<td class="text-left"><input id="password" name="password" type="password" class="input-text"><label class="must">*</label><label></label></td>
			</tr>
			<tr class="item">
				<td class="text-right">联系电话</td>
				<td class="text-left"><input id="mobile" name="mobile" type="text" class="input-text mobile"><label></label><label></label></td>
			</tr>
			<tr class="item">
				<td class="text-right">昵称</td>
				<td class="text-left"><input id="nick" name="nick" type="text" class="input-text nameForamt"><label></label><label></label></td>
			</tr>
			<tr class="item">
				<td class="text-right">出生日期</td>
				<td class="text-left"><input id="birthday" name="birthday" type="text" class="input-text"><label class="info">填写此信息可能有意外惊喜哦。</label>
			</tr>
			<tr class="item">
				<td class="text-right">Email</td>
				<td class="text-left"><input id="email" name="email" type="text" class="input-text"><label></label><label></label><label class="info">找回密码时，需要用到此信息。</label></td>
			</tr>
			<tr class="item">
				<td class="text-right">联系地址</td>
				<td class="text-left">
					<input id="cityId" name="cityId" type="hidden" value="0102">
					<input id="city" name="city" type="text" class="input-text" value="南京">
			    	<!--城市选择器-->
			    	
			    	<input id="districtId" name="districtId" type="hidden" value="0102001">
			    	<input id="district" type="text" class="input-text" value="玄武区">
			    	<!--区域选择器-->
		    		<div class="localityBox" id="localityBox">
						<br>
						<ol id="localityBoxList">
							<li class="on">商业区</li>
							<li>行政区</li>
						</ol>
						<div class="ciDetail" id="ciDetail1">
							<ul id="ciDetailList1">
						      	<li class="on">ABCDEF</li>
						         	<li>GHJKLM</li>
						        	<li>NPQRS</li>
						        	<li>TWXYZ</li>
						   	</ul>
						   	<div id="cArea_0" style="display: block;" class="locality">
						   		<a name="010104" title="东直门/簋街" href="javascript:void(0);">东直门/簋街</a><a name="010185" title="北大/清华/学院路" href="javascript:void(0);">北大/清华/学院路</a><a name="010186" title="安贞" href="javascript:void(0);">安贞</a></div>
						   	<div id="cArea_1" class="locality">
						   		<a name="010101" title="国贸CBD" href="javascript:void(0);">国贸CBD</a><a name="010179" title="丽泽商务区" href="javascript:void(0);">丽泽商务区</a><a name="010180" title="金源燕莎MALL" href="javascript:void(0);">金源燕莎MALL</a><a name="010182" title="航天桥/首都师范大学" href="javascript:void(0);">航天桥/首都师范大学</a></div>
					    	<div id="cArea_2" class="locality">
					    		<a name="010107" title="首都国际机场1/2号航站楼" href="javascript:void(0);">首都国际机场1/2号航站楼</a><a name="010184" title="上地工业园区" href="javascript:void(0);">上地工业园区</a></div>
					    	<div id="cArea_3" class="locality">
					    		<a name="010102" title="燕莎/农展馆" href="javascript:void(0);">燕莎/农展馆</a><a name="010160" title="新国展" href="javascript:void(0);">新国展</a><a name="010166" title="天桥" href="javascript:void(0);">天桥</a><a name="010181" title="五棵松体育馆" href="javascript:void(0);">五棵松体育馆</a><a name="010187" title="总部基地" href="javascript:void(0);">总部基地</a></div>
						</div>
						<div class="ciDetail hidden" id="ciDetail2">
							<div id="dArea" class="locality on">
								<a name="0001" title="西城区" href="javascript:void(0);">西城区</a><a name="0030" title="平谷区" href="javascript:void(0);">平谷区</a><a name="0031" title="门头沟区" href="javascript:void(0);">门头沟区</a><a name="0032" title="房山区" href="javascript:void(0);">房山区</a><a name="0033" title="大兴区" href="javascript:void(0);">大兴区</a></div>
						</div>
					</div>
				    <input id="address" name="address" type="text" class="input-text" value="动漫11栋104室" style="width:250px;"><label class="must">*</label>
				    <input id="saveAddress" type="checkbox" value="1" style="margin-left: 5px;">&nbsp;保存到常用地址
				    
				    <br><label class="valid-error">请填写完整的联系地址</label>
			    </td>
			</tr>			
		</table>
		</from>
		
		<!-- 工具栏 -->		
		<div class="toolbarCon mt10" style="height:auto">
			<div class=" center">
				<input id="protocol" type="checkbox" value="1" style="margin-left: 5px;">&nbsp;已阅读并同意<a href="#" class="active">会员协议</a>
				<label class="valid-error">请阅读并同意会员协议</label>
				
				<div class="mt10 hrl"></div>
				<div class="left" style="text-align: right; width: 45%;">
					<a id="submit-btn" class="btn highlight" href="javascript:void(0);">注册</a>
				</div>
				<div class="right" style="text-align: left; width: 55%; margin-top: 10px;">
					已经有账户？立即[<a href="${base}/member/login.htm" class="active">登录</a>]
				</div>
	    	</div>
		</div>
	</div>

	<div id="dialog-loading"><div class="loading left"></div><div id="msg">注册中...</div></div>
	
	<div id="dialog">注册失败，原因码：900001</div>

	<#-- 页脚 -->
	<#include "/common/footer.ftl">
</body>
	
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["js/jquery/jquery.min",
		"js/jquery/jquery-ui-1.9.2.custom.min",
		
		"js/jquery/jquery.validate",
		"js/custom/validate",
		
		"js/jquery.tab",
		"js/jquery.tabChg",
		"js/data/citys",
		"js/selector",
		"js/common",
		
		"js/custom/regist"
	] >
	<@res.js url = js />
</body>
</html>
