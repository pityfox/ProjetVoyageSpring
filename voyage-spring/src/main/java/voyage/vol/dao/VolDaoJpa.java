package voyage.vol.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.vol.model.*;

@Repository
@Transactional
public class VolDaoJpa implements VolDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	@Qualifier("compagnieAerienneVolDaoJpa")
	private CompagnieAerienneVolDao compagnieAerienneVolDao;
	
	@Autowired
	@Qualifier("escaleDaoJpa")
	private EscaleDao escaleDao;

	@Override
	@Transactional(readOnly=true)
	public Vol find(Long id) {
		return em.find(Vol.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Vol> findAll() {
		Query query = em.createQuery("select v from Vol v");
		return query.getResultList();
	}

	@Override
	public void create(Vol obj) {
		em.persist(obj);
	}

	@Override
	public Vol update(Vol obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Vol obj) {
		obj = em.merge(obj);

		for (CompagnieAerienneVol compagnieAerienneVol : obj.getCompagniesAeriennes()) {
			compagnieAerienneVolDao.delete(compagnieAerienneVol);
		}
		
		for(Escale escale: obj.getEscales()){
			escaleDao.delete(escale);
		}

		em.remove(obj);
	}

	

}
