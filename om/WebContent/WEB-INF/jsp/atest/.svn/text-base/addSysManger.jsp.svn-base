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
<title>Insert title here</title>
</head>
<body>
	<form action="sys/addsys.do" method="post">
		<div>
			<label>姓名：</label><input type="text" name="name">
		</div>
		<div>
			<label>账号：</label><input type="text" name="account">
		</div>
		<div>
			<label>密码：</label><input type="text" name="password">
		</div>
		<div>
			<label>电话：</label><input type="text" name="mobile">
		</div>
		<div>
			<label>邮箱：</label><input type="text" name="email">
		</div>
		<input type="submit" value="提交">
	</form>
</body>
</html>