package dao;

import dao.client.ClientsDAO;
import dao.client.ClientsDAOFichier;
import dao.comptes.CompteDAOFichier;
import dao.comptes.ComptesDAO;

public class DAOFactoryFichier implements DAOFactory{

	
	private ComptesDAO comptedao = new CompteDAOFichier();
	private ClientsDAO clientdao = new ClientsDAOFichier();

	public ComptesDAO getCompteDAO() {
		return comptedao;
	}

	
	public ClientsDAO getClientDAO() {
		return clientdao;
	}


}
