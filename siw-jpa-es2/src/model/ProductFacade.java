package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductFacade {
	
	@SuppressWarnings("unchecked")
	public static List<Provider> retriveAllProviders(Long productId) {
		List<Provider> fornitori = null;
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("model-unit");
		EntityManager em = ef.createEntityManager();
		Query ricercaFornitori = em.createNamedQuery("retriveProviders");
		ricercaFornitori.setParameter("id",productId);
		try {
			fornitori = ricercaFornitori.getResultList();
			return fornitori;
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
