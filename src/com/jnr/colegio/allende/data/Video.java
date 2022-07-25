package com.jnr.colegio.allende.data;

public class Video {
private int idVideo;
private String subtituloLectura;
private String cuerpoLectura;
private String rutaVideo;
private String rutaCodigoQr;
private int idTituloLectura;
public Video(int idVideo, String subtituloLectura, String cuerpoLectura, String rutaVideo, String rutaCodigoQr,
		int idTituloLectura) {
	super();
	this.idVideo = idVideo;
	this.subtituloLectura = subtituloLectura;
	this.cuerpoLectura = cuerpoLectura;
	this.rutaVideo = rutaVideo;
	this.rutaCodigoQr = rutaCodigoQr;
	this.idTituloLectura = idTituloLectura;
}
public int getIdVideo() {
	return idVideo;
}
public void setIdVideo(int idVideo) {
	this.idVideo = idVideo;
}
public String getSubtituloLectura() {
	return subtituloLectura;
}
public void setSubtituloLectura(String subtituloLectura) {
	this.subtituloLectura = subtituloLectura;
}
public String getCuerpoLectura() {
	return cuerpoLectura;
}
public void setCuerpoLectura(String cuerpoLectura) {
	this.cuerpoLectura = cuerpoLectura;
}
public String getRutaVideo() {
	return rutaVideo;
}
public void setRutaVideo(String rutaVideo) {
	this.rutaVideo = rutaVideo;
}
public String getRutaCodigoQr() {
	return rutaCodigoQr;
}
public void setRutaCodigoQr(String rutaCodigoQr) {
	this.rutaCodigoQr = rutaCodigoQr;
}
public int getIdTituloLectura() {
	return idTituloLectura;
}
public void setIdTituloLectura(int idTituloLectura) {
	this.idTituloLectura = idTituloLectura;
}


}
