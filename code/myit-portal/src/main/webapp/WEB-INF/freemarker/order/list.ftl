<#-- 数据列表 -->
<#if orders?exists && (orders?size &gt; 0)>
<#list orders as order>
<table class="shoppin-cart banner mt10">
	<thead>
	<tr class="title" style="height:60px;">
		<th colspan="7">
			<div class="left order-btns">
				订单号<a class="active" href="orderDetail.html" target="_blank">${order.orderNo}</a>
				&nbsp;订单状态<label class="active">${order.status}</label>
				&nbsp;订单金额<label class="active" style="font-size:16px;">￥${order.total}</label>
			</div>
			<div class="right order-btns">
				<div class="left">您还有<label id="timer_201309190001" class="active">01小时</label>可以支付</div>
				<div class="right">
					<a class="pay_btn" href="javascript:void(0);">付款</a>|<a class="receive_btn" href="javascript:void(0);">已收货</a>
					|<a class="remark_btn" href="javascript:void(0);">点评</a>|<a class="cancel-btn" id="${order.orderNo}" href="javascript:void(0);">取消</a>
				</div>
			</div>
		</th>				
	</tr>
	</thead>
	
	<#list order.orderItems as orderItem>
	<#if orderItem_index == order.orderItems?size-1>
	<tr class="item last">
	<#else>
	<tr class="item">
	</#if>
		<td class="chk"></td>
		<td class="image"><a href="${base}/commodity/info.htm?comCode=${orderItem.commodity.comCode}" ><img src="${resRoot}/${orderItem.commodity.img}"></a></td>
		
		<td style="text-align:left;">
			<a href="#"><a href="${base}/commodity/info.htm?comCode=${orderItem.commodity.comCode}">${orderItem.commodity.name}</a></a>
		</td>
		
		<td style="text-align:right;">￥${orderItem.commodity.price}</td>
		<td></td>
		<td class="count">${orderItem.commodity.count}</td>
		<td class="price active">￥${orderItem.subTotal}</td>
	</tr>
	</#list>
</table>
</#list>

<#-- 分页 -->
<div class="ad_pagenation_area mt10"> <div class="pagenation right"></div> </div>
<#else>
<#-- 没有匹配的数据 -->
没有订单
</#if>

<script>
	var pageCount=${pageCount}, pageNo=${pageNo};
	
	//分页
	showPagenation(pageNo, pageCount, ".pagenation");
</script>