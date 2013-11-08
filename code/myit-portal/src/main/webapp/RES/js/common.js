
var catelog_expand = function(item){
  var _tmp = $("#category_ex");
  _tmp.html(item.html());
  _tmp.css("top",item.offset().top);
  _tmp.addClass("catalog_item_expand");
  _tmp.children().eq(1).addClass("catalog_name_expand");
  _tmp.children().eq(0).addClass("expand_expand");
  _tmp.children().eq(2).addClass("catalog_sub_expand");
  _tmp.css("height",item.css("height"));
  _tmp.css("line-height",item.css("line-height"));
  _tmp.show();
};

var catelog_mouseover = function(){
	$(".menu_catalog_arrow").text("-");
	
	
  $("div[class='catalog left']").show();
  
  if($(this).attr("class") == "catalog_item"){
      catelog_expand($(this));
  }
};

var category_ex_mouseleave = function(){
	$(".menu_catalog_arrow").text("+");
	
  $("div[class='catalog left']").hide();
  $("#category_ex").hide();
};

var template = function(source, data) {
    var regexp = /{(.*?)}/g;
    return source.replace(regexp, function(match, subMatch, index, s) {
                return data[subMatch] || "";
    });
};
   
var isword = function(word){
    return /([a-z0-9\u4E00-\u9FA5])+$/i.test(word);
};

var getquery = function(name) {
   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
   var r = window.location.search.substr(1).match(reg);
   if (r!=null) return r[2]; 
   return null;
};
 
var search_keyword = function(word){
    if(word === "" || !isword(word)){
        alert("请填写有效的关键词");
    } else {
       //TODO
    }
};

var keydown_txt_searchbar_word = function(event){
    if(event.keyCode == 13){
        search_keyword($.trim(this.txt_searchbar_word.val()));
    }
};

var click_btn_search_word = function(){
    search_keyword($.trim(this.txt_searchbar_word.val()));
};

var clk_txt_searchbar_word = function(){
    if(this.txt_searchbar_word.val() == "度假山庄"){
        this.txt_searchbar_word.val("");
    }
};

var blur_txt_searchbar_word = function(){
    if(this.txt_searchbar_word.val() == ""){
        var keyword = "小吃零食";
        if(keyword !== ""){
            this.txt_searchbar_word.val(keyword);
        } else {
            this.txt_searchbar_word.val("度假山庄");
        }
    }
};

//倒计时
var remainSecond = function(second, con){
    var remain_second = second;
    setInterval(function(){
        if(remain_second == 0){
            window.location.href = $("div[class='menu center']").find("a").eq(1).attr("href");
        }
        else{
            $("#" + con).html(remain_second + "秒");
            remain_second--;
        }
    },1000);
};

var loading=function(msg){
	$('#dialog-loading').find("#msg").text(msg);
	$('#dialog-loading').dialog('open').css({
		'min-height' : '37px'
	}).prev().hide();
};

var closeLoading=function(){
	$('#dialog-loading').dialog('close');
};

var dialog=function(title,msg,callback){
	
	if (callback) {
		$('#dialog').prev().find(".ui-dialog-titlebar-close").hide();
		$('#dialog').dialog('option', 'buttons', { "确定": callback});
	}else{
		$(".ui-dialog-titlebar-close").show();
	}
	
	$('#dialog').text(msg);
	$('#dialog').dialog('option','title', title).dialog('open');
};

var closeDialog=function(){
	$('#dialog').dialog('close');
};

var setTop = function(){
if (top.location != self.location) {  
	  
	top.location=self.location;  
	  
	}  
};

//城市区域弹出层
//options:{id: '', event: '', css: null, callback: null}
function tagTrigger(options) {
	var o=$("#"+options.id).attr("readonly","readonly");
	var tag=o.next(".tagCon");

	tag.css(options.css);
	
	//定位弹出层位置
	var inputPos = o.position();
	if(inputPos){
		var o_left = inputPos.left + 'px';
		var o_top = inputPos.top + o.outerHeight() + 1 + 'px';
		tag.css({position:'absolute', left: o_left, top: o_top});
	}

	//标签展示的触发事件
	if(options.showEvent){
		o[options.showEvent](function(e) {
			e.stopPropagation();
			tag.show();
		});
	}
	
	//选择后赋值并关闭
	o.next().find("a").click(function(e) {
		e.stopPropagation();
		tag.hide();
		
		//自定义事件
		if(options.callback){
			options.callback($(this));
		}
	});
	
	//标签隐藏的触发事件
	if(options.hideEvent){
		tag[options.hideEvent](function(e) {
			e.stopPropagation();
			tag.hide();
		});
	}
	
	//点击空白处标签隐藏
	$("html").click(function(e) {
		e.stopPropagation();

		tag.hide();
	});
}

