package dao.comptes;

import java.util.List;

import factory.Compte;
import factory.CompteCourant;
import factory.CompteEpargne;

public interface ComptesDAO {
	List<Compte> FindAll();
	
	void saveCompte(Compte compte);
	
	void deleteAllCompteCourant();
	void deleteAllCompteEpargne();

	

}
