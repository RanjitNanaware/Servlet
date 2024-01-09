package Servlet.Assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Calculator extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException, ClassCastException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		String Operation = req.getParameter("Operation");
		int a = 0 ;
		
		PrintWriter printWriter = res.getWriter();
		if(Operation.equals("+")) {
			a = num1+num2 ;
		}
		else if(Operation.equals("-")) {
			a = num1-num2 ;
		}
		else if(Operation.equals("*")) {
			a = num1 * num2 ;
		}
		else if(Operation.equals("/")) {
			a = num1 / num2 ;
		}
		printWriter.print(a);
		
	}
}
