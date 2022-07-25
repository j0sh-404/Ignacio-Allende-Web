package com.jnr.colegio.allende.data;

public class TituloLectura {
 private int idTitulo;
 private String tituloLectura;
 private String rutaPortada;
public TituloLectura(int idTitulo, String tituloLectura, String rutaPortada) {
	super();
	this.idTitulo = idTitulo;
	this.tituloLectura = tituloLectura;
	this.rutaPortada = rutaPortada;
}
public int getIdTitulo() {
	return idTitulo;
}
public void setIdTitulo(int idTitulo) {
	this.idTitulo = idTitulo;
}
public String getTituloLectura() {
	return tituloLectura;
}
public void setTituloLectura(String tituloLectura) {
	this.tituloLectura = tituloLectura;
}
public String getRutaPortada() {
	return rutaPortada;
}
public void setRutaPortada(String rutaPortada) {
	this.rutaPortada = rutaPortada;
}
 
 
}
