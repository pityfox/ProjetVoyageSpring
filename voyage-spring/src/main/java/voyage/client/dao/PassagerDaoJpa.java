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

import voyage.client.model.Passager;
import voyage.dao.ReservationDao;
import voyage.model.Reservation;

@Repository
@Transactional
public class PassagerDaoJpa implements PassagerDao{
	@PersistenceContext
	private EntityManager em;

	@Autowired
	@Qualifier("reservationDaoJpa")
	private ReservationDao reservationDao;
	
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

		for (Reservation reservation : obj.getreservations()) {
			reservationDao.delete(reservation);
		}

		em.remove(obj);
	}

}
