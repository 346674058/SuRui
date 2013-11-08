$(document).ready(function() {

	// 美食分类选择器
	tagTrigger({
		id : 'catagory',
		showEvent : 'click',
		css : {
			width : '144px'
		},
		callback : function(o) {
			$("#catagory").val(o.text());
		}
	});

	//ajax加载广告图片
	loadCategoryRecom();

	//ajax加载分类推荐
	loadAdvImg();

	// location选择
	locality("#location", ".localityBox", function(o) {
		// TODO
	});

	// 查询
	$("#btn_search").click(function() {
		query_form.submit();

	});

});

//加载广告图片
function loadAdvImg(){
	var url=_BASE +"/index/getAdverImgs.htm";
	
	var advImgHtml=$.ajax({url:url,async:false});
	$("#adv_flash").html(advImgHtml.responseText);
	
	// 滚动广告
	if (_SILDE) {
		_SILDE.start('.slide', 'img');
	}
}

//加载分类推荐
function loadCategoryRecom(){
	var url=_BASE +"/index/getCategotyRecoms.htm";
	
	var categoryHtml=$.ajax({url:url,async:false});
	$("#categoryRecom").html(categoryHtml.responseText);
	
	//页签切换
	$(".tab").tab({
		event : "mouseover", // 触发事件，mouseover | click
		nav : ".tabNav", // tab的ID
		cls : "on", // 选中时的css
		con : ".tabCon", // 内容id的包围
		css : {
			width : '958px'
		}
	});
}