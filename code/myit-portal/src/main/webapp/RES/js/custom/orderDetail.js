$(document).ready(function() {

	// 时间范围
	$("#timeBegin").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 2,
		minDate : new Date(),
		dateFormat : 'yy-mm-dd',
		onClose : function(selectedDate) {
			$("#timeEnd").datepicker("option", "minDate", selectedDate);
			$("#timeEnd").focus();
		}
	});

	$("#timeEnd").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 2,
		dateFormat : 'yy-mm-dd',
		onClose : function(selectedDate) {
			$("#timeBegin").datepicker("option", "maxDate", selectedDate);
		}
	});

});