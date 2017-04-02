$(function() {
	'use strict';

	// customerAddress初始化
	$(document).on("pageInit", "#customerAddress", function(e, id, page) {
		//alert(page.data);
		//$("#consignee").val(consignee);
		var addressId=getURLParameter("id");
	/*	window.location.href="address.do?id="+addressId; */
	if(addressId==null || addressId==""){
		var addressDetail='<ul>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-media"><i class="icon icon-form-name"></i></div>'
								+'<div class="item-inner">'
								+'<div class="item-title label">收 货 人</div>'
								+'<div class="item-input">'
								+'<input type="hidden" name="id" id="id" value="">'
								+'<input type="text" name="consignee" id="consignee" value="">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title label">联系电话</div>'
								+'<div class="item-input">'
								+'<input type="text" id="mobile" name="mobile" value="">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title label">邮政编码</div>'
								+'<div class="item-input">'
								+'<input type="text"id="postcodes" name="postcodes" value="">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title label">详细地址</div>'
								+'<div class="item-input">'
								+'<input type="text" name="address" id="address" value="">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'</ul>'
								+'<ul>'
								+'<li >'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title checkbox"><input type="checkbox" value="">设置为默认地址</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'</ul>';
								$('#om-customer-address-form').append(addressDetail);
	}else{
		$.omAjax({
			type: "post",
			url: "mobile/address.do",
			data: {"id":addressId},
			success: function(data) {
				var addressDetail='<ul>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-media"><i class="icon icon-form-name"></i></div>'
								+'<div class="item-inner">'
								+'<div class="item-title label">收 货 人</div>'
								+'<div class="item-input">'
								+'<input type="hidden" name="id" id="id" value="'+data.data.id+'">'
								+'<input type="text" name="consignee" id="consignee" value="'+data.data.consignee+'">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title label">联系电话</div>'
								+'<div class="item-input">'
								+'<input type="text" id="mobile" name="mobile" value="'+data.data.mobile+'">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title label">邮政编码</div>'
								+'<div class="item-input">'
								+'<input type="text"id="postcodes" name="postcodes" value="'+data.data.postcodes+'">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'<li>'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title label">详细地址</div>'
								+'<div class="item-input">'
								+'<input type="text" name="address" id="address" value="'+data.data.address+'">'
								+'</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'</ul>'
								+'<ul>'
								+'<li >'
								+'<div class="item-content">'
								+'<div class="item-inner">'
								+'<div class="item-title checkbox"><input type="checkbox" value="">设置为默认地址</div>'
								+'</div>'
								+'</div>'
								+'</li>'
								+'</ul>';
				$('#om-customer-address-form').append(addressDetail);
			}
		});
	}
	});
	
	$(document).on("click", "#om-address-button", function(e) {
		$.omAjax({
			type: "post",
			url: "mobile/addressSave.do",
			data: $("#om-customer-address-form").serialize(),
			async: true,
			success: function(data) {
					$.router.load('customerAddressList.html', true);
			},
			error: function(res) {
				alert("出错了！");
			}
		});

	});
});
function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
}