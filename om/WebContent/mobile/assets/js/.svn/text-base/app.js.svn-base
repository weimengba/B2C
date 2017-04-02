$(function() {
	'use strict';
	// goods初始化
	$(document).on("pageInit", "#om-app", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。
		// alert($(e.target).html());
		// alert(id);
		// alert($(page).html());
		// ajax加载数据。
										
		$.omAjax({
			type : "get",
			url : "pub/goodsCategory/goodsCategoryList.do",
			success : function(data) {
				$.each(data.page, function(i, d) {
					var col = 
						'<div class="col-50 redir" style="margin-top:10px;">'
						+'<div id="'+d.id+'" class="red">'   	
						+'<text>'+d.name+'</text>'   		
						+'</div>'   		
						+'</div>';  	
					$('#row').append(col);	    
				});
			}
		});
		
	});
	$(document).on("click", ".red", function(e) {
		var id=$(this).attr('id');
		
		$.router.load('list.html?id='+id, true)
		
	})
});