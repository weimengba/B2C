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
			url : "demo/goods.do",
			success : function(data) {
				$.each(data.page.list, function(i, d) {



					'<div class="card">'
							+ '<div class="card-header">商品:'+d.title+'</div>'
							+ '<div class="card-content">'
							+ '<div class="list-block media-list">'
							+ '<ul>'
							+ '<li class="item-content">'
							+ '<div class="item-media">'
							+ '<img src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg" width="44">'
							+ '</div>'
							+ '<div class="item-inner">'
							+ '<div class="item-title-row">'
							+ '<div class="item-title">'+d.title+'</div>'
							+ '</div>'
							+ '<div class="item-subtitle">'+d.brief+'</div>'
							+ '</div>'
							+ '</li>'
							+ '</ul>'
							+ '</div>'
							+ '</div>'
							+ '</div>';

					var $card = $('#om-goods-card').clone();
					$card.find('.card-header').html(d.title);
					$card.find('.item-title').html(d.title);
					$card.find('.item-subtitle').html(d.brief);															
					$('#om-goods_list')
							.append($card);

					// var card =
					//
					// '<div class="card">'
					// + '<div class="card-header">商品:'+d.title+'</div>'
					// + '<div class="card-content">'
					// + '<div class="list-block media-list">'
					// + '<ul>'
					// + '<li class="item-content">'
					// + '<div class="item-media">'
					// + '<img
					// src="http://gqianniu.alicdn.com/bao/uploaded/i4//tfscom/i3/TB10LfcHFXXXXXKXpXXXXXXXXXX_!!0-item_pic.jpg_250x250q60.jpg"
					// width="44">'
					// + '</div>'
					// + '<div class="item-inner">'
					// + '<div class="item-title-row">'
					// + '<div class="item-title">'+d.title+'</div>'
					// + '</div>'
					// + '<div class="item-subtitle">'+d.brief+'</div>'
					// + '</div>'
					// + '</li>'
					// + '</ul>'
					// + '</div>'
					// + '</div>'
					// + '</div>';


					var $card = $('#om-goods-card').clone();
					$card.find('.card-header').html(d.title);
					$card.find('.item-title').html(d.title);
					$card.find('.item-subtitle').html(d.brief);
					$('#om-goods_list').append($card);

				});
			}
		});

	});

});