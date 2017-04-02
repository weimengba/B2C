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
						<i class="im-notebook"></i> 日志列表
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
								<form style="margin-top: 20px;" class="common-page-form" action="plat/common/logList.do" method="get">
									<input class="common-page-cur" type="hidden" name="c_cur" value="1"/> 
									<input class="common-page-order" type="hidden" name="c_od" value="${param.c_od }"/> 
									<input class="common-page-desc" type="hidden" name="c_desc" value="${param.c_desc }"/> 							
									<label>类别：</label>
									<input type="text" name="type" value="${param.type }"/> 
									<label>操作人ID：</label>
									<input type="text" name="operatorId" value="${param.operatorId }"/> 
									<input type="submit" value="查询"/>
								</form>
								
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>
										    <th class="common-order-button" data-order="type" data-desc="">类别</th>
											<th class="common-order-button" data-order="operatorId" data-desc="">操作人ID</th>
											<th class="common-order-button" data-order="operatorType" data-desc="">操作人类别</th>
											<th class="common-order-button" data-order="operatorTime" data-desc="">操作时间</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data.list }" var="d">
											<tr class="odd gradeX">
											    <td>${d.type }</td>
												<td>${d.operatorId }</td>
												<td>${d.operatorType }</td>
												<td>${d.operatorTime }</td>
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