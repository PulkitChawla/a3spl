<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%
	session.invalidate();
%>
<p>You have been successfully logout</p>
<a href="index.jsp">Home Page</a>
</body>
</html>