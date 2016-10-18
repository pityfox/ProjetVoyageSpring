package voyage.vol.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.vol.model.CompagnieAerienneVol;
import voyage.vol.model.CompagnieAerienneVolId;
import voyage.vol.model.Vol;


@Repository
@Transactional
public class CompagnieAerienneVolDaoJpa implements CompagnieAerienneVolDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	@Transactional(readOnly = true)
	public CompagnieAerienneVol find(CompagnieAerienneVolId id){

		return em.find(CompagnieAerienneVol.class,  id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompagnieAerienneVol> findAll() {
		Query query = em.createQuery("select cav from CompagnieAerienneVol cav");
		return query.getResultList();
	}

	@Override
	public void create(CompagnieAerienneVol obj) {
		obj.setCompagnieAerienne(em.merge(obj.getCompagnieAerienne()));
		obj.setVol(em.merge(obj.getVol()));
		em.persist(obj);
	}

	@Override
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(CompagnieAerienneVol obj) {
		em.remove(obj);
	}

}
