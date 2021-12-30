<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<!-- Custom styles for this page -->
<link href="/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<title>Arriendos de Temporada</title>
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->

		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Page Wrapper -->
			<div id="content">
				<!-- Topbar -->
				<nav	class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Topbar Navbar -->
					
						<div class="topbar-divider d-none d-sm-block">	
						<ul class="navbar-nav ml-auto">						
							<sec:authorize access="!isAuthenticated()">
								<div>
									<button onclick="location.href='/login';">Login</button>
								</div>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<!-- Nav Item - User Information -->
								<li class="nav-item dropdown no-arrow"><a
									class="nav-link dropdown-toggle" href="#" id="userDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
										<div>
											<sec:authentication property="principal.nombre" />
											<sec:authentication property="principal.apellidoP" />
											<sec:authentication property="principal.apellidoM" />
											<form action="/logout" method="post">
												<input type="hidden" name="${ _csrf.parameterName }"
													value="${ _csrf.token }">
											</form>
										</div> <img class="img-profile rounded-circle"
										src="img/undraw_profile.svg">
								</a> <!-- Dropdown - User Information -->
									<div
										class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
										aria-labelledby="userDropdown">
										<a class="dropdown-item" href="#"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
											Perfil
										</a>
										<a class="dropdown-item" href='/resumen?idCliente=<sec:authentication property="principal.id" />'> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
											Reservas
										</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#" data-toggle="modal"
											data-target="#logoutModal"> <i
											class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
											Logout
										</a>
									</div></li>
							</sec:authorize>
							</ul>
						</div>					
				</nav>

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<div class="card shadow">
						<div class="card-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<c:forEach items="${ reservas }" var="r">
											<div class="card shadow">
												<div class="card-body">
													<div class="row">
														<div class="col-lg-3">
															<h6><c:out value="${ r.idDepartamento.idEdificio.nombre  } dpto # ${ r.idDepartamento.numero }" /></h6>
														</div>
														<div class="col-lg-2">
															Desde: <c:out value="${ r.fechaIngreso }" />
															Hasta: <c:out value="${ r.fechaSalida}" />
														</div>
														<div class="col-lg-4">
															<div class="row">	
																Prepago: $<c:out value="${ r.pagoReserva}" />
															</div>																
															<div class="row">
																Pago pendiente $<c:out value="${ r.totalPagar - r.pagoReserva }" />
															</div>
															<div class="row">
																Reserva Total $<c:out value="${ r.totalPagar}" />
															</div>																													
														</div>
														<div class="col-lg-2">
															<c:choose>
																<c:when test="${ r.idReservaestado.idReservaestado == 1 }">
																	<c:out value="${ r.idReservaestado.descripcion }" />
																	<form action="/cancelarReserva" id="formCancelar" method="post">
																		<input type="hidden" value="${ r.idReserva }" name="idReserva"  >
																		<input type="hidden" value="<sec:authentication property="principal.id" />" name="idCliente">
																		<input type="button" value="Cancelar reserva" onclick="validar()">
																	</form>
																</c:when>
																<c:otherwise>
																	<c:out value="${ r.idReservaestado.descripcion }" />
																</c:otherwise>
															</c:choose>
															
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
										<br>
									</div>
								</div>
							</div>
						</div>
					</div>					
				</div>
				<div class="text-center">
					<a class="medium" href="/">Volver a inicio</a>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
				<footer class="footer fixed-bottom container">
				<div class="fixed-bottom">
					<div class="copyright text-center my-auto">
					<hr>
						<p>Arriendos de Temporada 2021</p>
					</div>
				</div>
			</footer>
			<!-- end Footer-->
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
		<sec:authorize access="isAuthenticated()">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">¿Listo para
							salir?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">¿Está seguro que quiere cerrar
						sesión?</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancelar</button>
						<sec:authorize access="isAuthenticated()">
							<form action="/logout" method="post">
								<input type="hidden" name="${ _csrf.parameterName }"
									value="${ _csrf.token }">
								<button class="btn btn-primary">Cerrar Sesión</button>
							</form>
						</sec:authorize>
					</div>
				</div>
			</div>
		</sec:authorize>
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
	<!-- combo -->	
	
	<script type="text/javascript">
		function validar()
		{
			if(confirm("¿Esta seguro que desea cancelar la reserva?"))
			{
				document.getElementById("formCancelar").submit();		
			}
		}
	</script>

</body>

</html>