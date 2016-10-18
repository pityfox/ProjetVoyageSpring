package voyage.vol.dao;

import java.util.List;


import voyage.vol.model.Aeroport;

public interface AeroportDao extends Dao <Aeroport, Long>{

	List<Aeroport> findAllByName(String name);
	
}
