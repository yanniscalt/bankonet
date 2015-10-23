package dao.comptes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import factory.Client;
import factory.Compte;
import factory.CompteCourant;
import factory.CompteEpargne;

public class CompteDAOJPA implements ComptesDAO{
	public EntityManagerFactory emf ;
	
	
	
	
	public CompteDAOJPA(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public List<Compte> FindAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select h from Compte h", Compte.class);
		List<Compte> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	@Override
	public void deleteAllCompteCourant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllCompteEpargne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCompte(Compte compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(compte);
		et.commit();// et.rollback()
		em.close();
		
	}

}
