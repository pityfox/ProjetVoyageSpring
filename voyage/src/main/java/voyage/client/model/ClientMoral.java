package voyage.client.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value="ClientMoral")
public class ClientMoral extends Client {
	// ------------ ATTRIBUTS -------------
	private TitreMoral titre;
	private String siret;
	
	// ------------ CONSTRUCTEURS -------------
	public ClientMoral() {
		super();
	}
	
	public ClientMoral(String nom, String numeroTel, String numeroFax, String email, TitreMoral titre, String siret) {
		super(nom, numeroTel, numeroFax, email);
		this.titre = titre;
		this.siret = siret;
	}
	
	// ------------ GETTERS & SETTERS -------------
	@Enumerated(EnumType.STRING)
	public TitreMoral getTitre() {
		return titre;
	}
	
	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}
	
	@Column(length=50)
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	// ------------ METHODES -------------
}
