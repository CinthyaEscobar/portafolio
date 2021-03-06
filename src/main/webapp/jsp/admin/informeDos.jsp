<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Custom fonts for this template -->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<!-- Custom styles for this page -->
<link href="/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<title>Admin</title>
</head>
<body id="page-top" class="bg-gradient-primary">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/admin">
				<div class="sidebar-brand-icon ">
					<i class="fas fa-hotel"></i>

				</div>
				<div class="sidebar-brand-text mx-3">Admin</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Divider -->
			<hr class="sidebar-divider">


			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link" href="/edificio"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Edificios</span>
			</a></li>

			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link" href="/departamento"
				aria-expanded="true" aria-controls="collapseOne"
				data-toggle="collapse" data-target="#collapseOne"> <span>Departamentos</span>
			</a>
				<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/departamento">Departamento</a>
						<h6 class="collapse-header">Mantenciones:</h6>
						<a class="collapse-item" href="/mantencion">Mantenci??n</a> <a
							class="collapse-item" href="/item">Items</a>

					</div>
				</div></li>

			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link" href="/tour"
				aria-expanded="true" aria-controls="collapseTwo"> <span>Tours</span>
			</a></li>

			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				aria-expanded="true" aria-controls="collapseTwo"
				data-toggle="collapse" data-target="#collapseTwo"> <span>Transporte</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Transportes:</h6>
						<a class="collapse-item" href="/transporte">Transportes</a> <a
							class="collapse-item" href="/conductor">Conductores</a> <a
							class="collapse-item" href="/vehiculo">Veh??culos</a>
					</div>
				</div></li>
			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				aria-expanded="true" aria-controls="collapseFour"
				data-toggle="collapse" data-target="#collapseFour"> <span>Informes</span>
			</a>
				<div id="collapseFour" class="collapse"
					aria-labelledby="headingFour" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Ver informes :</h6>
						<a class="collapse-item" href="/informe">Departamentos</a> <a
							class="collapse-item" href="/informeDos">Zonas</a>

					</div>
				</div></li>
			<!-- Nav items -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				aria-expanded="true" aria-controls="collapseThree"
				data-toggle="collapse" data-target="#collapseThree"> <span>Cuentas</span>
			</a>
				<div id="collapseThree" class="collapse"
					aria-labelledby="headingThree" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Crear cuentas:</h6>
						<a class="collapse-item" href="/funcionario">Funcionarios</a> <a
							class="collapse-item" href="/administrador">Administradores</a>

					</div>
				</div></li>

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
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"> <sec:authentication
										property="principal.nombre" /> <sec:authentication
										property="principal.apellidoP" /> <sec:authentication
										property="principal.apellidoM" />
							</span> <img class="img-profile rounded-circle"
								src="img/undraw_profile.svg">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Perfil
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<c:if test="${ msg != null }">
						<div class="col-xl-5 col-md-6 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="h5 mb-0 font-weight-bold text-gray-800">
												<c:out value="${ msg }" />
												<c:remove var="msg" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">REPORTES DE
								GANANCIAS</h6>

						</div>
						<div class="row">

							<div class="col-xl-8 col-lg-7">



								<!-- Bar Chart -->
								<div class="card shadow mb-4">

									<div class="card-body">

										<canvas id="myChart"></canvas>
									</div>

								</div>
							</div>
							<!-- Donut Chart -->
							<div class="col-xl-4 col-lg-5">
								<div class="card shadow mb-4">
									<!-- Card Header - Dropdown -->

									<!-- Card Body -->
									<div class="card-body">

										<canvas id="myPieChart"></canvas>


									</div>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<div class="card canvas_div_pdf">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<div class="card-header py-3">
												<h6 class="m-0 font-weight-bold text-primary">REPORTES
													DE GANANCIAS</h6>

											</div>
											<th>ID provincia</th>
											<th>Nombre Provincia.</th>
											<th>Total ingresos</th>


										</thead>
										<tbody>
											<c:forEach items="${ informe }" var="in">
												<tr>

													<td>${ in.idPr }</td>
													<td>${ in.provincia}</td>
													<td>$ ${ in.ingreso }</td>


												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<hr>

							<div class="col justify-content-center">
								<button class="btn btn-primary"
									style="margin: auto; display: block" onclick="getPDF()">Imprimir
									Ganancias</button>
								<br>
							</div>

							<hr>
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
						<span>Arriendo departamentos 2021</span>
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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">??Listo para
						salir?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">??</span>
					</button>
				</div>
				<div class="modal-body">??Esta seguro que quiere cerrar sesi??n?</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancelar</button>
					<sec:authorize access="isAuthenticated()">
						<form action="/logout" method="post">
							<input type="hidden" name="${ _csrf.parameterName }"
								value="${ _csrf.token }">
							<button class="btn btn-primary">Cerrar Sesi??n</button>
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
	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>

	<script>
	
		var xValor = [];
		var yValor = [];
		<c:forEach items="${ informe }" var="in">
			xValor.push("${in.provincia} ");
			yValor.push(${in.ingreso});
		</c:forEach>
	
		
		
		var barColors = ["red", "green","blue","pink","orange","yellow","purple","gray"];
		new Chart("myChart", {
		  type: "bar",
		  data: {
		    labels: xValor,
		    datasets: [{
		      backgroundColor: barColors,
		      data: yValor
		    }]
		  },
		  options: {
		    legend: {display: false},
		    title: {
		      display: true,
		      text: "Ganancias por Zona"
		    }
		  }
});
</script>
	<script>
	
		var xValor = [];
		var yValor = [];
		<c:forEach items="${ informe }" var="in">
			xValor.push("${in.provincia} ");
			yValor.push(${in.ingreso});
		</c:forEach>
	
		
		var barColors = ["red", "green","blue","pink","orange","yellow","purple","gray"];
		new Chart("myPieChart", {
		  type: "pie",
		  data: {
		    labels: xValor,
		    datasets: [{
		      backgroundColor: barColors,
		      data: yValor
		    }]
		  },
		  options: {
		    legend: {display: false},
		    title: {
		      display: true,
		      text: "Ganancias por Zona"
		    }
		  }
});
</script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.3/jspdf.min.js"></script>
	<script src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>

	<script type="text/javascript">
    
    
    
    function getPDF(){

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
			
		    pdf.save("ReporteZona.pdf");
        });
	};
    </script>



</body>
</html>