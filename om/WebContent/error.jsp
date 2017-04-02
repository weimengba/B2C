<%@ page language="java" import="com.alibaba.fastjson.*,com.util.*" contentType="text/html; charset=UTF-8" isErrorPage="true" pageEncoding="UTF-8"%>
<%
	//如果请求类型是Ajax的情况，不应该返回HTML错误页面。应该返回JSON错误信息。
	//需要检查请求类型。
	String type = request.getHeader("X-Requested-With");
    System.out.println("*************出错了："+type+"************");
	if ("XMLHttpRequest".equalsIgnoreCase(type)) {
		//输出AJAX错误
		response.setContentType("application/json;charset=UTF-8");
		AjaxMessage msg = new AjaxMessage();
		msg.setSuccess(1);
		msg.setMessage(exception.getMessage());
		out.write(JSON.toJSONString(msg));
	    System.out.println("*************出错了："+JSON.toJSONString(msg)+"************");
		out.clear();
		out = pageContext.pushBody();
	} else {
		
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	系统出错了！
	<br> 错误信息：<%
	out.println(exception);
%>
</body>
</html>
<%
	}
%>