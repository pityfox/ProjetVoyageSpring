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
public class VolDaoJpa implements VolDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Vol find(Long id) {
			Query query = em.createQuery("select distinct v from Vol v where v.id=:idVol");
			query.setParameter("idVol", id);
			return (Vol) query.getSingleResult();
	}

	@Override
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
			em.remove(em.merge(obj));
	}
}
