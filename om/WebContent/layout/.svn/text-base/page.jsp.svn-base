<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table>
	<tfoot>
		<tr>
			<th style="text-align: right;">
				<ul class="pagination">
					<li><a href="#" data-cur="1" class="common-page-button">首页</a></li>
					<li><a href="#" data-cur="${data.prePage }" class="common-page-button">《</a></li>
					<c:forEach items="${data.navigatepageNums }" var="d">
						<li <c:if test="${param.c_cur == d }">class="active"</c:if>><a href="#" data-cur="${d }" class="common-page-button">${d }</a></li>
					</c:forEach>
					<li><a href="#" data-cur="${data.nextPage }" class="common-page-button">》</a></li>
					<li><a href="#" data-cur="${data.lastPage }" class="common-page-button">尾页</a></li>
				</ul>
			</th>
		</tr>
	</tfoot>
</table>