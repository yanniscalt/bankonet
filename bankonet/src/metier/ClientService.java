package metier;

import java.util.Set;

import factory.Client;

public interface ClientService {
	
	void creerClient(String nom, String prenom, String identifiant);
	Set<Client> findAll();
	void delete(String identifiant);

}