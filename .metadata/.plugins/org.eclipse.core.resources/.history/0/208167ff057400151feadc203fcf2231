import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.INPUT_STREAM;

import com.bankonet.*;


public class Conseiller {
	
	private static List listClient;
	private static Integer index;
	private static List clientlist = new ArrayList();
	private static Map<String,Client> clientMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		//index = 0;
		int valueUser;
		do{
		
		System.out.println("*****APPLICATION CONSEILLER BANCAIRE*****");
		System.out.println("0. Arrêter programme");
		System.out.println("1. Ouvrir un compte courant");
		System.out.println("2. Lister tous les clients");		
		System.out.println("Veuiller choisir une action");
		valueUser = sc.nextInt();
		
		switch(valueUser){
			case 1: 
				System.out.println("Ouverture Compte");
				creationCompte();
			break;
			case 2: 
				System.out.println("Liste des clients");
				listclient();
			break;
			case 0: 
				System.out.println("0");
			break;
		default: System.out.println("Saisi non valide");
		}
		
		}while(valueUser != 0);
		
		
		System.out.println("Arret application");
	}



	public static void creationCompte() throws IOException{
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
		
		//saisi des information
		System.out.println("Saisissez le nom");
		nom = sc.nextLine();
		System.out.println("Saisissez le prenom");
		prenom = sc.nextLine();
		System.out.println("Saisissez le login");
		login = sc.nextLine();
		ch.append(nom.toUpperCase());
		ch.append("_");
		ch.append(prenom.toUpperCase());
		ch.append("_COURANT_");
		
		//creation client
		Client client1 = new Client(Civilite.MONSIEUR, nom,prenom , login );
		clientMap.put(login,client1);
		//clientlist.add(client1);
		
		//intitulecompte
		index = client1.nbCompte() + 1;
		ch.append(index);		
		intitule = ch.toString();
		
		//numero compte
		numerocompte.append(index);
		numerocomptefinal = numerocompte.toString();
		System.out.println(intitule);
		
		//creation Comptecourant
		CompteCourant compte = new CompteCourant(numerocomptefinal,intitule,0.0,0.0);
		client1.creerCompte(compte);
		
		
		sauvegardeclient(client1);
		System.out.println(client1.toString());
		chainesauvegardecompte = chaineSauvegardecompte(compte);
		sauvegardecompte(compte);
		
		
	}
//CLIENT
	public static void sauvegardeclient(Client client){
		Properties prop = new Properties();
		OutputStream output = null;
		InputStream input=null;
		try {

			
			input = new FileInputStream("src/clients.properties");
			
			prop.load(input);
			
			prop.setProperty(client.getIdentifiant(), chaineSauvegardeClient(client.getNom(),client.getPrenom(),client));
			
			
			output = new FileOutputStream("src/clients.properties");
			prop.store(output, null);
			

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		}
	
	
	public static String chaineSauvegardeClient(String nom, String prenom,Client client){
		StringBuilder ch = new StringBuilder();
		Integer nbcompte;
		ch.append("nom:");
		ch.append(nom);
		ch.append("&prenom:");
		ch.append(prenom);
		ch.append("&comptes_courant:");
		nbcompte = client.nbCompte();
		for (int i=0; i<nbcompte;i++)
		{
			ch.append("CC00");
			ch.append(nbcompte.toString());
			ch.append(",");
		}
		
		return ch.toString();
	}

	
//COMPTE
	public static void sauvegardecompte(Compte compte){
		
		Properties prop = new Properties();
		OutputStream output = null;
		InputStream input = null;
		
		
		try {
			input = new FileInputStream("src/comptes.properties");
			
			prop.load(input);
			
			prop.setProperty(compte.getIntitule(), compte.getNumero());
			output = new FileOutputStream("src/comptes.properties");
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		}
		

public static String chaineSauvegardecompte(Compte compte){
	StringBuilder ch = new StringBuilder("numero:");
	ch.append(compte.getNumero());
	ch.append("&intitule:");
	ch.append(compte.getIntitule());
	return ch.toString();
}
	


//OPTION 2
	private static void listclient() {
		
		fichierclient();

		
	} 
	
	private static void fichierclient(){
		
		Properties prop = new Properties();
		InputStream input = null;
		 Set<String> ch;
		 String ch2;
		 String login;
		int a;
		
		try {

			input = new FileInputStream("src/clients.properties");

			// load a properties file
			prop.load(input);
			ch = prop.stringPropertyNames();
			
			Iterator iterator = ch.iterator();
			while(iterator.hasNext())
			{
			
				login = (String) iterator.next();
				ch2 = prop.getProperty(login);
				String str[] = ch2.split("&");
				System.out.println(" login:"+login);
				for (int i = 0 ; i<str.length ; i++){
					System.out.println(str[i]);
				}
				
			}
						
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/*
	public accessCompte(String login){
		clientlist.get
	}
	*/
	
	public static Client accessCompte(String login){
		Client clientRecherche = (Client) clientMap.get(login);
		return clientRecherche;
	
	
}
	
}
