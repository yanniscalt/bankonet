package com.bankonet;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;


public class Client {
	
	private Civilite civilite;
	@ToString (uppercase = true) private String nom;
	@ToString private String prenom;
	private String identifiant;
	private String mdp = "1234";
	
	private Map<String, Compte> comptesMap = new HashMap<>();
	

	public Client(Civilite civilite, String nom, String prenom, String identifiant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.civilite = civilite;
	}
	
	public void creerCompte(Compte compte) {
		comptesMap.put(compte.getNumero(), compte);
	}
	
	public void supprimerCompte(Compte compte) {
		comptesMap.remove(compte.getNumero());
	}
	
	public Compte retournerCompte(String numero) throws CompteNonTrouveException {
		Compte compteRecherche = (Compte) comptesMap.get(numero);
	
		if(compteRecherche == null) {
			throw new CompteNonTrouveException();
		}
		
		return compteRecherche;
	}
	
	
	public void supprimerCompte(String numero) throws CompteNonTrouveException {
		Compte compteRecherche = retournerCompte(numero);
		comptesMap.remove(compteRecherche.getNumero());
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Collection<Compte> getComptesList() {
		return comptesMap.values();
	}

	@Override
	public String toString() {
		return String.format("Client [nom=%s, prenom=%s, identifiant=%s, mdp=%s]", nom, prenom, identifiant, mdp);
	}

	
	public int nbCompte(){
		return comptesMap.size();
	}
	
	public Boolean mdpValid(String mdp){
		if (this.mdp == mdp)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	


}