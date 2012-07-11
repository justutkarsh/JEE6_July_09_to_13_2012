import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.durasoft.Company;
import com.durasoft.Dog;
import com.durasoft.Person;

public class JPAClient {
	public static void main(String[] args) throws Exception{
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PersonsUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Company intuit = new Company("Intuit", "NY");
		em.persist(intuit);
		
		Person p1 = new Person("Ram", "Sharma", 39);
		p1.setCompany(intuit);
		Set<Dog> dogs = new HashSet<Dog>();
		dogs.add(new Dog("Tommy", "Dobberman"));
		dogs.add(new Dog("Jimmy", "Alsatian"));
		p1.setDogs(dogs);

		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(p1);
		txn.commit();
		
		
		
	/*	EntityTransaction txn = em.getTransaction();
		txn.begin();
		Person p1 = em.find(Person.class, 1001);
		em.remove(p1);
		txn.commit();*/
				
/*		Person p1 = em.find(Person.class, 1001);
		System.out.println(p1.getFirstName());
		System.out.println(p1.getLastName());*/
/*		Person p1 = new Person("Ram", "Sharma", 39);
		p1.setId(1003);
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(p1);
		txn.commit();*/
		em.close();
		System.out.println("Success");
	}
}
