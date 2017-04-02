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

	/*获取验证码*/
	var isPhone = 1;
	$(document).on("click", "#om-register-getCode", function(e) {
		checkPhone(); //验证手机号码
		if(isPhone){
			resetCode(); //倒计时
		}else{
			$('#om-register-phone').focus();
		}
	});
	//验证手机号码
	function checkPhone(){
		var phone = $('#om-register-phone').val();
		var pattern = /^1[0-9]{10}$/;
		isPhone = 1;
		if(phone == '') {
			alert('请输入手机号码');
			isPhone = 0;
			return;
		}
		if(!pattern.test(phone)){
			alert('请输入正确的手机号码');
			isPhone = 0;
			return;
		}
	}
	//倒计时
	function resetCode(){
		$('#om-register-resetCode').show();
		$('#om-register-getCode').hide();
		$('#om-register-second').html('5');
		$('#om-register-resetCode').show();
		var second = 5;
		var timer = null;
		timer = setInterval(function(){
			second -= 1;
			if(second >0 ){
				$('#om-register-second').html(second);
			}else{
				clearInterval(timer);
				$('#om-register-getCode').show();
				$('#om-register-resetCode').hide();
			}
		},1000);
	}
});