package metier;

import java.util.List;
import java.util.Set;

import dao.comptes.ComptesDAO;
import factory.Compte;
import factory.CompteCourant;

public class CompteServiceImpl implements CompteService {
	 private ComptesDAO comptedao;
	
	 

	public CompteServiceImpl(ComptesDAO compteDAO) {
		this.comptedao = compteDAO;
	}


	@Override
	public Compte creerCompteEpargne(String numero, String intitule, Double solde, Double TauInteret, Integer nbcomptecourant) {
		
		return null;
	}


	@Override
	public Compte creerCompteCourant(String nom, String prenom, Double solde, Double Montantdecouvert, Integer nbcomptecourant) {
		String intituleCompte = creerIntitulecourant(nom,prenom,nbcomptecourant);		
		CompteCourant compte1 = new CompteCourant(intituleCompte,solde, Montantdecouvert);
		comptedao.saveCompte(compte1);
		return compte1;
		
	}
	
	
	public List<Compte> findAll() {
		
		return comptedao.FindAll();
	}

	
	public void delete(String intitule) {
		// TODO Auto-generated method stub
		
	}
	
	private String creerIntitulecourant(String nom, String prenom, Integer nbcomptecourant){
		
		StringBuilder ch = new StringBuilder();
		ch.append(nom.toUpperCase());
		ch.append("_");
		ch.append(prenom.toUpperCase());
		ch.append("_COURANT_");
		nbcomptecourant++;
		ch.append(nbcomptecourant);
		return ch.toString();		
	
	}


}
