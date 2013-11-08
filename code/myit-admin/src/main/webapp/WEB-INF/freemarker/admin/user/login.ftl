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
		'stylesheets/jquery-ui-1.9.2.custom'
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
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right"></ul>
                <a href="javascript:void(0);" class="brand"><span class="first"></span> <span class="second">${title}</span></a>
        </div>
    </div>
    
    <div class="row-fluid">
	    <div class="dialog">
	        <div class="block">
	            <p class="block-heading">登录</p>
	            <div class="block-body">
	                <form id="login-form">
	                    <label>用户名</label><label></label>
	                    <input id="userName" name="userName" type="text" class="span12">
	                    <label>密　码</label><label></label>
	                    <input id="password" name="password" type="password" class="span12">
	                    <button  id="submit-btn" class="btn btn-primary pull-right">登录</button >
	                    <label class="remember-me"><input id="remember-me" type="checkbox">&nbsp;记住用户名</label>
	                    <div class="clearfix"></div>
	                </form>
	            </div>
	        </div>
	        <p class="pull-right" style=""><a href="reset-password.html">忘记密码？</a></p>
	        <p></p>
	    </div>
	    
	</div>
	<footer>
	    <hr>
	    <div style="text-align:center;padding-top:30px;">
	    	Design by <a href="${companyUrl}" target="_blank">${company}</a>&nbsp;|&nbsp;
	    	&copy; 2013-2020 <a href="${companyUrl}" target="_blank">${company}</a>
	    </div>
	</footer>

	<div id="dialog-loading"><div class="loading"><label id="msg">登录中...</label></div></div>
	
	<div id="dialog">登录失败，原因码：900001</div>

  </body>
	<#-- 最后引入js，防止阻塞页面加载 -->
	<#assign js = ["lib/jquery-1.7.2.min",
		"js/jquery/jquery-ui-1.9.2.custom.min",
		"js/jquery/jquery.validate",
		
		"js/common"
		"js/custom/login"
	] >
	<@res.js url = js />
</html>


