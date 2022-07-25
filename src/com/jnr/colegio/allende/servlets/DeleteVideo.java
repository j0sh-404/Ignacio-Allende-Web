package com.jnr.colegio.allende.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jnr.colegio.allende.query.MysqlDelete;

/**
 * Servlet implementation class DeleteVideo
 */
@WebServlet("/DeleteVideo")
public class DeleteVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVideo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idVideo"));
		MysqlDelete delete = new MysqlDelete();
		boolean s =delete.deleteVideo(id);
		String res =(s=true)?"Eliminado correctamente":"error";
		response.getWriter().append(res);
	}

}
