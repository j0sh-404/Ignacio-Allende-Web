<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.jnr.colegio.allende.data.Video" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.jnr.colegio.allende.query.MysqlQuery" %>
<%@ page import="com.jnr.colegio.allende.temp.TituloTemp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <title>Ignacio Allende</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
    <link rel="stylesheet" href="assets/css/animated.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="assets/css/ReproductorStyle.css">
    <link rel="stylesheet" href="assets/css/buttons.css">
  </head>

<body>
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <header style="position:relative;padding-bottom:10%" class="header-area header-sticky wow slideInDown" data-wow-duration="0.75s" data-wow-delay="0s">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <nav class="main-nav">
            <a href="#" class="logo" style="width: 7%">
              <img src="assets/images/ColegioIAllende.png" alt="Colegio Allende" >
            </a>      
            <ul class="nav"> 
              <li><div class="gradient-button"><a id="" href="Lecturas.jsp"><i class="fa fa-sign-in-alt"></i>Regresar</a></div></li> 
            </ul>  
            <ul class="nav"> 
              <li><div class="gradient-button"><a  href="#" onclick="agregarArchivo()" ><i class="fa fa-sign-in-alt"></i>Agregar archivos</a></div></li> 
            </ul>       
            <a class='menu-trigger'>
                <span>Menu</span>
            </a>
          </nav>
        </div>
      </div>
    </div>
    <style>
    .espacio{
    padding-bottom:30px;
    }
    </style>
  </header>
  <br>
  <body>
  
  <div id="idDetalleLectura" class="col-sm-12" style="padding-top:15%;position:relative">
   <div class="container">
    <div class="card col-sm-6 mx-auto">

  <div class="card-header text-center">
    Agrega un archivo a tu lectura
  </div>
  <div class="card-body">
     <div class="form-group col-sm-12 mb-3">
      <label for="idSubtitulo">Subtítulo*</label>
      <input class="form-control"  type="text" id="idSubtitulo"  id=""> 
     </div>
     <div class="form-group mb-3">
     <label for="texto">Cuerpo Lectura*</label>
     <textarea class="form-control" id="texto" rows="3"></textarea>
     </div>
     <div class="form-group col-sm-12 mb-3">
     <label dfor="fileArchivos">Agrega un video*</label>
     <input class="form-control"  type="file" id="fileArchivos" multiple="multiple"> 
     </div>
     </div> 
    <div class="card-footer text-center" style="padding-top:3%">
     <button class="btn btn-primary" onclick="Guardar()" type="button">Guardar</button>
     <button type="button" class="btn btn-danger" id="cancelarArchivo" onclick="cancelarDetalle()">Cancelar</button>
     <div class='col-sm-12' style="padding-top:4px;">
     <div class='col-sm-12'>
     <div class='progress'>
      <div id='progressBar1' class='progress-bar' role='progressbar' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100' style='width: 0%'>0%</div>
      </div>
      </div>
      </div>
    </div>
    <div class="form-group">
    <label></label>
    </div>
  </div>
   </div>
   </div>
  </div>
  <!-- Editar detalle lectura -->
   <div id="idEditarDetalleLectura" class="col-sm-12" style="padding-top:15%;position:relative">
   <div class="container">
    <div class="card col-sm-6 mx-auto">

  <div class="card-header text-center">
    Editar
  </div>
  <div class="card-body">
     <div class="form-group col-sm-12 mb-3">
      <input type="hidden" id="idActualizarDetalle">
      <label for="editarSubtitulo">Subtítulo*</label>
      <input class="form-control"  type="text" id="editarSubtitulo"> 
     </div>
     <div class="form-group mb-3">
     <label for="texto">Cuerpo Lectura*</label>
     <textarea class="form-control" id="editarTexto" rows="3"></textarea>
     </div>
     <div class="form-group col-sm-12 mb-3">
     <label for="editarFileArchivos" id="">Cambiar el video*</label>
     <input class="form-control"  type="file" id="editarFileArchivos" multiple="multiple"> 
     </div>
     <div class="form-group col-sm-12 mb-3">
        <div class="wrapper">
        <div class="player">
            <video id="video" poster="./assets/assets/images/poster.jpg" src="" width="400px"></video>
            <div class="player-overlay">
            <h2 class="player-title">Tu video Actual</h2>
                <div class="player-actions">
                    <button class="button" id="backward" aria-label="Retroceder 10 segundos" title="Retroceder 10 segundos"></button>
                    <button class="button" id="play" aria-label="Reproducir" title="Reproducir"></button>
                    <button class="button" hidden id="pause" aria-label="Pausar" title="Pausar"></button>
                    <button class="button" id="forward" aria-label="Adelantar 10 segundos" title="Adelantar 10 segundos"></button>
                </div>
                <div class="player-progress">
                    <input id="progress" type="range" min="0" value="0" step=".1">
                </div>
            </div>
        </div>
    </div>
     </div>
     </div> 
    <div class="card-footer text-center" style="padding-top:3%">
     <button class="btn btn-primary" onclick="guardarActualizacion()" type="button">Guardar</button>
     <button type="button" class="btn btn-danger" id="cancelarArchivo" onclick="cancelarActualizacion()">Cancelar</button>
     <div class='col-sm-12' style="padding-top:4px;">
     <div class='col-sm-12'>
     <div class='progress'>
      <div id='progressBar1' class='progress-bar' role='progressbar' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100' style='width: 0%'>0%</div>
      </div>
      </div>
      </div>
    </div>
    <div class="form-group">
    <label></label>
    </div>
  </div>
   </div>
   </div>
  </div>
  <!-- CLose editar detalle lectura -->
    <div style="padding-top:10%;padding-left:3%;padding-right:3%;position:relative;" class="col-sm-12" id="idAllDetalle">
    <div class='col-sm-12' style='text-align:center'><h5>Detalles de la lectura(<%=TituloTemp.titulo%>)</h5></div>
    <br>
    <br>
    <!-- For java -->
    <div class="row">
    <%
      MysqlQuery query = new MysqlQuery();
      ArrayList<Video>video=query.sqlQueryAllVideo("select * from video where id_titulo_lectura="+TituloTemp.idTitulo);
      if(video.size()>0){
    	  for(Video v:video){
    %>
           <div class="col-sm-3 espacio">
            <div class="pricing-item-pro">
            <span class="price">UTSH</span>
            <br>
            <h4 style="position:relative"><%=v.getSubtituloLectura()%></h4>
            <div class="icon">
              <img src="<%=v.getRutaCodigoQr()%>" alt="codigo QR">
            </div>
            <a href="<%=v.getRutaCodigoQr()%>" download="<%=v.getSubtituloLectura()%>Qr.png" styile="text-decoration:none;">Descargar Qr</a>
            <input type="hidden" value="sinValor" id="idDetalle">
            <div class="border-button">
              <a type="button" onclick="editarDetalle(<%=v.getIdVideo()%>,'<%=v.getSubtituloLectura()%>','<%=v.getCuerpoLectura()%>','http://localhost/ignacio-allende-files/videos/<%=v.getRutaVideo()%>')">Editar</a>
              <a type="button" onclick="eliminarVideo(<%=v.getIdVideo()%>)">Eliminar</a>
            </div>
          </div>
          </div>
        <%}}else{
        	out.println("<div class='col-sm-12' style='text-align:center'><h5>Sin contenido</h5></div>");
        }%>
        <!-- For -->
    </div>
    </div>
  </body>
  <footer id="newsletter">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 offset-lg-2">
          <div class="section-heading">
            <h4>Join our mailing list to receive the news &amp; latest trends</h4>
          </div>
        </div>
        <div class="col-lg-6 offset-lg-3">
          <form id="search" action="#" method="GET">
            <div class="row">
              <div class="col-lg-6 col-sm-6">
                <fieldset>
                  <input type="address" name="address" class="email" placeholder="Email Address..." autocomplete="on" required>
                </fieldset>
              </div>
              <div class="col-lg-6 col-sm-6">
                <fieldset>
                  <button type="submit" class="main-button">Subscribe Now <i class="fa fa-angle-right"></i></button>
                </fieldset>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <div class="copyright-text">
            <p>Copyright © 2022 Chain App Dev Company. All Rights Reserved. 
          <br>Design: <a href="https://templatemo.com/" target="_blank" title="css templates">TemplateMo</a></p>
          </div>
        </div>
      </div>
    </div>
  </footer>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/js/owl-carousel.js"></script>
  <script src="assets/js/animation.js"></script>
  <script src="assets/js/imagesloaded.js"></script>
  <script src="assets/js/popup.js"></script>
  <script src="assets/js/custom.js"></script>
  <script src="assets/js/service.js"></script>
</body>
</html>