<%@page import="employee_jsp.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
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

<%
	Employee employee = (Employee)request.getAttribute("emp");
%>

	<marquee class="text-primary"><h2>Update Form</h2></marquee>
	<form action="edit" method="post" class="form card" id="frm">
		<h2 class="bg-danger text-white card-header">Employee Update Form</h2>
		<table class="table table-hover">
		<tr>
			<td>Id</td>
			<td><input type="hidden" name="id" value=<%= employee.getId()%> readonly="true"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value=<%= employee.getName() %>></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><input type="number" name="phone" value=<%= employee.getPhone() %>></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="address" value=<%=employee.getAddress() %> ></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value=<%= employee.getEmail() %>></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="number" name="password" value=<%= employee.getPassword() %> ></td>
		</tr>
		<tr>
			<td><button type="submit" class="btn btn-outline-success">Update</button></td>
		</tr>
		</table>
	</form>
</body>
</html>