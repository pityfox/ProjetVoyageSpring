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
public class VilleDaoJpa implements VilleDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public Ville find(Long id) {
		return em.find(Ville.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ville> findAll() {
		Query query = em.createQuery("select v from Ville v");
		return query.getResultList();
	}

	@Override
	public void create(Ville obj) {
		em.persist(obj);
	}

	@Override
	public Ville update(Ville obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Ville obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ville> findAllByName(String name) {
		Query query = em.createQuery("select v from Ville v where c.nomVille = :monNomVille");
		query.setParameter("monNomVille", name);
		return query.getResultList();
	}
}
