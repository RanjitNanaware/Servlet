package com.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PersonCRUD crud = new PersonCRUD();
		String dbpassword = null;
		try {
			dbpassword = crud.loginPerson(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter printWriter = resp.getWriter();
		if(password.equals(dbpassword)) {
//			printWriter.print("Login Successfully");
			
//			RequestDispatcher requedtDispatcher = req.getRequestDispatcher("Home.html");
//			requedtDispatcher.forward(req, resp);
			
			resp.sendRedirect("https://www.facebook.com/");
			
		}else {
//			printWriter.print("Login Failed");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.forward(req, resp);
			
			
		}
	}
}
