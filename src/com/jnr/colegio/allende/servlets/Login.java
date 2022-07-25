package com.jnr.colegio.allende.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.jnr.colegio.allende.data.Usuario;
import com.jnr.colegio.allende.query.MysqlQuery;
import com.mysql.cj.xdevapi.JsonArray;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		MysqlQuery query = new MysqlQuery();
		JSONObject data=query.sqlQueryLogin("select * from user where correo='"+user+"'and clave='"+password+"'");
		if(data.isEmpty()){
			response.getWriter().append("error");
			}
		else{
			HttpSession sesion = request.getSession(); 
            sesion.setMaxInactiveInterval(1000);
			int id = Integer.parseInt(data.get("Id_User").toString());
			String nombre=data.get("Nombre").toString();
			String apellidoPaterno=data.get("Apellido_Paterno").toString();
			String apellidoMaterno=data.get("Apellido_Materno").toString();
			String textoEtiquetaInicio=data.get("I").toString();
			String textoEtiquetaLecturas=data.get("L").toString();
			Usuario nuevoUsuario = new Usuario(id,nombre,apellidoPaterno,apellidoMaterno,true,textoEtiquetaInicio,textoEtiquetaLecturas);
			sesion.setAttribute("sesionUsuario", nuevoUsuario);
			response.getWriter().append(data.toJSONString());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
