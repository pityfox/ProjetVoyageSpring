package voyage.vol.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.vol.model.Escale;
import voyage.vol.model.EscaleId;

@Repository
@Transactional
public class EscaleDaoJpa implements EscaleDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Escale find(EscaleId id) {
		return em.find(Escale.class, id);
	}

	@Override
	public List<Escale> findAll() {
		Query query = em.createQuery("select e from Escale e");
		return query.getResultList();
	}

	@Override
	public void create(Escale obj) {
		em.persist(obj);
	}

	@Override
	public Escale update(Escale obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Escale obj) {
		em.remove(em.merge(obj));
	}



}
