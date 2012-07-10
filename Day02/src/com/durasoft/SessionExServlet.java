package com.durasoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 1;
		HttpSession session = request.getSession(true);//JSESSIONID
		System.out.println(session.getId());
		if(session.getAttribute("requestCount") != null){
			count = Integer.parseInt(session.getAttribute("requestCount").toString());
			count++;
			//get the cookie called "JSESSIONID"
			//set the max age to some  time
			//add to the response
		}
		session.setAttribute("requestCount",count+"");
		PrintWriter out = response.getWriter();
		out.println("<h1>Request count:" + count + "</h1>");
	}
}
