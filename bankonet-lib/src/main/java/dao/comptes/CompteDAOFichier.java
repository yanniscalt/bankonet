package dao.comptes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import factory.*;

public class CompteDAOFichier implements ComptesDAO{

	@Override
	public List<Compte> FindAll() {
		Properties prop = new Properties();
		InputStream input = null;
		 Set<String> ch;
		 String ch2;
		 String login;
		int a;
		
		try {

			input = new FileInputStream("src/comptes.properties");

			// load a properties file
			prop.load(input);
			ch = prop.stringPropertyNames();
			
			Iterator iterator = ch.iterator();
			while(iterator.hasNext())
			{
			
				login = (String) iterator.next();
				ch2 = prop.getProperty(login);
				String str[] = ch2.split("_");
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
		return null;	

	}
/*
	@Override
	public void save(Compte compte) {
		Properties prop = new Properties();
		OutputStream output = null;
		InputStream input = null;
		
		
		try {
			input = new FileInputStream("src/comptes.properties");
			
			prop.load(input);
			
			prop.setProperty(compte.getIntitule(), compte.getIntitule());
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
	
	*/
public static String chaineSauvegardecompte(Compte compte){
		StringBuilder ch = new StringBuilder("numero:");
		ch.append(compte.getIntitule());
		ch.append("&intitule:");
		ch.append(compte.getIntitule());
		return ch.toString();
	}
/*
@Override
public void saveCompteCourant(CompteCourant compte) {
	// TODO Auto-generated method stub
	
}

@Override
public void saveCompteEpargne(CompteEpargne compte) {
	// TODO Auto-generated method stub
	
}
*/
@Override
public void deleteAllCompteCourant() {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteAllCompteEpargne() {
	// TODO Auto-generated method stub
	
}

@Override
public void saveCompte(Compte compte) {
	// TODO Auto-generated method stub
	
}

	
	
	
	

}
