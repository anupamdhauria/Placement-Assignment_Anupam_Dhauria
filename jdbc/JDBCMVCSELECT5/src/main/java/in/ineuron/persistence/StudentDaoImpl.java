package in.ineuron.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.io.*;

import in.ineuron.dto.Student;
import in.ineuron.util.jdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;

	

	@Override
	public ArrayList<Student> searchStudent() {
		

		String searchQuery="select sid,sname,sage,saddr from student";
		ArrayList<Student>std=new ArrayList<Student>();
		try {
			connection=jdbcUtil.getJdbcConnection();
			if(connection!=null) {
				pstmt=connection.prepareStatement(searchQuery);
			}
			if(pstmt!=null) {
				resultSet=pstmt.executeQuery();
			}
			if (resultSet != null) {

				while (resultSet.next()) {
					Student student=new Student();
					// copy resultSet data to student object
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddr(resultSet.getString(4));

					std.add(student);
				}

			}
	
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return std;
	}

	
	

}
