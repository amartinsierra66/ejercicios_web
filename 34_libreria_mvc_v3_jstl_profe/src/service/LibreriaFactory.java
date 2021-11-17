package service;

public class LibreriaFactory {
	public static ClientesService getClientesService() {
		return new ClientesServiceImpl();
	}
	public static LibrosService getLibrosService() {
		return new LibrosServiceImpl();
	}
	public static TemasService getTemasService() {
		return new TemasServiceImpl();
	}
	public static VentasService getVentasService() {
		return new VentasServiceImpl();
	}
}
