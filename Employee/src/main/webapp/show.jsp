<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,emp.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Records</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<center>
<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>Name</td>
<td>Email</td>
<td>City</td>
<td>State</td>
<td>Gender</td>
<td>Country</td>
<!-- <td>Edit</td>
<td>Delete</td> -->
<%
try{
	Connection con=DbConn.getConn();
	PreparedStatement ps=con.prepareStatement("select * from reg");

ResultSet rs = ps.executeQuery();
while(rs.next()){
%>
<tr>
<td><%=rs.getString("name") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getString("city") %></td>
<td><%=rs.getString("state") %></td>
<td><%=rs.getString("gender") %></td>
<td><%=rs.getString("coun") %></td>
<%-- <td><a href="edit.jsp?name=<%=rs.getString(1)%>">Edit</a></td>
<td><a href="delete.jsp?name=<%=rs.getString(1)%>">Delete</a></td> --%>
</tr>
<%
}
con.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
<a href="index.jsp">Go Back To Home Page</a>
</center>
</body>
</html>