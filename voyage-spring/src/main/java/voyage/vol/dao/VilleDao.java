package voyage.vol.dao;

import java.util.List;


import voyage.vol.model.Aeroport;
import voyage.vol.model.Ville;

public interface VilleDao extends Dao <Ville, Long>{

	List<Ville> findAllByName(String name);
	
}
