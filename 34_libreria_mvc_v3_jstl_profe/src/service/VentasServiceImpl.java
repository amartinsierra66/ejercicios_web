package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import locator.DatosLocator;
import model.Cliente;
import model.Libro;

public class VentasServiceImpl implements VentasService {

	@Override
	public void nuevaVenta(Cliente cliente, List<Libro> libros) {
		try(Connection cn=DatosLocator.getConnection();) {                       	           
            String sql="insert into ventas (idCliente, idLibro, fecha) values(?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
            for(Libro libro:libros) {
            	ps.setInt(1, cliente.getIdCliente());
            	ps.setInt(2, libro.getIsbn());
            	ps.setTimestamp(3, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            	ps.execute();
            }
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }

	}

}
