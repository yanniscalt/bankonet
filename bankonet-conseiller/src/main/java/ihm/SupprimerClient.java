package ihm;

import java.util.Scanner;

import metier.ClientService;

public class SupprimerClient extends IhmCommand {
	private ClientService clientService;
	
	
	
	public SupprimerClient(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Supprimer un client";
	}

	@Override
	void Execute() {
		Scanner sc = new Scanner(System.in);
		Integer id;
		String validate;
		System.out.println("Indiquer l'Id du client � supprimer");
		id = sc.nextInt();
		
		System.out.println("�tes vous sur de vouloir suprimmer ce client (V: valider , A:Annuler)");
		validate = sc.next();
		
		if(validate.equals("v")){
			clientService.SupprimerClient(id);
		}
		else{
			System.out.println("Action annul�e");
		}
	}

}
