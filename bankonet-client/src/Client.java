import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//index = 0;
		int valueUser=1;
		String login;
		String mdp;

			do{
				System.out.println("Indiquez login");
				login = sc.next();
				System.out.println("Indiquez le mot de passe");
				mdp = sc.next();
				if(fichierclient(login,mdp) && testMdp(mdp)){
						do{
							System.out.println("*****APPLICATION CLIENT*****");
							System.out.println("0. Arrêter programme");
							System.out.println("1. Consulter les soldes des comptes");
							System.out.println("Veuillez choisir une action");
							valueUser = sc.nextInt();
							
						}while(valueUser != 0);
					}				
			}while(valueUser != 0);

		System.out.println("Arret application");

	}
	
	





	private static boolean testMdp(String mdp) {
		if (mdp.equals("1234")){return true;}
		else {return false;}
	}




	private static Boolean fichierclient(String login, String mdp){
		
		Properties prop = new Properties();
		InputStream input = null;
		 String ch;
		 String ch2;
		 String nom;
		 String prenom;
		
		try {

			input = new FileInputStream("C:/Users/ETY/Desktop/java/bankonet-conseiller/bin/clients.properties");

			// load a properties file
			prop.load(input);
			return prop.containsKey(login);
			/*
			String str[] = ch.split("&");
			
			for (int i =0 ; i<str.length;i++)
			{
				String str2[]=str[i].split(":");							
				for (int j = 0 ; j<str2.length;j++)
				{
					if(str2[j].equals("nom")){nom = str2[j+1];}
					if(str2[j].equals("prenom")){prenom = str2[j+1];}
					System.out.println(str2[j]);
				}
			}
			*/			
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
		return false;
		
	}

}
