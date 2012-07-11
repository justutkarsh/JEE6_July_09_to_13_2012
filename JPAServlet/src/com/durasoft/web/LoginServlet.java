package com.durasoft.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.durasoft.domain.Person;
import com.durasoft.domain.User;
import com.durasoft.service.AuthenticationService;
import com.durasoft.service.HomeService;

@WebServlet(urlPatterns={"/login"},loadOnStartup=1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthenticationService authenticationService;
	private HomeService homeService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("JPAServletLab");
		getServletContext().setAttribute("emf", emf);
		
		authenticationService = new AuthenticationService(emf);
		homeService = new HomeService(emf);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//Not recommended accessing entity classes from servlet
		User user = authenticationService.authenticate(userName, password);
		if(user != null){
			HttpSession session = request.getSession(true);
			if("Customer".equals(user.getUserType().getDescription())){
				Person person = homeService.getPerson(user);
				session.setAttribute("person",person);
			}	
			else{
				List<Person> persons = homeService.getPersonsList();
				session.setAttribute("persons",persons);
			}
			response.sendRedirect("home.jsp");
		}
		else
		{
			request.setAttribute("error", "Invalid Credentials");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
