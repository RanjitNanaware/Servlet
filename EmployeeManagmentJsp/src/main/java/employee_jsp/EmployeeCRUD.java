package employee_jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_jsp?user=root&password=root");
		return connection;
	}

	public int saveEmployee(Employee employee) throws Exception {
		Connection connection = getConnection();
		String query = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());
		int result = preparedStatement.executeUpdate();
		
		connection.close();
		return result;
	}

	public Employee loginEmployee(String email) throws Exception {
		Connection connection = getConnection();
		String query = "SELECT * FROM EMPLOYEE WHERE EMAIL=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		Employee employee = new Employee();
		while(resultSet.next()) {
			employee.setName(resultSet.getString("name"));
			employee.setPassword(resultSet.getString("password"));
		}
		connection.close();
		return employee;
		
	}

	public List<Employee> getAllEmployee() throws Exception {
		Connection connection = getConnection();
		String query = "SELECT * FROM EMPLOYEE";
		
		PreparedStatement preparedStatement =connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<Employee> employees = new ArrayList<>();
		while(resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPhone(resultSet.getLong("phone"));
			employee.setAddress(resultSet.getString("address"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPassword(resultSet.getString("password"));
			
			employees.add(employee);
		}
		connection.close();
		return employees;
	}

	public int deleteEmployee(int id) throws Exception {
		Connection connection = getConnection();
		
		String query = "DELETE FROM EMPLOYEE WHERE ID=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}

	public int updateEmployee(Employee employee) throws Exception {
		Connection connection = getConnection();
		
		String query = "UPDATE EMPLOYEE SET NAME=?, PHONE=?, ADDRESS=?, EMAIL=?, PASSWORD=? WHERE ID=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6, employee.getId());
		
		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}

	public Employee getEmployeeById(int id) throws Exception {
		Connection connection = getConnection();
		String query = "SELECT * FROM EMPLOYEE";
		
		PreparedStatement preparedStatement =connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Employee employee = new Employee();
		while(resultSet.next()) {
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPhone(resultSet.getLong("phone"));
			employee.setAddress(resultSet.getString("address"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPassword(resultSet.getString("password"));
		}
		connection.close();
		return employee;
	}
}





