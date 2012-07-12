import javax.naming.Context;
import javax.naming.InitialContext;

import com.durasoft.IntuitWeatherReporter;
import com.durasoft.Person;

public class Client {
	public static void main(String[] args) throws Exception{
		Context context = new InitialContext();
/*		IntuitWeatherReporter reporter = 
				(IntuitWeatherReporter)context.lookup("IntuitWeatherReporterBean/remote");*/
		IntuitWeatherReporter reporter = 
				(IntuitWeatherReporter)context.lookup("MyReporter");
		System.out.println(reporter.getTemperature("Bengaluru"));
		Thread.sleep(4000);
		System.out.println(reporter.getInfo());		
		
		
		
		
		
		
		
		
/*		Person person1 = new Person();
		person1.setName("Sam");
		context.rebind("person1", person1);
		
		Person p1 = (Person)context.lookup("person1");
		System.out.println(p1.getName());
		//String intuit = "JEE6 training";
		//JEE6 training will be bound to the JNDI name "intuit"
		//context.bind("intuit", intuit);
		//System.out.println("Success");
		//bind
		String value = (String)context.lookup("intuit");
		System.out.println(value);*/
		//lookup
	}
}
