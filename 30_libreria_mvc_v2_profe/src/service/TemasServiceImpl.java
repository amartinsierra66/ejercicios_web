/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.DatosLocator;
import model.Tema;

/**
 *
 * @author Profesortarde
 */
 public class TemasServiceImpl implements TemasService {
	 
 
    @Override
	public List<Tema> obtenerTemas(){
        List<Tema> lista=new ArrayList<> ();
           
        try(Connection cn=DatosLocator.getConnection()) {                       
            String sql="select * from temas";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista;
    }

	@Override
	public Tema recuperarTemaPorId(int idTema) {
		Tema tema=null;
        
        try(Connection cn=DatosLocator.getConnection()) {                       
            String sql="select * from temas where idTema=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idTema);
            ResultSet rs=st.executeQuery();            
            if(rs.next()){
                tema=new Tema(rs.getInt("idTema"),rs.getString("tema"));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return tema;
	}
}
