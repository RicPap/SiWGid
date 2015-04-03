package model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerFacade {
	public static Customer addCustomer(String firstName, String lastName, String email,
			String phoneNumber, Date dateOfBirth, Date registrationDate, String street,
			String city,String state,String zipCode,String country) {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = ef.createEntityManager();
		Address a = new Address(street,city,state,zipCode,country);
		Customer c = new Customer(firstName,lastName,email,phoneNumber,dateOfBirth,registrationDate,a);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(c);
			tx.commit();
			return c;
		}
		catch(Exception e) {
			tx.rollback();
			return null;
		}
		finally {
			em.close();
			ef.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Customer> viewCustomers() {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = ef.createEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Customer c");
			return query.getResultList();
		}
		catch(Exception e) {
			return null;
		}
		finally {
			em.close();
			ef.close();
		}
	}
}