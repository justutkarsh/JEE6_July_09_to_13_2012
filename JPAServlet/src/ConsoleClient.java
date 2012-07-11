import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.durasoft.domain.User;

public class ConsoleClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAServletLab");
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select u from User u where " +
				"u.userName=:p1 and u.password=:p2");
		query.setParameter("p1", "sam23");
		query.setParameter("p2", "abcde");
		User u = (User)query.getResultList().get(0);
		System.out.println(u.getUserType().getDescription());
		query = em.createQuery("select p from Person p " +
				"where p.user.id=:p1");
		query.setParameter("p1", u.getId());
		System.out.println(query.getResultList());
		em.close();
	}
}
