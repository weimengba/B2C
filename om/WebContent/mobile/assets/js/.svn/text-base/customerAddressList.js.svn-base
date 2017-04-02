$(function() {
	'use strict';

	// 初始化

	$(document)
			.on(
					"pageInit",
					"#om-customer-address",
					function(e, id, page) {
						// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。
						// alert($(e.target).html());
						// alert(id);
						// alert($(page).html());
						// ajax加载数据。
											
	$.omAjax({ 
			type : "get",
			url : "mobile/addressList.do",
			success : function(data) {
				$.each(data.data, function(i, d) {
				var addressList = '<div class="card" id="address-list">'
								+'<div class="list-block-address media-list">'
								+'<ul>'
								+'<li class="item-content">'
								+'<div class="item-inner">'
								+'<input type="hidden" id="id" name="id" value="">'
								+'<div class="item-subtitle" id="consignee">'+d.consignee+'</div>'
								+'</div>'
								+'<div class="item-inner-right">'
								+'<div class="item-subtitle" id="mobile">'+d.mobile+'</div>'
								+'</div>'
								+'</li>'
								+'<li class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-subtitle" id="address">'+d.address+'</div>'
								+'</div>'
								+'</li>'
								+'<li class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-subtitle"><input type="checkbox">默认地址</div>'
								+'</div>'
								+'<div class="item-inner-right-oper">'
								+'<div class="item-subtitle">'
								+'<a class="button" id="address-edit" href="customerAddress.html?id='+d.id+'">编辑</a>'
								+'</div>'
								+'</div>'	
								+'<div class="item-inner-right">'
								+'<div class="item-subtitle">'
								+'<a class="button" id="address-del" href="deleteAddress.do?id='+d.id+'">删除</a>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'</ul>'
								+'</div>'
								+'</div>';
					//document.getElementById("address-content").innerHTML(addressList);
					$('#address-content').append(addressList);
							
				});
			}
		});

	});
	
	
	
});