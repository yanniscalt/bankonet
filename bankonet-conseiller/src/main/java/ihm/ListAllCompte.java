package ihm;

import java.util.List;
import java.util.Set;

import factory.Client;
import factory.Compte;
import metier.CompteService;

public class ListAllCompte extends IhmCommand{
	private CompteService compteService;
	
	
	public ListAllCompte(CompteService compteService) {
		super();
		this.compteService = compteService;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Lister tous les comptes";
	}

	@Override
	void Execute() {
		List<Compte> listcomptes = compteService.findAll();
		
		if(listcomptes == null){
			System.out.println("pas de comptes");
		}
		else{
		for(Compte c : listcomptes)
			{
			System.out.println(c.toString());
			}
		}
		
	}

}
