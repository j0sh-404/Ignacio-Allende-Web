 package com.jnr.colegio.allende.servlets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jnr.colegio.allende.query.MysqlInsert;
import com.jnr.colegio.allende.query.MysqlUpdate;
import com.jnr.colegio.allende.temp.TituloTemp;
@MultipartConfig
@WebServlet("/SaveVideo")
public class SaveVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String pathFile ="/opt/tomcat/webapps/data/video/";
	private final String rutaGuardar =" http://localhost/ignacio-allende-files/videos/";
	private File subir = new File(pathFile); 
	String extens[]= {".mp4"};
	Date date;
	private int idVideo=-1;
	HttpServletResponse res=null;
    private final String enviarQR="/opt/tomcat/webapps/data/codigo-qr/";
    private final String rutaGuardarCodigo=" http://localhost/ignacio-allende-files/QR/";
   
    public SaveVideo() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		this.res=response;
		  File f = new File(this.getClass().getResource("/").getPath());
		     System.out.println("ruta->"+f);
		saveVideo(request,response);
	}
	
	private void saveVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.idVideo=Integer.parseInt(request.getParameter("idVideo"));
        String titulo =request.getParameter("subtitulo");
		String texto=request.getParameter("texto");
		Part part =request.getPart("video");//Parametro del archivo a recibir
		System.out.println("idVideo->"+this.idVideo);
		if(part!=null) {
			/*Si el video es presente */
			if(validateExtens(part.getSubmittedFileName(), extens)) {		
				String photo=saveFile(part,subir,titulo,texto);
			}else {
				System.out.println("Erro de formato video");
			}	
		}else {
			/*En la actualizaci�n no incluyen el video*/
			updateSinVideo(idVideo,titulo,texto);
		}
	}
	
	private String saveFile(Part part,File pathUploads, String titulo,String texto) {
		String absolutePath="";
		String dataFile="";
		try {
			Path path = Paths.get(part.getSubmittedFileName());
			String fileName=path.getFileName().toString();
			InputStream input =part.getInputStream();
			date = new Date();
			String time =String.valueOf(date.getTime());
			if(input!=null) {
				/*todaLa ruta*/
				dataFile=time+fileName;
				File file = new File(pathUploads,time+fileName);
				absolutePath=file.getAbsolutePath();
			    Files.copy(input, file.toPath());
			    String rutaCodigoQr=generarCodigoQr(dataFile);
			    if(this.idVideo<0) {
			    saveBd(dataFile,titulo,texto,this.rutaGuardarCodigo+rutaCodigoQr);
			    }else {
			    updateConVideo(dataFile,titulo,texto,this.rutaGuardarCodigo+rutaCodigoQr);
			    }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return absolutePath;
	}
	/*Generar codigo qr*/
	private String generarCodigoQr(String url) {
		date = new Date();
		String cadena =String.valueOf(date.getTime());
		cadena+=".png";
		BitMatrix matriz =null;
		Writer writer = new QRCodeWriter();
		try {
			matriz = writer.encode(url,BarcodeFormat.QR_CODE,200,200);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		BufferedImage imagen = new BufferedImage(200, 200,BufferedImage.TYPE_INT_RGB);
	    for(int x=0;x<200;x++) {//eje x
	    	for(int y=0;y<200;y++) {
	    		int valor =(matriz.get(x, y)?0:1) & 0xff;
	    		imagen.setRGB(x, y,(valor==0?0:0xffffff));//asignamos el color del qr
	    	}
	    }
	    try {
			FileOutputStream qr = new FileOutputStream(enviarQR+cadena);//se Asigna la ruta e imagen
			ImageIO.write(imagen,"png", qr);
			qr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return cadena;
	}

	/*Validar la extension del archivo*/
	private boolean validateExtens(String fileName,String[] extensions) {
		for(String ex:extensions) {
			if(fileName.toLowerCase().endsWith(ex)) {
				return true;
			}
		}
		return false;
	}
	
	private void saveBd(String rutaVideo,String subtitulo,String texto,String rutaCodigoQr) {
		System.out.println("RutaVideo->"+rutaVideo+"\nSubtitulo->"+subtitulo+"\nTexto->"+texto+"\nRutaQR->"+rutaCodigoQr+"\nidTitulo->"+TituloTemp.idTitulo);
		MysqlInsert insertarVideo= new MysqlInsert();
		boolean response=insertarVideo.sqlInsertVideo(rutaVideo,subtitulo,texto,rutaCodigoQr,TituloTemp.idTitulo);
		String r=(response=true)?"Guardado Correctamente":"error";
		try {
			res.getWriter().append(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/*Actualizar el video*/
	private void updateSinVideo(int idVideo,String titulo, String texto) {
		 MysqlUpdate update = new MysqlUpdate();
		 boolean response = update.updateVideoFalse(idVideo, titulo, texto);
		 String r=(response=true)?"Guardado Correctamente":"error";
			try {
				res.getWriter().append(r);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	private void updateConVideo(String rutaVideo,String subtitulo,String texto,String rutaCodigoQr) {
		System.out.println("update con video/n"+rutaVideo+"->"+subtitulo+"->"+texto+"->"+rutaCodigoQr);
		MysqlUpdate update  = new MysqlUpdate();
		boolean response=update.updateVideoTrue(this.idVideo, rutaVideo, subtitulo, texto, rutaCodigoQr);
		String r=(response=true)?"Guardado Correctamente":"error";
		try {
			res.getWriter().append(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
