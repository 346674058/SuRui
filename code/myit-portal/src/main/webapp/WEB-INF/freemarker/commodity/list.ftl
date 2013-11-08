<#-- 数据列表 -->
<#if commodities?exists && (commodities?size &gt; 0)>
<table class="commodity-list">
	<#list commodities as commodity>
	<#if commodity_index == commodities?size-1>
	<tr class="item last">
	<#else>
	<tr class="item">
	</#if>
		<td class="image"><a href="${base}/commodity/info.htm?comCode=${commodity.comCode}" ><img src="${resRoot}/${commodity.img}"></a></td>
		
		<td class="commodity-info">
			<div class="name"><a href="${base}/commodity/info.htm?comCode=${commodity.comCode}">${commodity.name}</a></div>
			<#if commodity.supplier?exists>
			<div class="supply-info">
				<label>商户</label>${commodity.supply.name}<br>
				<label>电话</label>${commodity.supply.telephone}<br>
				<label>地址</label>${commodity.supply.address}
			</div>
			</#if>
		</td>
		
		<td class="price">
			<#if commodity.promotionPrice?exists>
			<label class="promotion">优惠￥${commodity.promotionPrice}</label>
			</#if>
			<label class="cur-price">￥${commodity.price}</label>
		</td>
		
		<td class="button">
			<#if commodity.countRemain &gt; 0>
			<a href="${base}/commodity/shoppingCart.htm?comCode=${commodity.comCode}" class="btn highlight">预订</a>
			<#else>
			<label class="btn">订完</a>
			</#if>
		</td>
	</tr>
	</#list>
<table>
<#-- 列表分页 -->
<div class="ad_pagenation_area mt10"><div class="pagenation right"></div></div>
<#else>
<#-- 没有匹配的数据 -->
<div class="mt10">
	<div class="exception" id="dv_empty_ad">
  <div style="height:25px;line-height:25px;font-size:16px;font-weight:bold;color:#666666;">没有找到合适的信息！</div>
  <div style="height:80px;line-height:80px;margin-top:30px;">
      <div style="color:#c2c2c2;height:20px;line-height:20px;text-align:left;">建议您:</div>
      <div style="color:#696969;height:30px;line-height:30px;text-align:left;">
      	1.尝试从&nbsp;<label class="active">所有产品分类</label>&nbsp;中点击与您相关的分类,或直接搜索关键词;</div>
      <div style="color:#696969;height:30px;line-height:30px;text-align:left;">
      2.调整&nbsp;<label class="active">搜索条件</label>&nbsp;重新搜索。
  </div>
  </div>
</div>
</#if>

<script>
	var pageCount=${pageCount}, pageNo=${pageNo};
	
	$("#totalCount").text("${totalCount}");
	
	
	// 1小时倒计时
	timeEnd(3599, "#timer_201309190001");
	
	//分页
	showPagenation(pageNo, pageCount, ".pagenation");
</script>