$(function() {
	'use strict';
	$(".swiper-container").swiper({loop:true,autoplay:2000,loopAdditionalSlides : 1,});
	// Login初始化
	$(document).on("pageInit", "#details", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。
		
		var gid = location.search.substr(1).split("=")[1];
		alert(gid);
		$.omAjax({
			type : "post",
			url : "pub/goods/goodsDetailById.do",
			data:{gid:gid},
			success : function(data) {
				var list = data.data[0].detail;
				$('#goodsdetail').append(list);
			}	
		})
	});

	$(document).on("click", "#argument", function(e) {
		$.omAjax({
			type : "get",
			url : "pub/goodsAttr/goodsAttrList.do",
			success : function(data) {
				$.each(data.page.list, function(i, d) {
					var list = 
						'<li class="item-content">'
						+'<div class="item-media">'
						+'<i class="icon icon-f7"></i>'
						+'</div>'
						+'<div class="item-inner">'
						+'<div class="item-title">'+d.title+'</div>'
						+'<div class="item-after">'+d.chooseValue+'</div>'
						+'</div>'
						+'</li>';
					$('.canshu').append(list);	
				});
			}	
		})
	});
	$(document).on("click", "#evaluate", function(e) {
		$.omAjax({
			type : "get",
			url : "pub/goodsComment/goodsCommentList.do ",
			success : function(data) {
				$.each(data.page.list, function(i, d) {
					var list = d.content;
						;
					$('.ping').append(list);	
				});
			}	
		})
	});
	
	
});