<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/layout/html_head.jsp"></jsp:include>

</head>

<body>
	<jsp:include page="/layout/body_header.jsp"></jsp:include>
	<jsp:include page="/layout/body_left.jsp"></jsp:include>
	<jsp:include page="/layout/body_right.jsp"></jsp:include>
	<!-- Start #content -->
	<!-- Start #content -->
	<div id="content">
		<!-- Start .content-wrapper -->
		<div class="content-wrapper">
			<div class="row">
				<!-- Start .row -->
				<!-- Start .page-header -->
				<div class="col-lg-12 heading">
					<h1 class="page-header">
						<c:if test="${object == null }">添加商品</c:if>
						<c:if test="${object != null }">编辑商品</c:if>
					</h1>
					<!-- Start .bredcrumb -->
					<ul id="crumb" class="breadcrumb">
					</ul>
					<!-- End .breadcrumb -->
				</div>
				<!-- End .page-header -->
			</div>
			<!-- End .row -->
			<!-- Page start here ( usual with .row ) -->
			<div class="outlet">
				<!-- Start .outlet -->
				<div class="row">
					<!-- Start .row -->
					<div class="col-lg-12">
						<!-- Start col-lg-12 -->
						<div class="panel panel-default toggle">
							<!-- Start .panel -->
							<div class="panel-heading">
								<h3 class="panel-title">添加或者修改商品</h3>
							</div>
							<div class="panel-body">
								<form action="plat/goods/goodsSave.do" method="post" class="form-horizontal group-border hover-stripped" role="form" id="validate"
									enctype="multipart/form-data">
									<c:if test="${object != null }">
										<input type="hidden" name="id" value="${object.id }">
									</c:if>
									
									<c:if test="${object != null }">
										<input type="hidden" name="id" value="">
									</c:if>

									<div class="form-group">
										<label class="col-lg-2 control-label">所属分类</label>
										<div class="col-lg-10">
										
										
											<select class="col-lg-2 control-label" name="categoryId">
													<c:forEach items="${goodsCat }" var="cat">
														<option value="${cat.id }"
														<c:if test="${object.category_id == cat.id}">
														selected="selected"
														</c:if >
														>
															${cat.name }
														</option>
														
														
													</c:forEach>
											</select>
										
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">所属类别</label>
										<div class="col-lg-10">
											<select class="col-lg-2 control-label" name="typeId">
													<c:forEach items="${goodsType }" var="t">
														<option value="${t.id }"
														<c:if test="${object.type_id == t.id}">
														selected="selected"
														</c:if >
														>
															${t.title }
														</option>
													</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">商品名称</label>
										<div class="col-lg-10">
											<input type="text" name="title" value="${object.title }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">平台销售价格</label>
										<div class="col-lg-10">
											<input type="text" name="price" value="${object.price }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">市场价</label>
										<div class="col-lg-10">
											<input type="text" name="marketPrice" value="${object.market_price }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">商品库存</label>
										<div class="col-lg-10">
											<input type="text" name="quantity" value="${object.quantity }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">销售数量</label>
										<div class="col-lg-10">
											<input type="text" name="num" value="${object.num }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">商品简述</label>
										<div class="col-lg-10">
											<input type="text" name="brief" value="${object.brief }" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-lg-2 control-label">商品详情</label>
										<div class="col-lg-10">											
											<!-- 富文本编辑框 -->
											<textarea id="rich_editor" name="detail">${object.detail }</textarea>
											<script src="assets/plugins/ueditor/ueditor.config.js"></script>
											<script src="assets/plugins/ueditor/ueditor.all.min.js"></script>
											<script src="assets/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
											<script>
												//富文本编辑
												var ue = UE.getEditor('rich_editor');
											</script>						
											<!-- 富文本编辑框 -->
										
										
										</div>
									</div>
									
									<div class="form-group" id="photo">
										<label class="col-lg-2 control-label">商品主图</label> 
										<c:if test="${object !=null }">	
										<img id="om_goods_edit_photo" src="${sys_image_prefix }${o[0].path }">
										
											<input type="button" value="删除" onclick="deletePhoto(${o[0].id},'goodsPhoto')"/>
										<div id="om_goods_photo_input" class="col-lg-10" style="display:none">
											<label>文件：</label><input type="file" name="goodsPhoto" disabled="disabled">
											</div>										
										</c:if>
										
										<c:if test="${object ==null }">							
										<div class="col-lg-10">
											<label>文件：</label><input type="file" name="goodsPhoto">
										</div>										
										</c:if>
									</div>	
									<div class="form-group" id="goodsImg" name="goodsImg">
										<label class="col-lg-2 control-label">商品相册</label> <a id="om-add-goods-img" href="#" class="btn btn-success">添加商品相册图片</a>
										<c:if test="${object !=null }">
											<c:forEach items="${goodsImg }" var="img">											
												<img id="${img.id}" src="${sys_image_prefix }${img.path }">
												<input type="button" value="删除" onclick="deletePhoto(${img.id},'goodsImg')"/>
											</c:forEach>
										</c:if>
										
									</div>
							</div>
							<!-- End .form-group  -->
							<div class="form-group">
								<div class="col-lg-offset-2">
									<button class="btn btn-success" type="submit">提交</button>
								</div>
							</div>
							<!-- End .form-group  -->
							</form>
						</div>
					</div>
					<!-- End .panel -->
				</div>
				<!-- End col-lg-12 -->
			</div>
			<!-- End .row -->
			<!-- Page End here -->
		</div>
		<!-- End .outlet -->
	</div>
	<!-- End .content-wrapper -->
	<div class="clearfix"></div>
	</div>
	<!-- End #content -->

	<!-- End #content -->
	<jsp:include page="/layout/body_end.jsp"></jsp:include>



	<script src="assets/plugins/core/moment/moment.min.js"></script>
	<script src="assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
	<script src="assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
	<script src="assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
	<script src="assets/plugins/forms/tinymce/tinymce.min.js"></script>
	<script src="assets/plugins/forms/switch/jquery.onoff.min.js"></script>
	<script src="assets/plugins/forms/maxlength/bootstrap-maxlength.js"></script>
	<script src="assets/plugins/forms/bootstrap-filestyle/bootstrap-filestyle.js"></script>
	<script src="assets/plugins/forms/color-picker/spectrum.js"></script>
	<script src="assets/plugins/forms/daterangepicker/daterangepicker.js"></script>
	<script src="assets/plugins/forms/datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script src="assets/plugins/forms/globalize/globalize.js"></script>
	<script src="assets/plugins/forms/maskedinput/jquery.maskedinput.js"></script>
	<script src="assets/plugins/forms/select2/select2.js"></script>
	<script src="assets/plugins/forms/dual-list-box/jquery.bootstrap-duallistbox.js"></script>
	<script src="assets/plugins/forms/password/jquery-passy.js"></script>
	<script src="assets/plugins/forms/checkall/jquery.checkAll.js"></script>
	<script src="assets/plugins/forms/validation/jquery.validate.js"></script>
	<script src="assets/plugins/forms/validation/additional-methods.min.js"></script>
	<script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
	<script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>

	<!-- 模板公共的JS -->
	<script src="assets/js/jquery.sprFlat.js"></script>
	<script src="assets/js/app.js"></script>

	<!-- 页面自身JS函数 -->
	<script src="assets/js/om/plat/goods/goods.js"></script>

</body>
</html>