<#ftl strip_whitespace=true>
<#-- 
jsurl 格式化js的url加入版本号，用list形式可一次可以传入多个
-->
<#macro js  url=[]>
<script type="text/javascript">
	var _BASE = "${base}";
</script>

<#list url as js><script type="text/javascript" src="${resRoot}/${js}${minSuffix}.js" ></script></#list>
</#macro>
<#--
cssurl 格式化css的url加入版本号，用list形式可一次可以传入多个
-->
<#macro css url=[]>
<link rel="shortcut icon" href="${resRoot}/images/icon.png">

<#list url as css><link rel="stylesheet" type="text/css" href="${resRoot}/${css}${minSuffix}.css" /></#list>
</#macro>
