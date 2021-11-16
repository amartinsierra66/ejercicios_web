package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import locator.DatosBd;
import model.Contacto;

public class ContactosServiceBdImpl implements ContactosService {
	
	/*public void altaContacto(Contacto contacto) {
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			//2. Enviar instrucción SQL
			String sql="Insert into contactos(nombre, email, edad) values('"+
				contacto.getNombre()+"','"+
				contacto.getEmail()+"',"+
				contacto.getEdad()+")";
			Statement st=con.createStatement();
			st.execute(sql);
			
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}*/
	//consultas parametrizadas
	@Override
	public void altaContacto(Contacto contacto) {
		try(Connection con=DatosBd.getConnection()){
			//2. Enviar instrucción SQL
			String sql="Insert into contactos(nombre, email, edad) values(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			st.setString(1, contacto.getNombre());
			st.setString(2, contacto.getEmail());
			st.setInt(3, contacto.getEdad());
			st.execute();
			
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	//elimina el contacto cuyo identificador se recibe como parámetro
	@Override
	public void eliminarContacto(int idContacto) {
		try(Connection con=DatosBd.getConnection()){
			//2. Enviar instrucción SQL
			String sql="delete from contactos where idContacto=?";
			PreparedStatement st=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			st.setInt(1, idContacto);			
			st.execute();			
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	//establece un nuevo email y edad, para el contacto cuyo identificador se recibe
	@Override
	public void actualizarDatosContacto(int idContacto, String email, int edad) {
		try(Connection con=DatosBd.getConnection()){
			//2. Enviar instrucción SQL
			String sql="update contactos set email=?,edad=? where idContacto=?";
			PreparedStatement st=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			st.setString(1, email);
			st.setInt(2, edad);
			st.setInt(3, idContacto);
			st.execute();			
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//Devuelve los contactos cuyo email termina en la cadena recibida
	/*public List<Contacto> recuperarContactos(String fin){
		List<Contacto> contactos=new ArrayList<>();
		try(Connection con=DriverManager.getConnection(cadenaConexion, user, pwd);){
			//2. Enviar instrucción SQL
			String sql="select * from contactos ";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("email").endsWith(fin)) {
					contactos.add(new Contacto(rs.getInt("idContacto"), 
							rs.getString("nombre"), 
							rs.getString("email"), 
							rs.getInt("edad")));
				}
			}
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}*/
	@Override
	public List<Contacto> recuperarContactos(){
		List<Contacto> contactos=new ArrayList<>();
		try(Connection con=DatosBd.getConnection()){
			//2. Enviar instrucción SQL
			String sql="select * from contactos ";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();			
			while(rs.next()) {				
					contactos.add(new Contacto(rs.getInt("idContacto"), 
							rs.getString("nombre"), 
							rs.getString("email"), 
							rs.getInt("edad")));				
			}
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return contactos;
	}
	
	@Override
	public List<Contacto> recuperarContactos(String fin){
		return recuperarContactos().stream()
			.filter(c->c.getEmail().endsWith(fin))
			.collect(Collectors.toList());
	}
	@Override
	public void altaContactos(Contacto[] contactos) {
		try(Connection con=DatosBd.getConnection()){
			//desactivar autocommit
			con.setAutoCommit(false);
			//2. Enviar instrucción SQL
			String sql="Insert into contactos(nombre, email, edad) values(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			for(Contacto c:contactos) {
				//sustituimos parámetros por valores
				st.setString(1, c.getNombre());
				st.setString(2, c.getEmail());
				st.setInt(3, c.getEdad());
				st.execute();
			}
			//confirmar transcción
			con.commit();
			
			//3. cerrar conexión
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
