package dao.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import factory.Client;

public class ClientsDAOMysql implements ClientsDAO {

	@Override
	public List<Client> findAll() {
		
		return null;
	}


	@Override
	public void save(Client client) {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","yannis","yannis");
			
			Statement statement = connection.createStatement();
			String nom = client.getNom();
			String prenom = client.getPrenom();
			String login = client.getLogin();			
			statement.executeUpdate("INSERT INTO CLIENT(NOM,PRENOM,LOGIN)"
					+ "VALUES('"+nom+"','"+prenom+"','" +login+"')");
			System.out.println("client ajout�");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void delateAllClient(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankonet","yannis","yannis");
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM CLIENT");
			System.out.println("compte ajout�");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
