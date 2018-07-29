<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border:1px solid #ccc;
	}
	table tr{
		border:1px solid #ccc;
	}
	table tr td{
		border:1px solid #ccc;
	}
</style>
</head>
<body>
	<c:if test="${!empty list }">
		<table>
			<tr>
				<td>商品名</td>
				<td>类别</td>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td><c:out value="${item.name }"></c:out></td>
					<td><c:out value="${item.level }"></c:out></td>
				<tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>