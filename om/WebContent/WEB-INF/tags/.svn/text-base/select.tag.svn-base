<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" body-content="empty"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ attribute name="name" rtexprvalue="true" required="true"%>
<%@ attribute name="value" rtexprvalue="true" required="false"%>
<%@ attribute name="dictName" rtexprvalue="true" required="true"%>

<select name="${name }" class="form-control">
	<c:forEach items="${sys_dict[dictName] }" var="d">
		<option value="${d.key }" <c:if test="${d.key == value}">selected="selected"</c:if>>${d.value }</option>
	</c:forEach>
</select>
