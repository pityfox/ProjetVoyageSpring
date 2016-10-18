package voyage.client.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import voyage.Application;
import voyage.client.dao.ClientDao;
import voyage.client.dao.ClientDaoJpa;
import voyage.client.dao.LoginDao;
import voyage.client.dao.LoginDaoJpa;
import voyage.client.dao.PassagerDao;
import voyage.client.dao.PassagerDaoJpa;
import voyage.client.model.Adresse;
import voyage.client.model.Client;
import voyage.client.model.ClientEI;
import voyage.client.model.ClientMoral;
import voyage.client.model.ClientPhysique;
import voyage.client.model.Login;
import voyage.client.model.Passager;
import voyage.client.model.TitreMoral;
import voyage.client.model.TitrePhysique;
import voyage.dao.ReservationDao;
import voyage.dao.ReservationDaoJpa;
import voyage.model.Reservation;

public class Test {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) throws ParseException {

		ReservationDao reservationDao=new ReservationDaoJpa();
		PassagerDao passagerDao=new PassagerDaoJpa();
		
		Reservation resa1=new Reservation(sdf.parse("08/08/2016"), 15478);
		Reservation resa2=new Reservation(sdf.parse("09/08/2016"), 15479);
		Reservation resa3=new Reservation(sdf.parse("10/08/2016"), 15480);
		Reservation resa4=new Reservation(sdf.parse("11/08/2016"), 15481);
		
		Passager p1=new Passager("Dupond", "Michel");
		Passager p2=new Passager("BIDULE", "chose");
		Passager p3=new Passager("MACHIN", "Truc");
		
		passagerDao.create(p1);
		passagerDao.create(p2);
		passagerDao.create(p3);
		
		p1.setAdresse(new Adresse("1 rue de la paix", "75004", "Paris", "France"));
		p2.setAdresse(new Adresse("1 place de la bourse", "75002", "Paris", "France"));
		p3.setAdresse(new Adresse("1 deux trois soleil", "94000", "Créteil", "France"));

		
		p1=passagerDao.update(p1);
		p2=passagerDao.update(p2);
		p3=passagerDao.update(p3);
		
		resa1.setPassager(p1);
		resa2.setPassager(p1);
		resa3.setPassager(p2);
		resa4.setPassager(p1);
		resa4.setPassager(p2);
		resa4.setPassager(p3);
		
		reservationDao.create(resa1);
		reservationDao.create(resa2);
		reservationDao.create(resa3);
		reservationDao.create(resa4);
		
		// Test Clients
		ClientDao clientDao = new ClientDaoJpa();
		
		Client client1 = new ClientPhysique("MICHELIN", "luc", "0123456789", "015478965", "luc@google.com", TitrePhysique.MR);
		Client client2 = new ClientMoral("MACHIN", "0352698745", "", "machin@lol.fr", TitreMoral.SARL, "12357879848974");
		Client client3 = new ClientEI("TRUC", "jacqueline", "456789465", "7845645", "truc.j@boite.com", TitrePhysique.MLLE);
		clientDao.create(client1);
		clientDao.create(client2);
		clientDao.create(client3);
		
		// Test Logins
		LoginDao logDao = new LoginDaoJpa();
		
		Login log1 = new Login("popol","mdp",false);
		Login log2 = new Login("loul","lel",true);
		
		logDao.create(log1);
		logDao.create(log2);
		
		// Ajouts sur Clients
		client1.setLogin(log1);
		client1.addReservation(resa1);
		client1.addReservation(resa4);
		client1.setAdresse(new Adresse("RUE DU MORT", "75666", "Paris", "France"));
		client1 = clientDao.update(client1);
		
		client2.setLogin(log2);
		client2 = clientDao.update(client2);
		
		
		resa2.setClient(client2);
		resa2 = reservationDao.update(resa2);
		
		resa3.setClient(client3);
		resa3 = reservationDao.update(resa3);

		Application.close();
		

	}

}
