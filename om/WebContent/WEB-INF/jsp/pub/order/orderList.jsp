<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
						<i class="im-table2"></i> Order订单信息表
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
								<form style="margin-top: 20px;" class="common-page-form" action="order/orderList.do" method="get">
									<input class="common-page-cur" type="hidden" name="c_cur" value="1"> <input class="common-page-order" type="hidden" name="c_od"
										value="${param.c_od }"> <input class="common-page-desc" type="hidden" name="c_desc" value="${param.c_desc }"> 
                                        <label>用户ID：</label> <input type="text" name="customer_id" value="${param.customer_id }">
                                        <label>删除状态：</label>
                                        <select class="col-lg-2 control-label" name="is_del">  									 
											 <option value="0">未删除</option>
											 <option value="1">已删除</option>
									    </select>
									    <select class="col-lg-2 control-label" name="state" >  										 
											 <option value="0">待支付</option>
											 <option value="1">已支付</option> 										     
										     <option value="2">已确认</option>
										     <option value="3">已出库</option>
										     <option value="4">已签收</option>
										     <option value="5">已退款</option>
										     <option value="6">已取消</option>
										 </select> 									     								     							
										<input type="submit" value="查询">
								</form>
								<a class="bike-add-button btn btn-primary btn-sm pull-right" href="order/tianjia1.do">添加</a>
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>
											<th class="common-order-button" data-order="id" data-desc="">ID</th>
										    <th class="common-order-button" data-order="customer_id" data-desc="">用户ID</th>
											<th class="common-order-button" data-order="total_price" data-desc="">总价</th>
											<th class="common-order-button" data-order="pay" data-desc="">支付金额</th>
											<th class="common-order-button" data-order="state" data-desc="">订单状态</th> 
											<th class="common-order-button" data-order="customer_address_id" data-desc="">收货地址ID</th> 
											<th class="common-order-button" data-order="remark" data-desc="">订单备注</th> 
											<th class="common-order-button" data-order="ctime" data-desc="">创建时间</th> 
											<th class="common-order-button" data-order="#" data-desc="">操作</th> 
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data.list }" var="d">
											<tr class="odd gradeX">
												<td>${d.id }</td>
												<td>${d.customer_id }</td>
												<td>${d.total_price }</td>
												<td>${d.pay }</td> 
												<td>
												<c:if test="${d.state==0}">
												             未支付
												    </c:if>
												    <c:if test="${d.state==1}">
												             已支付
												    </c:if>
													 <c:if test="${d.state==2}">
												              已确认
												    </c:if>
												    <c:if test="${d.state==3}">
												            已出库
												    </c:if>
												     <c:if test="${d.state==4}">
												              已签收
												    </c:if>
												     <c:if test="${d.state==5}">
												              已退款
												    </c:if>
												     <c:if test="${d.state==6}">
												              已取消
												    </c:if>
												</td> 
												<td>${d.customer_address_id }</td>
												<td>${d.remark }</td> 												
												<td>${d.ctime}</td> 												
												<td class="center" width="12%"><a class="btn btn-primary btn-sm" href="order/tianjia.do?id=${d.id }">编辑</a>|<a class="btn btn-primary btn-sm"
													href="order/DeleteOrder.do?id=${d.id }">删除</a></td>
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

</body>
</html>