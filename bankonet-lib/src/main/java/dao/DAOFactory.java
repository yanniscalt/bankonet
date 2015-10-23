package dao;

import dao.client.ClientsDAO;
import dao.comptes.ComptesDAO;

public interface DAOFactory{
	public ComptesDAO getCompteDAO();
	public ClientsDAO getClientDAO();

}
