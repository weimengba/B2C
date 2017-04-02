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
						<c:if test="${object == null }">添加商品属性</c:if>
						<c:if test="${object != null }">编辑商品属性</c:if>
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
								<h3 class="panel-title">添加或者修改商品属性</h3>
							</div>
							<div class="panel-body">
								<form action="plat/goodsAttr/goodsAttrSave.do" method="get" class="form-horizontal group-border hover-stripped" role="form" id="validate">
                                     <c:if test="${object != null }">
										<input type="hidden" name="id" value="${object.id }">
									</c:if>
									
									<div class="form-group">
										<label class="col-lg-2 control-label">属性名称</label>
										<div class="col-lg-10">
											<input type="text" name="title" value="${object.title }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">所属类别</label>
										<div class="col-lg-10">
											<select class="col-lg-2 control-label" name="typeId">
													<c:forEach items="${goodsType }" var="got">
														<option value="${got.id }"
														<c:if test="${object.type_id == got.id}">
														selected="selected"
														</c:if >
														>
															${got.title }
														</option>
														
														
													</c:forEach>
											</select>
										
										
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">属性数据类型</label>
										<div class="col-lg-10">
											
											<select class="col-lg-2 control-label" name="dataType">  
												   <c:if test="${object.data_type==null}">
													  <option value="2">请选择数据类型</option>
													 <option value="0">手工录入</option> 										     
												     <option value="1">选择录入</option>
												   </c:if>
												   <c:if test="${object.data_type==0}"> 
													 <option value="0">手工录入</option> 										     
												     <option value="1">选择录入</option>
												   </c:if>
												   <c:if test="${object.data_type==1}">  		     
												     <option value="1">选择录入</option>
												     <option value="0">手工录入</option> 
												   </c:if>
											  
										   </select>  
										
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">可选择数据</label>
										<div class="col-lg-10">
											<input type="text" name="chooseValue" value="${object.choose_value }" class="form-control">
										</div>
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
	<script src="assets/js/om/demo.js"></script>

</body>
</html>