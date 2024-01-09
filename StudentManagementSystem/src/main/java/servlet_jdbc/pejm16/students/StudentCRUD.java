package servlet_jdbc.pejm16.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCRUD {
	public Connection getConnection() throws Exception {
		// Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jdbc?user=root&password=root");
		return connection;
	}

	public int saveStudent(Student student) throws Exception {
		Connection connection = getConnection();
		
		// Create Statement
		String query = "INSERT INTO STUDENT VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getStudentName());
		preparedStatement.setString(3, student.getFatherName());
		preparedStatement.setString(4, student.getMotherName());
		preparedStatement.setInt(5, student.getAge());
		preparedStatement.setLong(6, student.getPhone());
		preparedStatement.setString(7, student.getEmail());
		preparedStatement.setString(8, student.getPassword());
		preparedStatement.setString(9, student.getSchool());
		preparedStatement.setLong(10, student.getFees());
		int count = preparedStatement.executeUpdate();
		
		connection.close();
		
		return count;
	}

	public Student loginStudtent(String email) throws Exception {
		Connection connection = getConnection();
		
		// Create Statement
		String query = "SELECT * FROM STUDENT WHERE EMAIL = ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Student student = new Student();
		
		while(resultSet.next()) {
			student.setPassword(resultSet.getString("password"));
			student.setSchool(resultSet.getString("school"));
		}
		connection.close();
		return student;
	}
}
