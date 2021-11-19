/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Antonio
 */
public class Pais {
	@SerializedName("name")
    private String nombre;
    @SerializedName("region")
    private String continente;
    @SerializedName("population")
    private long habitantes;
    private String capital;
    @SerializedName("flag")
    private String bandera;
	public Pais(String nombre, String continente, long habitantes, String capital) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.habitantes = habitantes;
		this.capital = capital;
	}
	public Pais() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getBandera() {
		return bandera;
	}
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
   
}
