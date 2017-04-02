/**
 * description:宝贝详情
 * author: 葛小雷
 */
$(function() {
	'use strict';
	var goodsDetailID=$.getUrlId();
	$(document).on(
		"pageInit",
		"#om-goodsdetails",
		function(e, id, page) {			
			$.omAjax({
				type : "post",
				url : "pub/goods/goodsDetailById.do",
				data : {id:goodsDetailID},
				success : function(data) {
					$("#goods-name").html(data.data[0].title);
					$("#market-price").html(data.data[0].marketPrice);
					$("#price").html('￥'+data.data[0].price);
					$("#sales-num").html('已销'+data.data[0].num+'笔');
					console.log('success'+data.datas.nickname);
					$.each(data.data,function(i,d){
//						console.log(d.title);
						var attributes='<div class="row no-gutter details-high">'
										+'<div class="col-50">'
											+'<span>'+d.titles+'</span>'
											+'<span>'+d.value+'</span>'
										+'</div>'							
									+'</div>';
						$("#tab3-content").append(attributes);
					})
					$.each(data.datas,function(i,e){
						console.log('content:'+e.nickname);
						var comments='<div class="card">'
				            			+'<div class="card-header">'
		            						+'<p><img class="u-user-img" src="assets/img/city.jpg"/><span class="u-user-nickname">'+e.nickname+'</span></p>'		            	
		            					+'</div>'
		            					+'<div class="card-content">'
										+'<div class="card-content-inner">'
		            							+'<span id="comment-time">'+e.ctime+'</span>'
	            								+'<p>'+e.content+'</p>'
	            							+'</div>'
	            						+'</div>'
	            					+'</div>'
	            					$("#tab2-content").append(comments);
					})
				}
			});
		});
	});
