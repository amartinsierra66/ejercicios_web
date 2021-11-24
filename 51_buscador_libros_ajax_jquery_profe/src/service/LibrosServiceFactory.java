package service;

public class LibrosServiceFactory {
	public static LibrosService getLibrosService() {
		return new LibrosServiceImpl();
	}
}
