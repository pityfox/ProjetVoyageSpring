package voyage.vol.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import voyage.Application;
import voyage.vol.model.*;

public class CompagnieAerienneDaoJpa implements CompagnieAerienneDao{

	@Override
	public CompagnieAerienne find(Long id) {
		CompagnieAerienne compagnieAerienne = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			compagnieAerienne = em.find(CompagnieAerienne.class, id);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return compagnieAerienne;
	}

	@Override
	public List<CompagnieAerienne> findAll() {
		List<CompagnieAerienne> compagnieAeriennes = new ArrayList<CompagnieAerienne>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select ca from CompagnieAerienne ca");
			compagnieAeriennes = query.getResultList();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return compagnieAeriennes;
	}

	@Override
	public void create(CompagnieAerienne obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.persist(obj);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}

	@Override
	public CompagnieAerienne update(CompagnieAerienne obj) {
		CompagnieAerienne compagnieAerienne = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			compagnieAerienne = em.merge(obj);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return compagnieAerienne;
	}

	@Override
	public void delete(CompagnieAerienne obj) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.remove(em.merge(obj));
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<CompagnieAerienne> findAllByName(String name) {
		List<CompagnieAerienne> compagnieAeriennes = new ArrayList<CompagnieAerienne>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select ca from CompagnieAerienne ca where ca.nom = :monNomCompagnieAerienne");
			query.setParameter("monNomCompagnieAerienne", name);
			compagnieAeriennes = query.getResultList();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return compagnieAeriennes;
	}



}
