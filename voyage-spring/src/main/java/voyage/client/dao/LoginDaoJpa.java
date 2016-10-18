package voyage.client.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import voyage.client.model.Login;

@Repository
@Transactional
public class LoginDaoJpa implements LoginDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public Login find(Long id) 
		{
		
		return em.find(Login.class, id);
		}

	@Override
	@Transactional(readOnly=true)
	public List<Login> findAll() 
		{
			Query query = em.createQuery("select c from Login c");
			return query.getResultList();
		}

	@Override
	public void create(Login obj) 
			{
				em.persist(obj);
			}

	@Override
	public Login update(Login obj)
			{
				return em.merge(obj);
			}

	@Override
	public void delete(Login obj) 
			{
				obj = em.merge(obj);
				em.remove(obj);
			}
	
}
