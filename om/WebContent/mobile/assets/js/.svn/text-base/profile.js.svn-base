$(function() {
	// 初始化
	$(document).on("pageInit", "#profile", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。

		// 如果用户已经登录，则跳转到用户中心。
		var loginToken = localStorage.getItem("LOGIN_TOKEN");
		if (loginToken) {
			$.router.load('goods.html', true);
		} else {

		}
	});
	$(document).ready(
			function() {
				var sex = $.requestURL("sex");
				$("#on-profile-cid").val($.requestURL("id"));
				$("#profile-nickname").val($.requestURL("nickname"));
				if ($.requestURL("path") != "") {
					if ($.requestURL("fm") != "" && $.requestURL("gp") != "") {
						$("#profile-header").attr(
								'src',
								$.requestURL("path") + "&fm="
										+ $.requestURL("fm") + "&gp="
										+ $.requestURL("gp"));
					} else {
						$("#profile-header").attr('src', $.requestURL("path"));
					}
				}
				if (sex == 1) {
					$("#profile-sex-m").prop('checked', true);
				} else if (sex == 2) {
					$("#profile-sex-f").prop('checked', true);
				}
			});

	function getObjectURL(file) {
		var url = null;
		if (window.createObjectURL != undefined) { // basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) { // mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) { // webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	$('#uploadFile')
			.live(
					'change',
					function() {
						// 判断是否有选择上传文件
						var imgPath = $("#uploadFile").val();
						var strExtension = imgPath.substr(imgPath
								.lastIndexOf('.') + 1);
						if (strExtension != 'jpg' && strExtension != 'gif'
								&& strExtension != 'png'
								&& strExtension != 'bmp') {
							alert("请选择图片文件");
							return;
						}
						$("#profile-uploadFile-a").hide();
						$("#om-profile-hu").show();
						var objUrl = getObjectURL(this.files[0]);
						if (objUrl) {
							$("#profile-header").attr("src", objUrl);
						}
					});

	$(document).on("click", "#om-profile-button", function() {
		var cid = $("#on-profile-cid").val();
		var nickname = $("#profile-nickname").val();
		var sex = $("input[type='radio']:checked").val();
		if (nickname == "" || nickname == null) {
			alert("请填写昵称");
		}
		$.omAjax({
			type : "post",
			url : "updateProfile.do",
			data : {
				"nickname" : nickname,
				"sex" : sex,
				"id" : cid
			},
			scriptCharset : 'utf-8',
			success : function(data) {
				alert("修改成功!");
			}
		});
	});
});