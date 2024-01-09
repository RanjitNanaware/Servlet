<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<style>
	#frm{
		width:500px;
		margin:auto;
		margin-top:100px;
	}
	marquee{
		margin-top: 10px;
	}
</style>
</head>
<body class="container-fluid">
<% String message =(String) request.getAttribute("message");
if(message != null)
{
%>
<h2><%= message %></h2>
<%} %>
	<marquee class="text-primary"><h2>Login Form</h2></marquee>
	<form action="login" method="post" class="form card" id="frm">
		<h2 class="bg-danger text-white card-header">Login Form</h2>
		<table class="table table-hover">
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" required></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="number" name="password" required></td>
		</tr>
		<tr>
			<td><button type="submit" class="btn btn-outline-success">Login</button></td>
		</tr>
		</table>
	</form>
</body>
</html>