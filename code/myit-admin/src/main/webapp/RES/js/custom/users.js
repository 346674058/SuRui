/*
 * ajax 查询
 */
function query() {
	// 加载效果
	$("#user-list tbody").html('<div class="loading">数据加载中...</div>');

	// ajax查询

	$.ajax({
		url : _BASE + "/user/list.htm",
		type : 'POST',
		data : $("#query-form").serialize(),
		dataType : 'json',
		success : function(data) {
			if (!data) {
				$("#user-list tbody")
						.html('<div class="panel">系统忙，请稍后再试</div>');
				return;
			}

			if (data.retCode != "0") {
				$("#user-list tbody")
						.html('<div class="panel">系统忙，请稍后再试</div>');
				return;
			}

			var userHtml = getUserHtml(data.users);
			$("#user-list tbody").html(userHtml);
			
			//重构分页
			showPagenation(/*data.pageNo*/17, data.pageCount, $("#pagnationCon"));
		},
		error : function() {
			$("#user-list tbody").html('<div class="panel">系统忙，请稍后再试</div>');
		}
	});
}

/**
 * 解析生存列表行
 * 
 * @param users
 */
function getUserHtml(users) {
	var userTpl = $("#user-item tbody").html();

	var userHtml = new Array();

	for ( var i = 0; i < users.length; i++) {
		var user = users[i];

		userHtml.push(template(userTpl, {
			"userName" : user.userName,
			"realName" : user.realName
		}));

	}

	return userHtml.toString();
}

$(function() {

	// 查询
	$("#query-btn").click(query);
});