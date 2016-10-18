package voyage.vol.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.vol.model.*;

@Repository
@Transactional
public class CompagnieAerienneDaoJpa implements CompagnieAerienneDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public CompagnieAerienne find(Long id) {
		return em.find(CompagnieAerienne.class, id);
	}

	@Override
	public List<CompagnieAerienne> findAll() {
		Query query = em.createQuery("select ca from CompagnieAerienne ca");
		return query.getResultList();
	}

	@Override
	public void create(CompagnieAerienne obj) {
		em.persist(obj);
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(CompagnieAerienne obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public List<CompagnieAerienne> findAllByName(String name) {
		Query query = em.createQuery("select ca from CompagnieAerienne ca where ca.nom = :monNomCompagnieAerienne");
		query.setParameter("monNomCompagnieAerienne", name);
		return query.getResultList();
	}



}
