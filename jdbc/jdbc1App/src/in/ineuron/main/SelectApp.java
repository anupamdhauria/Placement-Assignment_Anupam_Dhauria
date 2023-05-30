package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.jdbcUtil;

public class SelectApp {
	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = jdbcUtil.getJdbcConnection();

			String sqlSelectQuery = "select eid,ename,eaddr,esal from employee";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			
			if (resultSet != null) {

				System.out.println("EID\tENAME\tEADDRESS\tESAL");
				while (resultSet.next()) {
					
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3)
							+ "\t\t" + resultSet.getInt(4) );
				} 
			}

		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.cleanUp(connection, pstmt, resultSet);
				System.out.println("Closing the resource...");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
