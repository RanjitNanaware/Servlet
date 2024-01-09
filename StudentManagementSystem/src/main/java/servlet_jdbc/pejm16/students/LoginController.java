package servlet_jdbc.pejm16.students;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext context = getServletContext();
		String school = context.getInitParameter("school");
		
		StudentCRUD crud = new StudentCRUD();
		try {
			Student dbstudent = crud.loginStudtent(email);
			if(password.equals(dbstudent.getPassword())&&school.equals(dbstudent.getSchool())) {
				resp.sendRedirect("success.html");
			}else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
				requestDispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
