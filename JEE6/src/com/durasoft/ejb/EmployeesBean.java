package com.durasoft.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.durasoft.domain.Employee;
import com.durasoft.service.EmployeeService;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class EmployeesBean implements EmployeesBeanLocal {

	@PersistenceUnit(name="EmployeeUnit")
	private EntityManagerFactory emf; 
	private EmployeeService employeeService;
	
	@Resource(mappedName="/ConnectionFactory")
	private TopicConnectionFactory tcf;
	
	@Resource(mappedName="/topic/Stock")
	private Topic stockTopic;
	
	@PostConstruct
	public void initialize(){
		employeeService = new EmployeeService(emf);
	}

	private void postMessageToStockTopic(String message){
		System.out.println(tcf);
		System.out.println(stockTopic);
		try {
			TopicConnection conn = tcf.createTopicConnection();
			TopicSession session = 
					conn.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			TopicPublisher publisher = session.createPublisher(stockTopic);
			conn.start();
			TextMessage tm = session.createTextMessage();
			tm.setText(message);
			publisher.publish(tm);
			conn.close();
		} catch (JMSException e) {
			System.out.println("*****ERROR*****");
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean addEmployee(int id, String name, String dateOfJoining) {
		boolean result = employeeService.addEmployee(id, name, dateOfJoining);
		if(result)
			postMessageToStockTopic("Employee : " + id + " created successfully");
		else
			postMessageToStockTopic("Unable to add Employee with id: " + id);
		return result;
	}

	@Override
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}


}
