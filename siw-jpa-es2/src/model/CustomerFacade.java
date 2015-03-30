package model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerFacade {
	public static void addCusotmer(String firstName, String lastName, String email,
			String phoneNumber, Date dateOfBirth, Date registrationDate, String street,
			String city,String state,String zipCode,String country) {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = ef.createEntityManager();
		Address a = new Address(street,city,state,zipCode,country);
		Customer c = new Customer(firstName,lastName,email,phoneNumber,dateOfBirth,registrationDate,a);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		ef.close();
	}
}
