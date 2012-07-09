package com.durasoft;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postlunch")
public class PostLunchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String message = "Hello " + name.toUpperCase();
		request.setAttribute("info", message);
		RequestDispatcher disp = 
				request.getRequestDispatcher("/response.jsp");
		disp.forward(request, response);
	}
}
