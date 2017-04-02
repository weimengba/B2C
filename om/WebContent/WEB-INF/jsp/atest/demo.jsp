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
<title>测试Demo</title>
</head>
<body>
	文件上传
	<form action="demo/addDemo.do" method="post">
		<div>
			<label>姓名：</label><input type="text" name="name">
		</div>
		<div>
			<label>学校：</label><input type="text" name="school">
		</div>
		<div>
			<label>地址：</label><input type="text" name="address">
		</div>
		<div>
			<label>年龄：</label><input type="text" name="age">
		</div>
		<input type="submit" value="提交">
	</form>
</body>
</html>