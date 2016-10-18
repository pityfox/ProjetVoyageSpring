package voyage.vol.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import voyage.model.Reservation;



@Entity
public class Vol {
	
	private Long id;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	private int version;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private List<Escale> escales = new ArrayList<Escale>();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<CompagnieAerienneVol> compagniesAeriennes = new ArrayList<CompagnieAerienneVol>();
	public Vol() {
		super();
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	

	@ManyToOne
	@JoinColumn(name = "aeroport_arrivee_id", nullable=false)
	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}


	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	@ManyToOne
	@JoinColumn(name = "aeroport_depart_id", nullable=false)
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}


	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="date_depart", nullable=false)
	public Date getDateDepart() {
		return dateDepart;
	}


	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_arrivee", nullable=false)
	public Date getDateArrivee() {
		return dateArrivee;
	}


	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}


	@Temporal(TemporalType.TIME)
	@Column(name="heure_depart", nullable=false)
	public Date getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}


	@Temporal(TemporalType.TIME)
	@Column(name="heure_arrivee", nullable=false)
	public Date getHeureArrivee() {
		return heureArrivee;
	}


	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}


	@Version
	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@OneToMany (fetch = FetchType.EAGER, mappedBy = "id.vol") // IdClass
	// Embedded Id
//	@JoinColumns({ @JoinColumn(referencedColumnName = "vol", name = "escale_vol"),
//		@JoinColumn(referencedColumnName = "aeroport", name = "escale_aeroport") }) 
	public List<Escale> getEscales() {
		return escales;
	}


	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "vol")
	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="vol")
	public List<CompagnieAerienneVol> getCompagniesAeriennes() {
		return compagniesAeriennes;
	}


	public void setCompagniesAeriennes(List<CompagnieAerienneVol> compagniesAeriennes) {
		this.compagniesAeriennes = compagniesAeriennes;
	}


	// -------- METHODES ------------
	public void addEscale(Escale escale) {
		this.escales.add(escale);
	}

	public void removeEscale(Escale escale) {
		this.escales.remove(escale);
	}
	
	public void addReservation(Reservation reservation){
		reservations.add(reservation);
	}
	
	public void removeReservation(Reservation reservation){
		reservations.remove(reservation);
	}
	
}
