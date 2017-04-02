$(function() {
	'use strict';

	// goods初始化

	$(document)
			.on(
					"pageInit",
					"#om-goods",
					function(e, id, page) {
						// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。
						// alert($(e.target).html());
						// alert(id);
						// alert($(page).html());
						// ajax加载数据。
											
								
	$.omAjax({ 
			type : "get",
			url : "order/payment.do",
			success : function(data) {
				$.each(data.page.list, function(i, d) { 					 

					var $card = $('#om-goods-card').clone();
					$card.find('.card-header').html(d.title);
					$card.find('.item-title').html(d.title);
					$card.find('.item-subtitle').html(d.goods_price);
					$card.find('img').attr('src','/om/image.jsp?path='+d.path);
					$('#om-goods_list').append($card); 
				});
			}
		});

	});

});