<%@ page language="java" import="java.io.*,java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.reset(); 
	response.setContentType("image/jpeg");

	String path = request.getParameter("path");
	String dir = "D:/upload/";
	InputStream is = new FileInputStream(dir + path);
	OutputStream os = response.getOutputStream();
	byte[] buf = new byte[1024];
	int num = 0;
	while (true) {
		num = is.read(buf);
		if (num == -1) {
			break;
		}
		os.write(buf, 0, num);
	}
	is.close();
	os.flush();
	out.clear();  
	out = pageContext.pushBody();  
%>
