package voyage.vol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Escale")
//@IdClass(EscaleId.class)
public class Escale  {
	
	private EscaleId id; //Embedded
	private int version;
	private Date heureDepart;
	private Date heureArrivee;
//	private Vol vol; //IdClass
//	private Aeroport aeroport; //IdClass
	
	
	public Escale() {
		super();
	}
	
	
	
	@EmbeddedId // Embedded
	public EscaleId getId() {
		return id;
	}
	
	public void setId(EscaleId id) {
		this.id = id;
	}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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

	// Pour l'ID CLASS
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "Vol_id", nullable=false)
//	public Vol getVol() {
//		return vol;
//	}
//
//	public void setVol(Vol vol) {
//		this.vol = vol;
//	}
//
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "Aeroport_id", nullable=false)
//	public Aeroport getAeroport() {
//		return aeroport;
//	}
//
//	
//	public void setAeroport(Aeroport aeroport) {
//		this.aeroport = aeroport;
//	}
	
	
	
	
	
	
	

}
