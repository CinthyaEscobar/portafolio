<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Custom fonts for this template -->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    
<title>Detalle Reserva</title>
</head>
<body id="page-top" class="bg-gradient-primary">
 	<!-- Page Wrapper -->
	<div id="wrapper" >
		<!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index/funcionario">
                <div class="sidebar-brand-icon">
                    <i class="fas fa-user-circle"></i>

                </div>
                <div class="sidebar-brand-text mx-3">Funcionario</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">            

            <!-- Divider -->
            <hr class="sidebar-divider">
            

            <!-- Nav items -->
            <li class="nav-item">
                <a class="nav-link" href="/index/funcionario" aria-expanded="true" aria-controls="collapseTwo">                   
                    <span>Reservas</span>
                </a>               
            </li>
            

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>

        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                        <sec:authentication property="principal.nombre"/>
                                        <sec:authentication property="principal.apellidoP"/>
                                        <sec:authentication property="principal.apellidoM"/>
                                    </span>
                                <img class="img-profile rounded-circle"
                                    src="/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Perfil
                                </a>  
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>

                <!-- Begin Page Content -->
                <div class="container-fluid row d-flex justify-content-center">
                	<div class="w-65 mx-auto">	
                    <!-- Page Heading -->
					<div class="card shadow ">
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="card canvas_div_pdf">
											<div class="row">
												<div class="col"> 
													<c:if test="${reserva.idDepartamento.foto!= null }">
                                					<img id="profileImage" alt="preview" src="data:image/jpg;base64, ${ reserva.idDepartamento.getImg() }" width="330" height="330">
                                				</c:if> 
												</div>
												<div class="col">
												<br>
												<br>
												<br>
													<h6><c:out value="${ reserva.idDepartamento.idEdificio.nombre  } dpto # ${ reserva.idDepartamento.numero }" /></h6>
													<p><c:out value="${ reserva.idDepartamento.descripcion }" /></p>
													Caracteristicas
													<ul>
														<c:forEach items="${ items }" var="item">
														<li><c:out value="${ item.nombre }" /></li>
														</c:forEach>
													</ul>
												</div>													
											</div>
										 <hr/>	
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">												
												<h6 style="text-align: center;">Acompañantes</h6>	
												<c:if test="${ reserva.acompananteList.size() == 0 }">
													<h6 style="text-align: center;">Sin Acompañante</h6>
												</c:if>
												<c:forEach items="${ reserva.acompananteList }" var="ac">
													<h6 style="text-align: center;"><c:out value="${ ac.rut}" /> <c:out value="${ ac.nombre}" /></h6>	
												</c:forEach>	
											</div>
										 </div>
										  <hr/>	
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">
										 		<h6 style="text-align: center;">Transporte</h6>	
										 		<c:choose>
										 			<c:when test="${ reserva.idTransporte != null }">
										 				<h6 style="text-align: center;">Conductor: <c:out value="${ reserva.idTransporte.idConductor.nombre }"/> <c:out value="${ reserva.idTransporte.idConductor.apellidop }"/></h6>	
										 				<h6 style="text-align: center;">Vehiculo: <c:out value="${ reserva.idTransporte.idVehiculo.patente }"/> <c:out value="${ reserva.idTransporte.idVehiculo.marca }"/> <c:out value="${ reserva.idTransporte.idVehiculo.modelo }"/> </h6>	
										 				<h6 style="text-align: center;">Precio: $<c:out value="${ reserva.idTransporte.precio }"/> </h6>	
										 			</c:when>
										 			<c:otherwise>
										 				<h6 style="text-align: center;">Sin Transporte</h6>	
										 			</c:otherwise>
										 		</c:choose>
										 	</div>
										 </div>
										 <hr>
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">
										 		<h6 style="text-align: center;">Tours</h6>
										 		<c:if test="${ rTours.size() == 0 }">
										 			<h6 style="text-align: center;">Sin Tours</h6>
										 		</c:if>
										 		<c:forEach items="${ rTours }" var="r">
										 			<h6 style="text-align: center;">Lugar: <c:out value="${ r.idTour.lugar }" /></h6>
										 			<h6 style="text-align: center;">Fecha: <c:out value="${ r.idTour.fecha }" /></h6>
										 			<h6 style="text-align: center;">Hora: <c:out value="${ r.idTour.horaComienzo }" /></h6>
										 			<h6 style="text-align: center;">Precio: $<c:out value="${ r.idTour.precio }" /></h6>
										 		</c:forEach>
										 	</div>
										 </div>
										 <hr>
										 <div id="extra" style="display:none">
										 	<br>
										 	<br>
										 	<br>
										 	<br>										 	
										 	<hr>
										 </div>
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">
										 		<h6 style="text-align: center;">Multas</h6>
										 		<div class="row justify-content-center">
										 			<div class="col justify-content-center" id="checkMulta">
										 				<input type="checkbox" style="text-align: center;" id="chMulta" value="multa" name="chMulta" onclick="mostrar()"> 
										 				<label for="chMulta">Incluir multa</label>
										 			</div>
										 		</div>
										 		<div id="divSinMulta">
										 			<h6 style="text-align: center;">Sin Multas</h6>
										 		</div>
										 		<div id="divMulta">
										 			<input style="margin:auto;  display:block" type="number" id="txtMulta" name="valMulta" placeholder="Costo Multa" required="required">
										 			<br>
										 			<textarea style="margin:auto;  display:block" id="areaMulta" name="desMulta" rows="4" cols="50" placeholder="Descripción del motivo de la multa"></textarea>
										 		</div>	
										 	</div>
										 </div>	
										 <hr>
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">
										 		<h6 style="text-align: center;">Resumen pagos</h6>	
										 		<h6 style="text-align: center;">Total Reserva: $ <c:out value="${ reserva.totalPagar }" /></h6>	
										 		<h6 style="text-align: center;" id="pagoMulta"> </h6>
										 		<h6 style="text-align: center;" id="totalMulta"></h6>
										 												 			
										 	</div>
										 </div>
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">
										 		<br>										 		
										 		<h6 style="text-align: center;">____________________________</h6>	
										 		<h6 style="text-align: center;">   Firma y rut del cliente</h6>	
										 	</div>
										 </div>										 
									</div>
									<div class="card canvas_div_pdf">
										<hr>
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">										 												 		
										 		<button style="margin:auto;  display:block" onclick="getPDF()" >Imprimir</button>	
										 		<br>
										 	</div>
										 </div>
										 <hr>
										 <div class="row justify-content-center">
										 	<div class="col justify-content-center">	
										 		<form action="/generarcheckout" method="post" id="formCancelar">
										 			<input type="hidden" value="${ reserva.idReserva }" name="idReserva">
										 			<input type="hidden" value="" name="multa" >
										 			<input type="hidden" value="" name="desMulta">
										 			<input  style="margin:auto;  display:block" type="button" value="Check-out" onclick="validar()">										 			
										 		</form>	
										 		<br>
										 	</div>
										 </div>
									</div>
								</div>
							</div>
						</div>
					</div>	
					</div>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Arriendos de Temporada 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
        </div>
        <!-- End of Content Wrapper -->
	</div>        
    <!-- End of Page Wrapper -->

	</div>
     <!-- Scroll to Top Button-->
     <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿Listo para salir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">¿Esta segurro que quiere cerrar seción?</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                    <sec:authorize access="isAuthenticated()">
                            <form action="/logout" method="post">
                                <input type="hidden" name="${ _csrf.parameterName }"
                                    value="${ _csrf.token }">
                                <button class="btn btn-primary">Cerrar Sección</button>
                            </form>
                        </sec:authorize>       
                </div>
            </div>
        </div>
    </div>	

     <!-- Bootstrap core JavaScript-->
     <script src="/vendor/jquery/jquery.min.js"></script>
     <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 
     <!-- Core plugin JavaScript-->
     <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
 
     <!-- Custom scripts for all pages-->
     <script src="/js/sb-admin-2.min.js"></script>
 
     <!-- Page level plugins -->
     <script src="/vendor/datatables/jquery.dataTables.min.js"></script>
     <script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>
 
     <!-- Page level custom scripts -->
     <script src="/js/demo/datatables-demo.js"></script>
     <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.min.js"></script>
	 <script src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>
    
    <script type="text/javascript">
    
    var v;
    var x = ${ reserva.totalPagar};
    $(function(){
    	 $("#divMulta").hide();
    	 $("#pagoMulta").hide();
    	 $("#totalMulta").hide();
    	 
    	 $('#txtMulta').on('input',function(e){
    		 v = parseInt($("#txtMulta").val());
    		 if(!isNaN(v))
    		 {
    			 $("#pagoMulta").html("Pago Multa $"+ v);
    		 	 $("#totalMulta").html("Total Pago $" + (x+v));
    		 }
    		 else
    		 {
    			 $("#pagoMulta").html("Total Pago $0");
    			$("#totalMulta").html("Total Pago $" + (x));
    		 }
    		});
    	 
    });
    
    function mostrar()
    {
    	var check = document.getElementById('chMulta');
    	if(check.checked)
    	{
    		v = parseInt($("#txtMulta").val());    		
    		console.log(v);
    		$("#divMulta").show();
    		$("#divSinMulta").hide();
    		$("#pagoMulta").show();
    		$("#pagoMulta").html("Multa $0");
       	 	$("#totalMulta").show();
       	 	if(!isNaN(v))
       	 	{
       	 		$("#totalMulta").html("Total Pago $" + (x+v));
       	 	}
       	 	else
       	 	{
       	 		$("#totalMulta").html("Total Pago $" + (x));
       	 	}
    	}
    	else
    	{
    		$("#divMulta").hide();
    		$("#divSinMulta").show();
    		$("#pagoMulta").hide();
       	 	$("#totalMulta").hide();
       	 	v = 0;
       	 $("#totalMulta").html("");
    	}
    } 
    
    
    function validar()
	{
    	var m = $("#txtMulta").val();
    	var d = $("#areaMulta").val();
    	
    	$("[name='multa']").val(m);
    	$("[name='desMulta']").val(d);
    	
    	
		if(confirm("¿Está seguro que desea realizar el Check-out?"))
		{
			document.getElementById("formCancelar").submit();		
		}
	}
    
    function getPDF(){

    	$("#extra").show();
    	$("#checkMulta").hide();
    	
		var HTML_Width = $(".canvas_div_pdf").width();
		var HTML_Height = $(".canvas_div_pdf").height();
		var top_left_margin = 15;
		var PDF_Width = HTML_Width+(top_left_margin*2);
		var PDF_Height = (PDF_Width*1.5)+(top_left_margin*2);
		var canvas_image_width = HTML_Width;
		var canvas_image_height = HTML_Height;
		
		var totalPDFPages = Math.ceil(HTML_Height/PDF_Height)-1;
		

		html2canvas($(".canvas_div_pdf")[0],{allowTaint:true}).then(function(canvas) {
			canvas.getContext('2d');
			
			console.log(canvas.height+"  "+canvas.width);
			
			
			var imgData = canvas.toDataURL("image/jpeg", 1.0);
			var pdf = new jsPDF('p', 'pt',  [PDF_Width, PDF_Height]);
		    pdf.addImage(imgData, 'JPG', top_left_margin, top_left_margin,canvas_image_width,canvas_image_height);
			
			
			for (var i = 1; i <= totalPDFPages; i++) { 
				pdf.addPage(PDF_Width, PDF_Height);
				pdf.addImage(imgData, 'JPG', top_left_margin, -(PDF_Height*i)+(top_left_margin*4),canvas_image_width,canvas_image_height);
			}
			
		    pdf.save("Reserva.pdf");
		    $("#extra").hide();
		    $("#checkMulta").show();
        });
	};
    </script>
     
</body>
</html>