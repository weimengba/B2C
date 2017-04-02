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
						<i class="im-table2"></i> Goods图片测试表格
					</h1>
					<!-- Start .bredcrumb -->
					<ul id="crumb" class="breadcrumb">
					</ul>
					<!-- End .breadcrumb -->
					<!-- Start .option-buttons -->
					<div class="option-buttons">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group">
								<a id="clear-localstorage" class="btn tip" title="Reset panels position"> <i class="ec-refresh color-red s24"></i>
								</a>
							</div>
							<div class="btn-group dropdown">
								<a class="btn dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1"><i class="br-grid s24"></i></a>
								<div class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu1">
									<div class="option-dropdown">
										<div class="shortcut-button">
											<a href="#"> <i class="im-pie"></i> <span>Earning Stats</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="ec-images color-dark"></i> <span>Gallery</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="en-light-bulb color-orange"></i> <span>Fresh ideas</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="ec-link color-blue"></i> <span>Links</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="ec-support color-red"></i> <span>Support</span>
											</a>
										</div>
										<div class="shortcut-button">
											<a href="#"> <i class="st-lock color-teal"></i> <span>Lock area</span>
											</a>
										</div>
									</div>
								</div>
							</div>
							<div class="btn-group dropdown">
								<a class="btn dropdown-toggle" data-toggle="dropdown" id="dropdownMenu2"><i class="ec-pencil s24"></i></a>
								<div class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2">
									<div class="option-dropdown">
										<div class="row">
											<p class="col-lg-12">Quick post</p>
											<form class="form-horizontal" role="form">
												<div class="form-group">
													<div class="col-lg-12">
														<input type="text" class="form-control" placeholder="Enter title">
													</div>
												</div>
												<!-- End .form-group  -->
												<div class="form-group">
													<div class="col-lg-12">
														<textarea class="form-control wysiwyg" placeholder="Enter text"></textarea>
													</div>
												</div>
												<!-- End .form-group  -->
												<div class="form-group">
													<div class="col-lg-12">
														<input type="text" class="form-control tags1" placeholder="Enter tags">
													</div>
												</div>
												<!-- End .form-group  -->
												<div class="form-group">
													<div class="col-lg-12">
														<button class="btn btn-default btn-xs">Save Draft</button>
														<button class="btn btn-success btn-xs pull-right">Publish</button>
													</div>
												</div>
												<!-- End .form-group  -->
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="btn-group">
								<a class="btn dropdown-toggle" data-toggle="dropdown" id="dropdownMenu3"><i class="ec-help s24"></i></a>
								<div class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu3">
									<div class="option-dropdown">
										<p>
											First time visitor ? <a href="#" id="app-tour" class="btn btn-success ml15">Take app tour</a>
										</p>
										<hr>
										<p>
											Or check the <a href="#" class="btn btn-danger ml15">FAQ</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End .option-buttons -->
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
								<h4 class="panel-title">Goods图片表格</h4>
								<a class="bike-add-button btn btn-primary btn-sm" href="demo/addDemo.do">添加</a>
							</div>
							<div class="panel-body">
								<table class="table display table-bordered table-hover table-striped table-condensed" id="datatable">
									<thead>
										<tr>

											<th>文件名</th>
											<th>原始名</th>
											<th>文件类型</th>
											<th>操作</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${data }" var="d">
											<tr class="odd gradeX">
												<td>${d.fileName }</td>
												<td>${d.oldName }</td>
												<td>${d.path }</td>
												<td class="center" width="12%"><a class="btn btn-primary btn-sm" href="plat/common/row.do?c_tb=goods&id=${d.id }">编辑</a>|<a class="btn btn-primary btn-sm" href="plat/common/delete.do?c_tb=goods&id=${d.id }">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th colspan="7" style="text-align: right;">
												<ul class="pagination">
													<li><a href="demo/tablepage.do?cur=1">首页</a></li>
													<li><a href="demo/tablepage.do?cur=${datas.prePage }">《</a></li>
													<c:forEach items="${datas.navigatepageNums }" var="d">
														<li <c:if test="${datas.pageNum == d }">class="active"</c:if>><a href="demo/tablepage.do?cur=${d }"">${d }</a></li>
													</c:forEach>
													<li><a href="demo/tablepage.do?cur=${datas.nextPage }">》</a></li>
													<li><a href="demo/tablepage.do?cur=${datas.pages }">尾页</a></li>
												</ul>
											</th>
										</tr>
									</tfoot>
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

	<!-- End #content -->
	<jsp:include page="/layout/body_end.jsp"></jsp:include>
</body>
</html>