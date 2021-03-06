package ihm;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import factory.Client;
import metier.ClientService;

public class ListAllClient extends IhmCommand {

	private ClientService clientService;
	
	
	public ListAllClient(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Lister tous les clients";
	}

	@Override
	void Execute() {
		Set<Client> listclient = clientService.findAll();
		if(listclient == null){
			System.out.println("pas de client");
		}
		else{
		for(Client c : listclient)
		{
			System.out.println(c);
		}
		}
		
		
	}

}
