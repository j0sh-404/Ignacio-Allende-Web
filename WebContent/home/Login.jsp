<%@page import ="com.jnr.colegio.allende.data.Usuario"%>
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

<body onload="init()">
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
  <header class="header-area header-sticky wow slideInDown" data-wow-duration="0.75s" data-wow-delay="0s">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <nav class="main-nav">
            <a href="#" class="logo" style="width: 6%">
              <img src="assets/images/ColegioIAllende.png" alt="Colegio Allende" >
            </a>
            <ul class="nav">
              <!-- <li class="scroll-to-section" id="idInicio"><a href="Lecturas.jsp" class="active" >Inicio</a></li>
              <li class="scroll-to-section" id="idCuentos"><a href="Login.jsp" >Cuentos</a></li>-->
              <li><div class="gradient-button"><a id="modal_trigger" href="#modal"><i class="fa fa-sign-in-alt"></i> Inicia Sesión</a></div></li> 
            </ul>        
            <a class='menu-trigger'>
                <span>Menu</span>
            </a>
          </nav>
        </div>
      </div>
    </div>
  </header>
  <div id="modal" class="popupContainer" style="display:none;">
    <div class="popupHeader">
        <span class="header_title">Inicia Sesión</span>
        <span class="modal_close"><i class="fa fa-times"></i></span>
    </div>

    <section class="popupBody">
        <div class="social_login">
            <div class="">
                
             <div class="row">
              <div class="form-group" style="padding-top:9px">
              <input type="text" placeholder="Usuario o Correo" class="form-control" id="idUser">
              </div>
              <div class="form-group" style="padding-top:9px;">
              <input type="text" placeholder="Clave" class="form-control" id="idPassword">
              </div>
             </div>
            <div class="action_btns" style="padding-top:9px;">
                <div class="mx-auto"><a href="#" id="id_login" class="btn" style="float:center" onclick="login()">Acceder</a></div>
            </div>
        </div>
    </section>
</div>

  <div class="main-banner wow fadeIn" id="top" data-wow-duration="1s" data-wow-delay="0.5s">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-6 align-self-center">
              <div class="left-content show-up header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                <div class="row">
                  <div class="col-lg-12">
                    <h2>Colegio Ignacio Allende</h2>
                    <p style="color: white;">"Mucha gente pequeña, en lugares pequeños, haciendo cosas pequeñas, puede cambiar el mundo"</p>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="right-image wow fadeInRight" data-wow-duration="1s" data-wow-delay="0.5s">
                <lottie-player src="https://assets5.lottiefiles.com/packages/lf20_kcixdxqk/animations/lf30_editor_opilardo.json"  background="transparent"  speed="1"  style="width:85%;"  loop  autoplay></lottie-player>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
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