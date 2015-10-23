package factory;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	

	private Double decouvert;
	//private static int nbCompteCourants = 0;
	
	
		
	public CompteCourant() {
		super();
	}


	public CompteCourant(String intitule, double solde, double montantDecouvertAutorise) 
	{
		super(intitule, solde);		
		this.decouvert = montantDecouvertAutorise;
		//nbCompteCourants++;
	}


	public double getMontantDecouvertAutorise() {
		return decouvert;
	}
	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.decouvert = montantDecouvertAutorise;
	}
	
		
	@Override
	protected double calculerDebitMaximum() {
		return decouvert + getSolde();
	}
	
	

}
