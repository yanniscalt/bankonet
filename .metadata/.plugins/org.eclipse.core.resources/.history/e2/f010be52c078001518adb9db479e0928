package ihm;

import java.util.Scanner;

import com.mysql.fabric.xmlrpc.Client;

import metier.ClientService;

public class RechercheClientNom extends IhmCommand {
	
	private ClientService clientService;
	
	
	public RechercheClientNom(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public Integer getId() {
		
		return 4;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Rechercher un client à partir du nom";
	}

	@Override
	void Execute() {
		Scanner sc = new Scanner(System.in);
		String nom;
		
		System.out.println("Saisissez le nom");
		nom = sc.nextLine();
		
		factory.Client client = clientService.findClientNom(nom);
		System.out.println(client.toString());
		
	}

}
