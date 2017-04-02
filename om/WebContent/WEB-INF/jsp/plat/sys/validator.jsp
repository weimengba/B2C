<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>SSS(Software's System)——使用json描述参数验证</title>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--   <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/angular.js/1.5.8/angular.js"></script>
 -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<script src="assets/js/jquery-1.8.3.min.js"></script>
<script src="assets/js/bootstrap/bootstrap.js"></script>
<script src="assets/js/angular/angular.min.js"></script>

<style>
.panel-group {
	margin-bottom: 4px;
}

.modal-content {
	border-radius: 10px;
}

.modal-header {
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}

.modal-footer {
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
}

.form-control {
	margin-bottom: 4px;
}

table tr:nth-child(odd) {
	background-color: #ffffff;
}

table tr:nth-child(even) {
	background-color: #e1e1e1;
}
</style>

<script>
	/**
	 * 参数域类型
	 * */
	var fieldType = {
		'int' : "整数",
		'double' : "浮点数",
		'string' : "字符串",
		'date' : "日期",
		'datetime' : "日期时间",
		'text' : "大文本",
	};

	/**
	 * 字符串验证器
	 * */
	var stringValidator = {
		'email' : "邮箱",
		'mobile' : "手机号",
		'phone' : "固定电话",
		'url' : "URL",
		'expression' : "表达式验证",
	};
	/**
	 * 主键类型
	 * */
	var keyType = {
		0 : "自增",
		1 : "UUID",
		2 : "程序生成",
	};
	/**
	 * Angular
	 */
	var app = angular.module('myApp', []);
	app.controller('sssController', function($scope, $http) {
		$scope.fieldType = fieldType;
		$scope.stringValidator = stringValidator;

		$scope.sssAddValidator = sssAddValidator;
		$scope.sssAddField = sssAddField;
		$scope.sssMoveField = sssMoveField;
		$scope.sssShowData = sssShowData;
		$scope.sssDeleteObjectData = sssDeleteObjectData;
		$scope.sssDeleteArrayData = sssDeleteArrayData;

		//提交数据到后台。             
		$scope.sssUploadData = function(data) {
			var param = {};
			param.config = angular.toJson(data, true)

			$http({
				method : 'post',
				url : 'plat/sys/setValidateData.do',
				data : param,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				},
				transformRequest : function(data) {
					return $.param(data);
				}
			}).then(function successCallback(response) {
				alert('添加成功');
			}, function errorCallback(response) {
				alert('添加失败');
			});
		};

		//从后台去取出配置的数据。
		$http.get('plat/sys/getValidateData.do').success(function(res) {
			$scope.system = res;
		});
	});

	/**
	 * 添加参数验证
	 */
	function sssAddValidator(system) {
		if (angular.isUndefined(system.validators)) {
			system.validators = [];
		}
		var val = {
			//uuid: guid(),
			name : "资源" + (system.validators.length + 1),
			uri : "/***.do",
			comment : "注释"
		};
		system.validators.push(val);
	}
	/**
	 * 添加域
	 * @param data
	 */
	function sssAddField(data) {
		var fields = data.fields;
		if (angular.isUndefined(fields)) {
			fields = [];
			data.fields = fields;
		}
		var field_num = data.fields.length + 1;
		var field = {
			//uuid: guid(),
			order : field_num,
			name : "名称" + field_num,
			code : "field" + field_num,
			type : "string",
			comment : "注释",
			mustVal : true,
			mustFill : true,
			isArray : false,
		};
		fields.push(field);
	}

	/**
	 * 移动的域
	 * @param data
	 */
	function sssMoveField(val, field, move) {
		var newOrder = field.order + move;
		angular.forEach(val.fields, function(f, index, array) {
			if (f.order == newOrder) {
				f.order = field.order;
				field.order = newOrder;
				return;
			}
		});
	}
	/**
	 * 根据index从数组中删除对象
	 */
	function sssDeleteArrayData(arrayObj, index) {
		if (confirm("确定删除吗！"))
			arrayObj.splice(index, 1);
	}
	/**
	 * 根据Key删除对象
	 */
	function sssDeleteObjectData(obj, key) {
		if (confirm("确定删除吗！"))
			delete obj[key];
	}
	/**
	 * 格式化显示Json数据
	 * @param data
	 */
	function sssShowData(data) {
		$('#showSSSJsonCode').html(angular.toJson(data, true));
		$('#sssModalData').modal();
	}

	/**
	 * 生成GUID
	 * @returns {string}
	 */
	function guid() {
		function S4() {
			return (((1 + Math.random()) * 0x10000) | 0).toString(16)
					.substring(1);
		}

		return (S4() + S4() + S4() + S4() + S4() + S4() + S4() + S4());
	}
</script>
</head>

