var template = function(source, data) {
    var regexp = /{(.*?)}/g;
    return source.replace(regexp, function(match, subMatch, index, s) {
                return data[subMatch] || "";
    });
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

	$('.demo-cancel-click').click(function() {
		return false;
	});
	
	
	//页头时间问候
	$("#timePeri").text(getTimePeriText());
	
	try{
		$("[rel=tooltip]").tooltip();
		
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
	
})();