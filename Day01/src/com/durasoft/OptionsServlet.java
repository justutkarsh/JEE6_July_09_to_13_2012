package com.durasoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/options"},loadOnStartup=1,
initParams={
		@WebInitParam(name="key1",value="value1"),
		@WebInitParam(name="key2",value="value2"),
})
public class OptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void destroy() {
		super.destroy();
		//clean up
	}

	@Override
	public void init() throws ServletException {
		super.init();
		//perform initialization
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key1 = super.getServletConfig().getInitParameter("key1");
		PrintWriter out = response.getWriter();
		out.println(request.getAttribute("intuit"));
		out.println("This is options servlet");
		out.println(key1);
	}
}
