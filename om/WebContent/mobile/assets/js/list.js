$(function(){
	'use strict';
	$(document).on("pageInit","#om-list",function(e, id, page) {
				// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。
				// alert($(e.target).html());
				//alert(id);
				var tag = location.search.substr(1).split("=")[1];
				// alert($(page).html());
				// ajax加载数据。
									
				
				$.ajax({
					type : "post",
					url : "http://localhost:8080/om/pub/goods/goodsById.do",
					data:{cid:tag},
					success : function(res) {
						console.log(res);
						$.each(res.data.datas, function(i, d) {
							var card =														
								'<div class="card">'
								+'<div class="card-content">'
								+'<div class="list-block media-list">'
								+'<ul>'
								+'<li class="item-content">'	
								+'<div class="item-media" data="'+d.id+'">'		
								+'<img src="'+$.GlobalVar.imageURL+d.path+'" width="100" height="160">'			
								+'</div>'		
								+'<div class="item-inner">'		
								+'<div class="item-title-row">'			
								+'<div class="item-title">'+d.brief+'</div>'				
								+'</div>'			
								+'<div class="item-subtitle">'+d.title+'</div>'			
								+'<div class="item-subtitle">已售出：4473</div>'			
								+'<hr>'			
								+'<div class="item-subtitle">专享价：<strong class="text-danger">￥'+d.price+'</strong></div>'			
								+'<div class="item-subtitle">市场价：<del>￥'+d.marketPrice+'</del></div>'			
								+'<button id="'+d.id+'" class="button button-fill button-danger buy">立即购买</button>'			
								+'</div>'		
								+'</li>'	
								+'</ul>'
								+'</div>'
								+'</div>'
								+'</div>';

							$('.content').append(card);
						})
						
					},
				});
	});
	$(document).on("click", ".buy", function(e) {
		var goodsId = $(this).attr("id");
		console.log(goodsId);
		$.ajax({
			type: "post",
			url: "http://localhost:8080/om/order/addCar.do",
			data: {goodsId:goodsId,customerId:"8"},
			datatype:"json",
			async: true,
			success:function(res){
				alert(222);
				$.router.load('goodscar.html',true);
			}
		});
		
	});
	
	$(document).on("click", ".item-media", function(e) {
		var id=$(this).attr('data');
		
		$.router.load('details.html?id='+id, true);		
	});		
})