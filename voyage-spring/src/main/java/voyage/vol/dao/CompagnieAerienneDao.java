package voyage.vol.dao;

import java.util.List;



import voyage.vol.model.CompagnieAerienne;


public interface CompagnieAerienneDao extends Dao <CompagnieAerienne, Long>{

	List<CompagnieAerienne> findAllByName(String name);
	
}
