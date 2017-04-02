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
						<i class="im-table2"></i> 商品列表
					</h1>
					<!-- Start .bredcrumb -->
					<ul id="crumb" class="breadcrumb">
					</ul>
					<!-- End .breadcrumb -->					
				</div>
				<!-- End .page-header -->
			</div>
			<!-- End .row -->
			<div class="outlet">
				<!-- Start .outlet -->
				<!-- Page start here ( usual with .row ) -->
				<div class="row">
					<div class="col-lg-12">
						<!-- col-lg-12 start here -->
						<div class="panel panel-default plain toggle panelClose panelRefresh">
							<!-- Start .panel -->
							<div class="panel-heading white-bg">
								<form style="margin-top: 20px;" class="common-page-form" action="plat/goods/goodsList.do" method="get">
									 <div class="form-group row" style="display:flex;margin-left:1em">
									  <input class="common-page-cur" type="hidden" name="c_cur" value="1"> 
									  <input class="common-page-order" type="hidden" name="c_od"	value="${param.c_od }">
									   
										 <input class="common-page-desc" type="hidden" name="c_desc" value="${param.c_desc }">
										 <label class="control-label">商品名称：</label>
										 <input class="form-control input-medium" type="text" name="title" value="${param.title }"> 
										 <label class="control-label">价格：</label>
										 <input class="form-control input-medium" type="text" name="price" value="${param.price }"> 
										 <input class="common-page-form-search btn" type="button" value="查询">
									</div>
								</form>
								<a class="bike-add-button btn btn-primary btn-sm pull-right" href="plat/goods/goods.do">添加</a>
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>
											<th class="common-order-button" data-order="id" data-desc="">商品ID</th>
											<th class="common-order-button" data-order="title" data-desc="">商品名称</th>
											<th class="common-order-button" data-order="categoryid" data-desc="">所属分类</th>
											<th class="common-order-button" data-order="typeid" data-desc="">所属类别</th>
											<th class="common-order-button" data-order="price" data-desc="">平台售价</th>
											<th class="common-order-button" data-order="quantity" data-desc="">商品库存(件)</th>
											<th class="common-order-button" data-order="num" data-desc="">销售数量</th>
											<th class="common-order-button" data-order="ctime" data-desc="">添加时间</th>
											<th width="15%">操作</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data.list }" var="d">
											<tr class="odd gradeX">
												<td>${d.id }</td>
												<td>${d.title }</td>
												<td>${d.categoryId }</td>
												<td>${d.typeId }</td>
												<td>￥${d.price }</td>
												<td>${d.quantity }</td>
												<td>${d.num }</td>
												<td><fmt:formatDate value="${d.ctime }" pattern="yyyy-MM-dd"/></td>								
												
												<td class="center" width="12%"><a class="btn btn-primary btn-sm" href="plat/goods/goodsDetailList.do?id=${d.id }">详情</a>|<a class="btn btn-primary btn-sm" href="plat/goods/goods.do?id=${d.id }">编辑</a>|<a class="btn btn-primary btn-sm"
													href="plat/goods/goodsDelete.do?id=${d.id }">删除</a></td>
												
											</tr>
										</c:forEach>
									</tbody>
									<jsp:include page="/layout/page.jsp"></jsp:include>
								</table>
							</div>
						</div>
						<!-- End .panel -->
					</div>
					<!-- col-lg-12 end here -->
				</div>
				<!-- Page End here -->
			</div>
			<!-- End .outlet -->
		</div>
		<!-- End .content-wrapper -->
		<div class="clearfix"></div>
	</div>
	<!-- End #content -->
       <jsp:include page="/layout/body_end.jsp"></jsp:include>
	<!-- End #content -->
	
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
	
	<script>
	
	$(".datetime-picker").datetimepicker({
        format: "dd MM yyyy - hh:ii"
    }).on('show', function(){
	    $('.datetimepicker').find('th.prev>i').attr('class', '').addClass('en-arrow-left8');
	    $('.datetimepicker').find('th.next>i').attr('class', '').addClass('en-arrow-right8');
	});
	</script>
	
</body>
</html>
