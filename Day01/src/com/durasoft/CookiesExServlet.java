package com.durasoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.transport.http.client.HttpCookie;

@WebServlet("/cook")
public class CookiesExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[]  cookies = request.getCookies();
		Cookie requestCountCookie = null;
		if(cookies != null){
			for (int i = 0; i < cookies.length; i++) {
				if("requestCount".equals(cookies[i].getName())){
						requestCountCookie = cookies[i];
						break;
				}
			}
		}
		int count = 1;
		if(requestCountCookie == null){
			requestCountCookie = new Cookie("requestCount", count+"");
		}
		else{
			count = Integer.parseInt(requestCountCookie.getValue());
			count++;
		}
		requestCountCookie.setValue(count+"");
		requestCountCookie.setMaxAge(9999999);
		response.addCookie(requestCountCookie);	
			
		PrintWriter out = response.getWriter();
		out.println("<h1>Request Count : " + count + "</h1>");
	}

}
