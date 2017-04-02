<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试Goods</title>
</head>
<body>
	添加Goods表单
	<form action="goods/addGoods.do" method="get">
		<div>
			<label>分类ID：</label><input type="text" name="categoryId">
		</div>
		<div>
			<label>类别ID：</label><input type="text" name="typeId">
		</div>
		<div>
			<label>商品名称：</label><input type="text" name="title">
		</div>
		<div>
			<label>平台售价：</label><input type="text" name="price">
		</div>
		<div>
			<label>市场价：</label><input type="text" name="marketPrice">
		</div>
		<div>
			<label>商品库存：</label><input type="text" name="quantity">
		</div>
		<div>
			<label>销售数量：</label><input type="text" name="num">
		</div>
		<div>
			<label>商品简述：</label><input type="text" name="brief">
		</div>
		<div>
			<label>商品详情：</label><input type="text" name="detail">
		</div>
		<input type="submit" value="提交">
	</form>
</body>
</html>