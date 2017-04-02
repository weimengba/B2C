$(function() {
	'use strict';

	// Login初始化
	$(document).on("pageInit", "#login", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。

		//如果用户已经登录，则跳转到用户中心。
		var loginToken = localStorage.getItem("LOGIN_TOKEN");
		if(loginToken) {
			$.router.load('goods.html', true);
		} else {

		}
	});

	$(document).on("click", "#om-login-button", function(e) {
		alert();
		$.ajax({
			type: "post",
			url: $.GlobalVar.serverURL + "login.do",
			data: $("#om-login-form").serialize(),
			async: true,
			success: function(res) {
				if(res.success){
					localStorage.setItem("LOGIN_TOKEN", res.data.token);
					$.router.load('goods.html', true);
				}else{
					alert("登录失败，请重试！");
				}				
			},
			error: function(res) {
				alert("出错了！");
			}
		});

	});
});