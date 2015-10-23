package ihm;

import java.util.Scanner;

import metier.ClientService;

public class ModifierNom extends IhmCommand{
	private ClientService clientService;
	
	public ModifierNom(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier un nom client";
	}

	@Override
	void Execute() {
		Scanner sc = new Scanner(System.in);
		String nom;
		String newnom;
		
		System.out.println("Saisissez le nom à modifier");
		nom = sc.nextLine();
		
		System.out.println("Saisissez le nouveau nom");
		newnom = sc.nextLine();				
		clientService.ModifierNom(nom, newnom);
	}

}
