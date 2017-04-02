<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/layout/html_head.jsp"></jsp:include>
	<title>管理平台历史订单列表</title>
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
						<i class="im-table2"></i> 管理平台历史订单列表
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
								<form style="margin-top: 20px;" class="common-page-form" action="plat/payment/historyList.do" method="post">
									<input class="common-page-cur" type="hidden" name="c_cur" value="1"> 
									<input class="common-page-order" type="hidden" name="c_od"value="${param.c_od }"> 
									<input class="common-page-desc" type="hidden" name="c_desc" value="${param.c_desc }"> 
									<label>订单id：</label>
									<label class="col-lg-2 control-label">
										<input type="text" class="form-control input-large" name="orderId" value="${param.orderId }"> 
									</label>
									<label>下单时间：</label>
									<label class="col-lg-2 control-label">
										<input type="text" class="sang_Calender"name="ctime" value="${param.ctime }">
									</label> 
									订单状态：<label>  
												<select  class="form-control input-large" name="orderStatus">  
										              <c:if test="${param.orderStatus==null}">
										             <option value="5">请选择订单状态</option>
												     <option value="0">新下单</option> 										     
												     <option value="1">已付款</option> 
												     <option value="2">已确认</option> 										     
												     <option value="3">已发货</option>
												     <option value="4">已收货</option>
											  </c:if>
											  <c:if test="${param.orderStatus==0}"> 
												     <option value="0">新下单</option> 										     
												     <option value="1">已付款</option> 
												     <option value="2">已确认</option> 										     
												     <option value="3">已发货</option>
												     <option value="4">已收货</option>
											  </c:if>
											  <c:if test="${param.orderStatus==1}">
											         <option value="1">已付款</option>
											         <option value="0">新下单</option>  
												     <option value="2">已确认</option> 										     
												     <option value="3">已发货</option>
												     <option value="4">已收货</option>
											  </c:if>
											  <c:if test="${param.orderStatus==2}">
											  		<option value="2">已确认</option>
											  		<option value="1">已付款</option>
											         <option value="0">新下单</option>   		     
												     <option value="3">已发货</option>
												     <option value="4">已收货</option>
											  </c:if>
											  <c:if test="${param.orderStatus==3}"> 
											   		<option value="3">已发货</option>
											   		 <option value="2">已确认</option>
											  		<option value="1">已付款</option>
											         <option value="0">新下单</option>  
												     <option value="4">已收货</option> 
											  </c:if>
											  <c:if test="${param.orderStatus==4}"> 
											   		
											   		<option value="4">已收货</option>
											   		 <option value="3">已发货</option>
											   		 <option value="2">已确认</option>
											  		<option value="1">已付款</option>
											         <option value="0">新下单</option>  
												     
											  </c:if>
											   <c:if test="${param.orderStatus==5}"> 
											   		<option value="5">请选择订单状态</option>
											   		<option value="4">已收货</option>
											   		 <option value="3">已发货</option>
											   		 <option value="2">已确认</option>
											  		<option value="1">已付款</option>
											         <option value="0">新下单</option>  
												     
											  </c:if>
												     </select></label>
									<input class="bike-add-button btn btn-primary btn-sm " type="submit" value="查询">
								</form>
								<a class="bike-add-button btn btn-primary btn-sm pull-right" href="plat/payment/history.do">添加</a>
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>
											<th class="common-order-button" data-order="id" data-desc="">ID</th> 
											<th class="common-order-button" data-order="orderId" data-desc="">订单id</th>
											<th class="common-order-button" data-order="managerId" data-desc="">操作人ID</th> 
											<th class="common-order-button" data-order="orderStatus" data-desc="">商品状态</th>
											<th class="common-order-button" data-order="message" data-desc="">信息</th>
											<th class="common-order-button" data-order="ctime" data-desc="">下单时间</th> 
											<th>操作</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data.list}" var="d">
											<tr class="odd gradeX">
												<td>${d.id}</td> 
												<td>${d.orderId}</td> 
												<td>${d.managerId}</td> 
												<td>
													<c:if test="${d.orderStatus==0}">
												              新下单
												    </c:if>
												    <c:if test="${d.orderStatus==1}">
												             已付款
												    </c:if>
												    <c:if test="${d.orderStatus==2}">
												              已确认
												    </c:if>
												    <c:if test="${d.orderStatus==3}">
												           已发货
												    </c:if>
												    <c:if test="${d.orderStatus==4}">
												             已收货
												    </c:if>
												
												</td>
												<td>${d.message}</td>
												<td>
												<fmt:formatDate value='${d.ctime}' pattern='yyyy-MM-dd    HH:mm'/>
												</td>
												<td class="center" width="12%"><a class="btn btn-primary btn-sm" href="plat/payment/updateHistory.do?id=${d.id }">编辑</a>|<a class="btn btn-primary btn-sm" href="plat/payment/historyDelete.do?id=${d.id }">删除</a></td>
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
	<!-- 苏鹏 日期选择器js -->
	<script type="text/javascript" src="assets/js/om/date/datetime.js"></script>
	
	<!-- 模板公共的JS -->
	<script src="assets/js/jquery.sprFlat.js"></script>
	<script src="assets/js/app.js"></script>

</body>
</html>