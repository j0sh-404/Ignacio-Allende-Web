package com.jnr.colegio.allende.data;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String clave;
	private boolean isUser=false;
	private String textoEtiquetaLectura;
	private String textoEtiquetaInicio;
	public static boolean esUsuario;
	public Usuario(int idUsuario, String nombreUsuario, String apellidoPaterno, String apellidoMaterno,
			boolean isUser,String textoEtiquetaLectura, String textoEtiquetaInicio) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.isUser = isUser;
		this.textoEtiquetaLectura=textoEtiquetaLectura;
		this.textoEtiquetaInicio=textoEtiquetaInicio;
		esUsuario=isUser;
	}
	
	public Usuario(int idUsuario, String nombreUsuario, String apellidoPaterno, String apellidoMaterno, String correo,
			String clave, boolean isUser) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.clave = clave;
		this.isUser = isUser;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}

	public String getTextoEtiquetaLectura() {
		return textoEtiquetaLectura;
	}

	public void setTextoEtiquetaLectura(String textoEtiquetaLectura) {
		this.textoEtiquetaLectura = textoEtiquetaLectura;
	}

	public String getTextoEtiquetaInicio() {
		return textoEtiquetaInicio;
	}

	public void setTextoEtiquetaInicio(String textoEtiquetaInicio) {
		this.textoEtiquetaInicio = textoEtiquetaInicio;
	}

	public static boolean isEsUsuario() {
		return esUsuario;
	}

	public static void setEsUsuario(boolean esUsuario) {
		Usuario.esUsuario = esUsuario;
	}

	
 
}
