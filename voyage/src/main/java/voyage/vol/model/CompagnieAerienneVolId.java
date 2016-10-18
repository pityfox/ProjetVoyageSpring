package voyage.vol.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompagnieAerienneVolId implements Serializable{
	
	private CompagnieAerienne compagnieAerienne;
	private Vol vol;
	
	
	public CompagnieAerienneVolId() {
		super();
	}


	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}


	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compagnieAerienne == null) ? 0 : compagnieAerienne.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompagnieAerienneVolId other = (CompagnieAerienneVolId) obj;
		if (compagnieAerienne == null) {
			if (other.compagnieAerienne != null)
				return false;
		} else if (!compagnieAerienne.equals(other.compagnieAerienne))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
	
	
	
	

}