<body>
	<div class="container-fluid col-xs-12" ng-app="myApp" ng-controller="sssController">
		<div class="row">
			<div class="col-xs-12 ">
				<h1 class="text-center">系统名称: {{system.systemName}}</h1>
				<form class="form-inline text-center">
					系统名称:<input ng-model="system.systemName" class="form-control" style="width: 16rem;">
				</form>
			</div>
			<div class="col-xs-12 text-center">
				<h3 class="text-center">URI统一规范</h3>
				<textarea ng-model="system.urlConventions" class="form-control center-block" style="width: 80%;" rows="3"></textarea>
			</div>
			<div class="col-xs-12 ">
				<div ng-repeat="val in system.validators" class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<div class="panel panel-primary">
						<div class="panel-heading clearfix" role="tab" id="heading{{$index+1}}">
							<h4 class="panel-title text-center">

								<a class="pull-left" data-toggle="collapse" href="#collapse{{$index+1}}"> 验证{{$index+1}}&nbsp;&nbsp;{{val.name}}&nbsp;&nbsp;URI:{{val.uri}} </a>
							</h4>
							<button class="btn btn-info btn-xs pull-right" ng-click="sssDeleteArrayData(system.validators,$index)">删除</button>
						</div>
						<div id="collapse{{$index+1}}" class="panel-collapse collapse">
							<div class="panel-body">
								<form class="form-inline">
									<div class="form-group form-group-sm">
										<label>资源:</label> <input ng-model="val.name" type="text" class="form-control">
									</div>
									<div class="form-group form-group-sm">
										<label>URI:</label> <input ng-model="val.uri" type="text" class="form-control">
									</div>
									<div class="form-group">
										<label>注释:</label> <input ng-model="val.comment" type="text" class="form-control" style="width: 60rem;">
									</div>
									<div>
										<table class="table table-bordered table-condensed table-hover">
											<colgroup>
												<col style="width: 5%;">
												<col style="width: 20%;">
												<col style="width: 20%;">
												<col style="width: 20%;">
												<col style="width: 10%;">
											</colgroup>
											<thead>
												<tr>
													<td>序号</td>
													<td>域</td>
													<td>验证器</td>
													<td>注释</td>
													<td>操作</td>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat="field in val.fields | orderBy:'order'">
													<td>{{$index+1}}</td>
													<td>
														<div>
															<label> 域:</label><input ng-model="field.name" type="text" class="form-control">
														</div>
														<div>
															<label>代码:</label><input ng-model="field.code" type="text" class="form-control">
														</div>
														<div>
															<label>类型:</label><select ng-model="field.type" ng-options="k as v for (k,v) in fieldType" class="form-control"></select>
														</div>
													</td>
													<td>
														<div>
															<label>验证与否:</label> <input ng-model="field.mustVal" type="checkbox" alt="默认为需要验证">
														</div>
														<div>
															<label>是数组么:</label> <input ng-model="field.isArray" type="checkbox" alt="是否是数组参数">
														</div>
														<div>
															<label>必填:</label> <input ng-model="field.mustFill" type="checkbox" alt="默认为必填">
														</div>
														<div ng-show="field.type == 'int' || field.type == 'double' || field.type == 'string' || field.type == 'text'">
															<label>Min:</label> <input ng-model="field.min" ng-disabled="field.type == 4 || column.type == 5" type="number" class="form-control"
																style="width: 6rem;"> <label>Max:</label> <input ng-model="field.max" ng-disabled="field.type == 4 || column.type == 5" type="number"
																class="form-control" style="width: 6rem;">
														</div>
														<div ng-show="field.type == 'string' || field.type == 'text'">
															<label>字符串验证器</label> <select ng-model="field.stringValidator" ng-options="k as v for (k,v) in stringValidator" class="form-control"></select>
														</div>
														<div ng-show="field.stringValidator == 'expression'">
															<label>表达式: </label><input ng-model="field.max" ng-disabled="field.type == 4 || column.type == 5" type="text" class="form-control">
														</div>
													</td>
													<td><input ng-model="field.comment" class="form-control"></td>
													<td><a class="btn btn-info btn-xs" ng-click="sssMoveField(val,field,-1)" title="上移"><span class="glyphicon glyphicon-circle-arrow-up"></span>
													</a> <a class="btn btn-info btn-xs" ng-click="sssMoveField(val,field,1)" title="下移"><span class="glyphicon glyphicon-circle-arrow-down"></span> </a> <a
														class="btn btn-info btn-xs" ng-click="sssDeleteArrayData(val.fields,$index)" title="删除"> 删除 </a></td>
												</tr>
											</tbody>
										</table>
										<div class="col-xs-12 ">
											<button class="btn btn-info btn-xs" ng-click="sssAddField(val)">添加域</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 text-center">
				<button ng-click="sssAddValidator(system)" class="btn btn-info">添加验证</button>
				<button ng-click="sssShowData(system)" class="btn btn-info">显示数据</button>
				<button ng-click="sssUploadData(system)" class="btn btn-info">上传</button>
			</div>
		</div>
	</div>

	<!-- 模态框 -->
	<div class="modal fade" id="sssModalData" tabindex="-1" role="dialog" aria-labelledby="sssModalDataLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only text-danger">Close</span>
					</button>
					<h4 class="modal-title" id="sssModalDataLabel">系统模型json数据</h4>
				</div>
				<div class="modal-body">
					<xmp id="showSSSJsonCode" style="height: 24em;overflow-y: scroll;"> </xmp>
				</div>
				<div class="modal-footer bg-primary">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
