<%@page import="com.jnr.colegio.allende.query.MysqlQuery"%>
<%@page import ="com.jnr.colegio.allende.data.Usuario"%>
<%@page import ="com.jnr.colegio.allende.data.TituloLectura" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.io.File" %>
<% 
HttpSession sesion =request.getSession();
Usuario user =(Usuario)sesion.getAttribute("sesionUsuario");
/*if(user!=null){descomentar*/
%>
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
              <li><div class="gradient-button"><a id="" href="#"><i class="fa fa-sign-in-alt"></i>Salir</a></div></li> 
            </ul>  
            <ul class="nav"> 
              <li><div class="gradient-button"><a  href="#" onclick="newReading()"><i class="fa fa-sign-in-alt"></i>Agregar Lectura</a></div></li> 
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
  <div id="idReading" class="col-sm-12" style="padding-top:15%;position:relative">
   <div class="container">
    <div class="card col-sm-6 mx-auto">
  <div class="card-header text-center">
    Nueva Lectura
  </div>
  <div class="card-body">
    <form method="post" action="/Ignacio-Allende-Web/NewReading" enctype="multipart/form-data" id="submit-form">
    <div class="form-group">
    <label for="nombreLectura">Nombre Lectura*</label>
    <input type="text" class="form-control col-sm-12" id="nombreLectura" name="nombreLectura">
    <input type="hidden" class="form-control col-sm-12" id="idPortada" name="idPortada" value="-1">
    </div>
    <div class="form-group" style="padding-top:3%">
    <label for="nombreLectura">Colocar una portada(opcional)</label>
    <input type="file" class="form-control col-sm-12" id="portada" name="portada">
    </div>
    <div class="card-footer text-center" style="padding-top:3%">
    <input  type="submit" class="btn btn-danger" value="Guardar" id="save">
    <button type="button" class="btn btn-danger"  onclick="cancel()">Cancelar</button>
    </div>
    </form>
    <div class="form-group">
    <label></label>
    </div>
  </div>
   </div>
   </div>
  </div>
  <!-- Editar Lectura -->
  <div id="idEditarReading" class="col-sm-12" style="padding-top:15%;position:relative">
   <div class="container">
    <div class="card col-sm-6 mx-auto">
  <div class="card-header text-center">
    Editar Lectura
  </div>
  <div class="card-body">
    <form method="post" action="/Ignacio-Allende-Web/NewReading" enctype="multipart/form-data" id="submit-form">
    <div class="form-group">
    <label for="nombreLectura">Nombre Lectura*</label>
    <input type="text" class="form-control col-sm-12" id="editarNombreLectura" name="nombreLectura">
    </div>
    <div class="form-group" style="padding-top:3%">
    <label for="nombreLectura">Cambiar la portada</label>
    <input type="file" class="form-control col-sm-12" id="editarPortada" name="portada">
    </div>
    <div class="form-group" style="padding-top:3%">
    <label for="nombreLectura">Tu portada actual</label>
      <img src="" alt="portada" id="imagenActual">
    </div>
    <div class="card-footer text-center" style="padding-top:3%">
    <button  type="button" class="btn btn-danger" onclick="saveLecturaUpdate()" id="save">Guardar</button>
    <button type="button" class="btn btn-danger"  onclick="cancelLecturaUpdate()">Cancelar</button>
    </div>
    </form>
    <div class="form-group">
    <label></label>
    </div>
  </div>
   </div>
   </div>
  </div>
  <!-- Terminar lectura -->
    <div style="padding-top:10%;padding-left:3%;padding-right:3%;position:relative;" class="col-sm-12" id="idAllReading">
    <!-- For java -->
    <div class="row">
     <% 
     MysqlQuery titulos = new MysqlQuery();
     ArrayList<TituloLectura> tit=titulos.sqlQueryAllReading("select * from titulo");
     if(tit.size()>0){
    	 for(TituloLectura t :tit){
     %>
           <div class="col-sm-3 espacio">
            <div class="pricing-item-pro">
            <span class="price">UTSH</span>
            <br>
            <h4 style="position:relative"><%=t.getTituloLectura()%></h4>
            <div class="icon">
              <img src="<%=t.getRutaPortada()%>" alt="">
            </div>
            <input type="hidden" value="<%=t.getIdTitulo()%>" id="idTitulo">
            <input type="hidden" value="<%=t.getTituloLectura()%>" id="titulo_lectura">
            <div class="border-button">
              <button class="btn btn-danger" onclick="detalleLectura('<%=t.getIdTitulo()%>','<%=t.getTituloLectura()%>')">Agregar texto</button>
            </div>
            <div class=border-button>
              <a type="button" style="padding-top:2px;" onclick="updateLectura(<%=t.getIdTitulo()%>,'<%=t.getTituloLectura()%>','<%=t.getRutaPortada()%>')">Modificar</a>
              <a type="Button" style="padding-top:2px;" onclick="eliminarLectura(<%=t.getIdTitulo()%>)">Eliminar</a>
            </div>
          </div>
        </div>
        <%}}else{
        	out.println("<div class='col-sm-12' style='text-align:center'><h5>A�n no existen lecuras</h5></div>");
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
            <p>Copyright � 2022 Chain App Dev Company. All Rights Reserved. 
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
<%/*}else{descomentar*/%>
<!-- 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>...</title>
<meta http-equiv="refresh" content="0;URL=Login.jsp">
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
</body>
</html> -->
<%/*}*/%>