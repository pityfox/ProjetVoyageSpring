package voyage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import voyage.Application;
import voyage.model.Reservation;


@Transactioanal
public class ReservationDaoJpa implements ReservationDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactioanal(readOnly=true)
	public Reservation find(Long id)
		{
			return em.find(Reservation.class, id);
		}

	@Override
	@Transactional(readOnly=true)
	public List<Reservation> findAll()
		{
			Query query = em.createQuery("select r from Reservation r");
			return query.getResultList();
		}

	@Override
	public void create(Reservation obj) 
		{
			em.persist(obj);
		}

	@Override
	public Reservation update(Reservation obj) 
		{
			return em.merge(obj);
		}

	@Override
	public void delete(Reservation obj) 
		{
			obj = em.merge(obj);
			em.merge(obj);	
		}

}
