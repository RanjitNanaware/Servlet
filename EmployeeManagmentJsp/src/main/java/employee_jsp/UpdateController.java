package employee_jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeCRUD crud = new EmployeeCRUD();
		try {
			Employee employee = crud.getEmployeeById(id);
			if(employee != null) {
				HttpSession session = req.getSession();
				String name = (String) session.getAttribute("name");
				if (name != null) {
					req.setAttribute("emp", employee);
					RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
					rd.forward(req, resp);
				} else {
					req.setAttribute("message", "Please Login First");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
