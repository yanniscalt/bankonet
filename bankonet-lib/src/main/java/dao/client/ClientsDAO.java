package dao.client;
import java.util.List;

import factory.Client;

public interface ClientsDAO {
	List<Client> findAll();
	void save(Client client);
	void delateAllClient();
	Client FindClientNom(String nom);
	Client FindClientPrenom(String prenom);
	void ModifierNom(String nom,String newNom);
	void SupprimerClient(Integer id);
	void supprimerAllClient();
}
