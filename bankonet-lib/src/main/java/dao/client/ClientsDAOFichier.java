package dao.client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import factory.Client;

public class ClientsDAOFichier implements ClientsDAO {

	
	public List<Client> findAll() {
		
		return null;
	}


	public void save(Client client) {
		Properties prop = new Properties();
		OutputStream output = null;
		InputStream input=null;
		try {

			
			input = new FileInputStream("src/clients.properties");
			
			prop.load(input);
			
			prop.setProperty(client.getLogin(), chaineSauvegardeClient(client.getNom(),client.getPrenom(),client));
			
			
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
		nbcompte = client.nbCompteCourant();
		for (int i=0; i<=nbcompte;i++)
		{
			ch.append("CC00");
			ch.append(nbcompte.toString());
			ch.append(",");
		}		
		
		return ch.toString();
	}


	@Override
	public void delateAllClient() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Client FindClientNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Client FindClientPrenom(String prenom) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void ModifierNom(String nom, String newNom) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void SupprimerClient(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void supprimerAllClient() {
		// TODO Auto-generated method stub
		
	}



}
