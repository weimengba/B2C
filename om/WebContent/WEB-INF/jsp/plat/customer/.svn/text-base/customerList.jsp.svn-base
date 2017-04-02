<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<jsp:include page="/layout/html_head.jsp"></jsp:include>
<script type="text/javascript">

</script>
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
						<i class="im-table2"></i> 所有客户列表
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
								<form style="margin-top: 20px;" class="common-page-form" action="plat/customer/customerList.do" method="get">
									<input class="common-page-cur" type="hidden" name="c_cur" value="1"/> 
									<input class="common-page-order" type="hidden" name="c_od" value="${param.c_od }"/> 
									<input class="common-page-desc" type="hidden" name="c_desc" value="${param.c_desc }"/> 							
									<label>客户昵称：</label>
									<input type="text" name="nickname" value="${param.nickname }"/> 
									<label>客户电话：</label>
									<input type="text" name="mobile" value="${param.mobile }"/> 
									<label>客户邮箱：</label>
									<input type="text" name="email" value="${param.email }"/> 
									<label>客户性别：</label>
									<input type="radio" name="sex" value="1">男
									<input type="radio" name="sex" value="2">女
									<input type="submit" value="查询"/>
								</form>
								<a class="bike-add-button btn btn-primary btn-sm pull-right" href="plat/customer/customer.do?">添加</a>
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>
										    <th class="common-order-button" data-order="account" data-desc="">用户名</th>
											<th class="common-order-button" data-order="nickname" data-desc="">客户昵称</th>
											<th class="common-order-button" data-order="mobile" data-desc="">客户电话</th>
											<th class="common-order-button" data-order="email" data-desc="">客户邮箱</th>
											<th class="common-order-button" data-order="sex" data-desc="">客户性别</th>
											<th class="common-order-button" data-order="ctime" data-desc="">创建时间</th>
											<th class="common-order-button" data-desc="">操作</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data.list }" var="d">
											<tr class="odd gradeX">
											    <td>${d.account }</td>
												<td>${d.nickname }</td>
												<td>${d.mobile }</td>
												<td>${d.email }</td>
												<td>
												   <c:if test="${d.sex==1}">
												                   男
                                                   </c:if>
                                                   <c:if test="${d.sex==2}">
												                   女
                                                   </c:if>
												</td>
												<td>${d.ctime }</td>
												<td class="center" width="12%">
												   <a class="btn btn-primary btn-sm" href="plat/customer/customer.do?id=${d.id }">编辑</a>
												   <a class="btn btn-primary btn-sm" href="plat/customer/addressList.do?customerId=${d.id }">收货地址</a>|
												   <a class="btn btn-primary btn-sm" href="plat/customer/deleteCustomer.do?id=${d.id }">删除</a>
												   <a class="btn btn-primary btn-sm" href="plat/customer/cartList.do?customerId=${d.id }">购物车</a>
												</td>
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