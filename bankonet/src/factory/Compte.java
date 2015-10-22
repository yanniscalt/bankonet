package factory;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Compte implements CompteStat {
	
	@Id @GeneratedValue private Integer id;
	private String intitule;
	private Double solde;
	
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", intitule=" + intitule + ", solde=" + solde + "]";
	}

	public Compte() {
		super();
	}

	public Compte(String intitule, double solde) {
		super();
		this.intitule = intitule;
		if(solde >= 0.0) {
			this.solde = solde;
		} else {
			System.out.println("Impossible de créer un compte avec un solde négatif");
		}
	}
	
	abstract protected double calculerDebitMaximum();
	
	
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	public void crediter(double montant) throws CompteException {
		solde = solde + montant;
	}
	
	public void debiter(double montant) throws CompteException {
		double debitMax = calculerDebitMaximum();
		if(montant <= debitMax) {
			solde = solde - montant;
		} else {
			throw new DebitException("Débit maximum atteint : " + debitMax);
		}
	}
	
	public void effectuerVirement(Compte compte, double montant) throws CompteException {
		this.debiter(montant);
		compte.crediter(montant);
	}
	


}
