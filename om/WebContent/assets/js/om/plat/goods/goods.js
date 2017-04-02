$(document).ready(function() {

//------------- File input styling -------------//
$(":file").filestyle({
	buttonText: "Select file",
	classButton: "btn btn-primary",
	classInput: "form-control file-upload",
	classIcon: "fa-plus-sign"
});
 
//------------- Form validation -------------//
//add custom method for filesize field
$.validator.addMethod('filesize', function(value, element, param) {
    // param = size (en bytes) 
    // element = element to validate (<input>)
    // value = value of the element (file name)
    return (element.files[0].size <= param*1024) 
});
$("#validate").validate({
	ignore: null,
	ignore: 'input[type="hidden"]',
	errorPlacement: function(error, element) {
		wrap = element.parent();
		wrap1 = wrap.parent();
		if (wrap1.hasClass('checkbox')) {
			error.insertAfter(wrap1);
		} else {
			if (element.attr('type')=='file') {
				error.insertAfter(element.next());
			} else {
				error.insertAfter(element);
			}
		}
	}, 
	errorClass: 'help-block',
	rules: {		
		"goodsPhoto": { 
			required: true, 
			accept: "png|jpeg|jpg|gif", 
			filesize: 1024  
		},
		
		"goodsImg": { 
			required: true, 
			accept: "png|jpeg|jpg|gif", 
			filesize: 1024  
		}
	},
	messages: {		
		goodsPhoto: "文件必须是  JPG, GIF or PNG 格式, 且不能超过 1MB！",
		goodsImg: "文件必须是  JPG, GIF or PNG 格式, 且不能超过 1MB！"
	},
	highlight: function(element) {
		if ($(element).offsetParent().parent().hasClass('form-group')) {
			$(element).offsetParent().parent().removeClass('has-success').addClass('has-error');
		} else {
			if ($(element).attr('type')=='file') {
				$(element).parent().parent().removeClass('has-success').addClass('has-error');
			}
			$(element).offsetParent().parent().parent().parent().removeClass('has-success').addClass('has-error');
			
		}
    },
    unhighlight: function(element,errorClass) {
    	if ($(element).offsetParent().parent().hasClass('form-group')) {
    		$(element).offsetParent().parent().removeClass('has-error').addClass('has-success');
	    	$(element.form).find("label[for=" + element.id + "]").removeClass(errorClass);
    	} else if ($(element).offsetParent().parent().hasClass('checkbox')) {
    		$(element).offsetParent().parent().parent().parent().removeClass('has-error').addClass('has-success');
    		$(element.form).find("label[for=" + element.id + "]").removeClass(errorClass);
    	} else if ($(element).next().hasClass('bootstrap-filestyle')) {
    		$(element).parent().parent().removeClass('has-error').addClass('has-success');
    	}
    	else {
    		$(element).offsetParent().parent().parent().removeClass('has-error').addClass('has-success');
    	}
	}
});
 	
$('#om-add-goods-img').click(function(){
	
	if($(":file").length > 11){
		alert("最大上传10张商品相册图片!");
	}
	
	
	var content = '<div class="form-group">'
		+'<label class="col-lg-2 control-label">商品相册</label>'
		+'<div class="col-lg-10">'
		+'<label>文件：</label><input type="file" name="goodsImg">'
		+'</div>'
		+'</div>';
	$(this).parent().first().after($(content));
	
	//修复文件输入框样式。
	$(":file").filestyle({
		buttonText: "Select file",
		classButton: "btn btn-primary",
		classInput: "form-control file-upload",
		classIcon: "fa-plus-sign"
	});
});

$('#om_goods_edit_photo').click(function(){
	$('#om_goods_photo_input').css('display','block');
	$('#om_goods_photo_input').find('input').attr('disabled',false);
});


});

/**
 * 删除商品图片Ajax操作
 * @param id
 * @param type
 */
function deletePhoto(id,type){
	  $.ajax({
		      async: false,
		      cache: false,
		      type: 'POST',
	          url: "/om/plat/goods/goodsDeletePhoto.do", //请求的action路径
	          data:{'id':id,'type':type},
	          error: function () {//请求失败处理函数  
	                      alert('请求失败');
		         },
		         success: function (data) { 
		        	 if(data.message=="success"){
		        		 if(type=="goodsPhoto"){
		        			    $("#om_goods_edit_photo").remove();
				        		$('#om_goods_photo_input').css('display','block');
				        		$('#om_goods_photo_input').find('input').attr('disabled',false);	
		        		 }else{
		        			 $("#"+id).remove();
		        		 } 
		        		 
		        	
		        	 }else{
		        		 alert('删除失败');
		        	 }
	                },  
		    }); 
	
	}
 //二级联动商品属性和属性值
function attrValue(id){
	$('#attr').empty();
	//var id = document.getElementsByName('goodsId')[0];
	//alert(id);
	 $.ajax({
	      async: false,
	      cache: false,
	      type: 'POST',
          url: "/om/plat/goodsAttrValue/goodsAttrChange.do", 
          data:{'id':id},
          error: function () {
                     alert('请求失败');
	         },
	         success: function (data) { 
	        	 if(data.message=="success"){
	        		$.each(data.attr, function(i, d){
	        			//alert(d);
	        			var attr = '<option value='+d.id+'>'+d.title+'</option>';
	        			$('#attr').append(attr);
	        		})
	        		
	        	 }
	        } 
	    }); 
	 
	 
}



















