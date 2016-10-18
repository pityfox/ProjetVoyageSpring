package voyage.client.model;

public enum TitreMoral {
	SARL("SARL");
	
	private String titre;
	
	private TitreMoral(String titre){
		this.titre = titre;
	}
	
	public String getTitre(){
		return titre;
	}
}
