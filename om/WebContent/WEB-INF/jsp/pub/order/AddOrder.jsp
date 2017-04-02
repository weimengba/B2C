<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/layout/html_head.jsp"></jsp:include>
<link type="text/css" rel="stylesheet" href="jedate/skin/jedate.css">
<style>
.bodys{ padding:50px 0 0 50px;}
.datainp{ width:200px; height:30px; border:1px #A5D2EC solid;}
.datep{ margin-bottom:40px; line-height:24px; margin-right:15px;}
.wicon{background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAAQCAYAAADj5tSrAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAALEgAACxIB0t1+/AAAABZ0RVh0Q3JlYXRpb24gVGltZQAwNi8xNS8xNGnF/oAAAAAcdEVYdFNvZnR3YXJlAEFkb2JlIEZpcmV3b3JrcyBDUzVxteM2AAAAoElEQVQ4jWPceOnNfwYqAz9dYRQ+E7UtwAaGjyUsDAyYYUgJ2HT5LXZLcEmSCnA6duOlN///////H0bDALl8dPH/////Z8FuNW6Qtvw2nL3lyjsGBgYGhlmRqnj1kGwJuqHIlhJlCXq8EOITEsdqCXLEbbr8FisfFkTo+vBZRFZwERNEFFkCiw90nxJtCalxQmzegltCzVyP1RJq5HZ8AABuNZr0628DMwAAAABJRU5ErkJggg=="); background-repeat:no-repeat; background-position:right center;}
</style>
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
						<i class="im-checkbox-checked"></i> 添加订单
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
								<h3 class="panel-title">添加订单</h3>
							</div>
							<div class="panel-body">
								<form action="order/AddOrder.do" method="get" class="form-horizontal group-border hover-stripped" role="form" id="validate">																					
									<div class="form-group">
										 <c:if test="${object != null }">
										<label class="col-lg-2 control-label">Id</label>
										<div class="col-lg-10">										
										  <input type="text" name="id" value="${object.id }">									     
										</div>
										</c:if>
									</div>
								
									<div class="form-group">
										<label class="col-lg-2 control-label">用户Id</label>
										<div class="col-lg-10">
											<input type="text" name="customer_id" class="form-control" value="${object.customer_id }">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">总价</label>
										<div class="col-lg-10">
											<input type="text" name="total_price" class="form-control"value="${object.total_price }">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">支付金额</label>
										<div class="col-lg-10">
											<input type="text" name="pay" class="form-control" value="${object.pay }">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">状态</label>
										<div class="col-lg-10">
										<%-- 	<input type="" name="state" class="form-control" value="${object.state }"> --%>
									<select class="col-lg-2 control-label" name="state">  
										   <c:if test="${object.state==null}">
											 <option value="0">待支付</option>
											 <option value="1">已支付</option> 										     
										     <option value="2">已确认</option>
										     <option value="3">已出库</option>
										     <option value="4">已签收</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										   </c:if>
										   <c:if test="${object.state==0}"> 									
											 <option value="0">待支付</option>
											 <option value="1">已支付</option> 											 										     
										     <option value="2">已确认</option>
										     <option value="3">已出库</option>
										     <option value="4">已签收</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										   </c:if>
										  <c:if test="${object.state==1}"> 
										   <option value="1">已支付</option>									
											 <option value="0">待支付</option>											 											 										     
										     <option value="2">已确认</option>
										     <option value="3">已出库</option>
										     <option value="4">已签收</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										   </c:if>
										  <c:if test="${object.state==2}"> 
										   <option value="2">已确认</option>
										    <option value="0">待支付</option>
										   <option value="1">已支付</option>																										 											 										     									    
										     <option value="3">已出库</option>
										     <option value="4">已签收</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										   </c:if>
										   <c:if test="${object.state==3}"> 
										    <option value="3">已出库</option>
										  
										    <option value="0">待支付</option>
										   <option value="1">已支付</option>																										 											 										     									    
										     <option value="2">已确认</option>
										     <option value="4">已签收</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										   </c:if>
										    <c:if test="${object.state==4}"> 
										    
										   <option value="4">已签收</option>
										    <option value="0">待支付</option>
										   <option value="1">已支付</option>																										 											 										     									    
										     <option value="2">已确认</option>
										    <option value="3">已出库</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										   </c:if>
										     <c:if test="${object.state==5}"> 
										     <option value="5">已退款</option>
										  
										    <option value="0">待支付</option>
										   <option value="1">已支付</option>																										 											 										     									    
										     <option value="2">已确认</option>
										    <option value="3">已出库</option>
										     <option value="4">已签收</option>
										     <option value="6">已取消</option>
										   </c:if>
										    <c:if test="${object.state==6}"> 
										    
										  <option value="6">已取消</option>
										    <option value="0">待支付</option>
										   <option value="1">已支付</option>																										 											 										     									    
										     <option value="2">已确认</option>
										    <option value="3">已出库</option>
										     <option value="4">已签收</option>
										      <option value="5">已退款</option>s
										   </c:if>
										</select>  
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">地址ID</label>
										<div class="col-lg-10">
											<input type="text" name="customer_address_id" class="form-control" value="${object.customer_address_id }">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">创建时间</label>
										<div class="col-lg-10">
											<input type="text" class="sang_Calender" name="ctime" value="${object.ctime }">
										</div>									
									</div>															
									<div class="form-group">
										<label class="col-lg-2 control-label">结束时间</label>
										<div class="col-lg-10">
											<input type="text" name="utime" class="sang_Calender" value="${object.utime }" >
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">订单备注</label>
										<div class="col-lg-10">
											<input type="text" name="remark" class="form-control" value="${object.remark }">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">是否删除</label>
										<div class="col-lg-10">
											<input type="text" name="is_del" class="form-control" value="${object.is_del }">
										</div>
									</div>
									</div>						
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
	<script src="assets/plugins/forms/datetimepicker/locales/bootstrap-datepicker.js"></script>
	<script src="assets/plugins/forms/datetimepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
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
	
	
	<script type="text/javascript" src="assets/js/jedate/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="assets/js/jedate/jquery.jedate.js"></script>
    <!-- 时间选择器 -->
	<script type="text/javascript" src="assets/js/om/date/datetime.js"></script>
	
    </body>
</html>