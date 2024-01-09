package com.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {
	
	public Connection getConnection() throws Exception {
		// Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jdbc?user=root&password=root");
		return connection;
	}
	
	public void savePerson(Person person) throws Exception {
		Connection connection = getConnection();
		
		// Execute Query
		String query = "INSERT INTO PERSON(ID,NAME,PHONE,EMAIL,PASSWORD) VALUES (?,?,?,?,?)";
		
		// Create Statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setString(5, person.getPassword());
		preparedStatement.executeUpdate();
		
		//Close Connection
		connection.close();
	}

	public void UpdatePerson(Person person) throws Exception {
		Connection connection = getConnection();
		
		// Execute Query
		String query = "UPDATE PERSON SET NAME=?, PHONE=?, EMAIL=?, PASSWORD=? WHERE ID=?";
		
		// Create Statement
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, person.getName());
		prepareStatement.setLong(2, person.getPhone());
		prepareStatement.setString(3, person.getEmail());
		prepareStatement.setString(4, person.getPassword());
		prepareStatement.setInt(5, person.getId());
		prepareStatement.executeUpdate();
		
		//Close Connection
		connection.close();
	}

	public void DeletePerson(int id) throws Exception {
		Connection connection = getConnection();
		
		// Execute Query
		String query = "DELETE FROM PERSON WHERE ID = ?";
		
		// Create Statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		
		// Close Connection
		connection.close();
		
	}

	public String loginPerson(String email) throws Exception {
		Connection connection = getConnection();
		
		// Execute Query
		String query = "SELECT * FROM PERSON WHERE EMAIL = ?";
		
		// Create Statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null ;
		
		while(resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		return password;
	}
}








