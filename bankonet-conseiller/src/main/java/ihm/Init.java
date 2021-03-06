package ihm;

import metier.ClientService;

public class Init extends IhmCommand{

	private ClientService clientService;
	
	public Init(ClientService clientService) {
		super();
		this.clientService=clientService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Initialisation 5 clients";
	}

	@Override
	void Execute() {
		
		clientService.creerClient("Boss", "Hugo", "BH");
		clientService.creerClient("Lauren", "Ralph", "LR");
		clientService.creerClient("Jordan", "Michael", "JM");
		clientService.creerClient("Bryant", "Kobe", "BK");
		clientService.creerClient("Durant", "Kevin", "DK");
	}

}
