$(function() {
	'use strict';
	
	var param = {
		c_cur:1,
		c_od:'',
		c_desc:'',
		categoryId:'',
		title:''
	};
	
	//加载标志
	var loading = false;
	
	$(document).on("pageInit", "#infinite_scroll", function(e, id, page) {
		// 这是页面初始化的方法。如果页面是内联方式，SUI使用了缓存，要考虑是否需要每次都调用初始化。

		//初始化时调用数据
		refreshData();
	});

	//无限滚动事件
	$(document).on('infinite', '.infinite-scroll-bottom', function() {
		if (loading) return;
		loading = true;
		// 模拟1s的加载过程
		refreshData();
	});

	//获取数据，填充
	function refreshData(){	
		//setTimeout(function() {
			
		$.omAjax({
				type: "post",
				url: "pub/goods/goodsById.do",
				data: param,
				success: function(data) {
					$.each(data.datas.list, function(i, d) {	
						
						
						$('#om-list').append('<li class="item-content">'+d.id+':' + d.title + '</li>');
					
					
					
					
					});
					loading = false;
					if(data.datas.pages === param.c_cur){
						// 加载完毕，则注销无限加载事件，以防不必要的加载
                  		$.detachInfiniteScroll($('.infinite-scroll'));
			            // 删除加载提示符
			            $('.infinite-scroll-preloader').remove();
					}							
					param.c_cur++;
				}
		});	
		
		//},2000);
	}
});


