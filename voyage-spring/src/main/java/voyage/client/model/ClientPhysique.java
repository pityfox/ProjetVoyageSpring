package voyage.client.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value="ClientPhysique")
public class ClientPhysique extends Client {
	// ------------ ATTRIBUTS -------------
	private TitrePhysique titre;
	private String prenom;
	
	// ------------ CONSTRUCTEURS -------------
	public ClientPhysique() {
		super();
	}
	
	public ClientPhysique(String nom, String prenom, String numeroTel, String numeroFax, String email, TitrePhysique titre) {
		super(nom, numeroTel, numeroFax, email);
		this.titre = titre;
		this.prenom = prenom;
	}
	
	// ------------ GETTERS & SETTERS -------------
	@Enumerated(EnumType.STRING)
	public TitrePhysique getTitre() {
		return titre;
	}
	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}
	
	@Column(length=50)
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	
	
	// ------------ METHODES -------------
}
