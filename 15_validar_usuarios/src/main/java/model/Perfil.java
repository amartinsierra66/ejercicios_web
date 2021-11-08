package model;

public class Perfil {
	private String usuario;
	private String email;
	private int edad;
	public Perfil(String usuario, String email, int edad) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.edad = edad;
	}
	public Perfil() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
