
init();
initDetalle();
var vide0 = document.getElementById("video");
var imagen_lecura = document.getElementById("imagenActual");
var id_video=-1;
var id_lectura=-1;
function login(){
	var user =$("#idUser").val();
	var password=$("#idPassword").val();
	$.ajax({
		 url: "/Ignacio-Allende-Web/Login",
		 type: "post",
		 data: {user:user,password:password},
		 success: function(data){
			if(data!="error"){
			     $('#idCuentos').show();
	             $('#idInicio').show();
				var json = $.parseJSON(data);
				alert(json['Mensaje']);
				location.href="Lecturas.jsp";
			}else{
				alert("error");
			}
		 },
		 error: function(error){
			 console.log(error)
	     }

	 });
	
}
function init(){
	$('#idReading').hide();
	$('#idAllReading').show();
	$('#idEditarReading').hide();
}
function newReading(){
	$('#idReading').show();
	$('#idAllReading').hide();
	$('#idEditarReading').hide();
}
function cancel(){
	$('#idReading').hide();
	$('#idAllReading').show();
}

function initDetalle(){
	$('#idDetalleLectura').hide();
	$('#idAllDetalle').show();
	$('#idEditarDetalleLectura').hide();
}
function agregarArchivo(){
	$('#idDetalleLectura').show();
	$('#idAllDetalle').hide();
	$('#idEditarDetalleLectura').hide();
}

function cancelarDetalle(){
	$('#idDetalleLectura').hide();
	$('#idAllDetalle').show();
}
function Guardar(){ 
	if ($("#fileArchivos")[0].files.length > 0) {
	var inputFile = $("#fileArchivos")[0].files[0];
	var text =$("#texto").val();
	var sub=$("#idSubtitulo").val();
	var formData = new FormData();
	formData.append('idVideo', this.id_video);
	formData.append('video', inputFile);
	formData.append('subtitulo',sub);
	formData.append('texto',text);
	console.log(formData);
	return ajaxReq = $.ajax({
		url: '/Ignacio-Allende-Web/SaveVideo',
		type: 'POST',
		data: formData,
		cache: false,
		contentType: false,
		processData: false,
		xhr: function () {
			var xhr = $.ajaxSettings.xhr();
			xhr.upload.onprogress = function (event) {
				var perc = Math.round((event.loaded / event.total) * 100);
				$("#nombreArchivoCalendario1").text(inputFile.name);
				$("#progressBar1").text(perc + '%');
				$("#progressBar1").css('width', perc + '%');
			};
			return xhr;
		},
		beforeSend: function (xhr) {
			$("#progressBar1").text('0%');
			$("#progressBar1").css('width', '0%');
		},
		success: function (data, textStatus, jqXHR)
		{        
			$("#progressBar1").addClass("progress-bar-danger");
			$("#progressBar1").text('100% - Lectura registrada');
			window.location.reload();
		},
		error: function (jqXHR, textStatus) { 
			$("#progressBar1").text('100% - Error al guardar la lectura');
			$("#progressBar1").removeClass("progress-bar-danger");
			$("#progressBar1").addClass("progress-bar-warning");
		}
	});
	}else{
		alert("Por favor selecciona un video");
	}
}
function detalleLectura(id,titulo){
	$.ajax({
		url: "/Ignacio-Allende-Web/CaptureId",
		type: "post",
		data: {id:id,titulo:titulo},
		success: function(data){
		  location.href="DetalleLectura.jsp"
		},
		error: function(error){
			console.log(error)
		}

	});
}

function editarDetalle(idVideo,subtitulo,cuerpoLectura,video){
	this.id_video=idVideo;
	$('#idEditarDetalleLectura').show();
	$('#idAllDetalle').hide();
	$('#idActualizarDetalle').val(idVideo);
	$('#editarSubtitulo').val(subtitulo);
	$('#editarTexto').val(cuerpoLectura);

    
	vide0.setAttribute('src', video);
    //vide0.play();
	const $video = document.querySelector('#video')        
    const $play = document.querySelector('#play')
    const $pause = document.querySelector('#pause')
    const $backward = document.querySelector('#backward')
    const $forward = document.querySelector('#forward')

    $play.addEventListener('click',handlePlay)
   $pause.addEventListener('click',handlePause)

    function handlePlay(){
        $video.play()
        $play.hidden = true
        $pause.hidden= false
        console.log('le diste clic al botón de play')

    }

    function handlePause(){
        $video.pause()
        $play.hidden = false
        $pause.hidden= true
        console.log('le diste clic al botón de pause')
    }

   $backward.addEventListener('click',handleBackward)
   $forward.addEventListener('click',handleForward)

    function handleBackward(){
        $video.currentTime = $video.currentTime - 10
        console.log('retrocede 10 segundos')
    }

    function handleForward(){
        $video.currentTime = $video.currentTime + 10
        console.log('adelante 10 segundos')
    }

const $progress = document.querySelector('#progress')
$video.addEventListener('loadedmetadata' , handleLoaded)
$video.addEventListener('timeupdate' , handleTimeUpdate)

function handleLoaded(){
    $progress.max = $video.duration
    console.log('ha cargado mi video',$video.duration)
}

function handleTimeUpdate(){
    $progress.value = $video.currentTime
}

$progress.addEventListener('input', handleInput)

function handleInput() {
    $video.currentTime = $progress.value
    console.log($progress.Value)
}

}

