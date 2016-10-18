package voyage.client.model;

import java.util.*;
import javax.persistence.*;

import voyage.model.Reservation;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class Client {
	// ----------- ATTRIBUTS ----------- 
	private long id;
	private int version;
	private String nom;
	private String numeroTel;
	private String numeroFax;
	private String email;
	private Adresse adresse;
	private Login login = null;
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	// ----------- CONSTRUCTEURS -----------
	public Client() {
		super();
	}

	public Client(String nom, String numeroTel, String numeroFax, String email) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}

	// ----------- GETTERS & SETTERS -----------
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(length=50, nullable=false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="numero_tel", length=20)
	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	@Column(name="numero_fax", length=20)
	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	@Column(length=100, nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@OneToOne
	@JoinColumn(name="Login_id", nullable=true)
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy="client")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	// ----------- METHODES -----------
	public void addReservation(Reservation reservation){
		this.reservations.add(reservation);
	}

	public void removeReservation(Reservation reservation){
		this.reservations.remove(reservation);
	}
	
	// ToString
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", numeroTel=" + numeroTel + ", numeroFax=" + numeroFax
				+ ", email=" + email + "]";
	}
	
}
