/**
 * description:商品分类
 * author: 葛小雷
 */
$(function() {
	'use strict';
	var param;
	$(document).on(
		"pageInit",
		"#om-category",
		function(e, id, page) {	
			$.omAjax({
				type : "get",
				url : "pub/goodsCategory/goodsCategoryList.do",
				data : param,
				success : function(data) {
//					param.c_cur++;
					var leveloneId = new Array();
					$.each(data.page, function(i, d) {
						if(d.level==1&&d.parentId==1){
							leveloneId.push(d.id);
							var categorys='<div class="class-type"><h5>'+d.name+'</h5><div class="row no-gutter class'+d.id+'"></div></div>';
							$('#category-content').append(categorys);
						}														
						
					});
					console.log(leveloneId);
					$.each(data.page,function(i,d) {
						for(var i=0;i<leveloneId.length;i++){
							if(d.level==2 && d.parentId==leveloneId[i]){
								var secondCategorys='<div class="col-25 text-center class-type-class"><a href="goodsLists.html?id='+d.id+'"><img src="assets/img/city.jpg"/><span>'+d.name+'</span></a></div>';
								$('.class'+leveloneId[i]).append(secondCategorys);
							}
						}		
						
					})
				}
			});
		});
	});