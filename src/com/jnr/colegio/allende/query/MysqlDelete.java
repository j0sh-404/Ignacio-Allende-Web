package com.jnr.colegio.allende.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jnr.colegio.allende.conection.MysqlConnection;

public class MysqlDelete extends MysqlConnection{
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean deleteVideo(int id ) {
		Connection con = getConnection();
		try {
			ps=con.prepareStatement("delete from video where id_video="+id);
			int r=ps.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteTitulo(int idLectura) {
		Connection con = getConnection();
		try {
			ps=con.prepareStatement("delete from titulo where id_titulo_lectura="+idLectura);
			int r=ps.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
