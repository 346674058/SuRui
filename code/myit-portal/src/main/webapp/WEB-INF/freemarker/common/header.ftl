<!-- 页头 --> 
<div class="title_bar">
    <div class="bwidth center">
    	<div class="left">
    		<#if Session["loginMember"]?exists>
    			<#assign member=Session["loginMember"] >
				<label id="timePeri">您好</label>，<#if member.nick?exists>${member.nick}<#else>${member.memberNo}</#if><#if !member.mobile?exists>，您还没有绑定手机，请[<a href="../member/bandMobile.html" target="_self" class="active">绑定手机</a>]</#if>，[<a href="${base}/member/logout.htm" class="active">退出</a>]
    		<#else>
	    		<label id="timePeri">您好</label>，请[<a href="${base}/member/login.htm" class="active">登录</a>]，没有账户？[<a href="${base}/member/regist.htm" class="active">注册</a>]
    		</#if>
    	
    	</div>
    	
    	<div class="right">
    		<a href="${base}/order/list.htm" target="_self" >我的订单</a>
    		<a href="${base}/navigation/help.htm" target="_self" >帮助中心</a>
    	</div>
    </div>
</div>

<div class="headerCon">
    <div class="header center">
    	<div class="left">
	    	<a href="${base}" target="_self"><img class="logo left" /></a>
	    	<div style="font-size:18px;margin-top:20px;" class="left">[<a id="city" href="javascript:void(0);" class="active">南京</a>]</div>
    	</div>
        
        <div class="searchbar left">
            <div class="searchbar_word left">
                <div class="searchbar_icon left"></div>
                <input type="text" id="txt_searchbar_word" class="searchbar_txt left"></input>
            </div>
            <input type="button" id="btn_search_word" class="searchbar_button left" value="搜索"/>
            <div class="searchbar_suggest left">
                <span>猜你感兴趣:</span>
                <a href="javascript:void(0);" title="商务套餐" target="_self">商务套餐</a>
                <a href="javascript:void(0);" title="盖浇饭" target="_self">盖浇饭</a>
                <a href="javascript:void(0);" title="简餐" target="_self">简餐</a>
            </div>
        </div>
    </div>
</div>

<!-- 频道栏 --> 
<div class="menu_left"></div>
<div class="menu_right"></div>
<div class="menu center">
	<#-- 暂时屏蔽品类导航
	<div class="menu_catalog left">
		<a class="left" title="所有产品分类" href="#">所有产品分类</a><div class="menu_catalog_arrow right">+</div>
	</div>
	-->
	
	<a href="${base}/index.htm" title="首页" target="_self">首页</a>
	<a href="${base}/recomodity/list.htm" title="外卖外送" target="_self" class="on">外卖外送</a>
	<a href="#" title="美食广场" target="_self">美食广场</a>
</div>

<!-- 频道快速入口 -->
<div class="container center">
	<div class="catalog left">
	    <div class="catalog_item_nosub">
	        <div class="catalog_name_nosub"><a title="游戏" target="_self" href="#">游戏</a></div>
	    </div>
	    <div class="catalog_item">
	        <div class="catalog_expand right">&gt;</div>
	        <div class="catalog_name"><a title="购物" target="_self" href="#">购物</a></div>
	        <div class="catalog_sub">
	            <a href="#" title="生活用品" target="_self">生活用品</a>
	            <a href="#" title="家用电器" target="_self">家用电器</a>
	            <a href="#" title="食品饮料" target="_self">食品饮料</a>
	        </div>
	    </div>
	    <div class="catalog_item">
	        <div class="catalog_expand right">&gt;</div>
	        <div class="catalog_name"><a title="生活服务" target="_self" href="#">生活服务</a></div>
	        <div class="catalog_sub">
	            <a href="#" title="租车" target="_self">租车</a>
	            <a href="#" title="婚庆摄影" target="_self">婚庆摄影</a>
	            <a href="#" title="其他生活服务" target="_self">其他生活服务</a>
	        </div>
	    </div>
	    <div class="catalog_item">
	        <div class="catalog_expand right">&gt;</div>
	        <div class="catalog_name"><a title="旅游及票务" target="_self" href="#">旅游及票务</a></div>
	        <div class="catalog_sub">
	            <a href="#" title="旅游" target="_self">旅游</a>
	            <a href="#" title="宾馆" target="_self">宾馆</a>
	        </div>
	    </div>
	    
	    <div class="catalog_item_nosub" style="border-top:1px dotted #D4D4D4;">
	        <div class="catalog_name_nosub"><a title="美容整形" target="_self" href="#">美容整形</a></div>
	    </div>
	    <div class="catalog_item" style="height:86px;line-height:86px;">
	        <div class="catalog_expand right">&gt;</div>
	        <div class="catalog_name"><a title="招商加盟" target="_self" href="#">招商加盟</a></div>
	        <div class="catalog_sub">
	            <a href="#" title="餐饮服务加盟" target="_self">餐饮服务加盟</a>
	            <a href="#" title="美容化妆加盟" target="_self">美容化妆加盟</a>
	            <a href="#" title="其他招商加盟" target="_self">其他招商加盟</a>
	        </div>
		</div>
	</div>
	
	<div id="category_ex" style="display:none;position:absolute;z-index:3000;background-color:white;"></div>
</div>