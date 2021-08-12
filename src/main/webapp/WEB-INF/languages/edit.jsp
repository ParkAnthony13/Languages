<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h1>Edit Language</h1>
			<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
			    <input type="hidden" name="_method" value="put">
			    <p>
			        <form:label path="name">Name</form:label>
			        <form:errors path="name" style="color:red;"/>
			        <form:input path="name"/>
			    </p>
			    <p>
			        <form:label path="creator">Creator</form:label>
			        <form:errors path="creator" style="color:red;"/>
			        <form:textarea path="creator"/>
			    </p>
			    <p>
			        <form:label path="version">Version</form:label>
			        <form:errors path="version" style="color:red;"/>
			        <form:input path="version"/>
			    </p>

			    <input type="submit" value="Submit"/>
			</form:form>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>