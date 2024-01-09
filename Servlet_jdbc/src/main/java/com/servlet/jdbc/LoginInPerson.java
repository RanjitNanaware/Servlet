package com.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/Login")
public class LoginInPerson extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PersonCRUD crud = new PersonCRUD();
		String dbpassword = null;
		try {
			dbpassword = crud.loginPerson(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter printWriter = res.getWriter();
		if(password.equals(dbpassword)) {
			printWriter.print("Login Successfully");
		}else {
			printWriter.print("Login Failed");
		}
	}
}
