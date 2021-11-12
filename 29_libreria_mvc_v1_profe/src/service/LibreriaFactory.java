package service;

public class LibreriaFactory {
	public static ClientesService getClientesService() {
		return new ClientesServiceImpl();
	}
	
}
