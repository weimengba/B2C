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
div {
	/* border: solid green; */
	/*text-align: center;*/
	margin-top: 1rem;
}

.form-control { /*width: 20rem;*/
	/*width: 100%;*/
	
}
</style>
</head>
<body>

	<script>
	

		/**
		 * Angular
		 */
		var app = angular.module('myApp', []);
		app
				.controller(
						'sssController',
						function($scope, $http) {
							var num = 1;

						 	//提交数据到后台。             
				            $scope.sssUploadData = function(data){
				            	var param = {};
				            	param.config = angular.toJson(data, true)
				                          	
				            	$http({  
				            	    method: 'post',  
				            	    url: 'plat/sys/setSysConfig.do',
				            	    data: param,  
				            	    headers:{'Content-Type': 'application/x-www-form-urlencoded'},    
				            	    transformRequest: function (data) {
				            	    	return $.param(data);
				            	    }
				            	}).then(function successCallback(response) {
				            	    alert('添加成功');    
				            	}, function errorCallback(response) {
				            	    alert('添加失败');
				            	});
				            };

				            //从后台去取出配置的数据。
				            $http.get('plat/sys/getSysConfig.do').success( function(res) {
				                $scope.sys = res; 
				            });
				            
							/**
							 * 添加系统设置
							 * @param data
							 */
							$scope.sssAddSysConfig = function(data) {
								if (angular.isUndefined(data.systemConfig)) {
									data.systemConfig = {};
								}
								data.systemConfig[data.globalConfigKey] = data.globalConfigValue
							};

							/**
							 * 删除系统设置
							 */
							$scope.sssDelSysConfig = function(data, key) {
								delete data[key];
							};

							/**
							 * 格式化显示Json数据
							 * @param data
							 */
							$scope.sssShowData = function(data) {
								alert(angular.toJson(data, true));
							};
						});
	</script>
	<div class="container" ng-app="myApp" ng-controller="sssController">
		<div class="row">
			<div class="col-xs-12 text-center">
				<h1>系统名称: {{sys.systemName}}</h1>
				<input ng-model="sys.systemName" class="form-control">
				<button ng-click="sssShowData(sys)" class="btn btn-info">显示系统数据</button>
				<button ng-click="sssUploadData(sys)" class="btn btn-info">上传</button>
			</div>
			<div class="col-xs-12">
				<div ng-repeat="(confKey,confValue) in sys.systemConfig" class="col-xs-12">
					{{$index+1}}, 系统设置Key: <input ng-model="confKey">系统设置Value:<input ng-model="confValue">
					<button ng-click="sssDelSysConfig(sys.systemConfig,confKey)" class="btn btn-info">删除</button>
				</div>
				<div class="col-xs-12">
					系统设置Key:<input ng-model="sys.globalConfigKey"> 系统设置Value:<input ng-model="sys.globalConfigValue">
					<button ng-click="sssAddSysConfig(sys)" class="btn btn-info">添加系统设置</button>
				</div>
			</div>
		</div>

	</div>
	</div>

</body>
</html>


<script>
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


<script>
	$(function() {
		//添加bootstrap样式。
	});
</script>