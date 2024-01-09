package Servlet_Jdbc_Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductCRUD {

	public int saveProduct(Product product) throws Exception {
		// Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection
		String url = "jdbc:mysql://localhost:3306/servlet_jdbc?user=root&password=root";
		Connection connection = DriverManager.getConnection(url);
		
		// Create Statement
		String query = "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getBrand());
		preparedStatement.setDouble(4, product.getPrice());
		preparedStatement.setString(5, product.getManufacturer());
		preparedStatement.setString(6, product.getState());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
}