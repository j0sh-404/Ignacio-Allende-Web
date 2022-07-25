package com.jnr.colegio.allende.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jnr.colegio.allende.conection.MysqlConnection;


public class MysqlUpdate extends MysqlConnection{
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean updateVideoFalse(int idVideo,String titulo, String texto) {
		 Connection con = getConnection();
		 try {
			ps=con.prepareStatement("update video SET subtitulo_lectura='"+titulo+"',cuerpo_lectura='"+texto+"' WHERE id_video="+idVideo);
			int valor =ps.executeUpdate();
			if(valor>0) {return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return false;
	}
	
	public boolean updateVideoTrue(int idVideo,String rutaVideo,String subtitulo,String texto,String rutaCodigoQr) {
		 Connection con = getConnection();
		 try {
			ps=con.prepareStatement("update video SET subtitulo_lectura='"+subtitulo+"',cuerpo_lectura='"+texto+"',path_video='"+rutaVideo+"',codigo_qr='"+rutaCodigoQr+"' WHERE id_video="+idVideo);
			int valor =ps.executeUpdate();
			if(valor>0) {return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return false;
	}
	
	public boolean updatePortadaTrue(int idPortada,String tituloLectura,String portada) {
		 Connection con = getConnection();
		 try {
			ps=con.prepareStatement("update titulo set titulo_lectura='"+portada+"', portada='"+tituloLectura+"' where id_titulo_lectura="+idPortada);
			int valor =ps.executeUpdate();
			if(valor>0) {return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean upratePortadaFalse(int idPortada,String tituloLectura) {
		Connection con = getConnection();
		 try {
			ps=con.prepareStatement("update titulo set titulo_lectura='"+tituloLectura+"' where id_titulo_lectura="+idPortada);
			int valor =ps.executeUpdate();
			if(valor>0) {return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
