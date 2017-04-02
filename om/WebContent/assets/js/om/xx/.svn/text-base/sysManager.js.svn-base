$(document).ready(
		function() {

			$("#validate").validate(
					{
						ignore : null,
						ignore : 'input[type="hidden"]',
						errorPlacement : function(error, element) {
							wrap = element.parent();
							wrap1 = wrap.parent();
							if (wrap1.hasClass('checkbox')) {
								error.insertAfter(wrap1);
							} else {
								if (element.attr('type') == 'file') {
									error.insertAfter(element.next());
								} else {
									error.insertAfter(element);
								}
							}
						},
						errorClass : 'help-block',
						rules : {
							name : {
								required : true,
								rangelength : [ 1, 20 ]
							},
							account : {
								required : true,
								rangelength : [ 1, 20 ]
							},
							password : {
								required : true,
								rangelength : [ 6, 20 ]
							},
							mobile : {
								required : true,
								rangelength : [ 1, 20 ]
							},
							email : {
								required : true,
								email: true
							}
						},
						messages : {
							name : {
								required : "请输入姓名！",
								rangelength : "姓名长度在1--20之间！"
							},
							age : {
								required : "请输入年龄！",
								number : "请输入数字！",
								range : "年龄在1--200岁之间！"
							}
						},
						highlight : function(element) {
							if ($(element).offsetParent().parent().hasClass(
									'form-group')) {
								$(element).offsetParent().parent().removeClass(
										'has-success').addClass('has-error');
							} else {
								if ($(element).attr('type') == 'file') {
									$(element).parent().parent().removeClass(
											'has-success')
											.addClass('has-error');
								}
								$(element).offsetParent().parent().parent()
										.parent().removeClass('has-success')
										.addClass('has-error');

							}
						},
						unhighlight : function(element, errorClass) {
							if ($(element).offsetParent().parent().hasClass(
									'form-group')) {
								$(element).offsetParent().parent().removeClass(
										'has-error').addClass('has-success');
								$(element.form).find(
										"label[for=" + element.id + "]")
										.removeClass(errorClass);
							} else if ($(element).offsetParent().parent()
									.hasClass('checkbox')) {
								$(element).offsetParent().parent().parent()
										.parent().removeClass('has-error')
										.addClass('has-success');
								$(element.form).find(
										"label[for=" + element.id + "]")
										.removeClass(errorClass);
							} else if ($(element).next().hasClass(
									'bootstrap-filestyle')) {
								$(element).parent().parent().removeClass(
										'has-error').addClass('has-success');
							} else {
								$(element).offsetParent().parent().parent()
										.removeClass('has-error').addClass(
												'has-success');
							}
						}
					});

		});
