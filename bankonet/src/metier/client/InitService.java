package metier.client;

import dao.client.ClientsDAO;
import dao.comptes.ComptesDAO;
import factory.Client;
import metier.CompteServiceImpl;

public class InitService {
	
	private ClientsDAO clientdao;
	private ComptesDAO comptedao;
	
	public void init(){
		 Client client1 = new Client("Dupont","Pierre","DP");
		 Client client2 = new Client("Martin","Paul","MP");
		 Client client3 = new Client("Parker","Tony","TP");
		 Client client4 = new Client("Renard","Hugo","RH");
		 Client client5 = new Client("Lauren","Ralph","LR");
		 
		 CompteServiceImpl compteservice = new CompteServiceImpl(comptedao);
		 
		 clientdao.save(client1);
		 clientdao.save(client2);
		 clientdao.save(client3);
		 clientdao.save(client4);
		 clientdao.save(client5);
	}

}
