package voyage.client.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import voyage.Application;
import voyage.client.model.Passager;
import voyage.model.Reservation;

@Transactional
public class PassagerDaoJpa implements PassagerDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public Passager find(Long id) 
		{
			return em.find(Passager.class, id);
		}

	@Override
	@Transactional(readOnly=true)
	public List<Passager> findAll() 
		{
				Query query = em.createQuery("select p from Passager p");
				return query.getResultList();
		}

	@Override
	public void create(Passager obj) 
		{
			em.persist(obj);
		}

	@Override
	public Passager update(Passager obj) 
		{
			return em.merge(obj);
		}

	@Override
	public void delete(Passager obj) 
	{
		obj = em.merge(obj);

		for (Reservation reservation : obj.getReservations()) {
			reservationDao.delete(reservation);
		}

		em.remove(obj);
	}

}
