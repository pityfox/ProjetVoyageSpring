package voyage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import voyage.client.model.Client;
import voyage.client.model.Passager;
import voyage.vol.model.Vol;

@Entity
public class Reservation {

	private Long id;
	private Date date;
	private Integer numero;
	private Passager passager;
	private Client client;
	private Vol vol;
	private int version;
	
	public Reservation() {
		super();
	}

	public Reservation(Date date, Integer numero) {
		super();
		this.date = date;
		this.numero = numero;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(length=50, nullable=false)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne
	@JoinColumn(name="passager_id", nullable=false)
	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne
	@JoinColumn(name="vol_id", nullable=false)
	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", numero=" + numero + ", passager=" + passager
				+ ", client=" + client + ", vol=" + vol + ", version=" + version + "]";
	}


	
	
}
