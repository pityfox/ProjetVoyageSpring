package voyage.vol.model;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name = "aeroport_ville")
@IdClass(AeroportVilleId.class)
public class AeroportVille {
	
	private Aeroport aeroport;
	private Ville ville;
	private int version;
	
	
	public AeroportVille() {
		super();
	}
	
	
	
	public AeroportVille(Aeroport aeroport, Ville ville) {
		super();
		this.aeroport = aeroport;
		this.ville = ville;
	}



	@Id
	@ManyToOne
	@JoinColumn(name = "aeroport_id")
	public Aeroport getAeroport() {
		return aeroport;
	}
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ville_id")
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	

}
