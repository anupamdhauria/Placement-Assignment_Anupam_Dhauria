package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/show")
public class controllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		ArrayList<Student>student = studentService.searchStudent();
		int size=student.size();
		int i=0;
		PrintWriter out = response.getWriter();
		if (student != null) {
			out.println("<body>");
			out.println("<br/><br/><br/>");
			out.println("<center>");
			out.println("<table border='1'>");
			out.println("<tr><th>SID</th> <th>SNAME</th> <th>SAGE</th> <th>SADDRESS</th></tr>");
			while(i<size) {
				out.println("<tr><td>"+student.get(i).getSid()+"</td><td>"+student.get(i).getSname()+"</td>"
						+ "<td>"+student.get(i).getSage()+"</td><td>"+student.get(i).getSaddr()+"</td></tr>");
			i++;
			}
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");
			
		} else {
			out.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE  </h1>");
		}
		out.close();
	}

}
