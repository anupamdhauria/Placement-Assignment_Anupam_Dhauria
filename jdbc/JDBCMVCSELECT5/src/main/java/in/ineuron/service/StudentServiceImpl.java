package in.ineuron.service;

import java.util.ArrayList;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao stdDao;


	@Override
	public ArrayList<Student> searchStudent() {
		
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent();
	}

	
}
