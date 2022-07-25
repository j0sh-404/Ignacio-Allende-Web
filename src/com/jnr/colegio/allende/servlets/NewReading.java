package com.jnr.colegio.allende.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jnr.colegio.allende.query.MysqlInsert;
import com.jnr.colegio.allende.query.MysqlUpdate;

/**
 * Servlet implementation class NewReading
 */
@MultipartConfig
@WebServlet("/NewReading")
public class NewReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pathFile ="C:\\wamp64\\www\\ignacio-allende-files\\portada\\";
	String rutaGuardar =" http://localhost/ignacio-allende-files/portada/";
	private File subir = new File(pathFile); 
	String extens[]= {".jpg",".png",".jpeg"};
	Date date;
	private int id_portada=-1;
	private HttpServletResponse res;
    public NewReading() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*File f = new File(this.getClass().getResource("/").getPath()) obtener la ruta;
	    System.out.println(f);*/
		this.res=response;
		saveReading(request, response);
	}
	private void saveReading(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.id_portada = Integer.parseInt(request.getParameter("idPortada"));
		String nameReading=request.getParameter("nombreLectura");
		Part part =request.getPart("portada");
		
			if(part==null && this.id_portada>0) {
				updateSinPortada(this.id_portada,nameReading);	
			}else {
				if(validateExtens(part.getSubmittedFileName(), extens)) {		
					String photo=saveFile(part,subir,nameReading);
				}else {
		           saveBd(rutaGuardar+"default.png",nameReading);	
				}
			}
			
			captureResponse(response,null);
	}
	private String saveFile(Part part,File pathUploads, String name) {
		String absolutePath="";
		String dataFile="";
		try {
			Path path = Paths.get(part.getSubmittedFileName());
			String fileName=path.getFileName().toString();
			InputStream input =part.getInputStream();
			date = new Date();
			String time =String.valueOf(date.getTime());
			if(input!=null) {
				dataFile=time+fileName;
				File file = new File(pathUploads,time+fileName);
				absolutePath=file.getAbsolutePath();
			    Files.copy(input, file.toPath());
			    
			}else {
				dataFile=rutaGuardar+"imageDefault.png";
			}
			
			if(this.id_portada>0) {
				updateConPortada(this.id_portada,rutaGuardar+dataFile,name);
			}else {
			saveBd(rutaGuardar+dataFile,name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return absolutePath;
	}
	
	private void captureResponse(HttpServletResponse res,String mesaje) {
		
	}
	private boolean validateExtens(String fileName,String[] extensions) {
		for(String ex:extensions) {
			if(fileName.toLowerCase().endsWith(ex)) {
				return true;
			}
		}
		return false;
	}
	
	/*Guardar en la base de datos*/
    private void saveBd(String path,String portada) {
    	System.out.println("Ruta->"+path+"\nportada->"+portada);
    	try {
    		MysqlInsert insert = new MysqlInsert();
    		insert.sqlInsert(portada,path);
			res.sendRedirect("/Ignacio-Allende-Web/home/Lecturas.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void updateConPortada(int id,String tituloPortada,String portada) {
    	MysqlUpdate actualizarPortada = new MysqlUpdate();
    	boolean t=actualizarPortada.updatePortadaTrue(id, tituloPortada, portada);
    	System.out.println("ACtualizado->"+t);
    }
    private void updateSinPortada(int id,String tituloLectura){
    	MysqlUpdate actualizarPortada = new MysqlUpdate();
     	boolean t= actualizarPortada.upratePortadaFalse(id, tituloLectura);
     	System.out.println("ACtualizado->"+t);
    }
}
