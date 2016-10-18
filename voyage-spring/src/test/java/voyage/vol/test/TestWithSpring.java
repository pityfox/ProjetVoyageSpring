package voyage.vol.test;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import voyage.dao.ReservationDao;
//import voyage.dao.ReservationDao;
//import voyage.dao.ReservationDaoJpa;
import voyage.vol.dao.AeroportDao;
import voyage.vol.dao.AeroportVilleDao;
import voyage.vol.dao.CompagnieAerienneDao;
import voyage.vol.dao.CompagnieAerienneDaoJpa;
import voyage.vol.dao.CompagnieAerienneVolDao;
import voyage.vol.dao.CompagnieAerienneVolDaoJpa;
import voyage.vol.dao.EscaleDao;
import voyage.vol.dao.EscaleDaoJpa;
import voyage.vol.dao.VilleDao;
import voyage.vol.dao.VolDao;
import voyage.vol.dao.VolDaoJpa;

public class TestWithSpring {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AeroportDao aeroportDao = context.getBean(AeroportDao.class);
		VilleDao villeDao = context.getBean(VilleDao.class);
		VolDao volDao = new VolDaoJpa();
		EscaleDao escaleDao =new EscaleDaoJpa();
		AeroportVilleDao aeroportVilleDao = context.getBean(AeroportVilleDao.class);
		ReservationDao reservationDao = context.getBean(ReservationDao.class);
		CompagnieAerienneDao compagnieAerienneDao= new CompagnieAerienneDaoJpa();
		CompagnieAerienneVolDao compagnieAerienneVolDao =new CompagnieAerienneVolDaoJpa();
		
		
		

	}

}
