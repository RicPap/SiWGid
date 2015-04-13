package model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerFacade {
	public static Customer createCustomer(String firstName, String lastName, String email,
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
	public static List<Customer> retriveAllCostumers() {
		List<Customer> customers = null;
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = ef.createEntityManager();
		try {
			Query query = em.createNamedQuery("retriveCustomers");
			customers = query.getResultList();
			return customers;
		}
		catch(Exception e) {
			return null;
		}
		finally {
			em.close();
			ef.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Orders> retriveAllOrders(Long id) {
		List<Orders> ordini = null;
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = ef.createEntityManager();
		Query ricercaOrdini = em.createQuery("SELECT o FROM Orders o WHERE o.customer.id = :id");
		/*Customer c = em.find(Customer.class,id);
		List<Orders> ordini = c.getListOrders(); */
		ricercaOrdini.setParameter("id",id);
		try {
			ordini = ricercaOrdini.getResultList();
			return ordini;
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