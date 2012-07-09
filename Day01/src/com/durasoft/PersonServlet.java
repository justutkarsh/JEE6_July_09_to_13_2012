package com.durasoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"/person","/person2","/person3"})
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String lifeCycleInfo;
    private String id;
    private static int numberOfServlets;
	public PersonServlet(){
		numberOfServlets++;
		id = "Servlet id: " + numberOfServlets;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		PrintWriter out = response.getWriter();
		lifeCycleInfo = "Total number of Servlets: " + numberOfServlets;
		out.println("<h3>" + id  +"</h3>");
		out.println("<h3>" + lifeCycleInfo  +"</h3>");
		out.println("<h1>Hello " + firstName + "!!!</h1>");
	}
}
