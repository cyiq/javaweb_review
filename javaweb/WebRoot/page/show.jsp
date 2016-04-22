<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>page</title>
  </head>
  <body>
    <h1>分页</h1>
    <c:forEach items="${datas}" var="data" varStatus="idx">
		${idx.count}  * ${data.id},${data.name},${data.age}   <br/>
    </c:forEach>
    <hr/>
    <c:choose>
    	<c:when test="${currentPage==1}">
	    </c:when>
	    <c:otherwise>
	    	<a href="<c:url value='/pageServlet?page=${currentPage-1}'/>">上一页</a>
	    </c:otherwise>
    </c:choose>
    <c:forEach begin="${startNo}" end="${endNo}" var="page">
    	<c:choose>
	    	<c:when test="${page == currentPage}">
				<font color="orange">[${page}]</font>
	    	</c:when>
	    	<c:otherwise>
				<a href="<c:url value='/pageServlet?page=${page}'/>" >[${page}]</a>  	
	    	</c:otherwise>
    	</c:choose>
    </c:forEach>
    
     <c:choose>
    	<c:when test="${currentPage==pageCount}">
	    </c:when>
	    <c:otherwise>
	    	<a href="<c:url value='/pageServlet?page=${currentPage+1}'/>">下一页</a>
	    </c:otherwise>
    </c:choose>
  </body>
</html>
