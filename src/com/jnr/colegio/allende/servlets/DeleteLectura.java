package com.jnr.colegio.allende.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jnr.colegio.allende.query.MysqlDelete;

/**
 * Servlet implementation class DeleteLectura
 */
@WebServlet("/DeleteLectura")
public class DeleteLectura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLectura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLectura = Integer.parseInt(request.getParameter("idLectura"));
		eliminarTitulo(idLectura,response);
	}
	
	public void eliminarTitulo(int idLectura, HttpServletResponse res) {
		MysqlDelete delete = new MysqlDelete();
		boolean response=delete.deleteTitulo(idLectura);
		String status =(response=true)?"Borrado exitosamente":"error";
		
	}

}
