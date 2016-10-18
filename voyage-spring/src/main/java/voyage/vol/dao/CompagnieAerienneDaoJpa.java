package voyage.vol.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.vol.model.*;

@Repository
@Transactional
public class CompagnieAerienneDaoJpa implements CompagnieAerienneDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired()
	@Qualifier("CompagnieAerienneDaoJpa")
	private CompagnieAerienneVolDao compagnieAerienneVolDao;

	@Override
	@Transactional(readOnly=true)
	public CompagnieAerienne find(Long id) {
		
		return em.find(CompagnieAerienne.class, id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompagnieAerienne> findAll() {
		Query query = em.createQuery("select ca from CompagnieAerienne ca");
		return query.getResultList();
	}

	@Override
	public void create(CompagnieAerienne obj) {
		em.persist(obj);
		
		em.persist(obj);
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(CompagnieAerienne obj) {
		for (CompagnieAerienneVol compagnieAerienneVol : obj.getVols()) {
		em.remove(em.merge(obj));
			compagnieAerienneVolDao.delete(compagnieAerienneVol);
		}

		em.remove(obj);
	}

	@Override
	public List<CompagnieAerienne> findAllByName(String name) {
			Query query = em.createQuery("select ca from CompagnieAerienne ca where ca.nom = :monNomCompagnieAerienne");
			query.setParameter("monNomCompagnieAerienne", name);
			return query.getResultList();
	}



}
