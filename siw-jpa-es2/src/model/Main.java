package model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = emf.createEntityManager();
		Customer c = new Customer();
		Address a = new Address();
		a.setCity("Albano");
		a.setCountry("Lazio");
		a.setState("Italy");
		a.setStreet("Via del cancro");
		a.setZipCode("HS");
		c.setFirstName("Emanuele");
		c.setLastName("Grassi");
		c.setDateOfBirth(new Date(19999));
		c.setEmail("Ema.grassi@stup.copypasterino.hs");
		c.setPhoneNumber("PagineGialle");
		c.setRegistrationDate(new Date(471364796));
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		c.setAddres(a);
		tx.commit();
		em.close();
		emf.close();
		*/
		CustomerFacade.addCusotmer("Luca","Leone","@Luc","2534265",new Date(125478578), new Date(97786764),"@Lion","Roma","Italy","82421","Lazio");
	}
}
