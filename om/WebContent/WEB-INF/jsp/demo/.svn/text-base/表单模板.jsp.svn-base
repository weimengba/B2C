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
						<i class="im-checkbox-checked"></i> 添加Demo数据
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
								<h3 class="panel-title">Form fields</h3>
							</div>
							<div class="panel-body">
								<form class="form-horizontal group-border hover-stripped" role="form" id="validate">

									<div class="form-group">
										<label class="col-lg-2 control-label">digit</label>
										<div class="col-lg-10">
											<input type="text" name="digit" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-lg-2 control-label">必填内容</label>
										<div class="col-lg-10">
											<input type="text" name="name" class="form-control required">
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">邮件:</label>
										<div class="col-lg-10">
											<input id="email" name="email" type="email" class="form-control" placeholder="请输入你的邮箱">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">最小值13</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" name="minval" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">最大值13</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" name="maxval" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">密码：</label>
										<div class="col-lg-10">
											<input type="password" class="form-control" id="password" name="password" placeholder="Enter your password"> <input type="password"
												class="form-control mt15" id="confirm_password" name="confirm_passowrd" placeholder="Repeat password">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">最大长度10</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="maxLenght" name="maxLenght" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required range between 10-20 chars</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="rangelenght" name="rangelenght" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required with url validaiton</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="url" name="url" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required date</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="date" name="date" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required number</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="number" name="number" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required textarea</label>
										<div class="col-lg-10">
											<textarea class="form-control" name="textarea" id="textarea" rows="4"></textarea>
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required and accept credit card number</label>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="ccard" name="ccard" placeholder="">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required checkbox</label>
										<div class="col-lg-10">
											<label class="checkbox"> <input type="checkbox" name="agree" id="agree" value="option">agree terms ?
											</label>
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">文件上传:</label>
										<div class="col-lg-10">
											<input type="file" name="file" id="file" class="form-control">
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<label class="col-lg-2 control-label">Required select with filter</label>
										<div class="col-lg-10">
											<select class="form-control select2" name="select2" id="select2">
												<option value="">Choose</option>
												<optgroup label="Alaskan/Hawaiian Time Zone">
													<option value="AK">Alaska</option>
													<option value="HI">Hawaii</option>
												</optgroup>
												<optgroup label="Pacific Time Zone">
													<option value="CA">California</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
												</optgroup>
												<optgroup label="Mountain Time Zone">
													<option value="AZ">Arizona</option>
													<option value="CO">Colorado</option>
													<option value="ID">Idaho</option>
													<option value="MT">Montana</option>
													<option value="NE">Nebraska</option>
													<option value="NM">New Mexico</option>
													<option value="ND">North Dakota</option>
													<option value="UT">Utah</option>
													<option value="WY">Wyoming</option>
												</optgroup>
												<optgroup label="Central Time Zone">
													<option value="AL">Alabama</option>
													<option value="AR">Arkansas</option>
													<option value="IL">Illinois</option>
													<option value="IA">Iowa</option>
													<option value="KS">Kansas</option>
													<option value="KY">Kentucky</option>
													<option value="LA">Louisiana</option>
													<option value="MN">Minnesota</option>
													<option value="MS">Mississippi</option>
													<option value="MO">Missouri</option>
													<option value="OK">Oklahoma</option>
													<option value="SD">South Dakota</option>
													<option value="TX">Texas</option>
													<option value="TN">Tennessee</option>
													<option value="WI">Wisconsin</option>
												</optgroup>
												<optgroup label="Eastern Time Zone">
													<option value="CT">Connecticut</option>
													<option value="DE">Delaware</option>
													<option value="FL">Florida</option>
													<option value="GA">Georgia</option>
													<option value="IN">Indiana</option>
													<option value="ME">Maine</option>
													<option value="MD">Maryland</option>
													<option value="MA">Massachusetts</option>
													<option value="MI">Michigan</option>
													<option value="NH">New Hampshire</option>
													<option value="NJ">New Jersey</option>
													<option value="NY">New York</option>
													<option value="NC">North Carolina</option>
													<option value="OH">Ohio</option>
													<option value="PA">Pennsylvania</option>
													<option value="RI">Rhode Island</option>
													<option value="SC">South Carolina</option>
													<option value="VT">Vermont</option>
													<option value="VA">Virginia</option>
													<option value="WV">West Virginia</option>
												</optgroup>
											</select>
										</div>
									</div>
									<!-- End .form-group  -->
									<div class="form-group">
										<div class="col-lg-offset-2">
											<button class="btn btn-default ml15" type="submit">Test validation</button>
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