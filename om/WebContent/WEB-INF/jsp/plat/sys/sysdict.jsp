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
div { /* border: solid green; */
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
    app.controller('sssController', function ($scope, $http) {
        var num = 1;

      //提交数据到后台。             
        $scope.sssUploadData = function(data){
        	var param = {};
        	param.config = angular.toJson(data, true)
                      	
        	$http({  
        	    method: 'post',  
        	    url: 'plat/sys/setSysDict.do',
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
        $http.get('plat/sys/getSysDict.do').success( function(res) {
            $scope.sys = res; 
        });
        
        
        /**
         * 添加字典分类
         * @param data
         */
        $scope.sssAddDictionaryType = function (data) {
            if (angular.isUndefined(data.dictionary)) {
                data.dictionary = {};
            }
            data.dictionary[data.globalDictType] = {};
        };

        /**
         * 添加字典
         * @param data
         */
        $scope.sssAddDictionaryData = function (sys, data) {
            if (angular.isUndefined(data)) {
                data = {};
            }
            data[sys.globalDictValue] = sys.globalDictName;
        };

        /**
         * 删除字典
         */
        $scope.sssDelDictionaryData = function (dict, key) {
            delete dict[key];
        };

        /**
         * 格式化显示Json数据
         * @param data
         */
        $scope.sssShowData = function (data) {
            alert(angular.toJson(data, true));
        };
    });

</script>
<div class="container" ng-app="myApp" ng-controller="sssController">
    <div class="row">
        <div class="col-xs-12 text-center">
            <h1>系统名称: {{sys.systemName}}</h1><input ng-model="sys.systemName" class="form-control">
            <button ng-click="sssShowData(sys)" class="btn btn-info">显示系统数据</button>
            <button ng-click="sssUploadData(sys)" class="btn btn-info">上传</button>
        </div>
        <div class="col-xs-12">
            <div ng-repeat="(dictType,dictTypeValues) in sys.dictionary" class="col-xs-12">
                {{$index+1}}, 字典分类名称: <input ng-model="dictType">

                <div ng-repeat="(key,value) in dictTypeValues" class="col-xs-12">
                    <p>字典值：{{key}} 字典名：<input ng-model="value">
                        <button ng-click="sssDelDictionaryData(dictTypeValues,key)" class="btn btn-info">删除</button>
                    </p>
                </div>

                <div class="col-xs-12">
                    字典值:<input ng-model="sys.globalDictValue">
                    字典名:<input ng-model="sys.globalDictName">
                    <button ng-click="sssAddDictionaryData(sys,dictTypeValues)" class="btn btn-info">添加字典</button>
                </div>
            </div>
            <button ng-click="sssAddDictionaryType(sys)" class="btn btn-info">添加字典分类</button>

            字典分类:<input ng-model="sys.globalDictType">
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
            return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
        }

        return (S4() + S4() + S4() + S4() + S4() + S4() + S4() + S4());
    }
</script>


<script>
    $(function () {
        //添加bootstrap样式。
    });
</script>