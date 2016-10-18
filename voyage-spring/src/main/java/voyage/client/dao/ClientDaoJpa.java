package voyage.client.dao;

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

import voyage.client.model.Client;
import voyage.vol.dao.CompagnieAerienneVolDao;

@Repository
@Transactional
public class ClientDaoJpa implements ClientDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	public Client find(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		Query query = em.createQuery("select c from Client c");
		return query.getResultList();
	}

	@Override
	public void create(Client obj) {
		em.persist(obj);
	}

	
	@Override
	public Client update(Client obj) {
		return em.merge(obj);
	}
	

	@Override
	public void delete(Client obj) {
		obj = em.merge(obj);
		em.remove(obj);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAllByName(String name) {
		Query query = em.createQuery("select c from Client c where c.nom = :monNom");
		query.setParameter("monNom", name);
		return query.getResultList();
	}
	

}
