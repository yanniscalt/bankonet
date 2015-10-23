package ihm;

import metier.ClientService;

public class SupprimerAllClient extends IhmCommand{
	private ClientService clientService;
	
	public SupprimerAllClient(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Supprimer tous les clients";
	}

	@Override
	void Execute() {
		clientService.SupprimerAllClient();
		
	}

}
