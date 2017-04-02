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
						<i class="im-checkbox-checked"></i> 
                        <c:if test="${object == null }">添加平台用户订单</c:if>
						<c:if test="${object != null }">编辑平台用户订单</c:if>
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

								<h3 class="panel-title">
									<c:if test="${object == null }">添加平台用户订单</c:if>
									<c:if test="${object != null }">编辑平台用户订单</c:if></h3>
							</div>
							<div class="panel-body">
								<form action="plat/payment/platPaymentSave.do" enctype="multipart/form-data" method="post" class="form-horizontal group-border hover-stripped" role="form"
									id="validate">

									<c:if test="${object != null }">
										<input type="hidden" name="id" value="${object.id }">
									</c:if>
									<div class="form-group">
										<label class="col-lg-2 control-label">支付人</label>
										<div class="col-lg-10">
											<input type="text" name="payer" value="${object.payer }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">订单id</label>
										<div class="col-lg-10">
											<input type="text" name="orderId" value="${object.order_id }" class="form-control">
										</div>
									</div>
									 <div class="form-group">
										
										<div class="col-lg-10"> 
										<label class="col-lg-2 control-label">支付方式</label>
										<label class="col-lg-2 control-label">
										<select class="form-control input-large" name="payWay">  
										   <c:if test="${object.pay_way==null}">
											  <option value="0">请选择支付方式</option>
											 <option value="1">支付宝</option> 										     
										     <option value="2">微信</option>
										   </c:if>
										   <c:if test="${object.pay_way==1}"> 
											 <option value="1">支付宝</option> 										     
										     <option value="2">微信</option>
										   </c:if>
										   <c:if test="${object.pay_way==2}">  		     
										     <option value="2">微信</option>
										     <option value="1">支付宝</option> 
										   </c:if>
											  
										</select>  
										</label>
										</div>
									</div>
									<div class="form-group">
										
										<div class="col-lg-10">
										<label class="col-lg-2 control-label">支付状态</label>
										    <label class="col-lg-2 control-label">
											<select class="form-control input-large" name="payStatus">  
										      <c:if test="${object.pay_status==null}">
										             <option value="0">请选择支付状态</option>
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 										     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${object.pay_status==1}">
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 										     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${object.pay_status==2}">
											 		 <option value="2">已支付</option> 
												     <option value="1">未支付</option>  
												     <option value="3">退款中</option> 										     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${object.pay_status==3}">
											  		 <option value="3">退款中</option> 
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option>  		     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${object.pay_status==4}"> 
											   		 <option value="4">已退款</option>
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 
											  </c:if>
										  
										      
										</select> </label>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-lg-2 control-label">支付总金额</label>
										<div class="col-lg-10">
											<input type="text" name="paySum" value="${object.pay_sum }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">应收金额</label>
										<div class="col-lg-10">
											<input type="text" name="payAmount" value="${object.pay_amount }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">实际支付金额</label>
										<div class="col-lg-10">
											<input type="text" name="payActual" value="${object.pay_actual }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">退款金额</label>
										<div class="col-lg-10">
											<input type="text" name="payRefund" value="${object.pay_refund }" class="form-control">
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
	<script src="assets/js/om/xx/sysManager.js"></script>

</body>
</html>