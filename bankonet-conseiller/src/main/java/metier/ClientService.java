package metier;

import java.util.Set;

import factory.Client;

public interface ClientService {
	
	void creerClient(String nom, String prenom, String identifiant);
	Set<Client> findAll();
	void delete(String identifiant);
	Client findClientNom(String nom);
	Client findClientPrenom(String Prenom);
	void ModifierNom(String nom,String newnom);
	void SupprimerClient (Integer id);
	void SupprimerAllClient();

}
