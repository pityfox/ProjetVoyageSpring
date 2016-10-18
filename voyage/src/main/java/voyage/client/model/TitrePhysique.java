package voyage.client.model;

public enum TitrePhysique {
	MR("Mr"), MME("Mme"), MLLE("Mlle");
	
	private final String label;

	private TitrePhysique(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
	
}
