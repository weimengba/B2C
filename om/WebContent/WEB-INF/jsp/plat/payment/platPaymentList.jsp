<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/layout/html_head.jsp"></jsp:include>
	<title>管理平台订单列表</title>
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
						<i class="im-table2"></i> 管理平台订单列表
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
								<form style="margin-top: 20px;" class="common-page-form" action="plat/payment/paymentList.do" method="post">
									<input class="common-page-cur" type="hidden" name="c_cur" value="1"> 
									<input class="common-page-order" type="hidden" name="c_od"value="${param.c_od }"> 
									<input class="common-page-desc" type="hidden" name="c_desc" value="${param.c_desc }"> 
									<label class="col-lg-2 control-label">支付人：</label>
									<label class="col-lg-2 control-label">
										<input type="text" class="form-control input-medium" name="payer" value="${param.payer }"> 
									</label>
									<label class="col-lg-2 control-label">支付时间：</label>
									<input type="text" class="sang_Calender"name="payTime" value="${param.payTime }">
										<br/>
									<label class="col-lg-2 control-label">支付方式：</label>
									    <label class="col-lg-2 control-label">
										<select class="form-control input-medium" name="payWay">
												   <c:if test="${param.payWay==null}">
												  <option value="0">请选择支付方式</option>
												 <option value="1">支付宝</option> 										     
											     <option value="2">微信</option>
											   </c:if>
											   <c:if test="${param.payWay==1}"> 
												 <option value="1">支付宝</option> 										     
											     <option value="2">微信</option>
											   </c:if>
											   <c:if test="${param.payWay==2}">  		     
											     <option value="2">微信</option>
											     <option value="1">支付宝</option> 
											   </c:if>
											   <c:if test="${param.payWay==0}">
												  <option value="0">请选择支付方式</option>
												 <option value="1">支付宝</option> 										     
											     <option value="2">微信</option>
											   </c:if>
										   </select>
										   </label>
										   
									 <label class="col-lg-2 control-label">支付状态：</label>
									 <label class="col-lg-2 control-label">
												<select class="form-control input-medium" name="payStatus">  
										              <c:if test="${param.payStatus==null}">
										             <option value="0">请选择支付状态</option>
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 										     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${param.payStatus==1}">
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 										     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${param.payStatus==2}">
											 		 <option value="2">已支付</option> 
												     <option value="1">未支付</option>  
												     <option value="3">退款中</option> 										     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${param.payStatus==3}">
											  		 <option value="3">退款中</option> 
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option>  		     
												     <option value="4">已退款</option>
											  </c:if>
											  <c:if test="${param.payStatus==4}"> 
											   		 <option value="4">已退款</option>
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 
											  </c:if>
											   <c:if test="${param.payStatus==0}"> 
											   <option value="0">请选择支付状态</option>
											   		 <option value="4">已退款</option>
												     <option value="1">未支付</option> 										     
												     <option value="2">已支付</option> 
												     <option value="3">退款中</option> 
											  </c:if>
												     </select></label>
									<input type="submit" class="bike-add-button btn btn-primary btn-sm " value="查询">
								</form>
								<a class="bike-add-button btn btn-primary btn-sm pull-right" href="plat/payment/add.do">添加</a>
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>
											<th class="common-order-button" data-order="id" data-desc="">ID</th>
											<th class="common-order-button" data-order="payer" data-desc="">支付人</th>
											<th class="common-order-button" data-order="orderId" data-desc="">订单id</th>
											<th class="common-order-button" data-order="payWay" data-desc="">支付方式</th> 
											<th class="common-order-button" data-order="payTime" data-desc="">支付时间</th>
											<th class="common-order-button" data-order="payStatus" data-desc="">支付状态</th>
											<th class="common-order-button" data-order="paySum" data-desc="">总金额</th>
											<th class="common-order-button" data-order="payAmount" data-desc="">应收金额</th>
											<th class="common-order-button" data-order="payActual" data-desc="">实际支付金额</th>
											<th class="common-order-button" data-order="payRefund" data-desc="">退款金额</th>
											<th>操作</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data.list}" var="d">
											<tr class="odd gradeX">
												<td>${d.id}</td>
												<td>${d.payer}</td>
												<td>${d.orderId}</td>
												<td>
													<c:if test="${d.payWay==1}">
												              支付宝
												    </c:if>
													 <c:if test="${d.payWay==2}">
												              微信
												    </c:if>
												</td>
												<td>
												<fmt:formatDate value='${d.payTime}' pattern='yyyy-MM-dd    HH:mm'/>
												</td>
												<td>
													<c:if test="${d.payStatus==1}">
												              未支付
												    </c:if>
												    <c:if test="${d.payStatus==2}">
												             已支付
												    </c:if>
												    <c:if test="${d.payStatus==3}">
												              退款中
												    </c:if>
												    <c:if test="${d.payStatus==4}">
												              已退款
												    </c:if>			
												</td>
												<td>${d.paySum}</td>
												<td>${d.payAmount}</td>
												<td>${d.payActual}</td>
												<td>${d.payRefund}</td>
												<td class="center" width="12%"><!-- <a class="btn btn-primary btn-sm" href="plat/payment/updatePlat.do?id=${d.id }">编辑</a>| --><a class="btn btn-primary btn-sm" href="plat/payment/platPaymentDelete.do?id=${d.id }">删除支付信息</a></td>
											</tr>                                                                                              
										</c:forEach>
									</tbody>                                  
								  </table>
							<jsp:include page="/layout/page.jsp"></jsp:include>	 
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

	<!-- End #content -->
	<jsp:include page="/layout/body_end.jsp"></jsp:include>

	<script src="assets/plugins/core/moment/moment.min.js"></script>
	<script src="assets/plugins/charts/sparklines/jquery.sparkline.js"></script>
	<script src="assets/plugins/charts/pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="assets/plugins/forms/icheck/jquery.icheck.js"></script>
	<script src="assets/plugins/forms/tags/jquery.tagsinput.min.js"></script>
	<script src="assets/plugins/forms/tinymce/tinymce.min.js"></script>
	<script src="assets/plugins/tables/datatables/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/tables/datatables/jquery.dataTablesBS3.js"></script>
	<script src="assets/plugins/tables/datatables/tabletools/ZeroClipboard.js"></script>
	<script src="assets/plugins/tables/datatables/tabletools/TableTools.js"></script>
	<script src="assets/plugins/misc/highlight/highlight.pack.js"></script>
	<script src="assets/plugins/misc/countTo/jquery.countTo.js"></script>
	<!-- 模板公共的JS -->
	<script src="assets/js/jquery.sprFlat.js"></script>
	<script src="assets/js/app.js"></script>
	<!-- 苏鹏 日期选择器js -->
	<script type="text/javascript" src="assets/js/om/date/datetime.js"></script>
	

</body>
</html>