<#-- 首页分类推荐 -->
<div class="tabTitle">
	<h1>推荐美食</h1>
	<ul class="tabNav">
		<#list categories as category>
		<li>${category.title}</li>
		</#list>
	</ul>
</div>

<div class="tabCon">
<#list categories as category>
	<#if category_index == 0 >
	<div class="tab-item">
	<#else>
	<div class="tab-item hidden">
	</#if>
	<#list category.groups as group>
		<div class="sub-item">
			<#list group as commodity>
				<#if commodity_index == 0 >
				<img src="${resRoot}/${commodity.img}" />
				<#else>
				<img src="${resRoot}/${commodity.img}" class="hidden" />
				</#if>
			</#list>
			
			<#list group as commodity>
				<#if commodity_index == 0 >
				<div class="commo on"><a href="${base}/commodity/shoppingCart.htm?comCode=${commodity.comCode}" target="_blank">${commodity.name}</a>
					<div class="right"><label>${commodity.price}</label>
						<#if commodity.promotionPrice><label class="active">优惠${commodity.promotionPrice}</label></#if></div>
				</div>
				<#else>
				<div class="commo"><a href="${base}/commodity/shoppingCart.htm?comCode=${commodity.comCode}" target="_blank">${commodity.name}</a>
					<div class="right"><label>${commodity.price}</label>
						<#if commodity.promotionPrice><label class="active">优惠${commodity.promotionPrice}</label></#if></div>
				</div>
				</#if>
			</#list>
		</div>
	</#list>
		
	</div>
</#list>
</div>