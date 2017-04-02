$(function() {
	// 初始化
	$(document).on("pageInit", "#center", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。

		// 如果用户已经登录，则跳转到用户中心。
		var loginToken = localStorage.getItem("LOGIN_TOKEN");
		if (loginToken) {
			$.router.load('goods.html', true);
		} else {

		}
	});
	var customerId = $.requestURL("id");
	var nickname = "";
	var sex = "";
	var path = "";
	$(document).ready(function() {
		if (customerId != "") {
			$('#loginNo').hide();
			$('#loginYes').show();
			$.omAjax({
				type : "post",
				url : "customerProfile.do",
				data : "id=" + customerId,
				success : function(data) {
					nickname = data.cData.nickname;
					sex = data.cData.sex;
					path = data.cData.headimg;
					$("#center-nickname").text(nickname);
					$("#center-header").attr("src", path);
				}
			});
		}
	});
	$(document).on(
			"click",
			"#om-profile",
			function() {
				if (customerId != "") {
					window.location = 'profile.html?nickname=' + nickname
							+ '&sex=' + sex + '&path=' + path + '&id='
							+ customerId, true;
				}
			});
});