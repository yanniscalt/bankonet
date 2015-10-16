package metier;

import java.util.Set;

import dao.DAOFactory;
import dao.comptes.ComptesDAO;
import factory.Compte;
import factory.CompteCourant;

public class CompteServiceImpl implements CompteService {
	 private ComptesDAO comptedao;
	 private Integer nbcompte = 0;

	 

	public CompteServiceImpl(ComptesDAO compteDAO) {
		this.comptedao = compteDAO;
	}


	public void creerCompte(String nom, String prenom, double solde, double montantdecouvert) {
		String intituleCompte = creerIntitule(nom,prenom);		
		Compte compte1 = new CompteCourant("CC001",intituleCompte,solde, montantdecouvert);
		comptedao.save(compte1);
	}


	public Set<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void delete(String intitule) {
		// TODO Auto-generated method stub
		
	}
	
	private String creerIntitule(String nom, String prenom){
		
		StringBuilder ch = new StringBuilder();
		ch.append(nom.toUpperCase());
		ch.append("_");
		ch.append(prenom.toUpperCase());
		ch.append("_COURANT_");
		nbcompte++;
		ch.append(nbcompte);
		
		return ch.toString();		
	
	}

}