package metier;

import java.util.List;
import java.util.Set;

import factory.Compte;

public interface CompteService {
	
	Compte creerCompteCourant(String nom, String prenom, Double solde, Double Montantdecouvert, Integer nbcomptecourant);
	Compte creerCompteEpargne(String nom, String prenom, Double solde, Double TauInteret, Integer nbcompteepargne);
	List<Compte> findAll();
	void delete(String intitule);

}
