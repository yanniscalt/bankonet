package metier;

import java.util.Set;

import dao.DAOFactory;
import dao.client.ClientsDAO;
import dao.comptes.ComptesDAO;
import factory.Civilite;
import factory.Client;

public class ClientServiceImpl implements ClientService {
	 
	private ClientsDAO clientdao;
	private ComptesDAO comptedao;
	 

	public ClientServiceImpl(ClientsDAO clientDAO, ComptesDAO comptedao) {
		this.clientdao = clientDAO;
		this.comptedao = comptedao ;
	}


	public void creerClient(String nom, String prenom, String identifiant) {
		Client client = new Client(Civilite.MONSIEUR,nom,prenom ,identifiant);
		clientdao.save(client);
		CompteServiceImpl compteservice = new CompteServiceImpl(comptedao);
		compteservice.creerCompte(nom, prenom, 0.0, 0.0);
				
	}


	public Set<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public void delete(String identifiant) {
		// TODO Auto-generated method stub
		
	}

}