<%@page import="employee_jsp.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.cj.xdevapi.Table" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
<%
	String name = (String)request.getAttribute("cookie");
	if(name != null){
%>
<h2>Changed By <%=name %>  </h2>
<%
} 
%>
<%
	List<Employee>employees = (List)request.getAttribute("list");
%>
<table border="2px solid">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Phone</th>
	<th>Address</th>
	<th>Email</th>
	<th>Password</th>
</tr>
<% 
	for (Employee employee : employees)
	{
%>
<tr>
	<td><%=employee.getId() %></td>
	<td><%=employee.getName() %></td>
	<td><%=employee.getPhone() %></td>
	<td><%=employee.getAddress() %></td>
	<td><%=employee.getEmail() %></td>
	<td><%=employee.getPassword() %></td>
	<td><a href="delete?id=<%=employee.getId()%> "><button>Delete</button> </a></td>
	<td><a href="update?id=<%=employee.getId() %>"><button>Update</button> </a></td>
	
</tr>
<%
}
%>
</table>
</body>
</html>