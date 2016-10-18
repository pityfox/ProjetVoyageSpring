package voyage.client.dao;

import java.util.List;

import voyage.client.model.Client;
import voyage.dao.Dao;

public interface ClientDao extends Dao<Client, Long> {
	List<Client> findAllByName(String name);
}
