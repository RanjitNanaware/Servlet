<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
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
		<marquee class="text-primary"><h2>SignUp Form</h2></marquee>
	<form action="save" method="post" class="form card" id="frm">
		<h2 class="bg-danger text-white card-header">Employee SignUp Form</h2>
		<table class="table table-hover">
		<tr>
			<td>Id</td>
			<td><input type="number" name="id" required></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td>phone</td>
			<td><input type="number" name="phone" required></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><input type="text" name="address" required></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" required></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="number" name="password" required></td>
		</tr>
		<tr>
			<td><button type="submit" class="btn btn-outline-success">SignUp</button></td>
			<td><button type="reset" class="btn btn-outline-danger">Cancel</button></td>
		</tr>
		</table>
	</form>
</body>
</html>