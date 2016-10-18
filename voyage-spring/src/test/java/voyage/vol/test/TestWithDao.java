package voyage.vol.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import voyage.model.Reservation;
import voyage.Application;
import voyage.vol.dao.AeroportDao;
import voyage.vol.dao.AeroportDaoJpa;
import voyage.vol.dao.AeroportVilleDao;
import voyage.vol.dao.AeroportVilleDaoJpa;
import voyage.vol.dao.CompagnieAerienneDao;
import voyage.vol.dao.CompagnieAerienneDaoJpa;
import voyage.vol.dao.CompagnieAerienneVolDao;
import voyage.vol.dao.CompagnieAerienneVolDaoJpa;
import voyage.vol.dao.EscaleDao;
import voyage.vol.dao.EscaleDaoJpa;
import voyage.dao.ReservationDao;
import voyage.dao.ReservationDaoJpa;
import voyage.vol.dao.VilleDao;
import voyage.vol.dao.VilleDaoJpa;
import voyage.vol.dao.VolDao;
import voyage.vol.dao.VolDaoJpa;
import voyage.vol.model.Aeroport;
import voyage.vol.model.AeroportVille;
import voyage.vol.model.CompagnieAerienne;
import voyage.vol.model.CompagnieAerienneVol;
import voyage.vol.model.Escale;
import voyage.vol.model.EscaleId;
import voyage.vol.model.Ville;
import voyage.vol.model.Vol;

public class TestWithDao {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat heure = new SimpleDateFormat("h:mm a");

	public static void main(String[] args) throws ParseException {

		AeroportDao aeroportDao = new AeroportDaoJpa();
		VilleDao villeDao = new VilleDaoJpa();
		VolDao volDao = new VolDaoJpa();
		EscaleDao escaleDao =new EscaleDaoJpa();
		AeroportVilleDao aeroportVilleDao = new AeroportVilleDaoJpa();
		ReservationDao reservationDao = new ReservationDaoJpa();
		CompagnieAerienneDao compagnieAerienneDao= new CompagnieAerienneDaoJpa();
		CompagnieAerienneVolDao compagnieAerienneVolDao =new CompagnieAerienneVolDaoJpa();
		
		Aeroport aeroportCdg = new Aeroport();
		aeroportCdg.setNom("Charles de Gaulle");
		aeroportDao.create(aeroportCdg);
		
		aeroportCdg.setNom("Roissy Charles de Gaulle");
		aeroportCdg = aeroportDao.update(aeroportCdg);
		
		Aeroport aeroportJfk = new Aeroport();
		aeroportJfk.setNom("New York JFK");
		aeroportDao.create(aeroportJfk);
		
		Aeroport aeroportLax = new Aeroport();
		aeroportLax.setNom("LAX");
		aeroportDao.create(aeroportLax);
		
		Aeroport aeroportChicago = new Aeroport();
		aeroportChicago.setNom("Chicago O'Hare");
		aeroportDao.create(aeroportChicago);
		
		Aeroport aeroportOrly = new Aeroport();
		aeroportOrly.setNom("Aéroport d'Orly");
		aeroportDao.create(aeroportOrly);
		
		Reservation reservation1 = new Reservation();
		reservation1.setDate(sdf.parse("01/10/2016"));
		reservation1.setNumero(1234);
		reservationDao.create(reservation1);

		
		Ville paris = new Ville();
		paris.setNom("paname");
		villeDao.create(paris);

		paris.setNom("Paris");
		paris = villeDao.update(paris);
		
		Ville roissy = new Ville();
		roissy.setNom("Roissy");
		villeDao.create(roissy);
		
		Ville orly = new Ville();
		orly.setNom("Orly");
		villeDao.create(orly);
		
		Ville ny = new Ville();
		ny.setNom("New York");
		villeDao.create(ny);
		
		Ville la = new Ville();
		la.setNom("Los Angeles");
		villeDao.create(la);
		
		Ville chicago = new Ville();
		chicago.setNom("Chicago");
		villeDao.create(chicago);
		
		AeroportVille av1 = new AeroportVille();
		av1.setAeroport(aeroportCdg);
		av1.setVille(roissy);
		aeroportVilleDao.create(av1);
		
		AeroportVille av2 = new AeroportVille();
		av2.setAeroport(aeroportChicago);
		av2.setVille(chicago);
		aeroportVilleDao.create(av2);
		
		AeroportVille av3 = new AeroportVille();
		av3.setAeroport(aeroportCdg);
		av3.setVille(paris);
		aeroportVilleDao.create(av3);
		
		AeroportVille av4 = new AeroportVille();
		av4.setAeroport(aeroportJfk);
		av4.setVille(ny);
		aeroportVilleDao.create(av4);
		
		AeroportVille av5 = new AeroportVille();
		av5.setAeroport(aeroportLax);
		av5.setVille(la);
		aeroportVilleDao.create(av5);
		
		AeroportVille av6 = new AeroportVille();
		av6.setAeroport(aeroportOrly);
		av6.setVille(paris);
		aeroportVilleDao.create(av6);
		
	
		CompagnieAerienne compagnieAerienne1=new CompagnieAerienne();
		compagnieAerienne1.setNom("Air France");
		compagnieAerienneDao.create(compagnieAerienne1);
		
		CompagnieAerienne compagnieAerienne2=new CompagnieAerienne();
		compagnieAerienne2.setNom("Air Canada");
		compagnieAerienneDao.create(compagnieAerienne2);
		
		Vol vol1 = new Vol();
		vol1.setAeroportDepart(aeroportCdg);
		vol1.setAeroportArrivee(aeroportLax);
		vol1.setDateDepart(sdf.parse("10/10/2016"));
		vol1.setDateArrivee(sdf.parse("11/10/2016"));
		vol1.setHeureDepart(heure.parse("11:30 PM"));
		vol1.setHeureArrivee(heure.parse("01:30 PM"));
		volDao.create(vol1);
		
		CompagnieAerienneVol compvol1 = new CompagnieAerienneVol();
		compvol1.setCompagnieAerienne(compagnieAerienne1);
		compvol1.setVol(vol1);
		compagnieAerienneVolDao.create(compvol1);
		
		Escale escale1 = new Escale();
//		escale1.setAeroport(aeroportJfk);
//		escale1.setVol(vol1);
		escale1.setId(new EscaleId(aeroportJfk,vol1)); //Embedded
		escale1.setHeureDepart(heure.parse("09:30 AM"));
		escale1.setHeureArrivee(heure.parse("08:30 AM"));
		escaleDao.create(escale1);
		
		Escale escale2 = new Escale();
//		escale2.setAeroport(aeroportChicago);
//		escale2.setVol(vol1);
		escale2.setId(new EscaleId(aeroportChicago,vol1)); //Embedded
		escale2.setHeureDepart(heure.parse("12:30 AM"));
		escale2.setHeureArrivee(heure.parse("11:30 AM"));
		escaleDao.create(escale2);
		
//		vol1.addEscale(escale2);
//		vol1.addEscale(escale1);
//		vol1.setAeroportDepart(aeroportOrly);
//		vol1 = volDao.update(vol1);
		
		
		
		
		
		Application.close();
	}
	
}
