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
	<title>Project Form</title>
</head>	
<body>
	<a href="<c:url value="/project/list"/>">Project List</a>
	<h1>Project Form</h1>
	<form:form modelAttribute="project" action="create" method="post">
		<p>
			<form:label path="name" cssErrorClass="error">Name</form:label><br/>
			<form:input path="name"/><form:errors path="name"/><br/>
		</p>
		<input type="submit"/>
	</form:form>
</body>
</html>