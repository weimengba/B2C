/**
 * Om项目公共Ajax操作处理。
 */

(function($) {
	$.omAjax = function(param) {
			$.ajax({
				type: param.type,
				url: $.GlobalVar.serverURL + param.url,
				async: true,
				data: param.data,
				success: function(res) {
					if(res.success) {
						// 成功！
						param.success(res.data);
					} else {
						// 失败！
						alert("服务器错误！请联系管理员！");
					}
				},
				error: function(xhr, type) {
					alert('访问服务出错！');
				}
			});
		},
		//	获取地址栏传递的ID
		$.getUrlId = function() {
			var url = window.location;
			var string = new String(url);
			var goodsID = string.split('id=')[1];
			return goodsID;
		},
		/**
		 * 获取当前项目路径例如：http://localhost:8083/proj 
		 * @returns
		 */
		$.getRootPath = function() {
			//获取当前网址，如： http://localhost:8083/proj/meun.jsp  
			var curWwwPath = window.document.location.href;
			//获取主机地址之后的目录，如： proj/meun.jsp  
			var pathName = window.document.location.pathname;
			var pos = curWwwPath.indexOf(pathName);
			//获取主机地址，如： http://localhost:8083  
			var localhostPath = curWwwPath.substring(0, pos);
			//获取带"/"的项目名，如：/proj  
			var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
			return(localhostPath + projectName);
		},
		/**
		 * 获取url中的参数
		 */
		$.requestURL = function(paras) {
			var url = location.href;
			var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
			var paraObj = {}
			for(i = 0; j = paraString[i]; i++) {
				paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
			}
			var returnValue = paraObj[paras.toLowerCase()];
			if(typeof(returnValue) == "undefined") {
				return "";
			} else {
				returnValue = decodeURIComponent(returnValue);
				return returnValue;
			}
		}
})(Zepto)

/**
 * 调用SUI初始化函数。
 */

$(function() {
	'use strict';

	$.init();

	// 根据设备侦测结果，区分浏览器，APP，微信。加载相应的JS。
	if($.device.isWeixin) {
		// alert("微信！");
		//支付
		//隐藏其他按钮，之保留微信支付的按钮。
		//导入微信支付API
		// document.write("<script type='text/javascript'
		// src='http://res.wx.qq.com/open/js/jweixin-1.0.0.js'
		// charset='utf-8'></script>");
		//
		// $('#weixinButton').click(function() {
		// wx.chooseWXPay({
		// timestamp: 0, //
		// 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
		// nonceStr: '', // 支付签名随机串，不长于 32 位
		// package: '', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
		// signType: '', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
		// paySign: '', // 支付签名
		// success: function(res) {
		// // alert(ok);
		// // ajax调用，提交支付成功信息
		// }
		//			});
		//
		//		});
	} else if($.device.webView) {
		// alert("APP！");
	} else {
		// alert("浏览器！");
	}
});