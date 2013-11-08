<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    
    <#-- 引用资源宏文件 -->
	<#import "/common/res.ftl" as res>
	
	<#-- 引入css，不影响页面加载 -->
	<#assign css =['lib/bootstrap/css/bootstrap',
		'stylesheets/theme',
		'lib/font-awesome/css/font-awesome',
		'stylesheets/elements'
				]>
	<@res.css url =css />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <#-- 页头 -->
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="javascript:void(0);" class="hidden-phone visible-tablet visible-desktop" role="button">系统设置</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="javascript:void(0);" role="button" class="dropdown-toggle" data-toggle="dropdown">
                        	<#assign user=Session["loginUser"] >
                            <i class="icon-user"></i>&nbsp;<#if user.realName?exists>${user.realName}<#else>${user.userName}</#if>
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="javascript:void(0);">我的信息</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="javascript:void(0);">个人设置</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="${base}/user/logout.htm">退出</a></li>
                        </ul>
                    </li>
                    <li><a href="javascript:void(0);" class="hidden-phone visible-tablet visible-desktop" role="button">帮助</a></li>
                </ul>
                <a class="brand" href="javascript:void(0);"><span class="first"></span> <span class="second">${title}</span></a>
        </div>
    </div>
    
    <#-- 左侧菜单 -->
    <div id="_MenuCon" class="sidebar-nav">
    	<div class="loading">登录中...</div>
    </div>
    
	<#-- 右侧主页面 -->
    <div class="content">
        
        <#-- 汇总信息 -->
        <div class="header">
            <div class="stats">
			    <p class="stat"><span class="number">53</span>tickets</p>
			    <p class="stat"><span class="number">27</span>tasks</p>
			    <p class="stat"><span class="number">15</span>waiting</p>
			</div>

			<#-- 功能标题 -->
            <h1 class="page-title">Dashboard</h1>
        </div>
        
        <#-- 功能导航 -->
        <ul class="breadcrumb">
        	<li><a href="index.html">Home</a> <span class="divider">/</span></li>
        	<li class="active">Dashboard</li>
    	</ul>

		<#-- 功能操作区-->
        <div class="container-fluid">
            <div class="row-fluid">
            	<div id="_MainCon" class="row-fluid" style="min-height:455px;">
				</div>
                    
			    <#-- 页脚 -->
			     <footer>
	                <hr style="margin: 2em -2em;">
	
	                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
	                <p class="pull-right">Design by <a href="${companyUrl}" target="_blank">${company}</a></p>
	
	                <p>&copy; 2012 <a href="${companyUrl}" target="_blank">${company}</a></p>
	            </footer>
            </div>
        </div>
    </div>
    
  </body>
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["lib/jquery-1.7.2.min",
		
		"js/common",
		"js/custom/index"
	] >
	<@res.js url = js />
</html>


