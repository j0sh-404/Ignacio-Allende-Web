package com.jnr.colegio.allende.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jnr.colegio.allende.temp.TituloTemp;

@WebServlet("/CaptureId")
public class CaptureId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CaptureId() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String titulo=request.getParameter("titulo");
		TituloTemp.idTitulo=id;
		TituloTemp.titulo=titulo;
		System.out.println("Titulo->"+titulo+" kid->"+id);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("EEEEEEEE%%%%");
		System.out.println("Id->"+TituloTemp.idTitulo+" titulo->"+id);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
