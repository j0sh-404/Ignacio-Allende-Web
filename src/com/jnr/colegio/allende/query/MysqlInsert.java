package com.jnr.colegio.allende.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.tribes.group.interceptors.GzipInterceptor;

import com.jnr.colegio.allende.conection.MysqlConnection;

public class MysqlInsert extends MysqlConnection{
	private PreparedStatement ps;
	private ResultSet rs;
  
	public boolean sqlInsert(String titulo,String portada) {
		Connection con = getConnection();
		try {
			ps=con.prepareStatement("insert into titulo(titulo_lectura,portada)values(?,?)");
			ps.setString(1,titulo);
			ps.setString(2,portada);
			int valor=ps.executeUpdate();
			con.close();
			if(valor>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*Guardar video*/
	public boolean sqlInsertVideo(String rutaVideo,String subtitulo,String texto,String rutaCodigoQr,int idTituloLectura) {
		Connection con =getConnection();
		try {
			ps=con.prepareStatement("insert into video(subtitulo_lectura,cuerpo_lectura,path_video,codigo_qr,id_titulo_lectura)values(?,?,?,?,?)");
			ps.setString(1, subtitulo);
			ps.setString(2, texto);
			ps.setString(3, rutaVideo);
			ps.setString(4, rutaCodigoQr);
			ps.setInt(5, idTituloLectura);
			int valor=ps.executeUpdate();
			if(valor>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
