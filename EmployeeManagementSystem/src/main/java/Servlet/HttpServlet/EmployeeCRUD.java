package Servlet.HttpServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeCRUD {
	
	public Connection getConnection() throws Exception {
		// Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_employee?user=root&password=root");
		return connection;
		
	}

	public void AddEmployee(Employee employee) throws Exception {
		// get connection
		Connection connection = getConnection();
		
		// Create Statement
		String query = "INSERT INTO EMPLOYEE(ID,NAME,PHONE,ADDRESS,EMAIL,PASSWORD) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, employee.getId());
		prepareStatement.setString(2, employee.getName());
		prepareStatement.setLong(3, employee.getPhone());
		prepareStatement.setString(4, employee.getAddress());
		prepareStatement.setString(5, employee.getEmail());
		prepareStatement.setString(6, employee.getPassword());
		prepareStatement.executeUpdate();
		
		// Close Connection
		connection.close();
	}

	public void UpdateEmployee(Employee employee) throws Exception {
		// get Connection
		Connection connection = getConnection();
		
		// Create Statement
		String query = "UPDATE EMPLOYEE SET NAME=?, PHONE=?, ADDRESS=?, EMAIL=?, PASSWORD=? WHERE ID = ?";
		
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, employee.getName());
		prepareStatement.setLong(2, employee.getPhone());
		prepareStatement.setString(3, employee.getAddress());
		prepareStatement.setString(4, employee.getEmail());
		prepareStatement.setString(5, employee.getPassword());
		prepareStatement.setInt(6, employee.getId());
		
		prepareStatement.executeUpdate();
		
		// Close Connection
		connection.close();
	}

	public void DeleteEmployee(int id) throws Exception {
		// get Connection
		Connection connection = getConnection();
		
		// Create Statement
		String query = "DELETE FROM EMPLOYEE WHERE ID=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		preparedStatement.executeUpdate();
		
		// Close Connection
		connection.close();
	}

	public String LoginEmployee(String email) throws Exception {
		// get Connection 
		Connection connection = getConnection();
		
		// Create Statement
		String query = "SELECT * FROM EMPLOYEE WHERE EMAIL=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		
		while(resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		
		return password;
	}
}







