package dao.comptes;

import java.util.List;

import factory.Compte;

public interface ComptesDAO {
	List<Compte> FindAll();
	
	void save(Compte compte);
	

}