<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="validate.js"></script>
</head>
<body>
<center><b>Login Form</b><br><br>
<!--<form action="LogServlet" method="post">  -->
<div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <p>Please enter your credentials to login.</p>
          </div>
        </div>
<form action="LogServlet" method="post" class="login-form">

	Email<input type="text" name="email" required placeholder="Enter your email"/>
	Password<input type="text" name="pwd" required placeholder="Enter your password"/>
	
<td><center><input type="submit" value="login" onClick=" ValidateEmail()"></center></td>
</table>
<br><br>
<a href="index.jsp">Go Back To Home Page</a><br><br><br><br>
<a href="reg.html">Click Here To Register</a>
</form>
</center>
</body>
</html>