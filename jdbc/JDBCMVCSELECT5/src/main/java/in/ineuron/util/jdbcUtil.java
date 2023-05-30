package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.*;
public class jdbcUtil {

	static {
		//load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException,IOException{
				// Take the data from properties file
				FileInputStream fis = new FileInputStream("K:\\ASSIGNMENTS-JAVA\\JDBCMVCSELECT5\\src\\main\\java\\in\\ineuron\\properties\\application.properties");
				Properties properties = new Properties();
				properties.load(fis);

				// Step2. Establish the Connection
				Connection connection = DriverManager.getConnection(properties.getProperty("url"),
						properties.getProperty("username"), properties.getProperty("password"));
				System.out.println("CONNECTION object created...");
				return connection;
	}
	
	public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException {
		//  Close the resources
		if (con != null) {
			con.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
	
}
