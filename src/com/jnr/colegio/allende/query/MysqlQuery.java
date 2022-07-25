package com.jnr.colegio.allende.query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import java.sql.Connection;

import com.jnr.colegio.allende.conection.MysqlConnection;
import com.jnr.colegio.allende.data.TituloLectura;
import com.jnr.colegio.allende.data.Video;

public class MysqlQuery extends MysqlConnection{
	 private PreparedStatement ps;
	 private ResultSet rs;

	public void sqlInsert(String sql) {
		Connection con = getConnection();
	}
	/*Logearse*/
	public JSONObject sqlQueryLogin(String sql) {
		JSONObject data = new JSONObject();
		Connection con = getConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				 data.put("I","Inicio");
				 data.put("L","Lecturas");
				 data.put("Id_User",rs.getInt("id_user"));
				 data.put("Nombre", rs.getString("nombre_usuario"));
				 data.put("Apellido_Paterno",rs.getString("apellido_paterno"));
				 data.put("Apellido_Materno",rs.getString("apellido_materno"));
				 data.put("Mensaje","Bien venido(a) "+rs.getString("nombre_usuario"));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/*Obtener todos las lecturas*/
	
	public ArrayList<TituloLectura> sqlQueryAllReading(String sql) {
		ArrayList<TituloLectura>titulo= new ArrayList();
		Connection con = getConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				titulo.add(new TituloLectura(rs.getInt("id_titulo_lectura"),rs.getString("titulo_lectura"),rs.getString("portada")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titulo;
	}
	
	public ArrayList<Video> sqlQueryAllVideo(String sql){
		ArrayList<Video>video = new ArrayList();
		Connection con =getConnection();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				video.add(new Video(rs.getInt("id_video"),rs.getString("subtitulo_lectura"),rs.getString("cuerpo_lectura"),rs.getString("path_video"),rs.getString("codigo_qr"),rs.getInt("id_titulo_lectura") ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return video;
	}
 
}
