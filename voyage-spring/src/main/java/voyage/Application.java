package voyage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
	private static Application instance = null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("voyage");

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}
	
	public static void close() {
		getInstance().emf.close();
		getInstance().emf = null;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}