//城市区域弹出层
function locality(input, con, callback) {
	var o=$(input);
	var v = o.val();
	
	//定位弹出层位置
	var inputPos = o.position();	
	if(inputPos){
		var o_left = inputPos.left + 'px';	
		var o_top = inputPos.top + o.outerHeight() + 1 + 'px';
		$(con).css({position:'absolute', left: o_left, top: o_top});
	}
	
	$(input).click(function(e) {
		e.stopPropagation();
		
		$(this).val("");
		$(con).show();
	});
	
	$("#district").tabChg({
		tablist : "#localityBoxList",
		conClass : ".ciDetail",
		usevent : "click"
	});
	
	$("#ciDetail1").tabChg({
		tablist : "#ciDetailList1",
		conClass : ".locality",
		usevent : "click"
	});
	
	$("#ciDetail2").tabChg({
		tablist : "#ciDetailList2",
		conClass : ".locality",
		usevent : "click"
	}); 	

	$(con).find("a").click(function(e) {
		e.stopPropagation();
		
		var t = $(this).html();
		$(input).val(t);
		$(con).hide();
		
		//自定义事件
		if(callback){
			callback(this.name);
		}
	});
	
	//点击空白处对话框隐藏
	$("html").click(function(e) {
		e.stopPropagation();
		
		if ($(input).val() == "") {
			$(input).val(v);
		}
		$(con).hide();
	});
} 

function getTimePeri(){  
        var h=new Date().getHours();
        
        var retCode=2;	//默认为上午
        
        if(h>14 && h<=18 ){
        	retCode = 4;	//下午
        } else if (h>18 && h<=22 ) {
        	retCode = 5;	//晚上
        } else if (h>22 || h<=5 ) {
        	retCode = 6;	//深夜
        } else if (h>5 && h<=9) {
        	retCode = 1;	//早上
        } else if (h>9 && h<=11 ) {
        	retCode = 2;	//上午
        } else if (h>9 && h<=11 ) {
        	retCode = 3;	//中午
        }
        
        return retCode;
} 

function getTimePeriText(){
	var text = ["早上","上午","中午","下午","晚上","深夜"];
	
	var peri = getTimePeri()-1;
	return text[peri];
}

function timeEnd(diff, con, callback){

	window.setInterval(function(){
		if(diff < 0){
			
			//回调函数
			if(callback) {
				callback();
			}
		
			return ;
		}
	
		var date=getTimeEnd(diff);
		
		var text="";
		if(date[0]>0){
			 text +=date[0]+"天";
		}
		if(date[1]>0){
			 text +=date[1]+"小时";
		}
		if(date[2]>0){
			 text +=date[2]+"分";
		}
		if(date[3]=="00"){
			date[3] ="0";
		}
		
		$(con).html(text+date[3]+"秒");
	
		diff--;
		
	}, 1000);
} 

function getTimeEnd(diff){
	var day=0,
		hour=0,
		minute=0,
		second=0;//时间默认值
				
		if(diff > 0){
			day = Math.floor(diff / (60 * 60 * 24));
			hour = Math.floor(diff / (60 * 60)) - (day * 24);
			minute = Math.floor(diff / 60) - (day * 24 * 60) - (hour * 60);
			second = Math.floor(diff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
		}
		
		if (minute <= 9) minute = '0' + minute;
		if (second <= 9) second = '0' + second;
		
		return new Array(day, hour, minute, second);
}



(function(){
	//检查浏览器
	var canFix = /msie 6/i.test(navigator.userAgent) || (/msie 7/i.test(navigator.userAgent) && document.compatMode == "BackCompat") ? false:true;
	if(!canFix){
			$("#sidebar").attr("class", "sidebar_ie6");
	}
	
	try{
		// 城市插件
		new Vcity.CitySelector({
			input : 'city',
			data : _CITYS,
			blankTxt : '请选择城市',
			firstTbName : '热门城市',
			firstTbSize : 12,
			winSize : 15,
			callback : function(v) {
				$("#cityId").val(v.split("|")[1]);
	
			}
		});
	}catch(e){}
	
	//设置浮动栏的交互
	$("a[class^='sidebar_icon_word']").each(function(){
	    $(this).bind("mouseover",function(){
	        $(this).find("div[class='sidebar_word']").css("color","white");
	    });
	    $(this).bind("mouseout",function(){
	        $(this).find("div[class='sidebar_word']").css("color","#999999");
	    });
	});
	  
  	$("div[class='menu_catalog left']").bind("mouseover",catelog_mouseover);
  	$("div[class='catalog_item_nosub']").bind("mouseover",catelog_mouseover); 
	$("div[class='catalog_item']").bind("mouseover",catelog_mouseover); 
	$("#category_ex").bind("mouseleave",category_ex_mouseleave);
	$("div[class='menu_catalog left']").bind("mouseleave",category_ex_mouseleave);
	$("div[class='catalog_item_nosub']").bind("mouseleave",category_ex_mouseleave);

	//页头时间问候
	$("#timePeri").text(getTimePeriText());
	
	try{
		// dialog
		$("#dialog").dialog({
			autoOpen : false,
			modal : true,
			resizable : false,
			title : '提示'
		});
	
		// loading
		$("#dialog-loading").dialog({
			autoOpen : false,
			modal : true,
			resizable : false,
			draggable : false,
			closeOnEscape : false
		});
	}catch(e){}
	
	//ga.js 数据采集
	  var gaCfg = new Array();
	  gaCfg['path'] = "index.htm";
	  gaCfg['name'] = "美食之家首页";
  
  //document.write('<scr' + 'ipt type="text/javascript" src="script/ui.js"></scr' + 'ipt>');
	
})();