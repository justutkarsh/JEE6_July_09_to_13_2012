package com.durasoft.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.durasoft.domain.Employee;
import com.durasoft.ejb.EmployeesBeanLocal;
import com.durasoft.service.EmployeeService;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB(name="EmployeesBean")
	private EmployeesBeanLocal employeesBean;
	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dateOfJoining = request.getParameter("dateofjoining");
		PrintWriter out = response.getWriter();
		boolean created = employeesBean.addEmployee(id,name,dateOfJoining);
		if(created){
			List<Employee> employees = employeesBean.getAll();
			HttpSession session = request.getSession(true);
			session.setAttribute("employees",employees);
			response.sendRedirect("list.jsp");
		}
		else
		{
			request.setAttribute("error", "Error adding Employee");
			request.getRequestDispatcher("/add.jsp").forward(request,response);
		}
	}
}
