<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/public/css/app.css"/>">
	<title>Address List</title>
</head>	
<body>
	<h1>Address List</h1>
	<table class="container">
		<tr>
			<th>Name</th>
			<th>Postcode</th>
			<th>Address</th>
		</tr>
		<c:forEach var="person" items="${people}">
		<tr>
			<td>${person.name}</td>
			<td>${person.postcode}</td>
			<td>${person.address}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>