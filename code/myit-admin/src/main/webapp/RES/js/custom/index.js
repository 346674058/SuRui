$(function() {
	// 菜单加载
	$("#_MenuCon").load(_BASE + "/myMenus.htm");
	
	$("#_MenuCon ul li a").live("click",function(){
		
		$("#_MainCon").load(_BASE +"/user/users.htm");
		
		return false;
	});

});