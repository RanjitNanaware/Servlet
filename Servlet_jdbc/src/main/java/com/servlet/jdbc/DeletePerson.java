package com.servlet.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DeletePerson")
public class DeletePerson extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Person person = new Person();
		person.setId(id);
		
		PersonCRUD crud = new PersonCRUD();
		try {
			crud.DeletePerson(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter printWriter = res.getWriter();
		printWriter.print("Person Deleted SuccessFully");
		
	}
	
	
}
