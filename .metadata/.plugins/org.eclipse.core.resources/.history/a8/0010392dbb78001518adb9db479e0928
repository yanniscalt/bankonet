package ihm;

import java.util.Scanner;

import dao.DAOFactory;
import dao.DAOFactoryFichier;
import dao.DAOFactoryMySql;
import metier.ClientService;
import metier.ClientServiceImpl;
import metier.CompteService;
import metier.CompteServiceImpl;

public class OuvrirCompte extends IhmCommand {
	
	
	

	private ClientService clientService;
	
	
	
	

	public OuvrirCompte(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Ouverture compte";
	}

	@Override
	void Execute() {
		Scanner sc = new Scanner(System.in);
		String nom;
		String prenom;
		String login;
		
		System.out.println("Saisissez le nom");
		nom = sc.nextLine();
		System.out.println("Saisissez le prenom");
		prenom = sc.nextLine();
		System.out.println("Saisissez le login");
		login = sc.nextLine();
		
		clientService.creerClient(nom, prenom, login);	
		
	}

}
