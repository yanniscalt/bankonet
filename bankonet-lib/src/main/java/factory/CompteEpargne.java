package factory;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private static final double PLAFOND = 12000;
	
	private Double taux;

	
	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String intitule, double solde, double tauxInteret) {
		super(intitule, solde);
		this.taux = tauxInteret;
	}

	public double getTauxInteret() {
		return taux;
	}

	public void setTauxInteret(double tauxInteret) {
		this.taux = tauxInteret;
	}

	@Override
	public void crediter(double montant) throws CompteException {
		if(getSolde() + montant > PLAFOND) {
			throw new CreditException();
		}
		super.crediter(montant);
	}


	@Override
	protected double calculerDebitMaximum() {
		return getSolde();
	}
	
	
	
	

}
