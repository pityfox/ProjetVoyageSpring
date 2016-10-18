package voyage.vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compagnie_aerienne")
public class CompagnieAerienne {

	private long id;
	private String nom;
	private List<CompagnieAerienneVol> vols = new ArrayList<CompagnieAerienneVol>();
	
	public CompagnieAerienne() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(length=100, nullable = false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "compagnieAerienne")
	public List<CompagnieAerienneVol> getVols() {
		return vols;
	}

	public void setVols(List<CompagnieAerienneVol> vols) {
		this.vols = vols;
	}
	
	
	public void addVol(CompagnieAerienneVol vol){
		vols.add(vol);
	}
	
	public void removeVol(CompagnieAerienneVol vol){
		vols.remove(vol);
	}
	
}
