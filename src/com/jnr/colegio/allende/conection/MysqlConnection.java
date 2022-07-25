package com.jnr.colegio.allende.conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	    private String url="jdbc:mysql://200.150.199.206:3306/colegio_allende";
	    private String user="root";
	    private String password="XMBlik16141";
	    
	    public Connection getConnection(){
	        Connection conexion=null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conexion =(Connection)DriverManager.getConnection(url, user, password);
	        } catch (Exception e) {
	            System.err.println("Error conexion a BD "+e);
	        }
	        return conexion;
	    } 
}
