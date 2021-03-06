package dao.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import factory.Client;

public class ClientDAOJPA implements ClientsDAO {
	
	public EntityManagerFactory emf ;
	
	
	public ClientDAOJPA(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select h from Client h", Client.class);
		List<Client> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	@Override
	public void save(Client client) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(client);
		et.commit();// et.rollback()
		em.close();
		
	}

	@Override
	public void delateAllClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client FindClientNom(String nom) {
		EntityManager em = emf.createEntityManager();
		return em.createNamedQuery("Client.findByLastname",Client.class).setParameter("name", nom).getSingleResult();
		
	}

	@Override
	public Client FindClientPrenom(String prenom) {
		EntityManager em = emf.createEntityManager();
		return em.createNamedQuery("Client.findByFirstname",Client.class).setParameter("firstname", prenom).getSingleResult();
		
		}

	@Override
	public void ModifierNom(String nom, String newNom) {
		EntityManager em = emf.createEntityManager();		
		EntityTransaction et = em.getTransaction();		
		et.begin();
		
		Client oldclient = FindClientNom(nom);		
		Client c = em.find(Client.class, oldclient.getId());
		if (c  != null){
			c.setNom(newNom);
		}
		
		em.persist(c);
		et.commit();// et.rollback()
		em.close();
		
	}

	@Override
	public void SupprimerClient(Integer id) {
		EntityManager em = emf.createEntityManager();		
		EntityTransaction et = em.getTransaction();	
		et.begin();
		Client c = em.find(Client.class,id);
		if (c  != null){
			em.remove(c);
		}
		
		//em.merge(c);
		et.commit();// et.rollback()
		em.close();
		
	}

	@Override
	public void supprimerAllClient() {
		EntityManager em = emf.createEntityManager();		
		EntityTransaction et = em.getTransaction();	
		et.begin();	
		em.createNativeQuery("delete from client").executeUpdate();
		et.commit();
		em.close();
	}

}
