<%@ page language="java" import="java.io.*,java.util.*" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="om"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

Enumeration<String> names = request.getParameterNames();
while(names.hasMoreElements()){
	String name = names.nextElement();
	System.out.println(name+":"+request.getParameter(name));
}
String echoStr = request.getParameter("echostr");
out.println(echoStr);
out.flush();

%>