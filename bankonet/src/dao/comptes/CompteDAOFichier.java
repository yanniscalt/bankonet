package dao.comptes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import factory.*;

public class CompteDAOFichier implements ComptesDAO{

	@Override
	public List<Compte> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Compte compte) {
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
	
	
	
	

}
