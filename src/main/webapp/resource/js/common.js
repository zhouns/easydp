$(document).ready(function() {
	
	$.validator.setDefaults({
		highlight : function(element) {
			$(element).closest(".form-group").removeClass("has-success").addClass("has-error");
		},
		success : function(element) {
			$(element).closest(".form-group").removeClass("has-error").addClass("has-success");
		},
		errorPlacement: function (error, element) {
			if ($(element).closest(".input-group").length > 0) {
				error.insertAfter(element.closest(".input-group"));
			} else {
				error.insertAfter(element);
			}
		},
		ignore:".ignore"
	});
	
	// 表格全选
	$('.table').on('click', 'th input:checkbox' , function(){
		var that = this;
		$(this).closest('.table').find('tr > td:first-child input:checkbox')
		.each(function(){
			this.checked = that.checked;
			var $tr = $(this).closest('tr');
			if (this.checked && !$tr.hasClass('selected')) {
				$tr.addClass('selected');
			} else if (!this.checked) {
				$tr.removeClass('selected');
			}
		});
	});
	
	// 表格单选
	$('.table').on('click', 'td input:checkbox' , function() {
		var $tr = $(this).closest('tr');
		if (this.checked && !$tr.hasClass('selected')) {
			$tr.addClass('selected');
		} else if (!this.checked){
			$tr.removeClass('selected');
		}
	});
	
	// 清除缓存
	$('.modal').on('hidden.bs.modal', function(e) {
		$(this).removeData('bs.modal');
	});
	
});