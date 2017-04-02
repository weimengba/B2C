/**
 * description:商品列表
 * author: 葛小雷
 */
$(function() {
	'use strict';
	var categoryId = $.getUrlId();
	console.log('getId:'+categoryId);
//	var searchTitle;
//	var sortWay = {
//		desc: 1,
//		orderColumn: 'price'
//	}
	
	var param = {
			c_cur:1,
			c_od:'',
			c_desc:'',
			categoryId:categoryId,
			title:''
		};
	var loading = false;
	
	$(document).on(
		"pageInit",
		"#om-goodList",
		function(e, id, page) {	
			refreshData();
	});	
	
	//无限滚动事件
	$(document).on('infinite', '.infinite-scroll-bottom', function() {
		if (loading) return;
		loading = true;
		// 模拟1s的加载过程
		refreshData();
	});
	
	function refreshData(){
		$.omAjax({
				type: "post",
				url: "pub/goods/goodsById.do",
				data: param,
				success: function(data) {
					console.log('success');
					$('#goods>.col-100').remove();
					$.each(data.datas.list, function(i, d) {
						var goods = '<div class="col-100"><a href="goodsDetails.html?id=' + d.id + '"><img class="recom-img" src="' + $.GlobalVar.imageURL + d.path + '" alt="宝贝主图" /><div class="row no-gutter"><div class="col-50 u-tit"><span>' + d.title + '</span></div><div class="col-20"><span class="u-price">￥' + d.price + '</span></div><div class="col-30"><span style="">月销' + d.num + '笔</span></div></div></a></div>';						
						$('#goods').append(goods);
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
	}

	sortWayData($("#sortByPrice"),'price');
	sortWayData($("#sortBySells"),'num');
	$("#searchBtn").on("click",function(){
		param.title = $("#searchGoods").val();
		refreshData();
	});	
	function sortWayData(btn,way){
		$(btn).on("click", function(e) {
			param.c_od=way;
			if(param.c_desc==''){
				param.c_desc=1;
				refreshData();
			}else {
				param.c_desc='';
				refreshData();
			}
		})
	}
	
});