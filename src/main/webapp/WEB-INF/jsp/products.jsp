<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.code}"></c:out></td>
				<td><c:out value="${product.name}"></c:out></td>
				<td><c:out value="${product.type}"></c:out></td>
				<td><c:out value="${product.price}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>