package dao.client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import factory.Client;

public class ClientsDAOFichier implements ClientsDAO {

	
	public List<Client> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}


	public void save(Client client) {
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
	
	private String chaineSauvegardeClient(String nom, String prenom,Client client){
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



}
