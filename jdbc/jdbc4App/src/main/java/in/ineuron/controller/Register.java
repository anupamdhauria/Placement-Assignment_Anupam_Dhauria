package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green; text-align:center;'> Welcome:  "+username +"</h1>");
		out.close();
	}

}
