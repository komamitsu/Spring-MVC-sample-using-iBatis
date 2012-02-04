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
	<title>Project List</title>
</head>	
<body>
	<a href="<c:url value="/project/new"/>">Create new project</a>
	<h1>Project List</h1>
	<table class="container">
		<tr>
			<th>Name</th>
		</tr>
		<c:forEach var="project" items="${projects}">
		<tr>
			<td>${project.name}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>