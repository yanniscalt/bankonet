package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.client.ClientDAOJPA;
import dao.client.ClientsDAO;
import dao.comptes.CompteDAOJPA;
import dao.comptes.ComptesDAO;


	public class DAOFactoryJPA implements DAOFactory{
	private EntityManagerFactory emf;
	
	private ComptesDAO comptedao;
	private ClientsDAO clientdao;
	
	
	public DAOFactoryJPA(String bdd) {
		this.emf = 	Persistence.createEntityManagerFactory(bdd);
				
	}

	@Override
	public ComptesDAO getCompteDAO() {
		comptedao = new CompteDAOJPA(this.emf);
		return comptedao;
	}

	@Override
	public ClientsDAO getClientDAO() {
		clientdao = new ClientDAOJPA(this.emf);
		return clientdao;
	}

}
