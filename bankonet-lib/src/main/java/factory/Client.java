package factory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import java.io.BufferedWriter;

@Entity
@Table(name = "client")
@NamedQueries({
	@NamedQuery(name="Client.findByLastname", query="select c from Client c where c.NOM=:name"),
	@NamedQuery(name="Client.findByFirstname", query="select c from Client c where c.PRENOM=:firstname")
})
public class Client {
	
	private String NOM;
	private String PRENOM;
	private String LOGIN;
	@Id @GeneratedValue private Integer id ;
	//private String mdp;
	 
	@ManyToMany
	@JoinTable(name="compte_client",
	joinColumns = @JoinColumn(name="id_client", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="id_compte", referencedColumnName="id"))
	
	private List<Compte> comptes = new ArrayList<>();

	
	

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Client [nom=" + NOM + ", prenom=" + PRENOM + ", login=" + LOGIN + ", id=" + id + "]";
	}

	public Client(String nom, String prenom, String login) {
		super();
		this.NOM = nom;
		this.PRENOM = prenom;
		this.LOGIN =login;
		
	}

	public String getNom() {
		return NOM;
	}

	public void setNom(String nom) {
		this.NOM = nom;
	}

	public String getPrenom() {
		return PRENOM;
	}

	public void setPrenom(String prenom) {
		this.PRENOM = prenom;
	}


	public String getLogin() {
		return LOGIN;
	}

	public void setLogin(String login) {
		this.LOGIN = login;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Compte comptes) {
		this.comptes.add(comptes);
	}
	
	public Integer nbCompteCourant(){
		Integer i = 0;
		for(Compte c : comptes)
		{
			if(c instanceof CompteCourant)
			{
				i++;
			}
		}
		return i;
	}
	
	
	


}
