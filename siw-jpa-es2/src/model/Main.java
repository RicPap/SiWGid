package model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = emf.createEntityManager();
		Customer c = new Customer();
		c.setFirstName("Emanuele");
		c.setLastName("Grassi");
		c.setDateOfBirth(new Date(19999));
		c.setEmail("Ema.grassi@stup.copypasterino.hs");
		c.setPhoneNumber("PagineGialle");
		c.setRegistrationDate(new Date(471364796));
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		emf.close();
	}
}
