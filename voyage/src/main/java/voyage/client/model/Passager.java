package voyage.client.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import voyage.model.Reservation;

@Entity
public class Passager {
	
	private Long id;
	private String nom;
	private String prenom;
	private Adresse adresse;
	private List<Reservation> reservations;
	private int version;
	
	
	
	public Passager() {
		super();
	}

	public Passager(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=50, nullable=false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(length=50, nullable=false)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy="passager")
	public List<Reservation> getreservations() {
		return reservations;
	}

	public void setreservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Column(nullable=false)
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	// ------ METHODES --------
	public void addReservation(Reservation reservation){
		reservations.add(reservation);
	}
	
	public void removeReservation(Reservation reservation){
		reservations.remove(reservation);
	}

}
