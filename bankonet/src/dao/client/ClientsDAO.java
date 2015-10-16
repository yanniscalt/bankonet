package dao.client;
import java.util.List;

import factory.Client;

public interface ClientsDAO {
	List<Client> FindAll();
	void save(Client client);
}
