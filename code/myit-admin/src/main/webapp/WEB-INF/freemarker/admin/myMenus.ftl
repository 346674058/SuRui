<#if moduals?exists>
	<#list moduals as modual>
	<a href="#MODUAL_${modual.id}" class="nav-header" data-toggle="collapse"><#if modual.icon?exists><i class="icon-${modual.icon}"></i></#if>${modual.name}<#if modual.extInfo?exists>${modual.extInfo}</#if></a>
	
	<#if modual_index == 0>
	<ul id="MODUAL_${modual.id}" class="nav nav-list collapse in">
	<#else>
	<ul id="MODUAL_${modual.id}" class="nav nav-list collapse">
	</#if>
		<#list modual.menus as menu>
	    <li><a href="javascript:void(0);" link="${base}/user/users.htm"><#if menu.icon?exists><i class="icon-${menu.icon}"></i></#if>${menu.name}</a></li>
	    </#list>
	    
	</ul>
	</#list>
<#else>
	<div class="loading">菜单加载中...</div>
</#if>