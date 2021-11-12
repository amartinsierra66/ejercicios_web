package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	
	//consultas parametrizadas
	void altaContacto(Contacto contacto);

	//elimina el contacto cuyo identificador se recibe como parámetro
	void eliminarContacto(int idContacto);

	//establece un nuevo email y edad, para el contacto cuyo identificador se recibe
	void actualizarDatosContacto(int idContacto, String email, int edad);

	
	List<Contacto> recuperarContactos();

	List<Contacto> recuperarContactos(String fin);
	
	void altaContactos(Contacto[] contactos);

}