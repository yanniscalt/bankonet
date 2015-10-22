package dao.comptes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import factory.Compte;
import factory.CompteCourant;
import factory.CompteEpargne;

public class CompteDAOMySql implements ComptesDAO {

	@Override
	public List<Compte> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveCompteCourant(CompteCourant compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","yannis","yannis");
			
			Statement statement = connection.createStatement();
			String id = compte.getIntitule();
			System.out.println(id);
			String numero = compte.getNumero();
			double solde = compte.getSolde();
			double decouvert = compte.getMontantDecouvertAutorise();
			statement.executeUpdate("INSERT INTO COMPTECOURANT(ID,LIBELE,SOLDE,DECOUVERT)"
					+ "VALUES('"+id+"','"+numero+"','" +solde+"','" +decouvert+"')");
			System.out.println("compte ajouté");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void saveCompteEpargne(CompteEpargne compte) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void save(Compte compte) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllCompteCourant() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","yannis","yannis");
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM COMPTECOURANT");
			System.out.println("Tous les compte courant supprimé");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteAllCompteEpargne() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","yannis","yannis");
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM COMPTEEPARGNE");
			System.out.println("Tous les compte epargne supprimé");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
