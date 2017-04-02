$(function() {
	'use strict';

	// Login初始化
	$(document).on("pageInit", "#goodscar", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。
		$.ajax({
			type : "get",
			url : "http://localhost:8080/om/cart/customercart.do",
			success : function(data) {
				$.each(data.list, function(i, d) {
					var car = '<div class="car" id="'+d.goods_id+'">'
							+'<div class="img">'
							+'<img src="'+$.GlobalVar.imageURL+d.path+'"/>'
						 	+'</div>'
							+'<div class="top">'+d.title+'</div>'
							+'<div class="con">'
							+'<text class="price">￥<text class="money">'+d.price+'</text></text>'
							+'<a class="decrease">-</a><span class="num">1</span><a class="increase">+</a>'
							+'<a class="icon icon-remove pull-right del"></a>'
							+'</div>'
							+'</div>';
							
						$('.content-block').append(car);
						
				});								
					var num = 0;
					for(var i=0;i<$('.money').length;i++){					
						num += $('.money')[i].innerHTML*1*$('.num')[i].innerHTML;					
						$('.sumprice').html(num);				
					}
					$(document).on("click", ".increase", function(e) {
						$(this).siblings('.num').html($(this).siblings('.num').html()*1+1);
						var num = 0;
						for(var i=0;i<$('.money').length;i++){					
							num += $('.money')[i].innerHTML*1*$('.num')[i].innerHTML;					
							$('.sumprice').html(num);				
						}
					});
					$(document).on("click", ".decrease", function(e) {
						if($(this).siblings('.num').html()*1>1){
							$(this).siblings('.num').html($(this).siblings('.num').html()*1-1);
						}
						var num = 0;
						for(var i=0;i<$('.money').length;i++){					
							num += $('.money')[i].innerHTML*1*$('.num')[i].innerHTML;					
							$('.sumprice').html(num);				
						}
					});
					$(document).on("click", ".del", function(e) {
						$(this).parents('.car').remove();
						var num = 0;
						for(var i=0;i<$('.money').length;i++){					
							num += $('.money')[i].innerHTML*1*$('.num')[i].innerHTML;					
							$('.sumprice').html(num);				
						}
					});
			},
			error : function(xhr, type) {
				alert('访问服务出错！');
			}
		})
		
	});
	
	$(document).on("click",".settlement",function(e){
		var result;
		var str = [];
		for(var i=0;i<$('.car').length;i++){
			result = {goods_id:$('.car')[i].getAttribute("id"),num:$('.num')[i].innerHTML,price:$('.money')[i].innerHTML,}
			str.push(result);
		}		
		var sumprice = $('.sumprice').html();		
		$.ajax({
			type:"post",
			url:"http://localhost:8080/om/order/orderPay.do",
			data:{sumprice:sumprice,data:str},
			success:function(){
				alert('ok')
			},
			error:function(){
				alert('error!')
			}
		})
	})
	
	
	
	
});