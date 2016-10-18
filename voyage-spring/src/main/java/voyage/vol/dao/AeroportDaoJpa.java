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
public class AeroportDaoJpa implements AeroportDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public Aeroport find(Long id) {
		return em.find(Aeroport.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Aeroport> findAll() {
		Query query = em.createQuery("select a from Aeroport a");
		return query.getResultList();
	}

	@Override
	public void create(Aeroport obj) {
		em.persist(obj);
	}

	@Override
	public Aeroport update(Aeroport obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Aeroport obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Aeroport> findAllByName(String name) {
		Query query = em.createQuery("select a from Aeroport a where c.nomAeroport = :monNomAeroport");
		query.setParameter("monNomAeroport", name);
		return query.getResultList();
	}

}
