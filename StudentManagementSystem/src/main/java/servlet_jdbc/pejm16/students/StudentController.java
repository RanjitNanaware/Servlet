package servlet_jdbc.pejm16.students;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String studentName = req.getParameter("sname");
		String fatherName = req.getParameter("fname");
		String motherName = req.getParameter("mname");
		int age = Integer.parseInt(req.getParameter("age"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext context = getServletContext();
		String school = context.getInitParameter("school");
		
		Student student = new Student();
		student.setId(id);
		student.setStudentName(studentName);
		student.setFatherName(fatherName);
		student.setMotherName(motherName);
		student.setAge(age);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchool(school);
		
		String fee = req.getParameter("fees");
		if(fee.equals("oneshot")) {
			ServletConfig config = getServletConfig();
			long fees = Long.parseLong(config.getInitParameter("oneshot"));
			
			student.setFees(fees);
		}else {
			ServletConfig config = getServletConfig();
			long fees = Long.parseLong(config.getInitParameter("Installment"));
			
			student.setFees(fees);
		}
		
		StudentCRUD crud = new StudentCRUD();
		try {
			int count = crud.saveStudent(student);
			
			if(count!=0) {
				RequestDispatcher rd = req.getRequestDispatcher("home.html");
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("signUp.html");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
