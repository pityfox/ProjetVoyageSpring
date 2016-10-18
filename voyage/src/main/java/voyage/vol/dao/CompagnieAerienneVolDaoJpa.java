package voyage.vol.dao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import voyage.Application;
import voyage.vol.model.CompagnieAerienneVol;
import voyage.vol.model.CompagnieAerienneVolId;
import voyage.vol.model.Vol;

public class CompagnieAerienneVolDaoJpa implements CompagnieAerienneVolDao {
	
	@Override
	public CompagnieAerienneVol find(CompagnieAerienneVolId id){
		
		CompagnieAerienneVol compagnieAerienneVol=null;
		EntityManager em=null;
		EntityTransaction tx=null;
		try{
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();
			compagnieAerienneVol = em.find(CompagnieAerienneVol.class, id);
			
			
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
		return  compagnieAerienneVol;
	}
	
	@Override
	public List<CompagnieAerienneVol> findAll() {
		List<CompagnieAerienneVol> compagnieAerienneVols = new ArrayList<CompagnieAerienneVol>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Query query = em.createQuery("select ca from CompagnieAerienneVol ca");
			compagnieAerienneVols = query.getResultList();
			
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
		return compagnieAerienneVols;
	}
	
	@Override
		public void create(CompagnieAerienneVol obj) {
				CompagnieAerienneVol compagnieAerienneVol = null;
				EntityManager em = null;
				EntityTransaction tx = null;
				try {
					em = Application.getInstance().getEmf().createEntityManager();
					tx = em.getTransaction();

					tx.begin();
			
			Vol vol = em.merge(obj.getVol());
			obj.setVol(vol);
			obj.setCompagnieAerienne(em.merge(obj.getCompagnieAerienne()));
			
			
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
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		CompagnieAerienneVol compagnieAerienneVol = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			compagnieAerienneVol = em.merge(obj);
			
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
		return compagnieAerienneVol;
	}

	@Override
	public void delete(CompagnieAerienneVol obj) {
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
	}


