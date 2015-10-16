package ihm;

import java.util.Scanner;

import dao.DAOFactory;
import dao.DAOFactoryFichier;
import dao.DAOFactoryMySql;
import dao.client.ClientsDAO;
import factory.Client;
import metier.*;

public class Executeur {

	private  DAOFactory daofichier = new DAOFactoryFichier();
	private DAOFactory daosql = new DAOFactoryMySql();
	
	private ClientService clientdaofichier = new ClientServiceImpl(daofichier.getClientDAO() , daofichier.getCompteDAO()) ;
	private ClientService clientdaosql = new ClientServiceImpl(daosql.getClientDAO() ,  daosql.getCompteDAO());
	
	private CompteService comptedaofichier = new CompteServiceImpl(daofichier.getCompteDAO());
	private CompteService comptedaosql = new CompteServiceImpl(daofichier.getCompteDAO());
	
	
public static void main(String[] args) {
		Executeur app = new Executeur();
		app.start();
		
		
	}


private void start(){
	Scanner sc = new Scanner(System.in);
	String nom;
	String prenom;
	String login;
	StringBuilder ch = new StringBuilder();
	StringBuilder numerocompte = new StringBuilder("CC00");
	String numerocomptefinal;
	String intitule;
	String nbcompte;
	String chainesauvegardecompte;
	Integer index;
	

	System.out.println("Saisissez le nom");
	nom = sc.nextLine();
	System.out.println("Saisissez le prenom");
	prenom = sc.nextLine();
	System.out.println("Saisissez le login");
	login = sc.nextLine();
	
	clientdaofichier.creerClient(nom, prenom, login);
	
}
	
}

	
