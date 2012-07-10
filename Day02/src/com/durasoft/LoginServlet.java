package com.durasoft;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if("admin".equals(userName) && "admin".equals(password)){
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn",true);
			response.sendRedirect("home.jsp");
		}
		else
		{
			request.setAttribute("error","Invalid credentials");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
		}
	}
}
