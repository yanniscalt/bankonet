package dao;

import dao.client.ClientsDAO;
import dao.client.ClientsDAOMysql;
import dao.comptes.CompteDAOFichier;
import dao.comptes.CompteDAOMySql;
import dao.comptes.ComptesDAO;

public class DAOFactoryMySql implements DAOFactory {

	private ComptesDAO comptedao = new CompteDAOMySql();
	private ClientsDAO clientdao = new ClientsDAOMysql();
	

	public ComptesDAO getCompteDAO() {
		// TODO Auto-generated method stub
		return comptedao;
	}


	public ClientsDAO getClientDAO() {
		// TODO Auto-generated method stub
		return clientdao;
	}


}
