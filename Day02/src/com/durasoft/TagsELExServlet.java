package com.durasoft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/el")
public class TagsELExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		int age = Integer.parseInt(request.getParameter("age"));
		Person p1 = new Person(firstName, age);
		HttpSession session = request.getSession(true);
		session.setAttribute("person1",p1);
		response.sendRedirect("form2.jsp");
		
		
		
		
		
		
		
		
		
	}
}
