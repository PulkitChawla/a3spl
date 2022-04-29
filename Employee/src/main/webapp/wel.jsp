<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 //session.getAttribute("currentUser");
String name=(String)session.getAttribute("currentUser"); 
out.print("Welcome "+name); 
%>
<a href="logout.jsp">Logout</a>
<a href="index.jsp">Go back to index</a>
</body>
</html>