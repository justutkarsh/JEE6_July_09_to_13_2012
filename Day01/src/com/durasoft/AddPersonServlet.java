package com.durasoft;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.durasoft.domain.Person;

@WebServlet("/addperson")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Person> persons;
	
    public AddPersonServlet() {
    	persons = new ArrayList<Person>();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		Person p1 = new Person(firstName, lastName, age);
		persons.add(p1);
		request.setAttribute("persons",persons);
		request.getRequestDispatcher("/display.jsp").forward(request,response);
	}
}