function guardarActualizacion(){
	alert(this.id_video);
	if ($("#editarFileArchivos")[0].files.length > 0) {
		var inputFile = $("#editarFileArchivos")[0].files[0];
		var text =$("#editarTexto").val();
		var sub=$("#editarSubtitulo").val();
		var formData = new FormData();
		formData.append("idVideo",this.id_video);
		formData.append('video', inputFile);
		formData.append('subtitulo',sub);
		formData.append('texto',text);
		console.log(formData);
		return ajaxReq = $.ajax({
			url: '/Ignacio-Allende-Web/SaveVideo',
			type: 'POST',
			data: formData,
			cache: false,
			contentType: false,
			processData: false,
			xhr: function () {
				var xhr = $.ajaxSettings.xhr();
				xhr.upload.onprogress = function (event) {
					var perc = Math.round((event.loaded / event.total) * 100);
					$("#nombreArchivoCalendario1").text(inputFile.name);
					$("#progressBar1").text(perc + '%');
					$("#progressBar1").css('width', perc + '%');
				};
				return xhr;
			},
			beforeSend: function (xhr) {
				$("#progressBar1").text('0%');
				$("#progressBar1").css('width', '0%');
			},
			success: function (data, textStatus, jqXHR)
			{        
				$("#progressBar1").addClass("progress-bar-danger");
				$("#progressBar1").text('100% - Lectura registrada');
				window.location.reload();
			},
			error: function (jqXHR, textStatus) { 
				$("#progressBar1").text('100% - Error al guardar la lectura');
				$("#progressBar1").removeClass("progress-bar-danger");
				$("#progressBar1").addClass("progress-bar-warning");
			}
		});
		}else{
		var text =$("#editarTexto").val();
		var sub=$("#editarSubtitulo").val();
		var formData = new FormData();
		formData.append("idVideo",this.id_video);
		formData.append('subtitulo',sub);
		formData.append('texto',text);
		console.log(formData);
		return ajaxReq = $.ajax({
			url: '/Ignacio-Allende-Web/SaveVideo',
			type: 'POST',
			data: formData,
			cache: false,
			contentType: false,
			processData: false,
			xhr: function () {
				var xhr = $.ajaxSettings.xhr();
				xhr.upload.onprogress = function (event) {
					var perc = Math.round((event.loaded / event.total) * 100);
					$("#nombreArchivoCalendario1").text(inputFile.name);
					$("#progressBar1").text(perc + '%');
					$("#progressBar1").css('width', perc + '%');
				};
				return xhr;
			},
			beforeSend: function (xhr) {
				$("#progressBar1").text('0%');
				$("#progressBar1").css('width', '0%');
			},
			success: function (data, textStatus, jqXHR)
			{        
				$("#progressBar1").addClass("progress-bar-danger");
				$("#progressBar1").text('100% - Lectura registrada');
				window.location.reload();
			},
			error: function (jqXHR, textStatus) { 
				$("#progressBar1").text('100% - Error al guardar la lectura');
				$("#progressBar1").removeClass("progress-bar-danger");
				$("#progressBar1").addClass("progress-bar-warning");
			}
		});
		}
}

function cancelarActualizacion(){
	$('#idEditarDetalleLectura').hide();
	$('#idAllDetalle').show();
	 vide0.pause();
}

function eliminarVideo(idV){
	$.ajax({
		url: "/Ignacio-Allende-Web/DeleteVideo",
		type: "post",
		data: {idVideo:idV},
		success: function(data){
		   if(data!="error"){
			   location.href="DetalleLectura.jsp";
		   }else{
			   alert("error");
		   }
		},
		error: function(error){
			console.log(error)
		}

	});

}

    
function updateLectura(idLecura,tituloLectura,ruta){
	this.id_lectura=idLecura;
	$('#idEditarReading').show();
	$('#idAllReading').hide();
	$('#editarNombreLectura').val(tituloLectura);
	this.imagen_lecura.setAttribute('src', ruta);
	
}
	function saveLecturaUpdate(){
      if ($("#editarPortada")[0].files.length > 0) {
		var imagen = $("#editarPortada")[0].files[0];
		var  nombre =$("#editarNombreLectura").val();
		var formData = new FormData();
		formData.append('idPortada',this.id_lectura);
		formData.append('nombreLectura',nombre);
		formData.append('portada',imagen);

		return ajaxReq = $.ajax({
			url: '/Ignacio-Allende-Web/NewReading',
			type: 'POST',
			data: formData,
			cache: false,
			contentType: false,
			processData: false,
			success: function (data)
			{ 
				location.href="Lecturas.jsp";
			},
			error: function (error) { 
			   alert(error);
			}
		});
		}else{
		var  nombre =$("#editarNombreLectura").val();
		var formData = new FormData();
		formData.append('idPortada',this.id_lectura);
		formData.append('nombreLectura',nombre);
		return ajaxReq = $.ajax({
			url: '/Ignacio-Allende-Web/NewReading',
			type: 'POST',
			data: formData,
			cache: false,
			contentType: false,
			processData: false,
			success: function (data)
			{ 
				location.href="Lecturas=-1.jsp";
			},
			error: function (error) { 
			   alert(error);
			}
		});
			
		}
	}

	function cancelLecturaUpdate(){
		$('#idEditarReading').hide();
		$('#idAllReading').show();
	}
		
	function eliminarLectura(idLectura){
		$.ajax({
			url: "/Ignacio-Allende-Web/DeleteLectura",
			type: "post",
			data: {idLectura:idLectura},
			success: function(data){
			   if(data!="error"){
				   location.href="Lecturas.jsp";
			   }else{
				   alert("error");
			   }
			},
			error: function(error){
				console.log(error)
			}
	
		});
	}
