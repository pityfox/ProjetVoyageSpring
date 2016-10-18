package voyage.vol.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.vol.model.AeroportVille;
import voyage.vol.model.AeroportVilleId;


@Repository
@Transactional
public class AeroportVilleDaoJpa implements AeroportVilleDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public  AeroportVille find(AeroportVilleId id) {
			 return em.find( AeroportVille.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<AeroportVille> findAll() {
			Query query = em.createQuery("select av from  AeroportVille av");
			return query.getResultList();
	}

	@Override
	public void create(AeroportVille obj) {
			obj.setAeroport(em.merge(obj.getAeroport()));
			obj.setVille(em.merge(obj.getVille()));
			
			em.persist(obj);
	}

	@Override
	public  AeroportVille update(AeroportVille obj) {
			return em.merge(obj);
	}

	@Override
	public void delete(AeroportVille obj) {
			em.remove(em.merge(obj));
	}
		
	

}
